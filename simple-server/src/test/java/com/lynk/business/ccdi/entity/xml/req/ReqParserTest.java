package com.lynk.business.ccdi.entity.xml.req;

import com.lynk.base.BaseJunitTest;
import com.lynk.business.ccdi.entity.xml.req.ss0102.Ss0102ReqConvertible;
import com.lynk.business.ccdi.entity.xml.req.ss0506.Ss0506Form;
import org.junit.Test;

import javax.annotation.Resource;

public class ReqParserTest extends BaseJunitTest {
    @Resource
    private ReqParser reqParser;

    @Test
    public void parseSs01File() {
        Ss0102ReqConvertible ss01Form = reqParser.parseReqFile("C:\\Users\\Lynk\\Desktop\\监察机关\\国监委\\recv\\ZYJWGJJWE004H101110101001A181201000000100000001\\SS01E004H101110101001A181201000000100000001.xml", Ss0102ReqConvertible.class);
        System.out.println(ss01Form);
    }

    @Test
    public void parseSs02File() {
        Ss0102ReqConvertible ss02Form = reqParser.parseReqFile("C:\\Users\\Lynk\\Desktop\\监察机关\\国监委\\recv\\ZYJWGJJWE004H101110101001A181204000000100000003\\SS02E004H101110101001A181204000000100000003.xml", Ss0102ReqConvertible.class);
        System.out.println(ss02Form);
    }

    @Test
    public void parseSs05File() {
        Ss0506Form ss05Form = reqParser.parseReqFile("C:\\Users\\Lynk\\Desktop\\监察机关\\国监委\\recv\\ZYJWGJJWE004H101110101001A181206000000100000005\\SS05E004H101110101001A181206000000100000005.xml", Ss0506Form.class);
        System.out.println(ss05Form);
    }

    @Test
    public void parseSs06File() {
        Ss0506Form ss06Form = reqParser.parseReqFile("C:\\Users\\Lynk\\Desktop\\监察机关\\国监委\\recv\\ZYJWGJJWE004H101110101001A181206000000100000007\\SS06E004H101110101001A181206000000100000007.xml", Ss0506Form.class);
        System.out.println(ss06Form);
    }
}