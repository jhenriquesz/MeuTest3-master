package org.example.entities;

import java.time.LocalDateTime;

public class Reserva {
    private int id;
    private Passageiro passageiro;
    private Voo voo;
    private LocalDateTime dateTime;

    public Reserva(int id, Passageiro passageiro, Voo voo, LocalDateTime dateTime) {
        this.id = id;
        this.passageiro = passageiro;
        this.voo = voo;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
