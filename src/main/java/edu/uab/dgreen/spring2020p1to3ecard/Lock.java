/**
 * File: Lock.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  spring2020p1to3ecard - EE333 Spring 2020
 * Vers: 1.0.0 01/18/2020 dgg - initial coding
 */

package edu.uab.dgreen.spring2020p1to3ecard;

public class Lock extends AuthPoint {

  private boolean alarming = false;        // whether alarming is occuring

  /**
   * Create a lock.
   */
  public Lock() {
    super();
  }

  /**
   * Called to initialize the lock at a (new) location. This code is not necessary
   * but left to allow adding additional behavior to the initialize activity.
   *
   * @param location a string to identify the location of the authPoint
   */
  @Override
  public void initialize(final String location) {
    super.initialize(location);
  }

  /**
   * Called by the above validate method when a card is successfully validated.
   * Issue unlock, Show Green, Wait, Issue Lock, Turn off lights.  (simulated with log entries)
   *
   * @param blazerID - blazerID of card being granted access
   */
  @Override
  protected void valid(final String blazerID) {
    log(blazerID, "Unlock");
    log(blazerID, "Green light on");
    log(blazerID, "Waiting access time");
    log(blazerID, "Lock");
    log(blazerID, "Green light off");
  }

  /**
   * Called by the above validate method when a card is not validated when presented.
   * Issue "Red", "Wait", "Turn off Red".  (Simulated with log entries)
   *
   * @param cardCode - card code not being granted access
   */
  @Override
  protected void invalid(final String cardCode) {
    log(cardCode, "Red light on");
    log(cardCode, "Waiting access time");
    log(cardCode, "Red light off");
  }

  /**
   * Reset the system. Would, at least, turn off any alarming.
   */
  @Override
  protected void reset() {
    if (alarming) {
      log("", "Alarm off");
      alarming = false;
    }
  }

  /**
   * Activate any contained alarm.
   */
  @Override
  public void alarm() {
    alarming = true;
    log("", "Alarming");
  }

}