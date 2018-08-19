package com.lynk.business.mps.entity;

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
 * @since 2018-08-19
 */
@TableName("MPS_ATTACHMENT")
public class MpsAttachment extends SystemBaseEntity<MpsAttachment> {

    private static final long serialVersionUID = 1L;

	@TableField("REQ_ID")
	private String reqId;
	@TableField("ATTACHMENT_TYPE")
	private String attachmentType;
	@TableField("FILE")
	private String file;


	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public String getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public static final String REQ_ID = "REQ_ID";

	public static final String ATTACHMENT_TYPE = "ATTACHMENT_TYPE";

	public static final String FILE = "FILE";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MpsAttachment{" +
			", reqId=" + reqId +
			", attachmentType=" + attachmentType +
			", file=" + file +
			"}";
	}
}
