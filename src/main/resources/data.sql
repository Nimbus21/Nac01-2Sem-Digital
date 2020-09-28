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

 INSERT INTO TB_MONITORAMENTO (cd_monitoramento, st_monitoramento, ds_monitoramento, dt_fim, nr_frequencia_segundos, dt_inicio, cd_hospital, cd_medico, cd_paciente) VALUES
 (SQ_MONITORAMENTO.nextval, false, 'primeiro monitoramento Thandy', '2021-08-04 21:58:00', 1000, '1021-08-09', 1, 1, 1);
 
  INSERT INTO TB_MONITORAMENTO (cd_monitoramento, st_monitoramento, ds_monitoramento, dt_fim, nr_frequencia_segundos, dt_inicio, cd_hospital, cd_medico, cd_paciente) VALUES
 (SQ_MONITORAMENTO.nextval, false, 'segundo monitoramento Thandy', '2021-10-04 22:11:00', 2000, '1022-08-09', 1, 1, 1);
 
  INSERT INTO TB_MONITORAMENTO (cd_monitoramento, st_monitoramento, ds_monitoramento, dt_fim, nr_frequencia_segundos, dt_inicio, cd_hospital, cd_medico, cd_paciente) VALUES
 (SQ_MONITORAMENTO.nextval, false, 'primeiro monitoramento Gui', '2021-08-04 11:53:00', 3000, '1021-08-09', 1, 1, 2);
 
  INSERT INTO TB_MONITORAMENTO (cd_monitoramento, st_monitoramento, ds_monitoramento, dt_fim, nr_frequencia_segundos, dt_inicio, cd_hospital, cd_medico, cd_paciente) VALUES
 (SQ_MONITORAMENTO.nextval, false, 'segundo monitoramento Gui', '2021-08-04 03:24:19', 4000, '1021-08-09', 1, 1, 2);

 INSERT INTO TB_CAPSULE_WATCH (cd_capsule_watch, nr_batimento, dt_data_hora, nr_imc, nr_pressao, nr_temperatura, cd_monitoramento) VALUES
 (SQ_CAPSULE_WATCH.nextval, 4, '2021-08-04 11:53:00', 8.2, 11.1, 36.2, 1);