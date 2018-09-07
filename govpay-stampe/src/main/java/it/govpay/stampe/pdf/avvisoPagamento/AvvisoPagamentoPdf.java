package it.govpay.stampe.pdf.avvisoPagamento;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openspcoop2.utils.LoggerWrapperFactory;
import org.openspcoop2.utils.UtilsException;
import org.openspcoop2.utils.beans.WriteToSerializerType;
import org.slf4j.Logger;

import it.govpay.model.avvisi.AvvisoPagamento;
import it.govpay.model.avvisi.AvvisoPagamentoInput;
import it.govpay.stampe.pdf.avvisoPagamento.utils.AvvisoPagamentoProperties;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class AvvisoPagamentoPdf {

	private static AvvisoPagamentoPdf _instance = null;

	public static AvvisoPagamentoPdf getInstance() {
		if(_instance == null)
			init();

		return _instance;
	}

	public static synchronized void init() {
		if(_instance == null)
			_instance = new AvvisoPagamentoPdf();
	}

	public AvvisoPagamentoPdf() {

	}


	public JasperPrint creaJasperPrintAvviso(Logger log, AvvisoPagamentoInput input, AvvisoPagamento avvisoPagamento, 
			Properties propertiesAvvisoPerDominio, InputStream jasperTemplateInputStream,JRDataSource dataSource,Map<String, Object> parameters) throws Exception {
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperTemplateInputStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, dataSource);
		return jasperPrint;
	}

	public AvvisoPagamento creaAvviso(Logger log, AvvisoPagamentoInput input, AvvisoPagamento avvisoPagamento, AvvisoPagamentoProperties avProperties) throws Exception {
		// cerco file di properties esterni per configurazioni specifiche per dominio
		String codDominio = avvisoPagamento.getCodDominio();
		Properties propertiesAvvisoPerDominio = avProperties.getPropertiesPerDominio(codDominio, log);

		this.caricaLoghiAvviso(input, propertiesAvvisoPerDominio);

		// leggo il template file jasper da inizializzare
		String jasperTemplateFilename = propertiesAvvisoPerDominio.getProperty(AvvisoPagamentoCostanti.AVVISO_PAGAMENTO_TEMPLATE_JASPER);

		if(!jasperTemplateFilename.startsWith("/"))
			jasperTemplateFilename = "/" + jasperTemplateFilename; 

		InputStream is = AvvisoPagamentoPdf.class.getResourceAsStream(jasperTemplateFilename);
		Map<String, Object> parameters = new HashMap<>();
		JRDataSource dataSource = this.creaXmlDataSource(log,input);
		JasperPrint jasperPrint = this.creaJasperPrintAvviso(log, input, avvisoPagamento, propertiesAvvisoPerDominio, is, dataSource,parameters);

		byte[] reportToPdf = JasperExportManager.exportReportToPdf(jasperPrint);
		avvisoPagamento.setPdf(reportToPdf);
		return avvisoPagamento;
	}

	public JRDataSource creaXmlDataSource(Logger log,AvvisoPagamentoInput input) throws UtilsException, JRException {
		WriteToSerializerType serType = WriteToSerializerType.XML_JAXB;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		input.writeTo(os, serType);
		JRDataSource dataSource = new JRXmlDataSource(new ByteArrayInputStream(os.toByteArray()),AvvisoPagamentoCostanti.AVVISO_PAGAMENTO_ROOT_ELEMENT_NAME);
		return dataSource;
	}

	public JRDataSource creaCustomDataSource(Logger log,AvvisoPagamentoInput input) throws UtilsException, JRException {
		List<AvvisoPagamentoInput> listaAvvisi = new ArrayList<>();
		listaAvvisi.add(input);
		JRDataSource dataSource = new AvvisoPagamentoDatasource(listaAvvisi,log);
		return dataSource;
	}

	public void caricaLoghiAvviso(AvvisoPagamentoInput input, Properties propertiesAvvisoPerDominio) {
		// valorizzo la sezione loghi
		input.setEnteLogo(propertiesAvvisoPerDominio.getProperty(AvvisoPagamentoCostanti.LOGO_ENTE));
		input.setAgidLogo(propertiesAvvisoPerDominio.getProperty(AvvisoPagamentoCostanti.LOGO_AGID));
		input.setPagopaLogo(propertiesAvvisoPerDominio.getProperty(AvvisoPagamentoCostanti.LOGO_PAGOPA));
		input.setPagopa90Logo(propertiesAvvisoPerDominio.getProperty(AvvisoPagamentoCostanti.LOGO_PAGOPA_90));
		input.setAppLogo(propertiesAvvisoPerDominio.getProperty(AvvisoPagamentoCostanti.LOGO_APP));
		input.setPlaceLogo(propertiesAvvisoPerDominio.getProperty(AvvisoPagamentoCostanti.LOGO_PLACE));
		input.setImportoLogo(propertiesAvvisoPerDominio.getProperty(AvvisoPagamentoCostanti.LOGO_IMPORTO));
		input.setScadenzaLogo(propertiesAvvisoPerDominio.getProperty(AvvisoPagamentoCostanti.LOGO_SCADENZA));
		input.setTaglio(propertiesAvvisoPerDominio.getProperty(AvvisoPagamentoCostanti.LOGO_TAGLIO));
		input.setTaglio1(propertiesAvvisoPerDominio.getProperty(AvvisoPagamentoCostanti.LOGO_TAGLIO1));
	}


	public static void main(String[] args) throws Exception {
		try (InputStream jasperTemplateInputStream = new FileInputStream("FILE_PATH/AvvisoPagamento.jasper");) {
			Logger log = LoggerWrapperFactory.getLogger(AvvisoPagamentoPdf.class);

			AvvisoPagamentoProperties.newInstance("/var/govpay");

			AvvisoPagamentoProperties avProperties = AvvisoPagamentoProperties.getInstance();
			AvvisoPagamento av = new AvvisoPagamento();
			av.setCodDominio("83000390019");

			String codDominio = av.getCodDominio();
			Properties propertiesAvvisoPerDominio = avProperties.getPropertiesPerDominio(codDominio, log);

			Map<String, Object> parameters = new HashMap<>();
			AvvisoPagamentoInput input = new AvvisoPagamentoInput();
			AvvisoPagamentoPdf.getInstance().caricaLoghiAvviso(input, propertiesAvvisoPerDominio);

			input.setEnteDenominazione("Comune di San Valentino in Abruzzo Citeriore");
			input.setEnteArea("Area di sviluppo per le politiche agricole e forestali");
			input.setEnteIdentificativo("83000390019");
			input.setEnteCbill("AAAAAAA");
			input.setEnteUrl("www.comune.sanciprianopicentino.sa.it/");
			input.setEntePeo("info@comune.sancipriano.sa.it");
			input.setEntePec("protocollo@pec.comune.sanciprianopicentino.sa.it");
			input.setEntePartner("Link.it Srl");
			input.setIntestatarioDenominazione("Lorenzo Nardi");
			input.setIntestatarioIdentificativo("NRDLNA80P19D612M");
			input.setIntestatarioIndirizzo1("Via di Corniola 119A");
			input.setIntestatarioIndirizzo2("50053 Empoli (FI)");
			input.setAvvisoCausale("Pagamento diritti di segreteria per il rilascio in duplice copia della documentazione richiesta.");
			input.setAvvisoImporto(9999999.99);
			input.setAvvisoScadenza("31/12/2020");
			input.setAvvisoNumero("399000012345678900");
			input.setAvvisoIuv("99000012345678900");
			input.setAvvisoBarcode("415808888880094580203990000123456789003902222250");
			input.setAvvisoQrcode("PAGOPA|002|399000012345678900|83000390019|222250");

			JRDataSource dataSource = AvvisoPagamentoPdf.getInstance().creaXmlDataSource(log,input);
			JasperPrint jasperPrint = AvvisoPagamentoPdf.getInstance().creaJasperPrintAvviso(log, input, av, propertiesAvvisoPerDominio, jasperTemplateInputStream, dataSource,parameters);

			JasperExportManager.exportReportToPdfFile(jasperPrint,"/tmp/tmp.pdf");

			//System.out.println(input.toXml_Jaxb()); 
			System.out.println("FINE");
		}catch(Exception e ) {
			throw e;
		}  
	}
}
