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
@TableName("CCDI_RESP_PROIORITY")
@ApiModel(value="RespProiority对象", description="")
public class RespProiority extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("REQ_MAIN_ID")
    private String reqMainId;

    @TableField("ZH")
    private String zh;

    @TableField("XH")
    private String xh;

    @TableField("QLLX")
    private String qllx;

    @TableField("ZZLXDM")
    private String zzlxdm;

    @TableField("ZZHM")
    private String zzhm;

    @TableField("QLRXM")
    private String qlrxm;

    @TableField("QLJE")
    private BigDecimal qlje;

    @TableField("QLRDZ")
    private String qlrdz;

    @TableField("QLRLXFS")
    private String qlrlxfs;


    public static final String REQ_MAIN_ID = "REQ_MAIN_ID";

    public static final String ZH = "ZH";

    public static final String XH = "XH";

    public static final String QLLX = "QLLX";

    public static final String ZZLXDM = "ZZLXDM";

    public static final String ZZHM = "ZZHM";

    public static final String QLRXM = "QLRXM";

    public static final String QLJE = "QLJE";

    public static final String QLRDZ = "QLRDZ";

    public static final String QLRLXFS = "QLRLXFS";

}
