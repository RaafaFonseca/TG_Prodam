INSERT INTO PRESIDENCIA(pre_id, pre_datacadastro, pre_descricao, pre_sigla) VALUES(DEFAULT, current_timestamp, 'PRESIDENCIA', 'PRE');
	INSERT INTO GERENCIA(ger_id, ger_datacadastro, ger_descricao, ger_sigla, pre_ger_idpresidencia) VALUES(DEFAULT, current_timestamp, 'Gerência de Ouvidoria', 'GPO', 1);
	INSERT INTO GERENCIA(ger_id, ger_datacadastro, ger_descricao, ger_sigla, pre_ger_idpresidencia) VALUES(DEFAULT, current_timestamp, 'Gerência de Comunicação Institucional', 'GPC', 1);

INSERT INTO PRESIDENCIA(pre_id, pre_datacadastro, pre_descricao, pre_sigla) VALUES(DEFAULT, current_timestamp, 'Conselho de Administração', 'COA');
	INSERT INTO GERENCIA(ger_id, ger_datacadastro, ger_descricao, ger_sigla, pre_ger_idpresidencia) VALUES(DEFAULT, current_timestamp, 'Gerência Ger. de Auditoria Interna', 'GPA', 2);

--DIRETORIAS - GERENCIAS - NUCLEOS
INSERT INTO DIRETORIA(dir_id, dir_datacadastro, dir_descricao, dir_sigla, pre_dir_idpresidencia) VALUES(DEFAULT, current_timestamp, 'Diretoria Jurídica e de Governança Corporativa', 'DJU', 1);
	INSERT INTO GERENCIA(ger_id, ger_datacadastro, ger_descricao, ger_sigla, dir_ger_iddiretoria) VALUES(DEFAULT, current_timestamp, 'Gerência Jurídica - Contencioso', 'GJC', 1);
	INSERT INTO GERENCIA(ger_id, ger_datacadastro, ger_descricao, ger_sigla, dir_ger_iddiretoria) VALUES(DEFAULT, current_timestamp, 'Gerência Ger. Jurídica Administrativo', 'GJA', 1);
	INSERT INTO GERENCIA(ger_id, ger_datacadastro, ger_descricao, ger_sigla, dir_ger_iddiretoria) VALUES(DEFAULT, current_timestamp, 'Gerência Gerência de Gestão de Riscos e Controles Internos', 'GJR', 1);
	INSERT INTO GERENCIA(ger_id, ger_datacadastro, ger_descricao, ger_sigla, dir_ger_iddiretoria) VALUES(DEFAULT, current_timestamp, 'Gerência Ger. de Conformidade', 'GJO', 1);
		INSERT INTO NUCLEO(nuc_id, nuc_datacadastro, nuc_descricao, ger_nuc_idgerencia) VALUES(DEFAULT, current_timestamp, 'PROCESSOS', 4);
		
INSERT INTO DIRETORIA(dir_id, dir_datacadastro, dir_descricao, dir_sigla, pre_dir_idpresidencia) VALUES(DEFAULT, current_timestamp, 'Diretoria de Desenvolvimento e Operações de Sistemas', 'DDO', 1);
	INSERT INTO NUCLEO(nuc_id, nuc_datacadastro, nuc_descricao, nuc_sigla, dir_nuc_iddiretoria) VALUES(DEFAULT, current_timestamp, 'PROCESSOS', 2);
	INSERT INTO GERENCIA(ger_id, ger_datacadastro, ger_descricao, ger_sigla, dir_ger_iddiretoria) VALUES(DEFAULT, current_timestamp, 'Gerência de Desenvolvimento e Operações Saúde', 'GDS', 2);
		INSERT INTO NUCLEO(nuc_id, nuc_datacadastro, nuc_descricao, nuc_sigla, ger_nuc_iddiretoria) VALUES(DEFAULT, current_timestamp, 'Gestão Atenção Básica em Saúde', 5);		
		INSERT INTO NUCLEO(nuc_id, nuc_datacadastro, nuc_descricao, nuc_sigla, ger_nuc_iddiretoria) VALUES(DEFAULT, current_timestamp, 'Gestão Hospitalar', 5);		
		INSERT INTO NUCLEO(nuc_id, nuc_datacadastro, nuc_descricao, nuc_sigla, ger_nuc_iddiretoria) VALUES(DEFAULT, current_timestamp, 'Gestão da Vigilância em Saúde', 5);		
		INSERT INTO NUCLEO(nuc_id, nuc_datacadastro, nuc_descricao, nuc_sigla, ger_nuc_iddiretoria) VALUES(DEFAULT, current_timestamp, 'Desenvolvimento e Inovação de Serviços de Saúde', 5);	
	INSERT INTO GERENCIA(ger_id, ger_datacadastro, ger_descricao, ger_sigla, dir_ger_iddiretoria) VALUES(DEFAULT, current_timestamp, 'Gerência de Desenvolvimento e Operações - Gestão Integrada', 'GDI', 2);		
		INSERT INTO NUCLEO(nuc_id, nuc_datacadastro, nuc_descricao, nuc_sigla, ger_nuc_iddiretoria) VALUES(DEFAULT, current_timestamp, 'Núcleo de Desenvolvimento e Gestão', 6);
	INSERT INTO GERENCIA(ger_id, ger_datacadastro, ger_descricao, ger_sigla, dir_ger_iddiretoria) VALUES(DEFAULT, current_timestamp, 'Gerência de Desenvolvimento e Operações - Gestão Administrativa', 'GDA', 2);		
		INSERT INTO NUCLEO(nuc_id, nuc_datacadastro, nuc_descricao, nuc_sigla, ger_nuc_iddiretoria) VALUES(DEFAULT, current_timestamp, 'Gestão Previdenciária', 7);
		INSERT INTO NUCLEO(nuc_id, nuc_datacadastro, nuc_descricao, nuc_sigla, ger_nuc_iddiretoria) VALUES(DEFAULT, current_timestamp, 'Gestão de Negociação Jurídica Procuradoria', 7);
		INSERT INTO NUCLEO(nuc_id, nuc_datacadastro, nuc_descricao, nuc_sigla, ger_nuc_iddiretoria) VALUES(DEFAULT, current_timestamp, 'Administração', 7);
	INSERT INTO GERENCIA(ger_id, ger_datacadastro, ger_descricao, ger_sigla, dir_ger_iddiretoria) VALUES(DEFAULT, current_timestamp, 'Gerência de Desenvolvimento e Operações - Desenvolvimento Humano', 'GDH', 2);		
		INSERT INTO NUCLEO(nuc_id, nuc_datacadastro, nuc_descricao, nuc_sigla, ger_nuc_iddiretoria) VALUES(DEFAULT, current_timestamp, 'Cidadania', 8);
		INSERT INTO NUCLEO(nuc_id, nuc_datacadastro, nuc_descricao, nuc_sigla, ger_nuc_iddiretoria) VALUES(DEFAULT, current_timestamp, 'Educação - Esportes - Trabalho', 8);
	

	
	
	
INSERT INTO DIRETORIA(dir_id, dir_datacadastro, dir_descricao, dir_sigla, pre_dir_idpresidencia) VALUES(DEFAULT, current_timestamp, 'Diretoria de Infraestrutura e Tecnologia', 'DTI', 1);
INSERT INTO DIRETORIA(dir_id, dir_datacadastro, dir_descricao, dir_sigla, pre_dir_idpresidencia) VALUES(DEFAULT, current_timestamp, 'Diretoria de Administração e Finanças', 'DAF', 1);
INSERT INTO DIRETORIA(dir_id, dir_datacadastro, dir_descricao, dir_sigla, pre_dir_idpresidencia) VALUES(DEFAULT, current_timestamp, 'Diretoria de Participação', 'DIPAR', 1);
INSERT INTO DIRETORIA(dir_id, dir_datacadastro, dir_descricao, dir_sigla, pre_dir_idpresidencia) VALUES(DEFAULT, current_timestamp, 'Diretoria de Inovação e Arquitetura Organizacional', 'DAO', 1);