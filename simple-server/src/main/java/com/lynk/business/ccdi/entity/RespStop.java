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
@TableName("CCDI_RESP_STOP")
@ApiModel(value="RespStop对象", description="")
public class RespStop extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("REQ_MAIN_ID")
    private String reqMainId;

    @TableField("ZH")
    private String zh;

    @TableField("KH")
    private String kh;

    @TableField("ZXJG")
    private String zxjg;

    @TableField("SBYY")
    private String sbyy;

    @TableField("ZXQSSJ")
    private String zxqssj;


    public static final String REQ_MAIN_ID = "REQ_MAIN_ID";

    public static final String ZH = "ZH";

    public static final String KH = "KH";

    public static final String ZXJG = "ZXJG";

    public static final String SBYY = "SBYY";

    public static final String ZXQSSJ = "ZXQSSJ";

}
