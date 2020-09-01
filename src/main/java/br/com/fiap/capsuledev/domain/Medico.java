package br.com.fiap.capsuledev.domain;

import javax.persistence.*;

@Entity
@Table(name = "TB_MEDICO")
@SequenceGenerator(name = "MedicoSequence", sequenceName = "SQ_MEDICO", allocationSize = 1)
public class Medico {
    @Id
    @Column(name = "cd_medico")
    private Long medico;

    @Column(name = "nm_medico")
    private String nome;

    @Column(name = "nr_crm")
    private char crm;

    public Medico(Long medico, String nome, char crm) {
        this.medico = medico;
        this.nome = nome;
        this.crm = crm;
    }

    public Long getMedico() {
        return medico;
    }

    public void setMedico(Long medico) {
        this.medico = medico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getCrm() {
        return crm;
    }

    public void setCrm(char crm) {
        this.crm = crm;
    }
}
