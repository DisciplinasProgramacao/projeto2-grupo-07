import java.io.FileNotFoundException;
import java.util.*;

public class App {
    //Does not work on IDE Console
    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            }
            else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception ignored) {}
    }
    
    private static int novoGrafo() {
    	clearConsole();
    	@SuppressWarnings("resource")
		Scanner ng = new Scanner(System.in);

    	System.out.println("Selecione uma das opções abaixo:"
       			+ "\n [1]Gerar grafico pelo Console;"
       			+ "\n [2]Carregar grafo de um arquivo;");
    	int i = ng.nextInt();
    	if (i!=1 && i!=2) {		//Opção Default 
    		return 1;
    	}else {
    		return i;
    	}
    }
    
    private static int menuComplementar() {
    	clearConsole();
    	@SuppressWarnings("resource")
		Scanner mc = new Scanner(System.in);

    	System.out.println("Selecione uma das opções abaixo:"
    			+ "\n[1]Gerar grafo completo;"
    			+ "\n[2]Verificar se é completo;"
    			+ "\n[3]Gerar subgrafo;"
    			+ "\n[4]Salvar grafo;"
    			+ "\n[5]Imprimir grafo;"
    			+ "\n[6]Busca em largura;"
    			+ "\n[7]Busca em profundidade;"
    			+ "\n[0]Sair;");
    	int i = mc.nextInt();
    	if (i!=1 && i!=2 && i!=3 && i!=4 && i!=5 && i!=6 && i!=7 && i!=0) {		//Opção Default 
    		return 0;
    	}else {
    		return i;
    	}
    }
    
    public static void menuGrafo(String nome,String tipo) throws FileNotFoundException {
    	clearConsole();
        @SuppressWarnings("resource")
		Scanner mg = new Scanner(System.in);

    	switch (tipo) {
			case "D":
				GrafoDirecionado grafo = new GrafoDirecionado(nome);
				break;
			case "ND":
				GrafoNaoDirecionado grafo = new GrafoNaoDirecionado(nome);
				break;
    	}
    	System.out.println("Menu Grafo:");
    	int i = novoGrafo();
    	clearConsole();
		if(i==1) {		//Criar pelo console
    		//#######################
    		grafo.CriaGrafo();
    		//#######################
    	}else {			//Carregar grafo
    		System.out.println("Qual é o nome do Arquivo?");
    		String NomeArq = mg.nextLine();
    		grafo.carregar(NomeArq);
    	}
    	int tam;
		do{
			i = menuComplementar();
			clearConsole();
		    switch (i){
	    		case 1:			//Gerar Grafo Completo
	    			System.out.println("Digite a quantidade de Vértices do Grafo:");
	    			tam = mg.nextInt();
	    			grafo.grafoCompleto(tam);
	    			break;
	    		case 2:			//Verificar se é completo
	    			Boolean completo = grafo.completo();
	    			if(completo) {
	    				System.out.println("O grafo É Completo!");
	    			}else{
	    				System.out.println("O grafo Não É Completo!");
	    			}
	    			break;
	    		case 3:			//Gerar Subgrafo
	    			tam = grafo.tamanho();
	    			int b, c; 
	    			LinkedList<Integer> vertices = new LinkedList<>();
	    			for (int a = 0;a < tam; a++) {
	    				b = a++;
	    				System.out.println("Deseja manter o Vertice: "+b
	    						+"\n[1]Sim;"
                                +"\n[2]Não;");
	    				c = mg.nextInt();
	    				switch (c) {
	    					case 2:
	    						break;
	    					default:
	    						vertices.add(b);
	    				}		
	    			}
	    			grafo.subGrafo(vertices);
	    			break;
	    		case 4:			//Salvar Grafo
	    			System.out.println("Qual é o nome do Arquivo?");
	        		String NomeArq = mg.nextLine();
	        		grafo.salvar(NomeArq);
	    			break;
	    		case 5:			//Imprimir Grafo
	    			break;
	    		case 6:			//Busca Em Largura
	    			break;
	    		case 7:			//Busca Em Profundidade
	    			break;
	    		case 0:			//Sair
	    			break;
		    	}
		}while(i!=0);	 
    }
       
    public static void menuPrincipal() throws FileNotFoundException {
    	clearConsole();
    	@SuppressWarnings("resource")
		Scanner mp = new Scanner(System.in);

    	System.out.println("Digite o nome do novo Grafo:");
    	String nome = mp.nextLine();
    	clearConsole();
    	System.out.println("O Grafo '"+nome+"' é:\n [1]Direcionado;\n [2]Não Direcionado;");
    	int op = mp.nextInt();
    	clearConsole();
    	switch (op) {
    		case 1:
    			menuGrafo(nome,"D");
    			break;
    		default:
    			menuGrafo(nome,"ND");
    	}
    }
    
    public static void main(String[] args) throws FileNotFoundException{
    	@SuppressWarnings("resource")
		Scanner mm = new Scanner(System.in);

    	Boolean op = true;
    	do {
    		System.out.println("Deseja criar um novo Grafo?"
                    +"\n [1]Sim;"
                    +"\n [0]Não;");
    		int i = mm.nextInt();
    		switch (i) {
    			case 1:		//Cria um novo Grafo
    				menuPrincipal();
    				break;
    			default: 		//Finaliza a Aplicação
    				clearConsole();
    				System.out.println("Aplicação Finalizada!");
    				op = false;
    		}
    	}while(op);
    }
}
