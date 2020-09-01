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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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

    @Column(name = "dt_fim")
    private Date fim;
    
    @ManyToOne
    @JoinColumn(name = "cd_hospital", nullable = false)
    private Hospital hospital;
    
    @OneToOne
    @JoinColumn(name = "cd_capsule_watch", nullable = false)
    private CapsuleWatch capsuleWatch;
    
    @ManyToOne
    @JoinColumn(name = "cd_medico", nullable = false)
    private Medico medico;
    
    @OneToMany(mappedBy="monitoramento", cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
    private List<CapsuleControl> listaCapsuleControl = new ArrayList<CapsuleControl>();
    
    @ManyToMany(mappedBy="monitoramentos", cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    private List<Paciente> pacientes = new ArrayList<Paciente>();

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

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
}

