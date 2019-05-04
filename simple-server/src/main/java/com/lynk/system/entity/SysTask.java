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
@TableName("SYS_TASK")
@ApiModel(value="SysTask对象", description="")
public class SysTask extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("CODE")
    private String code;

    @TableField("NAME")
    private String name;

    @TableField("CATEGORY")
    private String category;

    @TableField("CLASS_NAME")
    private String className;

    @TableField("CRON_EXPRESSION")
    private String cronExpression;

    @TableField("SEQUENCE")
    private Integer sequence;

    @Deprecated
    @TableField("IS_RUN")
    private Boolean run;

    @Deprecated
    @TableField("IS_PAUSE")
    private Boolean pause;

    @TableField("IS_ENABLE")
    private Boolean enable;

    @TableField("REMARK")
    private String remark;


    public static final String CODE = "CODE";

    public static final String NAME = "NAME";

    public static final String CATEGORY = "CATEGORY";

    public static final String CLASS_NAME = "CLASS_NAME";

    public static final String CRON_EXPRESSION = "CRON_EXPRESSION";

    public static final String SEQUENCE = "SEQUENCE";

    public static final String IS_RUN = "IS_RUN";

    public static final String IS_PAUSE = "IS_PAUSE";

    public static final String IS_ENABLE = "IS_ENABLE";

    public static final String REMARK = "REMARK";

}
