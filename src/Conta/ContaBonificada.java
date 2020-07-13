package Conta;

/**
 * Rende um Bônus a cada depósito
 */

public class ContaBonificada extends Conta {
    private static double bonus = 0;

    public ContaBonificada(){
        super(); // Construtor da superclasse
    }

    //Sobrescreve a função de deposito
    @Override
    public void depositar(double valor) {
        bonus += valor * 0.01;
        super.depositar(valor);
    }

    // atribuir o bonus adiquirido a conta
    public void renderBonus(){
        super.depositar(bonus);
        bonus = 0;
    }
}
