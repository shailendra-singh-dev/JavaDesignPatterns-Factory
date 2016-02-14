package com.shail.controller;

import java.sql.Date;

import javax.security.auth.spi.LoginModule;
import javax.xml.bind.DataBindingException;

import com.shail.application.factory.DAOFactory;
import com.shail.model.ILogDAO;
import com.shail.model.IPersonDAO;
import com.shail.model.Log;
import com.shail.model.Model;
import com.shail.model.Person;
import com.shail.view.LoginFormEvent;
import com.shail.view.View;
import com.shail.view.View.IAccountCreatedListener;

public class Controller implements IAccountCreatedListener {
  private View mView;
  private Model mModel;
  private IPersonDAO mPersonDAO = DAOFactory.getInstance().getPersonDAO();
  private ILogDAO mLogDAO = DAOFactory.getInstance().getLogDAO();

  public Controller(View view, Model model) {
    this.mView = view;
    this.mModel = model;
  }

  @Override
  public void accountCreated(Person person) {
    System.out.println("\n Account creation event received: " + person.getName() + "; "
        + person.getPassword());
    mPersonDAO.addPerson(person);
    long time = System.currentTimeMillis();
    Date currentDate = new Date(time);
    mLogDAO.addLog(new Log(111, currentDate, "Account created.."));
  }

  public void clean() {
    mPersonDAO = null;
    mLogDAO = null;
    mView = null;
    mModel = null;
  }
}
