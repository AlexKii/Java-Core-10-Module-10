package read;

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"age\": " + age + ",\n" +
                "}";
    }

}
