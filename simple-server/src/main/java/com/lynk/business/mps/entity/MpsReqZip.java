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
@TableName("MPS_REQ_ZIP")
public class MpsReqZip extends SystemBaseEntity<MpsReqZip> {

    private static final long serialVersionUID = 1L;

	@TableField("POLICE_ORG_ID")
	private String policeOrgId;
	@TableField("BANK_ID")
	private String bankId;
	@TableField("QQDBS")
	private String qqdbs;
	@TableField("FILE")
	private String file;
	@TableField("NESTED_STATUS")
	private String nestedStatus;
	@TableField("PARENT_ZIP_ID")
	private String parentZipId;
	@TableField("STATUS")
	private String status;
	@TableField("HZDM")
	private String hzdm;


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

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getNestedStatus() {
		return nestedStatus;
	}

	public void setNestedStatus(String nestedStatus) {
		this.nestedStatus = nestedStatus;
	}

	public String getParentZipId() {
		return parentZipId;
	}

	public void setParentZipId(String parentZipId) {
		this.parentZipId = parentZipId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHzdm() {
		return hzdm;
	}

	public void setHzdm(String hzdm) {
		this.hzdm = hzdm;
	}

	public static final String POLICE_ORG_ID = "POLICE_ORG_ID";

	public static final String BANK_ID = "BANK_ID";

	public static final String QQDBS = "QQDBS";

	public static final String FILE = "FILE";

	public static final String NESTED_STATUS = "NESTED_STATUS";

	public static final String PARENT_ZIP_ID = "PARENT_ZIP_ID";

	public static final String STATUS = "STATUS";

	public static final String HZDM = "HZDM";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MpsReqZip{" +
			", policeOrgId=" + policeOrgId +
			", bankId=" + bankId +
			", qqdbs=" + qqdbs +
			", file=" + file +
			", nestedStatus=" + nestedStatus +
			", parentZipId=" + parentZipId +
			", status=" + status +
			", hzdm=" + hzdm +
			"}";
	}
}
