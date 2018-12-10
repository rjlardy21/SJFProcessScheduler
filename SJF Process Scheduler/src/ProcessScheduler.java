//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: ProcessScheduler.java
// Files: WaitingQueueADT.java, CustomProcessQueue.java, ProcessSchedulerTests.java,
//////////////////// CustomProcess.java
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
import java.util.Scanner; // import scanner class to get user input

/**
 * The ProcessScheduler class represents the data type for the main scheduler for our processes.
 * 
 * @author Reece Lardy & Nick Hayden
 */
public class ProcessScheduler {
  private int currentTime; // stores the current time after the last run
  private int numProcessesRun; // stores the number of processes run so far
  private CustomProcessQueue queue; // this processing unit's custom process queue

  /**
   * Constructor for a new Process Scheduler
   */
  public ProcessScheduler() {
    // Initialize time and processes run to 0 and creates a new queue for holding custom processes
    this.currentTime = 0;
    this.numProcessesRun = 0;
    this.queue = new CustomProcessQueue();
  }

  /**
   * Adds a process to the custom process queue
   * 
   * @param process - the new process that is being added to the queue
   */
  public void scheduleProcess(CustomProcess process) {
    // add the new process to the queue
    queue.enqueue(process);
    // print status update
    System.out.println("Process ID " + process.getProcessId() + " scheduled. Burst Time = "
        + process.getBurstTime());
  }

  /**
   * Runs all of the processes in the queue in order of smallest to largest burst time. If two
   * processes have the same burst time, the lower ID process runs first
   * 
   * @return log - a string containing a log of the method call
   */
  public String run() {
    // create empty log string
    String log = "";
    // add status update to log
    log = log.concat("Starting " + this.queue.size() + " processes\n\n");
    // while the queue is not empty
    while (this.queue.size() != 0) {
      // add status update to log
      log = log.concat("Time " + currentTime + " : Process ID " + this.queue.peek().getProcessId()
          + " Starting.\n");
      // increment the number of processes run
      numProcessesRun++;
      // increment the current time by the burst time of the process about to run
      currentTime = currentTime + this.queue.peek().getBurstTime();
      // dequeue the process and add another status update to log
      log = log.concat("Time " + currentTime + ": Process ID " + queue.dequeue().getProcessId()
          + " Completed.\n");
    }
    // add final update to log
    log = log.concat("\nTime " + currentTime + ": All scheduled processes completed.\n");
    // return the log
    return log;
  }

  /**
   * Driver method allowing users to use the ProcessScheduler application
   */
  public static void main(String[] args) {
    // create new process scheduler and scanner objects
    ProcessScheduler ps = new ProcessScheduler();
    Scanner sc = new Scanner(System.in);
    // create variables to be used by driver
    String command;
    // initialize boolean to true, representing whether or not the user is using process scheduler
    boolean active = true;
    String[] schedule;
    int btime;
    // initialize a string to hold the invalid command error message
    String cmderrormsg = "WARNING: Please enter a valid command!\n";
    // print welcome message
    System.out.println("==========   Welcome to the SJF Process Scheduler App   ========\n");
    // while user is using process scheduler
    while (active) {
      // print menu
      System.out.println("Enter command:");
      System.out.println("[schedule <burstTime>] or [s <burstTime>]");
      System.out.println("[run] or [r]");
      System.out.println("[quit] or [q]\n");
      // hold users input in command string
      command = sc.nextLine();
      command = command.trim();
      // if user input matches run command input
      if (command.toLowerCase().trim().equals("run") || command.toLowerCase().trim().equals("r")) {
        // print the log from run method call
        System.out.println(ps.run());
      }
      // if user input does not match run but matches schedule command input
      else if (command.toLowerCase().trim().startsWith("schdule ")
          || command.toLowerCase().trim().startsWith("s ")) {
        // split the command at the space in between the command and the integer
        schedule = command.split(" ");
        // if there is user input after the space after the schedule command
        if (schedule[1] != null) {
          // try and get the int value of the rest of the input
          try {
            // initialize burst time variable to the int value of the rest of input
            btime = Integer.valueOf(schedule[1]);
            // if burst time is 0 or smaller, print error message
            if (btime <= 0) {
              System.out.println("WARNING: burst time MUST be greater than 0!\n");
            }
            // if burst time is valid (>0)
            else {
              // create a new process with input burst time
              CustomProcess newProcess = new CustomProcess(btime);
              // schedule the new process
              ps.scheduleProcess(newProcess);
              System.out.println("");
            }
          }
          // if the rest of the user input was not an int
          catch (NumberFormatException e) {
            // print error message
            System.out.println("WARNING: burst time MUST be an integer!\n");
          }
        }
        // if the user provided no input after the space after the schedule command
        else {
          // print the command error message
          System.out.println(cmderrormsg);
        }
        // if the user input matches quit command input
      } else if (command.toLowerCase().trim().equals("quit")
          || command.toLowerCase().trim().equals("q")) {
        // print a goodbye message
        System.out.println(ps.numProcessesRun + " processes run in " + ps.currentTime
            + " units of time!\n" + "Thank you for using our scheduler!\n" + "Goodbye!\n");
        // set active to false to stop using the app and break out of the while loop
        active = false;
        break;
      }
      // if user input did not match any accepted command
      else
        // print the command error message
        System.out.println(cmderrormsg);
    }
    // close scanner
    sc.close();
  }
}
