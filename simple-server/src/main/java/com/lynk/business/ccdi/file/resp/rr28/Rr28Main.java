package com.lynk.business.ccdi.file.resp.rr28;

import com.lynk.system.common.Base64Util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Rr28Main {

    private String qqdbs;

    private String sqjgdm;

    private String mbjgdm;

    private String hzdm;

    private String jssj;

    private String hzsm;

    @XmlAttribute(name = "QQDBS")
    public String getQqdbs() {
        return Base64Util.encode(qqdbs);
    }

    public void setQqdbs(String qqdbs) {
        this.qqdbs = qqdbs;
    }

    @XmlAttribute(name = "SQJGDM")
    public String getSqjgdm() {
        return Base64Util.encode(sqjgdm);
    }

    public void setSqjgdm(String sqjgdm) {
        this.sqjgdm = sqjgdm;
    }

    @XmlAttribute(name = "MBJGDM")
    public String getMbjgdm() {
        return Base64Util.encode(mbjgdm);
    }

    public void setMbjgdm(String mbjgdm) {
        this.mbjgdm = mbjgdm;
    }

    @XmlAttribute(name = "HZDM")
    public String getHzdm() {
        return Base64Util.encode(hzdm);
    }

    public void setHzdm(String hzdm) {
        this.hzdm = hzdm;
    }

    @XmlAttribute(name = "JSSJ")
    public String getJssj() {
        return Base64Util.encode(jssj);
    }

    public void setJssj(String jssj) {
        this.jssj = jssj;
    }

    @XmlAttribute(name = "HZSM")
    public String getHzsm() {
        return Base64Util.encode(hzsm);
    }

    public void setHzsm(String hzsm) {
        this.hzsm = hzsm;
    }
}
