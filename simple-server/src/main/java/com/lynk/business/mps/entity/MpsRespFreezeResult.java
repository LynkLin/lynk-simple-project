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
@TableName("MPS_RESP_FREEZE_RESULT")
public class MpsRespFreezeResult extends SystemBaseEntity<MpsRespFreezeResult> {

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
	@TableField("SQDJXE")
	private String sqdjxe;
	@TableField("SDJE")
	private String sdje;
	@TableField("YE")
	private String ye;
	@TableField("ZXQSSJ")
	private String zxqssj;
	@TableField("DJJSRQ")
	private String djjsrq;
	@TableField("WNDJYY")
	private String wndjyy;
	@TableField("DJJG")
	private String djjg;
	@TableField("DJJE")
	private String djje;
	@TableField("DJJZRQ")
	private String djjzrq;
	@TableField("WDJJE")
	private String wdjje;
	@TableField("ZHKYYE")
	private String zhkyye;
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

	public String getSqdjxe() {
		return sqdjxe;
	}

	public void setSqdjxe(String sqdjxe) {
		this.sqdjxe = sqdjxe;
	}

	public String getSdje() {
		return sdje;
	}

	public void setSdje(String sdje) {
		this.sdje = sdje;
	}

	public String getYe() {
		return ye;
	}

	public void setYe(String ye) {
		this.ye = ye;
	}

	public String getZxqssj() {
		return zxqssj;
	}

	public void setZxqssj(String zxqssj) {
		this.zxqssj = zxqssj;
	}

	public String getDjjsrq() {
		return djjsrq;
	}

	public void setDjjsrq(String djjsrq) {
		this.djjsrq = djjsrq;
	}

	public String getWndjyy() {
		return wndjyy;
	}

	public void setWndjyy(String wndjyy) {
		this.wndjyy = wndjyy;
	}

	public String getDjjg() {
		return djjg;
	}

	public void setDjjg(String djjg) {
		this.djjg = djjg;
	}

	public String getDjje() {
		return djje;
	}

	public void setDjje(String djje) {
		this.djje = djje;
	}

	public String getDjjzrq() {
		return djjzrq;
	}

	public void setDjjzrq(String djjzrq) {
		this.djjzrq = djjzrq;
	}

	public String getWdjje() {
		return wdjje;
	}

	public void setWdjje(String wdjje) {
		this.wdjje = wdjje;
	}

	public String getZhkyye() {
		return zhkyye;
	}

	public void setZhkyye(String zhkyye) {
		this.zhkyye = zhkyye;
	}

	public String getBeiz() {
		return beiz;
	}

	public void setBeiz(String beiz) {
		this.beiz = beiz;
	}

	public static final String REQ_BASIC_INFO_ID = "REQ_BASIC_INFO_ID";

	public static final String REQ_TYPE = "REQ_TYPE";

	public static final String RWLSH = "RWLSH";

	public static final String ZH = "ZH";

	public static final String KH = "KH";

	public static final String ZXJG = "ZXJG";

	public static final String SQDJXE = "SQDJXE";

	public static final String SDJE = "SDJE";

	public static final String YE = "YE";

	public static final String ZXQSSJ = "ZXQSSJ";

	public static final String DJJSRQ = "DJJSRQ";

	public static final String WNDJYY = "WNDJYY";

	public static final String DJJG = "DJJG";

	public static final String DJJE = "DJJE";

	public static final String DJJZRQ = "DJJZRQ";

	public static final String WDJJE = "WDJJE";

	public static final String ZHKYYE = "ZHKYYE";

	public static final String BEIZ = "BEIZ";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MpsRespFreezeResult{" +
			", reqBasicInfoId=" + reqBasicInfoId +
			", reqType=" + reqType +
			", rwlsh=" + rwlsh +
			", zh=" + zh +
			", kh=" + kh +
			", zxjg=" + zxjg +
			", sqdjxe=" + sqdjxe +
			", sdje=" + sdje +
			", ye=" + ye +
			", zxqssj=" + zxqssj +
			", djjsrq=" + djjsrq +
			", wndjyy=" + wndjyy +
			", djjg=" + djjg +
			", djje=" + djje +
			", djjzrq=" + djjzrq +
			", wdjje=" + wdjje +
			", zhkyye=" + zhkyye +
			", beiz=" + beiz +
			"}";
	}
}
