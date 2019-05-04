package com.lynk.business.ccdi.file.req.basic;

import com.lynk.system.common.Base64Util;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author Lynk @ 2019/5/1
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
public class BasicInfo {

    @Size(max = 30, message = "请求单标识超长")
    private String qqdbs;

    @Size(max = 2, message = "请求措施类型超长")
    private String qqcslx;

    @Size(max = 20, message = "申请机构代码超长")
    private String sqjgdm;

    @Size(max = 50, message = "申请机构名称超长")
    private String sqjgmc;

    @Size(max = 20, message = "目标机构代码超长")
    private String mbjgdm;

    @Size(max = 2, message = "查控主体类别超长")
    private String ztlb;

    @Size(max = 50, message = "案件类型超长")
    private String ajlx;

    @Size(max = 2, message = "紧急程度超长")
    private String jjcd;

    @Size(max = 200, message = "备注超长")
    private String beiz;

    @Size(max = 14, message = "发送时间超长")
    private String fssj;

    @Size(max = 50, message = "法律文书号超长")
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
