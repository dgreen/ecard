/**
 * File: Lock.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  spring2020p1to3ecard - EE333 Spring 2020
 * Vers: 1.0.0 01/18/2020 dgg - initial coding
 */

package edu.uab.dgreen.spring2020p1to3ecard;

import java.util.ArrayList;

public class Lock extends AuthPoint {

  private boolean alarming = false;        // whether alarming is occuring
  private ArrayList<String> accessList;

  /**
   * Create a lock.
   */
  public Lock() {
    super();
    accessList = new ArrayList<>();
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
    if (accessList.contains(blazerID)) {

      // allow user access if on access list
      log(blazerID, "Unlock");
      log(blazerID, "Green light on");
      log(blazerID, "Waiting access time");
      log(blazerID, "Lock");
      log(blazerID, "Green light off");
    } else {

      // deny access to user if not on access list
      invalid(blazerID);
    }
  }

  /**
   * Called directly by the above access method when a card is validated but
   * does have access permission.  Signal deny access.
   * Issue deny access.
   *
   * @param blazerID - blazerID not being granted access
   */
  @Override
  protected void invalid(final String blazerID) {
    deny(blazerID);
  }

  /**
   * Called by the above validate method when a card is not validated when presented.
   * Signal deny access.
   *
   * @param code - card code not being granted access
   */
  @Override
  protected void invalid(final long code) {
    deny("" + code);
  }

  /*
   * Issue "Red", "Wait", "Turn off Red".  (Simulated with log entries)
   *
   * @param text - text related to user/card not being granted access
   */
  private void deny(final String text) {
    log(text, "Red light on");
    log(text, "Waiting display time");
    log(text, "Red light off");
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

  /**
   * Add a blazerID to the access list.
   *
   * @param blazerID the user to allow access to this lock
   */
  public void add(final String blazerID) {
    accessList.add(blazerID);
  }

}