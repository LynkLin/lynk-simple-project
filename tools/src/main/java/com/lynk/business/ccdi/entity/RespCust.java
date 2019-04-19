package com.lynk.business.ccdi.entity;

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
@TableName("CCDI_RESP_CUST")
@ApiModel(value="RespCust对象", description="")
public class RespCust extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("REQ_MAIN_ID")
    private String reqMainId;

    @TableField("CUST_NO")
    private String custNo;

    @TableField("ZZLXDM")
    private String zzlxdm;

    @TableField("ZZHM")
    private String zzhm;

    @TableField("KHMC")
    private String khmc;

    @TableField("LXDH")
    private String lxdh;

    @TableField("LXSJ")
    private String lxsj;

    @TableField("DBRXM")
    private String dbrxm;

    @TableField("DBRZJLX")
    private String dbrzjlx;

    @TableField("DBRZJHM")
    private String dbrzjhm;

    @TableField("ZZDZ")
    private String zzdz;

    @TableField("ZZDH")
    private String zzdh;

    @TableField("GZDW")
    private String gzdw;

    @TableField("DWDZ")
    private String dwdz;

    @TableField("DWDH")
    private String dwdh;

    @TableField("YXDZ")
    private String yxdz;

    @TableField("ZDDZ")
    private String zddz;

    @TableField("FRDB")
    private String frdb;

    @TableField("FRDBZJLX")
    private String frdbzjlx;

    @TableField("FRDBZJHM")
    private String frdbzjhm;

    @TableField("KHGSZZHM")
    private String khgszzhm;

    @TableField("GSNSH")
    private String gsnsh;

    @TableField("DSNSH")
    private String dsnsh;


    public static final String REQ_MAIN_ID = "REQ_MAIN_ID";

    public static final String CUST_NO = "CUST_NO";

    public static final String ZZLXDM = "ZZLXDM";

    public static final String ZZHM = "ZZHM";

    public static final String KHMC = "KHMC";

    public static final String LXDH = "LXDH";

    public static final String LXSJ = "LXSJ";

    public static final String DBRXM = "DBRXM";

    public static final String DBRZJLX = "DBRZJLX";

    public static final String DBRZJHM = "DBRZJHM";

    public static final String ZZDZ = "ZZDZ";

    public static final String ZZDH = "ZZDH";

    public static final String GZDW = "GZDW";

    public static final String DWDZ = "DWDZ";

    public static final String DWDH = "DWDH";

    public static final String YXDZ = "YXDZ";

    public static final String ZDDZ = "ZDDZ";

    public static final String FRDB = "FRDB";

    public static final String FRDBZJLX = "FRDBZJLX";

    public static final String FRDBZJHM = "FRDBZJHM";

    public static final String KHGSZZHM = "KHGSZZHM";

    public static final String GSNSH = "GSNSH";

    public static final String DSNSH = "DSNSH";

}
