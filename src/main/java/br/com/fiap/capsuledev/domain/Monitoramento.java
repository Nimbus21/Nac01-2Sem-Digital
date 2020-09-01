package br.com.fiap.capsuledev.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_MONITORAMENTO")
@SequenceGenerator(name = "monitoramentoSequence", sequenceName = "SQ_MONITORAMENTO, allocationSize = 1")
public class Monitoramento {

    @Id
    @Column(name = "cd_monitoramento")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hospitalSequence")
    private Long monitoramento;

    @Column(name = "dt_inicio")
    private Date inicio;

    @Column(name = "dt_fim")
    private Date fim;

    public Monitoramento(Long monitoramento, Date inicio, Date fim) {
        this.monitoramento = monitoramento;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Long getMonitoramento() {
        return monitoramento;
    }

    public void setMonitoramento(Long monitoramento) {
        this.monitoramento = monitoramento;
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

}

