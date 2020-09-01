package br.com.fiap.capsuledev.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_PACIENTE")
@SequenceGenerator(name = "pacienteSequence", sequenceName = "SQ_PACIENTE", allocationSize = 1)
public class Paciente {

    @Id
    @Column(name = "cd_paciente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pacienteSequence")
    private Long codigo;

    @Column(name = "nm_paciente")
    private String nome;

    @Column(name = "dt_nascimento")
    private Date nascimento;

    @Column(name = "nr_rg")
    private char rg;

    @Column(name = "ds_genero")
    private String genero;

    @Column(name = "nm_mae")
    private String mae;

    @Column(name = "ds_endereco")
    private String endereco;

    @Column(name = "nm_contato")
    private String contato;

    @Column(name = "tl_telefone")
    private char telefone;

    @Column(name = "ds_orgao")
    private String orgao;

    @Column(name = "ds_hospital_cirurgia")
    private String hospital;

    @Column(name = "dt_transplante")
    private Date transplante;

    public Paciente(Long codigo, String nome, Date nascimento, char rg, String genero, String mae, String endereco, String contato, char telefone, String orgao, String hospital, Date transplante, String medico, String crm) {
        this.codigo = codigo;
        this.nome = nome;
        this.nascimento = nascimento;
        this.rg = rg;
        this.genero = genero;
        this.mae = mae;
        this.endereco = endereco;
        this.contato = contato;
        this.telefone = telefone;
        this.orgao = orgao;
        this.hospital = hospital;
        this.transplante = transplante;
        this.medico = medico;
        this.crm = crm;
    }

    @Column(name = "nm_medico_cirurgia")
    private String medico;

    @Column(name = "nr_crm_medico")
    private String crm;



    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public char getRg() {
        return rg;
    }

    public void setRg(char rg) {
        this.rg = rg;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public char getTelefone() {
        return telefone;
    }

    public void setTelefone(char telefone) {
        this.telefone = telefone;
    }

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public Date getTransplante() {
        return transplante;
    }

    public void setTransplante(Date transplante) {
        this.transplante = transplante;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}
