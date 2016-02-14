package com.itexico.model;

public abstract class DAOFactory {

  public enum FACTORY_TYPE {
    MYSQL, ORACLE;
  }

  public abstract IPersonDAO getPersonDAO();

  public abstract ILogDAO getLogDAO();

  public static DAOFactory getDAOFactory(final FACTORY_TYPE factoryType) {
    switch (factoryType) {
      case MYSQL:
        return new MySQLDAOFactory();
      case ORACLE:
        return new OracleDAOFactory();
      default:
        return null;
    }
  }
}
