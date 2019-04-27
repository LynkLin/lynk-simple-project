package com.lynk.business.ccdi.common;

import java.util.Arrays;
import java.util.List;

/**
 * @author Lynk on 2019/04/22
 */
public class Constant extends com.lynk.system.common.Constant {
    /**
     * SS01	个人账户查询申请
     */
    public static final String FLDM_SS01 = "SS01";
    /**
     * SS02	对公账户查询申请
     */
    public static final String FLDM_SS02 = "SS02";
    /**
     * SS03	个人账户查询申请反馈
     */
    public static final String FLDM_SS03 = "SS03";
    /**
     * SS04	对公账户查询申请反馈
     */
    public static final String FLDM_SS04 = "SS04";
    /**
     * SS05	个人帐（卡）号查询申请
     */
    public static final String FLDM_SS05 = "SS05";
    /**
     * SS06	对公帐（卡）号查询申请
     */
    public static final String FLDM_SS06 = "SS06";
    /**
     * SS07	个人帐（卡）号查询申请反馈
     */
    public static final String FLDM_SS07 = "SS07";
    /**
     * SS08	对公帐（卡）号查询申请反馈
     */
    public static final String FLDM_SS08 = "SS08";
    /**
     * SS09	个人账户交易明细信息反馈
     */
    public static final String FLDM_SS09 = "SS09";
    /**
     * SS10	对公账户交易明细信息反馈
     */
    public static final String FLDM_SS10 = "SS10";
    /**
     * SS11	个人账户动态查询申请
     */
    public static final String FLDM_SS11 = "SS11";
    /**
     * SS12	对公账户动态查询申请
     */
    public static final String FLDM_SS12 = "SS12";
    /**
     * SS13	个人账户动态查询申请反馈
     */
    public static final String FLDM_SS13 = "SS13";
    /**
     * SS14	对公账户动态查询申请反馈
     */
    public static final String FLDM_SS14 = "SS14";
    /**
     * SS15	个人账户动态查询申请手机短信反馈
     */
    public static final String FLDM_SS15 = "SS15";
    /**
     * SS16	对公账户动态查询申请手机短信反馈
     */
    public static final String FLDM_SS16 = "SS16";
    /**
     * SS17	个人账户冻结/解冻/续冻申请
     */
    public static final String FLDM_SS17 = "SS17";
    /**
     * SS18	对公账户冻结/解冻/续冻申请
     */
    public static final String FLDM_SS18 = "SS18";
    /**
     * SS19	个人账户冻结/解冻/续冻申请反馈
     */
    public static final String FLDM_SS19 = "SS19";
    /**
     * SS20	对公账户冻结/解冻/续冻申请反馈
     */
    public static final String FLDM_SS20 = "SS20";
    /**
     * SS21	个人账户紧急止付申请
     */
    public static final String FLDM_SS21 = "SS21";
    /**
     * SS22	对公账户紧急止付申请
     */
    public static final String FLDM_SS22 = "SS22";
    /**
     * SS23	个人账户紧急止付申请反馈
     */
    public static final String FLDM_SS23 = "SS23";
    /**
     * SS24	对公账户紧急止付申请反馈
     */
    public static final String FLDM_SS24 = "SS24";
    /**
     * SS25	凭证图像查询申请
     */
    public static final String FLDM_SS25 = "SS25";
    /**
     * SS26	凭证图像查询反馈
     */
    public static final String FLDM_SS26 = "SS26";
    /**
     * SS30	个人账户金融理财信息查询反馈
     */
    public static final String FLDM_SS30 = "SS30";
    /**
     * SS31	对公账户金融理财信息查询反馈
     */
    public static final String FLDM_SS31 = "SS31";
    /**
     * SS32	个人手机号码查询申请
     */
    public static final String FLDM_SS32 = "SS32";
    /**
     * SS33	对公手机号码查询申请
     */
    public static final String FLDM_SS33 = "SS33";
    /**
     * SS34	个人手机号码申请反馈
     */
    public static final String FLDM_SS34 = "SS34";
    /**
     * SS35	对公手机号码申请反馈
     */
    public static final String FLDM_SS35 = "SS35";
    /**
     * LI25	文书文件名称
     */
    public static final String FLDM_LI25 = "LI25";
    /**
     * LI26	申请人工作证
     */
    public static final String FLDM_LI26 = "LI26";
    /**
     * LI27	协查人工作证
     */
    public static final String FLDM_LI27 = "LI27";
    /**
     * RR28	回执信息文件
     */
    public static final String FLDM_RR28 = "RR28";
    /**
     * SR53	回执文书文件
     */
    public static final String FLDM_SR53 = "SR53";

    public static final List<String> FLDM_GROUP_REQ_IDENT = Arrays.asList(FLDM_SS01, FLDM_SS02);
    public static final List<String> FLDM_GROUP_REQ_ACCOUNT = Arrays.asList(FLDM_SS05, FLDM_SS06);
    public static final List<String> FLDM_GROUP_REQ_PHONE = Arrays.asList(FLDM_SS32, FLDM_SS33);
    public static final List<String> FLDM_GROUP_REQ_DYNAMIC = Arrays.asList(FLDM_SS11, FLDM_SS12);
    public static final List<String> FLDM_GROUP_REQ_FREEZE = Arrays.asList(FLDM_SS17, FLDM_SS18);
    public static final List<String> FLDM_GROUP_REQ_STOP = Arrays.asList(FLDM_SS21, FLDM_SS22);
    public static final List<String> FLDM_GROUP_REQ_CERT = Arrays.asList(FLDM_SS25);

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
     * 01-解析请求文件中
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


    /**
     * 00-等待审核
     */
    public static final String REQ_APPROVAL_WAIT = "00";
    /**
     * 01-审核通过
     */
    public static final String REQ_APPROVAL_PASS = "01";

    /**
     * 02-审核不通过
     */
    public static final String REQ_APPROVAL_REJECT = "02";

    /**
     * 00-等待查控
     */
    public static final String REQ_STATUS_WAIT_PROCESS = "00";
    /**
     * 01-查控中
     */
    public static final String REQ_STATUS_PROCESSING = "01";
    /**
     * 02-查控完成，待反馈
     */
    public static final String REQ_STATUS_WAIT_RESP = "02";
    /**
     * 03-反馈中
     */
    public static final String REQ_STATUS_RESPING = "03";
    /**
     * 04-反馈成功
     */
    public static final String REQ_STATUS_RESP_SUCCESS = "04";
    /**
     * 05-反馈失败
     */
    public static final String REQ_STATUS_RESP_FAIL = "05";

    /**
     * 00-正常
     */
    public static final String REQ_DYNAMICAL_STATUS_NORMAL = "00";
    /**
     * 01-失效，已过执行时间区间
     */
    public static final String REQ_DYNAMICAL_STATUS_INVALID = "01";

    /**
     *1表示动态查询1个月
     */
    public static final String REQ_DYNAMICAL_ZXJSQJ_1_MONTH = "1";
    /**
     * 2表示2个月
     */
    public static final String REQ_DYNAMICAL_ZXJSQJ_2_MONTH = "2";
    /**
     * 3表示3个月
     */
    public static final String REQ_DYNAMICAL_ZXJSQJ_3_MONTH = "3";
    /**
     * 4表示规定的最长时间100天
     */
    public static final String REQ_DYNAMICAL_ZXJSQJ_100_DAY = "4";
}
