package generators.impl;

import generators.Generator;

public abstract class LinearCongruential implements Generator {
    protected final int a = (1 << 16) + 1;
    protected final int c = 119;
    protected final long mod = (1L << 32) - 1L;
    protected long state;

    public LinearCongruential(final long state) {
        this.state = state;
    }
}
