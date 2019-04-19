package com.lynk.business.ccdi.entity.xml.req.ss0506;

import com.lynk.business.ccdi.entity.xml.req.basic.BasicInfo;
import com.lynk.business.ccdi.entity.xml.req.basic.QueryPerson;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@Accessors(chain = true)
@XmlRootElement(name = "QUERYFORM")
@XmlAccessorType(XmlAccessType.FIELD)
public class Ss0506Form {
    @XmlElement(name = "BASICINFO")
    private BasicInfo basicInfo;

    @XmlElement(name = "QUERYPERSON")
    private QueryPerson queryPerson;

    @XmlElementWrapper(name = "QUERYACCOUNTS")
    @XmlElement(name = "QUERYACCOUNT")
    private List<Ss0506Main> ss0506Mains;
}
