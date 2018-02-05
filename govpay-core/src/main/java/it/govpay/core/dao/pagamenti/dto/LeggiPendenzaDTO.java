/**
 * 
 */
package it.govpay.core.dao.pagamenti.dto;

import it.govpay.core.dao.anagrafica.dto.BasicCreateRequestDTO;
import it.govpay.model.IAutorizzato;

/**
 * @author Bussu Giovanni (bussu@link.it)
 * @author  $Author: bussu $
 * @version $ Rev: 12563 $, $Date: 01 feb 2018 $
 * 
 */
public class LeggiPendenzaDTO extends BasicCreateRequestDTO {


	public LeggiPendenzaDTO(IAutorizzato user) {
		super(user);
	}

	private String codA2A;
	private String codPendenza;

	public String getCodA2A() {
		return codA2A;
	}
	public void setCodA2A(String codA2A) {
		this.codA2A = codA2A;
	}
	public String getCodPendenza() {
		return codPendenza;
	}
	public void setCodPendenza(String codPendenza) {
		this.codPendenza = codPendenza;
	}
}
