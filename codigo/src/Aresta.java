public class Aresta {
    private int destino;
    private boolean visitada = false;
    private int peso;

    public Aresta(int destino, int peso) {
        this.destino = destino;
        this.peso = peso;
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
