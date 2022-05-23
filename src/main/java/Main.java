import com.fasterxml.jackson.core.JsonProcessingException;

public class Main {
    public static void main (String[] args) throws JsonProcessingException {
        final CRUD crud = new CRUD();
        crud.create(args[0]);
    }
}