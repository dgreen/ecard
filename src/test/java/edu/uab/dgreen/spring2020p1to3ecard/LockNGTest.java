/*
 * File: LockNGTest.java
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
public class LockNGTest {

  private ECardDB ecdb;
  private Lock lock1;
  private Lock lock2;

  StringLogger logger;

  ECard ec1;
  ECard ec2;
  ECard ec3;
  ECard ecUnknown = new ECard();

  public LockNGTest() {
  }

  @BeforeMethod
  public void setUpMethod() throws Exception {
    ecdb = ECardDB.getInstance();

    ec1 = ecdb.issueCard("Joe Student", "stu1", 1);
    ec2 = ecdb.issueCard("Jill Faculty", "fac2", 6);
    ec3 = ecdb.issueCard("Adeem Visitor", "vis1", 0);

    logger = new StringLogger();

    lock1 = new Lock();
    lock1.add(logger);
    lock1.initialize("bec267");
    lock1.add("stu1");
    lock1.add("fac2");

    lock2 = new Lock();
    lock2.initialize("lock2loc");
    lock2.add("fac2");
    lock2.add("vis1");
    lock2.add(logger);
  }

  @AfterMethod
  public void tearDownMethod() throws Exception {
  }

  /**
   * Test of valid method through validate of good card with access permission, of class Lock.
   */
  @Test
  public void testValid() {
    assertTrue(lock1.validate(ec1));

    String[] expected = {
      "stu1: Unlock (bec267)",
      "stu1: Green light on (bec267)",
      "stu1: Waiting access time (bec267)",
      "stu1: Lock (bec267)",
      "stu1: Green light off (bec267)"
    };

    assertEquals(logger.extractLog(), expected);
  }

  /**
   * Test of invalid method through validate of good card without access, of class Lock.
   */
  @Test
  public void testInvalid_String() {
    assertTrue(lock1.validate(ec3) == false);

    String[] expected = {
      "vis1: Red light on (bec267)",
      "vis1: Waiting display time (bec267)",
      "vis1: Red light off (bec267)"
    };

    assertEquals(logger.extractLog(), expected);
  }

  /**
   * Test of invalid method through validate bad card, of class Lock.
   */
  @Test
  public void testInvalid_long() {
    assertTrue(lock1.validate(ecUnknown) == false);

    long code = ecUnknown.getCode();

    String[] expected = {
      "" + code + ": Red light on (bec267)",
      "" + code + ": Waiting display time (bec267)",
      "" + code + ": Red light off (bec267)"
    };

    assertEquals(logger.extractLog(), expected);
  }

  /**
   * Test of alarm and reset methods, of class Lock.
   */
  @Test
  public void testAlarm() {
    String[] expected1 = {
      ": Alarming (bec267)"
    };

    lock1.alarm();
    assertEquals(logger.extractLog(), expected1);

    String[] expected2 = {
      ": Alarm off (bec267)"
    };

    lock1.reset();
    assertEquals(logger.extractLog(), expected2);
  }

}
