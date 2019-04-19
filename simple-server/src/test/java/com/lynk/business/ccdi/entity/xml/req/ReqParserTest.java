package com.lynk.business.ccdi.entity.xml.req;

import com.lynk.base.BaseJunitTest;
import com.lynk.business.ccdi.entity.xml.req.ss0102.Ss0102ReqForm;
import com.lynk.business.ccdi.entity.xml.req.ss0506.Ss0506Form;
import org.junit.Test;

import javax.annotation.Resource;

public class ReqParserTest extends BaseJunitTest {
    @Resource
    private ReqParser reqParser;

    @Test
    public void parseSs01File() {
        Ss0102ReqForm ss01Form = reqParser.parseReqFile("/Users/LynkLin/IdeaProjects/lynk-simple-project/simple-server/fes/recv/ZYJWGJJWE004H101110101001A181201000000100000001/SS01E004H101110101001A181201000000100000001.xml", Ss0102ReqForm.class);
        System.out.println(ss01Form);
    }

    @Test
    public void parseSs02File() {
        Ss0102ReqForm ss02Form = reqParser.parseReqFile("/Users/LynkLin/IdeaProjects/lynk-simple-project/simple-server/fes/recv/ZYJWGJJWE004H101110101001A181204000000100000003/SS02E004H101110101001A181204000000100000003.xml", Ss0102ReqForm.class);
        System.out.println(ss02Form);
    }

    @Test
    public void parseSs05File() {
        Ss0506Form ss05Form = reqParser.parseReqFile("/Users/LynkLin/IdeaProjects/lynk-simple-project/simple-server/fes/recv/ZYJWGJJWE004H101110101001A181206000000100000005/SS05E004H101110101001A181206000000100000005.xml", Ss0506Form.class);
        System.out.println(ss05Form);
    }

    @Test
    public void parseSs06File() {
        Ss0506Form ss06Form = reqParser.parseReqFile("/Users/LynkLin/IdeaProjects/lynk-simple-project/simple-server/fes/recv/ZYJWGJJWE004H101110101001A181206000000100000007/SS06E004H101110101001A181206000000100000007.xml", Ss0506Form.class);
        System.out.println(ss06Form);
    }
}