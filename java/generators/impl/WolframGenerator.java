package generators.impl;

import constants.Constants;
import generators.BitGenerator;

public class WolframGenerator extends BitGenerator {
    private int state;

    private int cycleShiftLeft(int number) {
        number = (number << 1) | (number >>> 31);
        return number & Constants.TWO_TO_POW_32_MINUS_ONE;
    }

    public WolframGenerator(final int state) {
        this.state = state;
    }

    @Override
    protected int getNext() {
        int returnValue = state & 1;
        state = cycleShiftLeft(state) ^ (state | (state >>> 1));
        return returnValue;
    }
}
