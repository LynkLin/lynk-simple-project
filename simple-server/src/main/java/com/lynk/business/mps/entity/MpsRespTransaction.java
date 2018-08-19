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
@TableName("MPS_RESP_TRANSACTION")
public class MpsRespTransaction extends SystemBaseEntity<MpsRespTransaction> {

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
	@TableField("CXZH")
	private String cxzh;
	@TableField("CXKH")
	private String cxkh;
	@TableField("JYLX")
	private String jylx;
	@TableField("JDBZ")
	private String jdbz;
	@TableField("BZ")
	private String bz;
	@TableField("JE")
	private String je;
	@TableField("YE")
	private String ye;
	@TableField("JYSJ")
	private String jysj;
	@TableField("JYLSH")
	private String jylsh;
	@TableField("JYDFXM")
	private String jydfxm;
	@TableField("JYDFZKH")
	private String jydfzkh;
	@TableField("JYDFZKHLX")
	private String jydfzkhlx;
	@TableField("JYDFZJHM")
	private String jydfzjhm;
	@TableField("JYDSYE")
	private String jydsye;
	@TableField("JYDFZHKHH")
	private String jydfzhkhh;
	@TableField("JYZY")
	private String jyzy;
	@TableField("JYWDMC")
	private String jywdmc;
	@TableField("JYWDDM")
	private String jywddm;
	@TableField("RZH")
	private String rzh;
	@TableField("CPH")
	private String cph;
	@TableField("PZZL")
	private String pzzl;
	@TableField("PZH")
	private String pzh;
	@TableField("XJBZ")
	private String xjbz;
	@TableField("ZDH")
	private String zdh;
	@TableField("JYSFCG")
	private String jysfcg;
	@TableField("JYFSD")
	private String jyfsd;
	@TableField("SHMC")
	private String shmc;
	@TableField("SHH")
	private String shh;
	@TableField("IP")
	private String ip;
	@TableField("MAC")
	private String mac;
	@TableField("JYGYH")
	private String jygyh;
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

	public String getCxzh() {
		return cxzh;
	}

	public void setCxzh(String cxzh) {
		this.cxzh = cxzh;
	}

	public String getCxkh() {
		return cxkh;
	}

	public void setCxkh(String cxkh) {
		this.cxkh = cxkh;
	}

	public String getJylx() {
		return jylx;
	}

	public void setJylx(String jylx) {
		this.jylx = jylx;
	}

	public String getJdbz() {
		return jdbz;
	}

	public void setJdbz(String jdbz) {
		this.jdbz = jdbz;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getJe() {
		return je;
	}

	public void setJe(String je) {
		this.je = je;
	}

	public String getYe() {
		return ye;
	}

	public void setYe(String ye) {
		this.ye = ye;
	}

	public String getJysj() {
		return jysj;
	}

	public void setJysj(String jysj) {
		this.jysj = jysj;
	}

	public String getJylsh() {
		return jylsh;
	}

	public void setJylsh(String jylsh) {
		this.jylsh = jylsh;
	}

	public String getJydfxm() {
		return jydfxm;
	}

	public void setJydfxm(String jydfxm) {
		this.jydfxm = jydfxm;
	}

	public String getJydfzkh() {
		return jydfzkh;
	}

	public void setJydfzkh(String jydfzkh) {
		this.jydfzkh = jydfzkh;
	}

	public String getJydfzkhlx() {
		return jydfzkhlx;
	}

	public void setJydfzkhlx(String jydfzkhlx) {
		this.jydfzkhlx = jydfzkhlx;
	}

	public String getJydfzjhm() {
		return jydfzjhm;
	}

	public void setJydfzjhm(String jydfzjhm) {
		this.jydfzjhm = jydfzjhm;
	}

	public String getJydsye() {
		return jydsye;
	}

	public void setJydsye(String jydsye) {
		this.jydsye = jydsye;
	}

	public String getJydfzhkhh() {
		return jydfzhkhh;
	}

	public void setJydfzhkhh(String jydfzhkhh) {
		this.jydfzhkhh = jydfzhkhh;
	}

	public String getJyzy() {
		return jyzy;
	}

	public void setJyzy(String jyzy) {
		this.jyzy = jyzy;
	}

	public String getJywdmc() {
		return jywdmc;
	}

	public void setJywdmc(String jywdmc) {
		this.jywdmc = jywdmc;
	}

	public String getJywddm() {
		return jywddm;
	}

	public void setJywddm(String jywddm) {
		this.jywddm = jywddm;
	}

	public String getRzh() {
		return rzh;
	}

	public void setRzh(String rzh) {
		this.rzh = rzh;
	}

	public String getCph() {
		return cph;
	}

	public void setCph(String cph) {
		this.cph = cph;
	}

	public String getPzzl() {
		return pzzl;
	}

	public void setPzzl(String pzzl) {
		this.pzzl = pzzl;
	}

	public String getPzh() {
		return pzh;
	}

	public void setPzh(String pzh) {
		this.pzh = pzh;
	}

	public String getXjbz() {
		return xjbz;
	}

	public void setXjbz(String xjbz) {
		this.xjbz = xjbz;
	}

	public String getZdh() {
		return zdh;
	}

	public void setZdh(String zdh) {
		this.zdh = zdh;
	}

	public String getJysfcg() {
		return jysfcg;
	}

	public void setJysfcg(String jysfcg) {
		this.jysfcg = jysfcg;
	}

	public String getJyfsd() {
		return jyfsd;
	}

	public void setJyfsd(String jyfsd) {
		this.jyfsd = jyfsd;
	}

	public String getShmc() {
		return shmc;
	}

	public void setShmc(String shmc) {
		this.shmc = shmc;
	}

	public String getShh() {
		return shh;
	}

	public void setShh(String shh) {
		this.shh = shh;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getJygyh() {
		return jygyh;
	}

	public void setJygyh(String jygyh) {
		this.jygyh = jygyh;
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

	public static final String CXFKJG = "CXFKJG";

	public static final String CXFKJGYY = "CXFKJGYY";

	public static final String CXZH = "CXZH";

	public static final String CXKH = "CXKH";

	public static final String JYLX = "JYLX";

	public static final String JDBZ = "JDBZ";

	public static final String BZ = "BZ";

	public static final String JE = "JE";

	public static final String YE = "YE";

	public static final String JYSJ = "JYSJ";

	public static final String JYLSH = "JYLSH";

	public static final String JYDFXM = "JYDFXM";

	public static final String JYDFZKH = "JYDFZKH";

	public static final String JYDFZKHLX = "JYDFZKHLX";

	public static final String JYDFZJHM = "JYDFZJHM";

	public static final String JYDSYE = "JYDSYE";

	public static final String JYDFZHKHH = "JYDFZHKHH";

	public static final String JYZY = "JYZY";

	public static final String JYWDMC = "JYWDMC";

	public static final String JYWDDM = "JYWDDM";

	public static final String RZH = "RZH";

	public static final String CPH = "CPH";

	public static final String PZZL = "PZZL";

	public static final String PZH = "PZH";

	public static final String XJBZ = "XJBZ";

	public static final String ZDH = "ZDH";

	public static final String JYSFCG = "JYSFCG";

	public static final String JYFSD = "JYFSD";

	public static final String SHMC = "SHMC";

	public static final String SHH = "SHH";

	public static final String IP = "IP";

	public static final String MAC = "MAC";

	public static final String JYGYH = "JYGYH";

	public static final String BEIZ = "BEIZ";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MpsRespTransaction{" +
			", reqBasicInfoId=" + reqBasicInfoId +
			", reqType=" + reqType +
			", rwlsh=" + rwlsh +
			", cxfkjg=" + cxfkjg +
			", cxfkjgyy=" + cxfkjgyy +
			", cxzh=" + cxzh +
			", cxkh=" + cxkh +
			", jylx=" + jylx +
			", jdbz=" + jdbz +
			", bz=" + bz +
			", je=" + je +
			", ye=" + ye +
			", jysj=" + jysj +
			", jylsh=" + jylsh +
			", jydfxm=" + jydfxm +
			", jydfzkh=" + jydfzkh +
			", jydfzkhlx=" + jydfzkhlx +
			", jydfzjhm=" + jydfzjhm +
			", jydsye=" + jydsye +
			", jydfzhkhh=" + jydfzhkhh +
			", jyzy=" + jyzy +
			", jywdmc=" + jywdmc +
			", jywddm=" + jywddm +
			", rzh=" + rzh +
			", cph=" + cph +
			", pzzl=" + pzzl +
			", pzh=" + pzh +
			", xjbz=" + xjbz +
			", zdh=" + zdh +
			", jysfcg=" + jysfcg +
			", jyfsd=" + jyfsd +
			", shmc=" + shmc +
			", shh=" + shh +
			", ip=" + ip +
			", mac=" + mac +
			", jygyh=" + jygyh +
			", beiz=" + beiz +
			"}";
	}
}
