import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CriarTabela {
    public static void main(String[] args) {
        try {
            Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://dpg-cvrbs3euk2gs73fbl3k0-a.oregon-postgres.render.com/foxhound",
                "venomsnake",
                "TSjzLzfY7ShWjwasN95N4vXdyDMQuqrE"
            );

            Statement stmt = conexao.createStatement();

            String sqlpessoa = "CREATE TABLE IF NOT EXISTS pessoa (" +
                         "id SERIAL PRIMARY KEY," +
                         "nome VARCHAR(100)," +
                         "sobrenome VARCHAR(100)," +
                         "cpf VARCHAR(20)," +
                         "endereco VARCHAR(150)," +
                         "ano_nascimento INT" +
                         ");";

            stmt.executeUpdate(sqlpessoa);
            System.out.println("Tabela 'pessoa' criada com sucesso!");

            String sqlquarto = "CREATE TABLE IF NOT EXISTS quarto(" +
                               "id_quarto SERIAL PRIMARY KEY," +
                               "nome_quarto VARCHAR(100)," +
                               "numero_quarto INT," +
                               "p INT," +
                               "FOREIGN KEY (p) REFERENCES pessoa(id)" +
                               ");";

            stmt.executeUpdate(sqlquarto);
            System.out.println("Tabela 'quarto' criada com sucesso!");

            String sqlres = "CREATE TABLE IF NOT EXISTS reserva(" +
                         "id_res SERIAL PRIMARY KEY," +
                         "numero_reserva INT);";

            stmt.executeUpdate(sqlres);
            System.out.println("Tabela 'reserva' criada com sucesso!");

            
            stmt.close();
            conexao.close();

        } catch (Exception e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }
}
