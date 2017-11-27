function defaultFormatter(a){var i=!!a.uri,t='<div class="layout-item-box">';return t+='<div class="item-group fill-group">',t+='<div class="item-titolo item-valore">'+a.titolo+"</div>",t+='<div class="item-sottotitolo item-label">'+a.sottotitolo+"</div>",t+="</div>",i&&(t+='<div><iron-icon icon="chevron-right"></iron-icon></div>'),t+="</div>"}function versamenti1(a){var i="icons:check-circle";_getEtichetta(a.voci.statoVersamento,!1);"NON_ESEGUITO"===getValore(a.voci.statoVersamento)&&(i="icons:radio-button-unchecked"),"ANNULLATO"===getValore(a.voci.statoVersamento)&&(i="icons:cancel"),"ANOMALO"===getValore(a.voci.statoVersamento)&&(i="icons:report-problem");var t='<div class="layout-item-box">';return"ANNULLATO"===getValore(a.voci.statoVersamento)&&(t+='<div class="layout-anomalie">'),t+='<div class="layout-group">',t+='<div class="label-group">',t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.statoText)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.statoText)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.codDominio)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.codDominio)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.id)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.id)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.cf)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.cf)+"</span></div>",t+="</div>",t+='<div class="label-group">',t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.importoTotale)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.importoTotale)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.iuv)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.iuv)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.scadenza)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.scadenza)+"</span></div>",t+="</div>",t+="</div>","ANNULLATO"===getValore(a.voci.statoVersamento)&&(t+='<div class="anomalie-group">',t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.motivazioneAnnullamento)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.motivazioneAnnullamento)+"</span></div>",t+="</div>",t+="</div><!-- anomalie-group -->"),t+='<div><iron-icon icon="chevron-right"></iron-icon></div>',t+="</div>"}function flussoRendicontazioni1(a){var i="icons:check-circle";_getEtichetta(a.voci.stato,!1);"ACCETTATA"!=getValore(a.voci.stato)&&(i="icons:report-problem");var t='<div class="layout-item-box">';t+='<div class="layout-group">',t+='<div class="label-group">',t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.statoText)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.statoText)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.codFlusso)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.codFlusso)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.idDominio)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.idDominio)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.psp)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.psp)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.trn)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.trn)+"</span></div>",t+="</div>",t+='<div class="label-group">',t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.numRendicontazioniOk)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.numRendicontazioniOk)+"</span></div>";var e=getValore(a.voci.numRendicontazioniAnomale);e&&e>0&&(t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.numRendicontazioniAnomale)+"</span>",t+='<span class="item-valore">'+e+"</span></div>");var o=getValore(a.voci.numRendicontazioniAltroIntermediario);return o&&o>0&&(t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.numRendicontazioniAltroIntermediario)+"</span>",t+='<span class="item-valore">'+o+"</span></div>"),t+="</div>",t+="</div>",t+='<div><iron-icon icon="chevron-right"></iron-icon></div>',t+="</div>"}function rendicontazioni1(a){var i="icons:check-circle";_getEtichetta(a.voci.stato,!1);"3"===getValore(a.voci.esito)&&(i="icons:check-circle"),"ANOMALA"===getValore(a.voci.stato)&&(i="icons:report-problem"),"ALTRO_INTERMEDIARIO"===getValore(a.voci.stato)&&(i="icons:radio-button-unchecked");var t='<div class="layout-item-box">';if(a.voci.anomalie&&(t+='<div class="layout-anomalie">'),t+='<div class="layout-group">',t+='<div class="label-group">',t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.statoText)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.statoText)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.dominio)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.dominio)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.iuv)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.iuv)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.iur)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.iur)+"</span></div>",t+="</div>",t+='<div class="label-group">',t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.importo)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.importo)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.data)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.data)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.codSingoloVersamento)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.codSingoloVersamento)+"</span></div>",t+="</div>",t+="</div>",a.voci.anomalie){t+='<div class="anomalie-group">',t+='<span class="item-label">'+_getEtichetta(a.voci.anomalie,!1)+"</span>";var e=getVoci(a.voci,"anomalie_");for(var o in e)t+='<div class="item-group"><span class="item-label">'+getEtichetta(e[o])+"</span>",t+='<span class="item-valore">'+getValore(e[o])+"</span></div>";t+="</div>",t+="</div><!-- anomalie-group -->"}return a.uri&&""!=a.uri&&(t+='<div><iron-icon icon="chevron-right"></iron-icon></div>'),t+="</div>"}function transazioni1(a){var i="icons:check-circle";_getEtichetta(a.voci.statoTransazione,!1);"rr"===getValore(a.voci.tipo)&&(i="icons:check-circle"),"finaleKo"===getValore(a.voci.statoTransazione)&&(i="icons:cancel"),"inCorso"===getValore(a.voci.statoTransazione)&&(i="icons:radio-button-unchecked");var t='<div class="layout-item-box">';return t+='<div class="layout-group">',t+='<div class="label-group">',t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.statoText)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.statoText)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.idDominio)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.idDominio)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.iuv)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.iuv)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.ccp)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.ccp)+"</span></div>",t+="</div>",t+='<div class="label-group">',t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.data)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.data)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.psp)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.psp)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.importo)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.importo)+"</span></div>",t+="</div>",t+="</div>",t+='<div><iron-icon icon="chevron-right"></iron-icon></div>',t+="</div>"}function pagamenti1(a){var i="icons:check-circle";_getEtichetta(a.voci.stato,!1);"INCASSATO"!=getValore(a.voci.stato)&&(i="icons:radio-button-unchecked"),"RITARDO_INCASSO"===getValore(a.voci.stato)&&(i="icons:report-problem"),"BOLLO"===getValore(a.voci.stato)&&(i="editor:format-bold");var t='<div class="layout-item-box">';return a.voci.pagatoSenzaRpt&&(t+='<div class="layout-anomalie">'),t+='<div class="layout-group">',t+='<div class="label-group">',t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.statoText)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.statoText)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.idDominio)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.idDominio)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.iuv)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.iuv)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.iur)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.iur)+"</span></div>",t+="</div>",t+='<div class="label-group">',t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.importoPagato)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.importoPagato)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.dataPagamento)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.dataPagamento)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.codSingoloVersamentoEnte)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.codSingoloVersamentoEnte)+"</span></div>",t+="</div>",t+="</div>",a.voci.pagatoSenzaRpt&&(t+='<div class="anomalie-group">',t+='<span class="item-label">'+getValore(a.voci.pagatoSenzaRpt)+"</span>",t+="</div>",t+="</div><!-- anomalie-group -->"),t+='<div><iron-icon icon="chevron-right"></iron-icon></div>',t+="</div>"}function domini1(a){var i="icons:check-circle";_getEtichetta(a.voci.stato,!1);"disabilitato"!==getValore(a.voci.stato)&&"nonVerificato"!==getValore(a.voci.stato)||(i="icons:radio-button-unchecked"),"errore"===getValore(a.voci.stato)&&(i="icons:report-problem");var t='<div class="layout-item-box">';return t+='<div class="label-group fill-group">',t+='<div class="item-group fill-group"><span class="item-label">'+getEtichetta(a.voci.statoText)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.statoText)+"</span></div>",t+='<div class="item-group fill-group"><span class="item-label">'+getEtichetta(a.voci.ragioneSociale)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.ragioneSociale)+"</span></div>",t+='<div class="item-group fill-group"><span class="item-label">'+getEtichetta(a.voci.codDominio)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.codDominio)+"</span></div>",t+='<div class="item-group fill-group"><span class="item-label">'+getEtichetta(a.voci.codIntermediario)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.codIntermediario)+"</span></div>",a.voci.anomalia&&(t+='<div class="item-group fill-group"><span class="item-label">'+getEtichetta(a.voci.anomalia)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.anomalia)+"</span></div>"),t+="</div>",t+='<div><iron-icon icon="chevron-right"></iron-icon></div>',t+="</div>"}function stazioni1(a){var i="icons:check-circle";_getEtichetta(a.voci.stato,!1);"disabilitato"!==getValore(a.voci.stato)&&"nonVerificato"!==getValore(a.voci.stato)||(i="icons:radio-button-unchecked"),"errore"===getValore(a.voci.stato)&&(i="icons:report-problem");var t='<div class="layout-item-box">';return t+='<div class="layout-group">',t+='<div class="label-group fill-group">',t+='<div class="item-group fill-group"><span class="item-label">'+getEtichetta(a.voci.statoText)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.statoText)+"</span></div>",t+='<div class="item-group fill-group"><span class="item-valore">'+_getEtichetta(a.voci.codStazione,!1)+"</span></div>",a.voci.anomalia&&(t+='<div class="item-group fill-group"><span class="item-label">'+getEtichetta(a.voci.anomalia)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.anomalia)+"</span></div>"),t+="</div>",t+="</div>",t+='<div><iron-icon icon="chevron-right"></iron-icon></div>',t+="</div>"}function psp1(a){var i="icons:check-circle";_getEtichetta(a.voci.stato,!1);"disabilitato"!==getValore(a.voci.stato)&&"nonVerificato"!==getValore(a.voci.stato)||(i="icons:radio-button-unchecked"),"errore"===getValore(a.voci.stato)&&(i="icons:report-problem");var t='<div class="layout-item-box">';return t+='<div class="layout-group">',t+='<div class="label-group fill-group">',t+='<div class="item-group fill-group"><span class="item-label">'+getEtichetta(a.voci.statoText)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.statoText)+"</span></div>",t+='<div class="item-group fill-group"><span class="item-label">'+getEtichetta(a.voci.ragioneSociale)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.ragioneSociale)+"</span></div>",t+='<div class="item-group fill-group"><span class="item-label">'+getEtichetta(a.voci.codPsp)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.codPsp)+"</span></div>",t+="</div>",t+="</div>",t+='<div><iron-icon icon="chevron-right"></iron-icon></div>',t+="</div>"}function incassi1(a){var i="icons:check-circle";_getEtichetta(a.voci.stato,!1);"ERRORE"===getValore(a.voci.stato)&&(i="icons:report-problem");var t='<div class="layout-item-box">';return t+='<div class="layout-group">',t+='<div class="label-group">',t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.statoText)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.statoText)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.idDominio)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.idDominio)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.trn)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.trn)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.causale)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.causale)+"</span></div>",t+="</div>",t+='<div class="label-group">',t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.dataIncasso)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.dataIncasso)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.importo)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.importo)+"</span></div>",t+="</div>",t+="</div>",t+='<div><iron-icon icon="chevron-right"></iron-icon></div>',t+="</div>"}function tracciati1(a){var i="icons:radio-button-unchecked",t=_getEtichetta(a.voci.stato,!1);a.voci.hasOwnProperty("percentuale")&&a.voci.percentuale.hasOwnProperty("valore")&&(t+=" "+a.voci.percentuale.valore+"%",i=""),"CARICAMENTO_OK"!==getValore(a.voci.stato)&&"STAMPATO"!==getValore(a.voci.stato)||(i="icons:check-circle"),"CARICAMENTO_KO"===getValore(a.voci.stato)&&(i="icons:report-problem");var e='<div class="layout-item-box">';return e+='<div class="layout-group">',e+='<div class="label-group">',e+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.statoText)+"</span>",e+='<span class="item-valore">'+getValore(a.voci.statoText)+"</span></div>",e+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.nomeFile)+"</span>",e+='<span class="item-valore">'+getValore(a.voci.nomeFile)+"</span></div>",e+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.dataCaricamento)+"</span>",e+='<span class="item-valore">'+getValore(a.voci.dataCaricamento)+"</span></div>",e+="</div>",e+='<div class="label-group">',e+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.numOperazioniOk)+"</span>",e+='<span class="item-valore">'+getValore(a.voci.numOperazioniOk)+"</span></div>",e+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.numOperazioniKo)+"</span>",e+='<span class="item-valore">'+getValore(a.voci.numOperazioniKo)+"</span></div>",e+="</div>",e+="</div>",e+='<div><iron-icon icon="chevron-right"></iron-icon></div>',e+="</div>"}function operazioni1(a){var i="icons:check-circle";_getEtichetta(a.voci.stato,!1);"NON_VALIDO"!==getValore(a.voci.stato)&&"ESEGUITO_KO"!==getValore(a.voci.stato)||(i="icons:report-problem"),"NUOVO"===getValore(a.voci.stato)&&(i="icons:radio-button-unchecked");var t='<div class="layout-item-box">';if(a.voci.anomalie&&(t+='<div class="layout-anomalie">'),t+='<div class="layout-group">',t+='<div class="label-group">',t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.statoText)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.statoText)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.tipoOperazione)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.tipoOperazione)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.applicazione)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.applicazione)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.idVersamento)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.idVersamento)+"</span></div>",t+="</div>",t+="</div>",a.voci.anomalie){t+='<div class="anomalie-group">',t+='<span class="item-label">'+_getEtichetta(a.voci.anomalie,!1)+"</span>";var e=getVoci(a.voci,"anomalie_");for(var o in e)t+='<div class="item-group"><span class="item-label">'+getEtichetta(e[o])+"</span>",t+='<span class="item-valore">'+getValore(e[o])+"</span></div>";t+="</div>",t+="</div><!-- anomalie-group -->"}return a.uri&&""!=a.uri&&(t+='<div><iron-icon icon="chevron-right"></iron-icon></div>'),t+="</div>"}function operazioniCaricamento(a){var i="icons:check-circle";_getEtichetta(a.voci.stato,!1);"NON_VALIDO"!==getValore(a.voci.stato)&&"ESEGUITO_KO"!==getValore(a.voci.stato)||(i="icons:report-problem"),"NUOVO"===getValore(a.voci.stato)&&(i="icons:radio-button-unchecked");var t='<div class="layout-item-box">';if(a.voci.anomalie&&(t+='<div class="layout-anomalie">'),t+='<div class="layout-group">',t+='<div class="label-group">',t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.statoText)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.statoText)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.tipoOperazione)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.tipoOperazione)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.idVersamento)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.idVersamento)+"</span></div>",t+="</div>",t+='<div class="label-group">',t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.codDominio)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.codDominio)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.iuv)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.iuv)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.applicazione)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.applicazione)+"</span></div>",t+="</div>",t+="</div>",a.voci.anomalie){t+='<div class="anomalie-group">',t+='<span class="item-label">'+_getEtichetta(a.voci.anomalie,!1)+"</span>";var e=getVoci(a.voci,"anomalie_");for(var o in e)t+='<div class="item-group"><span class="item-label">'+getEtichetta(e[o])+"</span>",t+='<span class="item-valore">'+getValore(e[o])+"</span></div>";t+="</div>",t+="</div><!-- anomalie-group -->"}return t+='<div><iron-icon icon="chevron-right"></iron-icon></div>',t+="</div>"}function operazioniIncasso(a){var i="icons:check-circle";_getEtichetta(a.voci.stato,!1);"NON_VALIDO"!==getValore(a.voci.stato)&&"ESEGUITO_KO"!==getValore(a.voci.stato)||(i="icons:report-problem"),"NUOVO"===getValore(a.voci.stato)&&(i="icons:radio-button-unchecked");var t='<div class="layout-item-box">';if(a.voci.anomalie&&(t+='<div class="layout-anomalie">'),t+='<div class="layout-group">',t+='<div class="label-group">',t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.statoText)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.statoText)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.tipoOperazione)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.tipoOperazione)+"</span></div>",t+="</div>",t+='<div class="label-group">',t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.codDominio)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.codDominio)+"</span></div>",t+='<div class="item-group"><span class="item-label">'+getEtichetta(a.voci.trn)+"</span>",t+='<span class="item-valore">'+getValore(a.voci.trn)+"</span></div>",t+="</div>",t+="</div>",a.voci.anomalie){t+='<div class="anomalie-group">',t+='<span class="item-label">'+_getEtichetta(a.voci.anomalie,!1)+"</span>";var e=getVoci(a.voci,"anomalie_");for(var o in e)t+='<div class="item-group"><span class="item-label">'+getEtichetta(e[o])+"</span>",t+='<span class="item-valore">'+getValore(e[o])+"</span></div>";t+="</div>",t+="</div><!-- anomalie-group -->"}return t+='<div><iron-icon icon="chevron-right"></iron-icon></div>',t+="</div>"}function getEtichetta(a){return _getEtichetta(a,!0)}function _getEtichetta(a,i){return a?a.valore&&i?a.etichetta+": ":a.etichetta:""}function getValore(a){return a&&a.valore?a.valore:""}function getVoci(a,i){var t=[],e=Object.keys(a);for(var o in e){var s=e[o];s.startsWith(i)&&t.push(a[s])}return t}