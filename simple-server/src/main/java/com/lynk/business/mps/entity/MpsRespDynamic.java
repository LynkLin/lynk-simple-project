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
@TableName("MPS_RESP_DYNAMIC")
public class MpsRespDynamic extends SystemBaseEntity<MpsRespDynamic> {

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
	@TableField("ZHMC")
	private String zhmc;
	@TableField("ZHBZ")
	private String zhbz;
	@TableField("ZHDYKH")
	private String zhdykh;
	@TableField("JYCZ")
	private String jycz;
	@TableField("CZSJ")
	private String czsj;
	@TableField("JYDD")
	private String jydd;
	@TableField("AJLX")
	private String ajlx;
	@TableField("JYJE")
	private String jyje;
	@TableField("JDBZ")
	private String jdbz;
	@TableField("JYBZ")
	private String jybz;
	@TableField("ZHXYED")
	private String zhxyed;
	@TableField("KHZJLX")
	private String khzjlx;
	@TableField("KHZJHM")
	private String khzjhm;
	@TableField("JYDFZKH")
	private String jydfzkh;
	@TableField("JYDFZKHLX")
	private String jydfzkhlx;
	@TableField("DFZHMC")
	private String dfzhmc;
	@TableField("DFZHBZ")
	private String dfzhbz;
	@TableField("PZZL")
	private String pzzl;
	@TableField("PZH")
	private String pzh;
	@TableField("XJBZ")
	private String xjbz;
	@TableField("FWJM")
	private String fwjm;
	@TableField("ZDH")
	private String zdh;
	@TableField("KYXQ")
	private String kyxq;
	@TableField("JYLXYHK")
	private String jylxyhk;
	@TableField("JYLXGJK")
	private String jylxgjk;
	@TableField("SHH")
	private String shh;
	@TableField("SHMC")
	private String shmc;
	@TableField("WDMS")
	private String wdms;
	@TableField("WDDZ")
	private String wddz;
	@TableField("WDDH")
	private String wddh;
	@TableField("GYH")
	private String gyh;
	@TableField("SQGYH")
	private String sqgyh;
	@TableField("JYDM")
	private String jydm;
	@TableField("FJYBZ")
	private String fjybz;
	@TableField("CZJYBS")
	private String czjybs;


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

	public String getZhmc() {
		return zhmc;
	}

	public void setZhmc(String zhmc) {
		this.zhmc = zhmc;
	}

	public String getZhbz() {
		return zhbz;
	}

	public void setZhbz(String zhbz) {
		this.zhbz = zhbz;
	}

	public String getZhdykh() {
		return zhdykh;
	}

	public void setZhdykh(String zhdykh) {
		this.zhdykh = zhdykh;
	}

	public String getJycz() {
		return jycz;
	}

	public void setJycz(String jycz) {
		this.jycz = jycz;
	}

	public String getCzsj() {
		return czsj;
	}

	public void setCzsj(String czsj) {
		this.czsj = czsj;
	}

	public String getJydd() {
		return jydd;
	}

	public void setJydd(String jydd) {
		this.jydd = jydd;
	}

	public String getAjlx() {
		return ajlx;
	}

	public void setAjlx(String ajlx) {
		this.ajlx = ajlx;
	}

	public String getJyje() {
		return jyje;
	}

	public void setJyje(String jyje) {
		this.jyje = jyje;
	}

	public String getJdbz() {
		return jdbz;
	}

	public void setJdbz(String jdbz) {
		this.jdbz = jdbz;
	}

	public String getJybz() {
		return jybz;
	}

	public void setJybz(String jybz) {
		this.jybz = jybz;
	}

	public String getZhxyed() {
		return zhxyed;
	}

	public void setZhxyed(String zhxyed) {
		this.zhxyed = zhxyed;
	}

	public String getKhzjlx() {
		return khzjlx;
	}

	public void setKhzjlx(String khzjlx) {
		this.khzjlx = khzjlx;
	}

	public String getKhzjhm() {
		return khzjhm;
	}

	public void setKhzjhm(String khzjhm) {
		this.khzjhm = khzjhm;
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

	public String getDfzhmc() {
		return dfzhmc;
	}

	public void setDfzhmc(String dfzhmc) {
		this.dfzhmc = dfzhmc;
	}

	public String getDfzhbz() {
		return dfzhbz;
	}

	public void setDfzhbz(String dfzhbz) {
		this.dfzhbz = dfzhbz;
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

	public String getFwjm() {
		return fwjm;
	}

	public void setFwjm(String fwjm) {
		this.fwjm = fwjm;
	}

	public String getZdh() {
		return zdh;
	}

	public void setZdh(String zdh) {
		this.zdh = zdh;
	}

	public String getKyxq() {
		return kyxq;
	}

	public void setKyxq(String kyxq) {
		this.kyxq = kyxq;
	}

	public String getJylxyhk() {
		return jylxyhk;
	}

	public void setJylxyhk(String jylxyhk) {
		this.jylxyhk = jylxyhk;
	}

	public String getJylxgjk() {
		return jylxgjk;
	}

	public void setJylxgjk(String jylxgjk) {
		this.jylxgjk = jylxgjk;
	}

	public String getShh() {
		return shh;
	}

	public void setShh(String shh) {
		this.shh = shh;
	}

	public String getShmc() {
		return shmc;
	}

	public void setShmc(String shmc) {
		this.shmc = shmc;
	}

	public String getWdms() {
		return wdms;
	}

	public void setWdms(String wdms) {
		this.wdms = wdms;
	}

	public String getWddz() {
		return wddz;
	}

	public void setWddz(String wddz) {
		this.wddz = wddz;
	}

	public String getWddh() {
		return wddh;
	}

	public void setWddh(String wddh) {
		this.wddh = wddh;
	}

	public String getGyh() {
		return gyh;
	}

	public void setGyh(String gyh) {
		this.gyh = gyh;
	}

	public String getSqgyh() {
		return sqgyh;
	}

	public void setSqgyh(String sqgyh) {
		this.sqgyh = sqgyh;
	}

	public String getJydm() {
		return jydm;
	}

	public void setJydm(String jydm) {
		this.jydm = jydm;
	}

	public String getFjybz() {
		return fjybz;
	}

	public void setFjybz(String fjybz) {
		this.fjybz = fjybz;
	}

	public String getCzjybs() {
		return czjybs;
	}

	public void setCzjybs(String czjybs) {
		this.czjybs = czjybs;
	}

	public static final String REQ_BASIC_INFO_ID = "REQ_BASIC_INFO_ID";

	public static final String REQ_TYPE = "REQ_TYPE";

	public static final String RWLSH = "RWLSH";

	public static final String ZH = "ZH";

	public static final String KH = "KH";

	public static final String ZHMC = "ZHMC";

	public static final String ZHBZ = "ZHBZ";

	public static final String ZHDYKH = "ZHDYKH";

	public static final String JYCZ = "JYCZ";

	public static final String CZSJ = "CZSJ";

	public static final String JYDD = "JYDD";

	public static final String AJLX = "AJLX";

	public static final String JYJE = "JYJE";

	public static final String JDBZ = "JDBZ";

	public static final String JYBZ = "JYBZ";

	public static final String ZHXYED = "ZHXYED";

	public static final String KHZJLX = "KHZJLX";

	public static final String KHZJHM = "KHZJHM";

	public static final String JYDFZKH = "JYDFZKH";

	public static final String JYDFZKHLX = "JYDFZKHLX";

	public static final String DFZHMC = "DFZHMC";

	public static final String DFZHBZ = "DFZHBZ";

	public static final String PZZL = "PZZL";

	public static final String PZH = "PZH";

	public static final String XJBZ = "XJBZ";

	public static final String FWJM = "FWJM";

	public static final String ZDH = "ZDH";

	public static final String KYXQ = "KYXQ";

	public static final String JYLXYHK = "JYLXYHK";

	public static final String JYLXGJK = "JYLXGJK";

	public static final String SHH = "SHH";

	public static final String SHMC = "SHMC";

	public static final String WDMS = "WDMS";

	public static final String WDDZ = "WDDZ";

	public static final String WDDH = "WDDH";

	public static final String GYH = "GYH";

	public static final String SQGYH = "SQGYH";

	public static final String JYDM = "JYDM";

	public static final String FJYBZ = "FJYBZ";

	public static final String CZJYBS = "CZJYBS";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MpsRespDynamic{" +
			", reqBasicInfoId=" + reqBasicInfoId +
			", reqType=" + reqType +
			", rwlsh=" + rwlsh +
			", zh=" + zh +
			", kh=" + kh +
			", zhmc=" + zhmc +
			", zhbz=" + zhbz +
			", zhdykh=" + zhdykh +
			", jycz=" + jycz +
			", czsj=" + czsj +
			", jydd=" + jydd +
			", ajlx=" + ajlx +
			", jyje=" + jyje +
			", jdbz=" + jdbz +
			", jybz=" + jybz +
			", zhxyed=" + zhxyed +
			", khzjlx=" + khzjlx +
			", khzjhm=" + khzjhm +
			", jydfzkh=" + jydfzkh +
			", jydfzkhlx=" + jydfzkhlx +
			", dfzhmc=" + dfzhmc +
			", dfzhbz=" + dfzhbz +
			", pzzl=" + pzzl +
			", pzh=" + pzh +
			", xjbz=" + xjbz +
			", fwjm=" + fwjm +
			", zdh=" + zdh +
			", kyxq=" + kyxq +
			", jylxyhk=" + jylxyhk +
			", jylxgjk=" + jylxgjk +
			", shh=" + shh +
			", shmc=" + shmc +
			", wdms=" + wdms +
			", wddz=" + wddz +
			", wddh=" + wddh +
			", gyh=" + gyh +
			", sqgyh=" + sqgyh +
			", jydm=" + jydm +
			", fjybz=" + fjybz +
			", czjybs=" + czjybs +
			"}";
	}
}
