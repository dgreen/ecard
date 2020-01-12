/*
 * File: ECardDB.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  spring2020p1to3ecard - EE333 Fall 2020
 * Vers: 1.0.0 01/11/2020 dgg - initial coding
 */
package edu.uab.dgreen.spring2020p1to3ecard;

/**
 * Model a system to issue cards, validate them, and provide info on owner
 *
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
     *
     * @param ecard user's ECard
     * @return eCardRecord corresponding to the card if valid, null otherwise
     */
    public ECardRecord validate(final ECard ecard) {
        return null;
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
     * Cancel the card matching the given BlazerID. Ignore request if this card
     * is unknown or already canceled.
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
     * @param blazerID user's id code
     * @param typeCode type of user based on adding values: 1 - student 2 -
     * faculty 4 - employee where a visitor will have typeCode 0
     * @return
     */
    public ECard issueCard(final String displayName, final String blazerID,
            final int typeCode) {

        return null;
    }

}
