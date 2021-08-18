package eai.bam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eai.bam.model.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
