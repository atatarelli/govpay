package it.govpay.core.dao.pagamenti.dto;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.openspcoop2.generic_project.expression.SortOrder;

import it.govpay.core.dao.anagrafica.dto.BasicFindRequestDTO;
import it.govpay.core.exceptions.InternalException;
import it.govpay.core.exceptions.RequestParamException;
import it.govpay.core.exceptions.RequestParamException.FaultType;
import it.govpay.model.IAutorizzato;
import it.govpay.model.Utenza.TIPO_UTENZA;
import it.govpay.orm.Versamento;
import it.govpay.orm.VersamentoIncasso;

public class ListaPendenzeDTO extends BasicFindRequestDTO{
	
	
	public ListaPendenzeDTO(IAutorizzato user) {
		this(user, false);
	}
	
	public ListaPendenzeDTO(IAutorizzato user, boolean infoIncasso) {
		super(user);
		this.infoIncasso = infoIncasso;
		if(this.infoIncasso) {
			this.addSortField("dataCaricamento", VersamentoIncasso.model().DATA_CREAZIONE);
			this.addSortField("dataValidita", VersamentoIncasso.model().DATA_VALIDITA);
			this.addSortField("dataScadenza", VersamentoIncasso.model().DATA_SCADENZA);
			this.addSortField("stato", VersamentoIncasso.model().STATO_VERSAMENTO);
			this.addDefaultSort(VersamentoIncasso.model().DATA_CREAZIONE,SortOrder.DESC);
		} else {
			this.addSortField("dataCaricamento", Versamento.model().DATA_CREAZIONE);
			this.addSortField("dataValidita", Versamento.model().DATA_VALIDITA);
			this.addSortField("dataScadenza", Versamento.model().DATA_SCADENZA);
			this.addSortField("stato", Versamento.model().STATO_VERSAMENTO);
			this.addDefaultSort(Versamento.model().DATA_CREAZIONE,SortOrder.DESC);
		}
	}
	private Date dataA;
	private Date dataDa;
	private String stato;
	private String idDominio;
	private String idPagamento;
	private String idDebitore;
	private String idA2A;
	private String idPendenza;
	private boolean infoIncasso;
	
	public Date getDataA() {
		return this.dataA;
	}
	public void setDataA(Date dataA) {
		this.dataA = dataA;
	}
	public Date getDataDa() {
		return this.dataDa;
	}
	public void setDataDa(Date dataDa) {
		this.dataDa = dataDa;
	}
	public String getStato() {
		return this.stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public String getIdDominio() {
		return this.idDominio;
	}
	public void setIdDominio(String idDominio) {
		this.idDominio = idDominio;
	}
	public String getIdPagamento() {
		return this.idPagamento;
	}
	public void setIdPagamento(String idPagamento) {
		this.idPagamento = idPagamento;
	}
	public String getIdDebitore() {
		return this.idDebitore;
	}
	public void setIdDebitore(String idDebitore) {
		this.idDebitore = idDebitore;
	}
	public String getIdA2A() {
		return this.idA2A;
	}
	public void setIdA2A(String idA2A) {
		this.idA2A = idA2A;
	}
	public boolean isInfoIncasso() {
		return infoIncasso;
	}
	public void setInfoIncasso(boolean infoIncasso) {
		this.infoIncasso = infoIncasso;
	}
	public String getIdPendenza() {
		return idPendenza;
	}
	public void setIdPendenza(String idPendenza) {
		this.idPendenza = idPendenza;
	}

	@Override
	public void setOrderBy(String orderBy) throws RequestParamException, InternalException {
		this.resetSort();
		
		if(orderBy==null || orderBy.trim().isEmpty()) return;
		
		// visualizzazione smart abilitabile solo se ho infoincasso e se sono un cittadino oppure ho scelto un debitore		
		String fieldname = "smart";
		if(this.infoIncasso && orderBy.equals(fieldname) ){ 
			if(this.getUser().getTipoUtenza().equals(TIPO_UTENZA.CITTADINO) || StringUtils.isNotEmpty(this.idDebitore)) {
				this.addSortField(VersamentoIncasso.model().SMART_ORDER_RANK, SortOrder.ASC);
				this.addSortField(VersamentoIncasso.model().SMART_ORDER_DATE, SortOrder.ASC);
			} else {
				throw new RequestParamException(FaultType.PARAMETRO_ORDERBY_NON_VALIDO, "Il campo " + fieldname + " non e' valido per ordinare la ricerca in corso senza indicare un idDebitore.");
			}
		} else {
			super.setOrderBy(orderBy);
		}
	}
	
}