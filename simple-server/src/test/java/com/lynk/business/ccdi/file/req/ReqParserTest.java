package com.lynk.business.ccdi.file.req;

import com.lynk.base.BaseJunitTest;
import com.lynk.business.ccdi.common.Constant;
import com.lynk.business.ccdi.entity.ReqBasic;
import com.lynk.business.ccdi.entity.ReqMain;
import com.lynk.business.ccdi.entity.ReqPerson;
import com.lynk.business.ccdi.file.req.basic.ReqBiz;
import com.lynk.business.ccdi.file.req.ss0102.Ss0102Form;
import com.lynk.business.ccdi.file.req.ss0506.Ss0506Form;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

public class ReqParserTest extends BaseJunitTest {
    private static final String PROJECT_PATH = System.getProperty("user.dir");

    @Resource
    private ReqParser reqParser;

    @Test
    public void parseSs01XmlFile() {
        Ss0102Form ss01Form = reqParser.parseReqXmlFile(PROJECT_PATH + "/fes/recv/ZYJWGJJWE004H101110101001A181201000000100000001/SS01E004H101110101001A181201000000100000001.xml", Ss0102Form.class);
        assertNotNull(ss01Form.getBasicInfo());
        assertNotNull(ss01Form.getQueryPerson());
        assertNotNull(ss01Form.getReqBizs());
    }

    @Test
    public void parseSs02XmlFile() {
        Ss0102Form ss02Form = reqParser.parseReqXmlFile(PROJECT_PATH + "/fes/recv/ZYJWGJJWE004H101110101001A181204000000100000003/SS02E004H101110101001A181204000000100000003.xml", Ss0102Form.class);
        assertNotNull(ss02Form.getBasicInfo());
        assertNotNull(ss02Form.getQueryPerson());
        assertNotNull(ss02Form.getReqBizs());
    }

    @Test
    public void parseSs05XmlFile() {
        Ss0506Form ss05Form = reqParser.parseReqXmlFile(PROJECT_PATH + "/fes/recv/ZYJWGJJWE004H101110101001A181206000000100000005/SS05E004H101110101001A181206000000100000005.xml", Ss0506Form.class);
        assertNotNull(ss05Form.getBasicInfo());
        assertNotNull(ss05Form.getQueryPerson());
        assertNotNull(ss05Form.getReqBizs());
    }

    @Test
    public void parseSs06XmlFile() {
        Ss0506Form ss06Form = reqParser.parseReqXmlFile(PROJECT_PATH + "/fes/recv/ZYJWGJJWE004H101110101001A181206000000100000007/SS06E004H101110101001A181206000000100000007.xml", Ss0506Form.class);
        assertNotNull(ss06Form.getBasicInfo());
        assertNotNull(ss06Form.getQueryPerson());
        assertNotNull(ss06Form.getReqBizs());
    }

    @Test
    public void parse2ReqBasic() {
        Ss0102Form ss01Form = reqParser.parseReqXmlFile(PROJECT_PATH + "/fes/recv/ZYJWGJJWE004H101110101001A181201000000100000001/SS01E004H101110101001A181201000000100000001.xml", Ss0102Form.class);
        ReqBasic reqBasic = reqParser.parse2ReqBasic(ss01Form);
        assertEquals(ss01Form.getBasicInfo().getQqdbs(), reqBasic.getQqdbs());
    }

    @Test
    public void parse2ReqPerson() {
        Ss0102Form ss01Form = reqParser.parseReqXmlFile(PROJECT_PATH + "/fes/recv/ZYJWGJJWE004H101110101001A181201000000100000001/SS01E004H101110101001A181201000000100000001.xml", Ss0102Form.class);
        ReqPerson reqPerson = reqParser.parse2ReqPerson(ss01Form);
        assertEquals(ss01Form.getQueryPerson().getQqrxm(), reqPerson.getQqrxm());
    }

    @Test
    public void parse2ReqMain0102() {
        Ss0102Form ss01Form = reqParser.parseReqXmlFile(PROJECT_PATH + "/fes/recv/ZYJWGJJWE004H101110101001A181201000000100000001/SS01E004H101110101001A181201000000100000001.xml", Ss0102Form.class);
        List<ReqBiz> reqBizs = ss01Form.getReqBizs();
        List<ReqMain> reqMains = reqParser.parse2ReqMain(Constant.FLDM_SS01,ss01Form);
        assertEquals(reqBizs.size(), reqMains.size());
        for (int i = 0; i < reqBizs.size(); i++) {
            ReqBiz reqBiz = reqBizs.get(i);
            ReqMain reqMain = reqMains.get(i);
            assertEquals(reqBiz.getRwlsh(), reqMain.getRwlsh());
            assertEquals(reqBiz.getMxqssj(), reqMain.getKssj());
            assertEquals(reqBiz.getMxjzsj(), reqMain.getJssj());
            assertNull(reqMain.getZh());
            assertNull(reqMain.getSjhm());
            assertNull(reqMain.getYrwlsh());

            assertEquals(reqBiz.getJe(), reqMain.getJe());
        }
    }
}