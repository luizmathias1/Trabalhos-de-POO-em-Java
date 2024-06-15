import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarContatoFrame extends JFrame {
    private GerenciadorDeContatos gerenciadorDeContatos;

    public ModificarContatoFrame(GerenciadorDeContatos gerenciadorDeContatos) {
        this.gerenciadorDeContatos = gerenciadorDeContatos;

        setTitle("Modificar Contato");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(5, 2));

        JLabel lblTelefone = new JLabel("Telefone:");
        JTextField txtTelefone = new JTextField();
        JLabel lblNovoNome = new JLabel("Novo Nome:");
        JTextField txtNovoNome = new JTextField();
        JLabel lblNovoEmail = new JLabel("Novo Email:");
        JTextField txtNovoEmail = new JTextField();
        JLabel lblNovoTelefone = new JLabel("Novo Telefone:");
        JTextField txtNovoTelefone = new JTextField();

        JButton btnModificar = new JButton("Modificar");

        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int telefone = Integer.parseInt(txtTelefone.getText());
                    String novoNome = txtNovoNome.getText();
                    String novoEmail = txtNovoEmail.getText();
                    int novoTelefone = Integer.parseInt(txtNovoTelefone.getText());

                    if (String.valueOf(novoTelefone).length() != 9) {
                        throw new GerenciadorDeContatosException.TelefoneInvalidoException();
                    }

                    gerenciadorDeContatos.modificarContato(telefone, novoNome, novoEmail, novoTelefone);
                    JOptionPane.showMessageDialog(null, "Contato modificado com sucesso!");
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

        add(lblTelefone);
        add(txtTelefone);
        add(lblNovoNome);
        add(txtNovoNome);
        add(lblNovoEmail);
        add(txtNovoEmail);
        add(lblNovoTelefone);
        add(txtNovoTelefone);
        add(new JLabel());
        add(btnModificar);

        setVisible(true);
    }
}
