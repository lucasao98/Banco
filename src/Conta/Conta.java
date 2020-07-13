package Conta;

import javax.swing.JOptionPane;

/**
 * Classe de conta base, com os métodos essenciais
 */

public class Conta extends Cliente {
    private static int proxNum = 1; // variável estática para garantir números diferentes

    public Conta(){
        this.setSaldo(0);
        this.setNumConta(proxNum); //atribui o numero da conta
        proxNum++;  // incrementa a variável estática
    }


    public void depositar(double valor){
        if(valor == 0) { // condição usada apenas na interface gráfica
            valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor para depósito."));
        }
        if (valor > 0) {
            this.setSaldo(this.getSaldo() + valor);
            JOptionPane.showMessageDialog(null, "Depósito Efetuado com Sucesso!!");
        }else{
            JOptionPane.showMessageDialog(null, "Valor Inválido. Tente Novamente!");
        }

    }

    public void sacar(){
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor para saque."));
        if(this.getSaldo() <= 0){
            JOptionPane.showMessageDialog(null, "Operação Inválida. Saldo Negativo/Zerado");
        }else if((this.getSaldo() >= valor) && (valor > 0)){
            this.setSaldo(this.getSaldo() - valor);
            JOptionPane.showMessageDialog(null, "Saque Efetuado com Sucesso!!");
        }else{
            JOptionPane.showMessageDialog(null, "Valor Inválido. Tente Novamente");
        }
    }

    public void transferir(){
        int destino = Integer.parseInt(JOptionPane.showInputDialog("Digite o CPF da conta para a transferência"));
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor para a transferência."));
        if((this.getSaldo()> 0)&&(this.getSaldo() >= valor)){
            this.setSaldo(this.getSaldo() - valor);  
            JOptionPane.showMessageDialog(null, "Valor Transferido com Sucesso");
        }
        
    }

    public static void setProxNum(int proxNum) {
        Conta.proxNum = proxNum;
    }

    public static int getProxNum() {
        return proxNum;
    }
    
}
