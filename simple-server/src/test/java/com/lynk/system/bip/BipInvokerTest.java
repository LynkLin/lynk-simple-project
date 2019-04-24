package com.lynk.system.bip;

import com.lynk.base.BaseJunitTest;
import org.junit.jupiter.api.Test;

/**
 * @author Lynk
 * @since 2017/11/10
 */
public class BipInvokerTest extends BaseJunitTest {
    @Test
    public void invoker() throws Exception {
    }

    @Test
    public void invoker1() throws Exception {
    }

    @Test
    public void createSerialNumberPrefix() throws Exception {
        String serialNumberPrefix = BipInvoker.createSerialNumberPrefix();
        System.out.println(serialNumberPrefix);
    }

    @Test
    public void createNextSerialNumber() throws Exception {
        String serialNumber = BipInvoker.createSerialNumber();
        System.out.println(serialNumber);
        System.out.println(BipInvoker.createNextSerialNumber(serialNumber));
    }
}