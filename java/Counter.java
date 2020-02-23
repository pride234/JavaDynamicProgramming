import constants.Constants;
import generators.Generator;

public class Counter {
    private int[] numberBytes;
    private int[][] numberPairs;
    private int[][] numberBlocks;
    private final Generator generator;
    private final int sequenceSize;

    public Counter(Generator generator, int sequenceSize) {
        this.generator = generator;
        this.sequenceSize = sequenceSize;
        numberBytes = new int[Constants.NUMBER_BYTES];
        numberPairs = new int[Constants.NUMBER_BYTES + 1][Constants.NUMBER_BYTES + 1];
        numberBlocks = new int[Constants.NUMBER_BYTES][Constants.NUMBER_BLOCKS + 1];
    }

    public void countBytes() {
        int generatedByte;
        for (int i = 0; i < sequenceSize; i++) {
            generatedByte = generator.getByte();
            numberBytes[generatedByte]++;
        }
    }

    public void countPairs() {
        int generatedByte;
        int jpair = 0;
        int[] indexPair = new int[2];
        for (int i = 0; i < sequenceSize; i++) {
            generatedByte = generator.getByte();
            indexPair[jpair] = generatedByte;
            if (1 == (jpair & 1)) {
                numberPairs[indexPair[0]][indexPair[1]] += 1;
            }
            jpair ^= 1;
        }
        countAdditionalSumsPairs();
    }

    private void countAdditionalSumsPairs() {
        int sumFirstPlace;
        int sumSecondPlace;
        for (int i = 0; i < Constants.NUMBER_BYTES; i++) {
            sumFirstPlace = 0;
            sumSecondPlace = 0;
            for (int j = 0; j < Constants.NUMBER_BYTES; j++) {
                sumFirstPlace += numberPairs[i][j];
                sumSecondPlace += numberPairs[j][i];
            }
            numberPairs[i][Constants.NUMBER_BYTES] = sumFirstPlace;
            numberPairs[Constants.NUMBER_BYTES][i] = sumSecondPlace;
        }
    }

    public void countBlocks() {
        int generatedByte;
        int sumInBlocks;
        for (int j = 0; j < Constants.NUMBER_BLOCKS; j++) {
            for (int i = 0; i < Constants.LENGTH_BLOCK; i++) {
                generatedByte = generator.getByte();
                numberBlocks[generatedByte][j]++;
            }
        }
        for (int i = 0; i < Constants.NUMBER_BYTES; i++) {
            sumInBlocks = 0;
            for (int j = 0; j < Constants.NUMBER_BLOCKS; j++) {
                sumInBlocks += numberBlocks[i][j];
            }
            numberBlocks[i][Constants.NUMBER_BLOCKS] = sumInBlocks;
        }
    }

    public int[] getNumberBytes() {
        return this.numberBytes;
    }

    public int[][] getNumberPairs() {
        return this.numberPairs;
    }

    public int[][] getNumberBlocks() {
        return this.numberBlocks;
    }

    public Generator getGenerator() {
        return this.generator;
    }

    public int getSequenceSize() {
        return this.sequenceSize;
    }
}
