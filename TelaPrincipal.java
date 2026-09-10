import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {

    private SistemaUnicsul sistema;

    public TelaPrincipal(SistemaUnicsul sistema) {

        this.sistema = sistema;

        // ==============================
        // CONFIGURAÇÃO DA JANELA
        // ==============================

        setTitle("Sistema Unicsul");
        setSize(650, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // ==============================
        // PAINEL PRINCIPAL
        // ==============================

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBackground(new Color(245, 247, 250));

        // ==============================
        // CABEÇALHO
        // ==============================

        JPanel cabecalho = new JPanel();
        cabecalho.setLayout(new BoxLayout(cabecalho, BoxLayout.Y_AXIS));
        cabecalho.setBackground(new Color(30, 60, 100));

        JLabel titulo = new JLabel("SISTEMA UNICSUL");
        titulo.setFont(new Font("Arial", Font.BOLD, 32));
        titulo.setForeground(Color.WHITE);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitulo = new JLabel("Gerenciamento de Alunos");
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 17));
        subtitulo.setForeground(Color.WHITE);
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        cabecalho.setBorder(
                BorderFactory.createEmptyBorder(25, 10, 25, 10)
        );

        cabecalho.add(titulo);
        cabecalho.add(Box.createVerticalStrut(8));
        cabecalho.add(subtitulo);

        painelPrincipal.add(
                cabecalho,
                BorderLayout.NORTH
        );

        // ==============================
        // ÁREA DOS BOTÕES
        // ==============================

        JPanel painelBotoes = new JPanel();

        painelBotoes.setLayout(
                new GridLayout(4, 1, 0, 15)
        );

        painelBotoes.setBackground(
                new Color(245, 247, 250)
        );

        painelBotoes.setBorder(
                BorderFactory.createEmptyBorder(
                        40, 120, 35, 120
                )
        );

        // ==============================
        // BOTÕES
        // ==============================

        JButton botaoCadastrar =
                new JButton("Cadastrar Novo Aluno");

        JButton botaoLocalizar =
                new JButton("Localizar Aluno");

        JButton botaoListar =
                new JButton("Listar Alunos do Campus");

        JButton botaoSair =
                new JButton("Sair");

        Font fonte =
                new Font("Arial", Font.BOLD, 16);

        botaoCadastrar.setFont(fonte);
        botaoLocalizar.setFont(fonte);
        botaoListar.setFont(fonte);
        botaoSair.setFont(fonte);

        // Tamanho dos botões
        Dimension tamanho =
                new Dimension(400, 55);

        botaoCadastrar.setPreferredSize(tamanho);
        botaoLocalizar.setPreferredSize(tamanho);
        botaoListar.setPreferredSize(tamanho);
        botaoSair.setPreferredSize(tamanho);

        painelBotoes.add(botaoCadastrar);
        painelBotoes.add(botaoLocalizar);
        painelBotoes.add(botaoListar);
        painelBotoes.add(botaoSair);

        painelPrincipal.add(
                painelBotoes,
                BorderLayout.CENTER
        );

        // ==============================
        // RODAPÉ
        // ==============================

        JLabel rodape = new JLabel(
                "Sistema de gerenciamento de alunos",
                SwingConstants.CENTER
        );

        rodape.setFont(
                new Font("Arial", Font.PLAIN, 12)
        );

        rodape.setForeground(Color.GRAY);

        rodape.setBorder(
                BorderFactory.createEmptyBorder(
                        5, 5, 15, 5
                )
        );

        painelPrincipal.add(
                rodape,
                BorderLayout.SOUTH
        );

        // ==============================
        // BOTÃO CADASTRAR
        // ==============================

        botaoCadastrar.addActionListener(e -> {

            TelaCadastro telaCadastro =
                    new TelaCadastro(sistema);

            telaCadastro.setVisible(true);
        });

        // ==============================
        // BOTÃO LOCALIZAR
        // ==============================

        botaoLocalizar.addActionListener(e -> {

            TelaLocalizar telaLocalizar =
                    new TelaLocalizar(sistema);

            telaLocalizar.setVisible(true);
        });

        // ==============================
        // BOTÃO LISTAR
        // ==============================

        botaoListar.addActionListener(e -> {

            TelaListar telaListar =
                    new TelaListar(sistema);

            telaListar.setVisible(true);
        });

        // ==============================
        // BOTÃO SAIR
        // ==============================

        botaoSair.addActionListener(e -> {

            int resposta =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Deseja realmente sair?",
                            "Sair do sistema",
                            JOptionPane.YES_NO_OPTION
                    );

            if (resposta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        // Adiciona tudo à janela
        add(painelPrincipal);
    }
}