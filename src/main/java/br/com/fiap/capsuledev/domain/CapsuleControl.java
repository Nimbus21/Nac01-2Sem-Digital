package br.com.fiap.capsuledev.domain;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;

@Entity
@Table(name = "TB_CAPSULE_CONTROL")
@SequenceGenerator(name = "capsuleControlSequence", sequenceName = "SQ_CAPSULE_CONTROL", allocationSize = 1)
public class CapsuleControl {

    @Id
    @Column(name = "cd_capsule_control")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "capsuleControlSequence")
    private Long codigo;
    
	@NotBlank(message = "Medicamento obrigatório")
    @Column(name = "ds_remedio")
    private String remedio;

	@NotBlank(message = "Dose obrigatória")
    @Column(name = "ds_dose")
    private String dose;

    @Column(name = "dt_data")
    private Date data;
    
    @ManyToOne
    @JoinColumn(name = "cd_monitoramento", nullable = false)
    @JsonBackReference
    private Monitoramento monitoramento;
    
    public CapsuleControl() {
	}

	public CapsuleControl(String remedio, String dose, Date data) {
        this.remedio = remedio;
        this.dose = dose;
        this.data = data;
    }
    
    public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getRemedio() {
        return remedio;
    }

    public void setRemedio(String remedio) {
        this.remedio = remedio;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

	public Monitoramento getMonitoramento() {
		return monitoramento;
	}

	public void setMonitoramento(Monitoramento monitoramento) {
		this.monitoramento = monitoramento;
	}
    
}
