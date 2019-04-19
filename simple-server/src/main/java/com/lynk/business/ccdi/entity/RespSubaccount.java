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
@TableName("CCDI_RESP_SUBACCOUNT")
@ApiModel(value="RespSubaccount对象", description="")
public class RespSubaccount extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("REQ_MAIN_ID")
    private String reqMainId;

    @TableField("ZH")
    private String zh;

    @TableField("ZZHXH")
    private String zzhxh;

    @TableField("ZZHLB")
    private String zzhlb;

    @TableField("ZZHZH")
    private String zzhzh;

    @TableField("BZ")
    private String bz;

    @TableField("CHBZ")
    private String chbz;

    @TableField("ZHYE")
    private BigDecimal zhye;

    @TableField("ZHZT")
    private String zhzt;

    @TableField("KYYE")
    private BigDecimal kyye;


    public static final String REQ_MAIN_ID = "REQ_MAIN_ID";

    public static final String ZH = "ZH";

    public static final String ZZHXH = "ZZHXH";

    public static final String ZZHLB = "ZZHLB";

    public static final String ZZHZH = "ZZHZH";

    public static final String BZ = "BZ";

    public static final String CHBZ = "CHBZ";

    public static final String ZHYE = "ZHYE";

    public static final String ZHZT = "ZHZT";

    public static final String KYYE = "KYYE";

}
