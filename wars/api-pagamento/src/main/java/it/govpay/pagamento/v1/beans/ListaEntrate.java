package it.govpay.pagamento.v1.beans;

import java.net.URI;
import java.util.List;

import it.govpay.core.beans.Lista;

public class ListaEntrate extends Lista<Entrata> {

	public ListaEntrate(List<Entrata> risultati, URI requestUri, long count, long pagina, long limit) {
		super(risultati, requestUri, count, pagina, limit);
	}
	
}
