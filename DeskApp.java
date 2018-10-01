package deskapp;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class DeskApp extends JFrame implements ActionListener {
 
    Container container=getContentPane();
    JLabel userLabel=new JLabel("Username");
    JLabel passwordLabel=new JLabel("Password");
    JTextField userTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JButton btnlogin=new JButton("Login");
    JButton btnclear =new JButton("Clear");
    JButton btnexit = new JButton("Exit");
    JCheckBox showPassword=new JCheckBox("Show Password");
 
 
    DeskApp()
    {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        //calling addActionEvent() method
        addActionEvent();
 
    }
    //setting the layout manager
   public void setLayoutManager()
   {
       container.setLayout(null);
   }
   //changing the size
   public void setLocationAndSize()
   {
       userLabel.setBounds(50,150,100,30);
       passwordLabel.setBounds(50,220,100,30);
       userTextField.setBounds(150,150,150,30);
       passwordField.setBounds(150,220,150,30);
       showPassword.setBounds(150,250,150,30);
       btnlogin.setBounds(50,300,100,30);
       btnclear.setBounds(200,300,100,30);
       btnexit.setBounds(50, 300, 100, 30);
 
 
   }
   public void addComponentsToContainer()
   {
       container.add(userLabel);
       container.add(passwordLabel);
       container.add(userTextField);
       container.add(passwordField);
       container.add(showPassword);
       container.add(btnlogin); 
       container.add(btnclear);
       container.add(btnexit);
   }
   public void addActionEvent()
   {
      //adding Action listener to components
       btnlogin.addActionListener(this);
       btnclear.addActionListener(this);
       btnexit.addActionListener(this);
       showPassword.addActionListener(this);
   }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {

//To change body of generated methods, choose Tools | Templates.
   if (e.getSource() == btnlogin) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase("bruce") && pwdText.equalsIgnoreCase("1999")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials");
            }
 
        }
        //Coding Part of Clear button
        if (e.getSource() == btnclear) {
            userTextField.setText("");
            passwordField.setText("");
        }
        
        if (e.getSource() == btnexit){
            if (JOptionPane.showConfirmDialog(btnexit, "Confirm if you want to exit", "Login Systems",
				JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION){
				System.exit(0);	
            }
        }
       //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
    }
}