package br.com.fiap.capsuledev.domain.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.capsuledev.domain.CapsuleControl;
import br.com.fiap.capsuledev.domain.CapsuleWatch;
import br.com.fiap.capsuledev.domain.Hospital;
import br.com.fiap.capsuledev.domain.Medico;
import br.com.fiap.capsuledev.domain.Monitoramento;
import br.com.fiap.capsuledev.domain.Paciente;

public class MonitoramentoDTO {

	private Long codigo;
	private String descricao;
	private Date inicio;
	private Date fim;
	private Boolean ativo;
	private Long frequenciaSegundos;
	private Hospital hospital;
	private List<CapsuleWatch> listaCapsuleWatch;
	private Medico medico;
	private List<CapsuleControl> listaCapsuleControl;
	private Paciente paciente;

	public MonitoramentoDTO(Monitoramento monitoramento) {
		this.codigo = monitoramento.getCodigo();
		this.descricao = monitoramento.getDescricao();
		this.inicio = monitoramento.getInicio();
		this.fim = monitoramento.getFim();
		this.ativo = monitoramento.getAtivo();
		this.frequenciaSegundos = monitoramento.getFrequenciaSegundos();
		this.hospital = monitoramento.getHospital();
		this.listaCapsuleWatch = monitoramento.getListaCapsuleWatch();
		this.medico = monitoramento.getMedico();
		this.listaCapsuleControl = monitoramento.getListaCapsuleControl();
		this.paciente = monitoramento.getPaciente();
	}

	public Long getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public Date getInicio() {
		return inicio;
	}

	public Date getFim() {
		return fim;
	}
	
	public Boolean getAtivo() {
		return ativo;
	}

	public Long getFrequenciaSegundos() {
		return frequenciaSegundos;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public List<CapsuleWatch> getListaCapsuleWatch() {
		return listaCapsuleWatch;
	}

	public Medico getMedico() {
		return medico;
	}

	public List<CapsuleControl> getListaCapsuleControl() {
		return listaCapsuleControl;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public static List<MonitoramentoDTO> converter(List<Monitoramento> monitoramentos) {
		return monitoramentos.stream().map(MonitoramentoDTO::new).collect(Collectors.toList());
	}
}
