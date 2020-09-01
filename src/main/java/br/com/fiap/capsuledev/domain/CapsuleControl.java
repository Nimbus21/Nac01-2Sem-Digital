package br.com.fiap.capsuledev.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "TB_CAPSULE_CONTROL")
@SequenceGenerator(name = "capsuleControlSequence", sequenceName = "SQ_CAPSULE_CONTROL", allocationSize = 1)
public class CapsuleControl {

    @Id
    @Column(name = "ds_remedio")
    private String remedio;

    @Column(name = "ds_dose")
    private String dose;

    @Column(name = "dt_data")
    private Date data;

    @Column(name = "hr_alarme")
    private DateTimeFormat horaAlarme;

    public CapsuleControl(String remedio, String dose, Date data, DateTimeFormat horaAlarme) {
        this.remedio = remedio;
        this.dose = dose;
        this.data = data;
        this.horaAlarme = horaAlarme;
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

    public DateTimeFormat getHoraAlarme() {
        return horaAlarme;
    }

    public void setHoraAlarme(DateTimeFormat horaAlarme) {
        this.horaAlarme = horaAlarme;
    }
}
