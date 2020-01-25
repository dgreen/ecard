/*
 * File: ECardRollUnitNGTest.java
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
public class ECardRollUnitNGTest {

  private ECardDB ecdb;
  private ECardRollUnit ecru1;
  private ECardRollUnit ecru2;

  StringLogger logger;

  ECard ec1;
  ECard ec2;
  ECard ec3;
  ECard ec4;
  ECard ecUnknown = new ECard();

  public ECardRollUnitNGTest() {
  }

  @BeforeMethod
  public void setUpMethod() throws Exception {
    ecdb = ECardDB.getInstance();

    ec1 = ecdb.issueCard("Joe Student", "stu1", 1);
    ec2 = ecdb.issueCard("Jill Faculty", "fac2", 6);
    ec3 = ecdb.issueCard("Adeem Visitor", "vis1", 0);
    ec4 = ecdb.issueCard("Siri Student", "stu2", 1);

    logger = new StringLogger();

    ecru1 = new ECardRollUnit();

    ecru1.add(logger);
    ecru1.initialize("bec267");

    ecru2 = new ECardRollUnit();
    ecru2.initialize("bec155");
    ecru2.add(logger);
  }

  @AfterMethod
  public void tearDownMethod() throws Exception {
  }

  /**
   * Test of valid method, of class ECardRollUnit.
   */
  @Test
  public void testValid() {
    assertTrue(ecru1.validate(ec1));

    String[] expected = {
      "stu1: Green Light Flash (bec267)"
    };

    assertEquals(logger.extractLog(), expected);
  }

  /**
   * Test of invalid method, of class ECardRollUnit.
   */
  @Test
  public void testInvalid_long() {
    assertTrue(ecru1.validate(ec3) == false);

    String[] expected = {
      "vis1: Red Light Flash (bec267)"
    };

    assertEquals(logger.extractLog(), expected);
  }

  /**
   * Test of invalid method, of class ECardRollUnit.
   */
  @Test
  public void testInvalid_String() {
    assertTrue(ecru1.validate(ecUnknown) == false);

    String[] expected = {
      "" + ecUnknown.getCode() + ": Red Light Flash (bec267)"
    };

    assertEquals(logger.extractLog(), expected);
  }

  /**
   * Test of courseRoll method, of class ECardRollUnit.
   */
  @Test
  public void testCourseRoll() {

    ecru1.setCourse("ee333");
    ecru1.setDay("20200121");
    assertTrue(ecru1.validate(ec4));
    assertTrue(ecru1.validate(ec1));

    StringLogger rollReport = new StringLogger();

    String[] expected1 = {
      "stu1: 1",
      "stu2: 1"
    };
    ecru1.courseRoll("ee333", rollReport);
    assertEquals(rollReport.extractLog(), expected1);

    ecru1.setCourse("ee499");
    assertTrue(ecru1.validate(ec4));

    ecru1.setDay("20200128");
    ecru1.setCourse("ee333");
    assertTrue(ecru1.validate(ec4));

    String[] expected2 = {
      "stu1: 1",
      "stu2: 2"
    };
    ecru1.courseRoll("ee333", rollReport);
    assertEquals(rollReport.extractLog(), expected2);
  }

}
