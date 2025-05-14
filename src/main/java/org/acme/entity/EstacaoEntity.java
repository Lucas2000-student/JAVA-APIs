package org.acme.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


@Entity
@Table(name = "T_HFLL_ESTACAO")
public class EstacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_ESTACAO")
    private Integer idEstacao;

    @JsonProperty("NOME_ESTACAO")
    @Column(name = "NOME_ESTACAO")
    private String nomeEstacao;

    @JsonProperty("LOCALIZACAO")
    @Column(name = "LOCALIZACAO")
    private String localizacao;

    @JsonProperty("ACESSIBILIDADE")
    @Column(name = "ACESSIBILIDADE")
    private String acessibilidade;

    public EstacaoEntity() {
    }

    public Integer getIdEstacao() {
        return idEstacao;
    }

    public void setIdEstacao(Integer idEstacao) {
        this.idEstacao = idEstacao;
    }

    public String getNomeEstacao() {
        return nomeEstacao;
    }

    public void setNomeEstacao(String nomeEstacao) {
        this.nomeEstacao = nomeEstacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getAcessibilidade() {
        return acessibilidade;
    }

    public void setAcessibilidade(String acessibilidade) {
        this.acessibilidade = acessibilidade;
    }
}
