package com.lynk.system.tool;

import com.lynk.system.sequence.Sequence;

/**
 * @author Lynk
 * @since 2017/11/10
 */
public class SequenceManager {
    private Sequence sequence;

    private static SequenceManager sequenceManager;

    private SequenceManager() {
    }

    public static SequenceManager getInstance() {
        if (sequenceManager == null) {
            sequenceManager = new SequenceManager();
        }
        return sequenceManager;
    }

    public void init() {
        sequence = new Sequence(0, 0);
    }

    public long nextSequence() {
        return sequence.nextId();
    }

    public String nextSequenceId() {
        return Long.toString(sequence.nextId());
    }
}
