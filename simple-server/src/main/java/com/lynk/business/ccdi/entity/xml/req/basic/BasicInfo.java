package com.lynk.business.ccdi.entity.xml.req.basic;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@Accessors(chain = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class BasicInfo implements ReqConvertible {
    @XmlAttribute(name = "QQDBS")
    private String qqdbs;
    @XmlAttribute(name = "QQCSLX")
    private String qqcslx;
    @XmlAttribute(name = "SQJGDM")
    private String sqjgdm;
    @XmlAttribute(name = "SQJGMC")
    private String sqjgmc;
    @XmlAttribute(name = "MBJGDM")
    private String mbjgdm;
    @XmlAttribute(name = "ZTLB")
    private String ztlb;
    @XmlAttribute(name = "AJLX")
    private String ajlx;
    @XmlAttribute(name = "JJCD")
    private String jjcd;
    @XmlAttribute(name = "BEIZ")
    private String beiz;
    @XmlAttribute(name = "FSSJ")
    private String fssj;
    @XmlAttribute(name = "FLWSH")
    private String flwsh;
}
