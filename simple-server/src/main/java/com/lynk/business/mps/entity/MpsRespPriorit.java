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
@TableName("MPS_RESP_PRIORIT")
public class MpsRespPriorit extends SystemBaseEntity<MpsRespPriorit> {

    private static final long serialVersionUID = 1L;

	@TableField("REQ_BASIC_INFO_ID")
	private String reqBasicInfoId;
	@TableField("REQ_TYPE")
	private String reqType;
	@TableField("RESP_CUSTOMER_ID")
	private String respCustomerId;
	@TableField("ZH")
	private String zh;
	@TableField("XH")
	private String xh;
	@TableField("QLLX")
	private String qllx;
	@TableField("ZZLXDM")
	private String zzlxdm;
	@TableField("ZZHM")
	private String zzhm;
	@TableField("QLRXM")
	private String qlrxm;
	@TableField("QLJE")
	private String qlje;
	@TableField("QLRDZ")
	private String qlrdz;
	@TableField("QLRLXFS")
	private String qlrlxfs;


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

	public String getRespCustomerId() {
		return respCustomerId;
	}

	public void setRespCustomerId(String respCustomerId) {
		this.respCustomerId = respCustomerId;
	}

	public String getZh() {
		return zh;
	}

	public void setZh(String zh) {
		this.zh = zh;
	}

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getQllx() {
		return qllx;
	}

	public void setQllx(String qllx) {
		this.qllx = qllx;
	}

	public String getZzlxdm() {
		return zzlxdm;
	}

	public void setZzlxdm(String zzlxdm) {
		this.zzlxdm = zzlxdm;
	}

	public String getZzhm() {
		return zzhm;
	}

	public void setZzhm(String zzhm) {
		this.zzhm = zzhm;
	}

	public String getQlrxm() {
		return qlrxm;
	}

	public void setQlrxm(String qlrxm) {
		this.qlrxm = qlrxm;
	}

	public String getQlje() {
		return qlje;
	}

	public void setQlje(String qlje) {
		this.qlje = qlje;
	}

	public String getQlrdz() {
		return qlrdz;
	}

	public void setQlrdz(String qlrdz) {
		this.qlrdz = qlrdz;
	}

	public String getQlrlxfs() {
		return qlrlxfs;
	}

	public void setQlrlxfs(String qlrlxfs) {
		this.qlrlxfs = qlrlxfs;
	}

	public static final String REQ_BASIC_INFO_ID = "REQ_BASIC_INFO_ID";

	public static final String REQ_TYPE = "REQ_TYPE";

	public static final String RESP_CUSTOMER_ID = "RESP_CUSTOMER_ID";

	public static final String ZH = "ZH";

	public static final String XH = "XH";

	public static final String QLLX = "QLLX";

	public static final String ZZLXDM = "ZZLXDM";

	public static final String ZZHM = "ZZHM";

	public static final String QLRXM = "QLRXM";

	public static final String QLJE = "QLJE";

	public static final String QLRDZ = "QLRDZ";

	public static final String QLRLXFS = "QLRLXFS";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MpsRespPriorit{" +
			", reqBasicInfoId=" + reqBasicInfoId +
			", reqType=" + reqType +
			", respCustomerId=" + respCustomerId +
			", zh=" + zh +
			", xh=" + xh +
			", qllx=" + qllx +
			", zzlxdm=" + zzlxdm +
			", zzhm=" + zzhm +
			", qlrxm=" + qlrxm +
			", qlje=" + qlje +
			", qlrdz=" + qlrdz +
			", qlrlxfs=" + qlrlxfs +
			"}";
	}
}
