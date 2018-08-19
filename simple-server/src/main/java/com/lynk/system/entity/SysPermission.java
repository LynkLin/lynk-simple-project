package com.lynk.system.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.lynk.system.entity.base.SystemBaseEntity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lynk
 * @since 2017-12-28
 */
@TableName("SYS_PERMISSION")
public class SysPermission extends SystemBaseEntity<SysPermission> {

    private static final long serialVersionUID = 1L;

	private String name;
	@TableField("IS_REQUEST")
	private Boolean request;
	private String url;
	private String method;
	private Integer sequence;
	@TableField("PARENT_ID")
	private String parentId;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getRequest() {
		return request;
	}

	public void setRequest(Boolean request) {
		this.request = request;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public static final String NAME = "name";

	public static final String IS_REQUEST = "is_request";

	public static final String URL = "url";

	public static final String METHOD = "method";

	public static final String SEQUENCE = "sequence";

	public static final String PARENT_ID = "parent_id";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SysPermission{" +
			", name=" + name +
			", request=" + request +
			", url=" + url +
			", method=" + method +
			", sequence=" + sequence +
			", parentId=" + parentId +
			"}";
	}
}
