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
@TableName("CCDI_RESP_MESSAGE")
@ApiModel(value="RespMessage对象", description="")
public class RespMessage extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("REQ_MAIN_ID")
    private String reqMainId;

    @TableField("MOBILE_NO")
    private String mobileNo;

    @TableField("MSG_TYPE")
    private String msgType;

    @TableField("MESSAGE")
    private String message;


    public static final String REQ_MAIN_ID = "REQ_MAIN_ID";

    public static final String MOBILE_NO = "MOBILE_NO";

    public static final String MSG_TYPE = "MSG_TYPE";

    public static final String MESSAGE = "MESSAGE";

}
