package com.lynk.system.message;

import com.lynk.base.BaseJunitTest;
import org.junit.jupiter.api.Test;


/**
 * @author Lynk
 * @since 2017/11/10
 */
public class MessageGeneratorTest extends BaseJunitTest {
    @Test
    public void sendMessage() throws Exception {
        MessageGenerator.sendMessage("18262674108", "你的验证码是1234");
    }

}