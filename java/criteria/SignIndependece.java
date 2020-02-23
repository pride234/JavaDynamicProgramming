package criteria;

import constants.Constants;

public class SignIndependece {
    public static boolean isSignIndependence(int[][] pairs, double ziAlpha)
            throws IllegalArgumentException {
        int l = (Constants.NUMBER_BYTES - 1) * (Constants.NUMBER_BYTES - 1);
        double xi2Aplha = ziAlpha * Math.sqrt(2 * l) + l;
        double statistics = 0.0;
        for (int i = 0; i < Constants.NUMBER_BYTES; i++) {
            for (int j = 0; j < Constants.NUMBER_BYTES; j++) {
                double tempVar = (double) pairs[i][Constants.NUMBER_BYTES] * pairs[Constants.NUMBER_BYTES][j];
                if (tempVar == 0) {
                    continue;
                }
                statistics += pairs[i][j] / tempVar;
            }
        }
        statistics = (statistics - 1) * Constants.SEQUENCE_SIZE / 2;
        return statistics <= xi2Aplha;
    }
}
