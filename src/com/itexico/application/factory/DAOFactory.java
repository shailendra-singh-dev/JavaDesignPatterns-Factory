package com.itexico.application.factory;

import com.itexico.model.ILogDAO;
import com.itexico.model.IPersonDAO;
import com.itexico.model.MySQLLogDAO;
import com.itexico.model.MySQLPersonDAO;

public final class DAOFactory {

  private static final DAOFactory DAO_FACTORY = new DAOFactory();

  public enum FACTORY_TYPE {
    PERSON("Person"), LOG("Log");

    private String mName;

    FACTORY_TYPE(String name) {
      mName = name;
    }

    public String getFactoryName() {
      return mName;
    }
  }

  public IPersonDAO getPersonDAO() {
    return new MySQLPersonDAO();
  }

  public ILogDAO getLogDAO() {
    return new MySQLLogDAO();
  }

  public static DAOFactory getInstance() {
    return DAO_FACTORY;
  }

}
