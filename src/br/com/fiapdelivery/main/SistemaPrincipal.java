package br.com.fiapdelivery.main;

import br.com.fiapdelivery.model.Caminhao;
import br.com.fiapdelivery.model.Moto;
import br.com.fiapdelivery.model.Pacote;
import br.com.fiapdelivery.model.Rota;
import br.com.fiapdelivery.model.Veiculo;

public class SistemaPrincipal {

    public static void main(String[] args) {
        Veiculo caminhao = new Caminhao("ABC1234", 5000.0, 3);
        Veiculo moto = new Moto("XYZ9876", 20.0, true);
        Pacote pacote = new Pacote("BR999", 10.5);

        // A mesma Rota funciona com qualquer Veiculo (polimorfismo)
        new Rota(pacote, caminhao).iniciarEntrega();
        new Rota(pacote, moto).iniciarEntrega();

        System.out.println("Status do pacote: " + pacote.getStatus());

        // O dado invalido do codigo legado (capacidade -500) agora e barrado
        try {
            new Caminhao("DEF5678", -500.0, 3);
        } catch (IllegalArgumentException e) {
            System.out.println("Operacao bloqueada: " + e.getMessage());
        }

        // Regra nova: pacote pesado demais para a moto
        try {
            new Rota(new Pacote("BR111", 80.0), moto);
        } catch (IllegalArgumentException e) {
            System.out.println("Operacao bloqueada: " + e.getMessage());
        }
    }
}
