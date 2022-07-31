//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Linked creature
// Course: CS 300 Summer 2021
//
// Author: Dongwon Nam
// Email: dnam9@wisc.edu
// Lecturer: Chris Magnano
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class represents a linked list node of LinkedCreature
 * 
 * @author Dongwon
 *
 */
public class LinkedCreature {

  private Creature creature; // represents the data carried by this LinkedCreature node
  private LinkedCreature next; // represents the link to the next LinkedCreature node

  /**
   * Constructor for this class
   * 
   * @param creature
   */
  public LinkedCreature(Creature creature) {
    this.creature = creature;
    this.next = null;
  }

  /**
   * Constructor for this class
   * 
   * @param creature
   * @param next
   */
  public LinkedCreature(Creature creature, LinkedCreature next) {
    this.creature = creature;
    this.next = next;
  }

  /**
   * Returns the creature stored by this linked creature
   * 
   * @return creature stored by this linked creature
   */
  public Creature getCreature() {
    return this.creature;
  }

  /**
   * Returns the next linked creature node
   * 
   * @return next linked creature node
   */
  public LinkedCreature getNext() {
    return this.next;
  }

  /**
   * Sets the next linked creature node
   * 
   * @param next - next linked creature node
   */
  public void setNext(LinkedCreature next) {
    this.next = next;
  }

  /**
   * Returns a string representation of this linked creature
   * 
   * @return String representation of the linked creature
   */
  public String toString() {
    String creatureRep;

    if (this.next != null) {
      creatureRep = this.creature.toString() + " -> ";
    }

    else {
      creatureRep = this.creature.toString() + " -> END";
    }

    return creatureRep;
  }
}
