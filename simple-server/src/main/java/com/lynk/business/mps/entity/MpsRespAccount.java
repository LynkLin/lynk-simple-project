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
@TableName("MPS_RESP_ACCOUNT")
public class MpsRespAccount extends SystemBaseEntity<MpsRespAccount> {

    private static final long serialVersionUID = 1L;

	@TableField("REQ_BASIC_INFO_ID")
	private String reqBasicInfoId;
	@TableField("REQ_TYPE")
	private String reqType;
	@TableField("RESP_CUSTOMER_ID")
	private String respCustomerId;
	@TableField("KH")
	private String kh;
	@TableField("ZH")
	private String zh;
	@TableField("ZHLB")
	private String zhlb;
	@TableField("ZHZT")
	private String zhzt;
	@TableField("KHWD")
	private String khwd;
	@TableField("KHWDDM")
	private String khwddm;
	@TableField("KHRQ")
	private String khrq;
	@TableField("XHRQ")
	private String xhrq;
	@TableField("XHWD")
	private String xhwd;
	@TableField("BZ")
	private String bz;
	@TableField("CHBZ")
	private String chbz;
	@TableField("ZHYE")
	private String zhye;
	@TableField("KYYE")
	private String kyye;
	@TableField("ZHJYSJ")
	private String zhjysj;
	@TableField("BEIZ")
	private String beiz;


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

	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}

	public String getZh() {
		return zh;
	}

	public void setZh(String zh) {
		this.zh = zh;
	}

	public String getZhlb() {
		return zhlb;
	}

	public void setZhlb(String zhlb) {
		this.zhlb = zhlb;
	}

	public String getZhzt() {
		return zhzt;
	}

	public void setZhzt(String zhzt) {
		this.zhzt = zhzt;
	}

	public String getKhwd() {
		return khwd;
	}

	public void setKhwd(String khwd) {
		this.khwd = khwd;
	}

	public String getKhwddm() {
		return khwddm;
	}

	public void setKhwddm(String khwddm) {
		this.khwddm = khwddm;
	}

	public String getKhrq() {
		return khrq;
	}

	public void setKhrq(String khrq) {
		this.khrq = khrq;
	}

	public String getXhrq() {
		return xhrq;
	}

	public void setXhrq(String xhrq) {
		this.xhrq = xhrq;
	}

	public String getXhwd() {
		return xhwd;
	}

	public void setXhwd(String xhwd) {
		this.xhwd = xhwd;
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

	public String getKyye() {
		return kyye;
	}

	public void setKyye(String kyye) {
		this.kyye = kyye;
	}

	public String getZhjysj() {
		return zhjysj;
	}

	public void setZhjysj(String zhjysj) {
		this.zhjysj = zhjysj;
	}

	public String getBeiz() {
		return beiz;
	}

	public void setBeiz(String beiz) {
		this.beiz = beiz;
	}

	public static final String REQ_BASIC_INFO_ID = "REQ_BASIC_INFO_ID";

	public static final String REQ_TYPE = "REQ_TYPE";

	public static final String RESP_CUSTOMER_ID = "RESP_CUSTOMER_ID";

	public static final String KH = "KH";

	public static final String ZH = "ZH";

	public static final String ZHLB = "ZHLB";

	public static final String ZHZT = "ZHZT";

	public static final String KHWD = "KHWD";

	public static final String KHWDDM = "KHWDDM";

	public static final String KHRQ = "KHRQ";

	public static final String XHRQ = "XHRQ";

	public static final String XHWD = "XHWD";

	public static final String BZ = "BZ";

	public static final String CHBZ = "CHBZ";

	public static final String ZHYE = "ZHYE";

	public static final String KYYE = "KYYE";

	public static final String ZHJYSJ = "ZHJYSJ";

	public static final String BEIZ = "BEIZ";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MpsRespAccount{" +
			", reqBasicInfoId=" + reqBasicInfoId +
			", reqType=" + reqType +
			", respCustomerId=" + respCustomerId +
			", kh=" + kh +
			", zh=" + zh +
			", zhlb=" + zhlb +
			", zhzt=" + zhzt +
			", khwd=" + khwd +
			", khwddm=" + khwddm +
			", khrq=" + khrq +
			", xhrq=" + xhrq +
			", xhwd=" + xhwd +
			", bz=" + bz +
			", chbz=" + chbz +
			", zhye=" + zhye +
			", kyye=" + kyye +
			", zhjysj=" + zhjysj +
			", beiz=" + beiz +
			"}";
	}
}
