package com.lynk.business.ccdi.file.resp.rr28;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@Accessors(chain = true)
@XmlRootElement(name = "RETURNRECEIPTS")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rr28Form {
    @XmlElementWrapper(name = "RETURNRECEIPTS")
    @XmlElement(name = "RETURNRECEIPT")
    private List<Rr28Main> rr28Mains;
}
