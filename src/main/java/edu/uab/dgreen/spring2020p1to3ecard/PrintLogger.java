/*
 * File: PrintLogger.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  spring2020p1to3ecard - EE333 Spring 2020
 * Vers: 1.0.0 01/18/2020 dgg - initial coding
 */

package edu.uab.dgreen.spring2020p1to3ecard;

public class PrintLogger {

  /**
   * Log message with blazerid and message to stdout.
   *
   * @param blazerID user associated with action being logged
   * @param message action being logged
   */
  public void log(String blazerID, String message) {
    System.out.println(blazerID + ": " + message);
  }
}
