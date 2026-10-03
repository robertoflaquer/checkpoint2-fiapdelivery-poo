package br.com.fiapdelivery.model;

/**
 * Liga um pacote a um veiculo. Depende da abstracao {@link Veiculo}, entao
 * aceita Caminhao, Moto ou qualquer veiculo futuro sem alteracao.
 */
public class Rota {

    private final Pacote pacote;
    private final Veiculo veiculo;

    /**
     * @throws IllegalArgumentException se pacote ou veiculo forem nulos,
     *                                  ou se o pacote exceder a capacidade do veiculo
     */
    public Rota(Pacote pacote, Veiculo veiculo) {
        if (pacote == null || veiculo == null) {
            throw new IllegalArgumentException("Pacote e veiculo sao obrigatorios.");
        }
        if (pacote.getPesoKg() > veiculo.getCapacidadeKg()) {
            throw new IllegalArgumentException("O pacote (" + pacote.getPesoKg()
                    + "kg) excede a capacidade do veiculo (" + veiculo.getCapacidadeKg() + "kg).");
        }
        this.pacote = pacote;
        this.veiculo = veiculo;
    }

    public Pacote getPacote() {
        return pacote;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    /**
     * Inicia a entrega: marca o pacote como em transito e informa a rota.
     */
    public void iniciarEntrega() {
        pacote.atualizarStatus(StatusPacote.EM_TRANSITO);
        System.out.println("Levando pacote " + pacote.getCodigo() + " no veiculo " + veiculo.descrever());
    }
}
