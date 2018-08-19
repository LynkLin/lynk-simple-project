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
@TableName("MPS_RESP_SUBACCOUNT")
public class MpsRespSubaccount extends SystemBaseEntity<MpsRespSubaccount> {

    private static final long serialVersionUID = 1L;

	@TableField("REQ_BASIC_INFO_ID")
	private String reqBasicInfoId;
	@TableField("REQ_TYPE")
	private String reqType;
	@TableField("RESP_CUSTOMER_ID")
	private String respCustomerId;
	@TableField("ZH")
	private String zh;
	@TableField("ZZHXH")
	private String zzhxh;
	@TableField("ZZHLB")
	private String zzhlb;
	@TableField("ZZHZH")
	private String zzhzh;
	@TableField("BZ")
	private String bz;
	@TableField("CHBZ")
	private String chbz;
	@TableField("ZHYE")
	private String zhye;
	@TableField("ZHZT")
	private String zhzt;
	@TableField("KYYE")
	private String kyye;


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

	public String getZzhxh() {
		return zzhxh;
	}

	public void setZzhxh(String zzhxh) {
		this.zzhxh = zzhxh;
	}

	public String getZzhlb() {
		return zzhlb;
	}

	public void setZzhlb(String zzhlb) {
		this.zzhlb = zzhlb;
	}

	public String getZzhzh() {
		return zzhzh;
	}

	public void setZzhzh(String zzhzh) {
		this.zzhzh = zzhzh;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getChbz() {
		return chbz;
	}

	public void setChbz(String chbz) {
		this.chbz = chbz;
	}

	public String getZhye() {
		return zhye;
	}

	public void setZhye(String zhye) {
		this.zhye = zhye;
	}

	public String getZhzt() {
		return zhzt;
	}

	public void setZhzt(String zhzt) {
		this.zhzt = zhzt;
	}

	public String getKyye() {
		return kyye;
	}

	public void setKyye(String kyye) {
		this.kyye = kyye;
	}

	public static final String REQ_BASIC_INFO_ID = "REQ_BASIC_INFO_ID";

	public static final String REQ_TYPE = "REQ_TYPE";

	public static final String RESP_CUSTOMER_ID = "RESP_CUSTOMER_ID";

	public static final String ZH = "ZH";

	public static final String ZZHXH = "ZZHXH";

	public static final String ZZHLB = "ZZHLB";

	public static final String ZZHZH = "ZZHZH";

	public static final String BZ = "BZ";

	public static final String CHBZ = "CHBZ";

	public static final String ZHYE = "ZHYE";

	public static final String ZHZT = "ZHZT";

	public static final String KYYE = "KYYE";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MpsRespSubaccount{" +
			", reqBasicInfoId=" + reqBasicInfoId +
			", reqType=" + reqType +
			", respCustomerId=" + respCustomerId +
			", zh=" + zh +
			", zzhxh=" + zzhxh +
			", zzhlb=" + zzhlb +
			", zzhzh=" + zzhzh +
			", bz=" + bz +
			", chbz=" + chbz +
			", zhye=" + zhye +
			", zhzt=" + zhzt +
			", kyye=" + kyye +
			"}";
	}
}
