package com.lynk.business.ccdi.file.req;

import com.lynk.business.ccdi.file.req.basic.ReqBiz;
import com.lynk.business.ccdi.file.req.basic.ReqForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author Lynk @ 2019/04/29
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@XmlRootElement(name = "FREEZEFORM")
@XmlAccessorType(XmlAccessType.FIELD)
public class Ss1718Form extends ReqForm {
    @XmlElementWrapper(name = "FREEZEACCOUNTS")
    @XmlElement(name = "FREEZEACCOUNT")
    private List<@Valid ReqBiz> reqBizs;
}
