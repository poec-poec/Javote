package clientDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoSql implements ClientDao
{

    public Client findById(Long id)
    {
        ClientDaoFile client = null;
        Connection conn = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/agence", "user", "password");

            PreparedStatement ps = conn
                    .prepareStatement("select * from client where id=?");
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next())
            {
                // MAJ de ses attributs propres
                client = new Client(rs.getString("nom"), rs.getString("prenom"));
                client.setId(rs.getInt("id"));
                client.setEmail(rs.getString("email"));
                client.setTelephone(rs.getString("telephone"));

                // MAJ le lien entre l'élève et le formateur
                // on va chercher le formateur grâce à son DAO
            }

        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        return client;
    }

    /*
     * (non-Javadoc)
     * 
     * @see formation.dao.Dao#findAll()
     */
    @Override
    public List<Client> findAll()
    {
        // La liste des élèves que l'on va retourner
        List<Client> listeClients = new ArrayList<Client>();
        // Connexion à la BDD
        Connection connexion = null;
        /*
         * ------------------------- + Connexion à la BDD +
         * -------------------------
         */
        try
        {
            // 1. Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Créer la connexion à la BDD
            connexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/client", "user", "password");
            // 3. Création de la requête (statement)
            PreparedStatement ps = connexion
                    .prepareStatement("SELECT * FROM client");
            // 4. On exécute la requête
            ResultSet tuple = ps.executeQuery();
            // 5. Parcours de l'ensemble des résultats (ResultSet)
            while (tuple.next())
            {
                // je récupère les valeurs des colonnes qui correspondent
                // aux valeurs des attributs de l'objet
                String nom = tuple.getString("nom");
                String prenom = tuple.getString("prenom");
                // Création d'un objet Elève
                Eleve eleve = new Eleve(nom, prenom);
                // MAJ des attributs propres à l'élève
                eleve.setId(tuple.getInt("id"));
                eleve.setDtNais(tuple.getString("email"));
                eleve.setNote(tuple.getString("telephone"));

                // je l'ajoute à la liste des élèves
                listeClients.add(client);
            } // fin de la boucle de parcours de l'ensemble des résultats
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        // this block will be executed in any case
        finally
        {
            try
            {
                // we're closing the database connection because if we're not,
                // resource leak and potetial security disaster
                connexion.close();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // we return the student list : alleluia
        return listeClients;
    }
}
