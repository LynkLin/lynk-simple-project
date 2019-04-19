package com.lynk.business.ccdi.entity.xml.req.basic;

import com.lynk.system.common.Base64Util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.PROPERTY)
public class QueryPerson {

    private String qqrxm;

    private String qqrzjlx;

    private String qqrzjhm;
    private String qqrdwmc;

    private String qqrsjh;

    private String xcrxm;

    private String xcrzjlx;

    private String xcrzjhm;

    public String getQqrxm() {
        return qqrxm;
    }

    @XmlAttribute(name = "QQRXM")
    public void setQqrxm(String qqrxm) {
        this.qqrxm = Base64Util.decode(qqrxm);
    }

    public String getQqrzjlx() {
        return qqrzjlx;
    }

    @XmlAttribute(name = "QQRZJLX")
    public void setQqrzjlx(String qqrzjlx) {
        this.qqrzjlx = Base64Util.decode(qqrzjlx);
    }

    public String getQqrzjhm() {
        return qqrzjhm;
    }

    @XmlAttribute(name = "QQRZJHM")
    public void setQqrzjhm(String qqrzjhm) {
        this.qqrzjhm = Base64Util.decode(qqrzjhm);
    }

    public String getQqrdwmc() {
        return qqrdwmc;
    }

    @XmlAttribute(name = "QQRDWMC")
    public void setQqrdwmc(String qqrdwmc) {
        this.qqrdwmc = Base64Util.decode(qqrdwmc);
    }

    public String getQqrsjh() {
        return qqrsjh;
    }

    @XmlAttribute(name = "QQRSJH")
    public void setQqrsjh(String qqrsjh) {
        this.qqrsjh = Base64Util.decode(qqrsjh);
    }

    public String getXcrxm() {
        return xcrxm;
    }

    @XmlAttribute(name = "XCRXM")
    public void setXcrxm(String xcrxm) {
        this.xcrxm = Base64Util.decode(xcrxm);
    }

    public String getXcrzjlx() {
        return xcrzjlx;
    }

    @XmlAttribute(name = "XCRZJLX")
    public void setXcrzjlx(String xcrzjlx) {
        this.xcrzjlx = Base64Util.decode(xcrzjlx);
    }

    public String getXcrzjhm() {
        return xcrzjhm;
    }

    @XmlAttribute(name = "XCRZJHM")
    public void setXcrzjhm(String xcrzjhm) {
        this.xcrzjhm = Base64Util.decode(xcrzjhm);
    }
}
