import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SistemaUnicsul sistema = new SistemaUnicsul();

        SwingUtilities.invokeLater(() -> {

            TelaPrincipal tela = new TelaPrincipal(sistema);

            tela.setVisible(true);
        });
    }
}