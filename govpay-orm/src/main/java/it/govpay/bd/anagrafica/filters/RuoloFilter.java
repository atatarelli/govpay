/*
 * GovPay - Porta di Accesso al Nodo dei Pagamenti SPC 
 * http://www.gov4j.it/govpay
 * 
 * Copyright (c) 2014-2017 Link.it srl (http://www.link.it).
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 3, as published by
 * the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package it.govpay.bd.anagrafica.filters;

import java.util.List;

import org.openspcoop2.generic_project.dao.IExpressionConstructor;
import org.openspcoop2.generic_project.exception.ServiceException;
import org.openspcoop2.generic_project.expression.IExpression;
import org.openspcoop2.generic_project.expression.SortOrder;

import it.govpay.bd.AbstractFilter;
import it.govpay.bd.FilterSortWrapper;

public class RuoloFilter extends AbstractFilter {

	private String codRuolo = null;
	private String descrizione = null;
	private List<String> listaRuoli;
	public enum SortFields {
	}

	public RuoloFilter(IExpressionConstructor expressionConstructor) {
		this(expressionConstructor, false);
	}
	
	public RuoloFilter(IExpressionConstructor expressionConstructor, boolean simpleSearch) {
		super(expressionConstructor, simpleSearch);
	}

	@Override
	public IExpression _toExpression() throws ServiceException {
		return null;
	}

	public void addSortField(SortFields field, boolean asc) {
		FilterSortWrapper filterSortWrapper = new FilterSortWrapper();
		filterSortWrapper.setSortOrder((asc ? SortOrder.ASC : SortOrder.DESC));
		this.filterSortList.add(filterSortWrapper);
	}

	public String getCodRuolo() {
		return codRuolo;
	}

	public void setCodRuolo(String codRuolo) {
		this.codRuolo = codRuolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * @param listaRuoli
	 */
	public void setListaRuoli(List<String> listaRuoli) {
		this.listaRuoli = listaRuoli;
	}

	
}
