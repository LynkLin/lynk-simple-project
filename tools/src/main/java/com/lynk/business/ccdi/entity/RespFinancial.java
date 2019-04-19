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
@TableName("CCDI_RESP_FINANCIAL")
@ApiModel(value="RespFinancial对象", description="")
public class RespFinancial extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("REQ_MAIN_ID")
    private String reqMainId;

    @TableField("KH")
    private String kh;

    @TableField("ZH")
    private String zh;

    @TableField("JRZCXH")
    private String jrzcxh;

    @TableField("JRZCMC")
    private String jrzcmc;

    @TableField("JRZCLX")
    private String jrzclx;

    @TableField("CPXSZL")
    private String cpxszl;

    @TableField("JRCPBH")
    private String jrcpbh;

    @TableField("ZCGLR")
    private String zcglr;

    @TableField("ZCKFTGYHJY")
    private String zckftgyhjy;

    @TableField("ZCJYXZLX")
    private String zcjyxzlx;

    @TableField("ZCJYXZXCSJ")
    private String zcjyxzxcsj;

    @TableField("CPZT")
    private String cpzt;

    @TableField("ZYQR")
    private String zyqr;

    @TableField("TGR")
    private String tgr;

    @TableField("SYR")
    private String syr;

    @TableField("CLR")
    private String clr;

    @TableField("SHR")
    private String shr;

    @TableField("TGZH")
    private String tgzh;

    @TableField("JLDW")
    private String jldw;

    @TableField("BZ")
    private String bz;

    @TableField("ZCDWJG")
    private BigDecimal zcdwjg;

    @TableField("SE")
    private BigDecimal se;

    @TableField("KYSE")
    private BigDecimal kyse;

    @TableField("ZCZSE")
    private BigDecimal zczse;

    @TableField("KKZCZSE")
    private BigDecimal kkzczse;

    @TableField("BEIZ")
    private String beiz;


    public static final String REQ_MAIN_ID = "REQ_MAIN_ID";

    public static final String KH = "KH";

    public static final String ZH = "ZH";

    public static final String JRZCXH = "JRZCXH";

    public static final String JRZCMC = "JRZCMC";

    public static final String JRZCLX = "JRZCLX";

    public static final String CPXSZL = "CPXSZL";

    public static final String JRCPBH = "JRCPBH";

    public static final String ZCGLR = "ZCGLR";

    public static final String ZCKFTGYHJY = "ZCKFTGYHJY";

    public static final String ZCJYXZLX = "ZCJYXZLX";

    public static final String ZCJYXZXCSJ = "ZCJYXZXCSJ";

    public static final String CPZT = "CPZT";

    public static final String ZYQR = "ZYQR";

    public static final String TGR = "TGR";

    public static final String SYR = "SYR";

    public static final String CLR = "CLR";

    public static final String SHR = "SHR";

    public static final String TGZH = "TGZH";

    public static final String JLDW = "JLDW";

    public static final String BZ = "BZ";

    public static final String ZCDWJG = "ZCDWJG";

    public static final String SE = "SE";

    public static final String KYSE = "KYSE";

    public static final String ZCZSE = "ZCZSE";

    public static final String KKZCZSE = "KKZCZSE";

    public static final String BEIZ = "BEIZ";

}
