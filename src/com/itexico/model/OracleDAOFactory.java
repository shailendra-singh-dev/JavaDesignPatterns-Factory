package com.itexico.model;

public class OracleDAOFactory extends DAOFactory {

  public IPersonDAO getPersonDAO() {
    return new OraclePersonDAO();
  }

  public ILogDAO getLogDAO() {
    return new OracleLogDAO();
  }

}
