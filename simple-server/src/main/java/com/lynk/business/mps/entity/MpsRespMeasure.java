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
@TableName("MPS_RESP_MEASURE")
public class MpsRespMeasure extends SystemBaseEntity<MpsRespMeasure> {

    private static final long serialVersionUID = 1L;

	@TableField("REQ_BASIC_INFO_ID")
	private String reqBasicInfoId;
	@TableField("REQ_TYPE")
	private String reqType;
	@TableField("RESP_CUSTOMER_ID")
	private String respCustomerId;
	@TableField("ZH")
	private String zh;
	@TableField("CSXH")
	private String csxh;
	@TableField("DJKSRQ")
	private String djksrq;
	@TableField("DJJZRQ")
	private String djjzrq;
	@TableField("DJJGMC")
	private String djjgmc;
	@TableField("DJJE")
	private String djje;
	@TableField("BEIZ")
	private String beiz;
	@TableField("DJCSLX")
	private String djcslx;


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

	public String getCsxh() {
		return csxh;
	}

	public void setCsxh(String csxh) {
		this.csxh = csxh;
	}

	public String getDjksrq() {
		return djksrq;
	}

	public void setDjksrq(String djksrq) {
		this.djksrq = djksrq;
	}

	public String getDjjzrq() {
		return djjzrq;
	}

	public void setDjjzrq(String djjzrq) {
		this.djjzrq = djjzrq;
	}

	public String getDjjgmc() {
		return djjgmc;
	}

	public void setDjjgmc(String djjgmc) {
		this.djjgmc = djjgmc;
	}

	public String getDjje() {
		return djje;
	}

	public void setDjje(String djje) {
		this.djje = djje;
	}

	public String getBeiz() {
		return beiz;
	}

	public void setBeiz(String beiz) {
		this.beiz = beiz;
	}

	public String getDjcslx() {
		return djcslx;
	}

	public void setDjcslx(String djcslx) {
		this.djcslx = djcslx;
	}

	public static final String REQ_BASIC_INFO_ID = "REQ_BASIC_INFO_ID";

	public static final String REQ_TYPE = "REQ_TYPE";

	public static final String RESP_CUSTOMER_ID = "RESP_CUSTOMER_ID";

	public static final String ZH = "ZH";

	public static final String CSXH = "CSXH";

	public static final String DJKSRQ = "DJKSRQ";

	public static final String DJJZRQ = "DJJZRQ";

	public static final String DJJGMC = "DJJGMC";

	public static final String DJJE = "DJJE";

	public static final String BEIZ = "BEIZ";

	public static final String DJCSLX = "DJCSLX";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MpsRespMeasure{" +
			", reqBasicInfoId=" + reqBasicInfoId +
			", reqType=" + reqType +
			", respCustomerId=" + respCustomerId +
			", zh=" + zh +
			", csxh=" + csxh +
			", djksrq=" + djksrq +
			", djjzrq=" + djjzrq +
			", djjgmc=" + djjgmc +
			", djje=" + djje +
			", beiz=" + beiz +
			", djcslx=" + djcslx +
			"}";
	}
}
