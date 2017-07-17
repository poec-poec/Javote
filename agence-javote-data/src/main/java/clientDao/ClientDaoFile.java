package clientDao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoFile implements ClientDao
{

    private final File path;

    public ClientDaoFile(String path)
    {
        super();
        this.path = new File(path);
    }

    public File getPath()
    {
        return path;
    }

    @Override
    public Client findById(Long id)
    {
        Client client = null;

        FileReader fr = null;
        BufferedReader br = null;
        try
        {
            fr = new FileReader(path);
            br = new BufferedReader(fr);

            String lineEleve;

            while ((lineEleve = br.readLine()) != null)
            {
                client = stringToEleve(lineEleve);

                if (id.equals(client.getId()))
                {
                    break;
                }
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                br.close();
                fr.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return client;
    }

    @Override
    public List<Client> findAll()
    {
        List<Client> clients = new ArrayList<Client>();

        FileReader fr = null;
        BufferedReader br = null;
        try
        {
            fr = new FileReader(path);
            br = new BufferedReader(fr);

            String lineClient;

            while ((lineClient = br.readLine()) != null)
            {

                client.add(stringToEleve(lineClient));

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                br.close();
                fr.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return clients;
    }

}
