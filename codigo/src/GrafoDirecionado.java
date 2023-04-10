import java.util.List;

public class GrafoDirecionado extends GrafoMutavel {
    public GrafoDirecionado(String nome) {
        super(nome);
    }

    public GrafoDirecionado() {
        this("Grafo Direcionado");
    }

    @Override
    public Grafo subGrafo(List<Integer> vertices){
        GrafoMutavel subgrafo = new GrafoDirecionado("Subgrafo de " + this.nome());
        vertices.forEach(id -> {
            subgrafo.addVertice(id);
            vertices.forEach(destino -> {
                Aresta aresta = this.vertices.find(id).existeAresta(destino);
                if (aresta != null) {
                    subgrafo.addAresta(id, destino, aresta.peso());
                }
            });
        });
        return subgrafo;
    }

    @Override
    public boolean addAresta(int origem, int destino, int peso) {
        return this.vertices.find(origem).addAresta(destino, peso);
    }

    @Override
    public Aresta removeAresta(int origem, int destino) {
        return this.vertices.find(origem).removeAresta(destino);
    }
}
