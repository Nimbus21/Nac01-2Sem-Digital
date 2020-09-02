package br.com.fiap.capsuledev.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TB_MEDICO")
@SequenceGenerator(name = "medicoSequence", sequenceName = "SQ_MEDICO", allocationSize = 1)
public class Medico {
	
    @Id
    @Column(name = "cd_medico")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicoSequence")
    private Long codigo;

    @Column(name = "nm_medico")
    private String nome;

    @Column(name = "nr_crm")
    private String crm;
    
    @OneToMany(mappedBy="medico", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Monitoramento> monitoramentos = new ArrayList<Monitoramento>();
    
    public Medico() {
	}

	public Medico(String nome, String crm) {
        this.nome = nome;
        this.crm = crm;
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

	public List<Monitoramento> getMonitoramentos() {
		return monitoramentos;
	}

	public void setMonitoramentos(List<Monitoramento> monitoramentos) {
		this.monitoramentos = monitoramentos;
	}
    
	public void addMonitoramentos(Monitoramento monitoramento) {
		monitoramento.setMedico(this);
		monitoramentos.add(monitoramento);
	}
	
}
