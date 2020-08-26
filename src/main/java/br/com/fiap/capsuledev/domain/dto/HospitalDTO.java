package br.com.fiap.capsuledev.domain.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.capsuledev.domain.Hospital;

public class HospitalDTO {

private Long codigo;
	
	private String nome;	
	private String cnpj;
	private String inscricaoEstadual;
	private String endereco;
	private String telefone;
	
	
	public HospitalDTO(Hospital hospital) {
		this.codigo = hospital.getCodigo();
		this.nome = hospital.getNome();
		this.cnpj = hospital.getCnpj();
		this.inscricaoEstadual = hospital.getInscricaoEstadual();
		this.endereco = hospital.getEndereco();
		this.telefone = hospital.getTelefone();
	}

	public Long getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public static List<HospitalDTO> converter (List<Hospital> hospitais) {
		return hospitais.stream().map(HospitalDTO::new).collect(Collectors.toList());
	}
	
}
