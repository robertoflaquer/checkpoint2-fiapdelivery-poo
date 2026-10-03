package br.com.fiapdelivery.model;

/**
 * Representa um veiculo generico da frota do FiapDelivery.
 * Concentra os atributos e regras comuns a qualquer tipo de veiculo,
 * evitando duplicacao nas subclasses.
 */
public abstract class Veiculo {

    private final String placa;
    private double capacidadeKg;

    /**
     * @param placa        identificacao do veiculo (nao pode ser vazia)
     * @param capacidadeKg capacidade de carga em kg (deve ser maior que zero)
     */
    protected Veiculo(String placa, double capacidadeKg) {
        if (placa == null || placa.isBlank()) {
            throw new IllegalArgumentException("A placa nao pode ser vazia.");
        }
        this.placa = placa;
        setCapacidadeKg(capacidadeKg);
    }

    public String getPlaca() {
        return placa;
    }

    public double getCapacidadeKg() {
        return capacidadeKg;
    }

    public void setCapacidadeKg(double capacidadeKg) {
        if (capacidadeKg <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero.");
        }
        this.capacidadeKg = capacidadeKg;
    }

    /**
     * @return descricao curta do veiculo, usada nas mensagens de rota
     */
    public String descrever() {
        return placa;
    }
}
