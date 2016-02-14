package com.shail.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.shail.model.Database;
import com.shail.model.Model;
import com.shail.model.Person;

public class View extends JFrame implements ActionListener {

  private JButton okButton;
  private JTextField nameField;
  private JPasswordField passField;

  private JPasswordField repeatPassField;

  private IAccountCreatedListener mIAccountCreatedListener;

  public interface IAccountCreatedListener {
    public void accountCreated(Person person);
  }

  public View() {
    super("DesignPatterns-Beans");
    nameField = new JTextField(10);
    passField = new JPasswordField(10);
    repeatPassField = new JPasswordField(10);
    okButton = new JButton("Create user");

    setLayout(new GridBagLayout());

    GridBagConstraints gc = new GridBagConstraints();
    gc.anchor = GridBagConstraints.LAST_LINE_END;
    gc.gridx = 1;
    gc.gridy = 1;
    gc.weightx = 1;
    gc.weighty = 1;
    gc.insets = new Insets(100, 0, 0, 10);
    gc.fill = GridBagConstraints.NONE;

    add(new JLabel("Name: "), gc);

    gc.anchor = GridBagConstraints.LAST_LINE_START;
    gc.gridx = 2;
    gc.gridy = 1;
    gc.weightx = 1;
    gc.weighty = 1;
    gc.insets = new Insets(100, 0, 0, 0);
    gc.fill = GridBagConstraints.NONE;

    add(nameField, gc);

    gc.anchor = GridBagConstraints.LINE_END;
    gc.gridx = 1;
    gc.gridy = 2;
    gc.weightx = 1;
    gc.weighty = 1;
    gc.insets = new Insets(0, 0, 0, 10);
    gc.fill = GridBagConstraints.NONE;

    add(new JLabel("Password: "), gc);

    gc.anchor = GridBagConstraints.LINE_START;
    gc.gridx = 2;
    gc.gridy = 2;
    gc.weightx = 1;
    gc.weighty = 1;
    gc.insets = new Insets(0, 0, 0, 0);
    gc.fill = GridBagConstraints.NONE;

    add(passField, gc);

    gc.anchor = GridBagConstraints.LINE_END;
    gc.gridx = 1;
    gc.gridy = 3;
    gc.weightx = 1;
    gc.weighty = 1;
    gc.insets = new Insets(0, 0, 0, 10);
    gc.fill = GridBagConstraints.NONE;

    add(new JLabel("Repeat password: "), gc);

    gc.anchor = GridBagConstraints.LINE_START;
    gc.gridx = 2;
    gc.gridy = 3;
    gc.weightx = 1;
    gc.weighty = 1;
    gc.insets = new Insets(0, 0, 0, 0);
    gc.fill = GridBagConstraints.NONE;

    add(repeatPassField, gc);

    gc.anchor = GridBagConstraints.FIRST_LINE_START;
    gc.gridx = 2;
    gc.gridy = 4;
    gc.weightx = 1;
    gc.weighty = 100;
    gc.fill = GridBagConstraints.NONE;

    add(okButton, gc);

    okButton.addActionListener(this);

    setSize(600, 500);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);

    addWindowListener(new WindowAdapter() {
      @Override
      public void windowOpened(WindowEvent e) {
        super.windowOpened(e);
        try {
          Database.getInstance().connect();
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }

      @Override
      public void windowClosing(WindowEvent e) {
        super.windowClosed(e);
        Database.getInstance().disconnect();
      }

    });
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String personName = nameField.getText();
    String password = passField.getText();
    Person person =new Person();
    person.setID(11111);
    person.setName(personName);
    person.setPassword(password);
    mIAccountCreatedListener.accountCreated(person);
    
  }

  public void setAccountCreatedListener(IAccountCreatedListener accountCreatedListener) {
    mIAccountCreatedListener = accountCreatedListener;
  }

}
