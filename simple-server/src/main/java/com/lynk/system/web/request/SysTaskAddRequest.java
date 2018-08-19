package com.lynk.system.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author Lynk
 * @since 2018/04/03
 */
@ApiModel(description = "task bean for add")
public class SysTaskAddRequest implements Serializable {
    private static final long serialVersionUID = 7341894333200484716L;

    @ApiModelProperty(value = "task code (simple name)", required = true)
    private String code;
    @ApiModelProperty(value = "task name", required = true)
    private String name;
    @ApiModelProperty(value = "task group", required = true)
    private String category;
    @ApiModelProperty(value = "task class name", required = true)
    private String className;
    @ApiModelProperty(value = "task cron expression", required = true)
    private String cronExpression;
    @ApiModelProperty(value = "order by this field")
    private Integer sequence;
    @ApiModelProperty("remark")
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
