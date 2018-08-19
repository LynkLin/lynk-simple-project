package com.lynk.system.web.request;

import com.lynk.system.web.base.AbstractPageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author Lynk
 * @since 2018/04/03
 */
@ApiModel(description = "查找定时任务")
public class SysTaskGetRequest extends AbstractPageRequest implements Serializable {
    private static final long serialVersionUID = 7341894333200484716L;

    @ApiModelProperty("task code (simple name)")
    private String code;
    @ApiModelProperty("task name")
    private String name;
    @ApiModelProperty("task group")
    private String category;
    @ApiModelProperty("task class name")
    private String className;
    @ApiModelProperty("is task run")
    private Boolean run;
    @ApiModelProperty("is task paused")
    private Boolean pause;
    @ApiModelProperty("is task enable")
    private Boolean enable;

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

    public Boolean getRun() {
        return run;
    }

    public void setRun(Boolean run) {
        this.run = run;
    }

    public Boolean getPause() {
        return pause;
    }

    public void setPause(Boolean pause) {
        this.pause = pause;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
