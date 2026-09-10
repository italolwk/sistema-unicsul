import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaListar extends JFrame {

    private SistemaUnicsul sistema;
    private JComboBox<String> comboCampus;
    private JTextArea areaAlunos;

    public TelaListar(SistemaUnicsul sistema) {

        this.sistema = sistema;

        // ==============================
        // CONFIGURAÇÃO DA JANELA
        // ==============================

        setTitle("Listar Alunos - Sistema Unicsul");
        setSize(650, 550);
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
                new JLabel("LISTAR ALUNOS DO CAMPUS");

        titulo.setFont(
                new Font("Arial", Font.BOLD, 28)
        );

        titulo.setForeground(Color.WHITE);
        titulo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel subtitulo =
                new JLabel(
                        "Consulte os alunos cadastrados em cada campus"
                );

        subtitulo.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        subtitulo.setForeground(Color.WHITE);
        subtitulo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        cabecalho.add(titulo);
        cabecalho.add(
                Box.createVerticalStrut(8)
        );
        cabecalho.add(subtitulo);

        painelPrincipal.add(
                cabecalho,
                BorderLayout.NORTH
        );

        // ==============================
        // ÁREA CENTRAL
        // ==============================

        JPanel centro = new JPanel(
                new BorderLayout(10, 15)
        );

        centro.setBackground(
                new Color(245, 247, 250)
        );

        centro.setBorder(
                BorderFactory.createEmptyBorder(
                        25, 50, 15, 50
                )
        );

        // ==============================
        // SELEÇÃO DO CAMPUS
        // ==============================

        JPanel painelCampus =
                new JPanel(
                        new BorderLayout(10, 10)
                );

        painelCampus.setBackground(
                new Color(245, 247, 250)
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
                new Font("Arial", Font.PLAIN, 15)
        );

        JButton botaoListar =
                new JButton("Listar Alunos");

        botaoListar.setFont(
                new Font("Arial", Font.BOLD, 15)
        );

        painelCampus.add(
                labelCampus,
                BorderLayout.WEST
        );

        painelCampus.add(
                comboCampus,
                BorderLayout.CENTER
        );

        painelCampus.add(
                botaoListar,
                BorderLayout.EAST
        );

        centro.add(
                painelCampus,
                BorderLayout.NORTH
        );

        // ==============================
        // ÁREA DE RESULTADO
        // ==============================

        areaAlunos =
                new JTextArea();

        areaAlunos.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        areaAlunos.setEditable(false);

        areaAlunos.setLineWrap(true);

        areaAlunos.setWrapStyleWord(true);

        areaAlunos.setMargin(
                new Insets(15, 15, 15, 15)
        );

        JScrollPane scroll =
                new JScrollPane(areaAlunos);

        centro.add(
                scroll,
                BorderLayout.CENTER
        );

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
        // BOTÃO LISTAR
        // ==============================

        botaoListar.addActionListener(e -> {

            String campus =
                    (String) comboCampus.getSelectedItem();

            List<String> alunos =
                    sistema.listarAlunosCampus(campus);

            areaAlunos.setText("");

            if (alunos.isEmpty()) {

                areaAlunos.setText(
                        "Nenhum aluno cadastrado neste campus."
                );

            } else {

                areaAlunos.append(
                        "ALUNOS DO CAMPUS: "
                        + campus
                        + "\n"
                );

                areaAlunos.append(
                        "====================================\n\n"
                );

                int numero = 1;

                for (String aluno : alunos) {

                    areaAlunos.append(
                            numero
                            + ". "
                            + aluno
                            + "\n"
                    );

                    numero++;
                }
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