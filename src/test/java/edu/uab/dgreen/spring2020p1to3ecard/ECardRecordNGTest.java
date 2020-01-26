/*
 * File: ECardRecordNGTest.java
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
 * Test the ECardRecord model.
 * @author David G Green DGreen@uab.edu
 */
public class ECardRecordNGTest {

  ECard ec1;
  ECard ec2;
  ECard ec3;

  ECardRecord ecr1;
  ECardRecord ecr2;
  ECardRecord ecr3;

  public ECardRecordNGTest() {
  }

  /**
   * Set up environment for a test by creating three ecards and three
   * corresponding records.
   *
   * @throws Exception generalized exception (none anticipated)
   */

  @BeforeMethod
  public void setUpMethod() throws Exception {
    ec1 = new ECard();
    ec2 = new ECard();
    ec3 = new ECard();

    ecr1 = new ECardRecord(ec1, "Jim Student", "stu1", 1);
    ecr2 = new ECardRecord(ec2, "Jill Faculty", "fac2", 6);
    ecr3 = new ECardRecord(ec3, "Adeem Visitor", "vis3", 0);
  }

  @AfterMethod
  public void tearDownMethod() throws Exception {
  }

  /**
   * Test of isMatch method, of class ECardRecord.
   */
  @Test
  public void testIsMatch_ECard() {
    assertTrue(ecr1.isMatch(ec1));
    assertTrue(ecr2.isMatch(ec2));
    assertTrue(ecr3.isMatch(ec3));

    assertFalse(ecr1.isMatch(ec2));
    assertFalse(ecr1.isMatch(ec3));

    assertFalse(ecr2.isMatch(ec1));
    assertFalse(ecr2.isMatch(ec3));

    assertFalse(ecr3.isMatch(ec1));
    assertFalse(ecr3.isMatch(ec2));
  }

  /**
   * Test of isMatch method, of class ECardRecord.
   *
   * <p>Note that we can't predict the codes for ec1, ec2, ec3
   * as they are generated for each test and we do not
   * know the order the test will be run.
   */
  @Test
  public void testIsMatch_long() {
    long ec1Code = ec1.getCode();
    long ec2Code = ec2.getCode();
    long ec3Code = ec3.getCode();

    assertTrue(ecr1.isMatch(ec1Code));
    assertTrue(ecr2.isMatch(ec2Code));
    assertTrue(ecr3.isMatch(ec3Code));

    assertFalse(ecr1.isMatch(ec2Code));
    assertFalse(ecr1.isMatch(ec3Code));

    assertFalse(ecr2.isMatch(ec1Code));
    assertFalse(ecr2.isMatch(ec3Code));

    assertFalse(ecr3.isMatch(ec1Code));
    assertFalse(ecr3.isMatch(ec2Code));
  }

  /**
   * Test of getDisplayName method, of class ECardRecord.
   */
  @Test
  public void testGetDisplayName() {
    assertEquals(ecr2.getDisplayName(), "Jill Faculty");
    assertEquals(ecr3.getDisplayName(), "Adeem Visitor");
  }

  /**
   * Test of getBlazerID method, of class ECardRecord.
   */
  @Test
  public void testGetBlazerID() {
    assertEquals(ecr1.getBlazerID(), "stu1");
    assertEquals(ecr2.getBlazerID(), "fac2");
  }

  /**
   * Test of isStudent method, of class ECardRecord.
   */
  @Test
  public void testIsStudent() {
    assertTrue(ecr1.isStudent());
    assertFalse(ecr2.isStudent());
    assertFalse(ecr3.isStudent());
  }

  /**
   * Test of isFaculty method, of class ECardRecord.
   */
  @Test
  public void testIsFaculty() {
    assertFalse(ecr1.isFaculty());
    assertTrue(ecr2.isFaculty());
    assertFalse(ecr3.isFaculty());
  }

  /**
   * Test of isEmployee method, of class ECardRecord.
   */
  @Test
  public void testIsEmployee() {
    assertFalse(ecr1.isEmployee());
    assertTrue(ecr2.isEmployee());
    assertFalse(ecr3.isEmployee());
  }

  /**
   * Test of isVisitor method, of class ECardRecord.
   */
  @Test
  public void testIsVisitor() {
    assertFalse(ecr1.isVisitor());
    assertFalse(ecr2.isVisitor());
    assertTrue(ecr3.isVisitor());
  }

  /**
   * Test of cancel, isCancelled methods, of class ECardRecord.
   */
  @Test
  public void testCancelling() {
    assertFalse(ecr1.isCancelled());
    assertFalse(ecr2.isCancelled());
    assertFalse(ecr3.isCancelled());

    ecr2.cancel();
    ecr3.cancel();

    assertFalse(ecr1.isCancelled());
    assertTrue(ecr2.isCancelled());
    assertTrue(ecr3.isCancelled());

  }

}
