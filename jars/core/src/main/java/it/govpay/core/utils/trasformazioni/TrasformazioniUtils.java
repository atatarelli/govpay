package it.govpay.core.utils.trasformazioni;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.core.MultivaluedMap;

import org.openspcoop2.utils.date.DateManager;
import org.openspcoop2.utils.resources.TemplateUtils;
import org.openspcoop2.utils.service.context.IContext;
import org.slf4j.Logger;

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateModel;
import it.govpay.core.utils.GpContext;
import it.govpay.core.utils.trasformazioni.exception.TrasformazioneException;

public class TrasformazioniUtils {

	public static void fillDynamicMap(Logger log, Map<String, Object> dynamicMap, IContext context, MultivaluedMap<String, String> queryParameters,
			MultivaluedMap<String, String> pathParameters, Map<String, String> headers, String json) {
		if(dynamicMap.containsKey(Costanti.MAP_DATE_OBJECT)==false) {
			dynamicMap.put(Costanti.MAP_DATE_OBJECT, DateManager.getDate());
		}

		if(context !=null) {
			if(dynamicMap.containsKey(Costanti.MAP_CTX_OBJECT)==false) {
				dynamicMap.put(Costanti.MAP_CTX_OBJECT, context);
			}
			if(dynamicMap.containsKey(Costanti.MAP_TRANSACTION_ID_OBJECT)==false) {
				String idTransazione = context.getTransactionId();
				dynamicMap.put(Costanti.MAP_TRANSACTION_ID_OBJECT, idTransazione);
			}

			GpContext ctx = (GpContext) ((org.openspcoop2.utils.service.context.Context)context).getApplicationContext();
			if(ctx !=null && ctx.getEventoCtx()!=null && ctx.getEventoCtx().getUrl() != null) {
				URLRegExpExtractor urle = new URLRegExpExtractor(ctx.getEventoCtx().getUrl(), log);
				dynamicMap.put(Costanti.MAP_ELEMENT_URL_REGEXP, urle);
				dynamicMap.put(Costanti.MAP_ELEMENT_URL_REGEXP.toLowerCase(), urle);
			}
		}

		if(dynamicMap.containsKey(Costanti.MAP_HEADER)==false && headers !=null) {
			dynamicMap.put(Costanti.MAP_HEADER, headers);
		}

		if(dynamicMap.containsKey(Costanti.MAP_QUERY_PARAMETER)==false && queryParameters!=null && !queryParameters.isEmpty()) {
			dynamicMap.put(Costanti.MAP_QUERY_PARAMETER, convertMultiToRegularMap(queryParameters));
		}

		if(dynamicMap.containsKey(Costanti.MAP_PATH_PARAMETER)==false && pathParameters!=null && !pathParameters.isEmpty()) {
			dynamicMap.put(Costanti.MAP_PATH_PARAMETER, convertMultiToRegularMap(pathParameters));
		}

		if(json !=null) {
			PatternExtractor pe = new PatternExtractor(json, log);
			dynamicMap.put(Costanti.MAP_ELEMENT_JSON_PATH, pe);
			dynamicMap.put(Costanti.MAP_ELEMENT_JSON_PATH.toLowerCase(), pe);
		}
	}

	public static void convertFreeMarkerTemplate(String name, byte[] template, Map<String,Object> dynamicMap, OutputStream out) throws TrasformazioneException {
		try {			
			OutputStreamWriter oow = new OutputStreamWriter(out);
			_convertFreeMarkerTemplate(name, template, dynamicMap, oow);
			oow.flush();
			oow.close();
		}catch(Exception e) {
			throw new TrasformazioneException(e.getMessage(),e);
		}
	}
	public static void convertFreeMarkerTemplate(String name, byte[] template, Map<String,Object> dynamicMap, Writer writer) throws TrasformazioneException {
		_convertFreeMarkerTemplate(name, template, dynamicMap, writer);
	}
	private static void _convertFreeMarkerTemplate(String name, byte[] template, Map<String,Object> dynamicMap, Writer writer) throws TrasformazioneException {
		try {
			// ** Aggiungo utility per usare metodi statici ed istanziare oggetti

			// statici
			BeansWrapper wrapper = new BeansWrapper(Configuration.VERSION_2_3_23);
			TemplateModel classModel = wrapper.getStaticModels();
			dynamicMap.put(Costanti.MAP_CLASS_LOAD_STATIC, classModel);

			// newObject
			dynamicMap.put(Costanti.MAP_CLASS_NEW_INSTANCE, new freemarker.template.utility.ObjectConstructor());


			// ** costruisco template
			Template templateFTL = TemplateUtils.buildTemplate(name, template);
			templateFTL.process(dynamicMap, writer);
			writer.flush();

		}catch(Exception e) {
			throw new TrasformazioneException(e.getMessage(),e);
		}
	}

	private static Map<String, String> convertMultiToRegularMap(MultivaluedMap<String, String> m) {
		Map<String, String> map = new HashMap<String, String>();
		if (m == null) {
			return map;
		}
		for (Entry<String, List<String>> entry : m.entrySet()) {
			if(entry.getValue() != null) {
				StringBuilder sb = new StringBuilder();
				for (String s : entry.getValue()) {
					if (sb.length() > 0) {
						sb.append(',');
					}
					sb.append(s);
				}
				map.put(entry.getKey(), sb.toString());
			}
		}
		return map;
	}
}
