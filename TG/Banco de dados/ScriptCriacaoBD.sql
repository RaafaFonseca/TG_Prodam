create database fornecedores;
use fornecedores;


CREATE TABLE colaboradores (
    col_id          INTEGER(6) NOT NULL,
    col_dt_cadastro TIMESTAMP NOT NULL,
    col_rf          VARCHAR(10) NOT NULL,
    col_nome        VARCHAR(50) NOT NULL,
    col_img_id      INTEGER(6) NOT NULL,
    col_tac_id      INTEGER(6) NOT NULL,
    col_tco_id      INTEGER(6) NOT NULL,
    col_tct_id      INTEGER(6) NOT NULL,
    col_pre_id      INTEGER(6) NOT NULL,
    col_dir_id      INTEGER(6) NOT NULL,
    col_ger_id      INTEGER(6) NOT NULL,
    col_nuc_id      INTEGER(6) NOT NULL
);

CREATE TABLE colaboradores_equipamentos (
    ceq_id                  INTEGER(6) NOT NULL,
    ceq_eqp_id              INTEGER(6) NOT NULL,
    ceq_dt_disponibilizacao DATE NOT NULL,
    ceq_dt_devolucao        DATE,
    ceq_col_id              INTEGER(6) NOT NULL,
    ceq_vigente             CHAR(1) NOT NULL,
    ceq_finalidade          VARCHAR(100),
    ceq_respentrega         VARCHAR (100) NOT NULL
);

CREATE TABLE contratos_comodato (
    ccm_id              INTEGER(6) NOT NULL,
    ccm_dt_cadastro     TIMESTAMP NOT NULL,
    ccm_caminho_arquivo VARCHAR(300) NOT NULL,
    ccm_col_id          INTEGER(6) NOT NULL,
    ccm_stt_id          INTEGER(6) NOT NULL
);

CREATE TABLE contratos_impressora (
    coi_id          INTEGER(6) NOT NULL,
    coi_dt_cadastro TIMESTAMP NOT NULL,
    coi_fornecedor  VARCHAR(50) NOT NULL,
    coi_dt_inicio   DATE NOT NULL,
    coi_dt_termino  DATE NOT NULL
);

CREATE TABLE diretorias (
    dir_id                 INTEGER(6) NOT NULL,
    dir_dt_cadastro        TIMESTAMP NOT NULL,
    dir_descricao          VARCHAR(80) NOT NULL,
    dir_sigla              VARCHAR(10) NOT NULL,
    dir_responsavel_col_id INTEGER(6) NOT NULL,
    dir_pre_id             INTEGER(6) NOT NULL
);

CREATE TABLE equipamentos (
    eqp_id             INTEGER(6) NOT NULL,
    eqp_dt_cadastro    TIMESTAMP NOT NULL,
    eqp_patrimonio     INTEGER(6),
    eqp_serial         VARCHAR(50),
    eqp_observacao     VARCHAR(100),
    eqp_loc_presencial CHAR(1) NOT NULL,
    eqp_compartilhado  CHAR(1) NOT NULL,
    eqp_loc_id         INTEGER(6) NOT NULL,
    eqp_nof_id         INTEGER(6) NOT NULL,
    eqp_teq_id         INTEGER(6) NOT NULL
);

CREATE TABLE gerencias (
    ger_id                 INTEGER(6) NOT NULL,
    ger_dt_cadastro        TIMESTAMP NOT NULL,
    ger_descricao          VARCHAR(80) NOT NULL,
    ger_sigla              VARCHAR(10) NOT NULL,
    ger_responsavel_col_id INTEGER(6) NOT NULL,
    ger_dir_id             INTEGER(6) NOT NULL,
    ger_pre_id             INTEGER(6) NOT NULL
);

CREATE TABLE imagens (
    img_id          INTEGER(6) NOT NULL,
    img_dt_cadastro TIMESTAMP NOT NULL,
    img_descricao   VARCHAR(50) NOT NULL
);

CREATE TABLE imagens_programas (
    ipr_id     INTEGER(6) NOT NULL,
    ipr_prg_id INTEGER(6) NOT NULL,
    ipr_img_id INTEGER(6) NOT NULL
);

CREATE TABLE impressoras (
    imp_id          INTEGER(6) NOT NULL,
    imp_dt_cadastro TIMESTAMP NOT NULL,
    imp_marca       VARCHAR(30) NOT NULL,
    imp_modelo      VARCHAR(30) NOT NULL,
    imp_serial      VARCHAR(50) NOT NULL,
    imp_coi_id      INTEGER(6) NOT NULL,
    imp_loc_id      INTEGER(6) NOT NULL
);

CREATE TABLE localizacoes (
    loc_id          INTEGER(6) NOT NULL,
    loc_dt_cadastro TIMESTAMP NOT NULL,
    loc_predio      VARCHAR(20) NOT NULL,
    loc_andar       INTEGER(2) NOT NULL,
    loc_lado        VARCHAR(15),
    loc_referencia  VARCHAR(30)
);

CREATE TABLE notas_fiscais (
    nof_id          INTEGER(6) NOT NULL,
    nof_dt_cadastro TIMESTAMP NOT NULL,
    nof_numero      VARCHAR(20) NOT NULL,
    nof_dt          DATE NOT NULL
);

CREATE TABLE nucleos (
    nuc_id                 INTEGER(6) NOT NULL,
    nuc_dt_cadastro        TIMESTAMP NOT NULL,
    nuc_descricao          VARCHAR(80) NOT NULL,
    nuc_sigla              VARCHAR(10) NOT NULL,
    nuc_responsavel_col_id INTEGER(6) NOT NULL,
    nuc_ger_id             INTEGER(6) NOT NULL
);

CREATE TABLE ocorrencias (
    oco_id          INTEGER(6) NOT NULL,
    oco_dt_cadastro TIMESTAMP NOT NULL,
    oco_os          VARCHAR(20) NOT NULL,
    oco_descricao   VARCHAR(150) NOT NULL,
    oco_eqp_id      INTEGER(6) NOT NULL,
    oco_col_id      INTEGER(6) NOT NULL
);

CREATE TABLE presidencias (
    pre_id                 INTEGER(6) NOT NULL,
    pre_dt_cadastro        TIMESTAMP NOT NULL,
    pre_descricao          VARCHAR(80) NOT NULL,
    pre_sigla              VARCHAR(10) NOT NULL,
    pre_responsavel_col_id INTEGER(6) NOT NULL
);

CREATE TABLE programas (
    prg_id          INTEGER(6) NOT NULL,
    prg_dt_cadastro TIMESTAMP NOT NULL,
    prg_descricao   VARCHAR(20) NOT NULL,
    prg_licenca     VARCHAR(20) NOT NULL,
    prg_obervacao   VARCHAR(200),
    prg_tlc_id      INTEGER(6) NOT NULL
);

CREATE TABLE estatus (
    stt_id        INTEGER(6) NOT NULL,
    stt_descricao VARCHAR(20) NOT NULL
);

CREATE TABLE tipos_acesso (
    tac_id        INTEGER(6) NOT NULL,
    tac_descricao VARCHAR(20) NOT NULL
);

CREATE TABLE tipos_colaborador (
    tco_id        INTEGER(6) NOT NULL,
    tco_descricao VARCHAR(20) NOT NULL
);

CREATE TABLE tipos_contratos (
    tct_id        INTEGER(6) NOT NULL,
    tct_descricao VARCHAR(20) NOT NULL
);

CREATE TABLE tipos_equipamento (
    teq_id          INTEGER(6) NOT NULL,
    teq_dt_cadastro TIMESTAMP NOT NULL,
    teq_descricao   VARCHAR(50) NOT NULL,
    teq_marca       VARCHAR(50),
    teq_modelo      VARCHAR(50),
    teq_fornecedor  VARCHAR(50),
    teq_polegadas   VARCHAR(3)
);

CREATE TABLE tipos_licenca (
    tlc_id          INTEGER(6) NOT NULL,
    tlc_dt_cadastro TIMESTAMP NOT NULL,
    tlc_descricao   VARCHAR(30) NOT NULL
);

CREATE TABLE usuarios (
    usu_id          INTEGER(6) NOT NULL,
    usu_dt_cadastro TIMESTAMP NOT NULL,
    usu_login       VARCHAR(20) NOT NULL,
    usu_senha       VARCHAR(20) NOT NULL,
    usu_col_id      INTEGER(6) NOT NULL
);

/* Chaves Primárias */
ALTER TABLE colaboradores              ADD CONSTRAINT pk_col       PRIMARY KEY ( col_id );
ALTER TABLE colaboradores_equipamentos ADD CONSTRAINT pk_ceq       PRIMARY KEY ( ceq_id );
ALTER TABLE contratos_comodato         ADD CONSTRAINT pk_ccm       PRIMARY KEY ( ccm_id );
ALTER TABLE contratos_impressora       ADD CONSTRAINT pk_coi       PRIMARY KEY ( coi_id );
ALTER TABLE diretorias                 ADD CONSTRAINT pk_dir       PRIMARY KEY ( dir_id );
ALTER TABLE equipamentos               ADD CONSTRAINT pk_eqp       PRIMARY KEY ( eqp_id );
ALTER TABLE gerencias                  ADD CONSTRAINT pk_ger       PRIMARY KEY ( ger_id );
ALTER TABLE imagens                    ADD CONSTRAINT pk_img       PRIMARY KEY ( img_id );
ALTER TABLE imagens_programas          ADD CONSTRAINT pk_ipr       PRIMARY KEY ( ipr_id );
ALTER TABLE impressoras                ADD CONSTRAINT pk_imp       PRIMARY KEY ( imp_id );
ALTER TABLE localizacoes               ADD CONSTRAINT pk_loc       PRIMARY KEY ( loc_id );
ALTER TABLE notas_fiscais              ADD CONSTRAINT pk_nof       PRIMARY KEY ( nof_id );
ALTER TABLE nucleos                    ADD CONSTRAINT pk_nuc       PRIMARY KEY ( nuc_id );
ALTER TABLE ocorrencias                ADD CONSTRAINT pk_oco       PRIMARY KEY ( oco_id );
ALTER TABLE presidencias               ADD CONSTRAINT pk_pre       PRIMARY KEY ( pre_id );
ALTER TABLE programas                  ADD CONSTRAINT pk_prg       PRIMARY KEY ( prg_id );
ALTER TABLE estatus                    ADD CONSTRAINT pk_stt       PRIMARY KEY ( stt_id );
ALTER TABLE tipos_acesso               ADD CONSTRAINT pk_tac       PRIMARY KEY ( tac_id );
ALTER TABLE tipos_colaborador          ADD CONSTRAINT pk_tco       PRIMARY KEY ( tco_id );
ALTER TABLE tipos_contratos            ADD CONSTRAINT pk_tct       PRIMARY KEY ( tct_id );
ALTER TABLE tipos_equipamento          ADD CONSTRAINT pk_teq       PRIMARY KEY ( teq_id );
ALTER TABLE tipos_licenca              ADD CONSTRAINT pk_tlc       PRIMARY KEY ( tlc_id );
ALTER TABLE usuarios                   ADD CONSTRAINT pk_usu       PRIMARY KEY ( usu_id );

/* Chaves Estrangeiras */
ALTER TABLE contratos_comodato         ADD CONSTRAINT fk_ccm_col FOREIGN KEY ( ccm_col_id )             REFERENCES colaboradores ( col_id );
ALTER TABLE contratos_comodato         ADD CONSTRAINT fk_ccm_stt FOREIGN KEY ( ccm_stt_id )             REFERENCES estatus ( stt_id );
ALTER TABLE colaboradores_equipamentos ADD CONSTRAINT fk_ceq_col FOREIGN KEY ( ceq_col_id )             REFERENCES colaboradores ( col_id );
ALTER TABLE colaboradores_equipamentos ADD CONSTRAINT fk_ceq_eqp FOREIGN KEY ( ceq_eqp_id )             REFERENCES equipamentos ( eqp_id );
ALTER TABLE colaboradores              ADD CONSTRAINT fk_col_dir FOREIGN KEY ( col_dir_id )             REFERENCES diretorias ( dir_id );
ALTER TABLE colaboradores              ADD CONSTRAINT fk_col_ger FOREIGN KEY ( col_ger_id )             REFERENCES gerencias ( ger_id );
ALTER TABLE colaboradores              ADD CONSTRAINT fk_col_img FOREIGN KEY ( col_img_id )             REFERENCES imagens ( img_id );
ALTER TABLE colaboradores              ADD CONSTRAINT fk_col_nuc FOREIGN KEY ( col_nuc_id )             REFERENCES nucleos ( nuc_id );
ALTER TABLE colaboradores              ADD CONSTRAINT fk_col_pre FOREIGN KEY ( col_pre_id )             REFERENCES presidencias ( pre_id );
ALTER TABLE colaboradores              ADD CONSTRAINT fk_col_tac FOREIGN KEY ( col_tac_id )             REFERENCES tipos_acesso ( tac_id );
ALTER TABLE colaboradores              ADD CONSTRAINT fk_col_tco FOREIGN KEY ( col_tco_id )             REFERENCES tipos_colaborador ( tco_id );
ALTER TABLE colaboradores              ADD CONSTRAINT fk_col_tct FOREIGN KEY ( col_tct_id )             REFERENCES tipos_contratos ( tct_id );
ALTER TABLE diretorias                 ADD CONSTRAINT fk_dir_col FOREIGN KEY ( dir_responsavel_col_id ) REFERENCES colaboradores ( col_id );
ALTER TABLE diretorias                 ADD CONSTRAINT fk_dir_pre FOREIGN KEY ( dir_pre_id )             REFERENCES presidencias ( pre_id );
ALTER TABLE equipamentos               ADD CONSTRAINT fk_eqp_loc FOREIGN KEY ( eqp_loc_id )             REFERENCES localizacoes ( loc_id );
ALTER TABLE equipamentos               ADD CONSTRAINT fk_eqp_nof FOREIGN KEY ( eqp_nof_id )             REFERENCES notas_fiscais ( nof_id );
ALTER TABLE equipamentos               ADD CONSTRAINT fk_eqp_teq FOREIGN KEY ( eqp_teq_id )             REFERENCES tipos_equipamento ( teq_id );
ALTER TABLE gerencias                  ADD CONSTRAINT fk_ger_col FOREIGN KEY ( ger_responsavel_col_id ) REFERENCES colaboradores ( col_id );
ALTER TABLE gerencias                  ADD CONSTRAINT fk_ger_dir FOREIGN KEY ( ger_dir_id )             REFERENCES diretorias ( dir_id );
ALTER TABLE gerencias                  ADD CONSTRAINT fk_ger_pre FOREIGN KEY ( ger_pre_id )             REFERENCES presidencias ( pre_id );
ALTER TABLE impressoras                ADD CONSTRAINT fk_imp_coi FOREIGN KEY ( imp_coi_id )             REFERENCES contratos_impressora ( coi_id );
ALTER TABLE impressoras                ADD CONSTRAINT fk_imp_loc FOREIGN KEY ( imp_loc_id )             REFERENCES localizacoes ( loc_id );
ALTER TABLE imagens_programas          ADD CONSTRAINT fk_ipr_img FOREIGN KEY ( ipr_img_id )             REFERENCES imagens ( img_id );
ALTER TABLE imagens_programas          ADD CONSTRAINT fk_ipr_prg FOREIGN KEY ( ipr_prg_id )             REFERENCES programas ( prg_id );
ALTER TABLE nucleos                    ADD CONSTRAINT fk_nuc_col FOREIGN KEY ( nuc_responsavel_col_id ) REFERENCES colaboradores ( col_id );
ALTER TABLE nucleos                    ADD CONSTRAINT fk_nuc_ger FOREIGN KEY ( nuc_ger_id )             REFERENCES gerencias ( ger_id );
ALTER TABLE ocorrencias                ADD CONSTRAINT fk_oco_col FOREIGN KEY ( oco_col_id )             REFERENCES colaboradores ( col_id );
ALTER TABLE ocorrencias                ADD CONSTRAINT fk_oco_eqp FOREIGN KEY ( oco_eqp_id )             REFERENCES equipamentos ( eqp_id );
ALTER TABLE presidencias               ADD CONSTRAINT fk_pre_col FOREIGN KEY ( pre_responsavel_col_id ) REFERENCES colaboradores ( col_id );
ALTER TABLE programas                  ADD CONSTRAINT fk_prg_tlc FOREIGN KEY ( prg_tlc_id )             REFERENCES tipos_licenca ( tlc_id );
ALTER TABLE usuarios                   ADD CONSTRAINT fk_usu_col FOREIGN KEY ( usu_col_id )             REFERENCES colaboradores ( col_id );


