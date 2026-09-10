import java.util.ArrayList;
import java.util.List;

public class ArvoreBinaria {

    private No raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    // Inserir aluno na árvore
    public void inserir(String nome) {
        raiz = inserirRecursivo(raiz, nome);
    }

    private No inserirRecursivo(No atual, String nome) {

        if (atual == null) {
            return new No(nome);
        }

        if (nome.compareToIgnoreCase(atual.nome) < 0) {
            atual.esquerda = inserirRecursivo(atual.esquerda, nome);

        } else if (nome.compareToIgnoreCase(atual.nome) > 0) {
            atual.direita = inserirRecursivo(atual.direita, nome);
        }

        return atual;
    }

    // Buscar aluno
    public boolean buscar(String nome) {
        return buscarRecursivo(raiz, nome);
    }

    private boolean buscarRecursivo(No atual, String nome) {

        if (atual == null) {
            return false;
        }

        if (nome.equalsIgnoreCase(atual.nome)) {
            return true;
        }

        if (nome.compareToIgnoreCase(atual.nome) < 0) {
            return buscarRecursivo(atual.esquerda, nome);
        }

        return buscarRecursivo(atual.direita, nome);
    }

    // Retorna os alunos em ordem alfabética
    public List<String> listarEmOrdem() {

        List<String> alunos = new ArrayList<>();

        listarRecursivo(raiz, alunos);

        return alunos;
    }

    private void listarRecursivo(No atual, List<String> alunos) {

        if (atual != null) {

            // Esquerda
            listarRecursivo(atual.esquerda, alunos);

            // Raiz
            alunos.add(atual.nome);

            // Direita
            listarRecursivo(atual.direita, alunos);
        }
    }
}