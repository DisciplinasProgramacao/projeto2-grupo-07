public class Aresta {
    private int destino;
    private boolean visitada;
    private int peso;

    public Aresta(int destino, int peso) {
        this.destino = destino;
        this.peso = peso;
        this.visitada = false;
    }

    public Aresta(int destino) {
        this(destino, 0);
    }

    public int destino() {
        return destino;
    }

    public boolean visitada() {
        return visitada;
    }

    public int peso() {
        return peso;
    }

    public void visitar() {
        visitada = true;
    }

    public void limparVisita() {
        visitada = false;
    }
}
