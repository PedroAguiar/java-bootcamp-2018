package repository;

import entity.Client;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource(collectionResourceRel = "Client", path = "clients")
public interface ClientRepository extends CrudRepository<Client, Long> {
    /**
     * Metodo que devuelve una lista buscando por nombr
     */
    List<Client> findByName(@Param("name") String name);
    /**
     * Retorna cliente segun id
     */
    @Query("SELECT c.name FROM Client c where c.id = :id")
    Client findNameById(@Param("id") Long id);
    /**
     * Retorna lista de clietnes buscados por nombre y ordenados por eso tmb.
     */
    List<Client> findByNameOrderByName(@Param("name") String name);
}