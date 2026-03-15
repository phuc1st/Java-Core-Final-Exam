package pattern.strategy_pattern;

import java.io.File;

public class CompressionContext {
    private CompressionStrategy compressionStrategy;

    public void setCompressionStrategy(CompressionStrategy compressionStrategy) {
        this.compressionStrategy = compressionStrategy;
    }

    public void compress(File file){
        if (compressionStrategy==null){
            System.out.println("Vui lòng chọn phương thức nén");
            return;
        }
        compressionStrategy.compress(file);
    }
}
