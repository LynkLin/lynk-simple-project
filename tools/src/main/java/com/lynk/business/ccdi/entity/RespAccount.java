package com.lynk.business.ccdi.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lynk.system.entity.base.SystemBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lynk
 * @since 2019-04-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("CCDI_RESP_ACCOUNT")
@ApiModel(value="RespAccount对象", description="")
public class RespAccount extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("REQ_MAIN_ID")
    private String reqMainId;

    @TableField("CUST_NO")
    private String custNo;

    @TableField("CXKH")
    private String cxkh;

    @TableField("KH")
    private String kh;

    @TableField("ZH")
    private String zh;

    @TableField("WYZHMC")
    private String wyzhmc;

    @TableField("ZHDLIP")
    private String zhdlip;

    @TableField("ZHDLSJ")
    private String zhdlsj;

    @TableField("ZHLB")
    private String zhlb;

    @TableField("ZHZT")
    private String zhzt;

    @TableField("KHWD")
    private String khwd;

    @TableField("KHWDDM")
    private String khwddm;

    @TableField("KHRQ")
    private String khrq;

    @TableField("XHRQ")
    private String xhrq;

    @TableField("XHWD")
    private String xhwd;

    @TableField("BZ")
    private String bz;

    @TableField("CHBZ")
    private String chbz;

    @TableField("ZHYE")
    private BigDecimal zhye;

    @TableField("KYYE")
    private BigDecimal kyye;

    @TableField("ZHJYSJ")
    private String zhjysj;

    @TableField("BEIZ")
    private String beiz;


    public static final String REQ_MAIN_ID = "REQ_MAIN_ID";

    public static final String CUST_NO = "CUST_NO";

    public static final String CXKH = "CXKH";

    public static final String KH = "KH";

    public static final String ZH = "ZH";

    public static final String WYZHMC = "WYZHMC";

    public static final String ZHDLIP = "ZHDLIP";

    public static final String ZHDLSJ = "ZHDLSJ";

    public static final String ZHLB = "ZHLB";

    public static final String ZHZT = "ZHZT";

    public static final String KHWD = "KHWD";

    public static final String KHWDDM = "KHWDDM";

    public static final String KHRQ = "KHRQ";

    public static final String XHRQ = "XHRQ";

    public static final String XHWD = "XHWD";

    public static final String BZ = "BZ";

    public static final String CHBZ = "CHBZ";

    public static final String ZHYE = "ZHYE";

    public static final String KYYE = "KYYE";

    public static final String ZHJYSJ = "ZHJYSJ";

    public static final String BEIZ = "BEIZ";

}
