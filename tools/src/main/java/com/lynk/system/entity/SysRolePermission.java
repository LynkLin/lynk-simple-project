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
@TableName("SYS_ROLE_PERMISSION")
@ApiModel(value="SysRolePermission对象", description="")
public class SysRolePermission extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("ROLE_ID")
    private String roleId;

    @TableField("PERMISSION_ID")
    private String permissionId;


    public static final String ROLE_ID = "ROLE_ID";

    public static final String PERMISSION_ID = "PERMISSION_ID";

}
