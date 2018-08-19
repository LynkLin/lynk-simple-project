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
@TableName("MPS_REQ_BASIC")
public class MpsReqBasic extends SystemBaseEntity<MpsReqBasic> {

    private static final long serialVersionUID = 1L;

	@TableField("REQ_ID")
	private String reqId;
	@TableField("REQ_TYPE")
	private String reqType;
	@TableField("REQ_FILE")
	private String reqFile;
	@TableField("QQDBS")
	private String qqdbs;
	@TableField("QQCSLX")
	private String qqcslx;
	@TableField("SQJGDM")
	private String sqjgdm;
	@TableField("MBJGDM")
	private String mbjgdm;
	@TableField("CKZTLB")
	private String ckztlb;
	@TableField("AJLX")
	private String ajlx;
	@TableField("JJCD")
	private String jjcd;
	@TableField("BEIZ")
	private String beiz;
	@TableField("FSSJ")
	private String fssj;


	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getReqFile() {
		return reqFile;
	}

	public void setReqFile(String reqFile) {
		this.reqFile = reqFile;
	}

	public String getQqdbs() {
		return qqdbs;
	}

	public void setQqdbs(String qqdbs) {
		this.qqdbs = qqdbs;
	}

	public String getQqcslx() {
		return qqcslx;
	}

	public void setQqcslx(String qqcslx) {
		this.qqcslx = qqcslx;
	}

	public String getSqjgdm() {
		return sqjgdm;
	}

	public void setSqjgdm(String sqjgdm) {
		this.sqjgdm = sqjgdm;
	}

	public String getMbjgdm() {
		return mbjgdm;
	}

	public void setMbjgdm(String mbjgdm) {
		this.mbjgdm = mbjgdm;
	}

	public String getCkztlb() {
		return ckztlb;
	}

	public void setCkztlb(String ckztlb) {
		this.ckztlb = ckztlb;
	}

	public String getAjlx() {
		return ajlx;
	}

	public void setAjlx(String ajlx) {
		this.ajlx = ajlx;
	}

	public String getJjcd() {
		return jjcd;
	}

	public void setJjcd(String jjcd) {
		this.jjcd = jjcd;
	}

	public String getBeiz() {
		return beiz;
	}

	public void setBeiz(String beiz) {
		this.beiz = beiz;
	}

	public String getFssj() {
		return fssj;
	}

	public void setFssj(String fssj) {
		this.fssj = fssj;
	}

	public static final String REQ_ID = "REQ_ID";

	public static final String REQ_TYPE = "REQ_TYPE";

	public static final String REQ_FILE = "REQ_FILE";

	public static final String QQDBS = "QQDBS";

	public static final String QQCSLX = "QQCSLX";

	public static final String SQJGDM = "SQJGDM";

	public static final String MBJGDM = "MBJGDM";

	public static final String CKZTLB = "CKZTLB";

	public static final String AJLX = "AJLX";

	public static final String JJCD = "JJCD";

	public static final String BEIZ = "BEIZ";

	public static final String FSSJ = "FSSJ";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MpsReqBasic{" +
			", reqId=" + reqId +
			", reqType=" + reqType +
			", reqFile=" + reqFile +
			", qqdbs=" + qqdbs +
			", qqcslx=" + qqcslx +
			", sqjgdm=" + sqjgdm +
			", mbjgdm=" + mbjgdm +
			", ckztlb=" + ckztlb +
			", ajlx=" + ajlx +
			", jjcd=" + jjcd +
			", beiz=" + beiz +
			", fssj=" + fssj +
			"}";
	}
}
