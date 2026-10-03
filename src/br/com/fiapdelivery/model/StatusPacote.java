package br.com.fiapdelivery.model;

/**
 * Estados possiveis de um pacote. Usar enum impede status invalidos como "xyz".
 */
public enum StatusPacote {
    PENDENTE,
    EM_TRANSITO,
    ENTREGUE
}
