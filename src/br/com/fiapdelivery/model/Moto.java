package br.com.fiapdelivery.model;

/**
 * Veiculo de pequeno porte para entregas rapidas, que pode ou nao ter bau.
 */
public class Moto extends Veiculo {

    private boolean possuiBau;

    public Moto(String placa, double capacidadeKg, boolean possuiBau) {
        super(placa, capacidadeKg);
        this.possuiBau = possuiBau;
    }

    public boolean isPossuiBau() {
        return possuiBau;
    }

    public void setPossuiBau(boolean possuiBau) {
        this.possuiBau = possuiBau;
    }

    @Override
    public String descrever() {
        return "Moto " + getPlaca() + (possuiBau ? " (com bau)" : " (sem bau)");
    }
}
