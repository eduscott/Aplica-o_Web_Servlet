import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContatoDao {
	private Connection conexao;
        private Contato contato;
        

	public ContatoDao(Contato contato) {
            this.contato = contato;
            try {
                this.conexao = new ConnectionFactory().getConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
	}

	public void adiciona() {
            try {
		String sql = "insert into contatos (nome, email, endereco, dataNasc) values (?,?,?,?);";
		PreparedStatement stmt = conexao.prepareStatement(sql);

		stmt.setString(1, this.contato.getNome());
		stmt.setString(2, this.contato.getEmail());
		stmt.setString(3, this.contato.getEndereco());
		stmt.setDate(4, new Date(this.contato.getDataNasc().getTimeInMillis()));

		stmt.execute();
		stmt.close();
            } catch (SQLException e) {
		throw new RuntimeException(e);
            }
	}
}
