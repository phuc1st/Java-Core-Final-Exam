package pattern.build_pattern;

public class Computer {
    private final String CPU;
    private final String RAM;
    private final String storageType;
    private final int storageSize;

    private final boolean isGraphicsCardEnabled;
    private final boolean isBluetoothEnabled;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storageType = builder.storageType;
        this.storageSize = builder.storageSize;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    public Builder toBuilder() {
        return new Builder()
                .setCPU(this.CPU)
                .setRAM(this.RAM)
                .setStorageType(this.storageType)
                .setStorageSize(this.storageSize)
                .setBluetoothEnabled(this.isBluetoothEnabled)
                .setGraphicsCardEnabled(this.isGraphicsCardEnabled);
    }

    public static class Builder {
        private String CPU;
        private String RAM;
        private String storageType;
        private int storageSize;

        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorageType(String storageType) {
            this.storageType = storageType;
            return this;
        }

        public Builder setStorageSize(int storageSize) {
            this.storageSize = storageSize;
            return this;
        }

        public Builder setGraphicsCardEnabled(boolean isEnabled) {
            this.isGraphicsCardEnabled = isEnabled;
            return this;
        }

        public Builder setBluetoothEnabled(boolean isEnabled) {
            this.isBluetoothEnabled = isEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

/*
Product p1 = new Product.Builder()
        .setName("Laptop")
        .setPrice(1200)
        .setCategory("Electronics")
        .build();

// Clone p1 và chỉnh sửa một chút
Product p2 = p1.toBuilder()
        .setPrice(1000) // giảm giá
        .build();

 */