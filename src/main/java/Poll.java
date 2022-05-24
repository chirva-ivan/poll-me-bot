import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Poll {
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getMinVotes() {
        return minVotes;
    }

    public void setMinVotes(int minVotes) {
        this.minVotes = minVotes;
    }

    public int getYes() {
        return yes;
    }

    public void setYes(int yes) {
        this.yes = yes;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setVoters(Set<String> voters) {
        this.voters = voters;
    }

    public Set<String> getVoters() {
        return voters;
    }

    public void addVoter(String userId) {
        voters.add(userId);
    }

    public boolean hasVoter(String userId) {
        return voters.contains(userId);
    }

    private UUID id = UUID.randomUUID();
    private String text;
    private String author;
    private int minVotes = 10;
    private int yes;
    private int no;
    private boolean completed;
    private Set<String> voters = new HashSet<>();

    @Override
    public String toString() {
        return text;
    }


}
