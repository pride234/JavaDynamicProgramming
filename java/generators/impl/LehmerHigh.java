package generators.impl;

public class LehmerHigh extends LinearCongruential {
    private static final long LEHMER_HIGH_CONSTANT;

    static {
        long tempVar = 0;
        for (int i = 0; i < 8; i++) {
            tempVar = tempVar + (1L << (31 - i));
        }
        LEHMER_HIGH_CONSTANT = tempVar;
    }

    public LehmerHigh(final long state) {
        super(state);
    }

    @Override
    public int getByte() {
        int returnValue = (int)((state & LEHMER_HIGH_CONSTANT) >> 24);
        state = (a * state + c) & mod;
        return returnValue;
    }
}
