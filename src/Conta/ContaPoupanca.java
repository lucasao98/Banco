package Conta;

/**
 * conta apenas para render juros
 */

public class ContaPoupanca extends Conta {
    private final double juros = 1.02;

    public ContaPoupanca(){
        super(); // construtor da superclasse
    }

    // aplica os juros ao saldo
    public void renderJuros(){
        this.setSaldo(this.getSaldo() * juros);
    }
}
