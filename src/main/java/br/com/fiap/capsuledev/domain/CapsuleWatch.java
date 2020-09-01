package br.com.fiap.capsuledev.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_CAPSULE_WATCH")
@SequenceGenerator(name = "capsuleWatchSequence", sequenceName = "SQ_CAPSULE_WATCH", allocationSize =  1)
public class CapsuleWatch {

    @Id
    @Column(name ="cd_capsule_watch")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "capsuleWatchSequence")
    private Long codigo;

    @Column(name = "nr_batimento")
    private int batimentos;

    @Column(name = "nr_temperatura")
    private Float temperatura;

    @Column(name = "nr_pressao")
    private Float pressao;

    @Column(name = "nr_imc")
    private int imc;

    @Column(name = "dt_data_hora")
    private Date dataHora;

    @Column(name = "ds_sintomas")
    private String sintomas;
    
    @OneToOne(mappedBy="capsuleWatch", cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
    private Monitoramento monitoramento;

    public CapsuleWatch(int batimentos, Float temperatura, Float pressao, int imc, Date dataHora, String sintomas) {
        this.batimentos = batimentos;
        this.temperatura = temperatura;
        this.pressao = pressao;
        this.imc = imc;
        this.dataHora = dataHora;
        this.sintomas = sintomas;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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

    public Float getPressao() {
        return pressao;
    }

    public void setPressao(Float pressao) {
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

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

	public Monitoramento getMonitoramento() {
		return monitoramento;
	}

	public void setMonitoramento(Monitoramento monitoramento) {
		this.monitoramento = monitoramento;
	}
   
}
