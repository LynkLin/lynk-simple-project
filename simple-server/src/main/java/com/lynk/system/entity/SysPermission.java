package com.lynk.system.entity;

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
 * @since 2019-04-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("SYS_PERMISSION")
@ApiModel(value="SysPermission对象", description="")
public class SysPermission extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("NAME")
    private String name;

    @TableField("IS_REQUEST")
    private Boolean request;

    @TableField("URL")
    private String url;

    @TableField("METHOD")
    private String method;

    @TableField("SEQUENCE")
    private Integer sequence;

    @TableField("PARENT_ID")
    private String parentId;


    public static final String NAME = "NAME";

    public static final String IS_REQUEST = "IS_REQUEST";

    public static final String URL = "URL";

    public static final String METHOD = "METHOD";

    public static final String SEQUENCE = "SEQUENCE";

    public static final String PARENT_ID = "PARENT_ID";

}
