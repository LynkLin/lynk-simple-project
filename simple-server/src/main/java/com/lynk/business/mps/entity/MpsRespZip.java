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
@TableName("MPS_RESP_ZIP")
public class MpsRespZip extends SystemBaseEntity<MpsRespZip> {

    private static final long serialVersionUID = 1L;

	@TableField("REQ_ID")
	private String reqId;
	@TableField("POLICE_ORG_ID")
	private String policeOrgId;
	@TableField("BANK_ID")
	private String bankId;
	@TableField("QQDBS")
	private String qqdbs;
	@TableField("SEQ_NO")
	private String seqNo;
	@TableField("REQUEST_TYPE")
	private String requestType;
	@TableField("FILE")
	private String file;
	@TableField("STATUS")
	private String status;


	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public String getPoliceOrgId() {
		return policeOrgId;
	}

	public void setPoliceOrgId(String policeOrgId) {
		this.policeOrgId = policeOrgId;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getQqdbs() {
		return qqdbs;
	}

	public void setQqdbs(String qqdbs) {
		this.qqdbs = qqdbs;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static final String REQ_ID = "REQ_ID";

	public static final String POLICE_ORG_ID = "POLICE_ORG_ID";

	public static final String BANK_ID = "BANK_ID";

	public static final String QQDBS = "QQDBS";

	public static final String SEQ_NO = "SEQ_NO";

	public static final String REQUEST_TYPE = "REQUEST_TYPE";

	public static final String FILE = "FILE";

	public static final String STATUS = "STATUS";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MpsRespZip{" +
			", reqId=" + reqId +
			", policeOrgId=" + policeOrgId +
			", bankId=" + bankId +
			", qqdbs=" + qqdbs +
			", seqNo=" + seqNo +
			", requestType=" + requestType +
			", file=" + file +
			", status=" + status +
			"}";
	}
}
