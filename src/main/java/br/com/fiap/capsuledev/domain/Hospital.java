package br.com.fiap.capsuledev.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import  javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table (name = "TB_HOSPITAL_CLINICA")
@SequenceGenerator(name = "hospitalSequence", sequenceName = "SQ_HOSPITAL", allocationSize = 1)
public class Hospital {

	@Id
	@Column(name = "cd_hospital_clinica")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hospitalSequence")
	private Long codigo;
	
	@Column(name = "nm_hospital_clinica")
	private String nome;
	
	@Column(name = "nr_cnpj")
	private String cnpj;
	
	@Column(name = "nr_inscricao_estadual")
	private String inscricaoEstadual;
	
	@NotBlank(message = "Endereço obrigatório")
	@Column(name = "ds_endereco")
	private String endereco;
	
	@Column(name = "nr_telefone")
	private String telefone;
	
	@JsonManagedReference
	@OneToMany(mappedBy="hospital", cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	private List<Monitoramento> monitoramentos = new ArrayList<Monitoramento>();

	public Hospital() {
	
	}

	public Hospital(String nome, String cnpj, String inscricaoEstadual, String endereco, String telefone) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Monitoramento> getMonitoramentos() {
		return monitoramentos;
	}

	public void setMonitoramentos(List<Monitoramento> monitoramentos) {
		this.monitoramentos = monitoramentos;
	}
	
	public void addMonitoramentos(Monitoramento monitoramento) {
		monitoramento.setHospital(this);
		monitoramentos.add(monitoramento);
	}
	
}
