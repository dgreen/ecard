/*
 * File: ECardRollUnit.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  spring2020p1to3ecard - EE333 Spring 2020
 * Vers: 1.0.0 01/24/2020 dgg - initial coding
 */

package edu.uab.dgreen.spring2020p1to3ecard;

import java.util.ArrayList;

public class ECardRollUnit extends AuthPoint {

  private String day = "unknown day";
  private String course = "unknown course";
  private ArrayList<RollRecord> present = new ArrayList<>();

  /**
   * Set day.
   *
   * @param day string to log date (used till changed)
   */
  public void setDay(String day) {
    this.day = day;
  }

  /**
   *  Set course.
   *
   * @param course string to log course (used till changed)
   */
  public void setCourse(String course) {
    this.course = course;
  }

  /**
   * Called by the above validate method when a card is successfully validated.
   * @param blazerID - blazerid of card being granted access
   * @return true if access granted otherwise false
   */
  protected boolean valid(ECardRecord ecr) {
    String blazerID = ecr.getBlazerID();

    if (ecr.isStudent()) {
      present.add(new RollRecord(course, day, blazerID));
      log(blazerID, "Green Light Flash");
      return true;
    } else {
      invalid(blazerID);
      return false;
    }
  }

  /**
   * Called by the above validate method when a card is not validated when presented.
   *
   * @param cardCode - card code not being granted access
   */
  protected void invalid(long cardCode)  {
    log("" + cardCode, "Red Light Flash");
  }

  /**
   * Called by the above validate method when a card is not validated when presented.
   *
   * @param blazerID - user not being listed as present
   */
  protected void invalid(String blazerID) {
    log(blazerID, "Red Light Flash");
  }

  /**
   * Reset the system.  Would, at least, turn off any alarming. (unused)
   */
  protected void reset() {

  }

  /**
   * Activate any contained alarm.  (unused)
   */
  public void alarm() {

  }

  /**
   * Print a attendance list.
   * The output will be blazerID, count per line
   * The logger is not closed by this routine to facilitate continued use if desired.
   *
   * @param course string name of course to be reported on
   * @param logger an object that implements the eCardLogger interface
   */
  public void courseRoll(String course, ECardLogger logger) {

    String blazerID;
    ArrayList<String> blazerIDs = new ArrayList<>();

    // determine the list of blazerIDs for this class
    for (RollRecord rollRecord : present) {
      if (rollRecord.getCourse().equals(course)) {
        blazerID = rollRecord.getBlazerID();
        if (!blazerIDs.contains(blazerID)) {
          blazerIDs.add(blazerID);
        }
      }
    }

    // sort the list of blazerIDs
    blazerIDs.sort(String.CASE_INSENSITIVE_ORDER);

    // for each blazerid, count number of times they are listed
    for (String bid : blazerIDs) {
      int count = 0;
      for (RollRecord rollRecord : present) {
        if (rollRecord.getBlazerID().equalsIgnoreCase(bid)
            && rollRecord.getCourse().equalsIgnoreCase(course)) {
          count++;
        }
      }
      logger.log(bid, "" + count);
    }
  }

}
