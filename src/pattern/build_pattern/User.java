package pattern.build_pattern;

public class User {
    private final String id;
    private final String username;
    private final String email;
    private final String phone;
    private final String address;
    private final int age;

    private User(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
        this.age = builder.age;
    }
    public static class Builder{
        private String id;
        private String username;
        private String email;
        private String phone;
        private String address;
        private int age;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public User build(){
            if(this.age<18) throw  new IllegalStateException("Tuối phải từ 18 trở lên");
            return new User(this);
        }
    }
}
