//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: CustomProcess.java
// Files: WaitingQueueADT.java, CustomProcessQueue.java, ProcessSchedulerTests.java,
//////////////////// ProcessScheduler.java
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
 * This class represents a Custom Process with a burst time and unique process ID
 * 
 * @author Reece Lardy & Nick Hayden
 */
public class CustomProcess implements java.lang.Comparable<CustomProcess> {
  private static int nextProcessId = 1; // stores the id to be assigned to the next process
  // to be created
  private final int PROCESS_ID; // unique identifier for this process
  private int burstTime; // time required by this process for CPU execution

  /**
   * Constructor for custom process object
   */
  public CustomProcess(int burstTime) {
    // initialize fields
    this.PROCESS_ID = nextProcessId;
    // increment processID for next process
    nextProcessId++;
    this.burstTime = burstTime;
  }

  /**
   * Compares two custom processes and determines which process should be run first
   * 
   * @param other - the other custom process being compared
   * @return negative integer if this custom process should be run first, positive otherwise
   */
  public int compareTo(CustomProcess other) {
    // if this process' burst time is less than the other process' burst time
    if (this.burstTime < other.burstTime)
      // return a negative integer
      return -1;
    // if this process' burst time is greater than the other process' burst time
    else if (this.burstTime > other.burstTime)
      // return a positive integer
      return 1;
    // if this process' burst time is equal to the other process' burst time
    else
      // return a negative integer if this process has a lower process ID than the other process, a
      // positive integer otherwise
      return this.PROCESS_ID - other.PROCESS_ID;
  }

  /**
   * Getter method for process ID
   * 
   * @return int - Process ID
   */
  public int getProcessId() {
    return this.PROCESS_ID;
  }

  /**
   * Getter method for burst time
   * 
   * @return int - burst time
   */
  public int getBurstTime() {
    return this.burstTime;
  }
}
