// Árvore AVL

public class AVL {

    private NoAVL raiz;

    private int altura(NoAVL no) {
        return no == null ? 0 : no.altura;
    }

    private int fatorBalanceamento(NoAVL no) {
        return no == null ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    
    // ROTAÇÃO À DIREITA (SAFE)
    
    private NoAVL rotacaoDireita(NoAVL y) {
        if (y == null || y.esquerda == null) return y;

        NoAVL x = y.esquerda;
        NoAVL T2 = x.direita;

        
        x.direita = y;
        y.esquerda = T2;

        
        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    
    // ROTAÇÃO À ESQUERDA (SAFE)
    
    private NoAVL rotacaoEsquerda(NoAVL x) {
        if (x == null || x.direita == null) return x;

        NoAVL y = x.direita;
        NoAVL T2 = y.esquerda;

      
        y.esquerda = x;
        x.direita = T2;


        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    
    // INSERÇÃO COM BALANCEAMENTO
    
    private NoAVL inserirRec(NoAVL no, int valor) {

        if (no == null)
            return new NoAVL(valor);

        if (valor < no.valor)
            no.esquerda = inserirRec(no.esquerda, valor);

        else if (valor > no.valor)
            no.direita = inserirRec(no.direita, valor);

        else
            return no; 

        
        no.altura = 1 + max(altura(no.esquerda), altura(no.direita));

        
        int fb = fatorBalanceamento(no);

       
        // CASO 1 – ESQUERDA ESQUERDA
        
        if (fb > 1 && valor < no.esquerda.valor)
            return rotacaoDireita(no);
            
        
        // CASO 2 – DIREITA DIREITA
        
        if (fb < -1 && valor > no.direita.valor)
            return rotacaoEsquerda(no);

        
        // CASO 3 – ESQUERDA DIREITA
        
        if (fb > 1 && valor > no.esquerda.valor) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        
        // CASO 4 – DIREITA ESQUERDA
        
        if (fb < -1 && valor < no.direita.valor) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

   
    // BUSCA
    
    public boolean buscar(int chave) {
        return buscarRec(raiz, chave) != null;
    }

    private NoAVL buscarRec(NoAVL no, int chave) {
        if (no == null) return null;

        if (chave == no.valor) return no;

        return (chave < no.valor)
            ? buscarRec(no.esquerda, chave)
            : buscarRec(no.direita, chave);
    }
}
