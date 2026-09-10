import javax.swing.*;
import java.awt.*;

public class TelaCadastro extends JFrame {

    private SistemaUnicsul sistema;
    private JTextField campoNome;
    private JComboBox<String> comboCampus;

    public TelaCadastro(SistemaUnicsul sistema) {

        this.sistema = sistema;

        // ==============================
        // CONFIGURAÇÃO DA JANELA
        // ==============================

        setTitle("Cadastrar Aluno - Sistema Unicsul");
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
                new JLabel("CADASTRAR NOVO ALUNO");

        titulo.setFont(
                new Font("Arial", Font.BOLD, 28)
        );

        titulo.setForeground(Color.WHITE);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitulo =
                new JLabel("Preencha os dados do aluno");

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
        // FORMULÁRIO
        // ==============================

        JPanel formulario = new JPanel();

        formulario.setLayout(
                new GridLayout(4, 1, 10, 10)
        );

        formulario.setBackground(
                new Color(245, 247, 250)
        );

        formulario.setBorder(
                BorderFactory.createEmptyBorder(
                        35, 100, 20, 100
                )
        );

        JLabel labelNome =
                new JLabel("Nome do aluno:");

        labelNome.setFont(
                new Font("Arial", Font.BOLD, 15)
        );

        campoNome = new JTextField();

        campoNome.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        JLabel labelCampus =
                new JLabel("Campus:");

        labelCampus.setFont(
                new Font("Arial", Font.BOLD, 15)
        );

        String[] campi = {
                "Anália Franco",
                "Guarulhos",
                "Liberdade",
                "Paulista",
                "São Miguel",
                "Santo Amaro",
                "Villa Lobos"
        };

        comboCampus =
                new JComboBox<>(campi);

        comboCampus.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        formulario.add(labelNome);
        formulario.add(campoNome);
        formulario.add(labelCampus);
        formulario.add(comboCampus);

        painelPrincipal.add(
                formulario,
                BorderLayout.CENTER
        );

        // ==============================
        // BOTÕES
        // ==============================

        JPanel painelBotoes =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                20,
                                15
                        )
                );

        painelBotoes.setBackground(
                new Color(245, 247, 250)
        );

        JButton botaoCadastrar =
                new JButton("Cadastrar");

        JButton botaoVoltar =
                new JButton("Voltar");

        Font fonteBotao =
                new Font("Arial", Font.BOLD, 15);

        botaoCadastrar.setFont(fonteBotao);
        botaoVoltar.setFont(fonteBotao);

        botaoCadastrar.setPreferredSize(
                new Dimension(150, 45)
        );

        botaoVoltar.setPreferredSize(
                new Dimension(150, 45)
        );

        painelBotoes.add(botaoCadastrar);
        painelBotoes.add(botaoVoltar);

        painelPrincipal.add(
                painelBotoes,
                BorderLayout.SOUTH
        );

        // ==============================
        // BOTÃO CADASTRAR
        // ==============================

        botaoCadastrar.addActionListener(e -> {

            String nome =
                    campoNome.getText().trim();

            String campus =
                    (String) comboCampus.getSelectedItem();

            // Verifica nome vazio
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

            // Cadastra na árvore
            boolean cadastrado =
                    sistema.cadastrarAluno(
                            nome,
                            campus
                    );

            if (cadastrado) {

                JOptionPane.showMessageDialog(
                        this,
                        "Aluno cadastrado com sucesso!\n\n"
                        + "Nome: " + nome
                        + "\nCampus: " + campus,
                        "Cadastro realizado",
                        JOptionPane.INFORMATION_MESSAGE
                );

                campoNome.setText("");
                campoNome.requestFocus();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Este aluno já está cadastrado "
                        + "em algum campus.",
                        "Aluno já cadastrado",
                        JOptionPane.ERROR_MESSAGE
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