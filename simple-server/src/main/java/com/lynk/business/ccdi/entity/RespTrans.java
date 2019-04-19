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
@TableName("CCDI_RESP_TRANS")
@ApiModel(value="RespTrans对象", description="")
public class RespTrans extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("REQ_MAIN_ID")
    private String reqMainId;

    @TableField("CXKH")
    private String cxkh;

    @TableField("JYLX")
    private String jylx;

    @TableField("JDBZ")
    private String jdbz;

    @TableField("BZ")
    private String bz;

    @TableField("JE")
    private BigDecimal je;

    @TableField("YE")
    private BigDecimal ye;

    @TableField("JYSJ")
    private String jysj;

    @TableField("JYLSH")
    private String jylsh;

    @TableField("JYDFXM")
    private String jydfxm;

    @TableField("JYDFZH")
    private String jydfzh;

    @TableField("JYDFKH")
    private String jydfkh;

    @TableField("JYDFZJHM")
    private String jydfzjhm;

    @TableField("JYDSYE")
    private BigDecimal jydsye;

    @TableField("JYDFZHKHH")
    private String jydfzhkhh;

    @TableField("JYZY")
    private String jyzy;

    @TableField("JYWDMC")
    private String jywdmc;

    @TableField("JYWDDM")
    private String jywddm;

    @TableField("RZH")
    private String rzh;

    @TableField("CPH")
    private String cph;

    @TableField("PZZL")
    private String pzzl;

    @TableField("PZH")
    private String pzh;

    @TableField("XJBZ")
    private String xjbz;

    @TableField("ZDH")
    private String zdh;

    @TableField("JYSFCG")
    private String jysfcg;

    @TableField("JYFSD")
    private String jyfsd;

    @TableField("SHMC")
    private String shmc;

    @TableField("SHH")
    private String shh;

    @TableField("IP")
    private String ip;

    @TableField("MAC")
    private String mac;

    @TableField("JYGYH")
    private String jygyh;

    @TableField("BEIZ")
    private String beiz;

    @TableField("BFZH")
    private String bfzh;

    @TableField("BFKH")
    private String bfkh;


    public static final String REQ_MAIN_ID = "REQ_MAIN_ID";

    public static final String CXKH = "CXKH";

    public static final String JYLX = "JYLX";

    public static final String JDBZ = "JDBZ";

    public static final String BZ = "BZ";

    public static final String JE = "JE";

    public static final String YE = "YE";

    public static final String JYSJ = "JYSJ";

    public static final String JYLSH = "JYLSH";

    public static final String JYDFXM = "JYDFXM";

    public static final String JYDFZH = "JYDFZH";

    public static final String JYDFKH = "JYDFKH";

    public static final String JYDFZJHM = "JYDFZJHM";

    public static final String JYDSYE = "JYDSYE";

    public static final String JYDFZHKHH = "JYDFZHKHH";

    public static final String JYZY = "JYZY";

    public static final String JYWDMC = "JYWDMC";

    public static final String JYWDDM = "JYWDDM";

    public static final String RZH = "RZH";

    public static final String CPH = "CPH";

    public static final String PZZL = "PZZL";

    public static final String PZH = "PZH";

    public static final String XJBZ = "XJBZ";

    public static final String ZDH = "ZDH";

    public static final String JYSFCG = "JYSFCG";

    public static final String JYFSD = "JYFSD";

    public static final String SHMC = "SHMC";

    public static final String SHH = "SHH";

    public static final String IP = "IP";

    public static final String MAC = "MAC";

    public static final String JYGYH = "JYGYH";

    public static final String BEIZ = "BEIZ";

    public static final String BFZH = "BFZH";

    public static final String BFKH = "BFKH";

}
