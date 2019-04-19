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
@TableName("CCDI_RESP_MEASURE")
@ApiModel(value="RespMeasure对象", description="")
public class RespMeasure extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("REQ_MAIN_ID")
    private String reqMainId;

    @TableField("ZH")
    private String zh;

    @TableField("CSXH")
    private String csxh;

    @TableField("DJKSRQ")
    private String djksrq;

    @TableField("DJJZRQ")
    private String djjzrq;

    @TableField("DJJGMC")
    private String djjgmc;

    @TableField("DJJE")
    private BigDecimal djje;

    @TableField("BEIZ")
    private String beiz;

    @TableField("DJCSLX")
    private String djcslx;


    public static final String REQ_MAIN_ID = "REQ_MAIN_ID";

    public static final String ZH = "ZH";

    public static final String CSXH = "CSXH";

    public static final String DJKSRQ = "DJKSRQ";

    public static final String DJJZRQ = "DJJZRQ";

    public static final String DJJGMC = "DJJGMC";

    public static final String DJJE = "DJJE";

    public static final String BEIZ = "BEIZ";

    public static final String DJCSLX = "DJCSLX";

}
