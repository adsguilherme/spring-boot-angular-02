package br.com.api.helpdesk.domain.enums;

/**
 * Enumeração que representa os perfis de acesso dos usuários no sistema.
 *
 * Cada perfil possui um código numérico e uma descrição que corresponde
 * à role (regra) de segurança utilizada, por exemplo, pelo Spring Security.
 *
 */
public enum Perfil {

    // Definição dos valores da enumeração com código e descrição (Role)
    ADMIN(0, "ROLE_ADMIN"), 
    CLIENTE(1, "ROLE_CLIENTE"), 
    TECNICO(2, "ROLE_TECNICO");

    // Atributos privados para armazenar o código e a descrição do perfil
    private Integer codigo;
    private String descricao;

    /**
     * Construtor para atribuir os valores aos atributos do enum.
     * 
     * @param codigo Código numérico do perfil.
     * @param descricao Descrição textual (Role) do perfil.
     */
    private Perfil(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    /**
     * Obtém o código numérico do perfil.
     * @return O código do perfil.
     */
    public Integer getCodigo() {
        return codigo;
        // Método utilizado para recuperar o ID numérico, útil para salvar no banco.
    }

    /**
     * Obtém a descrição do perfil.
     * @return A descrição (Role) do perfil.
     */
    public String getDescricao() {
        return descricao;
        // Método utilizado para recuperar a String da role.
    }

    /**
     * Método estático capaz de converter um inteiro em um objeto Perfil.
     * Útil quando recebemos o código do banco de dados ou requisição e precisamos saber qual é o Enum.
     * 
     * @param cod O código numérico a ser convertido.
     * @return O objeto Perfil correspondente ao código.
     * @throws IllegalArgumentException caso o código passado não corresponda a nenhum perfil válido.
     */
    public static Perfil toEnum(Integer cod) {
        // Se o código for nulo, retorna nulo imediatamente para evitar erros
        if (cod == null) {
            return null;
        }

        // Percorre todos os valores possíveis desta enumeração (ADMIN, CLIENTE, TECNICO)
        for(Perfil x : Perfil.values()) {
            // Verifica se o código informado é igual ao código do perfil atual no loop
            if(cod.equals(x.getCodigo())) {
                return x; // Retorna o perfil encontrado
            }
        }

        // Se passar por todos e não encontrar, lança uma exceção informando que o ID é inválido
        throw new IllegalArgumentException("Id perfil inválido: " + cod);
    }
}
