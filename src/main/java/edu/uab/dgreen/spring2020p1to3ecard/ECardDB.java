/*
 * File: ECardDB.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  spring2020p1to3ecard - EE333 Spring 2020
 * Vers: 1.2.0 01/28/2020 dgg - change to arraylist (from array)
 * Vers: 1.1.0 01/20/2020 dgg - convert to singleton
 * Vers: 1.0.0 01/11/2020 dgg - initial coding
 */

package edu.uab.dgreen.spring2020p1to3ecard;

import java.util.ArrayList;

/**
 * Model a system to issue cards, validate them, and provide info on owner.
 *
 * @author David G. Green dgreen@uab.edu
 */
public class ECardDB {

  private ArrayList<ECardRecord> records;

  /**
   * Make an ECardDB object.
   */
  private ECardDB() {
    records = new ArrayList<>();
  }

  /**
   * Allow one to get the (only) ECardDB server.
   * @return reference to ECardDB server.
   */
  public static ECardDB getInstance() {
    return ECardDbHolder.INSTANCE;
  }

  private static class ECardDbHolder {
    private static final ECardDB INSTANCE = new ECardDB();
  }


  // queries
  /**
   * Determine whether the given eCard.
   *
   * @param ecard user's ECard
   * @return eCardRecord corresponding to the card if valid, null otherwise
   */
  public ECardRecord validate(final ECard ecard) {
    for (ECardRecord eCardRecord : records) {
      if (eCardRecord.isMatch(ecard)) {
        if (eCardRecord.isCancelled()) {
          return null;
        } else {
          return eCardRecord;
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
    for (ECardRecord eCardRecord : records) {
      if (eCardRecord.isMatch(uid)) {
        eCardRecord.cancel();
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
    for (ECardRecord eCardRecord : records) {
      if (blazerID.equals(eCardRecord.getBlazerID())) {
        eCardRecord.cancel();
      }
    }
  }

  // other
  /**
   * Issue a card for user generating a 10 digit unique id.
   *
   * @param displayName user's name ready to print
   * @param blazerID user's id code
   * @param typeCode type of user based on adding values: 1 - student 2 -
   *     faculty 4 - employee where a visitor will have typeCode 0
   *
   * @return ecard or null if no MAX_RECORDS ecards have already been issued
   */
  public ECard issueCard(final String displayName, final String blazerID,
      final int typeCode) {

    ECard card = new ECard();
    ECardRecord record = new ECardRecord(card, displayName, blazerID, typeCode);
    records.add(record);
    return card;
  }
}
