/*
 * File: TestP2.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  spring2020p1to3ecard - EE333 Spring 2020
 * Vers: 1.0.0 01/20/2020 dgg - initial coding
 */

package edu.uab.dgreen.spring2020p1to3ecard;

/**
 * Test P2 for Spring 2020.
 *
 * @author David G. Green dgreen@uab.edu
 */
public class TestP2 {

  /**
   * Exercise program P2's objects not tested by TestP1.
   *
   * @param args command line arguments (unused)
   */
  public static void main(String[] args) {
    println("TestP2");

    // Make a ECardDB to use
    ECardDB db = ECardDB.getInstance();
    ECardDB dbAgain = ECardDB.getInstance();

    printTestResult(db == dbAgain, "Singleton implemented.");

    ECardLogger logger = new PrintLogger();

    Lock lock1 = new Lock();
    lock1.initialize("lock1loc");
    lock1.add("stu1");
    lock1.add("fac2");
    lock1.add(logger);

    Lock lock2 = new Lock();
    lock2.initialize("lock2loc");
    lock2.add("fac2");
    lock2.add("vis1");
    lock2.add(logger);

    ECard ec1 = db.issueCard("First Student", "stu1", 1);
    ECard ec2 = db.issueCard("Second Faculty/Employee", "fac2", 6);
    ECard ec3 = db.issueCard("Third visitor", "vis1", 0);
    ECard ecUnknown = new ECard();

    printTestResult(lock1.validate(ec1), "Appears to have allowed access with stu1 at lock1loc");
    printTestResult(lock1.validate(ec2), "Appears to have allowed access with fac2 at lock1loc");
    printTestResult(!lock1.validate(ec3), "Appears to have denied access with vis1 at lock1loc");
    printTestResult(!lock1.validate(ecUnknown),
        "Appears to have denied access with non-registered card at lock1loc");

    printTestResult(!lock2.validate(ec1), "Appears to have denied access with stu1 at lock2loc");
    printTestResult(lock2.validate(ec2), "Appears to have allowed access with fac2 at lock2loc");
    printTestResult(lock2.validate(ec3), "Appears to have allowed access with vis1 at lock2loc");
    printTestResult(!lock2.validate(ecUnknown),
        "Appears to have denied access with non-registered card at lock2loc");
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
