

package com.globant.dao;
import com.globant.model.Client;
import java.util.List;

public class ClientDAO implements DataAccessObject<Client> {

    private static final String CREATE = "INSERT INTO client(name, surname, description) VALUES (?, ?, ?)";
    private static final String READ = "SELECT * FROM client WHERE Id=?";
    private static final String UPDATE = "UPDATE client SET name =?, surname=?, description= ? WHERE id=?";
    private static final String DELETE = "DELETE FROM client WHERE id=?";
    private static final String READ_ALL = "SELECT * FROM client";

    public Client create( Client client ) {
        return null;

        }
        public Client read( int id) {
            return null;
        }
        public Client update(Client client){

            return null;
        }

        public void delete ( int id ){

        }
        public List <Client> readAll(){
            return null;
        }

    }

