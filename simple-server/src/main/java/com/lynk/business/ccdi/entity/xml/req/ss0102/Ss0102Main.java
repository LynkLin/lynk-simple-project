package com.lynk.business.ccdi.entity.xml.req.ss0102;

import com.lynk.system.common.Base64Util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.PROPERTY)
public class Ss0102Main {

    private String rwlsh;

    private String zzlxdm;

    private String zzhm;

    private String ztmc;

    private String cxnr;

    private String mxsdlx;

    private String mxqssj;

    private String mxjzsj;

    public String getRwlsh() {
        return rwlsh;
    }

    @XmlAttribute(name = "RWLSH")
    public void setRwlsh(String rwlsh) {
        this.rwlsh = Base64Util.decode(rwlsh);
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

    public String getMxjzsj() {
        return mxjzsj;
    }

    @XmlAttribute(name = "MXJZSJ")
    public void setMxjzsj(String mxjzsj) {
        this.mxjzsj = Base64Util.decode(mxjzsj);
    }
}
