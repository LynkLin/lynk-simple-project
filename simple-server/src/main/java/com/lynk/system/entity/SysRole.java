package com.lynk.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lynk.system.entity.base.SystemBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
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
@TableName("SYS_ROLE")
@ApiModel(value="SysRole对象", description="")
public class SysRole extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("NAME")
    private String name;

    @TableField("IS_ADMIN")
    private Boolean admin;


    public static final String NAME = "NAME";

    public static final String IS_ADMIN = "IS_ADMIN";

}
