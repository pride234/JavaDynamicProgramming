package generators.impl;

import generators.Generator;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;

public class LibraryGenerator implements Generator {
    private File file;
    private ByteBuffer byteBuffer;
    private FileChannel fileChannel;
    private static final int DEFAULT_BUFFER_SIZE;

    static {
        DEFAULT_BUFFER_SIZE = 4096;
    }

    public LibraryGenerator(final File file) throws IOException {
        this.file = file;
        fileChannel = FileChannel.open(Paths.get(file.getPath()));
        byteBuffer = ByteBuffer.allocate(DEFAULT_BUFFER_SIZE);
        fileChannel.read(byteBuffer);
    }

    public LibraryGenerator(final File file, int bufferCapacity) throws IOException {
        this.file = file;
        fileChannel = FileChannel.open(Paths.get(file.getPath()));
        if (bufferCapacity < DEFAULT_BUFFER_SIZE) {
            bufferCapacity = DEFAULT_BUFFER_SIZE;
        }
        byteBuffer = ByteBuffer.allocate(bufferCapacity);
    }

    private void init() {

    }

    @Override
    public int getByte() {
        if (!byteBuffer.hasRemaining()) {
            byteBuffer.rewind();
            try {
                fileChannel.read(byteBuffer);
                byteBuffer.flip();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return byteBuffer.get();
    }

    public File getFile() {
        return file;
    }
}
