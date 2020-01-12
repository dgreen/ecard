/*
 * File: ECardRecord.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  spring2020p1to3ecard - EE333 Fall 2020
 * Vers: 1.0.0 01/11/2020 dgg - initial coding
 */
package edu.uab.dgreen.spring2020p1to3ecard;

/**
 *
 * @author David G. Green dgreen@uab.edu
 */
public class ECardRecord {

    /**
     * Create an ECardRecord
     *
     * @param eCard the matching card
     * @param displayName the ready to show name of the card holder
     * @param blazerID the userid of the card holder
     * @param type type of user based on adding values: 1 - student 2 - faculty
     * 4 - employee where a visitor will have typeCode 0
     */
    public ECardRecord(ECard eCard, String displayName, String blazerID, int type) {

    }

    // queries
    /**
     * Determine whether the given eCard matches this record
     *
     * @param ecard user's ECard
     * @return true if match, false otherwise
     */
    public long isMatch(final ECard ecard) {
        return 0;
    }

    /**
     * Get the display name that goes with an eCard that has been validated
     *
     * @return display name or null if token invalid
     */
    public String getDisplayName() {
        return null;
    }

    /**
     * Is this ECard holder a student?
     *
     * @return true if yes, false if no (or token invalid)
     */
    public boolean isStudent() {
        return false;
    }

    /**
     * Is this ECard holder a faculty member?
     *
     * @return true if yes, false if no (or token invalid)
     */
    public boolean isFaculty() {
        return false;
    }

    /**
     * Is this ECard holder an employee?
     *
     * @return true if yes, false if no (or token invalid)
     */
    public boolean isEmployee() {
        return false;
    }

    /**
     * Is this ECard holder a visitor?
     *
     * @return true if yes, false if no (or token invalid)
     */
    public boolean isVisitor() {
        return false;
    }
}
