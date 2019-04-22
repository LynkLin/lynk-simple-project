package com.lynk.system.security.common;

import com.lynk.system.common.DateUtil;
import com.lynk.system.exception.SystemException;
import com.lynk.system.exception.error.ErrorCode;
import io.jsonwebtoken.*;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author Lynk
 * @since 2017/10/18
 */
public class JwtBuilder {

    private JwtBuilder() {
    }

    public static JwtBuilder builder() {
        return new JwtBuilder();
    }

    public String createToken(String cacheId) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiration = now.plusHours(SecurityConstant.JWT_LIVE_HOUR);

        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject(cacheId)
                .setIssuedAt(DateUtil.localDateTimeToDate(now))
                .compressWith(CompressionCodecs.GZIP)
                .signWith(signatureAlgorithm, generateKey())
                .setExpiration(DateUtil.localDateTimeToDate(expiration))
                .compact();
    }

    /**
     * 刷新JWT TOKEN
     * @param cacheId
     * @param token
     * @return
     * @throws SystemException
     */
    public String refreshToken(String cacheId, String token) throws SystemException {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        Claims claims = parseToken(token);

        Date issuedAt = claims.getIssuedAt();
        if (issuedAt == null) {
            throw new SystemException(ErrorCode.SYS000);
        }
        LocalDateTime issueAt = DateUtil.dateToLocalDateTime(issuedAt);

        LocalDateTime expiration = DateUtil.dateToLocalDateTime(claims.getExpiration());

        expiration = expiration.plusHours(SecurityConstant.JWT_LIVE_HOUR);

        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject(cacheId)
                .setIssuedAt(DateUtil.localDateTimeToDate(issueAt))
                .compressWith(CompressionCodecs.GZIP)
                .signWith(signatureAlgorithm, generateKey())
                .setExpiration(DateUtil.localDateTimeToDate(expiration))
                .compact();
    }

    public String getCacheId(String token) throws SystemException {
        Claims claims = parseToken(token);
        return claims.getSubject();
    }

    /**
     * 校验TOKEN
     * @param token
     * @return
     * @throws SystemException
     */
    public boolean validateToken(String token) {
        Claims claims;
        try {
            claims = parseToken(token);
        } catch (SystemException e) {
            return false;
        }

        LocalDateTime now = LocalDateTime.now();

        Date issuedAt = claims.getIssuedAt();
        if (issuedAt == null) {
            return false;
        }
        LocalDateTime issueAt = DateUtil.dateToLocalDateTime(issuedAt);

        Date claimsExpiration = claims.getExpiration();
        if (claimsExpiration == null) {
            return false;
        }
        LocalDateTime expiration = DateUtil.dateToLocalDateTime(claimsExpiration);

        return issueAt.isBefore(now) && expiration.isAfter(now);
    }

    private Claims parseToken(String token) throws SystemException {
        try {
            return Jwts.parser().setSigningKey(generateKey()).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            throw new SystemException(ErrorCode.SYS000);
        }
    }

    private Key generateKey() {
        byte[] encodeKey = Base64.getEncoder().encode(SecurityConstant.JWT_SECURITY.getBytes());
        return new SecretKeySpec(encodeKey, "AES");
    }
}
