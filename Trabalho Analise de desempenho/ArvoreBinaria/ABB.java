// Árvore Binária de Busca (ABB)

public class ABB {

    private NoABB raiz;

    public void inserir(int valor) {

        NoABB novo = new NoABB(valor);

        
        if (raiz == null) {
            raiz = novo;
            return;
        }

        NoABB atual = raiz;
        NoABB pai = null;

        while (atual != null) {
            pai = atual;

            if (valor < atual.valor) {
                atual = atual.esquerda;
            } else if (valor > atual.valor) {
                atual = atual.direita;
            } else {
                return; 
            }
        }

        if (valor < pai.valor) pai.esquerda = novo;
        else pai.direita = novo;
    }


    public boolean buscar(int valor) {
        NoABB atual = raiz;

        while (atual != null) {
            if (valor == atual.valor) return true;
            atual = (valor < atual.valor) ? atual.esquerda : atual.direita;
        }
        return false;
    }
}
