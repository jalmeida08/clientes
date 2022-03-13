package br.com.gs3.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.gs3.infra.model.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long>{
	
	@Query("SELECT e FROM Email e INNER JOIN Contato c ON e.contato = c.id INNER JOIN Pessoa p ON p.id = c.pessoa WHERE p.id = :idCliente")
	public List<Email> listaEmailCliente( @Param("idCliente") Long idCliente);

}
