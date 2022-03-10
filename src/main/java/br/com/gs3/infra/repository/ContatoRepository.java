package br.com.gs3.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gs3.infra.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
