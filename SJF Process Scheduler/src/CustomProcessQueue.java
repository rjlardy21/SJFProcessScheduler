//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: CustomProcessQueue.java
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
 * This class represents a Custom Process Queue which is represented as a min heap
 * 
 * @author Reece Lardy & Nick Hayden
 */
public class CustomProcessQueue implements WaitingQueueADT<CustomProcess> {
  private static final int INITIAL_CAPACITY = 20; // the initial capacity of the heap
  private CustomProcess[] heap; // array-based min heap storing the data. This is an oversize array
  private int size; // number of CustomProcesses present in this CustomProcessQueue
  /*
   * Constructor for CustomProcessQueue
   */

  public CustomProcessQueue() {
    this.heap = new CustomProcess[INITIAL_CAPACITY]; // create heap with initial capacity
    this.size = 0; // set starting size to 0
  }

  /**
   * method that percolates up a number so that the min heap is in the proper order
   **/
  private void minHeapPercolateUp(int index) {
    CustomProcess x = heap[index]; // set the value to percolate up to x
    while (index > 1 && x.compareTo(heap[index / 2]) < 0) { // Of the index is not the root and
      // the value at the index is greater than its parent
      heap[index] = heap[index / 2]; // If it is bigger switch the two values
      index = index / 2; // change index value to check if the parent should be switched
    }
    heap[index] = x; // set the value at index to the smallest value in the heap.
  }

  /**
   * method that percolated down a number so that the min heap is in the proper order
   **/
  private void minHeapPercolateDown(int index) {
    heap[index] = heap[size]; // set the root value to the bottom value of the heap
    heap[size] = null; // set last value to null so you remove it
    size--; // decrease size by one
    CustomProcess temp; // make a temp variable
    while (index < size && heap[index].compareTo(heap[index * 2]) > 0) { // loop that proceeds
      // if the index is in the heap and the value is bigger than its child
      if (heap[index * 2 + 1] != null && heap[index * 2].compareTo(heap[index * 2 + 1]) > 0) {
        // check to see if the right child value is bigger than the left one
        temp = heap[index * 2 + 1]; // switch child and parent value
        heap[index * 2 + 1] = heap[index];
        heap[index] = temp;
        index = index * 2 + 1; // set index value to child value
      } else { // if the left child is bigger than the right child or the right child is null
        temp = heap[index * 2]; // switch child and parent value
        heap[index * 2] = heap[index];
        heap[index] = temp;
        index = index * 2; // set index value to child value
      }
    }

  }

  @Override
  /**
   * method that adds a value to the heap in the correct position
   * 
   * @see WaitingQueueADT#enqueue(java.lang.Comparable)
   **/
  public void enqueue(CustomProcess newObject) {
    if (size == heap.length - 1) // if the size is too small double the size
      doubleSize();
    int pos = ++size; // increase size and set that to pos
    heap[pos] = newObject; // add the newobject to the end of the heap
    minHeapPercolateUp(pos); // percolate up the value so its in the right position
  }

  /**
   * class that doubles the size of the heap
   **/
  private void doubleSize() {
    CustomProcess[] newHeap = new CustomProcess[(heap.length * 2)];// make new heap with double
    // the size
    newHeap = heap.clone(); // put values from first heap in second heap
    heap = newHeap; // set heap to the new heap
  }

  @Override
  /**
   * method that removes a value to the heap and adjusts the heap so its correct
   * 
   * @see WaitingQueueADT#dequeue()
   **/
  public CustomProcess dequeue() {
    CustomProcess temp; // create a temp variable
    if (this.size() == 0) // if the heap is empty return null
      return null;
    else {
      temp = heap[1]; // set root of heap to temp value
      heap[1] = null; // remove root from heap
      minHeapPercolateDown(1); // percolate down the root value
      return temp; // return the removed root value
    }
  }

  @Override
  /**
   * see what the root value in the heap is
   * 
   * @see WaitingQueueADT#peek()
   **/
  public CustomProcess peek() {
    if (this.size() == 0) // is the heap is empty return null
      return null;
    else
      return this.heap[1]; // return root of the heap
  }


  @Override
  /**
   * returns the size of the heap
   * 
   * @see WaitingQueueADT#size()
   **/
  public int size() {
    this.size = 0; // set size to 0
    for (int i = 0; i < heap.length; i++) { // loop through the heap
      if (heap[i] != null) {
        this.size++; // count each loop value that is not null
      }
    }
    return this.size; // return size of heap
  }

  @Override
  /**
   * checks to see if the heap is empty
   * 
   * @see WaitingQueueADT#isEmpty()
   **/
  public boolean isEmpty() {
    if (this.size() == 0) // if the heap is empty return true
      return true;
    else
      return false; // if not return false
  }

}
