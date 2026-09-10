import javax.swing.*;
import java.awt.*;

public class TelaLocalizar extends JFrame {

    private SistemaUnicsul sistema;
    private JTextField campoNome;
    private JLabel resultado;

    public TelaLocalizar(SistemaUnicsul sistema) {

        this.sistema = sistema;

        // ==============================
        // CONFIGURAÇÃO DA JANELA
        // ==============================

        setTitle("Localizar Aluno - Sistema Unicsul");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // ==============================
        // PAINEL PRINCIPAL
        // ==============================

        JPanel painelPrincipal =
                new JPanel(new BorderLayout());

        painelPrincipal.setBackground(
                new Color(245, 247, 250)
        );

        // ==============================
        // CABEÇALHO
        // ==============================

        JPanel cabecalho = new JPanel();

        cabecalho.setLayout(
                new BoxLayout(
                        cabecalho,
                        BoxLayout.Y_AXIS
                )
        );

        cabecalho.setBackground(
                new Color(30, 60, 100)
        );

        cabecalho.setBorder(
                BorderFactory.createEmptyBorder(
                        25, 10, 25, 10
                )
        );

        JLabel titulo =
                new JLabel("LOCALIZAR ALUNO");

        titulo.setFont(
                new Font("Arial", Font.BOLD, 28)
        );

        titulo.setForeground(Color.WHITE);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitulo =
                new JLabel("Consulte em qual campus o aluno está cadastrado");

        subtitulo.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        subtitulo.setForeground(Color.WHITE);
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        cabecalho.add(titulo);
        cabecalho.add(Box.createVerticalStrut(8));
        cabecalho.add(subtitulo);

        painelPrincipal.add(
                cabecalho,
                BorderLayout.NORTH
        );

        // ==============================
        // ÁREA CENTRAL
        // ==============================

        JPanel centro = new JPanel();

        centro.setLayout(
                new BoxLayout(
                        centro,
                        BoxLayout.Y_AXIS
                )
        );

        centro.setBackground(
                new Color(245, 247, 250)
        );

        centro.setBorder(
                BorderFactory.createEmptyBorder(
                        40, 100, 20, 100
                )
        );

        // Nome
        JLabel labelNome =
                new JLabel("Nome do aluno:");

        labelNome.setFont(
                new Font("Arial", Font.BOLD, 15)
        );

        labelNome.setAlignmentX(Component.LEFT_ALIGNMENT);

        campoNome = new JTextField();

        campoNome.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        campoNome.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        40
                )
        );

        campoNome.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Botão localizar
        JButton botaoLocalizar =
                new JButton("Localizar");

        botaoLocalizar.setFont(
                new Font("Arial", Font.BOLD, 15)
        );

        botaoLocalizar.setPreferredSize(
                new Dimension(160, 45)
        );

        botaoLocalizar.setMaximumSize(
                new Dimension(160, 45)
        );

        botaoLocalizar.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // Resultado
        resultado =
                new JLabel(
                        " ",
                        SwingConstants.CENTER
                );

        resultado.setFont(
                new Font("Arial", Font.BOLD, 17)
        );

        resultado.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        centro.add(labelNome);
        centro.add(Box.createVerticalStrut(10));
        centro.add(campoNome);
        centro.add(Box.createVerticalStrut(25));
        centro.add(botaoLocalizar);
        centro.add(Box.createVerticalStrut(30));
        centro.add(resultado);

        painelPrincipal.add(
                centro,
                BorderLayout.CENTER
        );

        // ==============================
        // BOTÃO VOLTAR
        // ==============================

        JPanel painelInferior =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER
                        )
                );

        painelInferior.setBackground(
                new Color(245, 247, 250)
        );

        JButton botaoVoltar =
                new JButton("Voltar");

        botaoVoltar.setFont(
                new Font("Arial", Font.BOLD, 15)
        );

        botaoVoltar.setPreferredSize(
                new Dimension(150, 45)
        );

        painelInferior.add(botaoVoltar);

        painelPrincipal.add(
                painelInferior,
                BorderLayout.SOUTH
        );

        // ==============================
        // BOTÃO LOCALIZAR
        // ==============================

        botaoLocalizar.addActionListener(e -> {

            String nome =
                    campoNome.getText().trim();

            // Verifica campo vazio
            if (nome.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Digite o nome do aluno.",
                        "Atenção",
                        JOptionPane.WARNING_MESSAGE
                );

                campoNome.requestFocus();

                return;
            }

            // Procura o aluno
            String campus =
                    sistema.localizarAluno(nome);

            if (campus != null) {

                resultado.setText(
                        "<html><center>"
                        + "ALUNO ENCONTRADO!<br><br>"
                        + "Nome: " + nome
                        + "<br>"
                        + "Campus: " + campus
                        + "</center></html>"
                );

                resultado.setForeground(
                        new Color(0, 120, 60)
                );

            } else {

                resultado.setText(
                        "<html><center>"
                        + "ALUNO NÃO LOCALIZADO"
                        + "<br><br>"
                        + "O aluno não está cadastrado."
                        + "</center></html>"
                );

                resultado.setForeground(
                        Color.RED
                );
            }
        });

        // ==============================
        // BOTÃO VOLTAR
        // ==============================

        botaoVoltar.addActionListener(e -> {
            dispose();
        });

        // ==============================
        // FINALIZAÇÃO
        // ==============================

        add(painelPrincipal);
    }
}