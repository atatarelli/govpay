package it.govpay.core.dao.anagrafica.dto;

import org.springframework.security.core.Authentication;

import it.govpay.bd.model.Dominio;

public class PutDominioDTO extends BasicCreateRequestDTO  {
	
	private Dominio dominio;
	private String idDominio;
	private String codStazione;
	
	public PutDominioDTO(Authentication user) {
		super(user);
		// TODO Auto-generated constructor stub
	}

	public String getCodStazione() {
		return this.codStazione;
	}

	public void setCodStazione(String idStazione) {
		this.codStazione = idStazione;
	}

	public Dominio getDominio() {
		return this.dominio;
	}

	public void setDominio(Dominio dominio) {
		this.dominio = dominio;
	}

	public String getIdDominio() {
		return this.idDominio;
	}

	public void setIdDominio(String idDominio) {
		this.idDominio = idDominio;
	}

}
