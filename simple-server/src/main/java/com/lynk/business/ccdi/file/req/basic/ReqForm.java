package com.lynk.business.ccdi.file.req.basic;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@Accessors(chain = true)
@XmlRootElement(name = "QUERYFORM")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqForm {
    @XmlElement(name = "BASICINFO")
    private BasicInfo basicInfo;

    @XmlElement(name = "QUERYPERSON")
    private QueryPerson queryPerson;

    private List<ReqBiz> reqBizs;
}
