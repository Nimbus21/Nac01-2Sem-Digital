package br.com.fiap.capsuledev.domain;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@Entity
@Table(name = "TB_CAPSULE_CONTROL")
@SequenceGenerator(name = "capsuleControlSequence", sequenceName = "SQ_CAPSULE_CONTROL", allocationSize = 1)
public class CapsuleControl {

    @Id
    @Column(name = "cd_capsule_control")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "capsuleControlSequence")
    private Long codigo;
    
    @Column(name = "ds_remedio")
    private String remedio;

    @Column(name = "ds_dose")
    private String dose;

    @Column(name = "dt_data")
    private Date data;

    @Column(name = "hr_alarme")
    private Date horaAlarme;
    
    @ManyToOne
    @JoinColumn(name = "cd_monitoramento", nullable = true)
    @JsonBackReference
    //true pra teste
    private Monitoramento monitoramento;

    
    
    public CapsuleControl() {
	}


	public CapsuleControl(String remedio, String dose, Date data, Date horaAlarme) {
        this.remedio = remedio;
        this.dose = dose;
        this.data = data;
        this.horaAlarme = horaAlarme;
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

    public Date getHoraAlarme() {
        return horaAlarme;
    }

    public void setHoraAlarme(Date horaAlarme) {
        this.horaAlarme = horaAlarme;
    }


	public Monitoramento getMonitoramento() {
		return monitoramento;
	}

	public void setMonitoramento(Monitoramento monitoramento) {
		this.monitoramento = monitoramento;
	}
    
}
