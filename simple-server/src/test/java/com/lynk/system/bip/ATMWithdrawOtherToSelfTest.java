package com.lynk.system.bip;

import com.lynk.base.BaseJunitTest;
import com.lynk.system.common.DateUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ATMWithdrawOtherToSelfTest extends BaseJunitTest {
    private String serialNumber;

    @Before
    public void createSerialNumber() {
        this.serialNumber = BipInvoker.createSerialNumber();
    }

    @Test
    public void test() throws Exception {
        Map<String, Object> inputMap = new HashMap<>();
        inputMap.put("serialNumber", serialNumber);
        inputMap.put("pinBlock", "82AFF319E10F0B76");
        inputMap.put("customerAccountNo", "6230756801000069223");
        inputMap.put("currencyCode", "CNY");
        inputMap.put("transactionMoney", "1000.00");
        inputMap.put("frontendTime", DateUtil.getCurrentTime6() + "0000");
        inputMap.put("goldTransactionChannel", "01");
        inputMap.put("operateOrg", "14293080");
        inputMap.put("boundFlag", "0");
        inputMap.put("squareDate", DateUtil.getCurrentDate8());

        BipResult result = BipInvoker.invoker("ATMWithdrawOtherToSelf", inputMap);
        String type = result.getType();
        Assert.assertEquals("S", type);
    }

    @After
    public void reverse() {
        Map<String, Object> inputMap = new HashMap<>();
        inputMap.put("serialNo", serialNumber);
        BipResult result = BipInvoker.invoker("posOffsetAccount", inputMap);
        String type = result.getType();
        System.out.println("冲正结果：" + type);
    }
}
