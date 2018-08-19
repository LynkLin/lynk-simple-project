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
@TableName("MPS_RESP_DYNAMIC_RESULT")
public class MpsRespDynamicResult extends SystemBaseEntity<MpsRespDynamicResult> {

    private static final long serialVersionUID = 1L;

	@TableField("REQ_BASIC_INFO_ID")
	private String reqBasicInfoId;
	@TableField("REQ_TYPE")
	private String reqType;
	@TableField("RWLSH")
	private String rwlsh;
	@TableField("ZH")
	private String zh;
	@TableField("KH")
	private String kh;
	@TableField("ZXJG")
	private String zxjg;
	@TableField("SBYY")
	private String sbyy;
	@TableField("FKSJHM")
	private String fksjhm;
	@TableField("ZXQSSJ")
	private String zxqssj;
	@TableField("ZXSJQJ")
	private String zxsjqj;
	@TableField("JSSJ")
	private String jssj;


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

	public String getZh() {
		return zh;
	}

	public void setZh(String zh) {
		this.zh = zh;
	}

	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}

	public String getZxjg() {
		return zxjg;
	}

	public void setZxjg(String zxjg) {
		this.zxjg = zxjg;
	}

	public String getSbyy() {
		return sbyy;
	}

	public void setSbyy(String sbyy) {
		this.sbyy = sbyy;
	}

	public String getFksjhm() {
		return fksjhm;
	}

	public void setFksjhm(String fksjhm) {
		this.fksjhm = fksjhm;
	}

	public String getZxqssj() {
		return zxqssj;
	}

	public void setZxqssj(String zxqssj) {
		this.zxqssj = zxqssj;
	}

	public String getZxsjqj() {
		return zxsjqj;
	}

	public void setZxsjqj(String zxsjqj) {
		this.zxsjqj = zxsjqj;
	}

	public String getJssj() {
		return jssj;
	}

	public void setJssj(String jssj) {
		this.jssj = jssj;
	}

	public static final String REQ_BASIC_INFO_ID = "REQ_BASIC_INFO_ID";

	public static final String REQ_TYPE = "REQ_TYPE";

	public static final String RWLSH = "RWLSH";

	public static final String ZH = "ZH";

	public static final String KH = "KH";

	public static final String ZXJG = "ZXJG";

	public static final String SBYY = "SBYY";

	public static final String FKSJHM = "FKSJHM";

	public static final String ZXQSSJ = "ZXQSSJ";

	public static final String ZXSJQJ = "ZXSJQJ";

	public static final String JSSJ = "JSSJ";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MpsRespDynamicResult{" +
			", reqBasicInfoId=" + reqBasicInfoId +
			", reqType=" + reqType +
			", rwlsh=" + rwlsh +
			", zh=" + zh +
			", kh=" + kh +
			", zxjg=" + zxjg +
			", sbyy=" + sbyy +
			", fksjhm=" + fksjhm +
			", zxqssj=" + zxqssj +
			", zxsjqj=" + zxsjqj +
			", jssj=" + jssj +
			"}";
	}
}
