package br.com.fiap.capsuledev.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_CAPSULE_WATCH")
@SequenceGenerator(name = "capsuleWatchSequence", sequenceName = "SQ_CAPSULE_WATCH", allocationSize =  1)
public class CapsuleWatch {

    @Id
    @Column(name ="cd_capsule_watch")
    private Long capsuleWatch;

    @Column(name = "nr_batimento")
    private int batimentos;

    @Column(name = "nr_temperatura")
    private Float temperatura;

    @Column(name = "nr_pressao")
    private char pressao;

    @Column(name = "nr_imc")
    private int imc;

    @Column(name = "dt_data_hora")
    private Date dataHora;

    @Column(name = "ds_dor")
    private String dor;

    public CapsuleWatch(Long capsuleWatch, int batimentos, Float temperatura, char pressao, int imc, Date dataHora, String dor) {
        this.capsuleWatch = capsuleWatch;
        this.batimentos = batimentos;
        this.temperatura = temperatura;
        this.pressao = pressao;
        this.imc = imc;
        this.dataHora = dataHora;
        this.dor = dor;
    }

    public Long getCapsuleWatch() {
        return capsuleWatch;
    }

    public void setCapsuleWatch(Long capsuleWatch) {
        this.capsuleWatch = capsuleWatch;
    }

    public int getBatimentos() {
        return batimentos;
    }

    public void setBatimentos(int batimentos) {
        this.batimentos = batimentos;
    }

    public Float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Float temperatura) {
        this.temperatura = temperatura;
    }

    public char getPressao() {
        return pressao;
    }

    public void setPressao(char pressao) {
        this.pressao = pressao;
    }

    public int getImc() {
        return imc;
    }

    public void setImc(int imc) {
        this.imc = imc;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getDor() {
        return dor;
    }

    public void setDor(String dor) {
        this.dor = dor;
    }
}
