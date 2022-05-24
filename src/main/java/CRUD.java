import java.io.IOException;
import java.util.UUID;

public class CRUD {
    private final Converter converter = new Converter();
    private final DAO dao = new DAO();

    public Poll create(String json) throws IOException {
        final Poll poll = converter.parse(json);
        dao.save(poll);

        return poll;
    }

    public Poll read(UUID id) throws IOException {
        return dao.get(id);
    }

    public Poll update(Poll poll) throws IOException {
        dao.save(poll);
        return poll;
    }

    public Poll vote(UUID id, boolean vote, String userId) throws IOException {
        Poll poll = read(id);

        if (poll.hasVoter(userId)) {
            throw new UnsupportedOperationException("you have already voted");
        } else {
            poll.addVoter(userId);
        }

        if (vote) {
            poll.setYes(poll.getYes() + 1);
        } else {
            poll.setNo(poll.getNo() + 1);
        }

        return update(poll);
    }

    public void delete() {
    }
}
