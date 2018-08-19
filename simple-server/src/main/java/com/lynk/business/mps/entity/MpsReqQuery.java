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
@TableName("MPS_REQ_QUERY")
public class MpsReqQuery extends SystemBaseEntity<MpsReqQuery> {

    private static final long serialVersionUID = 1L;

	@TableField("REQ_BASIC_INFO_ID")
	private String reqBasicInfoId;
	@TableField("REQ_TYPE")
	private String reqType;
	@TableField("RWLSH")
	private String rwlsh;
	@TableField("ZZLX")
	private String zzlx;
	@TableField("ZZHM")
	private String zzhm;
	@TableField("ZTMC")
	private String ztmc;
	@TableField("CXZH")
	private String cxzh;
	@TableField("CXNR")
	private String cxnr;
	@TableField("MXSDLX")
	private String mxsdlx;
	@TableField("MXQSSJ")
	private String mxqssj;
	@TableField("MXJZSJ")
	private String mxjzsj;


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

	public String getRwlsh() {
		return rwlsh;
	}

	public void setRwlsh(String rwlsh) {
		this.rwlsh = rwlsh;
	}

	public String getZzlx() {
		return zzlx;
	}

	public void setZzlx(String zzlx) {
		this.zzlx = zzlx;
	}

	public String getZzhm() {
		return zzhm;
	}

	public void setZzhm(String zzhm) {
		this.zzhm = zzhm;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public String getCxzh() {
		return cxzh;
	}

	public void setCxzh(String cxzh) {
		this.cxzh = cxzh;
	}

	public String getCxnr() {
		return cxnr;
	}

	public void setCxnr(String cxnr) {
		this.cxnr = cxnr;
	}

	public String getMxsdlx() {
		return mxsdlx;
	}

	public void setMxsdlx(String mxsdlx) {
		this.mxsdlx = mxsdlx;
	}

	public String getMxqssj() {
		return mxqssj;
	}

	public void setMxqssj(String mxqssj) {
		this.mxqssj = mxqssj;
	}

	public String getMxjzsj() {
		return mxjzsj;
	}

	public void setMxjzsj(String mxjzsj) {
		this.mxjzsj = mxjzsj;
	}

	public static final String REQ_BASIC_INFO_ID = "REQ_BASIC_INFO_ID";

	public static final String REQ_TYPE = "REQ_TYPE";

	public static final String RWLSH = "RWLSH";

	public static final String ZZLX = "ZZLX";

	public static final String ZZHM = "ZZHM";

	public static final String ZTMC = "ZTMC";

	public static final String CXZH = "CXZH";

	public static final String CXNR = "CXNR";

	public static final String MXSDLX = "MXSDLX";

	public static final String MXQSSJ = "MXQSSJ";

	public static final String MXJZSJ = "MXJZSJ";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MpsReqQuery{" +
			", reqBasicInfoId=" + reqBasicInfoId +
			", reqType=" + reqType +
			", rwlsh=" + rwlsh +
			", zzlx=" + zzlx +
			", zzhm=" + zzhm +
			", ztmc=" + ztmc +
			", cxzh=" + cxzh +
			", cxnr=" + cxnr +
			", mxsdlx=" + mxsdlx +
			", mxqssj=" + mxqssj +
			", mxjzsj=" + mxjzsj +
			"}";
	}
}
