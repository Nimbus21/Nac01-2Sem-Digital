INSERT INTO TB_HOSPITAL_CLINICA (cd_hospital_clinica, nm_hospital_clinica, nr_cnpj, nr_inscricao_estadual, ds_endereco, nr_telefone) VALUES
  (SQ_HOSPITAL.nextval, 'Sírio Libanês', '1000', '2000', 'Rua y', '11 9888888888');
  
INSERT INTO TB_HOSPITAL_CLINICA (cd_hospital_clinica, nm_hospital_clinica, nr_cnpj, nr_inscricao_estadual, ds_endereco, nr_telefone) VALUES
  (SQ_HOSPITAL.nextval, 'Albert Einstein', '3000', '4000', 'Rua x', '11 999999999');
  
INSERT INTO TB_MEDICO (cd_medico, nr_crm, nm_medico) VALUES (SQ_MEDICO.nextval, '888', 'Hans');

INSERT INTO TB_MEDICO (cd_medico, nr_crm, nm_medico) VALUES (SQ_MEDICO.nextval, '777', 'Chucrute');

INSERT INTO TB_PACIENTE (cd_paciente, nm_contato, ds_endereco, ds_genero, dt_nascimento, nm_paciente, nm_mae, ds_orgao, nr_rg, tl_telefone, dt_transplante) VALUES
 (SQ_PACIENTE.nextval, 'mamãe', 'grande rua', 'masculino', '1997-03-04', 'Thandy', 'Ana', 'pulmao', 'xx34', '9947474', '2020-03-04');
 
 INSERT INTO TB_PACIENTE (cd_paciente, nm_contato, ds_endereco, ds_genero, dt_nascimento, nm_paciente, nm_mae, ds_orgao, nr_rg, tl_telefone, dt_transplante) VALUES
 (SQ_PACIENTE.nextval, 'mamãe', 'grande rua', 'masculino', '1999-03-04', 'Gui', 'guiMae', 'pé', 'xx34', '9947474', '2020-03-04');