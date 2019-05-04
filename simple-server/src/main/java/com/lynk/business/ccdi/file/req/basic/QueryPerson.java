package com.lynk.business.ccdi.file.req.basic;

import com.lynk.system.common.Base64Util;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.PROPERTY)
public class QueryPerson {

    @Size(max = 20, message = "请求人姓名超长")
    private String qqrxm;

    @Size(max = 20, message = "请求人证件类型超长")
    private String qqrzjlx;

    @Size(max = 10, message = "请求人证件号码超长")
    private String qqrzjhm;

    @Size(max = 100, message = "请求人单位名称超长")
    private String qqrdwmc;

    @Size(max = 30, message = "请求人手机号超长")
    private String qqrsjh;

    @Size(max = 20, message = "协查人姓名超长")
    private String xcrxm;

    @Size(max = 20, message = "协查人证件类型超长")
    private String xcrzjlx;

    @Size(max = 8, message = "协查人证件号码超长")
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
