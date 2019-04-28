package com.lynk.business.ccdi.file.req;

import com.lynk.business.ccdi.common.Constant;
import com.lynk.business.ccdi.entity.ReqBasic;
import com.lynk.business.ccdi.entity.ReqMain;
import com.lynk.business.ccdi.entity.ReqPerson;
import com.lynk.business.ccdi.file.req.basic.BasicInfo;
import com.lynk.business.ccdi.file.req.basic.QueryPerson;
import com.lynk.business.ccdi.file.req.basic.ReqBiz;
import com.lynk.business.ccdi.file.req.basic.ReqForm;
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
    public <T extends ReqForm> T parseReqXmlFile(String filePath, Class<T> clz) {
        File file = new File(filePath);
        if (!file.exists() || clz == null) {
            return null;
        }
        return JAXB.unmarshal(file, clz);
    }

    public <T extends ReqForm> T parseReqXmlFile(File xmlFile, Class<T> clz) {
        if (!xmlFile.exists() || clz == null) {
            return null;
        }
        return JAXB.unmarshal(xmlFile, clz);
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

    /**
     *
     * @param fldm
     * @param reqForm
     * @return
     */
    public List<ReqMain> parse2ReqMain(String fldm, ReqForm reqForm) {
        List<ReqBiz> reqBizs = reqForm.getReqBizs();
        List<ReqMain> reqMains = new ArrayList<>(reqBizs.size());

        for (ReqBiz reqBiz: reqBizs) {
            ReqMain reqMain = new ReqMain();
            BeanUtils.copyProperties(reqBiz, reqMain);

            if (Constant.FLDM_GROUP_REQ_IDENT.contains(fldm)) {
                reqMain.setKssj(reqBiz.getMxqssj());
                reqMain.setJssj(reqBiz.getMxjzsj());
            }

            if (Constant.FLDM_GROUP_REQ_ACCOUNT.contains(fldm)) {
                reqMain.setZh(reqBiz.getCxzh());
                reqMain.setKssj(reqBiz.getMxqssj());
                reqMain.setJssj(reqBiz.getMxjzsj());
            }

            if (Constant.FLDM_GROUP_REQ_FREEZE.contains(fldm)) {
                reqMain.setZtmc(reqBiz.getDjzhhz());
            }

            if (Constant.FLDM_GROUP_REQ_CERT.contains(fldm)) {
                reqMain.setZh(reqBiz.getCxzh());
            }

            if (Constant.FLDM_GROUP_REQ_PHONE.contains(fldm)) {
                reqMain.setZh(reqBiz.getCxzh());
                reqMain.setKssj(reqBiz.getMxqssj());
                reqMain.setJssj(reqBiz.getMxjzsj());
            }
            /*
            if (ValidateUtil.isEmpty(reqMain.getZh())) {
                reqMain.setZh(reqBiz.getCxzh());
            }

            if (ValidateUtil.isEmpty(reqMain.getZtmc())) {

            }

            if (ValidateUtil.isEmpty(reqMain.getKssj())) {
                reqMain.setKssj(reqBiz.getMxqssj());
            }

            if (ValidateUtil.isEmpty(reqMain.getJssj())) {
                reqMain.setJssj(reqBiz.getMxjzsj());
            }*/
            reqMain.setFldm(fldm);
            reqMains.add(reqMain);
        }
        return reqMains;
    }
}
