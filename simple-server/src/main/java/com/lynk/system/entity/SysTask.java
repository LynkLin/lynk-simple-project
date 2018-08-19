package com.lynk.system.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.lynk.system.entity.base.SystemBaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lynk
 * @since 2017-11-16
 */
@TableName("SYS_TASK")
public class SysTask extends SystemBaseEntity<SysTask> {

    private static final long serialVersionUID = 1L;
	@ApiModelProperty("任务编号")
	private String code;
	@ApiModelProperty("任务名称")
	private String name;
	@ApiModelProperty("任务分组")
	private String category;
	@ApiModelProperty("任务类")
	@TableField("CLASS_NAME")
	private String className;
	@ApiModelProperty("任务时间表达式")
	@TableField("CRON_EXPRESSION")
	private String cronExpression;
	@ApiModelProperty("序号")
	private Integer sequence;
	@ApiModelProperty("是否运行中")
	@TableField("IS_RUN")
	private Boolean run;
	@ApiModelProperty("是否暂停中")
	@TableField("IS_PAUSE")
	private Boolean pause;
	@ApiModelProperty("是否可用")
	@TableField("IS_ENABLE")
	private Boolean enable;
	@ApiModelProperty("备注")
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public static final String CODE = "code";

	public static final String NAME = "name";

	public static final String CATEGORY = "category";

	public static final String CLASS_NAME = "class_name";

	public static final String CRON_EXPRESSION = "cron_expression";

	public static final String SEQUENCE = "sequence";

	public static final String IS_RUN = "is_run";

	public static final String IS_PAUSE = "is_pause";

	public static final String IS_ENABLE = "is_enable";

	public static final String REMARK = "remark";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SysTask{" +
			", code=" + code +
			", name=" + name +
			", category=" + category +
			", className=" + className +
			", cronExpression=" + cronExpression +
			", sequence=" + sequence +
			", run=" + run +
			", pause=" + pause +
			", enable=" + enable +
			", remark=" + remark +
			"}";
	}
}
