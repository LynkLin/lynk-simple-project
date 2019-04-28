package com.lynk.business.ccdi.file.req;

import com.lynk.business.ccdi.file.req.basic.ReqBiz;
import com.lynk.business.ccdi.file.req.basic.ReqForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author Lynk @ 2019/04/29
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@XmlRootElement(name = "CONTROLFORM")
@XmlAccessorType(XmlAccessType.FIELD)
public class Ss1112Form extends ReqForm {
    @XmlElementWrapper(name = "CONTROLACCOUNTS")
    @XmlElement(name = "CONTROLACCOUNT")
    private List<ReqBiz> reqBizs;
}
