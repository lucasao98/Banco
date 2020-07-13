package Conta;

import javax.swing.*;
import java.io.*;


public class ContaCadastro {
    String dados;

    public void cadastrar(Conta c){
        try{
            FileWriter arq = new FileWriter("Conta1.txt",true);
            PrintWriter esc = new PrintWriter(arq);
            esc.println(c.getCpf());
            esc.println(c.getSenha());
            esc.println(c.getNome());
            esc.println(c.getEndereco());
            esc.println(c.getSexo());

            esc.close();
            arq.close();

        }catch(Exception e){
            System.out.println("Erro no Arquivo");
        }
        System.out.println("Cadastro Realizado com Sucesso!!");
    }

    public void cadastrar(ContaBonificada c){
        try{
            FileOutputStream arq = new FileOutputStream("ContasBonificada.txt",true);
            PrintWriter esc = new PrintWriter(arq);

            esc.println(c.getCpf());
            esc.println(c.getSenha());
            esc.println(c.getNome());
            esc.println(c.getEndereco());
            esc.println(c.getSexo());


            esc.close();
            arq.close();

        }catch(Exception ex){
            System.out.println("Erro no Arquivo");
        }
        System.out.println("Cadastro Realizado com Sucesso!!");
    }

    public void cadastrar(ContaPoupanca c) {
        try {
            FileOutputStream arq = new FileOutputStream("ContaPoupanca.txt", true);
            PrintWriter esc = new PrintWriter(arq);

            esc.println(c.getCpf());
            esc.println(c.getSenha());
            esc.println(c.getNome());
            esc.println(c.getEndereco());
            esc.println(c.getSexo());


            esc.close();
            arq.close();

        } catch (Exception exc) {
            System.out.println("Erro no Arquivo");
        }
        System.out.println("Cadastro Realizado com Sucesso!!");
    }



//    public void lerArq(){
//        try{
//            FileInputStream arq = new FileInputStream("Cadastros.txt");
//            InputStreamReader input =new InputStreamReader(arq);
//            BufferedReader ler = new BufferedReader(input);
//
//            dados = ler.readLine();
//            while(dados != null){
//                if(dados.equals(campologin.getText())){
//                    dados = ler.readLine();
//                    if(dados.equals(camposenha.getText())){
//                        JOptionPane.showMessageDialog(null,"Uusário Cadastrado");
//                        System.exit(0);
//                    }
//                    else{
//                        JOptionPane.showMessageDialog(null,"Uusário Não Cadastrado");
//                    }
//                }else{
//                    dados = ler.readLine();
//                }
//                JOptionPane.showMessageDialog(null,"Uusário Não Cadastrado");
//                System.exit(0);
//            }
//
//
//        }catch(Exception ex){
//            System.out.println("Erro no Arquivo");
//        }
//    }





}