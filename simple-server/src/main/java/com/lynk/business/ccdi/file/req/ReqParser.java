package com.lynk.business.ccdi.file.req;

import com.lynk.business.ccdi.entity.ReqBasic;
import com.lynk.business.ccdi.entity.ReqMain;
import com.lynk.business.ccdi.entity.ReqPerson;
import com.lynk.business.ccdi.file.req.basic.BasicInfo;
import com.lynk.business.ccdi.file.req.basic.QueryPerson;
import com.lynk.business.ccdi.file.req.basic.ReqBiz;
import com.lynk.business.ccdi.file.req.basic.ReqForm;
import com.lynk.system.common.ValidateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXB;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lynk @ 2019/4/20
 */
@Component
public class ReqParser {
    public <T> T parseReqXmlFile(String filePath, Class<T> clz) {
        File file = new File(filePath);
        if (!file.exists()) {
            return null;
        }
        T t = JAXB.unmarshal(file, clz);
        return t;
    }

    public ReqBasic parse2ReqBasic(ReqForm reqForm) {
        BasicInfo basicInfo = reqForm.getBasicInfo();
        ReqBasic reqBasic = new ReqBasic();
        BeanUtils.copyProperties(basicInfo, reqBasic);
        return reqBasic;
    }

    public ReqPerson parse2ReqPerson(ReqForm reqForm) {
        QueryPerson queryPerson = reqForm.getQueryPerson();
        ReqPerson reqPerson = new ReqPerson();
        BeanUtils.copyProperties(queryPerson, reqPerson);
        return reqPerson;
    }

    public List<ReqMain> parse2ReqMain(ReqForm reqForm) {
        List<ReqBiz> reqBizs = reqForm.getReqBizs();
        List<ReqMain> reqMains = new ArrayList<>(reqBizs.size());

        for (ReqBiz reqBiz: reqBizs) {
            ReqMain reqMain = new ReqMain();
            BeanUtils.copyProperties(reqBiz, reqMain);

            if (ValidateUtil.isEmpty(reqMain.getZh())) {
                reqMain.setZh(reqBiz.getCxzh());
            }

            if (ValidateUtil.isEmpty(reqMain.getZtmc())) {
                reqMain.setZtmc(reqBiz.getDjzhhz());
            }

            if (ValidateUtil.isEmpty(reqMain.getKssj())) {
                reqMain.setKssj(reqBiz.getMxqssj());
            }

            if (ValidateUtil.isEmpty(reqMain.getJssj())) {
                reqMain.setJssj(reqBiz.getMxjzsj());
            }
            reqMains.add(reqMain);
        }
        return reqMains;
    }
}
