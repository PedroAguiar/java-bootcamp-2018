package com.prueba.springboot2.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.prueba.springboot2.entity.Client;

@Transactional
@Repository
public class ClientDAO implements IClientDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Client getClientById(long clientId) {
        return entityManager.find(Client.class, clientId);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Client> getAllClients() {
        String hql = "SELECT * FROM Clients ORDER BY id";
        return (List<Client>) entityManager.createQuery(hql).getResultList();
    }
    @Override
    public void addClient(Client client) {
        entityManager.persist(client);
    }
    @Override
    public void updateClient(Client client) {
        Client cl = getClientById(client.getClientId());
        cl.setClientName(client.getClientName());
        cl.setClientLastName(client.getClientLastName());
        cl.setClientDescription(client.getClientDescription());
        cl.setDeleted(client.getDeleted());
        entityManager.flush();
    }
    @Override
    public void deleteClient(long clientId) {
        entityManager.remove(getClientById(clientId));
    }

    @Override
    public boolean clientExists(String name, String lastName) {
        String hql = "SELECT * FROM Clients C WHERE C.name = ? and C.lastName = ?";
        int count = entityManager.createQuery(hql).setParameter(1, name).setParameter(2, lastName).getResultList().size();
        return count > 0 ? true : false;
    }
}