package generators;

public abstract class BitGenerator implements Generator {

    @Override
    public int getByte() {
        int returnValue = 0;
        for (int i = 0; i < 8; i++) {
            returnValue = returnValue << 1;
            returnValue = returnValue | getNext();
        }
        return returnValue;
    }

    protected abstract int getNext();
}
