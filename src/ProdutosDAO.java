import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ProdutosDAO {

    public void venderProduto(int id) {

        String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";

        try (Connection conn = conectaDAO.conectaBD();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, id);
            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto vendido com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(
                null,
                "Erro ao vender produto: " + erro.getMessage()
            );
        }
    }
}
