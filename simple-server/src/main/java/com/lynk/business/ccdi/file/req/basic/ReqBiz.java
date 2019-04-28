package com.lynk.business.ccdi.file.req.basic;

import com.lynk.system.common.Base64Util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author Lynk @ 2019/04/21
 */

@XmlAccessorType(XmlAccessType.PROPERTY)
public class ReqBiz {
    private String rwlsh;

    private String zh;

    private String cxzh;

    private String sjhm;

    private String zzlxdm;

    private String zzhm;

    private String ztmc;

    private String djzhhz;

    private String cxnr;

    private String mxsdlx;

    private String mxqssj;

    private String kssj;

    private String mxjzsj;

    private String jssj;

    private String yrwlsh;

    private String zxsjqj;

    private String zhxh;

    private String djfs;

    private String je;

    private String bz;

    private String cxzl;

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
        this.cxzh = cxzh;
    }

    public String getSjhm() {
        return sjhm;
    }

    @XmlAttribute(name = "SJHM")
    public void setSjhm(String sjhm) {
        this.sjhm = sjhm;
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
        this.djzhhz = djzhhz;
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
        this.kssj = kssj;
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
        this.jssj = jssj;
    }

    public String getYrwlsh() {
        return yrwlsh;
    }

    @XmlAttribute(name = "YRWLSH")
    public void setYrwlsh(String yrwlsh) {
        this.yrwlsh = yrwlsh;
    }

    public String getZxsjqj() {
        return zxsjqj;
    }

    @XmlAttribute(name = "ZXSJQJ")
    public void setZxsjqj(String zxsjqj) {
        this.zxsjqj = zxsjqj;
    }

    public String getZhxh() {
        return zhxh;
    }

    @XmlAttribute(name = "ZHXH")
    public void setZhxh(String zhxh) {
        this.zhxh = zhxh;
    }

    public String getDjfs() {
        return djfs;
    }

    @XmlAttribute(name = "DJFS")
    public void setDjfs(String djfs) {
        this.djfs = djfs;
    }

    public String getJe() {
        return je;
    }

    @XmlAttribute(name = "JE")
    public void setJe(String je) {
        this.je = je;
    }

    public String getBz() {
        return bz;
    }

    @XmlAttribute(name = "BZ")
    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getCxzl() {
        return cxzl;
    }

    @XmlAttribute(name = "CXZL")
    public void setCxzl(String cxzl) {
        this.cxzl = cxzl;
    }

    public String getJylsh() {
        return jylsh;
    }

    @XmlAttribute(name = "JYLSH")
    public void setJylsh(String jylsh) {
        this.jylsh = jylsh;
    }
}
