/*
 * File: ECardDB.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  spring2020p1to3ecard - EE333 Fall 2020
 * Vers: 1.0.0 01/11/2020 dgg - initial coding
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.dgreen.spring2020p1to3ecard;

/**
 * Model a system to issue cards, validate them, and provide info on owner
 * @author David G. Green dgreen@uab.edu
 */
public class ECardDB {

    /**
     * Make an ECardDB object
     */
    public ECardDB() {

    }

    // queries

    /**
     * Determine whether the given eCard
     * @param ecard user's ECard
     * @return token that can be used for additional queries about this user
     *               (or 0 if card not valid)
     */
    public long validate(final ECard ecard) {
    return 0;
  }

  /**
   * Get the display name that goes with an eCard that has been validated
   *
   * @param token - value to find correct card (returned by validate method)
   * @return display name or null if token invalid
   */
  public String getDisplayName(final long token) {
    return null;
  }

  /**
   * Is this ECard holder a student?
   *
   * @param token - value to find correct card (returned by validate method)
   * @return true if yes, false if no (or token invalid)
   */
  public boolean isStudent(final long token) {
    return false;
  }

  /**
   * Is this ECard holder a faculty member?
   *
   * @param token - value to find correct card (returned by validate method)
   * @return true if yes, false if no (or token invalid)
   */
  public boolean isFaculty(final long token) {
    return false;
  }

  /**
   * Is this ECard holder an employee?
   *
   * @param token - value to find correct card (returned by validate method)
   * @return true if yes, false if no (or token invalid)
   */
  public boolean isEmployee(final long token) {
    return false;
  }

  /**
   * Is this ECard holder a visitor?
   *
   * @param token - value to find correct card (returned by validate method)
   * @return true if yes, false if no (or token invalid)
   */
  public boolean isVisitor(final long token) {
    return false;
  }

  // commands

  /**
   * Cancel the card matching the given UID. Ignore request if this card is
   * unknown or already canceled.
   *
   * @param UID uid to match
   */
  public void cancel(final long UID) {

  }

  /**
   * Cancel the card matching the given BlazerID. Ignore request if this card is
   * unknown or already canceled.
   *
   * @param blazerID BlazerID to match
   */
  public void cancel(final String blazerID) {

  }

  // other

  /**
   * Issue a card base for user generating a 10 digit unique id
   *
   * @param displayName user's name ready to print
   * @param blazerID    user's id code
   * @param typeCode    type of user based on adding values: 1 - student 2 -
   *                    faculty 4 - employee where a visitor will have typeCode 0
   * @return
   */
  public ECard issueCard(final String displayName, final String blazerID, final int typeCode) {
        return null;
    }

}
