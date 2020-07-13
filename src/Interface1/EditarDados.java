package Interface1;

import Conta.*;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class EditarDados extends JFrame {
    private JLabel label = new JLabel("Nome");
    private JLabel label1 = new JLabel("CPF");
    private JLabel label2 = new JLabel("Endereço");
    private JLabel label3 = new JLabel("Email");
    private JLabel label4 = new JLabel("Sexo");
    private JLabel label5 = new JLabel("Tipo");
    private JLabel label6 = new JLabel("Senha");
    private JLabel label7 = new JLabel("Repetir Senha");
    private JTextField text = new JTextField();
    private JTextField text1 = new JTextField();
    private JTextField text2 = new JTextField();
    private JTextField text3 = new JTextField();
    private JPasswordField password = new JPasswordField();
    private JPasswordField password1 = new JPasswordField();
    private JComboBox tipo = new JComboBox<>(new String[]{"Conta Corrente", "Conta Pouopança", "Conta Bonificada"});
    private JComboBox sexo = new JComboBox<>(new String[]{"Masculino", "Feminino"});
    private JButton button = new JButton("Voltar");
    private JButton button1 = new JButton("Salvar");
    private JButton button2 = new JButton("Editar");
    private Background back = new Background("D:\\Interface\\600.png");
    private Font fonte = new Font(Font.SERIF, Font.BOLD, 14);

    private Conta c;

    public EditarDados() {
        initComponents();
    }

    public EditarDados(Conta c){
        initComponents();
        this.c = c;
        setInfo(c);
    }
    public EditarDados(ContaBonificada c){
        initComponents();
        this.c = c;
        setInfo(c);
    }
    public EditarDados(ContaPoupanca c){
        initComponents();
        this.c = c;
        setInfo(c);
    }

    // Função que inicializa os componentes no JFrame
    public void initComponents(){
        // configurações do JFrame
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        // Adiciona a imagem de fundo
        back.setLayout(null);
        back.setSize(600, 500);
        back.setVisible(true);
        add(back);


        /////////////////////////////////////////////////////////////
        label.setFont(fonte);
        label.setBounds(10, 10, 100, 30);
        back.add(label);
        text.setBounds(50, 15, 350, 20);
        text.setEditable(false);
        back.add(text);

        label.setFont(fonte);
        label1.setBounds(10, 50, 100, 30);
        back.add(label1);
        text1.setBounds(50, 55, 350, 20);
        text1.setEditable(false);
        back.add(text1);


        label2.setFont(fonte);
        label2.setBounds(10, 90, 100, 30);
        back.add(label2);
        text2.setBounds(70, 95, 500, 20);
        text2.setEditable(false);
        back.add(text2);



        label3.setFont(fonte);
        label3.setBounds(10, 130, 100, 30);
        back.add(label3);
        text3.setBounds(50, 135, 350, 20);
        text3.setEditable(false);
        back.add(text3);


        label4.setFont(fonte);
        label4.setBounds(10, 170, 100, 30);
        back.add(label4);
        sexo.setBounds(50, 170, 150, 30);
        sexo.setEditable(false);
        back.add(sexo);


        label5.setFont(fonte);
        label5.setBounds(10, 210, 100, 30);
        back.add(label5);
        tipo.setBounds(50, 210, 150, 30);
        tipo.setEditable(false);
        back.add(tipo);


        label6.setFont(fonte);
        label6.setBounds(10, 250, 100, 30);
        back.add(label6);
        password.setBounds(50, 255, 100, 20);
        password.setEditable(false);
        back.add(password);


        label7.setFont(fonte);
        label7.setBounds(10, 290, 100, 30);
        back.add(label7);
        password1.setBounds(100, 295, 100, 20);
        password1.setEditable(false);
        back.add(password1);


        button.setBounds(30, 400, 100, 40);
        back.add(button);
        button.addActionListener(e -> {
            dispose();
            new Principal(c);
        });



        button1.setBounds(460, 400, 100, 40);
        back.add(button1);
        button1.addActionListener(e -> {
            dispose();
            new Principal(c);
            String dados,aux;
            String[] dados1;
            try{    
                FileInputStream arq = new FileInputStream("Cadastros.txt");
                InputStreamReader input = new InputStreamReader(arq);
                BufferedReader ler = new BufferedReader(input);
                
                    
                dados = ler.readLine();
                if(!password.getText().equals(password1.getText())){
                    JOptionPane.showMessageDialog(null,"Senhas Diferentes");
                    password.setText("");
                    password1.setText("");
                    }else{
                    while(dados != null){
                        dados1 = dados.split(";");
                      if((dados1[0].equals(text1.getText()))||(dados1[1].equals(password.getText()))||(dados1[2].equals(text.getText()))||(dados1[3].equals(text3.getText()))||(dados1[4].equals(tipo.getSelectedItem()))||(dados1[5].equals(sexo.getSelectedItem()))||(dados1[6].equals(c.getSaldo()))){
                          dados = ler.readLine();
                          dados = ler.readLine();
                     try{     
                         FileOutputStream fw = new FileOutputStream("Cadastros.txt");
                         PrintWriter escreve = new PrintWriter(fw);
  
                         escreve.write(text1.getText());
                         escreve.write(";");
                         escreve.write(password.getPassword());
                         escreve.write(";");
                         escreve.write(text.getText());
                         escreve.write(";");
                         escreve.write(text2.getText());
                         escreve.write(";");
                         escreve.write(text3.getText());
                         escreve.write(";");
                         escreve.write((String) tipo.getSelectedItem());
                         escreve.write(";");
                         escreve.write((String) sexo.getSelectedItem());
                         escreve.write(";");
                         escreve.println("\n");
                         while (dados != null) {
                             aux = dados;
                             escreve.write(aux);
                             escreve.println("\n");
                             dados = ler.readLine();
                             dados = ler.readLine();
                         }
                     
                       escreve.close();
                       fw.close();
                     }catch(Exception eq){
                         System.out.println("Erro no Arquivo");
                     }
                       JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso!");
                    }else{
                           dados = ler.readLine();
                     }                     
                  }
                }
            }catch(Exception ex){
                System.out.println("Erro no Arquivo");
            }
         
        });

        button2.setBounds(160, 400, 100, 40);
        back.add(button2);
        button2.addActionListener(e -> editar(true));


    }


    // Função para tornar as caixas de texto editáveis
    public void editar(boolean b){
        text.setEditable(b);
        text1.setEditable(b);
        text2.setEditable(b);
        text3.setEditable(b);
        password.setEditable(b);
        password1.setEditable(b);
    }


    // Função que coloca os dados dos objetos nas caixas de texto para edição
    public void setInfo(Conta c){
        text.setText(c.getNome());
        text1.setText(String.valueOf(c.getCpf()));
        text2.setText(c.getEmail());
        text3.setText(c.getEndereco());
        password.setText(String.valueOf(c.getSenha()));
        password1.setText(String.valueOf(c.getSenha()));

    }
}
