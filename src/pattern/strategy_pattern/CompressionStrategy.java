package pattern.strategy_pattern;

import java.io.File;

public interface CompressionStrategy {
    void compress(File file);
}
