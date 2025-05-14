package org.acme.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "T_HFLL_LOCAIS_PROXIMOS")
public class LocaisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_LOCAL")
    private Integer idLocal;

    @JsonProperty("TIPO_LOCAL")
    @Column(name = "TIPO_LOCAL")
    private String tipoLocal;

    @JsonProperty("NOME")
    @Column(name = "NOME")
    private String nome;

    @JsonProperty("LOCALIZACAO")
    @Column(name = "LOCALIZACAO")
    private String localizacao;

    @JsonProperty("HORA_ABERTURA")
    @Column(name = "HORA_ABERTURA")
    private Integer horaAbertura;

    @JsonProperty("HORA_FECHAMENTO")
    @Column(name = "HORA_FECHAMENTO")
    private Integer horaFechamento;

    @JsonProperty("DIAS_FUNCIONAMENTO")
    @Column(name = "DIAS_FUNCIONAMENTO")
    private Integer diasFuncionamento;

    public LocaisEntity() {
    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public String getTipoLocal() {
        return tipoLocal;
    }

    public void setTipoLocal(String tipoLocal) {
        this.tipoLocal = tipoLocal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Integer getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(Integer horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public Integer getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(Integer horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    public Integer getDiasFuncionamento() {
        return diasFuncionamento;
    }

    public void setDiasFuncionamento(Integer diasFuncionamento) {
        this.diasFuncionamento = diasFuncionamento;
    }
}