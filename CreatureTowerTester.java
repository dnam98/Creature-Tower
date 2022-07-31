//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: CreatureTower class tester
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
 * Contains tester methods for LinkedCreature and CreatureList class
 * 
 * @author Dongwon
 *
 */
public class CreatureTowerTester {

  /**
   * Tester method for LinkedCreature class
   * 
   * @return true if LinkedCreature class passed
   */
  public static boolean testLinkedCreature() {
    Creature.restartNextCreatureNumber();
    Species species1 = Species.ELEPHANT;
    Species species2 = Species.HUMAN;
    Creature creature1 = new Creature(species1);
    Creature creature2 = new Creature(species2);
    Species expected = null;
    Species actual = null;

    // 1. Construct
    LinkedCreature linkedCreature = new LinkedCreature(creature1);
    LinkedCreature next = new LinkedCreature(creature2);

    // 2. Accessor method test
    Creature.restartNextCreatureNumber();
    expected = Species.ELEPHANT;
    actual = linkedCreature.getCreature().getSpecies();

    if (!actual.equals(expected)) {
      System.out.println("testLinkedCreature failed: Error in accessor method");
      System.out.println("Expected: " + expected.toString() + " Actual: " + actual.toString());
      return false;
    }


    // 3. Mutator method test
    Creature.restartNextCreatureNumber();
    creature1 = new Creature(species1);
    creature2 = new Creature(species2);
    linkedCreature = new LinkedCreature(creature1);
    next = new LinkedCreature(creature2);

    linkedCreature.setNext(next);
    expected = Species.HUMAN;
    actual = linkedCreature.getNext().getCreature().getSpecies();

    if (!actual.equals(expected)) {
      System.out.println("testLinkedCreature failed: Error in mutator method");
      System.out.println("Expected: " + expected.toString() + " Actual: " + actual.toString());
      return false;
    }

    // 4. toString method test
    Creature.restartNextCreatureNumber();
    creature1 = new Creature(species1);
    creature2 = new Creature(species2);
    linkedCreature = new LinkedCreature(creature1);
    next = new LinkedCreature(creature2);
    String expectedString = "ELEPHANT 1 -> END";
    String actualString = linkedCreature.toString();

    if (!expectedString.equals(actualString)) {
      System.out.println("testLinkedCreature failed: Error in toString method");
      System.out.println("Expected: " + expectedString + " Actual: " + actualString);
      return false;
    }

    System.out.println("testLinkedCreature passed");
    return true;
  }

  /**
   * Checks for the correctness of the CreatureList.clear() method
   * 
   * @return true if test passed
   */
  public static boolean testClear() {
    Creature.restartNextCreatureNumber();
    CreatureList list = new CreatureList();
    list.addElephant(new Creature(Species.ELEPHANT)); // adds ELEPHANT 1
    list.addHuman(new Creature(Species.HUMAN)); // adds HUMAN 2 at the head of the list
    list.addElephant(new Creature(Species.ELEPHANT)); // adds ELEPHANT 3
    list.clear();
    int expected = 0;
    int actual = list.size();
    if (expected != actual) {
      System.out.println("testClear failed");
      System.out.println("Expected list size: " + expected + " Actual list size: " + actual);
      return false;
    }

    int expectedElephant = 0;
    int expectedHuman = 0;
    int expectedTurtle = 0;
    int actualElephant = list.getElephantCount();
    int actualHuman = list.getHumanCount();
    int actualTurtle = list.getTurtleCount();

    if (expectedElephant != actualElephant) {
      System.out.println("testClear failed");
      System.out.println("Expected elephant count: " + expected + " Actual count: " + actual);
      return false;
    }

    if (expectedHuman != actualHuman) {
      System.out.println("testClear failed");
      System.out.println("Expected human count: " + expected + " Actual count: " + actual);
      return false;
    }

    if (expectedTurtle != actualTurtle) {
      System.out.println("testClear failed");
      System.out.println("Expected turtle count: " + expected + " Actual count: " + actual);
      return false;
    }

    System.out.println("testClear passed");
    return true;
  }

  /**
   * Checks for the correctness of the CreatureList.addHuman(), CreatureList.addElephant(), and
   * CreatureList.addTurtle() methods
   * 
   * @return true if test passed
   */
  public static boolean testAddCreatures() {
    Creature.restartNextCreatureNumber();
    CreatureList list;
    String expected;
    String actual;

    // Calling addTurtle with a different species as parameter
    Creature.restartNextCreatureNumber();
    list = new CreatureList();
    try {
      list.addTurtle(new Creature(Species.HUMAN)); // should throw exception
    } catch (IllegalArgumentException e) {
      e.getMessage();
    }

    // Calling addHuman with a different species as parameter
    Creature.restartNextCreatureNumber();
    list = new CreatureList();
    try {
      list.addHuman(new Creature(Species.ELEPHANT)); // should throw exception
    } catch (IllegalArgumentException e) {
      e.getMessage();
    }

    // Calling addElephant with a different species as parameter
    Creature.restartNextCreatureNumber();
    list = new CreatureList();
    try {
      list.addElephant(new Creature(Species.HUMAN)); // should throw exception
    } catch (IllegalArgumentException e) {
      e.getMessage();
    }

    // Adding ELEPHANT to an empty list
    Creature.restartNextCreatureNumber();
    list = new CreatureList();
    list.addElephant(new Creature(Species.ELEPHANT)); // adds ELEPHANT 1
    expected = "ELEPHANT 1 -> END";
    actual = list.toString();

    if (!expected.equals(actual)) {
      System.out.println("testAddCreatures failed");
      System.out.println("Expected: " + expected + " Actual: " + actual);
      return false;
    }

    // Adding HUMAN to an empty list
    Creature.restartNextCreatureNumber();
    list = new CreatureList();
    list.addHuman(new Creature(Species.HUMAN)); // adds HUMAN 1
    expected = "HUMAN 1 -> END";
    actual = list.toString();

    if (!expected.equals(actual)) {
      System.out.println("testAddCreatures failed");
      System.out.println("Expected: " + expected + " Actual: " + actual);
      return false;
    }

    // Adding TURTLE to an empty list
    Creature.restartNextCreatureNumber();
    list = new CreatureList();
    list.addTurtle(new Creature(Species.TURTLE)); // adds TURTLE 1
    expected = "TURTLE 1 -> END";
    actual = list.toString();

    if (!expected.equals(actual)) {
      System.out.println("testAddCreatures failed");
      System.out.println("Expected: " + expected + " Actual: " + actual);
      return false;
    }

    // General Test
    Creature.restartNextCreatureNumber();
    list = new CreatureList();
    list.addElephant(new Creature(Species.ELEPHANT)); // adds ELEPHANT 1

    // Adding to head of the list
    list.addHuman(new Creature(Species.HUMAN)); // adds HUMAN 2 at the head of the list

    // Adding to the middle of the list
    list.addElephant(new Creature(Species.ELEPHANT)); // adds ELEPHANT 3

    // Adding to the end of the list
    list.addTurtle(new Creature(Species.TURTLE)); // adds TURTLE 4 at the end of the list

    expected = "HUMAN 2 -> ELEPHANT 3 -> ELEPHANT 1 -> TURTLE 4 -> END";
    actual = list.toString();

    if (!expected.equals(actual)) {
      System.out.println("testAddCreatures failed");
      System.out.println("Expected: " + expected + " Actual: " + actual);
      return false;
    }

    // Test passed
    System.out.println("testAddCreatures passed");
    return true;
  }

  /**
   * Checks for the correctness of the CreatureList.removeCreature(), CreatureList.removeHuman(),
   * and CreatureList.removeTurtle() methods
   * 
   * @return true if test passed
   */
  public static boolean testRemoveCreatures() {
    Creature.restartNextCreatureNumber();
    String expected1;
    String actual1;
    String expected2;
    String actual2;
    CreatureList list;

    list = new CreatureList();
    list.addElephant(new Creature(Species.ELEPHANT)); // adds ELEPHANT 1
    list.addHuman(new Creature(Species.HUMAN)); // adds HUMAN 2 at the head of the list
    list.addElephant(new Creature(Species.ELEPHANT)); // adds ELEPHANT 3
    list.addTurtle(new Creature(Species.TURTLE)); // adds TURTLE 4 at the end of the list
    list.addHuman(new Creature(Species.HUMAN)); // adds HUMAN 5 at the head of the list

    // At this point, the list is
    // HUMAN 5 -> HUMAN 2 -> ELEPHANT 3 -> ELEPHANT 1 -> TURTLE 4 -> END

    // Remove from the middle
    list.removeCreature(1); // removes ELEPHANT 1

    // Remove from the end
    list.removeTurtle(); // removes TURTLE 4

    // Remove from the middle
    list.removeCreature(3); // removes ELLEPHANT 3

    // Remove from the front
    list.removeHuman(); // removes HUMAN 5

    // The list should be HUMAN 2 -> END

    expected1 = "HUMAN 2 -> END";
    actual1 = list.toString();

    if (!actual1.equals(expected1)) {
      System.out.println("testRemoveCreatures failed");
      System.out.println("Expected: " + expected1 + " Actual: " + actual1);
      return false;
    }

    // Removing a creature of creatureNumber that doesn't exist in the list
    try {
      list.removeCreature(5);
    } catch (NoSuchElementException e) {
      e.getMessage();
    }
    
    list.removeHuman(); // removes HUMAN 2

    // The list should be empty
    expected2 = "";
    actual2 = list.toString();

    if (!actual2.equals(expected2)) {
      System.out.println("testRemoveCreatures failed");
      System.out.println("Expected: " + expected2 + " Actual: " + actual2);
      return false;
    }

    // Removing human from an empty list
    try {
      list.removeHuman();
    } catch (NoSuchElementException e) {
      e.getMessage();
    }

    // Removing turtle from an empty list
    Creature.restartNextCreatureNumber();
    list = new CreatureList();
    try {
      list.removeTurtle();
    } catch (NoSuchElementException e) {
      e.getMessage();
    }

    // Test passed
    System.out.println("testRemoveCreatures passed");
    return true;
  }

  /**
   * Checks for the correctness of the CreatureList.get() method
   * 
   * @return true if test passed
   */
  public static boolean testGetCreatures() {
    Creature.restartNextCreatureNumber();
    String expected;
    Creature expectedCreature;
    Creature actualCreature;
    String actual;
    CreatureList list = new CreatureList();

    // Empty list
    try {
      list.get(1);
    } catch (IndexOutOfBoundsException e) {
      e.getMessage();
    }

    list.addElephant(new Creature(Species.ELEPHANT)); // adds ELEPHANT 1
    list.addHuman(new Creature(Species.HUMAN)); // adds HUMAN 2 at the head of the list
    list.addElephant(new Creature(Species.ELEPHANT)); // adds ELEPHANT 3
    list.addTurtle(new Creature(Species.TURTLE)); // adds TURTLE 4 at the end of the list
    list.addHuman(new Creature(Species.HUMAN)); // adds HUMAN 5 at the head of the list

    // At this point, the list is
    // HUMAN 5 -> HUMAN 2 -> ELEPHANT 3 -> ELEPHANT 1 -> TURTLE 4 -> END

    expected = "HUMAN 2";
    actualCreature = list.get(1);
    actual = actualCreature.toString();

    if (!expected.equals(actual)) {
      System.out.println("testGetCreatures failed");
      System.out.println("Expected: " + expected + " Actual: " + actual);
      return false;
    }

    // Test passed
    System.out.println("testGetCreatures passed");
    return true;
  }

  /**
   * A test suite method to run all test methods
   * 
   * @return
   */
  public static boolean runAllTests() {
    if (!testLinkedCreature()) {
      return false;
    }
    if (!testClear()) {
      return false;
    }
    if (!testAddCreatures()) {
      return false;
    }
    if (!testRemoveCreatures()) {
      return false;
    }
    if (!testGetCreatures()) {
      return false;
    }

    System.out.println("All tests have passed");
    return true;
  }

  /**
   * Helper method to display the size and the count of different creatures stored in a creatureList
   * 
   * @param list a reference to an CreatureList object
   * @throws NullPointerException if list is null
   */
  private static void displaySizeCounts(CreatureList list) {
    System.out.println(
        " Size: " + list.size() + ", humanCount: " + list.getHumanCount() + ", elephantCount: "
            + list.getElephantCount() + ", turtleCount: " + list.getTurtleCount());
  }

  /**
   * Demo method showing how to use the implemented classes in P04 Creature Tower
   * 
   * @param args input arguments
   */
  public static void demo() {
    Creature.restartNextCreatureNumber();
    // Create a new empty CreatureList object
    CreatureList list = new CreatureList();
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    // Add an ELEPHANT to an empty list
    list.addElephant(new Creature(Species.ELEPHANT)); // adds ELEPHANT 1
    System.out.println(list); // prints list's content
    list.addHuman(new Creature(Species.HUMAN)); // adds HUMAN 2 at the head of the list
    System.out.println(list); // prints list's content
    list.addElephant(new Creature(Species.ELEPHANT)); // adds ELEPHANT 3
    System.out.println(list); // prints list's content
    list.addHuman(new Creature(Species.HUMAN)); // adds HUMAN 4
    System.out.println(list); // prints list's content
    list.addHuman(new Creature(Species.HUMAN)); // adds HUMAN 5 at the head of the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    // Add more creatures to list and display its contents
    list.addTurtle(new Creature(Species.TURTLE)); // adds TURTLE 6 at the end of the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.addTurtle(new Creature(Species.TURTLE)); // adds TURTLE 7 at the end of the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeTurtle(); // removes TURTLE 7 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.addElephant(new Creature(Species.ELEPHANT)); // adds ELEPHANT 8
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeTurtle(); // removes TURTLE 6 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeHuman(); // removes HUMAN 5
    System.out.println(list); // prints list's content
    list.removeCreature(3); // removes ELEPHANT 3 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    try {
      list.removeCreature(25); // tries to remove creature 25
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    // remove all humans
    while (list.getHumanCount() != 0) {
      list.removeHuman();
    }
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeCreature(1); // removes ELEPHANT 1 from the list -> empty list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.addTurtle(new Creature(Species.TURTLE)); // adds TURTLE 9 to the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeCreature(8); // removes ELEPHANT 8 from the list TODO:jdsfopiajasfdpoisadfj
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeTurtle(); // removes TURTLE 9 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.addHuman(new Creature(Species.HUMAN)); // adds HUMAN 10 to the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeCreature(10); // removes HUMAN 10 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
  }

  /**
   * Main method that calls the tester methods
   * 
   * @param args - unused
   */
  public static void main(String[] args) {

    testLinkedCreature();
    runAllTests();
    demo();


  }

}
