# 📊 Análise de Desempenho de Estruturas de Dados em Java

Este projeto tem como objetivo analisar o desempenho de diferentes estruturas de dados implementadas manualmente em Java. São comparadas inserções e buscas em:

- Vetor Dinâmico
- Árvore Binária de Busca (ABB)
- Árvore AVL

Além disso, foram analisados dois algoritmos de ordenação aplicados ao vetor:

- Bubble Sort (simples)
- MergeSort (avançado)

Todos os tempos de execução foram medidos em diferentes tamanhos de amostras e em ordens diversas.

---

## 🧩 Estruturas Implementadas

### ✔ Vetor
- Inserção sequencial
- Busca sequencial
- Busca binária (após ordenação)

### ✔ ABB – Árvore Binária de Busca
- Inserção iterativa (evita StackOverflow)
- Busca iterativa

### ✔ AVL – Árvore Binária Auto-Balanceada
- Inserção com rotações
- Busca binária
- Balanceamento garantido

### ✔ Algoritmos de Ordenação
- Bubble Sort
- MergeSort

---

## 🧪 Metodologia Utilizada

Para cada estrutura foram executados testes de:

- **Inserção**
- **Busca**
- **Ordenação (apenas vetor)**

E para cada teste foram avaliados:

- **3 tamanhos de conjuntos de dados:**  
  - 100  
  - 1.000  
  - 10.000  

- **3 modos de geração dos dados:**  
  - Ordenados (1, 2, 3, ...)  
  - Inversos (100, 99, 98, ...)  
  - Aleatórios  

Cada teste foi executado **5 vezes**, e o tempo final registrado foi a **média** das execuções.

Os tempos foram coletados em **nanosegundos** usando `System.nanoTime()`.

---

## ⚙️ Como Compilar e Executar o Projeto

Siga os passos abaixo diretamente no terminal **dentro da pasta onde está o arquivo `Main.java`**.

---

### 📌 Compilar todas as classes

Compile todas as estruturas (Vetor, ABB, AVL, Sorts) de uma só vez:

```bash
javac */*.java Main.java
```
▶ Executar o programa

Após a compilação, execute:

java Main

---

💡 Observações Importantes

Não é necessário usar package em nenhuma classe.

O comando acima compila automaticamente as seguintes pastas:

/Vetor
/ArvoreBinaria
/ArvoreAVL
/Sorts


Funciona em Windows, Linux e macOS.

Caso utilize uma IDE (VSCode, IntelliJ, Eclipse, jGRASP), basta abrir a pasta raiz e rodar o Main.java.

---

## 📁 Estrutura do Projeto

A organização do projeto está dividida em pacotes/folders, da seguinte forma:

/ArvoreAVL
AVL.java
NoAVL.java

/ArvoreBinaria
ABB.java
NoABB.java

/Sorts
BubbleSort.java
MergeSort.java

/Vetor
Vetor.java

Main.java

---

🏁 Conclusão Final

A análise permite concluir que:

A AVL é a melhor estrutura para busca + inserção constantes.

O Vetor + MergeSort + Busca Binária é excelente para grandes conjuntos estáticos.

A ABB, sem balanceamento, não deve ser usada em cenários que possam gerar entradas ordenadas.

Estas conclusões reforçam a importância da escolha adequada de estruturas conforme o caso de uso.

---

👨‍💻 Autor

Marcus Vinícius Ferreira
Curso: Análise e Desenvolvimento de Sistemas
Ano: 2025

