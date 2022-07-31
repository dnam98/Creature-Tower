//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Creature list
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

import java.util.NoSuchElementException;

/**
 * This class models the singly linked list data structure that stores elements of type Creature.
 * 
 * @author Dongwon
 *
 */
public class CreatureList {

  private LinkedCreature head; // head of the list
  private LinkedCreature tail; // tail of the list
  private int size; // keeps track of total number of creatures stored in the list
  private int humanCount; // total number of HUMAN creatures in the list
  private int elephantCount; // total number of ELEPHANT creatures in the list
  private int turtleCount; // total number of TURTLE creatures in the list

  /**
   * Adds a new elephant at the top of elephants if the list contains any elephants.
   * 
   * @param creature
   */
  public void addElephant(Creature creature) {
    // throws exception if the creature is not a Elephant
    if (creature.getSpecies() != Species.ELEPHANT || creature == null) {
      throw new IllegalArgumentException("Error: Elephant creature should be added");
    }

    LinkedCreature newElephant = new LinkedCreature(creature);

    // Adding to an empty list
    if (this.head == null && tail == null) {
      this.head = newElephant;
      this.tail = newElephant;
    }

    // Adding to a non-empty list
    else {
      LinkedCreature current = this.head;

      // Adding to the tail (humanCount == size)
      if (humanCount == size) {
        for (int i = 0; i < humanCount - 1; i++) {
          current = current.getNext();
        }
        current.setNext(newElephant);
        newElephant.setNext(null);
        this.tail = newElephant;
      }

      else {
        for (int i = 0; i < humanCount - 1; i++) {
          current = current.getNext();
        }

        newElephant.setNext(current.getNext());
        current.setNext(newElephant);
      }

    }

    this.size++;
    this.elephantCount++;

  }

  /**
   * Adds a new human to the head of this creatureList.
   * 
   * @param creature
   */
  public void addHuman(Creature creature) {
    // throws exception if the creature is not a human
    if (creature.getSpecies() != Species.HUMAN || creature == null) {
      throw new IllegalArgumentException("Error: Human creature should be added");
    }

    LinkedCreature newHuman = new LinkedCreature(creature);

    // Adding to an empty list
    if (head == null && tail == null) {
      this.head = newHuman;
      this.tail = newHuman;
    }

    // Adding to the head of the list (not empty)
    else {
      newHuman.setNext(this.head);
      this.head = newHuman;
    }

    this.size++;
    this.humanCount++;
  }

  /**
   * Adds a new turtle to the end of this creatureList.
   * 
   * @param creature
   */
  public void addTurtle(Creature creature) {
    // throws exception if the creature is not a Turtle
    if (creature.getSpecies() != Species.TURTLE || creature == null) {
      throw new IllegalArgumentException("Error: Turtle creature should be added");
    }

    LinkedCreature newTurtle = new LinkedCreature(creature, null);

    // Adding to an empty list
    if (this.head == null && this.tail == null) {
      this.head = newTurtle;
      this.tail = newTurtle;
    }

    // Adding to the tail of the list (not empty)
    else {
      this.tail.setNext(newTurtle);
      this.tail = newTurtle;
    }

    this.size++;
    this.turtleCount++;
  }

  /**
   * Removes all the elements from the creature list.
   */
  public void clear() {
    this.head = null;
    this.tail = null;
    this.elephantCount = 0;
    this.humanCount = 0;
    this.turtleCount = 0;
    this.size = 0;
  }

  /**
   * Returns the element stored at position index of this list without removing it.
   * 
   * @param index
   * @return
   */
  public Creature get(int index) {
    if (this.head == null || index >= this.size || index < 0) {
      throw new IndexOutOfBoundsException("Error: Index out of bound");
    }

    LinkedCreature current = this.head;

    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }

    return current.getCreature();
  }

  /**
   * Returns the number of elephants stored in this list.
   * 
   * @return
   */
  public int getElephantCount() {
    return this.elephantCount;
  }

  /**
   * Returns the number of humans stored in this list.
   * 
   * @return
   */
  public int getHumanCount() {
    return this.humanCount;
  }

  /**
   * Returns the number of turtles stored in this list.
   * 
   * @return
   */
  public int getTurtleCount() {
    return this.turtleCount;
  }

  /**
   * Checks whether this CreatureList is empty.
   * 
   * @return true if CreatureList is empty
   */
  public boolean isEmpty() {
    if (this.head == null) {
      return true;
    }

    return false;
  }

  /**
   * Removes and returns a creature given its creature number from this list
   * 
   * @param creatureNumber - Creature to remove
   * @return the removed creature corresponding to the specified creatureNumber
   */
  public Creature removeCreature(int creatureNumber) {
    // List is empty
    if (this.head == null) {
      throw new NoSuchElementException("Error: List is empty");
    }

    // Throw exception if no creature found with the specified creatureNumber
    LinkedCreature tempNode = this.head;
    boolean creatureFound = false;

    for (int i = 0; i < this.size; i++) {
      if (tempNode.getCreature().getCreatureNumber() == creatureNumber) {
        creatureFound = true;
        break;
      }
      tempNode = tempNode.getNext();
    }

    if (!creatureFound) {
      throw new NoSuchElementException(
          "Error: Creature with creature number " + creatureNumber + " is not in the list");
    }

    LinkedCreature nodeToRemove;
    Creature removedCreature;
    LinkedCreature prevNode;

    // Does not exist in list
    {
      nodeToRemove = this.head;
      boolean found = false;
      for (int i = 0; i < size; i++) {
        if (nodeToRemove.getCreature().getCreatureNumber() == creatureNumber) {
          found = true;
          break;
        }
        nodeToRemove = nodeToRemove.getNext();
      }
      if (!found) {
        return null;
      }
    }

    // Removing the only creature in the list
    if (this.head == this.tail) {
      if (this.head.getCreature().getCreatureNumber() == creatureNumber) {
        nodeToRemove = this.head;
        removedCreature = nodeToRemove.getCreature();
        this.head = null;
        this.tail = null;
        this.size--;
        if (removedCreature.getSpecies() == Species.ELEPHANT) {
          this.elephantCount--;
        }

        else if (removedCreature.getSpecies() == Species.HUMAN) {
          this.humanCount--;
        }

        else {
          this.turtleCount--;
        }

        return removedCreature;
      }
    }

    // Specified creature is the head or tail of a size 2 list
    if (this.size == 2) {
      // If it is the head
      if (this.head.getCreature().getCreatureNumber() == creatureNumber) {
        nodeToRemove = this.head;
        removedCreature = nodeToRemove.getCreature();
        this.head = this.tail;
        size--;
        if (removedCreature.getSpecies() == Species.ELEPHANT) {
          this.elephantCount--;
        }

        else if (removedCreature.getSpecies() == Species.HUMAN) {
          this.humanCount--;
        }

        else {
          this.turtleCount--;
        }

        return removedCreature;
      }

      // If it is the tail
      if (this.tail.getCreature().getCreatureNumber() == creatureNumber) {
        nodeToRemove = this.tail;
        removedCreature = nodeToRemove.getCreature();
        this.head.setNext(null);
        this.tail = this.head;
        size--;
        if (removedCreature.getSpecies() == Species.ELEPHANT) {
          this.elephantCount--;
        }

        else if (removedCreature.getSpecies() == Species.HUMAN) {
          this.humanCount--;
        }

        else {
          this.turtleCount--;
        }

        return removedCreature;
      }
    }

    // Creature is the first in the list (more than two creatures in the list)
    if (this.head.getCreature().getCreatureNumber() == creatureNumber) {
      nodeToRemove = this.head;
      removedCreature = nodeToRemove.getCreature();
      this.head = this.head.getNext();
      this.size--;
      if (removedCreature.getSpecies() == Species.ELEPHANT) {
        this.elephantCount--;
      } else if (removedCreature.getSpecies() == Species.HUMAN) {
        this.humanCount--;
      } else {
        this.turtleCount--;
      }

      return removedCreature;
    }

    // Creature is at the end of the list
    if (this.tail.getCreature().getCreatureNumber() == creatureNumber) {
      nodeToRemove = this.tail;
      removedCreature = nodeToRemove.getCreature();
      prevNode = this.head;
      for (int i = 0; i < size - 2; i++) {
        prevNode = prevNode.getNext();
      }
      prevNode.setNext(null);
      this.tail = prevNode;
      this.size--;
      if (removedCreature.getSpecies() == Species.ELEPHANT) {
        this.elephantCount--;
      } else if (removedCreature.getSpecies() == Species.HUMAN) {
        this.humanCount--;
      } else {
        this.turtleCount--;
      }

      return removedCreature;
    }

    // Creature is in the middle of the list (more than one creatures in the list)
    if (this.head.getCreature().getCreatureNumber() != creatureNumber
        && this.tail.getCreature().getCreatureNumber() != creatureNumber) {
      nodeToRemove = this.head.getNext();
      prevNode = this.head;
      for (int i = 0; i < this.size - 1; i++) {
        if (nodeToRemove.getCreature().getCreatureNumber() == creatureNumber) {
          removedCreature = nodeToRemove.getCreature();
          prevNode.setNext(nodeToRemove.getNext());
          prevNode = prevNode.getNext();
          this.size--;
          if (removedCreature.getSpecies() == Species.ELEPHANT) {
            this.elephantCount--;
          } else if (removedCreature.getSpecies() == Species.HUMAN) {
            this.humanCount--;
          } else {
            this.turtleCount--;
          }
          return removedCreature;
        }
        nodeToRemove = nodeToRemove.getNext();
        prevNode = prevNode.getNext();
      }
    }

    // None of the above
    return null;
  }

  /**
   * Removes and returns the element at the head of this list if it is a human.
   * 
   * @return the removed human creature
   */
  public Creature removeHuman() {
    // Throws exception if the list is empty
    if (this.head == null || this.humanCount == 0) {
      throw new NoSuchElementException("Error: List does not contain human creature");
    }

    Creature firstNode = this.head.getCreature();

    // Check if head equals tail (one creature in list)

    // More than one creature in the list
    if (this.head != this.tail) {
      // Check if the creature is human
      if (firstNode.getSpecies().equals(Species.HUMAN)) {
        this.head = this.head.getNext();
        this.humanCount--;
        this.size--;
        return firstNode;
      }

      // If not human, don't do anything
      else {
        return null;
      }
    }

    // Only one creature in the list
    else {
      // Check if the creature is human
      if (firstNode.getSpecies().equals(Species.HUMAN)) {
        this.head = null;
        this.tail = null;
        this.humanCount--;
        this.size--;
        return firstNode;
      }

      // If not human, don't do anything
      else {
        return null;
      }
    }
  }

  /**
   * Removes and returns the element at the tail of this list if it is a turtle.
   * 
   * @return the removed turtle creature
   */
  public Creature removeTurtle() {
    // Throws exception if the list is empty
    if (this.head == null || this.turtleCount == 0) {
      throw new NoSuchElementException("Error: List does not contain Turtle creature");
    }

    LinkedCreature current = this.head;
    LinkedCreature removedTurtle = this.tail;

    // Check if head equals tail (one creature in list)
    if (this.head == this.tail) {
      // Check if it is turtle
      if (removedTurtle.getCreature().getSpecies().equals(Species.TURTLE)) {
        this.head = null;
        this.tail = null;
        this.size--;
        this.turtleCount--;
        return removedTurtle.getCreature();
      }

      // If not, do nothing
      else {
        return null;
      }
    }

    // More than one creature in the list
    else {
      // get second to last list node
      for (int i = 0; i < this.size - 2; i++) {
        current = current.getNext();
      }
      current.setNext(null);
      this.tail = current;
      this.turtleCount--;
      this.size--;
      return removedTurtle.getCreature();
    }
  }

  /**
   * Returns the size of this list
   * 
   * @return
   */
  public int size() {
    return this.size;
  }

  /**
   * Returns a string representation of the contents of this list
   */
  public String toString() {
    // Empty list
    if (this.head == null) {
      return "";
    }

    // Non-empty list
    else {
      LinkedCreature current = this.head;
      String creatures = this.head.toString();
      for (int i = 0; i < size - 1; i++) {
        current = current.getNext();
        if (current == null) {
          break;
        }
        creatures = creatures + current.toString();
      }
      return creatures;
    }
  }

}
