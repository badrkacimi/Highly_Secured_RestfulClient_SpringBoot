package eai.bam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eai.bam.model.entities.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, String> {

}
