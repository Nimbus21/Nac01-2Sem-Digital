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

    @Column(name = "dt_inicio")
    private Date inicio;
    
    @FutureOrPresent
    @Column(name = "dt_fim")
    private Date fim;
    
    @ManyToOne
    @JoinColumn(name = "cd_hospital", nullable = true)
    @JsonBackReference
    @Valid
    private Hospital hospital;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_capsule_watch", nullable = false)
    private CapsuleWatch capsuleWatch;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_medico", nullable = false)
    @Valid
    private Medico medico;
    
    @OneToMany(mappedBy="monitoramento", cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @Valid
    private List<CapsuleControl> listaCapsuleControl = new ArrayList<CapsuleControl>();
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_paciente", nullable = false)
    private Paciente paciente;
    
    

    public Monitoramento() {
	}

	public Monitoramento(Date inicio, Date fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public CapsuleWatch getCapsuleWatch() {
		return capsuleWatch;
	}

	public void setCapsuleWatch(CapsuleWatch capsuleWatch) {
		this.capsuleWatch = capsuleWatch;
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

