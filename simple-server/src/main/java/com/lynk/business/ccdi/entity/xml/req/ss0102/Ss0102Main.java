package com.lynk.business.ccdi.entity.xml.req.ss0102;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@Accessors(chain = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class Ss0102Main {
    @XmlAttribute(name = "RWLSH")
    private String rwlsh;
    @XmlAttribute(name = "ZZLXDM")
    private String zzlxdm;
    @XmlAttribute(name = "ZZHM")
    private String zzhm;
    @XmlAttribute(name = "ZTMC")
    private String ztmc;
    @XmlAttribute(name = "CXNR")
    private String cxnr;
    @XmlAttribute(name = "MXSDLX")
    private String mxsdlx;
    @XmlAttribute(name = "MXQSSJ")
    private String mxqssj;
    @XmlAttribute(name = "MXJZSJ")
    private String mxjzsj;
}
