package br.com.fiap.capsuledev.domain.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.capsuledev.domain.CapsuleControl;
import br.com.fiap.capsuledev.domain.Monitoramento;

public class CapsuleControlDTO {
	
	private Long codigo;
	private String remedio;
	private String dose;
	private Date data;
	private Date horaAlarme;
	private Monitoramento monitoramento;
	
	public CapsuleControlDTO(CapsuleControl capsuleControl) {
		this.codigo = capsuleControl.getCodigo();
		this.remedio = capsuleControl.getRemedio();
		this.dose = capsuleControl.getDose();
		this.data = capsuleControl.getData();
		this.horaAlarme = capsuleControl.getHoraAlarme();
		this.monitoramento = capsuleControl.getMonitoramento();
	}
	
	public Long getCodigo() {
		return codigo;
	}
	
	public String getRemedio() {
		return remedio;
	}
	
	public String getDose() {
		return dose;
	}
	
	public Date getData() {
		return data;
	}
	
	public Date getHoraAlarme() {
		return horaAlarme;
	}
	
	public Monitoramento getMonitoramento() {
		return monitoramento;
	}
	
	public static List<CapsuleControlDTO> converter (List<CapsuleControl> listaCapsuleControl) {
		return listaCapsuleControl.stream().map(CapsuleControlDTO::new).collect(Collectors.toList());
	}
}
