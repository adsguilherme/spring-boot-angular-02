package br.com.api.helpdesk.domain.enums;

/**
 * Enumeração que representa a prioridade de um chamado no sistema.
 *
 * Cada prioridade possui um código numérico e uma descrição.
 *
 */
public enum Prioridade {

    // Definição dos valores da enumeração com código e descrição
    BAIXA(0, "BAIXA"), 
    MEDIA(1, "MEDIA"), 
    ALTA(2, "ALTA");

    // Atributos privados para armazenar o código e a descrição da prioridade
    private Integer codigo;
    private String descricao;

    /**
     * Construtor para atribuir os valores aos atributos do enum.
     * 
     * @param codigo Código numérico da prioridade.
     * @param descricao Descrição textual da prioridade.
     */
    private Prioridade(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    /**
     * Obtém o código numérico da prioridade.
     * @return O código da prioridade.
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * Obtém a descrição da prioridade.
     * @return A descrição da prioridade.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Método estático capaz de converter um inteiro em um objeto Prioridade.
     * Útil quando recebemos o código do banco de dados ou requisição e precisamos saber qual é o Enum.
     * 
     * @param cod O código numérico a ser convertido.
     * @return O objeto Prioridade correspondente ao código.
     * @throws IllegalArgumentException caso o código passado não corresponda a nenhuma prioridade válida.
     */
    public static Prioridade toEnum(Integer cod) {
        // Se o código for nulo, retorna nulo imediatamente para evitar erros
        if (cod == null) {
            return null;
        }

        // Percorre todos os valores possíveis desta enumeração (BAIXA, MEDIA, ALTA)
        for(Prioridade x : Prioridade.values()) {
            // Verifica se o código informado é igual ao código da prioridade atual no loop
            if(cod.equals(x.getCodigo())) {
                return x; // Retorna a prioridade encontrada
            }
        }

        // Se passar por todos e não encontrar, lança uma exceção informando que o ID é inválido
        throw new IllegalArgumentException("Prioridade inválida: " + cod);
    }
}
