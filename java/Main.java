import constants.Constants;
import criteria.EqualProbability;
import generators.Generator;
import generators.impl.BlumBlumShub;

public class Main {
    private static void func(Generator generator) {
        Counter counter = new Counter(generator, Constants.SEQUENCE_SIZE);
        counter.countBytes();
        System.out.println(EqualProbability
                .isEqualProbability(counter.getNumberBytes(),Constants.X_001));
    }

    public static void main(String[] args) {
        String hexP = "D5BBB96D30086EC484EBA3D7F9CAEB07";
        String hexQ = "425D2B9BFDB25B9CF6C416CC6E37B59C1F";
        String state = "6D30086EC484E";
        Generator generator = new BlumBlumShub(hexP, hexQ, state);
        FreeRunner.run(generator, 250);
        func(generator);
    }
}
