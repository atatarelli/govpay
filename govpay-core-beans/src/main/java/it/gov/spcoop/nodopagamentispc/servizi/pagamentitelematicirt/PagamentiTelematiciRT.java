package it.gov.spcoop.nodopagamentispc.servizi.pagamentitelematicirt;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.5
 * 2018-07-04T14:49:49.787+02:00
 * Generated source version: 3.1.5
 * 
 */
@WebService(targetNamespace = "http://NodoPagamentiSPC.spcoop.gov.it/servizi/PagamentiTelematiciRT", name = "PagamentiTelematiciRT")
@XmlSeeAlso({gov.telematici.pagamenti.ws.ppthead.ObjectFactory.class, it.gov.digitpa.schemas._2011.ws.nodo.ObjectFactory.class})
public interface PagamentiTelematiciRT {

    @WebMethod(action = "paaInviaRT")
    @Action(input = "http://ws.pagamenti.telematici.gov/PPT/paaInviaRTRichiesta", output = "http://ws.pagamenti.telematici.gov/PPT/paaInviaRTRisposta")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "paaInviaRTRisposta", targetNamespace = "http://ws.pagamenti.telematici.gov/", partName = "bodyrisposta")
    public it.gov.digitpa.schemas._2011.ws.nodo.PaaInviaRTRisposta paaInviaRT(
        @WebParam(partName = "bodyrichiesta", name = "paaInviaRT", targetNamespace = "http://ws.pagamenti.telematici.gov/")
        it.gov.digitpa.schemas._2011.ws.nodo.PaaInviaRT bodyrichiesta,
        @WebParam(partName = "header", name = "intestazionePPT", targetNamespace = "http://ws.pagamenti.telematici.gov/ppthead", header = true)
        gov.telematici.pagamenti.ws.ppthead.IntestazionePPT header
    );

    @WebMethod(action = "paaInviaEsitoStorno")
    @Action(input = "http://ws.pagamenti.telematici.gov/PPT/paaInviaEsitoStornoRichiesta", output = "http://ws.pagamenti.telematici.gov/PPT/paaInviaEsitoStornoRisposta")
    @RequestWrapper(localName = "paaInviaEsitoStorno", targetNamespace = "http://ws.pagamenti.telematici.gov/", className = "it.gov.digitpa.schemas._2011.ws.nodo.PaaInviaEsitoStorno")
    @ResponseWrapper(localName = "paaInviaEsitoStornoRisposta", targetNamespace = "http://ws.pagamenti.telematici.gov/", className = "it.gov.digitpa.schemas._2011.ws.nodo.PaaInviaEsitoStornoRisposta")
    @WebResult(name = "paaInviaEsitoStornoRisposta", targetNamespace = "")
    public it.gov.digitpa.schemas._2011.ws.nodo.TipoInviaEsitoStornoRisposta paaInviaEsitoStorno(
        @WebParam(name = "identificativoIntermediarioPA", targetNamespace = "")
        java.lang.String identificativoIntermediarioPA,
        @WebParam(name = "identificativoStazioneIntermediarioPA", targetNamespace = "")
        java.lang.String identificativoStazioneIntermediarioPA,
        @WebParam(name = "identificativoDominio", targetNamespace = "")
        java.lang.String identificativoDominio,
        @WebParam(name = "identificativoUnivocoVersamento", targetNamespace = "")
        java.lang.String identificativoUnivocoVersamento,
        @WebParam(name = "codiceContestoPagamento", targetNamespace = "")
        java.lang.String codiceContestoPagamento,
        @WebParam(name = "er", targetNamespace = "")
        byte[] er
    );
}
