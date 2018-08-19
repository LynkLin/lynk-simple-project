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
@TableName("MPS_REQ_PERSON")
public class MpsReqPerson extends SystemBaseEntity<MpsReqPerson> {

    private static final long serialVersionUID = 1L;

	@TableField("REQ_BASIC_INFO_ID")
	private String reqBasicInfoId;
	@TableField("REQ_TYPE")
	private String reqType;
	@TableField("QQRXM")
	private String qqrxm;
	@TableField("QQRZJLX")
	private String qqrzjlx;
	@TableField("QQRZJHM")
	private String qqrzjhm;
	@TableField("QQRDWMC")
	private String qqrdwmc;
	@TableField("QQRSJH")
	private String qqrsjh;
	@TableField("XCRXM")
	private String xcrxm;
	@TableField("XCRZJLX")
	private String xcrzjlx;
	@TableField("XCRZJHM")
	private String xcrzjhm;


	public String getReqBasicInfoId() {
		return reqBasicInfoId;
	}

	public void setReqBasicInfoId(String reqBasicInfoId) {
		this.reqBasicInfoId = reqBasicInfoId;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getQqrxm() {
		return qqrxm;
	}

	public void setQqrxm(String qqrxm) {
		this.qqrxm = qqrxm;
	}

	public String getQqrzjlx() {
		return qqrzjlx;
	}

	public void setQqrzjlx(String qqrzjlx) {
		this.qqrzjlx = qqrzjlx;
	}

	public String getQqrzjhm() {
		return qqrzjhm;
	}

	public void setQqrzjhm(String qqrzjhm) {
		this.qqrzjhm = qqrzjhm;
	}

	public String getQqrdwmc() {
		return qqrdwmc;
	}

	public void setQqrdwmc(String qqrdwmc) {
		this.qqrdwmc = qqrdwmc;
	}

	public String getQqrsjh() {
		return qqrsjh;
	}

	public void setQqrsjh(String qqrsjh) {
		this.qqrsjh = qqrsjh;
	}

	public String getXcrxm() {
		return xcrxm;
	}

	public void setXcrxm(String xcrxm) {
		this.xcrxm = xcrxm;
	}

	public String getXcrzjlx() {
		return xcrzjlx;
	}

	public void setXcrzjlx(String xcrzjlx) {
		this.xcrzjlx = xcrzjlx;
	}

	public String getXcrzjhm() {
		return xcrzjhm;
	}

	public void setXcrzjhm(String xcrzjhm) {
		this.xcrzjhm = xcrzjhm;
	}

	public static final String REQ_BASIC_INFO_ID = "REQ_BASIC_INFO_ID";

	public static final String REQ_TYPE = "REQ_TYPE";

	public static final String QQRXM = "QQRXM";

	public static final String QQRZJLX = "QQRZJLX";

	public static final String QQRZJHM = "QQRZJHM";

	public static final String QQRDWMC = "QQRDWMC";

	public static final String QQRSJH = "QQRSJH";

	public static final String XCRXM = "XCRXM";

	public static final String XCRZJLX = "XCRZJLX";

	public static final String XCRZJHM = "XCRZJHM";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MpsReqPerson{" +
			", reqBasicInfoId=" + reqBasicInfoId +
			", reqType=" + reqType +
			", qqrxm=" + qqrxm +
			", qqrzjlx=" + qqrzjlx +
			", qqrzjhm=" + qqrzjhm +
			", qqrdwmc=" + qqrdwmc +
			", qqrsjh=" + qqrsjh +
			", xcrxm=" + xcrxm +
			", xcrzjlx=" + xcrzjlx +
			", xcrzjhm=" + xcrzjhm +
			"}";
	}
}
