/*
 * File: ECardNGTest.java
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
 * Test an ECard.
 * @author David G Green DGreen@uab.edu
 */
public class ECardNGTest {

  public ECardNGTest() {
  }

  @BeforeMethod
  public void setUpMethod() throws Exception {
  }

  @AfterMethod
  public void tearDownMethod() throws Exception {
  }

  /**
   * Test of getCode method, of class ECard.
   * Cards with leading 0's to make 10 digits are not allowed.
   */
  @Test
  public void testCodes() {
    ECard ec1 = new ECard();
    ECard ec2 = new ECard();
    ECard ec3 = new ECard();

    assertTrue(ec1.getCode() >= 1000000000L
        && ec1.getCode() < 10000000000L,
        "ec1 10 digit");
    assertTrue(ec2.getCode() >= 1000000000L
        && ec2.getCode() < 10000000000L,
        "ec2 10 digit");
    assertTrue(ec3.getCode() >= 1000000000L
        && ec3.getCode() < 10000000000L,
        "ec3 10 digit");

    assertTrue(ec1.getCode() != ec2.getCode()
        && ec1.getCode() != ec3.getCode()
        && ec2.getCode() != ec3.getCode(),
        "code uniqueness test");
  }

}