package br.com.fiapdelivery.model;

/**
 * Encomenda a ser entregue. O codigo e imutavel; o status so muda por
 * {@link #atualizarStatus(StatusPacote)}.
 */
public class Pacote {

    private final String codigo;
    private double pesoKg;
    private StatusPacote status;

    /**
     * Cria um pacote sempre com status {@link StatusPacote#PENDENTE}.
     */
    public Pacote(String codigo, double pesoKg) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("O codigo do pacote nao pode ser vazio.");
        }
        this.codigo = codigo;
        setPesoKg(pesoKg);
        this.status = StatusPacote.PENDENTE;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        if (pesoKg <= 0) {
            throw new IllegalArgumentException("O peso deve ser maior que zero.");
        }
        this.pesoKg = pesoKg;
    }

    public StatusPacote getStatus() {
        return status;
    }

    public void atualizarStatus(StatusPacote novoStatus) {
        if (novoStatus == null) {
            throw new IllegalArgumentException("O status nao pode ser nulo.");
        }
        this.status = novoStatus;
    }
}
