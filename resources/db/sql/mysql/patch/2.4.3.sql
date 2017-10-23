-- GP-550
ALTER TABLE pagamenti ADD COLUMN indice_dati INT NOT NULL default 1;
ALTER TABLE pagamenti ADD CONSTRAINT unique_pagamenti_1 UNIQUE (cod_dominio,iuv,iur,indice_dati);
CREATE UNIQUE INDEX index_pagamenti_1 ON pagamenti (cod_dominio,iuv,iur,indice_dati);

ALTER TABLE canali DROP CONSTRAINT fk_canali_1;
ALTER TABLE stazioni DROP CONSTRAINT fk_stazioni_1;
ALTER TABLE domini DROP CONSTRAINT fk_domini_1;
ALTER TABLE domini DROP CONSTRAINT fk_domini_2;
ALTER TABLE uo DROP CONSTRAINT fk_uo_1;
ALTER TABLE iban_accredito DROP CONSTRAINT fk_iban_accredito_1;
ALTER TABLE tributi DROP CONSTRAINT fk_tributi_1;
ALTER TABLE tributi DROP CONSTRAINT fk_tributi_2;
ALTER TABLE tributi DROP CONSTRAINT fk_tributi_3;
ALTER TABLE acl DROP CONSTRAINT fk_acl_1;
ALTER TABLE acl DROP CONSTRAINT fk_acl_2;
ALTER TABLE acl DROP CONSTRAINT fk_acl_3;
ALTER TABLE acl DROP CONSTRAINT fk_acl_4;
ALTER TABLE acl DROP CONSTRAINT fk_acl_5;
ALTER TABLE acl DROP CONSTRAINT fk_acl_6;
-- ALTER TABLE versamenti DROP CONSTRAINT fk_versamenti_1;
-- ALTER TABLE versamenti DROP CONSTRAINT fk_versamenti_2;
-- ALTER TABLE singoli_versamenti DROP CONSTRAINT fk_singoli_versamenti_1;
-- ALTER TABLE singoli_versamenti DROP CONSTRAINT fk_singoli_versamenti_2;
-- ALTER TABLE singoli_versamenti DROP CONSTRAINT fk_singoli_versamenti_3;
-- ALTER TABLE rpt DROP CONSTRAINT fk_rpt_1;
-- ALTER TABLE rpt DROP CONSTRAINT fk_rpt_2;
-- ALTER TABLE rpt DROP CONSTRAINT fk_rpt_3;
ALTER TABLE rr DROP CONSTRAINT fk_rr_1;
-- ALTER TABLE notifiche DROP CONSTRAINT fk_notifiche_1;
-- ALTER TABLE notifiche DROP CONSTRAINT fk_notifiche_2;
-- ALTER TABLE notifiche DROP CONSTRAINT fk_notifiche_3;
-- ALTER TABLE iuv DROP CONSTRAINT fk_iuv_1;
-- ALTER TABLE iuv DROP CONSTRAINT fk_iuv_2;
ALTER TABLE incassi DROP CONSTRAINT fk_incassi_1;
ALTER TABLE pagamenti DROP CONSTRAINT fk_pagamenti_1;
ALTER TABLE pagamenti DROP CONSTRAINT fk_pagamenti_2;
ALTER TABLE pagamenti DROP CONSTRAINT fk_pagamenti_3;
ALTER TABLE pagamenti DROP CONSTRAINT fk_pagamenti_4;
ALTER TABLE rendicontazioni DROP CONSTRAINT fk_rendicontazioni_1;
ALTER TABLE rendicontazioni DROP CONSTRAINT fk_rendicontazioni_2;
ALTER TABLE tracciati DROP CONSTRAINT fk_tracciati_1;
ALTER TABLE tracciati DROP CONSTRAINT fk_tracciati_2;
ALTER TABLE operazioni DROP CONSTRAINT fk_operazioni_1;
ALTER TABLE operazioni DROP CONSTRAINT fk_operazioni_2;
ALTER TABLE gp_audit DROP CONSTRAINT fk_gp_audit_1;


ALTER TABLE canali ADD CONSTRAINT fk_id_psp FOREIGN KEY (id_psp) REFERENCES psp(id);
ALTER TABLE stazioni ADD CONSTRAINT fk_id_intermediario FOREIGN KEY (id_intermediario) REFERENCES intermediari(id);
ALTER TABLE domini ADD CONSTRAINT fk_id_stazione FOREIGN KEY (id_stazione) REFERENCES stazioni(id);
ALTER TABLE domini ADD CONSTRAINT fk_id_applicazione_default FOREIGN KEY (id_applicazione_default) REFERENCES applicazioni(id);
ALTER TABLE uo ADD CONSTRAINT fk_id_dominio FOREIGN KEY (id_dominio) REFERENCES domini(id);
ALTER TABLE iban_accredito ADD CONSTRAINT fk_id_dominio FOREIGN KEY (id_dominio) REFERENCES domini(id);

ALTER TABLE tributi ADD CONSTRAINT fk_id_dominio FOREIGN KEY (id_dominio) REFERENCES domini(id);
ALTER TABLE tributi ADD CONSTRAINT fk_id_iban_accredito FOREIGN KEY (id_iban_accredito) REFERENCES iban_accredito(id);
ALTER TABLE tributi ADD CONSTRAINT fk_id_tipo_tributo FOREIGN KEY (id_tipo_tributo) REFERENCES tipi_tributo(id);

ALTER TABLE acl ADD CONSTRAINT fk_id_applicazione FOREIGN KEY (id_applicazione) REFERENCES applicazioni(id);
ALTER TABLE acl ADD CONSTRAINT fk_id_portale FOREIGN KEY (id_portale) REFERENCES portali(id);
ALTER TABLE acl ADD CONSTRAINT fk_id_operatore FOREIGN KEY (id_operatore) REFERENCES operatori(id);
ALTER TABLE acl ADD CONSTRAINT fk_id_ruolo FOREIGN KEY (id_ruolo) REFERENCES ruoli(id);
ALTER TABLE acl ADD CONSTRAINT fk_id_dominio FOREIGN KEY (id_dominio) REFERENCES domini(id);
ALTER TABLE acl ADD CONSTRAINT fk_id_tipo_tributo FOREIGN KEY (id_tipo_tributo) REFERENCES tipi_tributo(id);

-- ALTER TABLE versamenti ADD CONSTRAINT fk_id_uo FOREIGN KEY (id_uo) REFERENCES uo(id);
-- ALTER TABLE versamenti ADD CONSTRAINT fk_id_applicazione FOREIGN KEY (id_applicazione) REFERENCES applicazioni(id);

-- ALTER TABLE singoli_versamenti ADD CONSTRAINT fk_id_versamento FOREIGN KEY (id_versamento) REFERENCES versamenti(id);
-- ALTER TABLE singoli_versamenti ADD CONSTRAINT fk_id_tributo FOREIGN KEY (id_tributo) REFERENCES tributi(id);
-- ALTER TABLE singoli_versamenti ADD CONSTRAINT fk_id_iban_accredito FOREIGN KEY (id_iban_accredito) REFERENCES iban_accredito(id);

-- ALTER TABLE rpt ADD CONSTRAINT fk_id_versamento FOREIGN KEY (id_versamento) REFERENCES versamenti(id);
-- ALTER TABLE rpt ADD CONSTRAINT fk_id_canale FOREIGN KEY (id_canale) REFERENCES canali(id);
-- ALTER TABLE rpt ADD CONSTRAINT fk_id_portale FOREIGN KEY (id_portale) REFERENCES portali(id);

ALTER TABLE rr ADD CONSTRAINT fk_id_rpt FOREIGN KEY (id_rpt) REFERENCES rpt(id);

-- ALTER TABLE notifiche ADD CONSTRAINT fk_id_applicazione FOREIGN KEY (id_applicazione) REFERENCES applicazioni(id);
-- ALTER TABLE notifiche ADD CONSTRAINT fk_id_rpt FOREIGN KEY (id_rpt) REFERENCES rpt(id);
-- ALTER TABLE notifiche ADD CONSTRAINT fk_id_rr FOREIGN KEY (id_rr) REFERENCES rr(id);

-- ALTER TABLE iuv ADD CONSTRAINT fk_id_applicazione FOREIGN KEY (id_applicazione) REFERENCES applicazioni(id),
-- ALTER TABLE iuv ADD CONSTRAINT fk_id_dominio FOREIGN KEY (id_dominio) REFERENCES domini(id),

ALTER TABLE incassi ADD CONSTRAINT fk_id_applicazione FOREIGN KEY (id_applicazione) REFERENCES applicazioni(id);

ALTER TABLE pagamenti ADD CONSTRAINT fk_id_rpt FOREIGN KEY (id_rpt) REFERENCES rpt(id);
ALTER TABLE pagamenti ADD CONSTRAINT fk_id_singolo_versamento FOREIGN KEY (id_singolo_versamento) REFERENCES singoli_versamenti(id);
ALTER TABLE pagamenti ADD CONSTRAINT fk_id_rr FOREIGN KEY (id_rr) REFERENCES rr(id);
ALTER TABLE pagamenti ADD CONSTRAINT fk_id_incasso FOREIGN KEY (id_incasso) REFERENCES incassi(id);

ALTER TABLE rendicontazioni ADD CONSTRAINT fk_id_fr FOREIGN KEY (id_fr) REFERENCES fr(id);
ALTER TABLE rendicontazioni ADD CONSTRAINT fk_id_pagamento FOREIGN KEY (id_pagamento) REFERENCES pagamenti(id);

ALTER TABLE tracciati ADD CONSTRAINT fk_id_operatore FOREIGN KEY (id_operatore) REFERENCES operatori(id);
ALTER TABLE tracciati ADD CONSTRAINT fk_id_applicazione FOREIGN KEY (id_applicazione) REFERENCES applicazioni(id);

ALTER TABLE operazioni ADD CONSTRAINT fk_id_tracciato FOREIGN KEY (id_tracciato) REFERENCES tracciati(id);
ALTER TABLE operazioni ADD CONSTRAINT fk_id_applicazione FOREIGN KEY (id_applicazione) REFERENCES applicazioni(id);

ALTER TABLE gp_audit ADD CONSTRAINT fk_id_operatore FOREIGN KEY (id_operatore) REFERENCES operatori(id);

CREATE INDEX index_rpt_stato ON rpt (stato);
CREATE INDEX index_rpt_id_versamento ON rpt (id_versamento);
