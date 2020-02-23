package criteria;

import constants.Constants;

public class Homogeneity {
    public static boolean isHomogeneity(int[][] table, double ziAplha) {
        double statistics = 0;
        int l = (Constants.NUMBER_BYTES - 1) * (Constants.NUMBER_BLOCKS - 1);
        double xi2Aplha = ziAplha * Math.sqrt(2 * l) + l;
        for (int i = 0; i < Constants.NUMBER_BYTES; i++) {
            for (int j = 0; j < Constants.NUMBER_BLOCKS; j++) {
                double tempVar = table[i][Constants.NUMBER_BLOCKS] * Constants.LENGTH_BLOCK;
                if (tempVar == 0) {
                    continue;
                }
                statistics += ((double) table[i][j] * table[i][j]) / tempVar;
            }
        }
        statistics = (statistics - 1) * Constants.SEQUENCE_SIZE;
        return statistics <= xi2Aplha;
    }
}
