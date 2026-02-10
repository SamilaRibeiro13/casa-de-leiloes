import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutosDAO {

    // VENDER PRODUTO
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

    // LISTAR PRODUTOS VENDIDOS
    public ArrayList<ProdutosDTO> listarProdutosVendidos() {

        String sql = "SELECT * FROM produtos WHERE status = 'Vendido'";
        ArrayList<ProdutosDTO> lista = new ArrayList<>();

        try (Connection conn = conectaDAO.conectaBD();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getInt("valor"));
                produto.setStatus(rs.getString("status"));

                lista.add(produto);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(
                null,
                "Erro ao listar produtos vendidos: " + erro.getMessage()
            );
        }

        return lista;
    }
}
