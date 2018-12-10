//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: ProcessSchedulerTests.java
// Files: WaitingQueueADT.java, CustomProcessQueue.java
// Course: CS300 Fall 2018
//
// Author: Reece Lardy
// Email: RLardy@wisc.edu
// Lecturer's Name: Alexander Brooks
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Nick Hayden
// Partner Email: nhayden@wisc.edu
// Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// X Write-up states that pair programming is allowed for this assignment.
// X We have both read and understand the course Pair Programming Policy.
// X We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * This class tests of the Process Schedu;er project works properly
 * 
 * @author Nick Hayden Reece Lardy
 *
 */
public class ProcessSchedulerTests {
  /**
   * This method tests if the enqueue method in CustomProcessQueue works
   * 
   * @return if the method works
   */
  public static boolean testEnqueueCustomProcessQueue() {
    CustomProcessQueue testQueue = new CustomProcessQueue(); // create a queue to test on
    CustomProcess testProcess = new CustomProcess(7); // create processes to add to queue
    CustomProcess testProcess1 = new CustomProcess(8);

    if (!testQueue.isEmpty()) { // make should the heap is empty
      return false;
    }
    testQueue.enqueue(testProcess); // enqueue a value into the heap
    if (testQueue.isEmpty()) { // Make sure the heap is not empty
      return false;
    }
    if (testQueue.size() != 1) { // check to make sure that the heap size is one
      return false;
    }
    if (testQueue.peek() != testProcess) { // check to make sure that the root is testProcess
      return false;
    }
    if (testQueue.peek().getBurstTime() != testProcess.getBurstTime()) {
      // check to make sure the burst time is correct
      return false;
    }
    if (testQueue.peek().getProcessId() != testProcess.getProcessId()) {
      // check to make sure that the ProcessId is correct
      return false;
    }
    testQueue.enqueue(testProcess1); // enqueue testProcess1 into the heap
    if (testQueue.peek() != testProcess) { // make sure testProcess is still the root
      return false;
    }
    return true; // return true if all the tests pass
  }

  /**
   * This method checks to make sure that the Dequeue method works
   * 
   * @return if the method is true or not
   */
  public static boolean testDequeueCustomProcessQueue() {
    CustomProcessQueue testQueue = new CustomProcessQueue();// create a queue to test on
    CustomProcess testProcess = new CustomProcess(7); // create processes to add to queue
    CustomProcess testProcess1 = new CustomProcess(8);

    if (!testQueue.isEmpty()) { // make should the heap is empty
      return false;
    }
    testQueue.enqueue(testProcess); // enqueue testProcess onto the heap
    testQueue.enqueue(testProcess1); // enqueue testProcess1 onto the heap
    testQueue.dequeue(); // dequeue the heap
    if (testQueue.peek() != testProcess1) { // make sure that the heap properly dequeue
      return false;
    }
    return true; // return true if the method works
  }

  /**
   * the method tests that size method of the custom process Queue
   **/
  public static boolean testSizeCustomProcessQueue() {
    CustomProcessQueue testQueue = new CustomProcessQueue(); // create a queue to test on
    CustomProcess testProcess = new CustomProcess(7); // create processes to add to queue
    CustomProcess testProcess1 = new CustomProcess(8);
    if ((testQueue.size() != 0)) { // make sure the size is not equal to 0
      return false;
    }
    testQueue.enqueue(testProcess); // enqueue the heap
    if ((testQueue.size() != 1)) { // make sure the size is equal to 1
      return false;
    }
    testQueue.enqueue(testProcess1); // enqueue the heap
    if ((testQueue.size() != 2)) { // make sure the size is equal to 2
      return false;
    }
    return true; // return true if the tests
  }

  /**
   * the method tests to make peek method works
   * 
   * @return
   */
  public static boolean testPeekCustomProcessQueue() {
    CustomProcessQueue testQueue = new CustomProcessQueue();// create a queue to test on
    CustomProcess testProcess = new CustomProcess(7);// create processes to add to queue
    CustomProcess testProcess1 = new CustomProcess(3);
    if (testQueue.peek() != null) { // make sure peek returns null when the heap is empty
      return false;
    }
    testQueue.enqueue(testProcess); // enqueue test Process onto the heap
    if (testQueue.peek() != testProcess) { // make sure heap returns test process
      return false;
    }
    testQueue.enqueue(testProcess1); // enqueue thestProcess1 onto the heap
    if (testQueue.peek() != testProcess1) { // make sure peek returns testProcess1
      return false;
    }
    return true; // return true if all tests pass
  }

  /**
   * method that calls all other tests methods
   * 
   * @param args
   */
  public static void main(String[] args) {
    boolean testStatus = true; // Status that checks if tests pass
    if (!testSizeCustomProcessQueue()) { // test to make sure testSizeCustomProcessQueue works
      testStatus = false;
      System.out.println("testSizeCustomProcessQueue failed.");
    }
    if (!testPeekCustomProcessQueue()) { // test to make sure testPeekCustomProcessQueue works
      testStatus = false;
      System.out.println("testPeekCustomProcessQueue failed.");
    }
    if (!testEnqueueCustomProcessQueue()) {// test to make sure testEnqueueCustomProcessQueue works
      testStatus = false;
      System.out.println("testEnqueueCustomProcessQueue failed.");
    }
    if (!testDequeueCustomProcessQueue()) {// test to make sure testEnqueueCustomProcessQueue works
      testStatus = false;
      System.out.println("testDequeueCustomProcessQueue failed.");
    }

    if (testStatus) { // if all the methods pass
      System.out.println("All tests passed!");
    }
  }
}
