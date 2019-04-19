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
@TableName("CCDI_RESP_DYNAMIC")
@ApiModel(value="RespDynamic对象", description="")
public class RespDynamic extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("REQ_MAIN_ID")
    private String reqMainId;

    @TableField("ZH")
    private String zh;

    @TableField("KH")
    private String kh;

    @TableField("ZHMC")
    private String zhmc;

    @TableField("ZHBZ")
    private String zhbz;

    @TableField("ZHDYKH")
    private String zhdykh;

    @TableField("JYCZ")
    private String jycz;

    @TableField("CZSJ")
    private String czsj;

    @TableField("JYDD")
    private String jydd;

    @TableField("JYJE")
    private BigDecimal jyje;

    @TableField("JYBZ")
    private String jybz;

    @TableField("ZHXYED")
    private BigDecimal zhxyed;

    @TableField("KHZJLX")
    private String khzjlx;

    @TableField("KHZJHM")
    private String khzjhm;

    @TableField("DFZH")
    private String dfzh;

    @TableField("DFZHMC")
    private String dfzhmc;

    @TableField("DFZHBZ")
    private String dfzhbz;

    @TableField("DFZHDYKH")
    private String dfzhdykh;

    @TableField("PZZL")
    private String pzzl;

    @TableField("PZH")
    private String pzh;

    @TableField("XJBZ")
    private String xjbz;

    @TableField("FWJM")
    private String fwjm;

    @TableField("ZDH")
    private String zdh;

    @TableField("KYXQ")
    private String kyxq;

    @TableField("JYLXYHK")
    private String jylxyhk;

    @TableField("JYLXGJK")
    private String jylxgjk;

    @TableField("SHH")
    private String shh;

    @TableField("SHMC")
    private String shmc;

    @TableField("WDMS")
    private String wdms;

    @TableField("WDDZ")
    private String wddz;

    @TableField("WDDH")
    private String wddh;

    @TableField("GYH")
    private String gyh;

    @TableField("SQGYH")
    private String sqgyh;

    @TableField("JYDM")
    private String jydm;

    @TableField("FJYBZ")
    private String fjybz;

    @TableField("CZJYBS")
    private String czjybs;


    public static final String REQ_MAIN_ID = "REQ_MAIN_ID";

    public static final String ZH = "ZH";

    public static final String KH = "KH";

    public static final String ZHMC = "ZHMC";

    public static final String ZHBZ = "ZHBZ";

    public static final String ZHDYKH = "ZHDYKH";

    public static final String JYCZ = "JYCZ";

    public static final String CZSJ = "CZSJ";

    public static final String JYDD = "JYDD";

    public static final String JYJE = "JYJE";

    public static final String JYBZ = "JYBZ";

    public static final String ZHXYED = "ZHXYED";

    public static final String KHZJLX = "KHZJLX";

    public static final String KHZJHM = "KHZJHM";

    public static final String DFZH = "DFZH";

    public static final String DFZHMC = "DFZHMC";

    public static final String DFZHBZ = "DFZHBZ";

    public static final String DFZHDYKH = "DFZHDYKH";

    public static final String PZZL = "PZZL";

    public static final String PZH = "PZH";

    public static final String XJBZ = "XJBZ";

    public static final String FWJM = "FWJM";

    public static final String ZDH = "ZDH";

    public static final String KYXQ = "KYXQ";

    public static final String JYLXYHK = "JYLXYHK";

    public static final String JYLXGJK = "JYLXGJK";

    public static final String SHH = "SHH";

    public static final String SHMC = "SHMC";

    public static final String WDMS = "WDMS";

    public static final String WDDZ = "WDDZ";

    public static final String WDDH = "WDDH";

    public static final String GYH = "GYH";

    public static final String SQGYH = "SQGYH";

    public static final String JYDM = "JYDM";

    public static final String FJYBZ = "FJYBZ";

    public static final String CZJYBS = "CZJYBS";

}
