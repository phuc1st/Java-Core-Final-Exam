package pattern.strategy_pattern;

import java.io.File;

public class ZipCompression implements CompressionStrategy{
    @Override
    public void compress(File file) {
        System.out.println("compressed by zip");
    }
}
