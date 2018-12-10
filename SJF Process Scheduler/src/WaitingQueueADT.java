//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: WaitingQueueADT.java
// Files: CustomProcess.java, CustomProcessQueue.java, ProcessSchedulerTests.java,
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
 * The WaitingQueueADT class represents the Abstract Data Type that represents the pattern for our
 * ready processes waiting list.
 * 
 * @author Reece Lardy & Nick Hayden
 * @see Comparable<T>
 */
public interface WaitingQueueADT<T extends Comparable<T>> {

  public void enqueue(T newObject); // inserts a newObject in the priority queue

  public T dequeue(); // removes and returns the item with the highest priority

  public T peek(); // returns without removing the item with the highest priority

  public int size(); // returns size of the waiting queue

  public boolean isEmpty(); // checks if the waiting queue is empty
}
