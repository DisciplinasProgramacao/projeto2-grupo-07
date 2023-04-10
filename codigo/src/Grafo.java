/** 
 * MIT License
 *
 * Copyright(c) 2021-23 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.util.Arrays;
import java.util.List;

/**
 * Classe básica para um Grafo simples não direcionado.
 */
public abstract class Grafo {
    public final String nome;
    protected ABB<Vertice> vertices;

    public static Grafo grafoCompleto(int ordem){
        return null;
    }

    /**
     * Construtor. Cria um grafo vazio com um nome escolhido pelo usuário. Em caso de nome não informado 
     * (string vazia), recebe o nome genérico "Grafo"
     */
    public Grafo(String nome){
        this.nome = nome;
        this.vertices = new ABB<>();
    }

    public Grafo() {
        this("Grafo");
    }

    public String nome(){
        return this.nome;
    }

    public Vertice existeVertice(int idVertice){
        return this.vertices.find(idVertice);
    }

    public Aresta existeAresta(int verticeA, int verticeB){
        return this.vertices.find(verticeA).existeAresta(verticeB);
    }
    
    
    public boolean completo(){
       Vertice[] vertices = new Vertice[this.vertices.size()];
       return Arrays.stream(this.vertices.allElements(vertices)).anyMatch(vertice -> {
           return Arrays.stream(this.vertices.allElements(vertices)).anyMatch(destino -> {
               if (vertice.getId() != destino.getId() && vertice.existeAresta(destino.getId()) != null)
                   return true;
               return false;
           });
       });
    }
    public abstract Grafo subGrafo(List<Integer> vertices);

    public int tamanho(){
        return Arrays.stream(this.vertices.allElements(new Vertice[100])).mapToInt(Vertice::grau).sum();
    }

    public int ordem(){
        return this.vertices.size();
    }

}