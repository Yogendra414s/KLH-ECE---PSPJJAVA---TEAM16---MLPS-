import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] parking = new int[3][5];//co3 covered. 2d arrays
        int choice;
        do {//co2 covered.do while loop
            System.out.println("\n--- MULTI LEVEL PARKING SYSTEM ---");
            System.out.println("1. Park a vehicle");
            System.out.println("2. Remove a vehicle");
            System.out.println("3. View parking spaces");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {//co2 covered switch
                case 1: {
                    System.out.print("Enter vehicle number plate(positive integer): ");
                    int vehicle = sc.nextInt();
                    if (vehicle <= 0) {
                        System.out.println("Invalid vehicle number.");
                        break;
                    }

                    boolean alreadyParked = false;
                    for (int floor = 0; floor < parking.length; floor++) {
                        for (int space = 0; space < parking[floor].length; space++) {
                            if (parking[floor][space] == vehicle) {
                                alreadyParked = true;
                            }
                        }
                    }
                    if (alreadyParked) {
                        System.out.println("This vehicle is already parked.");
                        break;
                    }

                    boolean parked = false;
                    for (int floor = 0; floor < parking.length; floor++) {
                        for (int space = 0; space < parking[floor].length; space++) {
                            if (parking[floor][space] == 0 && !parked) {
                                parking[floor][space] = vehicle;
                                parked = true;
                                System.out.println("Vehicle parked on floor "
                                        + (floor + 1) + ", space " + (space + 1));
                            }
                        }
                    }
                    if (!parked) {
                        System.out.println("Parking is full.");
                    }
                    break;
                }
                case 2: {
                    System.out.print("Enter vehicle number: ");
                    int vehicle = sc.nextInt();
                    boolean found = false;
                    if (vehicle > 0) {
                        for (int floor = 0; floor < parking.length; floor++) {
                            for (int space = 0; space < parking[floor].length; space++) {
                                if (parking[floor][space] == vehicle) {
                                    parking[floor][space] = 0;
                                    found = true;
                                    System.out.println("Vehicle removed.");
                                }
                            }
                        }
                    }
                    if (!found) {
                        System.out.println("Vehicle not found.");
                    }
                    break;
                }
                case 3: {
                    int available = 0;
                    for (int floor = 0; floor < parking.length; floor++) {
                        System.out.println("\nFloor " + (floor + 1));
                        for (int space = 0; space < parking[floor].length; space++) {
                            System.out.print("Space " + (space + 1) + ": ");
                            if (parking[floor][space] == 0) {
                                System.out.println("Empty");
                                available++;
                            } else {
                                System.out.println("Vehicle " + parking[floor][space]);
                            }
                        }
                    }
                    System.out.println("\nAvailable spaces: " + available);
                    break;
                }
                case 4:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice,Enter 1 to 4");
            }
        } while (choice != 4);

        sc.close();
    }
}
