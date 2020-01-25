/*
 * File: ECardDBNGTest.java
 * Author: David G Green DGreen@uab.edu
 * Assignment:  spring2020p1to3ecard - EE333 Spring 2020
 * Vers: 1.0.0 01/25/2020 dgg - initial coding
 */
package edu.uab.dgreen.spring2020p1to3ecard;

import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author David G Green DGreen@uab.edu
 */
public class ECardDBNGTest {

  ECardDB ecdb1;
  ECardDB ecdb2;
  
  ECard ec1;
  ECard ec2;
  ECard ec3;
  ECard invalid;
  
  public ECardDBNGTest() {
  }

  @BeforeMethod
  public void setUpMethod() throws Exception {
    ecdb1 = ECardDB.getInstance();
    ecdb2 = ECardDB.getInstance();
    
    ec1 = ecdb1.issueCard("Joe Student", "stu1", 1);
    ec2 = ecdb1.issueCard("Jill Faculty", "fac2", 6);
    ec3 = ecdb1.issueCard("Adeem Visitor", "vis1", 0);
  }

  @AfterMethod
  public void tearDownMethod() throws Exception {
  }

  /**
   * Test of getInstance method, of class ECardDB.
   * 
   * Verify all calls get same object.
   */
  @Test
  public void testGetInstance() {
    assertTrue(ecdb1 == ecdb2);
  }

  /**
   * Test of validate method, of class ECardDB.
   */
  @Test
  public void testValidate() {
    assertTrue(ecdb1.validate(ec1) != null);
    assertTrue(ecdb1.validate(ec2) != null);
    assertTrue(ecdb1.validate(ec3) != null);
    assertTrue(ecdb1.validate(new ECard()) == null);
    
    ECardRecord ecr1 = ecdb1.validate(ec1);
    assertEquals(ecr1.getBlazerID(), "stu1");
    assertEquals(ecr1.getDisplayName(), "Joe Student");
    assertTrue(ecr1.isStudent());
    assertTrue(ecr1.isFaculty() == false);
    assertTrue(ecr1.isVisitor() ==  false);
    assertTrue(ecr1.isCancelled() == false);
    assertTrue(ecr1.isMatch(ec1));
  }

  /**
   * Test of cancel method, of class ECardDB.
   */
  @Test
  public void testCancel_long() {
    
    assertTrue(ecdb1.validate(ec1) != null);
    
    ecdb1.cancel(ec1.getCode());
    
    assertTrue(ecdb1.validate(ec1) == null);
  }

  /**
   * Test of cancel method, of class ECardDB.
   */
  @Test
  public void testCancel_String() {
    
    assertTrue(ecdb1.validate(ec2) != null);
    
    ecdb1.cancel("fac2");
    
    assertTrue(ecdb1.validate(ec2) == null);
  }

  /**
   * Test of issueCard method, of class ECardDB.
   */
  @Test
  public void testIssueCard() {
 
    // no additional tests seem to be needed at this time.
  
  }

}
