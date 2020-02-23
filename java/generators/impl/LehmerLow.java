package generators.impl;

public class LehmerLow extends LinearCongruential {
    private static int LEHMER_LOW_CONSTANT;

    static {
        LEHMER_LOW_CONSTANT = (1 << 8) - 1;
    }

    public LehmerLow(final long state) {
        super(state);
    }

    @Override
    public int getByte() {
        int returnValue = (int) state & LEHMER_LOW_CONSTANT;
        state = (a * state + c) & mod;
        return returnValue;
    }
}
