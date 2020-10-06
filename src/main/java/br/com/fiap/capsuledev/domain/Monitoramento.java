package br.com.fiap.capsuledev.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PreRemove;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TB_MONITORAMENTO")
@SequenceGenerator(name = "monitoramentoSequence", sequenceName = "SQ_MONITORAMENTO", allocationSize = 1)
public class Monitoramento {

    @Id
    @Column(name = "cd_monitoramento")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "monitoramentoSequence")
    private Long codigo;
    
    @Column(name = "ds_monitoramento")
    private String descricao;

    @Column(name = "dt_inicio")
    private Date inicio;
    
    @FutureOrPresent
    @Column(name = "dt_fim")
    private Date fim;
    
    @Column(name = "st_monitoramento")
    private Boolean ativo;
    
    @Column(name = "nr_frequencia_segundos")
    private Long frequenciaSegundos;
    //Relatórios CapsuleWatch chegam a cada 'frequenciaSegundos' segundos
    
    @ManyToOne
    @JoinColumn(name = "cd_hospital", nullable = false)
    @JsonBackReference
    private Hospital hospital;
    
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "cd_capsule_watch", nullable = false)
//    private CapsuleWatch capsuleWatch;
    
    @OneToMany(mappedBy="monitoramento", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    //Cascade? Not sure
    private List<CapsuleWatch> listaCapsuleWatch = new ArrayList<CapsuleWatch>();
    
    @ManyToOne(cascade = {CascadeType.REMOVE})
    //Costumava ser ALL
    @JoinColumn(name = "cd_medico", nullable = false)
    //@JsonBackReference não pode ficar :(
    private Medico medico;
    
    @OneToMany(mappedBy="monitoramento", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    //Costumava ser cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
    @Valid
    private List<CapsuleControl> listaCapsuleControl = new ArrayList<CapsuleControl>();
    
    @ManyToOne(cascade = {CascadeType.REMOVE})
    //Costumava ser ALL
    @JoinColumn(name = "cd_paciente", nullable = false)
    private Paciente paciente;
    
    public Monitoramento() {
	}

	public Monitoramento(String descricao, Date inicio, Date fim, Boolean ativo, Long frequenciaSegundos) {
		this.descricao = descricao;
        this.inicio = inicio;
        this.fim = fim;
        this.ativo = ativo;
        this.frequenciaSegundos = frequenciaSegundos;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }
    
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Long getFrequenciaSegundos() {
		return frequenciaSegundos;
	}

	public void setFrequenciaSegundos(Long frequenciaSegundos) {
		this.frequenciaSegundos = frequenciaSegundos;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public List<CapsuleWatch> getListaCapsuleWatch() {
		return listaCapsuleWatch;
	}

	public void setListaCapsuleWatch(List<CapsuleWatch> listaCapsuleWatch) {
		this.listaCapsuleWatch = listaCapsuleWatch;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<CapsuleControl> getListaCapsuleControl() {
		return listaCapsuleControl;
	}

	public void setListaCapsuleControl(List<CapsuleControl> listaCapsuleControl) {
		this.listaCapsuleControl = listaCapsuleControl;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	//Nao tenho certeza se isso precisa
	@PreRemove
	private void removeMonitoramentoFromHospital() {
		if (this.hospital == null) {
			
		}else {
			hospital.getMonitoramentos().remove(this);
		}
	}
	
}

