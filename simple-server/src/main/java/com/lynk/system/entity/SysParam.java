package com.lynk.system.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.lynk.system.entity.base.SystemBaseEntity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lynk
 * @since 2017-11-16
 */
@TableName("SYS_PARAM")
public class SysParam extends SystemBaseEntity<SysParam> {

    private static final long serialVersionUID = 1L;

	private String category;
	private String code;
	private String value;
	private String remark;


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public static final String CATEGORY = "category";

	public static final String CODE = "code";

	public static final String VALUE = "value";

	public static final String REMARK = "remark";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SysParam{" +
			", category=" + category +
			", code=" + code +
			", value=" + value +
			", remark=" + remark +
			"}";
	}
}
