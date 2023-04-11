import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArestaTest {

	    @Test
	    public void testarVisita() {
	        Aresta a = new Aresta(5, 2);
	        assertFalse(a.visitada());
	        a.visitar();
	        assertTrue(a.visitada());
	        a.limparVisita();
	        assertFalse(a.visitada());
	    }
}
