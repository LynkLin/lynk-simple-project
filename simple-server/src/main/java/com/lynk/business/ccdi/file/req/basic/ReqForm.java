package com.lynk.business.ccdi.file.req.basic;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@Accessors(chain = true)
@XmlRootElement(name = "QUERYFORM")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqForm {
    @Valid
    @XmlElement(name = "BASICINFO")
    private BasicInfo basicInfo;

    @Valid
    @XmlElement(name = "QUERYPERSON")
    private QueryPerson queryPerson;

    private List<@Valid ReqBiz> reqBizs;
}
