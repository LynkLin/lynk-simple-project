package com.lynk.business.ccdi.file.req;

import com.lynk.business.ccdi.file.req.basic.ReqForm;
import com.lynk.business.ccdi.file.req.basic.ReqBiz;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author Lynk @ 2019/04/27
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@XmlRootElement(name = "QUERYFORM")
@XmlAccessorType(XmlAccessType.FIELD)
public class Ss0102Form extends ReqForm {
    @XmlElementWrapper(name = "QUERYMAINS")
    @XmlElement(name = "QUERYMAIN")
    private List<@Valid ReqBiz> reqBizs;
}
