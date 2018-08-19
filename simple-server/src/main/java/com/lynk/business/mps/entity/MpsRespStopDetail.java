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
@TableName("MPS_RESP_STOP_DETAIL")
public class MpsRespStopDetail extends SystemBaseEntity<MpsRespStopDetail> {

    private static final long serialVersionUID = 1L;

	@TableField("REQ_BASIC_INFO_ID")
	private String reqBasicInfoId;
	@TableField("REQ_TYPE")
	private String reqType;
	@TableField("RWLSH")
	private String rwlsh;
	@TableField("ZH")
	private String zh;
	@TableField("ZHZZH")
	private String zhzzh;
	@TableField("ZZHXH")
	private String zzhxh;
	@TableField("ZZHYE")
	private String zzhye;
	@TableField("ZXJG")
	private String zxjg;
	@TableField("ZXJGYY")
	private String zxjgyy;
	@TableField("ZFKSSJ")
	private String zfkssj;
	@TableField("ZFJSSJ")
	private String zfjssj;
	@TableField("BZ")
	private String bz;
	@TableField("CHBZ")
	private String chbz;


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

	public String getZhzzh() {
		return zhzzh;
	}

	public void setZhzzh(String zhzzh) {
		this.zhzzh = zhzzh;
	}

	public String getZzhxh() {
		return zzhxh;
	}

	public void setZzhxh(String zzhxh) {
		this.zzhxh = zzhxh;
	}

	public String getZzhye() {
		return zzhye;
	}

	public void setZzhye(String zzhye) {
		this.zzhye = zzhye;
	}

	public String getZxjg() {
		return zxjg;
	}

	public void setZxjg(String zxjg) {
		this.zxjg = zxjg;
	}

	public String getZxjgyy() {
		return zxjgyy;
	}

	public void setZxjgyy(String zxjgyy) {
		this.zxjgyy = zxjgyy;
	}

	public String getZfkssj() {
		return zfkssj;
	}

	public void setZfkssj(String zfkssj) {
		this.zfkssj = zfkssj;
	}

	public String getZfjssj() {
		return zfjssj;
	}

	public void setZfjssj(String zfjssj) {
		this.zfjssj = zfjssj;
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

	public static final String REQ_BASIC_INFO_ID = "REQ_BASIC_INFO_ID";

	public static final String REQ_TYPE = "REQ_TYPE";

	public static final String RWLSH = "RWLSH";

	public static final String ZH = "ZH";

	public static final String ZHZZH = "ZHZZH";

	public static final String ZZHXH = "ZZHXH";

	public static final String ZZHYE = "ZZHYE";

	public static final String ZXJG = "ZXJG";

	public static final String ZXJGYY = "ZXJGYY";

	public static final String ZFKSSJ = "ZFKSSJ";

	public static final String ZFJSSJ = "ZFJSSJ";

	public static final String BZ = "BZ";

	public static final String CHBZ = "CHBZ";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MpsRespStopDetail{" +
			", reqBasicInfoId=" + reqBasicInfoId +
			", reqType=" + reqType +
			", rwlsh=" + rwlsh +
			", zh=" + zh +
			", zhzzh=" + zhzzh +
			", zzhxh=" + zzhxh +
			", zzhye=" + zzhye +
			", zxjg=" + zxjg +
			", zxjgyy=" + zxjgyy +
			", zfkssj=" + zfkssj +
			", zfjssj=" + zfjssj +
			", bz=" + bz +
			", chbz=" + chbz +
			"}";
	}
}
