package com.itexico.model;

import java.sql.SQLException;
import java.util.List;



public interface IPersonDAO {

  public abstract void addPerson(final Person person);

  public abstract Person getPerson(int id);

  public abstract List<Person> getPeople() throws SQLException;

  public abstract int updatePerson(Person person);

  public abstract int deletePerson(int id);

  public abstract int deleteAll();

}
