package br.com.fiap.capsuledev.domain.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.capsuledev.domain.Medico;
import br.com.fiap.capsuledev.domain.Monitoramento;

public class MedicoDTO {
	
	private Long codigo;
	private String nome;
	private String crm;
	private List<Monitoramento> monitoramentos;
	
	public MedicoDTO(Medico medico) {
		this.codigo = medico.getCodigo();
		this.nome = medico.getNome();
		this.crm = medico.getCrm();
		this.monitoramentos = medico.getMonitoramentos();
	}
	
	public Long getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCrm() {
		return crm;
	}
	public List<Monitoramento> getMonitoramentos() {
		return monitoramentos;
	}

	public static List<MedicoDTO> converter (List<Medico> medicos) {
		return medicos.stream().map(MedicoDTO::new).collect(Collectors.toList());
	}
}
