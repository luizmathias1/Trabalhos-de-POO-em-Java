import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarContatoFrame extends JFrame {
    private GerenciadorDeContatos gerenciadorDeContatos;

    public AdicionarContatoFrame(GerenciadorDeContatos gerenciadorDeContatos) {
        this.gerenciadorDeContatos = gerenciadorDeContatos;

        setTitle("Adicionar Contato");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(4, 2));

        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();
        JLabel lblTelefone = new JLabel("Telefone:");
        JTextField txtTelefone = new JTextField();

        JButton btnAdicionar = new JButton("Adicionar");

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = txtNome.getText();
                    String email = txtEmail.getText();
                    int telefone = Integer.parseInt(txtTelefone.getText());

                    if (String.valueOf(telefone).length() != 9) {
                        throw new IllegalArgumentException("O telefone deve ter exatamente 9 dígitos.");
                    }

                    Contato contato = new Contato(nome, email, telefone);
                    gerenciadorDeContatos.adicionarContato(contato);
                    JOptionPane.showMessageDialog(null, "Contato adicionado com sucesso!");
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Telefone deve ser um número inteiro!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (GerenciadorDeContatosException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(lblNome);
        add(txtNome);
        add(lblEmail);
        add(txtEmail);
        add(lblTelefone);
        add(txtTelefone);
        add(new JLabel());
        add(btnAdicionar);

        setVisible(true);
    }
}
