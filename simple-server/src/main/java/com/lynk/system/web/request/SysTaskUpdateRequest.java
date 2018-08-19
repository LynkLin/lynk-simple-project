package com.lynk.system.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author Lynk
 * @since 2018/04/03
 */
@ApiModel(description = "task bean for update")
public class SysTaskUpdateRequest implements Serializable {
    private static final long serialVersionUID = 7341894333200484716L;

    public static final int OPERATOR_UPDATE_CRON_EXPRESSION = 0;
    public static final int OPERATOR_DISABLE_TASK = 1;
    public static final int OPERATOR_ENABLE_TASK = 2;
    public static final int OPERATOR_PAUSE_TASK = 3;
    public static final int OPERATOR_RESUME_TASK = 4;
    public static final int OPERATOR_RUN_TASK = 5;

    @ApiModelProperty("ID")
    private String id;
    @ApiModelProperty("0 - update cron expression, 1 - disable task, 2 - enable task, 3 - pause task, 4 - resume task, 5 - run task")
    private Integer operator;
    @ApiModelProperty("task cron expression")
    private String cronExpression;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
}
