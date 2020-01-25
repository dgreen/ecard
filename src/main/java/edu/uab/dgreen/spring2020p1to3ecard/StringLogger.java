/*
 * File: StringLogger.java
 * Author: David G Green DGreen@uab.edu
 * Assignment:  spring2020p1to3ecard - EE333 Spring 2020
 * Vers: 1.0.0 01/25/2020 dgg - initial coding
 */
package edu.uab.dgreen.spring2020p1to3ecard;

import java.util.ArrayList;

/**
 * A ECardLogger which logs the strings to a string array that can be retrieved.
 * @author David G Green DGreen@uab.edu
 */
public class StringLogger implements ECardLogger {
  
  private ArrayList<String> entries;

  /**
   * Create a StringLogger.
   */
  public StringLogger() {
    entries = new ArrayList<>();
  }
  
  /**
   * Create a log entry.
   * @param blazerID user code
   * @param message text
   */
  @Override
  public void log(String blazerID, String message) {
    entries.add(blazerID + ": " + message);
  }
  
  /**
   * Return an array matching content and reset log.
   * @return an array containing the strings written.
   */
  public String[] extractLog() {
    String[] log = entries.toArray(String[]::new);
    entries.clear();
    return log;
  }
  
}
