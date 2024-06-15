import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListarContatosFrame extends JFrame {
    public ListarContatosFrame(GerenciadorDeContatos gerenciadorDeContatos) {
        setTitle("Lista de Contatos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        List<Contato> contatos = gerenciadorDeContatos.listarContatos();
        String[] colunas = {"Nome", "Email", "Telefone"};
        String[][] dados = new String[contatos.size()][3];

        for (int i = 0; i < contatos.size(); i++) {
            Contato contato = contatos.get(i);
            dados[i][0] = contato.getNome();
            dados[i][1] = contato.getEmail();
            dados[i][2] = String.valueOf(contato.getTelefone());
        }

        JTable tabela = new JTable(dados, colunas);
        JScrollPane scrollPane = new JScrollPane(tabela);

        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
