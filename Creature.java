
/**
 * This class models a Species used for creature towers
 * 
 * @author chris
 *
 */
public class Creature {
  private static int nextCreatureNumber = 1; // generator of unique inventory numbers
  private Species Species; // Species of this box
  private final int CREATURE_NUMBER; // unique inventory number of this box

  /**
   * Creates a new creature and initializes its instance fields Species and unique creature number
   * 
   * @param Species Species to be assigned of this box. It can be any of the constant Species values
   *              defined in the enum Species: Species.HUMAN, Species.ELEPHANT, or Species.TURTLE
   */
  public Creature(Species Species) {
    this.Species = Species;
    this.CREATURE_NUMBER = nextCreatureNumber++;
  }

  /**
   * Returns the Species of this creature
   * 
   * @return the Species of this creature
   */
  public Species getSpecies() {
    return Species;
  }

  /**
   * returns the creature number of this creature
   * 
   * @return the unique creature number of this creature
   */
  public int getCreatureNumber() {
    return this.CREATURE_NUMBER;
  }


  /**
   * Returns a String representation of this box in the format "Species CREATURE_NUMBER"
   *
   * @return a String representation of this creature
   */
  @Override
  public String toString() {
    return Species.toString() + " " + this.CREATURE_NUMBER;
  }

  /**
   * This method sets the nextCreatureNumber to 1. This method must be used in your tester methods
   * only.
   */
  public static void restartNextCreatureNumber() {
    nextCreatureNumber = 1;
  }
}
