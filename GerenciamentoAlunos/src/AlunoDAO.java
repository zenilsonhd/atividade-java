import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private Connection conectar() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:alunos.db"; // Cria ou conecta ao arquivo alunos.db
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // Criar a tabela se não existir
    public void criarTabela() {
        String sql = """
                CREATE TABLE IF NOT EXISTS alunos (
                    id INTEGER PRIMARY KEY,
                    nome TEXT NOT NULL,
                    idade INTEGER,
                    curso TEXT
                );
                """;

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Inserir aluno
    public void inserir(Aluno aluno) {
        String sql = "INSERT INTO alunos(id, nome, idade, curso) VALUES(?, ?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, aluno.getId());
            pstmt.setString(2, aluno.getNome());
            pstmt.setInt(3, aluno.getIdade());
            pstmt.setString(4, aluno.getCurso());
            pstmt.executeUpdate();
            System.out.println("Aluno inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Listar todos os alunos
    public List<Aluno> listarTodos() {
        List<Aluno> lista = new ArrayList<>();
        String sql = "SELECT * FROM alunos";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Aluno aluno = new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("curso")
                );
                lista.add(aluno);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    // Buscar aluno por ID
    public Aluno buscarPorId(int id) {
        String sql = "SELECT * FROM alunos WHERE id = ?";
        Aluno aluno = null;

        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                aluno = new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("curso")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return aluno;
    }

    // Atualizar aluno
    public void atualizar(Aluno aluno) {
        String sql = "UPDATE alunos SET nome = ?, idade = ?, curso = ? WHERE id = ?";

        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, aluno.getNome());
            pstmt.setInt(2, aluno.getIdade());
            pstmt.setString(3, aluno.getCurso());
            pstmt.setInt(4, aluno.getId());

            int linhasAfetadas = pstmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Aluno atualizado com sucesso!");
            } else {
                System.out.println("Aluno não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Deletar aluno por ID
    public void deletar(int id) {
        String sql = "DELETE FROM alunos WHERE id = ?";

        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int linhasAfetadas = pstmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Aluno deletado com sucesso!");
            } else {
                System.out.println("Aluno não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

