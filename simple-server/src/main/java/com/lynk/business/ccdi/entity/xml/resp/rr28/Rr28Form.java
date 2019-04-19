package com.lynk.business.ccdi.entity.xml.resp.rr28;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "RETURNRECEIPTS")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rr28Form {
    @XmlElementWrapper(name = "RETURNRECEIPTS")
    @XmlElement(name = "RETURNRECEIPT")
    private List<Rr28Main> rr28Mains;
}
