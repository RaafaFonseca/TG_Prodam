--FOREIGN KEYS
ALTER TABLE COLABORADOR           ADD CONSTRAINT fk_pre_col_idpresidencia   FOREIGN KEY ( pre_col_idpresidencia )    REFERENCES presidencia ( pre_id );
ALTER TABLE COLABORADOR           ADD CONSTRAINT fk_dir_col_iddiretoria     FOREIGN KEY ( dir_col_iddiretoria )      REFERENCES diretoria ( dir_id );
ALTER TABLE COLABORADOR           ADD CONSTRAINT fk_ger_col_idgerencia      FOREIGN KEY ( ger_col_idgerencia )       REFERENCES gerencia ( ger_id );
ALTER TABLE COLABORADOR           ADD CONSTRAINT fk_nuc_col_idnucleo        FOREIGN KEY ( nuc_col_idnucleo )         REFERENCES nucleo ( nuc_id );

ALTER TABLE USUARIO               ADD CONSTRAINT fk_col_usu_idcolaborador   FOREIGN KEY ( col_usu_idcolaborador )    REFERENCES colaborador ( col_id );

ALTER TABLE PRESIDENCIA           ADD CONSTRAINT fk_col_pre_idpresidente    FOREIGN KEY ( col_pre_idpresidente )     REFERENCES colaborador ( col_id );

ALTER TABLE DIRETORIA             ADD CONSTRAINT fk_pre_dir_idpresidencia   FOREIGN KEY ( pre_dir_idpresidencia )    REFERENCES presidencia ( pre_id );
ALTER TABLE DIRETORIA             ADD CONSTRAINT fk_col_dir_iddiretor       FOREIGN KEY ( col_dir_iddiretor )        REFERENCES colaborador ( col_id );

ALTER TABLE GERENCIA              ADD CONSTRAINT fk_pre_ger_idpresidencia   FOREIGN KEY ( pre_ger_idpresidencia )    REFERENCES presidencia ( pre_id );
ALTER TABLE GERENCIA              ADD CONSTRAINT fk_dir_ger_iddiretoria     FOREIGN KEY ( dir_ger_iddiretoria )      REFERENCES diretoria ( dir_id );
ALTER TABLE GERENCIA              ADD CONSTRAINT fk_col_ger_idgerente       FOREIGN KEY ( col_ger_idgerente )        REFERENCES colaborador ( col_id );

ALTER TABLE NUCLEO                ADD CONSTRAINT fk_ger_nuc_idgerencia      FOREIGN KEY ( ger_nuc_idgerencia )       REFERENCES gerencia ( ger_id );
ALTER TABLE NUCLEO                ADD CONSTRAINT fk_dir_nuc_iddiretoria      FOREIGN KEY ( dir_nuc_iddiretoria )       REFERENCES diretoria ( dir_id );
ALTER TABLE NUCLEO                ADD CONSTRAINT fk_col_nuc_idresponsavel   FOREIGN KEY ( col_nuc_idresponsavel )    REFERENCES colaborador ( col_id );

ALTER TABLE CONTRATOCOLABORADOR   ADD CONSTRAINT fk_col_coc_idcolaborador   FOREIGN KEY ( col_coc_idcolaborador )    REFERENCES colaborador ( col_id );

ALTER TABLE NOTEBOOK              ADD CONSTRAINT fk_nof_not_idnotafical     FOREIGN KEY ( nof_not_idnotafical )      REFERENCES notafiscal ( nof_id );
ALTER TABLE NOTEBOOK              ADD CONSTRAINT fk_loc_not_idlocalizacao   FOREIGN KEY ( loc_not_idlocalizacao )    REFERENCES localizacao ( loc_id );

ALTER TABLE DESKTOP               ADD CONSTRAINT fk_nof_des_idnotafical     FOREIGN KEY ( nof_des_idnotafical )      REFERENCES notafiscal ( nof_id );
ALTER TABLE DESKTOP               ADD CONSTRAINT fk_loc_des_idlocalizacao   FOREIGN KEY ( loc_des_idlocalizacao )    REFERENCES localizacao ( loc_id );

ALTER TABLE MONITOR               ADD CONSTRAINT fk_nof_mon_idnotafical     FOREIGN KEY ( nof_mon_idnotafical )      REFERENCES notafiscal ( nof_id );
ALTER TABLE MONITOR               ADD CONSTRAINT fk_loc_mon_idlocalizacao   FOREIGN KEY ( loc_mon_idlocalizacao )    REFERENCES localizacao ( loc_id );

ALTER TABLE PERIFERICO            ADD CONSTRAINT fk_nof_pef_idnotafical     FOREIGN KEY ( nof_pef_idnotafical )      REFERENCES notafiscal ( nof_id );
ALTER TABLE PERIFERICO            ADD CONSTRAINT fk_loc_pef_idlocalizacao   FOREIGN KEY ( loc_pef_idlocalizacao )    REFERENCES localizacao ( loc_id );

ALTER TABLE KIT                   ADD CONSTRAINT fk_col_kit_idcolaborador   FOREIGN KEY ( col_kit_idcolaborador )    REFERENCES colaborador ( col_id );
ALTER TABLE KIT                   ADD CONSTRAINT fk_not_kit_idnotebook      FOREIGN KEY ( not_kit_idnotebook )       REFERENCES notebook ( not_id );
ALTER TABLE KIT                   ADD CONSTRAINT fk_des_kit_iddesktop       FOREIGN KEY ( des_kit_iddesktop )        REFERENCES desktop ( des_id );
ALTER TABLE KIT                   ADD CONSTRAINT fk_mon_kit_idmonitor       FOREIGN KEY ( mon_kit_idmonitor )        REFERENCES monitor ( mon_id );
ALTER TABLE KIT                   ADD CONSTRAINT fk_pef_kit_idperiferico    FOREIGN KEY ( pef_kit_idperiferico )     REFERENCES periferico ( pef_id );

ALTER TABLE OCORRENCIA            ADD CONSTRAINT fk_col_oco_idcolaborador   FOREIGN KEY ( col_oco_idcolaborador )    REFERENCES colaborador ( col_id );
ALTER TABLE OCORRENCIA            ADD CONSTRAINT fk_not_oco_idnotebook      FOREIGN KEY ( not_oco_idnotebook )       REFERENCES notebook ( not_id );
ALTER TABLE OCORRENCIA            ADD CONSTRAINT fk_des_oco_iddesktop       FOREIGN KEY ( des_oco_iddesktop )        REFERENCES desktop ( des_id );
ALTER TABLE OCORRENCIA            ADD CONSTRAINT fk_mon_oco_idmonitor       FOREIGN KEY ( mon_oco_idmonitor )        REFERENCES monitor ( mon_id );
ALTER TABLE OCORRENCIA            ADD CONSTRAINT fk_pef_oco_idperiferico    FOREIGN KEY ( pef_oco_idperiferico )     REFERENCES periferico ( pef_id );

ALTER TABLE IMPRESSORA            ADD CONSTRAINT fk_coi_imp_idcontrato      FOREIGN KEY ( coi_imp_idcontrato )       REFERENCES contratoimpressora ( coi_id );

