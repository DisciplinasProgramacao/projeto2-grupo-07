import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public abstract class GrafoMutavel extends Grafo {
    public GrafoMutavel(String nome) {
        super(nome);
    }

    public GrafoMutavel() {
    }

    public boolean addVertice(int id){
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    public Vertice removeVertice(int id) {
        return this.vertices.remove(id);
    }
    public abstract boolean addAresta(int origem, int destino, int peso);

    public boolean addAresta(int origem, int destino) {
        return this.addAresta(origem, destino, 0);
    }

    public abstract Aresta removeAresta(int origem, int destino);

    public void carregar(String nomeArquivo) throws FileNotFoundException {
        File arquivo = new File(nomeArquivo);
        Scanner in = new Scanner(arquivo);
        int n_vertices = in.nextInt();
        int n_arestas = in.nextInt();
        this.vertices = new ABB<Vertice>();
        for (int i = 0; i < n_vertices; i++) {
            this.vertices.add(i, new Vertice(i));
        }
        for (int i = 0; i < n_arestas; i++) {
            String[] linha = in.nextLine().trim().split(" ");
            int origem = Integer.parseInt(linha[0]);
            int destino = Integer.parseInt(linha[1]);
            if (linha.length == 3) {
                int peso = Integer.parseInt(linha[2]);
                this.addAresta(origem, destino, peso);
            }
            else {
                this.addAresta(origem, destino);
            }
        }
    }

    public void salvar(String nomeArquivo) throws IOException {
        FileWriter arquivo = new FileWriter(nomeArquivo);
        String grafo = "";
        arquivo.write(grafo);
        arquivo.close();
    }
}
