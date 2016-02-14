package com.itexico.application;

import javax.swing.SwingUtilities;

import com.itexico.controller.Controller;
import com.itexico.model.Model;
import com.itexico.view.View;

public class Application {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        runApp();
      }
    });
  }

  public static void runApp() {
    Model model = new Model();
    View view = new View();
    Controller controller = new Controller(view, model);
    view.setAccountCreatedListener(controller);
  }

}
