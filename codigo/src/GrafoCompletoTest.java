import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GrafoCompletoTest {

	@Test
    public void testCriarGrafoCompleto() {
        GrafoCompleto gc = new GrafoCompleto(5);
        assertNotNull(gc);
    }
    
}
