package generators.impl;

import generators.BitGenerator;

public class LinearFeedbackShiftRegister extends BitGenerator {
    /**
        This LFSR can have length only less than 32,i.e 31 , 30 , ... ;
     */
    private int length;
    private int[] polynom;
    private int state;

    public LinearFeedbackShiftRegister(final int[] polynom,
                                       final int state, int length) {
        this.length = length;
        this.polynom = polynom;
        this.state = state;
        this.state &= ((1 << length) - 1);
    }

    public long getState() {
        return state;
    }

    public void setState(final int state) {
        this.state = state;
    }

    @Override
    public int getNext() {
        int newState = 0;
        for (int i = 0; i < polynom.length; i++) {
            newState = newState ^ (state >> polynom[i]);
        }
        newState = ((newState & 1) << (length - 1)) | (state >> 1);
        int returnValue = state & 1;
        state = newState;
        return returnValue;
    }
}
