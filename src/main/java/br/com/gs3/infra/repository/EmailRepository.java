package br.com.gs3.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gs3.infra.model.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long>{

}
