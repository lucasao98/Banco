package Interface1;

import Conta.*;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Cadastro extends JFrame {
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
    private JComboBox tipo = new JComboBox<>(new String[]{"","Conta Corrente", "Conta Poupança", "Conta Bonificada"});
    private JComboBox sexo = new JComboBox<>(new String[]{"","Masculino", "Feminino"});
    private JButton button = new JButton("Voltar");
    private JButton button1 = new JButton("Cadastrar");
    private Background back = new Background("D:\\Interface\\600.png");
    private Font fonte = new Font(Font.SERIF, Font.BOLD, 14);
    Conta c = new Conta();
    
    public Cadastro(){
        initComponents();
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
        back.add(text);


        label.setFont(fonte);
        label1.setBounds(10, 50, 100, 30);
        back.add(label1);
        text1.setBounds(50, 55, 350, 20);
        back.add(text1);


        label2.setFont(fonte);
        label2.setBounds(10, 90, 100, 30);
        back.add(label2);
        text2.setBounds(70, 95, 500, 20);
        back.add(text2);


        label3.setFont(fonte);
        label3.setBounds(10, 130, 100, 30);
        back.add(label3);
        text3.setBounds(50, 135, 350, 20);
        back.add(text3);


        label4.setFont(fonte);
        label4.setBounds(10, 170, 100, 30);
        back.add(label4);
        sexo.setBounds(50, 170, 150, 30);
        back.add(sexo);


        label5.setFont(fonte);
        label5.setBounds(10, 210, 100, 30);
        back.add(label5);
        tipo.setBounds(50, 210, 150, 30);
        back.add(tipo);


        label6.setFont(fonte);
        label6.setBounds(10, 250, 100, 30);
        back.add(label6);
        password.setBounds(50, 255, 100, 20);
        back.add(password);


        label7.setFont(fonte);
        label7.setBounds(10, 290, 100, 30);
        back.add(label7);
        password1.setBounds(100, 295, 100, 20);
        back.add(password1);


        button.setBounds(30, 400, 100, 40);
        back.add(button);
        button.addActionListener(e -> {
            dispose();
            new Login();
        });



        button1.setBounds(460, 400, 100, 40);
        back.add(button1);
        button1.addActionListener(e -> {
            /**
             * Função para gravação no arquivo
             *
             * Usando esse método de escrita é possível fazer split na leitura para recuperação de dados
             */
            if(!password.getText().equals(password1.getText())){
                JOptionPane.showMessageDialog(null,"Senhas Diferentes");
                password.setText("");
                password1.setText("");
            }else{
            try{
                FileOutputStream fw = new FileOutputStream("Cadastros.txt",true);
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
                escreve.flush();

                escreve.close();
                fw.close();
               
                JOptionPane.showMessageDialog(null,"Cadastrado Com Sucesso");          
          
            }catch(Exception ex){
                System.out.println("Erro ao escrever no arquivo");
            }
            text1.setText("");
            password.setText("");
            password1.setText("");
            text.setText("");
            text2.setText("");
            text3.setText("");
            tipo.setSelectedItem("");
            sexo.setSelectedItem("");
            }
        });

    }


}
