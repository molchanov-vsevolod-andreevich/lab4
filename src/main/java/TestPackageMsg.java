public class TestPackageMessage {
    private final int id;
    private final String name;

    @JsonCreator
    public Pet(@JsonProperty("id") int id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}