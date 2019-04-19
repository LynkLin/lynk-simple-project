package com.lynk.system.bip;


import com.giantstone.exception.PackSoapMessageException;
import com.giantstone.service.InvokeResult;
import com.giantstone.service.domain.WebserviceInvokeResult;
import com.giantstone.service.invoke.imp.WebServiceInvoker;
import com.giantstone.wsdl.domain.WebServiceInterfaceManager;
import com.lynk.system.common.Constants;
import com.lynk.system.common.DateUtil;
import com.lynk.system.common.JsonBuilder;
import com.lynk.system.exception.SystemException;
import com.lynk.system.tool.SequenceManager;
import com.lynk.system.tool.SysParamManager;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Lynk
 * @since 2017/11/10
 */
public class BipInvoker {
    private static final Logger LOGGER = LoggerFactory.getLogger(BipInvoker.class);

    /**
     * 带参数服务
     * @param serviceName
     * @param inputMap
     * @return
     * @throws SystemException
     */
    public static BipResult invoker(String serviceName, Map<String, Object> inputMap) throws SystemException {
        //check some
        if (inputMap == null) {
            inputMap = new HashMap<>(16);
        }
        if (!inputMap.containsKey(BipResult.INPUT_EXTERNAL_DOMAIN)) {
            inputMap.put(BipResult.INPUT_EXTERNAL_DOMAIN, SysParamManager.getInstance().getParam(Constants.SYSTEM_PARAM_GROUP_BIP, Constants.SYSTEM_PARAM_BIP_DOMAIN));
        }
        if (!inputMap.containsKey(BipResult.INPUT_MEDIUM)) {
            inputMap.put(BipResult.INPUT_MEDIUM, SysParamManager.getInstance().getParam(Constants.SYSTEM_PARAM_GROUP_BIP, Constants.SYSTEM_PARAM_BIP_MEDIUM));
        }
        if (!inputMap.containsKey(BipResult.INPUT_SERIAL_NUMBER)) {
            inputMap.put(BipResult.INPUT_SERIAL_NUMBER, createSerialNumber());
        }
        if (!inputMap.containsKey(BipResult.INPUT_TELLER_CODE)) {
            inputMap.put(BipResult.INPUT_TELLER_CODE, SysParamManager.getInstance().getParam(Constants.SYSTEM_PARAM_GROUP_BIP, Constants.SYSTEM_PARAM_BIP_TELLER_CODE));
        }
        if (!inputMap.containsKey(BipResult.INPUT_ORG_CODE)) {
            inputMap.put(BipResult.INPUT_ORG_CODE, SysParamManager.getInstance().getParam(Constants.SYSTEM_PARAM_GROUP_BIP, Constants.SYSTEM_PARAM_BIP_ORG_CODE));
        }

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("call bip service start: {}, input: {}", serviceName, JsonBuilder.builder().bean2Json(inputMap));
        }

        //wsdl文件路径
        String wsdlFileName = SysParamManager.getInstance().getParam(Constants.SYSTEM_PARAM_GROUP_BIP, Constants.SYSTEM_PARAM_BIP_WSDL_PATH) + File.separator + serviceName + File.separator + serviceName + ".wsdl";
        String serviceAddress = SysParamManager.getInstance().getParam(Constants.SYSTEM_PARAM_GROUP_BIP, Constants.SYSTEM_PARAM_BIP_ADDRESS) + "/" + serviceName;
        //解析wsdl文件
        try {
            WebServiceInterfaceManager.loadWsdlByFullPath(wsdlFileName);
        } catch (Exception e) {
            LOGGER.error("载入WSDL失败", e);
        }
        //设置soap报文头
        Map<String, Object> header = new HashMap<>(16);

        InvokeResult result = new WebserviceInvokeResult();
        //调用接口
        try {
            Map<String, Object> body = new HashMap<>(16);
            body.put("input", inputMap);
            WebServiceInvoker.invoke(wsdlFileName, header, body, serviceAddress, serviceName, "UTF-8", 55000, 55000, result);
        } catch (PackSoapMessageException e) {
            LOGGER.error("调用BIP失败", e);
        }

        BipResult bipResult = new BipResult();
        bipResult.setInput(inputMap);
        Map dataMap = result.getResultDataMap();

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("call bip service finish: {}, output: {}", serviceName, JsonBuilder.builder().bean2Json(dataMap));
        }

        Map bodyMap = (Map) dataMap.get("Body");
        if (bodyMap != null) {
            Map outMap = (Map) bodyMap.get("out");
            if (outMap != null) {
                Map returnCodeMap = (Map) outMap.get("returnCode");
                if (returnCodeMap != null) {
                    bipResult.setType((String) returnCodeMap.get("type"));
                    bipResult.setReturnCode((String) returnCodeMap.get("returnCode"));
                    bipResult.setMessage((String) returnCodeMap.get("message"));

                    outMap.remove("returnCode");
                    for (Object key: outMap.keySet()) {
                        bipResult.putData(key, outMap.get(key));
                    }
                }

            }
        }
        return bipResult;
    }


    /**
     * 无参数服务
     * @param serviceName
     * @return
     * @throws SystemException
     */
    public static BipResult invoker(String serviceName) throws SystemException {
        Map<String, Object> inputMap = new HashMap<>(16);
        String serialNumber = createSerialNumber();
        inputMap.put(BipResult.INPUT_SERIAL_NUMBER, serialNumber);
        return invoker(serviceName, inputMap);
    }

    /**
     * 23位流水号
     * @return
     */
    public static String createSerialNumberPrefix() {
        String sequenceId = SequenceManager.getInstance().nextSequenceId();
        String sequence = sequenceId.substring(sequenceId.length() - 12);

        //3+8+12
        return SysParamManager.getInstance().getParam(Constants.SYSTEM_PARAM_GROUP_BIP, Constants.SYSTEM_PARAM_BIP_DOMAIN)
                + DateUtil.getCurrentDate8()
                + sequence;
    }

    /**
     * 生成序号为1的流水
     * @return
     */
    public static String createSerialNumber() {
        return createSerialNumber(1);
    }

    /**
     * 生成下一个流水号，序号加1
     * @param serialNumber 32位流水号
     * @return
     */
    public static String createNextSerialNumber(String serialNumber) {
        if (serialNumber.length() >= 23) {
            String pre = serialNumber.substring(0, 23);
            String sub = serialNumber.substring(23);
            int order = Integer.parseInt(sub);
            return pre + formatOrder(++order);
        } else {
            return serialNumber + formatOrder(1);
        }
    }


    /**
     * 32位流水号
     * @param order
     * @return
     */
    private static String createSerialNumber(int order) {
        String serialNumberPrefix = createSerialNumberPrefix();
        //3+8+12+9
        return serialNumberPrefix + formatOrder(order);
    }

    /**
     * 左补0,9位长度
     * @param order
     * @return
     */
    private static String formatOrder(int order) {
        String orderStr = Integer.toString(order);
        return StringUtils.leftPad(orderStr, 9, "0");
    }
}
