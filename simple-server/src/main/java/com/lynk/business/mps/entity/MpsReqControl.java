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
@TableName("MPS_REQ_CONTROL")
public class MpsReqControl extends SystemBaseEntity<MpsReqControl> {

    private static final long serialVersionUID = 1L;

	@TableField("REQ_BASIC_INFO_ID")
	private String reqBasicInfoId;
	@TableField("REQ_TYPE")
	private String reqType;
	@TableField("RWLSH")
	private String rwlsh;
	@TableField("YRWLSH")
	private String yrwlsh;
	@TableField("DJZHHZ")
	private String djzhhz;
	@TableField("ZZLXDM")
	private String zzlxdm;
	@TableField("ZZHM")
	private String zzhm;
	@TableField("ZH")
	private String zh;
	@TableField("ZHXH")
	private String zhxh;
	@TableField("DJFS")
	private String djfs;
	@TableField("JE")
	private String je;
	@TableField("BZ")
	private String bz;
	@TableField("KSSJ")
	private String kssj;
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

	public String getDjzhhz() {
		return djzhhz;
	}

	public void setDjzhhz(String djzhhz) {
		this.djzhhz = djzhhz;
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

	public String getZh() {
		return zh;
	}

	public void setZh(String zh) {
		this.zh = zh;
	}

	public String getZhxh() {
		return zhxh;
	}

	public void setZhxh(String zhxh) {
		this.zhxh = zhxh;
	}

	public String getDjfs() {
		return djfs;
	}

	public void setDjfs(String djfs) {
		this.djfs = djfs;
	}

	public String getJe() {
		return je;
	}

	public void setJe(String je) {
		this.je = je;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getKssj() {
		return kssj;
	}

	public void setKssj(String kssj) {
		this.kssj = kssj;
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

	public static final String DJZHHZ = "DJZHHZ";

	public static final String ZZLXDM = "ZZLXDM";

	public static final String ZZHM = "ZZHM";

	public static final String ZH = "ZH";

	public static final String ZHXH = "ZHXH";

	public static final String DJFS = "DJFS";

	public static final String JE = "JE";

	public static final String BZ = "BZ";

	public static final String KSSJ = "KSSJ";

	public static final String JSSJ = "JSSJ";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MpsReqControl{" +
			", reqBasicInfoId=" + reqBasicInfoId +
			", reqType=" + reqType +
			", rwlsh=" + rwlsh +
			", yrwlsh=" + yrwlsh +
			", djzhhz=" + djzhhz +
			", zzlxdm=" + zzlxdm +
			", zzhm=" + zzhm +
			", zh=" + zh +
			", zhxh=" + zhxh +
			", djfs=" + djfs +
			", je=" + je +
			", bz=" + bz +
			", kssj=" + kssj +
			", jssj=" + jssj +
			"}";
	}
}
