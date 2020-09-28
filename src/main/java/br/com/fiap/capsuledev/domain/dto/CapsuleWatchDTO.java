package br.com.fiap.capsuledev.domain.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.capsuledev.domain.CapsuleWatch;
import br.com.fiap.capsuledev.domain.Monitoramento;

public class CapsuleWatchDTO {
	
	private Long codigo;
	private Integer batimentos;
	private Float temperatura;
	private Float pressao;
	private Float imc;
	private Date dataHora;
	private String sintomas;
	private Monitoramento monitoramento;
	
	public CapsuleWatchDTO(CapsuleWatch capsuleWatch) {
		this.codigo = capsuleWatch.getCodigo();
		this.batimentos = capsuleWatch.getBatimentos();
		this.temperatura = capsuleWatch.getTemperatura();
		this.pressao = capsuleWatch.getPressao();
		this.imc = capsuleWatch.getImc();
		this.dataHora = capsuleWatch.getDataHora();
		this.sintomas = capsuleWatch.getSintomas();
		this.monitoramento = capsuleWatch.getMonitoramento();
	}
	
	public Long getCodigo() {
		return codigo;
	}
	
	public Integer getBatimentos() {
		return batimentos;
	}
	
	public Float getTemperatura() {
		return temperatura;
	}
	
	public Float getPressao() {
		return pressao;
	}
	
	public Float getImc() {
		return imc;
	}
	
	public Date getDataHora() {
		return dataHora;
	}
	
	public String getSintomas() {
		return sintomas;
	}
	
	public Monitoramento getMonitoramento() {
		return monitoramento;
	}
	
	public static List<CapsuleWatchDTO> converter (List<CapsuleWatch> listaCapsuleWatch) {
		return listaCapsuleWatch.stream().map(CapsuleWatchDTO::new).collect(Collectors.toList());
	}
}
