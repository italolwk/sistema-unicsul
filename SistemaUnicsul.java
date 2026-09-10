import java.util.List;
import java.util.ArrayList;

public class SistemaUnicsul {

    private ArvoreBinaria analiaFranco;
    private ArvoreBinaria guarulhos;
    private ArvoreBinaria liberdade;
    private ArvoreBinaria paulista;
    private ArvoreBinaria saoMiguel;
    private ArvoreBinaria santoAmaro;
    private ArvoreBinaria villaLobos;

    // Construtor
    public SistemaUnicsul() {

        analiaFranco = new ArvoreBinaria();
        guarulhos = new ArvoreBinaria();
        liberdade = new ArvoreBinaria();
        paulista = new ArvoreBinaria();
        saoMiguel = new ArvoreBinaria();
        santoAmaro = new ArvoreBinaria();
        villaLobos = new ArvoreBinaria();
    }

    // VERIFICAR SE O ALUNO JÁ EXISTE

    public boolean alunoExiste(String nome) {

        return analiaFranco.buscar(nome)
                || guarulhos.buscar(nome)
                || liberdade.buscar(nome)
                || paulista.buscar(nome)
                || saoMiguel.buscar(nome)
                || santoAmaro.buscar(nome)
                || villaLobos.buscar(nome);
    }

    // CADASTRAR ALUNO

    public boolean cadastrarAluno(String nome, String campus) {

        if (nome == null || nome.trim().isEmpty()) {
            return false;
        }

        if (campus == null || campus.trim().isEmpty()) {
            return false;
        }

        nome = nome.trim();
        campus = campus.trim();

        // Verifica se o aluno já existe em qualquer campus
        if (alunoExiste(nome)) {
            return false;
        }

        switch (campus) {

            case "Anália Franco":
                analiaFranco.inserir(nome);
                break;

            case "Guarulhos":
                guarulhos.inserir(nome);
                break;

            case "Liberdade":
                liberdade.inserir(nome);
                break;

            case "Paulista":
                paulista.inserir(nome);
                break;

            case "São Miguel":
                saoMiguel.inserir(nome);
                break;

            case "Santo Amaro":
                santoAmaro.inserir(nome);
                break;

            case "Villa Lobos":
                villaLobos.inserir(nome);
                break;

            default:
                return false;
        }

        return true;
    }

    // LOCALIZAR ALUNO

    public String localizarAluno(String nome) {

        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }

        nome = nome.trim();

        if (analiaFranco.buscar(nome)) {
            return "Anália Franco";
        }

        if (guarulhos.buscar(nome)) {
            return "Guarulhos";
        }

        if (liberdade.buscar(nome)) {
            return "Liberdade";
        }

        if (paulista.buscar(nome)) {
            return "Paulista";
        }

        if (saoMiguel.buscar(nome)) {
            return "São Miguel";
        }

        if (santoAmaro.buscar(nome)) {
            return "Santo Amaro";
        }

        if (villaLobos.buscar(nome)) {
            return "Villa Lobos";
        }

        return null;
    }

    // LISTAR ALUNOS DO CAMPUS

    public List<String> listarAlunosCampus(String campus) {

        if (campus == null || campus.trim().isEmpty()) {
            return new ArrayList<>();
        }

        switch (campus) {

            case "Anália Franco":
                return analiaFranco.listarEmOrdem();

            case "Guarulhos":
                return guarulhos.listarEmOrdem();

            case "Liberdade":
                return liberdade.listarEmOrdem();

            case "Paulista":
                return paulista.listarEmOrdem();

            case "São Miguel":
                return saoMiguel.listarEmOrdem();

            case "Santo Amaro":
                return santoAmaro.listarEmOrdem();

            case "Villa Lobos":
                return villaLobos.listarEmOrdem();

            default:
                return new ArrayList<>();
        }
    }
}