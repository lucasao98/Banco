package Interface1;


import Conta.*;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Login extends JFrame {
    private JLabel label1 = new JLabel("CPF");
    private JLabel label2 = new JLabel("Senha");
    private JTextField txt = new JTextField();
    private JPasswordField password = new JPasswordField();
    private JButton button1 = new JButton("Entrar");
    private JButton button2 = new JButton("Cadastrar");
    private JButton button3 = new JButton("Sair");
    private Background back = new Background("D:\\Interface\\400 Entrar.png");
    ContaCadastro c;
    private Font letra = new Font(Font.SERIF, Font.BOLD, 18);
    

    public Login(){
        initComponents();
    }

    public Login(ContaCadastro c){
        initComponents();
        this.c = c;
    }

    // Função que inicializa os componentes no JFrame
    public void initComponents(){
        // configurações do JFrame
        setBounds(100, 100, 400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);


        // Adiciona a imagem de fundo
        back.setSize(400, 400);
        back.setVisible(true);
        back.setLayout(null);
        add(back);






        ////////////////////////////////////////////////////////
        label1.setBounds(170, 30, 200, 50);
        label1.setFont(letra);
        back.add(label1);
        txt.setBounds(100, 70, 200, 30);
        back.add(txt);


        label2.setBounds(170, 140, 200, 50);
        label2.setFont(letra);
        back.add(label2);
        password.setBounds(100, 180, 200, 30);
        back.add(password);


        button3.setBounds(10, 320, 100, 30);
        back.add(button3);
        button3.addActionListener(e -> dispose());


        button2.setBounds(140, 320, 100, 30);
        back.add(button2);
        button2.addActionListener(e -> {
            dispose();
            new Cadastro();
        });


        button1.setBounds(280, 320, 100, 30);
        back.add(button1);
        button1.addActionListener(e -> {
            /**
             * Função busca no arquivo e retorna objeto conta
             */

            Conta c = new Conta();
            String dados;
            String[] dados1;
            String nulo = "";
            try{
                FileInputStream arq = new FileInputStream("Cadastros.txt");
                InputStreamReader input = new InputStreamReader(arq);
                BufferedReader ler = new BufferedReader(input);

                dados = ler.readLine();
                if((nulo.equals(txt.getText()))||(nulo.equals(password.getText()))){
                    txt.setBackground(Color.red);
                    password.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null,"Dados Inválidos");
                    dispose();
                    new Login();
                }else{                
                while(dados != null){
                    dados1 = dados.split(";");
                    if(dados1[0].equals(txt.getText())){
                        if(dados1[1].equals(password.getText())){
                            c.setCpf(Integer.parseInt(dados1[0]));
                            c.setSenha(Integer.parseInt(dados1[1]));
                            c.setNome(dados1[2]);
                            c.setEndereco(dados1[3]);
                            c.setEmail(dados1[4]);
                            c.setSexo(dados1[5]);
                            JOptionPane.showMessageDialog(null,"Login Efetuado com Sucesso");
                            dados = null;
                            dispose();
                            new Principal(c);
                        }else{
                            JOptionPane.showMessageDialog(null,"Usuário Não Cadastrado");
                            dados = null;
                            dispose();
                            new Login();
                        }
                    }else{
                        dados = ler.readLine();
                    }
                 }
                }
                arq.close();
            }catch(Exception ex){
                System.out.println("Erro no Arquivo");
            }          
        });
    }


}
