import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    private GerenciadorDeContatos gerenciadorDeContatos;

    public MainFrame() {
        gerenciadorDeContatos = new GerenciadorDeContatos("contatos.ser");

        setTitle("Gerenciador de Contatos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);

        // Adicionando Window Listener para salvar contatos ao fechar a janela
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                fecharAplicacao();
            }
        });

        // Configurar layout
        setLayout(new GridLayout(5,1));

        JButton btnAdd = new JButton("Adicionar Contato");
        JButton btnList = new JButton("Listar Contatos");
        JButton btnModify = new JButton("Modificar Contato");
        JButton btnRemove = new JButton("Remover Contato");
        JButton btnSaveAndExit = new JButton("Salvar e Sair");

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdicionarContatoFrame(gerenciadorDeContatos);
            }
        });

        btnList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ListarContatosFrame(gerenciadorDeContatos);
            }
        });

        btnModify.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ModificarContatoFrame(gerenciadorDeContatos);
            }
        });

        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RemoveContatoFrame(gerenciadorDeContatos);
            }
        });

        btnSaveAndExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarEFechar();
            }
        });

        add(btnAdd);
        add(btnList);
        add(btnModify);
        add(btnRemove);
        add(btnSaveAndExit);

        setVisible(true);
    }

    private void salvarEFechar() {
        gerenciadorDeContatos.salvarContatos();
        JOptionPane.showMessageDialog(this, "Contatos salvos. Saindo.");
        System.exit(0);
    }

    private void fecharAplicacao() {
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja salvar os contatos antes de sair?", "Salvar Contatos",
                JOptionPane.YES_NO_CANCEL_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            salvarEFechar();
        } else if (resposta == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Contatos não salvos. Saindo.");
            System.exit(0);
        }
        // Se a opção for CANCELAR, não faz nada
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
