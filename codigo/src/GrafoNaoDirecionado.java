import java.util.List;

public class GrafoNaoDirecionado extends GrafoMutavel {
    public GrafoNaoDirecionado(String nome) {
        super(nome);
    }

    public GrafoNaoDirecionado() {
        this("Grafo Não Direcionado");
    }

    @Override
    public Grafo subGrafo(List<Integer> vertices){
        GrafoMutavel subgrafo = new GrafoNaoDirecionado("Subgrafo de " + this.nome());
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
    public Grafo bfs(int idVerticeInicio) {
        return null;
    }

    @Override
    public boolean addAresta(int origem, int destino, int peso) {
        return this.vertices.find(origem).addAresta(destino, peso) && this.vertices.find(destino).addAresta(origem, peso);
    }

    @Override
    public Aresta removeAresta(int origem, int destino) {
        this.vertices.find(destino).removeAresta(origem);
        return this.vertices.find(origem).removeAresta(destino);
    }

    @Override
    public Grafo dfs(int idVerticeInicio) {
        GrafoMutavel grafo = new GrafoNaoDirecionado();
        vertices.find(idVerticeInicio).visitar();
        grafo.addVertice(idVerticeInicio);
        List<Integer> vizinhos = vertices.find(idVerticeInicio).vizinhos();
        vizinhos.forEach(vizinho -> {
            if (!this.vertices.find(vizinho).visitado())
                dfs(grafo ,idVerticeInicio);
        });
        return grafo;
    }

    private void dfs(GrafoMutavel grafo, int idVertice) {
        if (this.vertices.find(idVertice).visitado())
            return;
        List<Integer> vizinhos = vertices.find(idVertice).vizinhos();
        vizinhos.forEach(vizinho -> {
            if (!this.vertices.find(vizinho).visitado()) {
                grafo.addVertice(vizinho);
                grafo.addAresta(idVertice, vizinho);
                dfs(grafo, vizinho);
            }
        });
    }

}
