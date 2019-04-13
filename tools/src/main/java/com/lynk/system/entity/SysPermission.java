package com.lynk.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.lynk.system.entity.base.SystemBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
 * @since 2019-04-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("SYS_PERMISSION")
@ApiModel(value="SysPermission对象", description="")
public class SysPermission extends SystemBaseEntity<SysPermission> {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    @TableField("NAME")
    private String name;

    @TableField("IS_REQUEST")
    private Integer isRequest;

    @TableField("URL")
    private String url;

    @TableField("METHOD")
    private String method;

    @TableField("SEQUENCE")
    private Integer sequence;

    @TableField("PARENT_ID")
    private String parentId;

    @TableField(value = "GMT_CREATE", fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
