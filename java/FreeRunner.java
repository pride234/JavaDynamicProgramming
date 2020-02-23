import generators.Generator;

public class FreeRunner {
    public static Generator run(Generator generator, int number) {
        while (number-- > 0) {
            generator.getByte();
        }
        return generator;
    }
}
