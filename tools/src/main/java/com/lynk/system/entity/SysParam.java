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
@TableName("SYS_PARAM")
@ApiModel(value="SysParam对象", description="")
public class SysParam extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("CATEGORY")
    private String category;

    @TableField("CODE")
    private String code;

    @TableField("VALUE")
    private String value;

    @TableField("REMARK")
    private String remark;


    public static final String CATEGORY = "CATEGORY";

    public static final String CODE = "CODE";

    public static final String VALUE = "VALUE";

    public static final String REMARK = "REMARK";

}
