package com.lynk.system.tool;

import com.lynk.base.BaseJunitTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @author Lynk @ 2019/04/22
 */
public class SequenceManagerTest extends BaseJunitTest {

    @Test
    public void nextSequenceId() {
        Long before = SequenceManager.getInstance().nextSequence();
        Long after = SequenceManager.getInstance().nextSequence();
        Assertions.assertThat(after - before).isEqualTo(1);
    }
}