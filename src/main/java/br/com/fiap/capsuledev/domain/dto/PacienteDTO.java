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
    private List<Monitoramento> monitoramentos = new ArrayList<Monitoramento>();
    private Date transplante;
    
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
    	this.monitoramentos = paciente.getMonitoramentos();
    	this.transplante = paciente.getTransplante();
    }
    
    public Long codigo() {
    	return codigo;
    }
    
    public String nome() {
    	return nome;
    }
    
    public Date nascimento() {
    	return nascimento;
    }
    
    public String rg() {
    	return rg;
    }
    
    public String genero() {
    	return genero;
    }
    
    public String nomeMae() {
    	return nomeMae;
    }
    
    public String endereco() {
    	return endereco;
    }
    
    public String contato() {
    	return contato;
    }
    
    public String telefone() {
    	return telefone;
    }
    
    public String orgao() {
    	return orgao;
    }
    
	public List<Monitoramento> getMonitoramentos() {
		return monitoramentos;
	}

	public Date transplante() {
		return transplante;
	}
	
	public static List<PacienteDTO> converter (List<Paciente> pacientes) {
		return pacientes.stream().map(PacienteDTO::new).collect(Collectors.toList());
	}
}
