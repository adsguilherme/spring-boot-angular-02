package br.com.api.helpdesk.domain.enums;

/**
 * Enumeração que representa os status de um chamado no sistema.
 *
 * Cada status possui um código numérico e uma descrição.
 *
 */
public enum Status {

    // Definição dos valores da enumeração com código e descrição
    ABERTO(0, "ABERTO"), 
    ANDAMENTO(1, "ANDAMENTO"), 
    ENCERRADO(2, "ENCERRADO");

    // Atributos privados para armazenar o código e a descrição do status
    private Integer codigo;
    private String descricao;

    /**
     * Construtor para atribuir os valores aos atributos do enum.
     * 
     * @param codigo Código numérico do status.
     * @param descricao Descrição textual do status.
     */
    private Status(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    /**
     * Obtém o código numérico do status.
     * @return O código do status.
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * Obtém a descrição do status.
     * @return A descrição do status.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Método estático capaz de converter um inteiro em um objeto Status.
     * Útil quando recebemos o código do banco de dados ou requisição e precisamos saber qual é o Enum.
     * 
     * @param cod O código numérico a ser convertido.
     * @return O objeto Status correspondente ao código.
     * @throws IllegalArgumentException caso o código passado não corresponda a nenhum status válido.
     */
    public static Status toEnum(Integer cod) {
        // Se o código for nulo, retorna nulo imediatamente para evitar erros
        if (cod == null) {
            return null;
        }

        // Percorre todos os valores possíveis desta enumeração (ABERTO, ANDAMENTO, ENCERRADO)
        for(Status x : Status.values()) {
            // Verifica se o código informado é igual ao código do status atual no loop
            if(cod.equals(x.getCodigo())) {
                return x; // Retorna o status encontrado
            }
        }

        // Se passar por todos e não encontrar, lança uma exceção informando que o ID é inválido
        throw new IllegalArgumentException("Status inválido: " + cod);
    }
}
