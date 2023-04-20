package exercicios.desafio6.domain;

import exercicios.desafio6.utils.enums.TipoDePao;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Optional;


@Document
public class Sanduiche {

    @Id
    private String chaveParticao;

    private String chaveFiltragem;

    private LocalDateTime dataAtualizacao = LocalDateTime.now();

    private TipoDePao tipoDePao;

    private String proteina;

    private Integer alface;

    private Integer tomate;

    private Integer queijo;

    private Integer picles;

    public Sanduiche() {
    }

    public Sanduiche(String chaveParticao, String chaveFiltragem, LocalDateTime dataAtualizacao, TipoDePao tipoDePao, String proteina, Integer alface, Integer tomate, Integer queijo, Integer picles) {
        this.chaveParticao = chaveParticao;
        this.chaveFiltragem = chaveFiltragem;
        this.dataAtualizacao = dataAtualizacao;
        this.tipoDePao = tipoDePao;
        this.proteina = proteina;
        this.alface = alface;
        this.tomate = tomate;
        this.queijo = queijo;
        this.picles = picles;
    }


    public String getChaveFiltragem() {
        return chaveFiltragem;
    }

    public void setChaveFiltragem(String chaveFiltragem) {
        this.chaveFiltragem = chaveFiltragem;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public TipoDePao getTipoDePao() {
        return tipoDePao;
    }

    public void setTipoDePao(TipoDePao tipoDePao) {
        this.tipoDePao = tipoDePao;
    }

    public String getProteina() {
        return proteina;
    }

    public void setProteina(String proteina) {
        this.proteina = proteina;
    }

    public Integer getAlface() {
        return alface;
    }

    public void setAlface(Integer alface) {
        this.alface = alface;
    }

    public Integer getTomate() {
        return tomate;
    }

    public void setTomate(Integer tomate) {
        this.tomate = tomate;
    }

    public Integer getQueijo() {
        return queijo;
    }

    public void setQueijo(Integer queijo) {
        this.queijo = queijo;
    }

    public Integer getPicles() {
        return picles;
    }

    public void setPicles(Integer picles) {
        this.picles = picles;
    }

    public String getChaveParticao() {
        return chaveParticao;
    }

    public void setChaveParticao(String chaveParticao) {
        this.chaveParticao = chaveParticao;
    }
}
