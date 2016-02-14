package com.itexico.model;

public class MySQLDAOFactory extends DAOFactory{

  public IPersonDAO getPersonDAO(){
    return new MySQLPersonDAO();
  }
  
  public ILogDAO getLogDAO(){
    return new MySQLLogDAO();
  }
  
}
