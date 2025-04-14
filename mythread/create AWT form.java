package mythread;

import java.awt.*;
import java.awt.event.*;

 class LoginExample {
    public static void main(String[] args){
        Frame frame = new Frame("AWT Login Form");

        Label userLabel = new Label("Username:");
        userLabel.setBounds(50,50,100,30);
        TextField userText = new TextField();
        userText.setBounds(150,50,150,30);

        Label passLabel = new Label("Password:");
        passLabel.setBounds(50,100,100,30);
        TextField passText = new TextField();
        passText.setBounds(150,100,150,30);
        passText.setEchoChar('*');

        Button loginButton = new Button("Login");
        loginButton.setBounds(150,150,80,30);

        Label result = new Label();
        result.setBounds(50,200,300,30);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String username = userText.getText();
                String password = passText.getText();
                if(username.equals("admin")&& password.equals("1234")){
                    result.setText("Login Successfull");
                } else{
                    result.setText("Invalid Username or Password.");
                }
            }
            
        });
        frame.add(userLabel);
        frame.add(userText);
        frame.add(passLabel);
        frame.add(passText);
        frame.add(loginButton);
        frame.add(result);

        frame.setSize(400,300);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                frame.dispose();
            }
        });
      }
    }
