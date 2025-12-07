// Merge Sort (avançado)

class MergeSort {
    public static void ordenar(int[] v) {
        mergeSort(v, 0, v.length - 1);
    }

    private static void mergeSort(int[] v, int ini, int fim) {
        if (ini >= fim) return;
        int meio = (ini + fim) / 2;
        mergeSort(v, ini, meio);
        mergeSort(v, meio + 1, fim);
        merge(v, ini, meio, fim);
    }

    private static void merge(int[] v, int ini, int meio, int fim) {
        int[] temp = new int[fim - ini + 1];
        int i = ini, j = meio + 1, k = 0;

        while (i <= meio && j <= fim) {
            if (v[i] <= v[j]) temp[k++] = v[i++];
            else temp[k++] = v[j++];
        }
        while (i <= meio) temp[k++] = v[i++];
        while (j <= fim) temp[k++] = v[j++];

        for (i = 0; i < temp.length; i++) v[ini + i] = temp[i];
    }
}