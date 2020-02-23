package generators.impl;

import generators.Generator;

public class NativeGenerator implements Generator {
    private static final int MOD;

    static {
        MOD = (1 << 8) - 1;
    }

    @Override
    public int getByte() {
        return ((int) Math.random() * 1000) & MOD;
    }
}
