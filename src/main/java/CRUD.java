import com.fasterxml.jackson.core.JsonProcessingException;

public class CRUD {
    private final Converter converter = new Converter();
    private final DAO<Poll> dao = new DAO<>();

    public Poll create (String json) throws JsonProcessingException {
        final Poll poll = converter.parse(json);
        dao.save(poll);

        return poll;
    }

    public void read () {}
    public void update () {}
    public void delete () {}
}
