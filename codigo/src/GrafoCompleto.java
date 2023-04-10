import java.util.List;

public class GrafoCompleto extends Grafo {
    public GrafoCompleto(String nome, int ordem) {
        super(nome);
        for (int i = 0; i < ordem; i++) {
            Vertice vertice = new Vertice(i);
            for (int j = 0; j < ordem; j++) {
                if (j != i)
                    vertice.addAresta(j);
            }
        }
    }

    public GrafoCompleto(int ordem) {
        this("Grafo completo", ordem);
    }

    public GrafoCompleto(String nome, List<Integer> vertices) {
        super(nome);
        vertices.forEach((vertice) -> {
            this.vertices.add(vertice, new Vertice(vertice));
            vertices.forEach((destino) -> {
                if (vertice != destino)
                    this.vertices.find(vertice).addAresta(destino);
            });
        });
    }

    @Override
    public Grafo subGrafo(List<Integer> vertices){
        return new GrafoCompleto("Subgrafo de " + this.nome, vertices);
    }
}
