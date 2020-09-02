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
	private Date inicio;
	private Date fim;
	private Hospital hospital;
	private CapsuleWatch capsuleWatch;
	private Medico medico;
	private List<CapsuleControl> listaCapsuleControl;
	private Paciente paciente;

	public MonitoramentoDTO(Monitoramento monitoramento) {
		this.codigo = monitoramento.getCodigo();
		this.inicio = monitoramento.getInicio();
		this.fim = monitoramento.getFim();
		this.hospital = monitoramento.getHospital();
		this.capsuleWatch = monitoramento.getCapsuleWatch();
		this.medico = monitoramento.getMedico();
		this.listaCapsuleControl = monitoramento.getListaCapsuleControl();
		this.paciente = monitoramento.getPaciente();
	}

	public Long getCodigo() {
		return codigo;
	}

	public Date getInicio() {
		return inicio;
	}

	public Date getFim() {
		return fim;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public CapsuleWatch getCapsuleWatch() {
		return capsuleWatch;
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
