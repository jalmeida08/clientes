package br.com.gs3.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.gs3.infra.model.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long>{

	@Query("SELECT t FROM Telefone t INNER JOIN Contato c ON t.contato = c.id INNER JOIN Pessoa p ON p.id = c.pessoa WHERE p.id = :idCliente")
	public List<Telefone> listaTelefoneCliente( @Param("idCliente") Long idCliente);

}
