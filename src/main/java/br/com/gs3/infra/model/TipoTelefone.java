package br.com.gs3.infra.model;

public enum TipoTelefone {
	COMERCIAL, RESIDENCIAL, CELULAR; 
}


//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import javax.persistence.Version;
//
//@Entity
//@Table(name = "tipo_telefone")
//public class TipoTelefone {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//	
//	private String nomeTipoTelefone;
//	
//	@OneToMany(mappedBy = "tipoTelefone")
//	private List<Telefone> telefone = new ArrayList<Telefone>();
//	
//	@Version
//	private Long versao;
//
//}


