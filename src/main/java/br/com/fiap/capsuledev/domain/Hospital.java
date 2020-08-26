package br.com.fiap.capsuledev.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "hospitalSequence", sequenceName = "SQ_HOSPITAL", allocationSize = 1)
public class Hospital {

	//Arrumar o tamanho das strings com Size
	//Colocar as anotações de colunas com o nome da modelagem. Igual o cnpj
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hospitalSequence")
	private Long codigo;
	
	private String nome;
	
	@Column(name = "nr_cnpj")
	private String cnpj;
	
	private String inscricaoEstadual;
	
	private String endereco;
	
	private String telefone;

	public Hospital() {
	
	}

	public Hospital(String nome, String cnpj, String inscricaoEstadual, String endereco, String telefone) {
		super();
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
	
}
