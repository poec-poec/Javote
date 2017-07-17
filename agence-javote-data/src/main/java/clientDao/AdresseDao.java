package clientDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clientModel.Adresse;

public class AdresseDao implements IDataRecovery<Adresse>
{

    public List<Adresse> findAll()
    {
        List<Adresse> adresses = new ArrayList<Adresse>();

        try
        {
            // Etape 1 : chargement du driver
            Class.forName("com.mysql.jdbc.Driver");
            // Etape 2 : création de la connexion
            String dsn = "jdbc:mysql://localhost:3306/agence";
            Connection connexion = DriverManager.getConnection(dsn, "user", "password");
            // Etape 3 : création du statement
            Statement statement = connexion.createStatement();
            // Etape 4 : Exécuter la requête SQL
            ResultSet resultats = statement.executeQuery("SELECT * FROM adresse");
            // Etape 5 : boucle de parcours des résultats
            while (resultats.next())
            {
                // je crée une adresse vide
                Adresse adresse = new Adresse();
                adresse.setId(resultats.getInt("idAdr"));
                adresse.setAdresse(resultats.getString("adresse"));
                adresse.setCodePostal(resultats.getString("codePostal"));
                adresse.setVille(resultats.getString("ville"));
                adresse.setPays(resultats.getString("pays"));

                // je l'ajoute à ma liste
                adresses.add(adresse);
            }
            // Etape 6 : fermer le résultat
            resultats.close();
            // Etape 7 : fermer le statement
            statement.close();
            // Etape 8 : fermer la connexion
            connexion.close();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Impossible de charger le driver. Vérifier votre classpath.");
        }
        catch (SQLException e)
        {
            System.out.println("Erreur SQL. Voir ci-après.");
            System.out.println(e.getMessage());
        }
        return adresses;
    }

    public Adresse findById(int id)
    {
        Adresse adresse = new Adresse();

        try
        {
            // Etape 1 : chargement du driver
            Class.forName("com.mysql.jdbc.Driver");
            // Etape 2 : création de la connexion
            String dsn = "jdbc:mysql://localhost:3306/agence";
            Connection connexion = DriverManager.getConnection(dsn, "user", "password");
            // Etape 3 : création du statement
            Statement statement = connexion.createStatement();
            // Etape 4 : Exécuter la requête SQL
            ResultSet resultats = statement
                    .executeQuery("SELECT * FROM adresse WHERE idAdr = " + id);
            // Etape 5 : boucle de parcours des résultats
            if (resultats.next())
            {
                adresse.setId(resultats.getInt("idAdr"));
                adresse.setAdresse(resultats.getString("adresse"));
                adresse.setCodePostal(resultats.getString("codePostal"));
                adresse.setVille(resultats.getString("ville"));
                adresse.setPays(resultats.getString("pays"));
            }
            // Etape 6 : fermer le résultat
            resultats.close();
            // Etape 7 : fermer le statement
            statement.close();
            // Etape 8 : fermer la connexion
            connexion.close();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Impossible de charger le driver. Vérifier votre classpath.");
        }
        catch (SQLException e)
        {
            System.out.println("Erreur SQL. Voir ci-après.");
            System.out.println(e.getMessage());
        }
        return adresse;
    }

    public Adresse findByClientId(int id)
    {
        Adresse adresse = new Adresse();

        try
        {
            // Etape 1 : chargement du driver
            Class.forName("com.mysql.jdbc.Driver");
            // Etape 2 : création de la connexion
            String dsn = "jdbc:mysql://localhost:3306/agence";
            Connection connexion = DriverManager.getConnection(dsn, "user", "password");
            // Etape 3 : création du statement
            Statement statement = connexion.createStatement();
            // Etape 4 : Exécuter la requête SQL
            ResultSet resultats = statement
                    .executeQuery("SELECT * FROM adresse WHERE idCli = " + id);
            // Etape 5 : boucle de parcours des résultats
            if (resultats.next())
            {
                adresse.setId(resultats.getInt("idAdr"));
                adresse.setAdresse(resultats.getString("adresse"));
                adresse.setCodePostal(resultats.getString("codePostal"));
                adresse.setVille(resultats.getString("ville"));
                adresse.setPays(resultats.getString("pays"));
            }
            // Etape 6 : fermer le résultat
            resultats.close();
            // Etape 7 : fermer le statement
            statement.close();
            // Etape 8 : fermer la connexion
            connexion.close();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Impossible de charger le driver. Vérifier votre classpath.");
        }
        catch (SQLException e)
        {
            System.out.println("Erreur SQL. Voir ci-après.");
            System.out.println(e.getMessage());
        }
        return adresse;
    }
}
