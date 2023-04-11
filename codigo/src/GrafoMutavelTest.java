import org.junit.Assert;
import org.junit.Test;



class GrafoMutavelTest {

	@Test
    public void testAddAresta() {
        GrafoDirecionado grafo = new GrafoDirecionado();
        Assert.assertTrue(grafo.addAresta(1, 2, 5));
    }

    @Test
    public void testRemoveAresta() {
        GrafoDirecionado grafo = new GrafoDirecionado();
        grafo.addAresta(1, 2, 5);
        Aresta arestaRemovida = grafo.removeAresta(1, 2);
        Assert.assertNull(arestaRemovida);
    }

}
