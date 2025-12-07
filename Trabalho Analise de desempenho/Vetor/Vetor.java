// Classe Vetor Dinâmico

class Vetor {
    private int[] dados;
    private int tamanho;

    public Vetor(int capacidade) {
        dados = new int[capacidade];
        tamanho = 0;
    }

    public void inserir(int valor) {
        if (tamanho == dados.length) {
            int[] novo = new int[dados.length * 2];
            for (int i = 0; i < dados.length; i++) novo[i] = dados[i];
            dados = novo;
        }
        dados[tamanho++] = valor;
    }

    public int buscarSequencial(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (dados[i] == valor) return i;
        }
        return -1;
    }

    public int buscarBinaria(int valor) {
        int ini = 0, fim = tamanho - 1;
        while (ini <= fim) {
            int meio = (ini + fim) / 2;
            if (dados[meio] == valor) return meio;
            if (valor < dados[meio]) fim = meio - 1;
            else ini = meio + 1;
        }
        return -1;
    }

    public int[] getArray() {
        int[] copia = new int[tamanho];
        for (int i = 0; i < tamanho; i++) copia[i] = dados[i];
        return copia;
    }
}
