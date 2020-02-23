package generators.impl;

import generators.BitGenerator;
import java.math.BigInteger;

public class BigIntegerGenerator extends BitGenerator {
    private BigInteger state;
    private int[] polynom;
    private int length;

    public BigIntegerGenerator(final int[] polynom, final BigInteger state, int length) {
        this.length = length;
        this.state = state;
        this.polynom = polynom;
    }

    public BigIntegerGenerator(final int[] polynom, int state, int length) {
        this.length = length;
        if (state < 0) {
            state = state * (-1);
        }
        this.state = BigInteger.valueOf(state);
        this.polynom = polynom;
    }

    public int getNext() {
        BigInteger newState = BigInteger.ZERO;
        for (int i = 0; i < polynom.length; i++) {
            newState = newState.xor(state.shiftRight(polynom[i]));
        }
        newState = newState
                .and(BigInteger.ONE)
                .shiftLeft(length - 1)
                .or(state.shiftRight(1));
        int returnValue = state.testBit(0) ? 1 : 0;
        state = newState;
        return returnValue;
    }
}
