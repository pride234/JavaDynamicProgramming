package generators.impl;

import generators.BitGenerator;
import java.math.BigInteger;

public class BlumaMikali extends BitGenerator {
    private BigInteger primitive;
    private BigInteger mod;
    private BigInteger compareValue;
    private BigInteger state;

    public BlumaMikali(final BigInteger mod,
                       final BigInteger primitive,
                       final BigInteger state) {
        this.primitive = primitive;
        this.mod = mod;
        this.state = state;
        compareValue = mod.subtract(BigInteger.ONE).divide(BigInteger.TWO);
    }

    public BlumaMikali(String mod,
                       String primitive,
                       String state,
                       String q) {
        this.primitive = new BigInteger(primitive, 16);
        this.mod = new BigInteger(mod, 16);
        this.state = new BigInteger(state, 16);
        compareValue = new BigInteger(q, 16);
    }

    private BigInteger pow(BigInteger base, BigInteger exponent) {
        BigInteger result = BigInteger.ONE;
        while (exponent.signum() > 0) {
            if (exponent.testBit(0)) {
                result = result.multiply(base);
            }
            base = base.multiply(base);
            exponent = exponent.shiftRight(1);
        }
        return result;
    }

    @Override
    public int getNext() {
        int returnValue = state.compareTo(compareValue);
        state = primitive.modPow(state, mod);
        if (returnValue >= 0) {
            return 0;
        }
        return 1;
    }
}
