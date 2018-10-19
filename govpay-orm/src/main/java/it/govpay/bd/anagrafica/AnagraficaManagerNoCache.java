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
package it.govpay.bd.anagrafica;

import org.openspcoop2.generic_project.exception.MultipleResultException;
import org.openspcoop2.generic_project.exception.NotFoundException;
import org.openspcoop2.generic_project.exception.ServiceException;
import org.openspcoop2.utils.LoggerWrapperFactory;
import org.openspcoop2.utils.UtilsException;

import it.govpay.bd.BasicBD;
import it.govpay.bd.anagrafica.cache.ApplicazioniBDCacheWrapper;
import it.govpay.bd.anagrafica.cache.DominiBDCacheWrapper;
import it.govpay.bd.anagrafica.cache.IbanAccreditoBDCacheWrapper;
import it.govpay.bd.anagrafica.cache.IntermediariBDCacheWrapper;
import it.govpay.bd.anagrafica.cache.OperatoriBDCacheWrapper;
import it.govpay.bd.anagrafica.cache.StazioniBDCacheWrapper;
import it.govpay.bd.anagrafica.cache.TipiTributoBDCacheWrapper;
import it.govpay.bd.anagrafica.cache.TributiBDCacheWrapper;
import it.govpay.bd.anagrafica.cache.UoBDCacheWrapper;
import it.govpay.bd.anagrafica.cache.UtenzeBDCacheWrapper;
import it.govpay.bd.model.Applicazione;
import it.govpay.bd.model.Dominio;
import it.govpay.bd.model.IbanAccredito;
import it.govpay.bd.model.Operatore;
import it.govpay.bd.model.Stazione;
import it.govpay.bd.model.Tributo;
import it.govpay.bd.model.UnitaOperativa;
import it.govpay.bd.model.Utenza;
import it.govpay.model.Intermediario;
import it.govpay.model.TipoTributo;

public class AnagraficaManagerNoCache {
	
	private static final String CACHE_KEY_GET_TIPO_TRIBUTO = "getTipoTributo";
	private static final String CACHE_KEY_GET_TRIBUTO = "getTributo";
	private static final String CACHE_KEY_GET_STAZIONE = "getStazione";
	private static final String CACHE_KEY_GET_UTENZA = "getUtenza";
	private static final String CACHE_KEY_GET_OPERATORE_BY_SUBJECT = "getOperatoreBySubject";
	private static final String CACHE_KEY_GET_OPERATORE_BY_PRINCIPAL = "getOperatoreByPrincipal";
	private static final String CACHE_KEY_GET_OPERATORE = "getOperatore";
	private static final String CACHE_KEY_GET_INTERMEDIARIO = "getIntermediario";
	private static final String CACHE_KEY_GET_IBAN_ACCREDITO = "getIbanAccredito";
	private static final String CACHE_KEY_GET_UNITA_OPERATIVA = "getUnitaOperativa";
	private static final String CACHE_KEY_GET_DOMINIO = "getDominio";
	private static final String CACHE_KEY_GET_APPLICAZIONE_BY_SUBJECT = "getApplicazioneBySubject";
	private static final String CACHE_KEY_GET_APPLICAZIONE_BY_PRINCIPAL = "getApplicazioneByPrincipal";
	private static final String CACHE_KEY_GET_APPLICAZIONE = "getApplicazione";

	private static final boolean DEBUG = false;
	
	private static DominiBDCacheWrapper dominiBDCacheWrapper;
	private static ApplicazioniBDCacheWrapper applicazioniBDCacheWrapper;
	private static UoBDCacheWrapper uoBDCacheWrapper;
	private static IbanAccreditoBDCacheWrapper ibanAccreditoBDCacheWrapper;
	private static IntermediariBDCacheWrapper intermediariBDCacheWrapper;
	private static OperatoriBDCacheWrapper operatoriBDCacheWrapper;
	private static StazioniBDCacheWrapper stazioniBDCacheWrapper;
	private static TributiBDCacheWrapper tributiBDCacheWrapper;
	private static TipiTributoBDCacheWrapper tipiTributoBDCacheWrapper;
	private static UtenzeBDCacheWrapper utenzeBDCacheWrapper;

	private AnagraficaManagerNoCache() throws UtilsException {
		dominiBDCacheWrapper = new DominiBDCacheWrapper(false, LoggerWrapperFactory.getLogger(DominiBDCacheWrapper.class));
		applicazioniBDCacheWrapper = new ApplicazioniBDCacheWrapper(false, LoggerWrapperFactory.getLogger(ApplicazioniBDCacheWrapper.class));
		uoBDCacheWrapper = new UoBDCacheWrapper(false, LoggerWrapperFactory.getLogger(UoBDCacheWrapper.class));
		ibanAccreditoBDCacheWrapper = new IbanAccreditoBDCacheWrapper(false, LoggerWrapperFactory.getLogger(IbanAccreditoBDCacheWrapper.class));
		intermediariBDCacheWrapper = new IntermediariBDCacheWrapper(false, LoggerWrapperFactory.getLogger(IntermediariBDCacheWrapper.class));
		operatoriBDCacheWrapper = new OperatoriBDCacheWrapper(false, LoggerWrapperFactory.getLogger(OperatoriBDCacheWrapper.class));
		stazioniBDCacheWrapper = new StazioniBDCacheWrapper(false, LoggerWrapperFactory.getLogger(StazioniBDCacheWrapper.class));
		tributiBDCacheWrapper = new TributiBDCacheWrapper(false, LoggerWrapperFactory.getLogger(TributiBDCacheWrapper.class));
		tipiTributoBDCacheWrapper = new TipiTributoBDCacheWrapper(false, LoggerWrapperFactory.getLogger(TipiTributoBDCacheWrapper.class));
		utenzeBDCacheWrapper = new UtenzeBDCacheWrapper(false, LoggerWrapperFactory.getLogger(UtenzeBDCacheWrapper.class));
	}

	public static AnagraficaManagerNoCache newInstance() throws UtilsException {
		return new AnagraficaManagerNoCache();
	}

	public static DominiBDCacheWrapper getDominiBDCacheWrapper() {
		return dominiBDCacheWrapper;
	}

	public static ApplicazioniBDCacheWrapper getApplicazioniBDCacheWrapper() {
		return applicazioniBDCacheWrapper;
	}

	public static UoBDCacheWrapper getUoBDCacheWrapper() {
		return uoBDCacheWrapper;
	}

	public static IbanAccreditoBDCacheWrapper getIbanAccreditoBDCacheWrapper() {
		return ibanAccreditoBDCacheWrapper;
	}

	public static IntermediariBDCacheWrapper getIntermediariBDCacheWrapper() {
		return intermediariBDCacheWrapper;
	}

	public static OperatoriBDCacheWrapper getOperatoriBDCacheWrapper() {
		return operatoriBDCacheWrapper;
	}
	
	public static UtenzeBDCacheWrapper getUtenzeBDCacheWrapper() {
		return utenzeBDCacheWrapper;
	}

	public static StazioniBDCacheWrapper getStazioniBDCacheWrapper() {
		return stazioniBDCacheWrapper;
	}

	public static TributiBDCacheWrapper getTributiBDCacheWrapper() {
		return tributiBDCacheWrapper;
	}
	
	public static TipiTributoBDCacheWrapper getTipiTributoBDCacheWrapper() {
		return tipiTributoBDCacheWrapper;
	}
	
	public static void removeFromCache(Applicazione applicazione) {
		try {applicazioniBDCacheWrapper.removeObjectCache(applicazioniBDCacheWrapper.getKeyCache(CACHE_KEY_GET_APPLICAZIONE, String.valueOf(applicazione.getId())));} catch (Exception e) {	}
		try {applicazioniBDCacheWrapper.removeObjectCache(applicazioniBDCacheWrapper.getKeyCache(CACHE_KEY_GET_APPLICAZIONE, applicazione.getCodApplicazione()));} catch (Exception e) {	}
		try {applicazioniBDCacheWrapper.removeObjectCache(applicazioniBDCacheWrapper.getKeyCache(CACHE_KEY_GET_APPLICAZIONE_BY_PRINCIPAL, applicazione.getPrincipal()));} catch (Exception e) {	}
		try {applicazioniBDCacheWrapper.removeObjectCache(applicazioniBDCacheWrapper.getKeyCache(CACHE_KEY_GET_APPLICAZIONE_BY_SUBJECT, applicazione.getPrincipal()));} catch (Exception e) {	}
	}
	
	public static void removeFromCache(Dominio dominio) {
		try {dominiBDCacheWrapper.removeObjectCache(dominiBDCacheWrapper.getKeyCache(CACHE_KEY_GET_DOMINIO, String.valueOf(dominio.getId())));} catch (Exception e) {	}
		try {dominiBDCacheWrapper.removeObjectCache(dominiBDCacheWrapper.getKeyCache(CACHE_KEY_GET_DOMINIO, dominio.getCodDominio()));} catch (Exception e) {	}
	}
	
	public static void removeFromCache(UnitaOperativa uo) {
		try {uoBDCacheWrapper.removeObjectCache(uoBDCacheWrapper.getKeyCache(CACHE_KEY_GET_UNITA_OPERATIVA, String.valueOf(uo.getId())));} catch (Exception e) {	}
		try {uoBDCacheWrapper.removeObjectCache(uoBDCacheWrapper.getKeyCache(CACHE_KEY_GET_UNITA_OPERATIVA, String.valueOf(uo.getCodUo() + "@" + uo.getIdDominio())));} catch (Exception e) {	}
		try {uoBDCacheWrapper.removeObjectCache(uoBDCacheWrapper.getKeyCache(CACHE_KEY_GET_UNITA_OPERATIVA, String.valueOf("ByCodUnivocoUo#" + uo.getCodUo() + "@" + uo.getIdDominio())));} catch (Exception e) {	}
	}
	
	public static void removeFromCache(IbanAccredito iban) {
		try {ibanAccreditoBDCacheWrapper.removeObjectCache(ibanAccreditoBDCacheWrapper.getKeyCache(CACHE_KEY_GET_IBAN_ACCREDITO, String.valueOf(iban.getId())));} catch (Exception e) {	}
		try {ibanAccreditoBDCacheWrapper.removeObjectCache(ibanAccreditoBDCacheWrapper.getKeyCache(CACHE_KEY_GET_IBAN_ACCREDITO, String.valueOf(iban.getCodIban())));} catch (Exception e) {	}
	}
	
	public static void removeFromCache(Intermediario intermediario) {
		try {intermediariBDCacheWrapper.removeObjectCache(intermediariBDCacheWrapper.getKeyCache(CACHE_KEY_GET_INTERMEDIARIO, String.valueOf(intermediario.getId())));} catch (Exception e) {	}
		try {intermediariBDCacheWrapper.removeObjectCache(intermediariBDCacheWrapper.getKeyCache(CACHE_KEY_GET_INTERMEDIARIO, String.valueOf(intermediario.getCodIntermediario())));} catch (Exception e) {	}
	}
	
	public static void removeFromCache(Operatore operatore) {
		try {operatoriBDCacheWrapper.removeObjectCache(operatoriBDCacheWrapper.getKeyCache(CACHE_KEY_GET_OPERATORE, String.valueOf(operatore.getId())));} catch (Exception e) {	}
		try {operatoriBDCacheWrapper.removeObjectCache(operatoriBDCacheWrapper.getKeyCache(CACHE_KEY_GET_OPERATORE_BY_PRINCIPAL, String.valueOf(operatore.getUtenza().getPrincipal())));} catch (Exception e) {	}
		try {operatoriBDCacheWrapper.removeObjectCache(operatoriBDCacheWrapper.getKeyCache(CACHE_KEY_GET_OPERATORE_BY_SUBJECT, String.valueOf(operatore.getUtenza().getPrincipal())));} catch (Exception e) {	}
	}
	
	public static void removeFromCache(Utenza utenza) {
		try {utenzeBDCacheWrapper.removeObjectCache(utenzeBDCacheWrapper.getKeyCache(CACHE_KEY_GET_UTENZA, String.valueOf(utenza.getId())));} catch (Exception e) {	}
		try {utenzeBDCacheWrapper.removeObjectCache(utenzeBDCacheWrapper.getKeyCache(CACHE_KEY_GET_UTENZA, String.valueOf(utenza.getPrincipal())));} catch (Exception e) {	}
	}
	
	public static void removeFromCache(Stazione stazione) {
		try {stazioniBDCacheWrapper.removeObjectCache(stazioniBDCacheWrapper.getKeyCache(CACHE_KEY_GET_STAZIONE, String.valueOf(stazione.getId())));} catch (Exception e) {	}
		try {stazioniBDCacheWrapper.removeObjectCache(stazioniBDCacheWrapper.getKeyCache(CACHE_KEY_GET_STAZIONE, String.valueOf(stazione.getCodStazione())));} catch (Exception e) {	}
	}
	
	public static void removeFromCache(Tributo tributo) {
		try {tributiBDCacheWrapper.removeObjectCache(tributiBDCacheWrapper.getKeyCache(CACHE_KEY_GET_TRIBUTO, String.valueOf(tributo.getId())));} catch (Exception e) {	}
		try {tributiBDCacheWrapper.removeObjectCache(tributiBDCacheWrapper.getKeyCache(CACHE_KEY_GET_TRIBUTO, String.valueOf(tributo.getCodTributo() + "@" + tributo.getIdDominio())));} catch (Exception e) {	}
	}
	
	public static void removeFromCache(TipoTributo tipoTributo) {
		try {tipiTributoBDCacheWrapper.removeObjectCache(tipiTributoBDCacheWrapper.getKeyCache(CACHE_KEY_GET_TIPO_TRIBUTO, String.valueOf(tipoTributo.getId())));} catch (Exception e) {	}
		try {tipiTributoBDCacheWrapper.removeObjectCache(tipiTributoBDCacheWrapper.getKeyCache(CACHE_KEY_GET_TIPO_TRIBUTO, String.valueOf(tipoTributo.getCodTributo())));} catch (Exception e) {	}
	}
	
	public static Dominio getDominio(BasicBD basicBD, long id) throws ServiceException {
		try {
			String method = CACHE_KEY_GET_DOMINIO;
			Object dominio = dominiBDCacheWrapper.getObjectCache(basicBD, DEBUG, String.valueOf(id), method, Long.valueOf(id));
			return (Dominio) dominio;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw new ServiceException(t);
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}

	public static Dominio getDominio(BasicBD basicBD, String codDominio) throws ServiceException, NotFoundException {
		try {
			String method = CACHE_KEY_GET_DOMINIO;
			Object dominio = dominiBDCacheWrapper.getObjectCache(basicBD, DEBUG, codDominio, method, codDominio);
			return (Dominio) dominio;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw (NotFoundException) t;
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}

	public static Applicazione getApplicazione(BasicBD basicBD, long id) throws ServiceException {
		try {
			String method = CACHE_KEY_GET_APPLICAZIONE;
			Object applicazione = applicazioniBDCacheWrapper.getObjectCache(basicBD, DEBUG, String.valueOf(id), method, Long.valueOf(id));
			return (Applicazione) applicazione;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw new ServiceException(t);
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}

	public static Applicazione getApplicazione(BasicBD basicBD, String codApplicazione) throws ServiceException, NotFoundException {
		try {
			String method = CACHE_KEY_GET_APPLICAZIONE;
			Object applicazione = applicazioniBDCacheWrapper.getObjectCache(basicBD, DEBUG, codApplicazione, method, codApplicazione);
			return (Applicazione) applicazione;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw (NotFoundException) t;
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}
	
	public static Applicazione getApplicazioneBySubject(BasicBD basicBD, String principal) throws ServiceException, NotFoundException {
		try {
			String method = CACHE_KEY_GET_APPLICAZIONE_BY_SUBJECT;
			Object applicazione = applicazioniBDCacheWrapper.getObjectCache(basicBD, DEBUG, principal, method, principal);
			return (Applicazione) applicazione;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw (NotFoundException) t;
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}
	
	public static Applicazione getApplicazioneByPrincipal(BasicBD basicBD, String principal) throws ServiceException, NotFoundException {
		try {
			String method = CACHE_KEY_GET_APPLICAZIONE_BY_PRINCIPAL;
			Object applicazione = applicazioniBDCacheWrapper.getObjectCache(basicBD, DEBUG, principal, method, principal);
			return (Applicazione) applicazione;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw (NotFoundException) t;
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}


	public static UnitaOperativa getUnitaOperativa(BasicBD basicBD, long id) throws ServiceException {
		try {
			String method = CACHE_KEY_GET_UNITA_OPERATIVA;
			Object uo = uoBDCacheWrapper.getObjectCache(basicBD, DEBUG, String.valueOf(id), method, Long.valueOf(id));
			return (UnitaOperativa) uo;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw new ServiceException(t);
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}

	public static UnitaOperativa getUnitaOperativa(BasicBD basicBD, long idDominio, String codUo) throws ServiceException, NotFoundException {
		try {
			String method = CACHE_KEY_GET_UNITA_OPERATIVA;
			Object uo = uoBDCacheWrapper.getObjectCache(basicBD, DEBUG, codUo + "@" + idDominio, method, idDominio, codUo);
			return (UnitaOperativa) uo;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw (NotFoundException) t;
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}
	
	public static UnitaOperativa getUnitaOperativaByCodUnivocoUo(BasicBD basicBD, long idDominio, String codUnivocoUo) throws ServiceException, NotFoundException {
		try {
			String method = "getUnitaOperativaByCodUnivocoUo";
			Object uo = uoBDCacheWrapper.getObjectCache(basicBD, DEBUG, "ByCodUnivocoUo#" + codUnivocoUo + "@" + idDominio, method, idDominio, codUnivocoUo);
			return (UnitaOperativa) uo;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw (NotFoundException) t;
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}


	public static IbanAccredito getIbanAccredito(BasicBD basicBD, long id) throws ServiceException {
		try {
			String method = CACHE_KEY_GET_IBAN_ACCREDITO;
			Object ibanAccredito = ibanAccreditoBDCacheWrapper.getObjectCache(basicBD, DEBUG, String.valueOf(id), method, Long.valueOf(id));
			return (IbanAccredito) ibanAccredito;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw new ServiceException(t);
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}

	public static IbanAccredito getIbanAccredito(BasicBD basicBD, Long idDominio, String codIbanAccredito) throws ServiceException, NotFoundException {
		try {
			String method = CACHE_KEY_GET_IBAN_ACCREDITO;
			Object ibanAccredito = ibanAccreditoBDCacheWrapper.getObjectCache(basicBD, DEBUG, codIbanAccredito + "@" + idDominio, method, idDominio, codIbanAccredito);
			return (IbanAccredito) ibanAccredito;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw (NotFoundException) t;
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}


	public static Intermediario getIntermediario(BasicBD basicBD, long id) throws ServiceException {
		try {
			String method = CACHE_KEY_GET_INTERMEDIARIO;
			Object intermediario = intermediariBDCacheWrapper.getObjectCache(basicBD, DEBUG, String.valueOf(id), method, Long.valueOf(id));
			return (Intermediario) intermediario;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw new ServiceException(t);
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}

	public static Intermediario getIntermediario(BasicBD basicBD, String codIntermediario) throws ServiceException, NotFoundException {
		try {
			String method = CACHE_KEY_GET_INTERMEDIARIO;
			Object intermediario = intermediariBDCacheWrapper.getObjectCache(basicBD, DEBUG, codIntermediario, method, codIntermediario);
			return (Intermediario) intermediario;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw (NotFoundException) t;
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}

	public static Operatore getOperatore(BasicBD basicBD, long id) throws ServiceException {
		try {
			String method = CACHE_KEY_GET_OPERATORE;
			Object operatore = operatoriBDCacheWrapper.getObjectCache(basicBD, DEBUG, String.valueOf(id), method, Long.valueOf(id));
			return (Operatore) operatore;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw new ServiceException(t);
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}
	
	
	public static Operatore getOperatoreByPrincipal(BasicBD basicBD, String principal) throws ServiceException, NotFoundException {
		try {
			String method = CACHE_KEY_GET_OPERATORE_BY_PRINCIPAL;
			Object operatore = operatoriBDCacheWrapper.getObjectCache(basicBD, DEBUG, principal, method, principal);
			return (Operatore) operatore;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw (NotFoundException) t;
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}
	
	public static Operatore getOperatoreBySubject(BasicBD basicBD, String principal) throws ServiceException, NotFoundException {
		try {
			String method = CACHE_KEY_GET_OPERATORE_BY_SUBJECT;
			Object operatore = operatoriBDCacheWrapper.getObjectCache(basicBD, DEBUG, principal, method, principal);
			return (Operatore) operatore;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw (NotFoundException) t;
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}
	
	public static Utenza getUtenza(BasicBD basicBD, long id) throws ServiceException {
		try {
			String method = CACHE_KEY_GET_UTENZA;
			Object utenza = utenzeBDCacheWrapper.getObjectCache(basicBD, DEBUG, String.valueOf(id), method, Long.valueOf(id));
			return (Utenza) utenza;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw new ServiceException(t);
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}
	
	public static Utenza getUtenza(BasicBD basicBD, String principal) throws ServiceException, NotFoundException {
		try {
			String method = CACHE_KEY_GET_UTENZA;
			Object utenza = utenzeBDCacheWrapper.getObjectCache(basicBD, DEBUG, principal, method, principal);
			return (Utenza) utenza;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw (NotFoundException) t;
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}

	
	
	public static Stazione getStazione(BasicBD basicBD, long id) throws ServiceException {
		try {
			String method = CACHE_KEY_GET_STAZIONE;
			Object stazione = stazioniBDCacheWrapper.getObjectCache(basicBD, DEBUG, String.valueOf(id), method, Long.valueOf(id));
			return (Stazione) stazione;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw new ServiceException(t);
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}

	public static Stazione getStazione(BasicBD basicBD, String codStazione) throws ServiceException, NotFoundException {
		try {
			String method = CACHE_KEY_GET_STAZIONE;
			Object stazione = stazioniBDCacheWrapper.getObjectCache(basicBD, DEBUG, codStazione, method, codStazione);
			return (Stazione) stazione;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw (NotFoundException) t;
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}


	public static Tributo getTributo(BasicBD basicBD, long id) throws ServiceException {
		try {
			String method = CACHE_KEY_GET_TRIBUTO;
			Object tributo = tributiBDCacheWrapper.getObjectCache(basicBD, DEBUG, String.valueOf(id), method, Long.valueOf(id));
			return (Tributo) tributo;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw new ServiceException(t);
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}

	public static Tributo getTributo(BasicBD basicBD, long idDominio, String codTributo) throws ServiceException, NotFoundException {
		try {
			String method = CACHE_KEY_GET_TRIBUTO;
			Object tributo = tributiBDCacheWrapper.getObjectCache(basicBD, DEBUG, codTributo + "@" +  String.valueOf(idDominio), method, Long.valueOf(idDominio), codTributo);
			return (Tributo) tributo;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw (NotFoundException) t;
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}

	public static TipoTributo getTipoTributo(BasicBD basicBD, long id) throws ServiceException {
		try {
			String method = CACHE_KEY_GET_TIPO_TRIBUTO;
			Object tipoTributo = tipiTributoBDCacheWrapper.getObjectCache(basicBD, DEBUG, String.valueOf(id), method, Long.valueOf(id));
			return (TipoTributo) tipoTributo;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw new ServiceException(t);
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}

	public static TipoTributo getTipoTributo(BasicBD basicBD, String codTributo) throws ServiceException, NotFoundException {
		try {
			String method = CACHE_KEY_GET_TIPO_TRIBUTO;
			Object tributo = tipiTributoBDCacheWrapper.getObjectCache(basicBD, DEBUG, codTributo, method, codTributo);
			return (TipoTributo) tributo;
		} catch (Throwable t) {
			if(t instanceof NotFoundException) {
				throw (NotFoundException) t;
			}
			if(t instanceof MultipleResultException) {
				throw new ServiceException(t);
			}
			if(t instanceof ServiceException) {
				throw (ServiceException) t;
			}
			throw new ServiceException(t);
		}
	}
}