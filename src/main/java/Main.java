import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final CRUD crud = new CRUD();
        Poll poll1 = crud.create(args[0]);
        Poll poll2 = crud.read(poll1.getId());

        assert poll1.getId().equals(poll2.getId());
        assert poll1.getText().equals(poll2.getText());

        poll1 = crud.vote(poll1.getId(), true, "IVAN");
        assert poll1.hasVoter("IVAN");
        assert poll1.getYes() == 1;

        try {
            crud.vote(poll1.getId(), true, "IVAN");
            throw new IllegalStateException("test failed");
        } catch (UnsupportedOperationException error) {
            assert error.getMessage() != null;
        }

    }
}