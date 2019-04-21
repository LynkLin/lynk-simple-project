package com.lynk.business.ccdi.file.req.ss0506;

import com.lynk.business.ccdi.file.req.basic.ReqBiz;
import com.lynk.business.ccdi.file.req.basic.ReqForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@XmlRootElement(name = "QUERYFORM")
@XmlAccessorType(XmlAccessType.FIELD)
public class Ss0506Form extends ReqForm {
    @XmlElementWrapper(name = "QUERYACCOUNTS")
    @XmlElement(name = "QUERYACCOUNT")
    private List<ReqBiz> reqBizs;
}
