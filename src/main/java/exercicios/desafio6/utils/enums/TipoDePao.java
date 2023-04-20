package exercicios.desafio6.utils.enums;

public enum TipoDePao {
    BRIOCHE("brioche"),
    FRANCES("francês"),
    HAMBURGUER("hamburguer");

    private String valor;
    TipoDePao(String valor) {
        this.valor = valor;
    }
}
