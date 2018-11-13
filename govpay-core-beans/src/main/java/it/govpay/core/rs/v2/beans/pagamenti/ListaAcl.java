package it.govpay.core.rs.v2.beans.pagamenti;

import java.net.URI;
import java.util.List;

import it.govpay.core.rs.v1.beans.Lista;


public class ListaAcl extends Lista<Acl> {
	
	public ListaAcl() {
	}
	public ListaAcl(List<Acl> acl, URI requestUri, long count, long pagina, long limit) {
		super(acl, requestUri, count, pagina, limit);
	}
	
}