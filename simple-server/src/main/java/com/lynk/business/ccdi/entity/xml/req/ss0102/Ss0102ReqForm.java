package com.lynk.business.ccdi.entity.xml.req.ss0102;

import com.lynk.business.ccdi.entity.xml.req.basic.ReqConvertible;
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
public class Ss0102ReqForm implements ReqConvertible {
    @XmlElement(name = "BASICINFO")
    private BasicInfo basicInfo;

    @XmlElement(name = "QUERYPERSON")
    private QueryPerson queryPerson;

    @XmlElementWrapper(name = "QUERYMAINS")
    @XmlElement(name = "QUERYMAIN")
    private List<Ss0102Main> ss0102Mains;
}
