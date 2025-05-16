package org.example.entities;

import java.time.LocalDateTime;

public class Voo {
    private int id;
    private String origem;
    private String destino;
    private LocalDateTime dateTime;
    private Aviao aviao;

    public Voo(int id, String origem, String destino, LocalDateTime dateTime, Aviao aviao) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.dateTime = dateTime;
        this.aviao = aviao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }
}
