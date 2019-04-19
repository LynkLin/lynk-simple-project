package com.lynk.business.ccdi.entity.xml.req.ss0506;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@Accessors(chain = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class Ss0506Main {
    @XmlAttribute(name = "RWLSH")
    private String rwlsh;
    @XmlAttribute(name = "CXZH")
    private String CXZH;
    @XmlAttribute(name = "CXNR")
    private String cxnr;
    @XmlAttribute(name = "MXSDLX")
    private String mxsdlx;
    @XmlAttribute(name = "MXQSSJ")
    private String mxqssj;
    @XmlAttribute(name = "MXJZSJ")
    private String mxjzsj;
}
