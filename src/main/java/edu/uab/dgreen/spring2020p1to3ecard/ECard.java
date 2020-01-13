/*
 * File: ECard.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  spring2020p1to3ecard - EE333 Spring 2020
 * Vers: 1.0.0 01/11/2020 dgg - initial coding
 */

package edu.uab.dgreen.spring2020p1to3ecard;

/**
 * Model a ECard for identity.
 *
 * @author David G. Green dgreen@uab.edu
 */
public class ECard {

  private static long counter = 1000000000L;
  private final long uid;

  /**
   * Create a card assigning it a unique 10 digit code.
   */
  public ECard() {
    uid = counter++;
  }

  /**
   * Return the code for this card.
   *
   * @return the card's code
   */
  public long getCode() {
    return uid;
  }

}
