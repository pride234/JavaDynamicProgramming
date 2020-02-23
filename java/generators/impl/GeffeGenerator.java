package generators.impl;

import generators.BitGenerator;

public class GeffeGenerator extends BitGenerator {
    private LinearFeedbackShiftRegister l1;
    private LinearFeedbackShiftRegister l2;
    private LinearFeedbackShiftRegister l3;

    public GeffeGenerator(final LinearFeedbackShiftRegister l1,
                          final LinearFeedbackShiftRegister l2,
                          final LinearFeedbackShiftRegister l3) {
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }

    @Override
    public int getNext() {
        int s = l3.getNext();
        int x = l1.getNext();
        int y = l2.getNext();
        return (s & x) ^ ((1 ^ x) & y);
    }
}
