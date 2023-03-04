import java.util.Scanner;

public class OnlineReservationSystem {

  private static Scanner sc = new Scanner(System.in);
  private static String[] trainNumber = {"T101", "T102", "T103", "T104", "T105"};
  private static String[] trainName = {"Train1", "Train2", "Train3", "Train4", "Train5"};

  private static String username = "admin";
  private static String password = "1234";

  public static void main(String[] args) {
    int option = 0;
    boolean loggedIn = false;
    do {
      System.out.println(" ");
      System.out.println("####################################");
      System.out.println("Welcome to Online Reservation System");
      System.out.println("####################################");
      System.out.println(" ");

      System.out.println("1. Login");
      System.out.println("2. Reservation");
      System.out.println("3. Cancellation");
      System.out.println("4. Exit");
      System.out.println(" ");
      System.out.print("Enter your option: ");
      option = sc.nextInt();

      switch (option) {
        case 1:
          loggedIn = login();
          break;
        case 2:
          if (loggedIn) {
            reservation();
          } else {
            System.out.println("Please login first to access reservation");
          }
          break;
        case 3:
          if (loggedIn) {
            cancellation();
          } else {
            System.out.println("Please login first to access cancellation");
          }
          break;
        case 4:
          System.out.println("Exiting the system");
          break;
        default:
          System.out.println("Invalid option. Please try again");
          break;
      }
    } while (option != 4);
  }

  private static boolean login() {
    System.out.println(" ");
    System.out.print("Enter username: ");
    String usernameInput = sc.next();
    System.out.println(" ");

    System.out.print("Enter password: ");
    String passwordInput = sc.next();
    System.out.println(" ");

    if (usernameInput.equals(username) && passwordInput.equals(password)) {
      System.out.println("Login successful");
      return true;
    } else {
      System.out.println("Login failed. Invalid username or password");
      return false;
    }
  }

  private static void reservation() {
    System.out.println(" ");
    System.out.println("Available trains:");
    for (int i = 0; i < trainNumber.length; i++) {
      System.out.println((i + 1) + ". " + trainNumber[i] + " - " + trainName[i]);
    }

    System.out.println(" ");
    System.out.print("Enter your choice of train number: ");
    int trainChoice = sc.nextInt();

    String selectedTrainNumber = trainNumber[trainChoice - 1];

    System.out.println(" ");
    System.out.print("Enter your class type (1. First Class, 2. Second Class): ");
    int classType = sc.nextInt();

    System.out.println(" ");
    System.out.print("Enter your date of journey (dd/mm/yyyy): ");
    String journeyDate = sc.next();

    System.out.println(" ");
    System.out.print("Enter your source: ");
    String source = sc.next();

    System.out.println(" ");
    System.out.print("Enter your destination: ");
    String destination = sc.next();

    System.out.println(" ");
    System.out.println("Reservation successful");
    System.out.println(" ");

    System.out.println("######### YOUR BOOKING DETAILS ########");
    System.out.println("Train Number: " + selectedTrainNumber);
    System.out.println("Train Name: " + trainName[trainChoice - 1]);
    System.out.println("Class Type: " + (classType == 1 ? "First Class" : "Second Class"));
    System.out.println("Date of Journey: " + journeyDate);
    System.out.println("Source: " + source);
    System.out.println("Destination: " + destination);
    System.out.println("#######################################");
  }

  private static void cancellation() {
    System.out.println(" ");
    System.out.print("Enter your PNR number: ");
    int pnrNumber = sc.nextInt();
    System.out.println(" ");
    System.out.println("Ticket with PNR number " + pnrNumber + " has been cancelled");
  }
}