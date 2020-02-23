package constants;

public class Constants {
    public static final int NUMBER_BYTES;
    public static final int NUMBER_BLOCKS;
    public static final int LENGTH_BLOCK;
    public static final int SEQUENCE_SIZE;
    public static final int TWO_TO_POW_32_MINUS_ONE;
    public static final int TWO_TO_POW_8_MINUS_ONE;
    public static final double X_01;
    public static final double X_005;
    public static final double X_001;
    public static final String BOOK_PATH;

    static {
        X_01 = -1.18;
        X_005 = -1.64;
        X_001 = -2.87;
        NUMBER_BYTES = 256;
        SEQUENCE_SIZE = 1_000_000;
        NUMBER_BLOCKS = 100;
        LENGTH_BLOCK = SEQUENCE_SIZE / NUMBER_BLOCKS;
        TWO_TO_POW_32_MINUS_ONE = (int) ((1L << 32) - 1L);
        TWO_TO_POW_8_MINUS_ONE = (1 << 8) - 1;
        BOOK_PATH = System
                .getProperty("user.dir")
                .concat("/src/main/resources/book.txt");
    }
}
