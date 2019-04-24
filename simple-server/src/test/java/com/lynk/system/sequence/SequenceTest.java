package com.lynk.system.sequence;

import com.lynk.base.BaseJunitTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Lynk
 * @since 2017/11/10
 */
public class SequenceTest extends BaseJunitTest {
    private long preSequence = 0;
    @Test
    public void nextId() {
        Sequence sequence = new Sequence(0, 0);
        for (int i = 0; i < 100; i++) {
            long id = sequence.nextId();
            if (preSequence != 0) {
                Assertions.assertThat(id).as("生成的sequence应该不相等").isNotEqualTo(preSequence);
            }
            preSequence = id;
            System.out.println(id);
        }
    }

}