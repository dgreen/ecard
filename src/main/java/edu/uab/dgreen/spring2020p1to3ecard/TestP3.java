/*
 * File: TestP3.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  spring2020p1to3ecard - EE333 Spring 2020
 * Vers: 1.1.0 01/27/2020 dgg - change to use faculty card to change course
 * Vers: 1.0.0 01/24/2020 dgg - initial coding
 */

package edu.uab.dgreen.spring2020p1to3ecard;

/**
 * Test P3 for Spring 2020.
 *
 * @author David G. Green dgreen@uab.edu
 */
public class TestP3 {

  /**
   * Exercise program P3's objects not tested by TestP1, TestP2 or unit tests.
   *
   * @param args command line arguments (unused)
   */
  public static void main(String[] args) {
    println("TestP3");

    // Make a ECardDB to use
    ECardDB db = ECardDB.getInstance();

    ECardLogger logger = new PrintLogger();

    ECardRollUnit eru = new ECardRollUnit();
    eru.initialize("bec267");
    eru.add(logger);

    final ECard ec1 = db.issueCard("First Student", "stu1", 1);
    final ECard ec2 = db.issueCard("Second Student employee", "stu2", 5);
    final ECard ec3 = db.issueCard("Faculty member", "fac1", 2);
    final ECard ecUnknown = new ECard();

    printTestResult(eru.validate(ec3), "appears fac1 course change possible.");
    eru.setCourse("ee333");
    eru.setDay("20200121");

    printTestResult(eru.validate(ec2), "appears stu2 logged.");
    printTestResult(eru.validate(ec1), "appears stu1 logged.");
    printTestResult(!eru.validate(ecUnknown), "appears unknown card not allowed");

    eru.setDay("20200128");
    printTestResult(eru.validate(ec1), "appears stu1 logged.");

    eru.courseRoll("ee333", logger);
    println("Test Passed: appears to show stu1 with two, stu2 with one count");
  }

  // convenience println
  private static void println(String s) {
    System.out.println(s);
  }

  // print s after noting whether or not test passed
  // b will be true if test passed
  private static void printTestResult(boolean b, String s) {
    if (b) {
      println("Test passed: " + s);
    } else {
      println("Test failed: " + s);
    }
  }
}
