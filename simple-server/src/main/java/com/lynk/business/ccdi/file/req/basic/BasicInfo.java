package com.lynk.business.ccdi.file.req.basic;

import com.lynk.system.common.Base64Util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.PROPERTY)
public class BasicInfo {

    private String qqdbs;

    private String qqcslx;

    private String sqjgdm;

    private String sqjgmc;

    private String mbjgdm;

    private String ztlb;

    private String ajlx;

    private String jjcd;

    private String beiz;

    private String fssj;

    private String flwsh;

    public String getQqdbs() {
        return qqdbs;
    }

    @XmlAttribute(name = "QQDBS")
    public void setQqdbs(String qqdbs) {
        this.qqdbs = Base64Util.decode(qqdbs);
    }

    public String getQqcslx() {
        return qqcslx;
    }

    @XmlAttribute(name = "QQCSLX")
    public void setQqcslx(String qqcslx) {
        this.qqcslx = Base64Util.decode(qqcslx);
    }

    public String getSqjgdm() {
        return sqjgdm;
    }

    @XmlAttribute(name = "SQJGDM")
    public void setSqjgdm(String sqjgdm) {
        this.sqjgdm = Base64Util.decode(sqjgdm);
    }

    public String getSqjgmc() {
        return sqjgmc;
    }

    @XmlAttribute(name = "SQJGMC")
    public void setSqjgmc(String sqjgmc) {
        this.sqjgmc = Base64Util.decode(sqjgmc);
    }

    public String getMbjgdm() {
        return mbjgdm;
    }

    @XmlAttribute(name = "MBJGDM")
    public void setMbjgdm(String mbjgdm) {
        this.mbjgdm = Base64Util.decode(mbjgdm);
    }

    public String getZtlb() {
        return ztlb;
    }

    @XmlAttribute(name = "ZTLB")
    public void setZtlb(String ztlb) {
        this.ztlb = Base64Util.decode(ztlb);
    }

    public String getAjlx() {
        return ajlx;
    }

    @XmlAttribute(name = "AJLX")
    public void setAjlx(String ajlx) {
        this.ajlx = Base64Util.decode(ajlx);
    }

    public String getJjcd() {
        return jjcd;
    }

    @XmlAttribute(name = "JJCD")
    public void setJjcd(String jjcd) {
        this.jjcd = Base64Util.decode(jjcd);
    }

    public String getBeiz() {
        return beiz;
    }

    @XmlAttribute(name = "BEIZ")
    public void setBeiz(String beiz) {
        this.beiz = Base64Util.decode(beiz);
    }

    public String getFssj() {
        return fssj;
    }

    @XmlAttribute(name = "FSSJ")
    public void setFssj(String fssj) {
        this.fssj = Base64Util.decode(fssj);
    }

    public String getFlwsh() {
        return flwsh;
    }

    @XmlAttribute(name = "FLWSH")
    public void setFlwsh(String flwsh) {
        this.flwsh = Base64Util.decode(flwsh);
    }
}
