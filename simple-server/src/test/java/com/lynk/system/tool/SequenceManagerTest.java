package com.lynk.system.tool;

import com.lynk.base.BaseJunitTest;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @authory: Lynk
 * @date: 2019/04/22
 */
public class SequenceManagerTest extends BaseJunitTest {

    @Test
    public void nextSequenceId() {
        Long before = SequenceManager.getInstance().nextSequence();
        Long after = SequenceManager.getInstance().nextSequence();
        assertEquals(1, after - before);
    }
}