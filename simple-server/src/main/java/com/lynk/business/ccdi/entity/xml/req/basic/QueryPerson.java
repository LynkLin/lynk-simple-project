package com.lynk.business.ccdi.entity.xml.req.basic;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@Accessors(chain = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class QueryPerson {
    @XmlAttribute(name = "QQRXM")
    private String qqrxm;
    @XmlAttribute(name = "QQRZJLX")
    private String qqrzjlx;
    @XmlAttribute(name = "QQRZJHM")
    private String qqrzjhm;
    @XmlAttribute(name = "QQRDWMC")
    private String qqrdwmc;
    @XmlAttribute(name = "QQRSJH")
    private String qqrsjh;
    @XmlAttribute(name = "XCRXM")
    private String xcrxm;
    @XmlAttribute(name = "XCRZJLX")
    private String xcrzjlx;
    @XmlAttribute(name = "XCRZJHM")
    private String xcrzjhm;
}
