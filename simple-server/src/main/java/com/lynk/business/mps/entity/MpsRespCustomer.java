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
@TableName("MPS_RESP_CUSTOMER")
public class MpsRespCustomer extends SystemBaseEntity<MpsRespCustomer> {

    private static final long serialVersionUID = 1L;

	@TableField("REQ_BASIC_INFO_ID")
	private String reqBasicInfoId;
	@TableField("REQ_TYPE")
	private String reqType;
	@TableField("RWLSH")
	private String rwlsh;
	@TableField("CXFKJG")
	private String cxfkjg;
	@TableField("CXFKJGYY")
	private String cxfkjgyy;
	@TableField("ZZLX")
	private String zzlx;
	@TableField("ZZHM")
	private String zzhm;
	@TableField("KHMC")
	private String khmc;
	@TableField("LXDH")
	private String lxdh;
	@TableField("LXSJ")
	private String lxsj;
	@TableField("DBRXM")
	private String dbrxm;
	@TableField("DBRZJLX")
	private String dbrzjlx;
	@TableField("DBRZJHM")
	private String dbrzjhm;
	@TableField("ZZDZ")
	private String zzdz;
	@TableField("ZZDH")
	private String zzdh;
	@TableField("GZDW")
	private String gzdw;
	@TableField("DWDZ")
	private String dwdz;
	@TableField("DWDH")
	private String dwdh;
	@TableField("YXDZ")
	private String yxdz;
	@TableField("FRDB")
	private String frdb;
	@TableField("FRDBZJLX")
	private String frdbzjlx;
	@TableField("FRDBZJHM")
	private String frdbzjhm;
	@TableField("KHGSZZHM")
	private String khgszzhm;
	@TableField("GSNSH")
	private String gsnsh;
	@TableField("DSNSH")
	private String dsnsh;


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

	public String getCxfkjg() {
		return cxfkjg;
	}

	public void setCxfkjg(String cxfkjg) {
		this.cxfkjg = cxfkjg;
	}

	public String getCxfkjgyy() {
		return cxfkjgyy;
	}

	public void setCxfkjgyy(String cxfkjgyy) {
		this.cxfkjgyy = cxfkjgyy;
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

	public String getKhmc() {
		return khmc;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getLxsj() {
		return lxsj;
	}

	public void setLxsj(String lxsj) {
		this.lxsj = lxsj;
	}

	public String getDbrxm() {
		return dbrxm;
	}

	public void setDbrxm(String dbrxm) {
		this.dbrxm = dbrxm;
	}

	public String getDbrzjlx() {
		return dbrzjlx;
	}

	public void setDbrzjlx(String dbrzjlx) {
		this.dbrzjlx = dbrzjlx;
	}

	public String getDbrzjhm() {
		return dbrzjhm;
	}

	public void setDbrzjhm(String dbrzjhm) {
		this.dbrzjhm = dbrzjhm;
	}

	public String getZzdz() {
		return zzdz;
	}

	public void setZzdz(String zzdz) {
		this.zzdz = zzdz;
	}

	public String getZzdh() {
		return zzdh;
	}

	public void setZzdh(String zzdh) {
		this.zzdh = zzdh;
	}

	public String getGzdw() {
		return gzdw;
	}

	public void setGzdw(String gzdw) {
		this.gzdw = gzdw;
	}

	public String getDwdz() {
		return dwdz;
	}

	public void setDwdz(String dwdz) {
		this.dwdz = dwdz;
	}

	public String getDwdh() {
		return dwdh;
	}

	public void setDwdh(String dwdh) {
		this.dwdh = dwdh;
	}

	public String getYxdz() {
		return yxdz;
	}

	public void setYxdz(String yxdz) {
		this.yxdz = yxdz;
	}

	public String getFrdb() {
		return frdb;
	}

	public void setFrdb(String frdb) {
		this.frdb = frdb;
	}

	public String getFrdbzjlx() {
		return frdbzjlx;
	}

	public void setFrdbzjlx(String frdbzjlx) {
		this.frdbzjlx = frdbzjlx;
	}

	public String getFrdbzjhm() {
		return frdbzjhm;
	}

	public void setFrdbzjhm(String frdbzjhm) {
		this.frdbzjhm = frdbzjhm;
	}

	public String getKhgszzhm() {
		return khgszzhm;
	}

	public void setKhgszzhm(String khgszzhm) {
		this.khgszzhm = khgszzhm;
	}

	public String getGsnsh() {
		return gsnsh;
	}

	public void setGsnsh(String gsnsh) {
		this.gsnsh = gsnsh;
	}

	public String getDsnsh() {
		return dsnsh;
	}

	public void setDsnsh(String dsnsh) {
		this.dsnsh = dsnsh;
	}

	public static final String REQ_BASIC_INFO_ID = "REQ_BASIC_INFO_ID";

	public static final String REQ_TYPE = "REQ_TYPE";

	public static final String RWLSH = "RWLSH";

	public static final String CXFKJG = "CXFKJG";

	public static final String CXFKJGYY = "CXFKJGYY";

	public static final String ZZLX = "ZZLX";

	public static final String ZZHM = "ZZHM";

	public static final String KHMC = "KHMC";

	public static final String LXDH = "LXDH";

	public static final String LXSJ = "LXSJ";

	public static final String DBRXM = "DBRXM";

	public static final String DBRZJLX = "DBRZJLX";

	public static final String DBRZJHM = "DBRZJHM";

	public static final String ZZDZ = "ZZDZ";

	public static final String ZZDH = "ZZDH";

	public static final String GZDW = "GZDW";

	public static final String DWDZ = "DWDZ";

	public static final String DWDH = "DWDH";

	public static final String YXDZ = "YXDZ";

	public static final String FRDB = "FRDB";

	public static final String FRDBZJLX = "FRDBZJLX";

	public static final String FRDBZJHM = "FRDBZJHM";

	public static final String KHGSZZHM = "KHGSZZHM";

	public static final String GSNSH = "GSNSH";

	public static final String DSNSH = "DSNSH";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MpsRespCustomer{" +
			", reqBasicInfoId=" + reqBasicInfoId +
			", reqType=" + reqType +
			", rwlsh=" + rwlsh +
			", cxfkjg=" + cxfkjg +
			", cxfkjgyy=" + cxfkjgyy +
			", zzlx=" + zzlx +
			", zzhm=" + zzhm +
			", khmc=" + khmc +
			", lxdh=" + lxdh +
			", lxsj=" + lxsj +
			", dbrxm=" + dbrxm +
			", dbrzjlx=" + dbrzjlx +
			", dbrzjhm=" + dbrzjhm +
			", zzdz=" + zzdz +
			", zzdh=" + zzdh +
			", gzdw=" + gzdw +
			", dwdz=" + dwdz +
			", dwdh=" + dwdh +
			", yxdz=" + yxdz +
			", frdb=" + frdb +
			", frdbzjlx=" + frdbzjlx +
			", frdbzjhm=" + frdbzjhm +
			", khgszzhm=" + khgszzhm +
			", gsnsh=" + gsnsh +
			", dsnsh=" + dsnsh +
			"}";
	}
}
