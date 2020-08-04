//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (Jungle Park 2000)
// Files: (JunglePark.java ParkGUI.java Animal.java Tiger.java Deer.java AddAnimalButton.java
//////////////////// ClearButton.java JungkeParkTests.java)
// Course: (001 SUMMER 2019)
//
// Author: (Rosalie CAI)
// Email: (rcai25@wisc.edu)
// Lecturer's Name: (Mouna KACEM)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (Jiong Chen)
// Partner Email: (jchen672@wisc.edu)
// Partner Lecturer's Name: (Mouna KACEM)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (NONE)
// Online Sources: (NONE)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.ArrayList;

public class JungleParkTests extends JunglePark {

  private static JunglePark park; // PApplet object that represents the display
                                  // window of this program

  /**
   * This method checks whether isClose() called by a Deer returns true if a tiger is within its
   * scanRange area and false if called with another tiger as input parameter located outside the
   * scanRange area
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean test1isCloseMethod() {
    boolean passed = true;

    // This is an example. You can define your own test scenario for this method
    // Create a deer and two tigers
    Deer d = new Deer(park);
    Tiger t1 = new Tiger(park);
    Tiger t2 = new Tiger(park);
    // Set deer at position(200,200)
    d.setPositionX(200);
    d.setPositionY(200);

    // Set first tiger at position(400,200)
    t1.setPositionX(400); // tiger is 200px away from deer
    t1.setPositionY(200);

    // Set second tiger at position(300,200)
    t2.setPositionX(300); // tiger is 100px away from deer
    t2.setPositionY(200);

    if (d.isClose(t1, 175)) { // bug! isClose() should return false here
      System.out.println("Deer's isClose is returning true when it should return false.");
      passed = false;
    }
    if (!d.isClose(t2, 175)) { // bug! isClose() should return true here
      System.out.println("Deer's isClose is returning false when it should return true.");
      passed = false;
    }

    /////////////////////////////////////
    park.listGUI.clear(); // clear all the content of listGUI to get ready for a next scenario

    return passed;
  }

  /**
   * This method checks whether isClose() called by a Tiger returns false if another tiger is
   * located outside its scanRange area
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean test2isCloseMethod() {
    boolean passed = true;
    // TODO Define your test scenario here

    // Create two tigers
    Tiger t1 = new Tiger(park);
    Tiger t2 = new Tiger(park);

    // Set third tiger at position(200,200)
    t1.setPositionX(200);
    t1.setPositionY(200);


    // Set first tiger at position(400,200)
    t2.setPositionX(400); // tiger is 200px away from deer
    t2.setPositionY(200);

    if (t1.isClose(t2, 175)) { // bug! isClose() should return false here
      System.out.println("Tiger's isClose is returning true when it should return false.");
      passed = false;
    }

    /////////////////////////////////////
    park.listGUI.clear(); // clear all the content of listGUI to get ready for a next scenario

    return passed;
  }


  // /**
  // * This method checks whether isClose() called by a Tiger returns true if another tiger is
  // located
  // * inside its scanRange area
  // *
  // * @return true when test verifies correct functionality, and false otherwise.
  // */
  // public static boolean test3isCloseMethod() {
  // boolean passed = true;
  // // TODO Define your test scenario here
  //
  // // Create two tigers
  //
  // Tiger t1 = new Tiger(park);
  // Tiger t2 = new Tiger(park);
  //
  //
  // // Set third tiger at position(200,200)
  // t1.setPositionX(200);
  // t1.setPositionY(200);
  //
  //
  // // Set second tiger at position(300,200)
  // t2.setPositionX(300); // tiger is 100px away from deer
  // t2.setPositionY(200);
  //
  //
  // if (!t1.isClose(t2, 175)) { // bug! isClose() should return false here
  // System.out.println("Tiger's isClose is returning false when it should return true.");
  // passed = false;
  // }
  //
  // /////////////////////////////////////
  // park.listGUI.clear(); // clear all the content of listGUI to get ready for a next scenario
  //
  // return passed;
  // }

  /**
   * This method checks whether the deer detects a Tiger present at its proximity
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean test1DeerScanForThreatMethod() {
    boolean passed = true;

    // Create a deer and a tiger
    Deer d = new Deer(park);
    Tiger t1 = new Tiger(park);

    // Set deer at position(200,200)
    d.setPositionX(200);
    d.setPositionY(200);
    // Set second tiger at position(300,200)
    t1.setPositionX(300); // tiger is 100px away from deer
    t1.setPositionY(200);

    // add tiger and deer to listGUI
    park.listGUI.add(d);
    park.listGUI.add(t1);

    if (!d.scanForThreat(175)) { // bug! ScanForThreat() should return true here
      System.out.println("Deer's scanForThreat is returning false when it should return true.");
      passed = false;
    }

    /////////////////////////////////////
    park.listGUI.clear(); // clear all the content of listGUI to get ready for a next scenario

    return passed;
  }

  /**
   * This method checks whether your scanForThreat() method returns false if no Tiger is present
   * within a specific range distance from it
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean test2DeerScanForThreatMethod() {
    boolean passed = true;
    // TODO Define your test scenario here
    // Create a deer and a tiger
    Deer d = new Deer(park);
    Tiger t1 = new Tiger(park);
    // Set deer at position(200,200)
    d.setPositionX(200);
    d.setPositionY(200);
    // Set first tiger at position(400,200)
    t1.setPositionX(400); // tiger is 200px away from deer
    t1.setPositionY(200);


    // add tiger and deer to listGUI
    park.listGUI.add(d);
    park.listGUI.add(t1);

    if (d.scanForThreat(175)) { // bug! ScanForThreat() should return false here
      System.out.println("Deer's scanForThreat is returning true when it should return false.");
      passed = false;
    }


    /////////////////////////////////////
    park.listGUI.clear(); // clear all the content of listGUI to get ready for a next scenario

    return passed;
  }

  /**
   * This method checks whether the tiger hops on the deer provided to the hop() method as input
   * argument. (1) The tiger should take the position of the deer. (2) The unfortunate deer should
   * be removed from the JunglePark listGUI. (3) The eatenDeerCount should be incremented.
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean testTigerHopMethod() {
    boolean passed = true;
    // This is an example. You may develop different scenarios to assess further the correctness of
    // your hop() method
    // Create one deer and one tiger
    Deer d = new Deer(park);
    Tiger t = new Tiger(park);

    // Set the deer at position(250,250)
    d.setPositionX(250);
    d.setPositionY(250);

    // Set the tiger at position(300,300) tiger is 70.71px away from deer d1
    t.setPositionX(300);
    t.setPositionY(300);

    // add the tiger and the deer to the JunglePark (i.e. to listGUI)
    park.listGUI.add(d);
    park.listGUI.add(t);
    t.hop(d); // tiger hops on the deer
    if (t.getPositionX() != d.getPositionX() && t.getPositionY() != d.getPositionY()) {
      // tiger should move to the position of the deer
      System.out.println("Tiger did not move correctly when hopping.");
      passed = false;
    }
    if (park.listGUI.contains(d)) {
      // deer should be removed from the park
      System.out.println("Deer was not removed after being hopped on.");
      passed = false;
    }
    if (t.getDeerEatenCount() != 1) {
      // deerEatenCount should be incremented. It was 0
      System.out.println("deerEatenCount should be incremented after the tiger hopped on a deer.");
      passed = false;
    }

    /////////////////////////////////////
    park.listGUI.clear(); // clear all the content of listGUI to get ready for a next scenario

    return passed;
  }

  // /**
  // * This method checks whether the tiger action method is ok
  // *
  // * @return true when test verifies correct functionality, and false otherwise.
  // */
  // public static boolean testTigerActionMethod() {
  // boolean passed = true;
  //
  // // Create two deers and one tiger
  // Deer d = new Deer(park);
  // Deer d1 = new Deer(park);
  // Deer d2 = new Deer(park);
  // Tiger t = new Tiger(park);
  //
  // // Set the deer at position(250,250)
  // d.setPositionX(250);
  // d.setPositionY(250);
  //
  // // Set the deer1 at position(250,250)
  // d1.setPositionX(270);
  // d1.setPositionY(250);
  //
  // // Set the deer2 at position(250,250)
  // d2.setPositionX(270);
  // d2.setPositionY(270);
  //
  //
  // // Set the tiger at position(300,300) tiger is 70.71px away from deer d1
  // t.setPositionX(300);
  // t.setPositionY(300);
  //
  // // add the tiger and the deers to the JunglePark (i.e. to listGUI)
  // park.listGUI.add(d);
  // park.listGUI.add(t);
  // park.listGUI.add(d1);
  // park.listGUI.add(d2);
  //
  // // start eating deer
  // t.action();
  //
  // if (t.getDeerEatenCount() != 3) {
  // passed = false;
  // }
  //
  // /////////////////////////////////////
  // park.listGUI.clear(); // clear all the content of listGUI to get ready for a next scenario
  //
  // return passed;
  // }


  /**
   * runs JungleParkTests program as a PApplet client
   * 
   * @param args
   */
  public static void main(String[] args) {
    // Call PApplet.main(String className) to start this program as a PApplet client application
    PApplet.main("JungleParkTests");
  }

  /**
   * This is a callback method automatically called only one time when the PApplet application
   * starts as a result of calling PApplet.main("PAppletClassName"); Defines the initial environment
   * properties of this class/program As setup() is run only one time when this program starts, all
   * your test methods should be called in this method
   */
  @Override
  public void setup() {
    super.setup(); // calls the setup() method defined
    park = this; // set the park to the current instance of Jungle

    // TODO Call your test methods here
    System.out.println("test1isCloseMethod(): " + test1isCloseMethod());
    System.out.println("test2isCloseMethod(): " + test2isCloseMethod());
    System.out.println("test1DeerScanForThreatMethod(): " + test1DeerScanForThreatMethod());
    System.out.println("test2DeerScanForThreatMethod() : " + test2DeerScanForThreatMethod());
    System.out.println("testTigerHopMethod(): " + testTigerHopMethod());

//    System.out.println("testTigerActionMethod(): " + testTigerActionMethod());
    // close PApplet display window (No need for the graphic mode for these tests)
    park.exit();

  }



}
