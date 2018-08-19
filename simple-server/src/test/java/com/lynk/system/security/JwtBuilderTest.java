package com.lynk.system.security;

import com.lynk.base.BaseJunitTest;
import com.lynk.system.security.common.JwtBuilder;
import com.lynk.system.tool.SequenceManager;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Lynk
 * @since 2017/10/19
 */
public class JwtBuilderTest extends BaseJunitTest {

    @Test
    public void createToken() {
        String cacheId = SequenceManager.getInstance().nextSequenceId();
        String token = JwtBuilder.builder().createToken(cacheId);
        Assert.assertEquals(JwtBuilder.builder().getCacheId(token), cacheId);
    }
}