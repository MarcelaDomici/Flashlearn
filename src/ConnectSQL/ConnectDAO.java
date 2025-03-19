package ConnectSQL;

import Body.Estudo;
import Body.Flashcards;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Body.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class ConnectDAO {

    public void InsertUser(User user) {
        String query = "INSERT INTO users(nome, senha, email) VALUES(?,?,?)";
        PreparedStatement pst = null;
        try {
            pst = ConnectToDatabase.getConnection().prepareStatement(query);
            pst.setString(1, user.getName());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getEmail());
            pst.execute();
            pst.close();
        } catch (SQLException ie) {
        }
    }

    public boolean CheckUser(User user) {
        String query = "SELECT COUNT(*) As total FROM users WHERE email = ? AND senha = ?";
        PreparedStatement pst = null;
        try {
            pst = ConnectToDatabase.getConnection().prepareStatement(query);
            pst.setString(1, user.getEmail());
            pst.setString(2, user.getPassword());
            ResultSet rest = pst.executeQuery();
            if (rest.next()) {
                int i = rest.getInt("total");
                return i > 0;
            }
        } catch (SQLException ie) {
        }
        return false;
    }
    
    public boolean CheckUserCadastro(User user) {
        String query = "SELECT COUNT(*) As total FROM users WHERE email = ?";
        PreparedStatement pst = null;
        try {
            pst = ConnectToDatabase.getConnection().prepareStatement(query);
            pst.setString(1, user.getEmail());
            ResultSet rest = pst.executeQuery();
            if (rest.next()) {
                int i = rest.getInt("total");
                return i > 0;
            }
        } catch (SQLException ie) {
        }
        return false;
    }

    public int GetIdUser(User user) {
        String query = "select id from users where email = ? and senha = ?";
        PreparedStatement pst = null;
        try {
            pst = ConnectToDatabase.getConnection().prepareStatement(query);
            pst.setString(1, user.getEmail());
            pst.setString(2, user.getPassword());
            ResultSet rest = pst.executeQuery();
            if (rest.next()) {
                int i = rest.getInt("id");
                return i;
            }
        } catch (SQLException ie) {
        }
        return 0;
    }

    public int GetIdList(Flashcards flashcards) {
        String query = "select id from list_user where nome = ?";
        PreparedStatement pst = null;
        try {
            pst = ConnectToDatabase.getConnection().prepareStatement(query);
            pst.setString(1, flashcards.getNameList());
            ResultSet rest = pst.executeQuery();
            if (rest.next()) {
                int i = rest.getInt("id");
                return i;
            }
        } catch (SQLException ie) {
        }
        return 0;
    }

    public void AlterName(int id, String name) {
        String query = "update users set nome = ? where id = ?";
        PreparedStatement pst = null;
        try {
            pst = ConnectToDatabase.getConnection().prepareStatement(query);
            pst.setString(1, name);
            pst.setInt(2, id);
            pst.execute();
            pst.close();
        } catch (SQLException ie) {
        }
    }

    public void AlterNameList(int id, String name) {
        String query = "update list_user set nome = ? where id = ?";
        PreparedStatement pst = null;
        try {
            pst = ConnectToDatabase.getConnection().prepareStatement(query);
            pst.setString(1, name);
            pst.setInt(2, id);
            pst.execute();
            pst.close();
        } catch (SQLException ie) {
        }
    }

    //Alterar email
    public void AlterEmail(int id, String name) {
        String query = "update users set email = ? where id = ?";
        PreparedStatement pst = null;
        try {
            pst = ConnectToDatabase.getConnection().prepareStatement(query);
            pst.setString(1, name);
            pst.setInt(2, id);
            pst.execute();
            pst.close();
        } catch (SQLException ie) {
        }
    }

    // Alterar senha
    public void AlterSenha(int id, String name) {
        String query = "update users set senha = ? where id = ?";
        PreparedStatement pst = null;
        try {
            pst = ConnectToDatabase.getConnection().prepareStatement(query);
            pst.setString(1, name);
            pst.setInt(2, id);
            pst.execute();
            pst.close();
        } catch (SQLException ie) {
        }
    }

    public void DeleteUser(int id) {
        String query = "delete from users where id = ?";
        PreparedStatement pst = null;
        try {
            pst = ConnectToDatabase.getConnection().prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
            pst.close();
        } catch (SQLException ie) {
        }
    }

    public int InsertListName(Flashcards flashcards) {
        String query = "INSERT INTO list_user (id_user, nome) VALUES(?, ?)";
        PreparedStatement pst = null;
        try {
            pst = ConnectToDatabase.getConnection().prepareStatement(query);
            pst.setInt(1, flashcards.getIdUser());
            pst.setString(2, flashcards.getNameList());
            pst.execute();
            String query1 = "select id from list_user where nome = ? and id_user = ?";
            pst = ConnectToDatabase.getConnection().prepareStatement(query1);
            pst.setString(1, flashcards.getNameList());
            pst.setInt(2, flashcards.getIdUser());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }

        } catch (SQLException ie) {
        }

        return 0;

    }

    public boolean CheckList(Flashcards flashcards) {
        String query = "SELECT COUNT(*) As total FROM list_user WHERE nome = ? AND id_user = ?";
        PreparedStatement pst = null;
        try {
            pst = ConnectToDatabase.getConnection().prepareStatement(query);
            pst.setString(1, flashcards.getNameList());
            pst.setInt(2, flashcards.getIdUser());
            ResultSet rest = pst.executeQuery();
            if (rest.next()) {
                int i = rest.getInt("total");
                return i > 0;
            }
        } catch (SQLException ie) {
        }
        return false;
    }

    // mostrar listas do usuario comboBox
    public List<String> showList(Flashcards flashcards) {
        List<String> nomesDasListas = new ArrayList<>();

        String query = "SELECT nome FROM list_user WHERE id_user = ?";
        PreparedStatement pst = null;
        try {
            pst = ConnectToDatabase.getConnection().prepareStatement(query);
            pst.setInt(1, flashcards.getIdUser());
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    String nomeLista = rs.getString("nome");
                    nomesDasListas.add(nomeLista);
                }
            }
            pst.close();
        } catch (SQLException ie) {
        }

        return nomesDasListas;
    }

    public void InsertAskAnswer(String pergunta, String resposta, int id, int id2)throws SQLException{
        if(pergunta!=null&&resposta!=null){
        String query = "insert into lists(id_about_list, pergunta, resposta, id_about_user) values (?, ?, ?, ?)";
        PreparedStatement pst = null;
            pst = ConnectToDatabase.getConnection().prepareStatement(query);
            pst.setInt(1, id);
            pst.setString(2, pergunta);
            pst.setString(3, resposta);
            pst.setInt(4, id2);
            pst.execute();
            pst.close();
       
        }
    }

    public void deleteList(String nome, int idUser) {
        String query = "select id from list_user where nome = ? and id_user = ?";
        PreparedStatement pst = null;
        try {
            pst = ConnectToDatabase.getConnection().prepareStatement(query);
            pst.setString(1, nome);
            pst.setInt(2, idUser);
            ResultSet rest = pst.executeQuery();
            if (rest.next()) {
                int i = rest.getInt("id");
                String query1 = "delete from lists where id_about_list = ?";
                pst = ConnectToDatabase.getConnection().prepareStatement(query1);
                pst.setInt(1, i);
                pst.execute();
                String query2 = "delete from list_user where nome = ? and id_user = ?";
                pst = ConnectToDatabase.getConnection().prepareStatement(query2);
                pst.setString(1, nome);
                pst.setInt(2, idUser);
                pst.execute();
                pst.close();
            }
        } catch (SQLException ie) {
        }
    }
     
    public void deleteAll(int idUser){
        String query = "select id from list_user where id_user = ?";
        PreparedStatement pst = null;
        try {
            pst = ConnectToDatabase.getConnection().prepareStatement(query);
            pst.setInt(1, idUser);
            ResultSet rest = pst.executeQuery();
            if (rest.next()) {
               // int idList = rest.getInt("id");
                String query1 = "delete from lists where id_about_user = ?";
                pst = ConnectToDatabase.getConnection().prepareStatement(query1);
                pst.setInt(1, idUser);
                pst.execute();
                String query2 = "delete from list_user where id_user = ?";
                pst = ConnectToDatabase.getConnection().prepareStatement(query2);
                pst.setInt(1, idUser);
                pst.execute();
                String query3 = "delete from users where id = ?";
                pst = ConnectToDatabase.getConnection().prepareStatement(query3);
                pst.setInt(1, idUser);
                pst.execute();
                pst.close();
            }
        } catch (SQLException ie) {
        }
    }
    

    public ArrayList<Estudo> estudar(Flashcards flashcards, int idUser) {
        ArrayList<Estudo> estudar = new ArrayList<>();
        int i = this.GetIdList(flashcards);
        String query = "select pergunta, resposta, id from lists where id_about_list = ? and id_about_user = ?";
        PreparedStatement pst = null;
        try {
            pst = ConnectToDatabase.getConnection().prepareStatement(query);
            pst.setInt(1, i);
            pst.setInt(2, idUser);
            ResultSet rest = pst.executeQuery();
            while (rest.next()) {
                Estudo estudo = new Estudo();
                estudo.setPergunta(rest.getString("pergunta"));
                estudo.setResposta(rest.getString("resposta"));
                estudo.setId(rest.getInt("id"));
                if(estudo.getPergunta().equals("null")||estudo.getResposta().equals("null")){
                    DeleteItemAtList(estudo.getId());
                    continue;
                }
                estudar.add(estudo);
            }
            return estudar;

        } catch (SQLException ie) {
        }
        return null;
    }
    
    public void getEstudoToUpdate(Estudo estudo)throws SQLException{
        String query = "UPDATE lists set pergunta = ?, resposta = ? where id = ?";
        try (PreparedStatement pst = ConnectToDatabase.getConnection().prepareStatement(query)) {
            pst.setString(1, estudo.getPergunta());
            pst.setString(2, estudo.getResposta());
            pst.setInt(3,estudo.getId());
            pst.execute();
            pst.close();
        }
    }
    public byte DeleteItemAtList(int i)throws SQLException{
        String query = "DELETE FROM lists where id = ?";
        try (PreparedStatement pst = ConnectToDatabase.getConnection().prepareStatement(query)) {
            pst.setInt(1, i);
            pst.execute();
            pst.close();
            return 1;
        }
    }
   
    public String getNome(int userId) {
        String nome = null;
        String query = "SELECT nome FROM users WHERE id = ?";
        PreparedStatement pst = null;
        try {
            pst = ConnectToDatabase.getConnection().prepareStatement(query);
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nome = rs.getString("nome");

            }
        } catch (SQLException ie) {
        }

        return nome;
    }

    public String getEmail(int userId) {
        String nome = null;
        String query = "SELECT email FROM users WHERE id = ?";
        PreparedStatement pst = null;
        try {
            pst = ConnectToDatabase.getConnection().prepareStatement(query);
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nome = rs.getString("email");

            }
        } catch (SQLException ie) {
        }

        return nome;
    }

    public String generatePassword() {
        Random random = new Random();
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        StringBuilder sb = new StringBuilder(8);

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }

        return sb.toString();
    }

    public String saveNewPasswordEmail(String email) {
        String query = "update users set senha = ? where email = ?";
        PreparedStatement pst = null;
        String senha = new ConnectDAO().generatePassword();
        try {
            pst = ConnectToDatabase.getConnection().prepareStatement(query);
            pst.setString(1, senha);
            pst.setString(2, email);
            pst.execute();
            pst.close();
        } catch (SQLException ie) {
        }

        return senha;
    }

    public void sendPasswordEmail(String userEmail) {

        String meuEmail = "flashlearn34@gmail.com";
        String minhaSenha = "v e m i h l v u f f h g j i w r";

        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
        email.setSSLOnConnect(true);

        String senha = new ConnectDAO().saveNewPasswordEmail(userEmail);

        try {
            email.setFrom(meuEmail);
            email.setSubject("FlashLearn - Nova senha");
            email.setMsg("Conforme foi solicitado, segue sua nova senha para acessar o aplicativo. Senha: " + senha);
            email.addTo(userEmail); // para quem enviar
            email.send();
        } catch (EmailException ei) {
        }
    }
         
}
