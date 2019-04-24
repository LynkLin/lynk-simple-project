package com.lynk.business.ccdi.common;

import java.util.Arrays;
import java.util.List;

/**
 * @author Lynk on 2019/04/22
 */
public class Constant extends com.lynk.system.common.Constant {
    public static final String FLDM_SS01 = "SS01";
    public static final String FLDM_SS02 = "SS02";
    public static final String FLDM_SS03 = "SS03";
    public static final String FLDM_SS04 = "SS04";
    public static final String FLDM_SS05 = "SS05";
    public static final String FLDM_SS06 = "SS06";
    public static final String FLDM_SS07 = "SS07";
    public static final String FLDM_SS08 = "SS08";
    public static final String FLDM_SS09 = "SS09";
    public static final String FLDM_SS10 = "SS10";
    public static final String FLDM_SS11 = "SS11";
    public static final String FLDM_SS12 = "SS12";
    public static final String FLDM_SS13 = "SS13";
    public static final String FLDM_SS14 = "SS14";
    public static final String FLDM_SS15 = "SS15";
    public static final String FLDM_SS16 = "SS16";
    public static final String FLDM_SS17 = "SS17";
    public static final String FLDM_SS18 = "SS18";
    public static final String FLDM_SS19 = "SS19";
    public static final String FLDM_SS20 = "SS20";
    public static final String FLDM_SS21 = "SS21";
    public static final String FLDM_SS22 = "SS22";
    public static final String FLDM_SS23 = "SS23";
    public static final String FLDM_SS24 = "SS24";
    public static final String FLDM_SS25 = "SS25";
    public static final String FLDM_SS26 = "SS26";
    public static final String FLDM_SS30 = "SS30";
    public static final String FLDM_SS31 = "SS31";
    public static final String FLDM_SS32 = "SS32";
    public static final String FLDM_SS33 = "SS33";
    public static final String FLDM_SS34 = "SS34";
    public static final String FLDM_SS35 = "SS35";
    public static final String FLDM_LI25 = "LI25";
    public static final String FLDM_LI26 = "LI26";
    public static final String FLDM_LI27 = "LI27";
    public static final String FLDM_RR28 = "RR28";
    public static final String FLDM_SR53 = "SR53";

    public static final List<String> FLDM_GROUP_REQ_IDENT = Arrays.asList(FLDM_SS01, FLDM_SS02);
    public static final List<String> FLDM_GROUP_REQ_ACCOUNT = Arrays.asList(FLDM_SS05, FLDM_SS06);
    public static final List<String> FLDM_GROUP_REQ_PHONE = Arrays.asList(FLDM_SS32, FLDM_SS33);
    public static final List<String> FLDM_GROUP_REQ_DYNAMIC = Arrays.asList(FLDM_SS11, FLDM_SS12);
    public static final List<String> FLDM_GROUP_REQ_FREEZE = Arrays.asList(FLDM_SS17, FLDM_SS18);
    public static final List<String> FLDM_GROUP_REQ_STOP = Arrays.asList(FLDM_SS21, FLDM_SS22);
    public static final List<String> FLDM_GROUP_REQ_CERT = Arrays.asList(FLDM_SS25);

    /**
     * *.ZIP
     */
    public static final String ZIP_FILE_SPEC = "*.ZIP";
    /**
     * 文件名上的请求机构
     */
    public static final String FILE_ORG = "ZYJWGJJW";

    /**
     * 正常包
     */
    public static final String NESTED_STATUS_NORMAL = "0";
    /**
     * 托管银行外层
     */
    public static final String NESTED_STATUS_OUTTER = "1";
    /**
     * 托管银行内层
     */
    public static final String NESTED_STATUS_INNER = "2";

    /**
     * 00-下载zip完成
     */
    public static final String REQ_ZIP_STATUS_00 = "00";
    /**
     * 01-解析请求文件
     */
    public static final String REQ_ZIP_STATUS_01 = "01";
    /**
     * 02-解析完成, 等待反馈回执
     */
    public static final String REQ_ZIP_STATUS_02 = "02";
    /**
     * 03-已反馈回执
     */
    public static final String REQ_ZIP_STATUS_03 = "03";
    /**
     * 04-数据全部反馈完成
     */
    public static final String REQ_ZIP_STATUS_04 = "04";

    /**
     * 30000 成功接收查控文件
     */
    public static final String REQ_ZIP_HZDM_SUCCESS = "3000";
    /**
     * 30001 数字签名错误，验签没通过
     */
    public static final String REQ_ZIP_HZDM_FAIL_SIGNATURE = "30001";
    /**
     * 30002 查控报文解析错误
     */
    public static final String REQ_ZIP_HZDM_FAIL_PARSE = "30002";
    /**
     * 30003 查控法律文件缺失
     */
    public static final String REQ_ZIP_HZDM_FAIL_MISSING_PDF = "30003";
    /**
     * 30004 法律文书与请求单信息不符
     */
    public static final String REQ_ZIP_HZDM_FAIL_PDF_NOT_MATCH = "30004";
    /**
     * 30005 缺少请求报文文件
     */
    public static final String REQ_ZIP_HZDM_FAIL_MISSING_XML = "30005";
}
