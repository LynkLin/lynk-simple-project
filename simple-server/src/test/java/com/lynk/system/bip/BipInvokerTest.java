package com.lynk.system.bip;

import com.lynk.base.BaseJunitTest;
import org.junit.Test;

import static org.junit.Assert.*;

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

}