package org.acme.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "T_HFLL_TREM")
public class TrainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_TREM")
    private Integer idTrem;

    @JsonProperty("HORARIO_PARTIDA")
    @Column(name = "HORARIO_PARTIDA")
    private Integer horarioPartida;

    @JsonProperty("HORARIO_CHEGADA")
    @Column(name = "HORARIO_CHEGADA")
    private Integer horarioChegada;

    @JsonProperty("STATUS")
    @Column(name = "STATUS")
    private String status;

    // Construtor padrão
    public TrainEntity() {
    }

    // Getters e Setters

    public Integer getIdTrem() {
        return idTrem;
    }

    public void setIdTrem(Integer idTrem) {
        this.idTrem = idTrem;
    }

    public Integer getHorarioPartida() {
        return horarioPartida;
    }

    public void setHorarioPartida(Integer horarioPartida) {
        this.horarioPartida = horarioPartida;
    }

    public Integer getHorarioChegada() {
        return horarioChegada;
    }

    public void setHorarioChegada(Integer horarioChegada) {
        this.horarioChegada = horarioChegada;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

