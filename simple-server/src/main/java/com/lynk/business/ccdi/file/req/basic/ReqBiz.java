package com.lynk.business.ccdi.file.req.basic;

import com.lynk.system.common.Base64Util;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author Lynk @ 2019/04/21
 */

@XmlAccessorType(XmlAccessType.PROPERTY)
public class ReqBiz {

    @Size(max = 35, message = "任务流水号超长")
    private String rwlsh;

    @Size(max = 40, message = "账卡号超长")
    private String zh;

    @Size(max = 40, message = "查询账卡号超长")
    private String cxzh;

    @Size(max = 11, message = "手机号码超长")
    private String sjhm;

    @Size(max = 15, message = "证照类型代码超长")
    private String zzlxdm;

    @Size(max = 30, message = "证照号码超长")
    private String zzhm;

    @Size(max = 100, message = "主体名称超长")
    private String ztmc;

    @Size(max = 100, message = "冻结账户户主超长")
    private String djzhhz;

    @Size(max = 2, message = "查询内容超长")
    private String cxnr;

    @Size(max = 2, message = "明细时段类型超长")
    private String mxsdlx;

    @Size(max = 8, message = "明细起始时间超长")
    private String mxqssj;

    @Size(max = 8, message = "开始时间超长")
    private String kssj;

    @Size(max = 8, message = "明细截止时间超长")
    private String mxjzsj;

    @Size(max = 8, message = "结束时间超长")
    private String jssj;

    @Size(max = 30, message = "原任务流水号超长")
    private String yrwlsh;

    @Size(max = 1, message = "执行时间区间超长")
    private String zxsjqj;

    @Size(max = 14, message = "账户序号超长")
    private String zhxh;

    @Size(max = 2, message = "冻结方式超长")
    private String djfs;

    @Size(max = 21, message = "金额超长")
    private String je;

    @Size(max = 20, message = "币种超长")
    private String bz;

    @Size(max = 2, message = "查询种类超长")
    private String cxzl;

    @Size(max = 50, message = "交易流水号超长")
    private String jylsh;

    public String getRwlsh() {
        return rwlsh;
    }

    @XmlAttribute(name = "RWLSH")
    public void setRwlsh(String rwlsh) {
        this.rwlsh = Base64Util.decode(rwlsh);
    }

    public String getZh() {
        return zh;
    }

    @XmlAttribute(name = "ZH")
    public void setZh(String zh) {
        this.zh = Base64Util.decode(zh);
    }

    public String getCxzh() {
        return cxzh;
    }

    @XmlAttribute(name = "CXZH")
    public void setCxzh(String cxzh) {
        this.cxzh = Base64Util.decode(cxzh);
    }

    public String getSjhm() {
        return sjhm;
    }

    @XmlAttribute(name = "SJHM")
    public void setSjhm(String sjhm) {
        this.sjhm = Base64Util.decode(sjhm);
    }

    public String getZzlxdm() {
        return zzlxdm;
    }

    @XmlAttribute(name = "ZZLXDM")
    public void setZzlxdm(String zzlxdm) {
        this.zzlxdm = Base64Util.decode(zzlxdm);
    }

    public String getZzhm() {
        return zzhm;
    }

    @XmlAttribute(name = "ZZHM")
    public void setZzhm(String zzhm) {
        this.zzhm = Base64Util.decode(zzhm);
    }

    public String getZtmc() {
        return ztmc;
    }

    @XmlAttribute(name = "ZTMC")
    public void setZtmc(String ztmc) {
        this.ztmc = Base64Util.decode(ztmc);
    }

    public String getDjzhhz() {
        return djzhhz;
    }

    @XmlAttribute(name = "DJZHHZ")
    public void setDjzhhz(String djzhhz) {
        this.djzhhz = Base64Util.decode(djzhhz);
    }

    public String getCxnr() {
        return cxnr;
    }

    @XmlAttribute(name = "CXNR")
    public void setCxnr(String cxnr) {
        this.cxnr = Base64Util.decode(cxnr);
    }

    public String getMxsdlx() {
        return mxsdlx;
    }

    @XmlAttribute(name = "MXSDLX")
    public void setMxsdlx(String mxsdlx) {
        this.mxsdlx = Base64Util.decode(mxsdlx);
    }

    public String getMxqssj() {
        return mxqssj;
    }

    @XmlAttribute(name = "MXQSSJ")
    public void setMxqssj(String mxqssj) {
        this.mxqssj = Base64Util.decode(mxqssj);
    }

    public String getKssj() {
        return kssj;
    }

    @XmlAttribute(name = "KSSJ")
    public void setKssj(String kssj) {
        this.kssj = Base64Util.decode(kssj);
    }

    public String getMxjzsj() {
        return mxjzsj;
    }

    @XmlAttribute(name = "MXJZSJ")
    public void setMxjzsj(String mxjzsj) {
        this.mxjzsj = Base64Util.decode(mxjzsj);
    }

    public String getJssj() {
        return jssj;
    }

    @XmlAttribute(name = "JSSJ")
    public void setJssj(String jssj) {
        this.jssj = Base64Util.decode(jssj);
    }

    public String getYrwlsh() {
        return yrwlsh;
    }

    @XmlAttribute(name = "YRWLSH")
    public void setYrwlsh(String yrwlsh) {
        this.yrwlsh = Base64Util.decode(yrwlsh);
    }

    public String getZxsjqj() {
        return zxsjqj;
    }

    @XmlAttribute(name = "ZXSJQJ")
    public void setZxsjqj(String zxsjqj) {
        this.zxsjqj = Base64Util.decode(zxsjqj);
    }

    public String getZhxh() {
        return zhxh;
    }

    @XmlAttribute(name = "ZHXH")
    public void setZhxh(String zhxh) {
        this.zhxh = Base64Util.decode(zhxh);
    }

    public String getDjfs() {
        return djfs;
    }

    @XmlAttribute(name = "DJFS")
    public void setDjfs(String djfs) {
        this.djfs = Base64Util.decode(djfs);
    }

    public String getJe() {
        return je;
    }

    @XmlAttribute(name = "JE")
    public void setJe(String je) {
        this.je = Base64Util.decode(je);
    }

    public String getBz() {
        return bz;
    }

    @XmlAttribute(name = "BZ")
    public void setBz(String bz) {
        this.bz = Base64Util.decode(bz);
    }

    public String getCxzl() {
        return cxzl;
    }

    @XmlAttribute(name = "CXZL")
    public void setCxzl(String cxzl) {
        this.cxzl = Base64Util.decode(cxzl);
    }

    public String getJylsh() {
        return jylsh;
    }

    @XmlAttribute(name = "JYLSH")
    public void setJylsh(String jylsh) {
        this.jylsh = Base64Util.decode(jylsh);
    }
}
