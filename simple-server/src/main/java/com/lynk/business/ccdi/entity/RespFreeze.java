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
@TableName("CCDI_RESP_FREEZE")
@ApiModel(value="RespFreeze对象", description="")
public class RespFreeze extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("REQ_MAIN_ID")
    private String reqMainId;

    @TableField("ZH")
    private String zh;

    @TableField("KH")
    private String kh;

    @TableField("ZXJG")
    private String zxjg;

    @TableField("SQDJXE")
    private BigDecimal sqdjxe;

    @TableField("SDJE")
    private BigDecimal sdje;

    @TableField("YE")
    private BigDecimal ye;

    @TableField("ZXQSSJ")
    private String zxqssj;

    @TableField("DJJSRQ")
    private String djjsrq;

    @TableField("WNDJYY")
    private String wndjyy;

    @TableField("DJJG")
    private String djjg;

    @TableField("DJJE")
    private BigDecimal djje;

    @TableField("DJJZRQ")
    private String djjzrq;

    @TableField("WDJJE")
    private BigDecimal wdjje;

    @TableField("ZHKYYE")
    private BigDecimal zhkyye;

    @TableField("BEIZ")
    private String beiz;


    public static final String REQ_MAIN_ID = "REQ_MAIN_ID";

    public static final String ZH = "ZH";

    public static final String KH = "KH";

    public static final String ZXJG = "ZXJG";

    public static final String SQDJXE = "SQDJXE";

    public static final String SDJE = "SDJE";

    public static final String YE = "YE";

    public static final String ZXQSSJ = "ZXQSSJ";

    public static final String DJJSRQ = "DJJSRQ";

    public static final String WNDJYY = "WNDJYY";

    public static final String DJJG = "DJJG";

    public static final String DJJE = "DJJE";

    public static final String DJJZRQ = "DJJZRQ";

    public static final String WDJJE = "WDJJE";

    public static final String ZHKYYE = "ZHKYYE";

    public static final String BEIZ = "BEIZ";

}
