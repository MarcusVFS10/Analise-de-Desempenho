// Classe Principal com Testes Completos

import java.util.function.Supplier;

public class Main {

    
    // MEDIR MÉDIA - reexecuta a operação 5x
    // mas sempre em uma NOVA estrutura
    
    public static long medirMedia(Supplier<Object> s) {
        long soma = 0;
        for (int i = 0; i < 5; i++) {
            long ini = System.nanoTime();
            s.get();
            soma += (System.nanoTime() - ini);
        }
        return soma / 5;
    }

    
    // GERAR VETORES DE TESTE
    
    public static int[] gerarDados(int n, int modo) {
        int[] v = new int[n];
        if (modo == 1) { 
            for (int i = 0; i < n; i++) v[i] = i + 1;
        } else if (modo == 2) { 
            for (int i = 0; i < n; i++) v[i] = n - i;
        } else { 
            for (int i = 0; i < n; i++) v[i] = (int)(Math.random() * n);
        }
        return v;
    }

    
    // MAIN FINAL
    
    public static void main(String[] args) {

        int[] tamanhos = {100, 1000, 10000};
        int[] modos = {1, 2, 3}; 

        for (int tam : tamanhos) {
            System.out.println("\n==================== TAMANHO: " + tam + " ====================");

            for (int modo : modos) {

                System.out.println("\n---------- MODO " + modo + " ----------");

                int[] dados = gerarDados(tam, modo);

                
                // INSERÇÃO VETOR
                
                long tempoInsVetor = medirMedia(() -> {
                    Vetor v = new Vetor(tam);
                    for (int x : dados) v.inserir(x);
                    return null;
                });

                System.out.println("Inserção Vetor: " + tempoInsVetor);


                
                // INSERÇÃO ABB
                
                long tempoInsABB = medirMedia(() -> {
                    ABB abbTemp = new ABB();
                    for (int x : dados) abbTemp.inserir(x);
                    return null;
                });

                System.out.println("Inserção ABB: " + tempoInsABB);


                
                // INSERÇÃO AVL
               
                long tempoInsAVL = medirMedia(() -> {
                    AVL avlTemp = new AVL();
                    for (int x : dados) avlTemp.inserir(x);
                    return null;
                });

                System.out.println("Inserção AVL: " + tempoInsAVL);


                
                // PREPARAR ESTRUTURAS REAIS PARA BUSCA
                // (para não testar em árvores vazias)
                
                Vetor vet = new Vetor(tam);
                ABB abb = new ABB();
                AVL avl = new AVL();

                for (int x : dados) {
                    vet.inserir(x);
                    abb.inserir(x);
                    avl.inserir(x);
                }

                int primeiro = dados[0];
                int ultimo = dados[dados.length - 1];
                int meio = dados[dados.length / 2];
                int inexistente = -999999;


                
                // BUSCAS VETOR
                
                System.out.println("Buscas Vetor:");

                long t1 = medirMedia(() -> { vet.buscarSequencial(primeiro); return null; });
                long t2 = medirMedia(() -> { vet.buscarSequencial(ultimo); return null; });
                long t3 = medirMedia(() -> { vet.buscarSequencial(meio); return null; });
                long t4 = medirMedia(() -> { vet.buscarSequencial(inexistente); return null; });

                System.out.println("  Seq - primeiro: " + t1);
                System.out.println("  Seq - último: " + t2);
                System.out.println("  Seq - meio: " + t3);
                System.out.println("  Seq - inexistente: " + t4);


                
                // BUSCAS ABB
                
                System.out.println("Buscas ABB:");

                long a1 = medirMedia(() -> { abb.buscar(primeiro); return null; });
                long a2 = medirMedia(() -> { abb.buscar(ultimo); return null; });
                long a3 = medirMedia(() -> { abb.buscar(meio); return null; });
                long a4 = medirMedia(() -> { abb.buscar(inexistente); return null; });

                System.out.println("  ABB - primeiro: " + a1);
                System.out.println("  ABB - último: " + a2);
                System.out.println("  ABB - meio: " + a3);
                System.out.println("  ABB - inexistente: " + a4);


                
                // BUSCAS AVL
                
                System.out.println("Buscas AVL:");

                long av1 = medirMedia(() -> { avl.buscar(primeiro); return null; });
                long av2 = medirMedia(() -> { avl.buscar(ultimo); return null; });
                long av3 = medirMedia(() -> { avl.buscar(meio); return null; });
                long av4 = medirMedia(() -> { avl.buscar(inexistente); return null; });

                System.out.println("  AVL - primeiro: " + av1);
                System.out.println("  AVL - último: " + av2);
                System.out.println("  AVL - meio: " + av3);
                System.out.println("  AVL - inexistente: " + av4);
            }
        }
    }
}
