package br.com.fiapdelivery.model;

/**
 * Veiculo de grande porte, caracterizado pela quantidade de eixos.
 */
public class Caminhao extends Veiculo {

    private int eixos;

    public Caminhao(String placa, double capacidadeKg, int eixos) {
        super(placa, capacidadeKg);
        setEixos(eixos);
    }

    public int getEixos() {
        return eixos;
    }

    public void setEixos(int eixos) {
        if (eixos < 2) {
            throw new IllegalArgumentException("Um caminhao deve ter ao menos 2 eixos.");
        }
        this.eixos = eixos;
    }

    @Override
    public String descrever() {
        return "Caminhao " + getPlaca() + " (" + eixos + " eixos)";
    }
}
