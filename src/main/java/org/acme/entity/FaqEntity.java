package org.acme.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "T_HFLL_FAQ")
public class FaqEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_FAQ")
    private Integer idFaq;

    @JsonProperty("FEEDBACK_")
    @Column(name = "FEEDBACK_")
    private String feedback;

    @JsonProperty("SUGESTAO")
    @Column(name = "SUGESTAO")
    private String sugestao;

    @JsonProperty("FAQ_NOME")
    @Column(name = "FAQ_NOME")
    private String faqNome;

    public FaqEntity() {
    }

    public Integer getIdFaq() {
        return idFaq;
    }

    public void setIdFaq(Integer idFaq) {
        this.idFaq = idFaq;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getSugestao() {
        return sugestao;
    }

    public void setSugestao(String sugestao) {
        this.sugestao = sugestao;
    }

    public String getFaqNome() {
        return faqNome;
    }

    public void setFaqNome(String faqNome) {
        this.faqNome = faqNome;
    }
}