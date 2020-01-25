/**
 * File: AuthPoint.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  spring2020p1to3ecard - EE333 Spring 2020
 * Vers: 1.0.1 01/24/2020 dgg - initial coding
 */

package edu.uab.dgreen.spring2020p1to3ecard;

import java.util.ArrayList;

public abstract class AuthPoint {

  private String location = "no location";       // location of this authPoint
  private final ArrayList<ECardLogger> loggers;  // collection of loggers

  /**
   * Create an AuthPoint.
   */
  protected AuthPoint() {
    loggers = new ArrayList<>();
  }

  /**
   * Validate the ecard that is presented.  If the ecard is valid, then
   * call the method valid().  If the method is not valid, call the method
   * inValid().
   *
   * @param ecard an ECard to use for validation
   * @return true if validation/access was successful and false otherwise.
   */
  public boolean validate(ECard ecard) {
    ECardRecord record = ECardDB.getInstance().validate(ecard);
    if (record == null) {
      invalid("" + ecard.getCode());
      return false;
    } else {
      return valid(record);
    }
  }

  /**
   * Called to initialize the auth poin at a (new) location.
   *
   * @param location a string to identify the location of the authPoint
   */
  public void initialize(String location) {
    this.location = location;
  }

  /**
   * Called by the above validate method when a card is successfully validated.
   * @param ecr - record of card being granted access
   * @return true if access granted otherwise false
   */
  protected abstract boolean valid(ECardRecord ecr);

  /**
   * Called by the above validate method when a card is not validated when presented.
   *
   * @param cardCode - card code not being granted access
   */
  protected abstract void invalid(long cardCode);

  /**
   * Called by the above validate method when a card is not validated when presented.
   *
   * @param blazerID - user not being granted access
   */
  protected abstract void invalid(String blazerID);

  /**
   * Reset the system.  Would, at least, turn off any alarming.
   */
  protected abstract void reset();

  /**
   * Activate any contained alarm.
   */
  public abstract void alarm();

  /**
   * Add an logger to the authpoint.  Each logger will be called for events that are
   * logged.
   *
   * @param logger the logger to add to the system
   */
  public void add(ECardLogger logger) {
    if (logger != null) {
      loggers.add(logger);
    }
  }

  /**
   * As a service to subclasses, send message out to all registered loggers.
   */
  protected void log(final String blazerID, final String message) {
    for (final ECardLogger ecardLogger : loggers) {
      ecardLogger.log(blazerID, message + " (" + location + ")");
    }
  }
}
