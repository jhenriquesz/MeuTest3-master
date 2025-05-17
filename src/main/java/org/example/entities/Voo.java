package org.example.entities;

import java.time.LocalDateTime;

public class Voo {
    private static int id;
    private String origem;
    private String destino;
    private LocalDateTime dateTime;
    private static Aviao aviao;
    private int vagasDisponiveis;

    public Voo(String origem, String destino, LocalDateTime dateTime, Aviao aviao) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.dateTime = dateTime;
        this.aviao = aviao;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Voo.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public static Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }
}
