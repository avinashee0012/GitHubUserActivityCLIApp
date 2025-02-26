
public class EventEntity {

    // FIELDS
    private String type;
    private RepoEntity repo;

    // GETTERS
    public String getType() {
        return type;
    }

    public RepoEntity getRepo() {
        return repo;
    }

    // SETTERS
    // No setters created

    // HELPER METHODS
    @Override
    public String toString() {
        return "{type: " + type + ", repo: " + repo.getName() + "}";
    }

}
