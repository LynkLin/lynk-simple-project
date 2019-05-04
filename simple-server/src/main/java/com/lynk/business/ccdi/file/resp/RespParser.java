package com.lynk.business.ccdi.file.resp;

import com.lynk.business.ccdi.entity.ReqZip;
import com.lynk.business.ccdi.file.resp.rr28.Rr28Form;
import com.lynk.business.ccdi.file.resp.rr28.Rr28Main;
import com.lynk.system.common.DateUtil;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXB;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lynk @ 2019/5/1
 */
@Component
public class RespParser {
    /**
     * 转换为RR28文件
     * @param rr28File
     * @param reqZip
     */
    public void parse2Rr28File(File rr28File, ReqZip reqZip) {
        if (rr28File.exists()) {
            rr28File.delete();
        }
        Rr28Form rr28Form = parse2Rr28(reqZip);
        JAXB.marshal(rr28Form, rr28File);
    }

    private Rr28Form parse2Rr28(ReqZip reqZip) {
        Rr28Form rr28Form = new Rr28Form();

        List<Rr28Main> rr28Mains = new ArrayList<>(1);
        rr28Form.setRr28Mains(rr28Mains);

        Rr28Main rr28Main = new Rr28Main();
        rr28Main.setQqdbs(reqZip.getQqdbs());
        rr28Main.setSqjgdm(reqZip.getSqjgdm());
        rr28Main.setMbjgdm(reqZip.getMbjgdm());
        rr28Main.setHzdm(reqZip.getHzdm());
        rr28Main.setHzsm(reqZip.getHzsm());
        rr28Main.setJssj(DateUtil.formatLocalDateTime(reqZip.getGmtCreate()));

        rr28Mains.add(rr28Main);

        return rr28Form;
    }

}
