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
@TableName("MPS_RESP_STOP_RESULT")
public class MpsRespStopResult extends SystemBaseEntity<MpsRespStopResult> {

    private static final long serialVersionUID = 1L;

	@TableField("REQ_BASIC_INFO_ID")
	private String reqBasicInfoId;
	@TableField("REQ_TYPE")
	private String reqType;
	@TableField("RWLSH")
	private String rwlsh;
	@TableField("ZH")
	private String zh;
	@TableField("ZXJG")
	private String zxjg;
	@TableField("SBYY")
	private String sbyy;
	@TableField("ZXQSSJ")
	private String zxqssj;


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

	public String getZxqssj() {
		return zxqssj;
	}

	public void setZxqssj(String zxqssj) {
		this.zxqssj = zxqssj;
	}

	public static final String REQ_BASIC_INFO_ID = "REQ_BASIC_INFO_ID";

	public static final String REQ_TYPE = "REQ_TYPE";

	public static final String RWLSH = "RWLSH";

	public static final String ZH = "ZH";

	public static final String ZXJG = "ZXJG";

	public static final String SBYY = "SBYY";

	public static final String ZXQSSJ = "ZXQSSJ";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MpsRespStopResult{" +
			", reqBasicInfoId=" + reqBasicInfoId +
			", reqType=" + reqType +
			", rwlsh=" + rwlsh +
			", zh=" + zh +
			", zxjg=" + zxjg +
			", sbyy=" + sbyy +
			", zxqssj=" + zxqssj +
			"}";
	}
}
