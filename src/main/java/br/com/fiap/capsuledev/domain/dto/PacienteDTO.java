package br.com.fiap.capsuledev.domain.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.capsuledev.domain.Monitoramento;
import br.com.fiap.capsuledev.domain.Paciente;

public class PacienteDTO {
	
	private Long codigo;
    private String nome;
    private Date nascimento;
    private String rg;
    private String genero;
    private String nomeMae;
    private String endereco;
    private String contato;
    private String telefone;
    private String orgao;
    private Date transplante;
    private List<Monitoramento> monitoramentos = new ArrayList<Monitoramento>();

    
    public PacienteDTO(Paciente paciente) {
    	this.codigo = paciente.getCodigo();
    	this.nome = paciente.getNome();
    	this.nascimento = paciente.getNascimento();
    	this.rg = paciente.getRg();
    	this.genero = paciente.getGenero();
    	this.nomeMae = paciente.getNomeMae();
    	this.endereco = paciente.getEndereco();
    	this.contato = paciente.getContato();
    	this.telefone = paciente.getTelefone();
    	this.orgao = paciente.getOrgao();
    	this.transplante = paciente.getTransplante();
    	this.monitoramentos = paciente.getMonitoramentos();
    }
    
    public Long getCodigo() {
    	return codigo;
    }
    
    public String getNome() {
    	return nome;
    }
    
    public Date getNascimento() {
    	return nascimento;
    }
    
    public String getRg() {
    	return rg;
    }
    
    public String getGenero() {
    	return genero;
    }
    
    public String getNomeMae() {
    	return nomeMae;
    }
    
    public String getEndereco() {
    	return endereco;
    }
    
    public String getContato() {
    	return contato;
    }
    
    public String getTelefone() {
    	return telefone;
    }
    
    public String getOrgao() {
    	return orgao;
    }
    
	public List<Monitoramento> getMonitoramentos() {
		return monitoramentos;
	}

	public Date getTransplante() {
		return transplante;
	}
	
	public static List<PacienteDTO> converter (List<Paciente> pacientes) {
		return pacientes.stream().map(PacienteDTO::new).collect(Collectors.toList());
	}
}
