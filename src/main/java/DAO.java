import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.UUID;

public class DAO {

    private final Converter converter = new Converter();

    public void save(Poll poll) throws IOException {
        // TODO: add db

        String json = converter.stringify(poll);
        Path path = Paths.get(poll.getId().toString() + ".json");

        if (!Files.exists(path)) {
            Files.createFile(path);
        }

        Files.write(path, Collections.singletonList(json));

        System.out.println("saved data: " + poll);
    }

    public Poll get(UUID id) throws IOException {
        Path path = Paths.get(id.toString() + ".json");

        if (!Files.exists(path)) {
            throw new IllegalArgumentException("no such poll");
        }

        String json = Files.readAllLines(path).get(0);
        Poll poll = converter.parse(json);

        System.out.println("got data: " + poll);

        return poll;
    }
}
