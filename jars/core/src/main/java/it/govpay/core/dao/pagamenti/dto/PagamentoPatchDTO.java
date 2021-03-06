/**
 * 
 */
package it.govpay.core.dao.pagamenti.dto;

import org.springframework.security.core.Authentication;

/**
 * @author Bussu Giovanni (bussu@link.it)
 * @author  $Author: bussu $
 * @version $ Rev: 12563 $, $Date: 28 giu 2018 $
 * 
 */
public class PagamentoPatchDTO extends AbstractPatchDTO {

	private String idSessione;
	
	public PagamentoPatchDTO(Authentication user) {
		super(user);
	}

	public String getIdSessione() {
		return this.idSessione;
	}

	public void setIdSessione(String idSessione) {
		this.idSessione = idSessione;
	}

	
}
