/*
 * File: RollRecord.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  spring2020p1to3ecard - EE333 Spring 2020
 * Vers: 1.0.0 01/24/2020 dgg - initial coding
 */

package edu.uab.dgreen.spring2020p1to3ecard;

/**
 * Model a record associated with an roll for class attendance on a day.
 *
 * @author David G. Green dgreen@uab.edu
 */
public class RollRecord {

  private final String course;       // course name (like EE333)
  private final String day;          // showable day (like 20200121)
  private final String blazerID;     // userid

  /**
   * Create an RollRecord.
   *
   * @param course the course name
   * @param day the showable day
   * @param blazerID the userid of the card holder
   */
  public RollRecord(String course, String day, String blazerID) {
    this.course = course;
    this.day = day;
    this.blazerID = blazerID;
  }

  /**
   * Get the blazerID of that corresponds to the eCard.
   *
   * @return blazerID of record
   */
  public String getBlazerID() {
    return blazerID;
  }

  /**
   * Get the course name.
   *
   * @return course name of record
   */
  public String getCourse() {
    return course;
  }

  /**
   * Get the day.
   * 
   * @return the day
   */
  public String getDay() {
    return day;
  }
}
