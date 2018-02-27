import org.junit.Test;
import main.java.Model.Client;
import static org.junit.Assert.*;

public class ClientTest {
    private Client mario = new Client(99,"Mario","Rodriguez","dec");

    @Test
    public void getFirstName() {
        assertEquals("Mario", mario.getFirstName());
    }
}