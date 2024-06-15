import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveContatoFrame extends JFrame {
    private GerenciadorDeContatos gerenciadorDeContatos;

    public RemoveContatoFrame(GerenciadorDeContatos gerenciadorDeContatos) {
        this.gerenciadorDeContatos = gerenciadorDeContatos;

        setTitle("Remover Contato");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(2, 2));

        JLabel lblTelefone = new JLabel("Telefone:");
        JTextField txtTelefone = new JTextField();

        JButton btnRemover = new JButton("Remover");

        btnRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int telefone = Integer.parseInt(txtTelefone.getText());
                    gerenciadorDeContatos.removerContato(telefone);
                    JOptionPane.showMessageDialog(null, "Contato removido com sucesso!");
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Telefone deve ser um número inteiro!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (GerenciadorDeContatosException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(lblTelefone);
        add(txtTelefone);
        add(new JLabel());
        add(btnRemover);

        setVisible(true);
    }
}
