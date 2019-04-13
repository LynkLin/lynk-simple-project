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
@TableName("SYS_USER")
@ApiModel(value="SysUser对象", description="")
public class SysUser extends SystemBaseEntity<SysUser> {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    @TableField("NAME")
    private String name;

    @TableField("PASSWORD")
    private String password;

    @TableField("SALT")
    private String salt;

    @TableField("REAL_NAME")
    private String realName;

    @TableField("IS_DELETED")
    private Integer isDeleted;

    @TableField(value = "GMT_CREATE", fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
