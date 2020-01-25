/*
 * File: StringLoggerNGTest.java
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
public class StringLoggerNGTest {

  private StringLogger slog;

  public StringLoggerNGTest() {
  }

  @BeforeMethod
  public void setUpMethod() throws Exception {
    slog = new StringLogger();
  }

  @AfterMethod
  public void tearDownMethod() throws Exception {
  }

  /**
   * Test of log / extractLog methods, of class StringLogger.
   */
  @Test
  public void testExtractLog() {
    slog.log("stu1", "message 1");
    slog.log("fac2", "message 2");
    slog.log("none", "The End");

    String[] expected = {"stu1: message 1",
                         "fac2: message 2",
                         "none: The End"
                        };
    assertEquals(slog.extractLog(), expected);
    
    // should be empty this time
    assertEquals(slog.extractLog(), new String[0]);
  }
}

