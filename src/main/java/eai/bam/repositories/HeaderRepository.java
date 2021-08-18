package eai.bam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eai.bam.model.entities.Header;

@Repository
public interface HeaderRepository extends JpaRepository<Header, Integer>{

}
