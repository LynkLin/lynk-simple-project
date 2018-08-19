package com.lynk.system.sequence;

import com.lynk.base.BaseJunitTest;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Lynk
 * @since 2017/11/10
 */
public class SequenceTest extends BaseJunitTest {

    @Test
    public void nextId() throws Exception {
        Sequence sequence = new Sequence(0, 0);
        for (int i = 0; i < 100; i++) {
            long id = sequence.nextId();
            System.out.println(id);
        }
    }

}