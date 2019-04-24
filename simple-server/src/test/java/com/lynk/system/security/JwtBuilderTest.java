package com.lynk.system.security;

import com.lynk.base.BaseJunitTest;
import com.lynk.system.exception.SystemException;
import com.lynk.system.security.common.JwtBuilder;
import com.lynk.system.tool.SequenceManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Lynk
 * @since 2017/10/19
 */
public class JwtBuilderTest extends BaseJunitTest {

    @Test
    @DisplayName("Token解析后字段对比")
    public void createToken() {
        String cacheId = SequenceManager.getInstance().nextSequenceId();
        String token = JwtBuilder.builder().createToken(cacheId);
        String jwtCacheId = null;
        try {
            jwtCacheId = JwtBuilder.builder().getCacheId(token);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        Assertions.assertThat(jwtCacheId).as("Token解析出的字段应和生成Token时的一致").isEqualTo(cacheId);
    }
}