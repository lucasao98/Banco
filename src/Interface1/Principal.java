package Interface1;

import Conta.*;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Principal extends JFrame {
    private JLabel label = new JLabel("Introduz");
    private JButton button = new JButton("Saldo");
    private JButton button1 = new JButton("Tranferir");
    private JButton button2 = new JButton("Sacar");
    private JButton button3 = new JButton("Depositar");
    private JButton button4 = new JButton("Editar Dados");
    private JButton button5 = new JButton("Sair");
    private Background back = new Background("D:\\Interface\\400 Menu.png");
    private Font fonte = new Font(Font.SERIF, Font.BOLD, 14);

    private Conta c;

    public Principal(){
        initComponents();
    }


    public Principal(Conta c){
        initComponents();
        this.c = c;
        label.setText("Bem Vindo "+c.getNome()+" ao Banco UESC");
    }

    public Principal(ContaBonificada c){
        initComponents();
        this.c = c;
        label.setText(c.getNome());
    }

    public Principal(ContaPoupanca c){
        initComponents();
        this.c = c;
        label.setText(c.getNome());
    }

    // Função que inicializa os componentes no JFrame
    public void initComponents(){
        // configurações do JFrame
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        // Adiciona a imagem de fundo
        back.setLayout(null);
        back.setSize(400, 400);
        back.setVisible(true);
        add(back);


        label.setFont(fonte);
        label.setBounds(40, 20, 300, 20);
        back.add(label);


        button.setBounds(20, 70, 150, 50);
        back.add(button);
        button.addActionListener(e -> JOptionPane.showMessageDialog(null, "Saldo = R$ " + c.getSaldo()));

        button1.setBounds(220, 70, 150, 50);
        back.add(button1);
        button1.addActionListener(e -> c.transferir());

        button2.setBounds(20, 150, 150, 50);
        back.add(button2);
        button2.addActionListener(e -> c.sacar());

        button3.setBounds(220, 150, 150, 50);
        back.add(button3);
        button3.addActionListener(e -> c.depositar(0));

        button4.setBounds(125, 240, 150, 50);
        back.add(button4);
        button4.addActionListener(e -> {
            dispose();
            new EditarDados(c);
        });

        button5.setBounds(150, 310, 100, 30);
        back.add(button5);
        button5.addActionListener(e -> {
           
                        try{
                            FileOutputStream fw = new FileOutputStream("Cadastros.txt",true);
                            PrintWriter escreve = new PrintWriter(fw);
                            
                            escreve.write(Double.toString(c.getSaldo()));
                            escreve.write(";");
                            escreve.flush();
                            escreve.println("\n");
                            escreve.close();
                            fw.close();
               
          
                            }catch(Exception ex){
                                System.out.println("Erro ao escrever no arquivo");
                            }
                    
                
            
            dispose();
            new Login();
        });
    }

    
}
