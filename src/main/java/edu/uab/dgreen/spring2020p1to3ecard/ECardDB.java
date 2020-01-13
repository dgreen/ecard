/*
 * File: ECardDB.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  spring2020p1to3ecard - EE333 Spring 2020
 * Vers: 1.0.0 01/11/2020 dgg - initial coding
 */
package edu.uab.dgreen.spring2020p1to3ecard;

/**
 * Model a system to issue cards, validate them, and provide info on owner
 *
 * @author David G. Green dgreen@uab.edu
 */
public class ECardDB {

  private static final int MAX_RECORDS = 100;

  private ECardRecord records[];
  private int numberRecords;

  /**
   * Make an ECardDB object Limited to MAX_RECORDS cards
   */
  public ECardDB() {
    records = new ECardRecord[MAX_RECORDS];
    numberRecords = 0;
  }

  // queries
  /**
   * Determine whether the given eCard
   *
   * @param ecard user's ECard
   * @return eCardRecord corresponding to the card if valid, null otherwise
   */
  public ECardRecord validate(final ECard ecard) {
    for (int i = 0; i < numberRecords; i++) {
      if (records[i].isMatch(ecard)) {
        if (records[i].isCancelled()) {
          return null;
        } else {
          return records[i];
        }
      }
    }
    return null;        // did not find one
  }

  // commands
  /**
   * Cancel the card matching the given UID. Ignore request if this card is
   * unknown or already canceled.
   *
   * @param uid UID to match
   */
  public void cancel(final long uid) {
    for (int i = 0; i < numberRecords; i++) {
      if (records[i].isMatch(uid)) {
        records[i].cancel();
      }
    }
  }

  /**
   * Cancel the card matching the given BlazerID. Ignore request if this card is
   * unknown or already canceled.
   *
   * @param blazerID BlazerID to match
   */
  public void cancel(final String blazerID) {
    for (int i = 0; i < numberRecords; i++) {
      if (blazerID.equals(records[i].getBlazerID())) {
        records[i].cancel();
      }
    }

  }

  // other
  /**
   * Issue a card for user generating a 10 digit unique id
   *
   * @param displayName user's name ready to print
   * @param blazerID user's id code
   * @param typeCode type of user based on adding values: 1 - student 2 -
   * faculty 4 - employee where a visitor will have typeCode 0
   *
   * @return ecard or null if no MAX_RECORDS ecards have already been issued
   */
  public ECard issueCard(final String displayName, final String blazerID,
      final int typeCode) {

    if (numberRecords >= MAX_RECORDS) {
      return null;
    }

    ECard card = new ECard();
    ECardRecord record = new ECardRecord(card, displayName, blazerID, typeCode);
    records[numberRecords++] = record;
    return card;
  }
}
