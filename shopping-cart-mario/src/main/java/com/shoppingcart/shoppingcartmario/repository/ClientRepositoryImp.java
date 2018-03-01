package com.shoppingcart.shoppingcartmario.repository;

import com.shoppingcart.shoppingcartmario.model.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ClientRepositoryImp implements ClientRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Client getClientById(int idClient) {
        return entityManager.find(Client.class, idClient);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Client> getAllClients() {
        String hql = "FROM client ORDER BY client.client_id";
        return (List<Client>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addClient(Client client) {
        entityManager.persist(client);
    }

    @Override
    public void updateClient(Client client) {
        Client cli = getClientById(client.getIdClient());//ASK
        cli.setFirstName(client.getFirstName());
        cli.setLastName(client.getLastName());
        entityManager.flush();
    }

    @Override
    public void deleteClient(int idClient) {
        entityManager.remove(getClientById(idClient));
    }

    @Override
    public boolean clientExists(String firstName, String lastName, String description) {
        String hql = "FROM client WHERE client.first_name = ? and client.last_name = ? and client.description = ? ";
        int count = entityManager.createQuery(hql).setParameter(1, firstName)
                .setParameter(2, lastName).setParameter(3,description).getResultList().size();
        return count > 0 ? true : false;
    }

}
