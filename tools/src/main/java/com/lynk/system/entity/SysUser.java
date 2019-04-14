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
@TableName("SYS_USER")
@ApiModel(value="SysUser对象", description="")
public class SysUser extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("NAME")
    private String name;

    @TableField("PASSWORD")
    private String password;

    @TableField("SALT")
    private String salt;

    @TableField("REAL_NAME")
    private String realName;

    @TableField("IS_DELETED")
    private Boolean deleted;


    public static final String NAME = "NAME";

    public static final String PASSWORD = "PASSWORD";

    public static final String SALT = "SALT";

    public static final String REAL_NAME = "REAL_NAME";

    public static final String IS_DELETED = "IS_DELETED";

}
