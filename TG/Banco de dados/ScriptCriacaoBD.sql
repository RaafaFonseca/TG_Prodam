create database prodam;
use prodam;

CREATE TABLE colaboradores (
    col_id          INTEGER(6),
    col_dt_cadastro TIMESTAMP,
    col_rf          VARCHAR(10),
    col_nome        VARCHAR(50),
    col_img_id      INTEGER(6),
    col_tac_id      INTEGER(6),
    col_tco_id      INTEGER(6),
    col_tct_id      INTEGER(6),
    col_pre_id      INTEGER(6),
    col_dir_id      INTEGER(6),
    col_ger_id      INTEGER(6),
    col_nuc_id      INTEGER(6)
);

CREATE TABLE colaboradores_equipamentos (
    ceq_id                  INTEGER(6),
    ceq_eqp_id              INTEGER(6),
    ceq_dt_disponibilizacao DATE,
    ceq_dt_devolucao        DATE,
    ceq_col_id              INTEGER(6),
    ceq_vigente             CHAR(1),
    ceq_finalidade          VARCHAR(100),
    ceq_resp_entrega         VARCHAR (100) 
);

CREATE TABLE contratos_comodato (
    ccm_id              INTEGER(6),
    ccm_dt_cadastro     TIMESTAMP,
    ccm_caminho_arquivo VARCHAR(300),
    ccm_col_id          INTEGER(6),
    ccm_stt_id          INTEGER(6)
);

CREATE TABLE contrato_equipamento_terceiros(
	cet_id  INTEGER(6),
    cet_fornecedor VARCHAR(50),
    cet_dt_inicio DATE,
    cet_dt_termino DATE
);
CREATE TABLE diretorias (
    dir_id                 INTEGER(6),
    dir_dt_cadastro        TIMESTAMP,
    dir_descricao          VARCHAR(80),
    dir_sigla              VARCHAR(10),
    dir_responsavel_col_id INTEGER(6),
    dir_pre_id             INTEGER(6)
);

CREATE TABLE equipamentos (
    eqp_id             INTEGER(6),
    eqp_dt_cadastro    TIMESTAMP,
    eqp_patrimonio     INTEGER(6),
    eqp_serial         VARCHAR(50),
    eqp_observacao     VARCHAR(100),
    eqp_loc_presencial CHAR(1),
    eqp_compartilhado  CHAR(1),
    eqp_loc_id         INTEGER(6),
    eqp_nof_id         INTEGER(6),
    eqp_teq_id         INTEGER(6),
	eqp_cet_id 		   INTEGER(6)
);

CREATE TABLE gerencias (
    ger_id                 INTEGER(6),
    ger_dt_cadastro        TIMESTAMP,
    ger_descricao          VARCHAR(80),
    ger_sigla              VARCHAR(10),
    ger_responsavel_col_id INTEGER(6),
    ger_dir_id             INTEGER(6),
    ger_pre_id             INTEGER(6)
);

CREATE TABLE imagens (
    img_id          INTEGER(6),
    img_dt_cadastro TIMESTAMP,
    img_descricao   VARCHAR(50) 
);
CREATE TABLE imagens_programas (
    ipr_id     INTEGER(6),
    ipr_prg_id INTEGER(6),
    ipr_img_id INTEGER(6)
);
CREATE TABLE localizacoes (
    loc_id          INTEGER(6),
    loc_dt_cadastro TIMESTAMP,
    loc_predio      VARCHAR(20),
    loc_andar       INTEGER(2),
    loc_lado        VARCHAR(15),
    loc_referencia  VARCHAR(30)
);

CREATE TABLE notas_fiscais (
    nof_id          INTEGER(6),
    nof_dt_cadastro TIMESTAMP,
    nof_numero      VARCHAR(20),
    nof_dt          DATE 
);

CREATE TABLE nucleos (
    nuc_id                 INTEGER(6),
    nuc_dt_cadastro        TIMESTAMP,
    nuc_descricao          VARCHAR(80),
    nuc_sigla              VARCHAR(10),
    nuc_responsavel_col_id INTEGER(6),
    nuc_ger_id             INTEGER(6)
);

CREATE TABLE ocorrencias (
    oco_id          INTEGER(6),
    oco_dt_cadastro TIMESTAMP,
    oco_os          VARCHAR(20),
    oco_descricao   VARCHAR(150),
    oco_eqp_id      INTEGER(6),
    oco_col_id      INTEGER(6)
);

CREATE TABLE presidencias (
    pre_id                 INTEGER(6),
    pre_dt_cadastro        TIMESTAMP,
    pre_descricao          VARCHAR(80),
    pre_sigla              VARCHAR(10),
    pre_responsavel_col_id INTEGER(6)
);

CREATE TABLE programas (
    prg_id          INTEGER(6),
    prg_dt_cadastro TIMESTAMP,
    prg_descricao   VARCHAR(20),
    prg_licenca     VARCHAR(20),
    prg_obervacao   VARCHAR(200),
    prg_tlc_id      INTEGER(6) 
);

CREATE TABLE estatus (
    stt_id        INTEGER(6),
    stt_descricao VARCHAR(20) 
);

CREATE TABLE tipos_acesso (
    tac_id        INTEGER(6),
    tac_descricao VARCHAR(20) 
);

CREATE TABLE tipos_colaborador (
    tco_id        INTEGER(6),
    tco_descricao VARCHAR(20) 
);

CREATE TABLE tipos_contratos (
    tct_id        INTEGER(6),
    tct_descricao VARCHAR(20) 
);

CREATE TABLE tipos_equipamento (
    teq_id          INTEGER(6),
    teq_dt_cadastro TIMESTAMP,
    teq_descricao   VARCHAR(50),
    teq_marca       VARCHAR(50),
    teq_modelo      VARCHAR(50),
    teq_fornecedor  VARCHAR(50),
    teq_polegadas   VARCHAR(3)
);

CREATE TABLE tipos_licenca (
    tlc_id          INTEGER(6),
    tlc_dt_cadastro TIMESTAMP,
    tlc_descricao   VARCHAR(30) 
);

CREATE TABLE usuarios (
    usu_id          INTEGER(6),
    usu_dt_cadastro TIMESTAMP,
    usu_login       VARCHAR(20),
    usu_senha       VARCHAR(20),
    usu_col_id      INTEGER(6)
);

/* Chaves Primárias */
ALTER TABLE colaboradores                    ADD CONSTRAINT pk_col       PRIMARY KEY ( col_id );
ALTER TABLE colaboradores_equipamentos       ADD CONSTRAINT pk_ceq       PRIMARY KEY ( ceq_id );
ALTER TABLE contratos_comodato               ADD CONSTRAINT pk_ccm       PRIMARY KEY ( ccm_id );
ALTER TABLE contrato_equipamento_terceiros   ADD CONSTRAINT pk_cet       PRIMARY KEY ( cet_id );
ALTER TABLE diretorias                       ADD CONSTRAINT pk_dir       PRIMARY KEY ( dir_id );
ALTER TABLE equipamentos                     ADD CONSTRAINT pk_eqp       PRIMARY KEY ( eqp_id );
ALTER TABLE gerencias                        ADD CONSTRAINT pk_ger       PRIMARY KEY ( ger_id );
ALTER TABLE imagens                          ADD CONSTRAINT pk_img       PRIMARY KEY ( img_id );
ALTER TABLE imagens_programas                ADD CONSTRAINT pk_ipr       PRIMARY KEY ( ipr_id );
ALTER TABLE localizacoes                     ADD CONSTRAINT pk_loc       PRIMARY KEY ( loc_id );
ALTER TABLE notas_fiscais                    ADD CONSTRAINT pk_nof       PRIMARY KEY ( nof_id );
ALTER TABLE nucleos                          ADD CONSTRAINT pk_nuc       PRIMARY KEY ( nuc_id );
ALTER TABLE ocorrencias                      ADD CONSTRAINT pk_oco       PRIMARY KEY ( oco_id );
ALTER TABLE presidencias                     ADD CONSTRAINT pk_pre       PRIMARY KEY ( pre_id );
ALTER TABLE programas                        ADD CONSTRAINT pk_prg       PRIMARY KEY ( prg_id );
ALTER TABLE estatus                          ADD CONSTRAINT pk_stt       PRIMARY KEY ( stt_id );
ALTER TABLE tipos_acesso                     ADD CONSTRAINT pk_tac       PRIMARY KEY ( tac_id );
ALTER TABLE tipos_colaborador                ADD CONSTRAINT pk_tco       PRIMARY KEY ( tco_id );
ALTER TABLE tipos_contratos                  ADD CONSTRAINT pk_tct       PRIMARY KEY ( tct_id );
ALTER TABLE tipos_equipamento                ADD CONSTRAINT pk_teq       PRIMARY KEY ( teq_id );
ALTER TABLE tipos_licenca                    ADD CONSTRAINT pk_tlc       PRIMARY KEY ( tlc_id );
ALTER TABLE usuarios                         ADD CONSTRAINT pk_usu       PRIMARY KEY ( usu_id );

--  Not null and Auto_Increment 
ALTER TABLE colaboradores                   	   MODIFY col_dt_cadastro TIMESTAMP           NOT NULL;
ALTER TABLE colaboradores                    	   MODIFY col_rf VARCHAR(10)                  NOT NULL;
ALTER TABLE colaboradores                    	   MODIFY col_nome VARCHAR(50)                NOT NULL;
ALTER TABLE colaboradores_equipamentos             MODIFY ceq_dt_disponibilizacao DATE        NOT NULL;
ALTER TABLE colaboradores_equipamentos             MODIFY ceq_vigente CHAR(1)                 NOT NULL;
ALTER TABLE colaboradores_equipamentos             MODIFY ceq_finalidade VARCHAR(100)         NOT NULL;
ALTER TABLE colaboradores_equipamentos             MODIFY ceq_resp_entrega VARCHAR(100)       NOT NULL;
ALTER TABLE contrato_equipamento_terceiros         MODIFY cet_fornecedor VARCHAR(50)          NOT NULL;
ALTER TABLE contrato_equipamento_terceiros         MODIFY cet_dt_inicio DATE                  NOT NULL;
ALTER TABLE contrato_equipamento_terceiros         MODIFY cet_dt_termino DATE                 NOT NULL;
ALTER TABLE contratos_comodato                     MODIFY ccm_dt_cadastro TIMESTAMP           NOT NULL;
ALTER TABLE contratos_comodato                     MODIFY ccm_caminho_arquivo TIMESTAMP       NOT NULL;
ALTER TABLE diretorias                             MODIFY dir_dt_cadastro TIMESTAMP           NOT NULL;
ALTER TABLE diretorias                             MODIFY dir_descricao VARCHAR(80)           NOT NULL;
ALTER TABLE diretorias                             MODIFY dir_sigla VARCHAR(10)               NOT NULL;
ALTER TABLE equipamentos                           MODIFY eqp_dt_cadastro TIMESTAMP           NOT NULL;
ALTER TABLE equipamentos                           MODIFY eqp_loc_presencial CHAR(1)          NOT NULL;
ALTER TABLE equipamentos                           MODIFY eqp_compartilhado CHAR(1)           NOT NULL;
ALTER TABLE estatus                                MODIFY stt_descricao  VARCHAR(20)          NOT NULL;
ALTER TABLE gerencias                              MODIFY ger_dt_cadastro TIMESTAMP           NOT NULL;
ALTER TABLE gerencias                              MODIFY ger_descricao  VARCHAR(80)          NOT NULL;
ALTER TABLE gerencias                              MODIFY ger_sigla VARCHAR(10)               NOT NULL;
ALTER TABLE imagens                                MODIFY img_dt_cadastro TIMESTAMP           NOT NULL;
ALTER TABLE imagens                                MODIFY img_descricao VARCHAR(50)           NOT NULL;
ALTER TABLE localizacoes                           MODIFY loc_dt_cadastro TIMESTAMP           NOT NULL;
ALTER TABLE localizacoes                           MODIFY loc_predio VARCHAR(20)              NOT NULL;
ALTER TABLE localizacoes                           MODIFY loc_andar INTEGER(2)                NOT NULL;
ALTER TABLE notas_fiscais                          MODIFY nof_dt_cadastro TIMESTAMP           NOT NULL;
ALTER TABLE notas_fiscais                          MODIFY nof_numero VARCHAR(20)              NOT NULL;
ALTER TABLE notas_fiscais                          MODIFY nof_dt DATE                         NOT NULL;
ALTER TABLE nucleos                                MODIFY nuc_dt_cadastro TIMESTAMP           NOT NULL;
ALTER TABLE nucleos                                MODIFY nuc_descricao  VARCHAR(80)          NOT NULL;
ALTER TABLE nucleos                                MODIFY nuc_sigla VARCHAR(10)               NOT NULL;
ALTER TABLE ocorrencias                            MODIFY oco_dt_cadastro TIMESTAMP           NOT NULL;
ALTER TABLE ocorrencias                            MODIFY oco_descricao VARCHAR(150)          NOT NULL;
ALTER TABLE presidencias                           MODIFY pre_dt_cadastro TIMESTAMP           NOT NULL;
ALTER TABLE presidencias                           MODIFY pre_descricao  VARCHAR(80)          NOT NULL;
ALTER TABLE presidencias                           MODIFY pre_sigla VARCHAR(10)               NOT NULL;
ALTER TABLE programas                              MODIFY prg_dt_cadastro TIMESTAMP           NOT NULL;
ALTER TABLE programas                              MODIFY prg_descricao VARCHAR(50)           NOT NULL;
ALTER TABLE tipos_acesso                           MODIFY tac_descricao VARCHAR(20)           NOT NULL;
ALTER TABLE tipos_colaborador                      MODIFY tco_descricao VARCHAR(20)           NOT NULL;
ALTER TABLE tipos_contratos                        MODIFY tct_descricao VARCHAR(20)           NOT NULL;
ALTER TABLE tipos_equipamento                      MODIFY teq_dt_cadastro TIMESTAMP           NOT NULL;
ALTER TABLE tipos_equipamento                      MODIFY teq_descricao VARCHAR(50)           NOT NULL;
ALTER TABLE tipos_equipamento                      MODIFY teq_marca VARCHAR(50)               NOT NULL;
ALTER TABLE tipos_equipamento                      MODIFY teq_modelo VARCHAR(50)              NOT NULL;
ALTER TABLE tipos_equipamento                      MODIFY teq_fornecedor VARCHAR(50)          NOT NULL;
ALTER TABLE tipos_licenca                          MODIFY tlc_descricao VARCHAR(20)           NOT NULL;
ALTER TABLE usuarios                               MODIFY usu_dt_cadastro TIMESTAMP           NOT NULL;
ALTER TABLE usuarios                               MODIFY usu_login VARCHAR(20)               NOT NULL;
ALTER TABLE usuarios                               MODIFY usu_senha VARCHAR(20)               NOT NULL;

ALTER TABLE colaboradores                          MODIFY col_id INTEGER(6)     NOT NULL AUTO_INCREMENT;
ALTER TABLE colaboradores_equipamentos             MODIFY ceq_id INTEGER(6)     NOT NULL AUTO_INCREMENT;
ALTER TABLE contrato_equipamento_terceiros         MODIFY cet_id INTEGER(6)     NOT NULL AUTO_INCREMENT;
ALTER TABLE contratos_comodato                     MODIFY ccm_id INTEGER(6)     NOT NULL AUTO_INCREMENT;
ALTER TABLE diretorias                             MODIFY dir_id INTEGER(6)     NOT NULL AUTO_INCREMENT;
ALTER TABLE equipamentos                           MODIFY eqp_id INTEGER(6)     NOT NULL AUTO_INCREMENT;
ALTER TABLE estatus                                MODIFY stt_id INTEGER(6)     NOT NULL AUTO_INCREMENT;
ALTER TABLE gerencias                              MODIFY ger_id INTEGER(6)     NOT NULL AUTO_INCREMENT;
ALTER TABLE imagens                                MODIFY img_id INTEGER(6)     NOT NULL AUTO_INCREMENT;
ALTER TABLE imagens_programas                      MODIFY ipr_id INTEGER(6)     NOT NULL AUTO_INCREMENT;
ALTER TABLE localizacoes                           MODIFY loc_id INTEGER(6)     NOT NULL AUTO_INCREMENT;
ALTER TABLE notas_fiscais                          MODIFY nof_id INTEGER(6)     NOT NULL AUTO_INCREMENT;
ALTER TABLE nucleos                                MODIFY nuc_id INTEGER(6)     NOT NULL AUTO_INCREMENT;
ALTER TABLE ocorrencias                            MODIFY oco_id INTEGER(6)     NOT NULL AUTO_INCREMENT;
ALTER TABLE presidencias                           MODIFY pre_id INTEGER(6)     NOT NULL AUTO_INCREMENT;
ALTER TABLE programas                              MODIFY prg_id INTEGER(6)     NOT NULL AUTO_INCREMENT;
ALTER TABLE tipos_acesso                           MODIFY tac_id INTEGER(6)     NOT NULL AUTO_INCREMENT;
ALTER TABLE tipos_colaborador                      MODIFY tco_id INTEGER(6)     NOT NULL AUTO_INCREMENT;
ALTER TABLE tipos_contratos                        MODIFY tct_id INTEGER(6)     NOT NULL AUTO_INCREMENT;
ALTER TABLE tipos_equipamento                      MODIFY teq_id INTEGER(6)     NOT NULL AUTO_INCREMENT;
ALTER TABLE tipos_licenca                          MODIFY tlc_id INTEGER(6)     NOT NULL AUTO_INCREMENT;
ALTER TABLE usuarios                               MODIFY usu_id INTEGER(6)     NOT NULL AUTO_INCREMENT;

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
ALTER TABLE equipamentos               ADD CONSTRAINT fk_eqp_cet FOREIGN KEY ( eqp_cet_id )             REFERENCES contrato_equipamento_terceiros ( cet_id );
ALTER TABLE gerencias                  ADD CONSTRAINT fk_ger_col FOREIGN KEY ( ger_responsavel_col_id ) REFERENCES colaboradores ( col_id );
ALTER TABLE gerencias                  ADD CONSTRAINT fk_ger_dir FOREIGN KEY ( ger_dir_id )             REFERENCES diretorias ( dir_id );
ALTER TABLE gerencias                  ADD CONSTRAINT fk_ger_pre FOREIGN KEY ( ger_pre_id )             REFERENCES presidencias ( pre_id );
ALTER TABLE imagens_programas          ADD CONSTRAINT fk_ipr_img FOREIGN KEY ( ipr_img_id )             REFERENCES imagens ( img_id );
ALTER TABLE imagens_programas          ADD CONSTRAINT fk_ipr_prg FOREIGN KEY ( ipr_prg_id )             REFERENCES programas ( prg_id );
ALTER TABLE nucleos                    ADD CONSTRAINT fk_nuc_col FOREIGN KEY ( nuc_responsavel_col_id ) REFERENCES colaboradores ( col_id );
ALTER TABLE nucleos                    ADD CONSTRAINT fk_nuc_ger FOREIGN KEY ( nuc_ger_id )             REFERENCES gerencias ( ger_id );
ALTER TABLE ocorrencias                ADD CONSTRAINT fk_oco_col FOREIGN KEY ( oco_col_id )             REFERENCES colaboradores ( col_id );
ALTER TABLE ocorrencias                ADD CONSTRAINT fk_oco_eqp FOREIGN KEY ( oco_eqp_id )             REFERENCES equipamentos ( eqp_id );
ALTER TABLE presidencias               ADD CONSTRAINT fk_pre_col FOREIGN KEY ( pre_responsavel_col_id ) REFERENCES colaboradores ( col_id );
ALTER TABLE programas                  ADD CONSTRAINT fk_prg_tlc FOREIGN KEY ( prg_tlc_id )             REFERENCES tipos_licenca ( tlc_id );
ALTER TABLE usuarios                   ADD CONSTRAINT fk_usu_col FOREIGN KEY ( usu_col_id )             REFERENCES colaboradores ( col_id );


