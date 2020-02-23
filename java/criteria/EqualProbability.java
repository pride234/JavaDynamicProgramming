package criteria;

import constants.Constants;

public class EqualProbability {
    public static boolean isEqualProbability(int[] actualNumber,
                                             double ziAlpha) {
        final int expectedNumber = Constants.SEQUENCE_SIZE / Constants.NUMBER_BYTES;
        final int l = Constants.NUMBER_BYTES - 1;
        double xi2Alpha = Math.sqrt(2 * l) * ziAlpha + l;
        double statistics = 0;
        for (int i = 0; i < Constants.NUMBER_BYTES; i++) {
            int tempVar = actualNumber[i] - expectedNumber;
            statistics += ((double) tempVar * (double) tempVar) / expectedNumber;
        }
        return statistics <= xi2Alpha;
    }
}
