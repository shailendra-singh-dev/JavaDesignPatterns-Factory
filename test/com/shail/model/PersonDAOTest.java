package com.shail.model;

import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.shail.application.factory.DAOFactory;
import com.shail.model.Database;
import com.shail.model.IPersonDAO;
import com.shail.model.Person;

public class PersonDAOTest {

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    Database.getInstance().disconnect();
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    Database.getInstance().disconnect();
  }

  @Before
  public void setUp() throws Exception {
    IPersonDAO personDAOTest = DAOFactory.getInstance().getPersonDAO();
    personDAOTest.deleteAll();
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testAddPerson() throws SQLException {
    fail("Not yet implemented");
    IPersonDAO personDAO = DAOFactory.getInstance().getPersonDAO();

    Person person1 = new Person(111, "Shail", "shail");
    personDAO.addPerson(person1);
    Person person2 = new Person(111, "Swati", "swati");
    personDAO.addPerson(person2);

    personDAO.addPerson(person1);
    personDAO.addPerson(person2);

    List<Person> people = personDAO.getPeople();
    Assert.assertEquals("These two person should be same", person1, people.get(0));
    Assert.assertEquals("These two person should be same", person2, people.get(1));
  }

  @Test
  public void testGetPerson() {
    fail("Not yet implemented");
  }

  @Test
  public void testGetPeople() {
    fail("Not yet implemented");
  }

  @Test
  public void testUpdatePerson() {
    fail("Not yet implemented");
  }

}
