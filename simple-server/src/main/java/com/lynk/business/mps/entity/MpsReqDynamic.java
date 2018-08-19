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
@TableName("MPS_REQ_DYNAMIC")
public class MpsReqDynamic extends SystemBaseEntity<MpsReqDynamic> {

    private static final long serialVersionUID = 1L;

	@TableField("REQ_BASIC_INFO_ID")
	private String reqBasicInfoId;
	@TableField("REQ_TYPE")
	private String reqType;
	@TableField("RWLSH")
	private String rwlsh;
	@TableField("YRWLSH")
	private String yrwlsh;
	@TableField("ZH")
	private String zh;
	@TableField("KSSJ")
	private String kssj;
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

	public String getYrwlsh() {
		return yrwlsh;
	}

	public void setYrwlsh(String yrwlsh) {
		this.yrwlsh = yrwlsh;
	}

	public String getZh() {
		return zh;
	}

	public void setZh(String zh) {
		this.zh = zh;
	}

	public String getKssj() {
		return kssj;
	}

	public void setKssj(String kssj) {
		this.kssj = kssj;
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

	public static final String YRWLSH = "YRWLSH";

	public static final String ZH = "ZH";

	public static final String KSSJ = "KSSJ";

	public static final String ZXSJQJ = "ZXSJQJ";

	public static final String JSSJ = "JSSJ";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MpsReqDynamic{" +
			", reqBasicInfoId=" + reqBasicInfoId +
			", reqType=" + reqType +
			", rwlsh=" + rwlsh +
			", yrwlsh=" + yrwlsh +
			", zh=" + zh +
			", kssj=" + kssj +
			", zxsjqj=" + zxsjqj +
			", jssj=" + jssj +
			"}";
	}
}
