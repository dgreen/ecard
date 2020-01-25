/*
 * File: RollRecordNGTest.java
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
 * Quick test of RollRecord -- very unlikely to have problems at present level
 *
 * @author David G Green DGreen@uab.edu
 */
public class RollRecordNGTest {

  private RollRecord rr;

  public RollRecordNGTest() {
  }

  @BeforeMethod
  public void setUpMethod() throws Exception {
    rr = new RollRecord("ee333", "20200121", "stu1");
  }

  @AfterMethod
  public void tearDownMethod() throws Exception {
  }

  /**
   * Test of getBlazerID method, of class RollRecord.
   */
  @Test
  public void testGetBlazerID() {
    assertEquals(rr.getBlazerID(), "stu1");
  }

  /**
   * Test of getCourse method, of class RollRecord.
   */
  @Test
  public void testGetCourse() {
    assertEquals(rr.getCourse(), "ee333");
  }

  /**
   * Test of getDay method, of class RollRecord.
   */
  @Test
  public void testGetDay() {
    assertEquals(rr.getDay(), "20200121");
  }

}
