--CREATE DATABASE prodam;
--USE prodam;

--TABLES
CREATE TABLE IF NOT EXISTS colaborador (	
	col_id SERIAL,
	col_datacadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	col_rf VARCHAR(10),
	col_nome VARCHAR(20),
	pre_col_idpresidencia INTEGER,
	dir_col_iddiretoria INTEGER,
	ger_col_idgerencia INTEGER,
	nuc_col_idnucleo INTEGER,
	col_acessodeadministrador BOOLEAN,
	col_teletrabalho BOOLEAN
);

CREATE TABLE IF NOT EXISTS usuario (
	usu_id SERIAL,
	usu_datacadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	col_usu_idcolaborador INTEGER,
	usu_login VARCHAR(20),
	usu_senha VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS presidencia (
	pre_id SERIAL,
	pre_datacadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	pre_descricao VARCHAR(80),
	pre_sigla VARCHAR(10),
	col_pre_idpresidente INTEGER
);

CREATE TABLE IF NOT EXISTS diretoria (
	dir_id SERIAL,
	dir_datacadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	dir_descricao VARCHAR(80),
	dir_sigla VARCHAR(10),
	col_dir_iddiretor INTEGER,
	pre_dir_idpresidencia INTEGER
);

CREATE TABLE IF NOT EXISTS gerencia (
	ger_id SERIAL,
	ger_datacadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	ger_descricao VARCHAR(80),
	ger_sigla VARCHAR(10),
	pre_ger_idpresidencia INTEGER,
	dir_ger_iddiretoria INTEGER,
	col_ger_idgerente INTEGER
);

CREATE TABLE IF NOT EXISTS nucleo (
	nuc_id SERIAL,
	nuc_datacadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	nuc_descricao VARCHAR(80),
	dir_nuc_iddiretoria INTEGER,
	ger_nuc_idgerencia INTEGER,
	col_nuc_idresponsavel INTEGER
);

CREATE TABLE IF NOT EXISTS contratocolaborador (
	coc_id SERIAL,
	coc_datacadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	coc_caminhoarquivo VARCHAR(150),
	col_coc_idcolaborador INTEGER,
	coc_status BOOLEAN
);

CREATE TABLE IF NOT EXISTS notebook (
	not_id SERIAL,
	not_datacadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	nof_not_idnotafical INTEGER,
	not_patrimonio INTEGER,
	not_marca VARCHAR(30),
	not_modelo VARCHAR(30),
	not_serial VARCHAR(50),
	not_fornecedor VARCHAR(50),
	not_processador VARCHAR(30),
	not_ram VARCHAR(10),
	not_hd VARCHAR(10),
	not_polegadas VARCHAR(5),
	loc_not_idlocalizacao INTEGER,
	not_datarecebimento DATE,
	not_dataentrega DATE
);

CREATE TABLE IF NOT EXISTS desktop (
	des_id SERIAL,
	des_datacadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	nof_des_idnotafical INTEGER,
	des_patrimonio INTEGER,
	des_marca VARCHAR(30),
	des_modelo VARCHAR(30),
	des_serial VARCHAR(50),
	des_fornecedor VARCHAR(50),
	des_processador VARCHAR(30),
	des_ram VARCHAR(10),
	des_hd VARCHAR(10),
	loc_des_idlocalizacao INTEGER,
	des_datarecebimento DATE,
	des_dataentrega DATE
);

CREATE TABLE IF NOT EXISTS monitor (
	mon_id SERIAL,
	mon_datacadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	nof_mon_idnotafical INTEGER,
	mon_patrimonio INTEGER,
	mon_marca VARCHAR(30),
	mon_modelo VARCHAR(30),
	mon_serial VARCHAR(50),
	mon_fornecedor VARCHAR(50),
	mon_polegadas VARCHAR(5),
	loc_mon_idlocalizacao INTEGER,
	mon_datarecebimento DATE,
	mon_dataentrega DATE
);

CREATE TABLE IF NOT EXISTS periferico (
	pef_id SERIAL,
	pef_datacadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	nof_pef_idnotafical INTEGER,
	pef_patrimonio INTEGER,
	pef_marca VARCHAR(30),
	pef_modelo VARCHAR(30),
	pef_serial VARCHAR(50),
	loc_pef_idlocalizacao INTEGER,
	pef_datarecebimento DATE,
	pef_dataentrega DATE
);

CREATE TABLE IF NOT EXISTS kit (
	kit_id SERIAL,
	pef_datacadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	col_kit_idcolaborador INTEGER,
	not_kit_idnotebook INTEGER,
	des_kit_iddesktop INTEGER,
	mon_kit_idmonitor INTEGER,
	pef_kit_idperiferico INTEGER,
	pef_itemadicional VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS ocorrencia (
	oco_id SERIAL,
	oco_datacadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	col_oco_idcolaborador INTEGER,
	oco_os VARCHAR(20),
	oco_descricao VARCHAR(150),
	not_oco_idnotebook INTEGER,
	des_oco_iddesktop INTEGER,
	mon_oco_idmonitor INTEGER,
	pef_oco_idperiferico INTEGER
);

CREATE TABLE IF NOT EXISTS impressora (
	imp_id SERIAL,
	imp_datacadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	imp_marca VARCHAR(30),
	imp_modelo VARCHAR(30),
	imp_serial VARCHAR(50),
	coi_imp_idcontrato INTEGER
);

CREATE TABLE IF NOT EXISTS contratoimpressora (
	coi_id SERIAL,
	coi_datacadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	coi_fornecedor VARCHAR(50),
	coi_datainicio DATE,
	coi_datafinal DATE
);

CREATE TABLE IF NOT EXISTS notafiscal (
	nof_id SERIAL,
	nof_datacadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	nof_numero VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS localizacao (
	loc_id SERIAL,
	loc_datacadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	loc_homeoffice BOOLEAN,
	loc_predio VARCHAR(20),
	loc_andar INTEGER,
	loc_lado VARCHAR(15),
	loc_referencia VARCHAR(30)
);




