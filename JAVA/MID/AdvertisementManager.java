import java.util.ArrayList;
import java.util.Scanner;

class Advertisement {
    private static int next_id = 1;

    protected int advertisement_Id;
    protected String client_Name;
    protected String start_Date;

    public Advertisement(String client_Name, String start_Date) {
        this.advertisement_Id = next_id++;
        this.client_Name = client_Name;
        this.start_Date = start_Date;
    }
}

class Commercial_Add extends Advertisement {
    private int size_Of_Add;
    private double pricePerCm;

    public Commercial_Add(String client_Name, String start_Date, int size_Of_Add, double pricePerCm) {
        super(client_Name, start_Date);
        this.size_Of_Add = size_Of_Add;
        this.pricePerCm = pricePerCm;
    }

    public int getsize_Of_Add() {
        return size_Of_Add;
    }

    public double getPricePerCm() {
        return pricePerCm;
    }

    public double addCost() {
        return size_Of_Add * pricePerCm;
    }
}

class Free_Add extends Advertisement {
    private int Free_Add_Time_Duration;

    public Free_Add(String client_Name, String start_Date, int Free_Add_Time_Duration) {
        super(client_Name, start_Date);
        this.Free_Add_Time_Duration = Free_Add_Time_Duration;
    }

    public int getFree_Add_Time_Duration() {
        return Free_Add_Time_Duration;
    }
}

public class AdvertisementManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Advertisement> ads_List = new ArrayList<>();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Read values for Commercial Add");
            System.out.println("2. Read values for Free Add");
            System.out.println("3. Display values of Commercial Add and Free Add instances");
            System.out.println("4. Display the add cost for commercial add for the given advertisement id");
            System.out.println("5. Display all the free adds with a duration more than 3 months");
            System.out.println("6. Display the total income from commercial add");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    readCommercial_Add(scanner, ads_List);
                    break;
                case 2:
                    readFree_Add(scanner, ads_List);
                    break;
                case 3:
                    displayAdvertisementDetails(ads_List);
                    break;
                case 4:
                    displayCommercial_AddCost(scanner, ads_List);
                    break;
                case 5:
                    displayFree_AddsMoreThan3Months(ads_List);
                    break;
                case 6:
                    displayTotalIncomeFromCommercial_Add(ads_List);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void readCommercial_Add(Scanner scanner, ArrayList<Advertisement> ads_List) {
        System.out.println("Enter client name:");
        String client_Name = scanner.next();
        System.out.println("Enter start date:");
        String start_Date = scanner.next();
        System.out.println("Enter size of add in cm:");
        int size_Of_Add = scanner.nextInt();
        System.out.println("Enter price per cm:");
        double pricePerCm = scanner.nextDouble();

        Commercial_Add Commercial_Add = new Commercial_Add(client_Name, start_Date, size_Of_Add, pricePerCm);
        ads_List.add(Commercial_Add);
    }

    private static void readFree_Add(Scanner scanner, ArrayList<Advertisement> ads_List) {
        System.out.println("Enter client name:");
        String client_Name = scanner.next();
        System.out.println("Enter start date:");
        String start_Date = scanner.next();
        System.out.println("Enter free add time duration in months:");
        int Free_Add_Time_Duration = scanner.nextInt();

        Free_Add Free_Add = new Free_Add(client_Name, start_Date, Free_Add_Time_Duration);
        ads_List.add(Free_Add);
    }

    private static void displayAdvertisementDetails(ArrayList<Advertisement> ads_List) {
        for (Advertisement ad : ads_List) {
            if (ad instanceof Commercial_Add) {
                Commercial_Add Commercial_Add = (Commercial_Add) ad;
                System.out.println("Commercial Add - ID: " + Commercial_Add.advertisement_Id +
                        ", Client: " + Commercial_Add.client_Name +
                        ", Start Date: " + Commercial_Add.start_Date +
                        ", Size: " + Commercial_Add.getsize_Of_Add() + " cm" +
                        ", Price: $" + Commercial_Add.getPricePerCm() + " per cm" +
                        ", Cost: $" + Commercial_Add.addCost());
            } else if (ad instanceof Free_Add) {
                Free_Add Free_Add = (Free_Add) ad;
                System.out.println("Free Add - ID: " + Free_Add.advertisement_Id +
                        ", Client: " + Free_Add.client_Name +
                        ", Start Date: " + Free_Add.start_Date +
                        ", Duration: " + Free_Add.getFree_Add_Time_Duration() + " months");
            }
        }
    }

    private static void displayCommercial_AddCost(Scanner scanner, ArrayList<Advertisement> ads_List) {
        System.out.println("Enter Advertisement ID for Commercial Add:");
        int adId = scanner.nextInt();

        for (Advertisement ad : ads_List) {
            if (ad instanceof Commercial_Add && ad.advertisement_Id == adId) {
                Commercial_Add Commercial_Add = (Commercial_Add) ad;
                System.out.println("Advertisement ID: " + adId +
                        ", Client: " + Commercial_Add.client_Name +
                        ", Start Date: " + Commercial_Add.start_Date +
                        ", Cost: $" + Commercial_Add.addCost());
                return;
            }
        }

        System.out.println("Commercial Add with Advertisement ID " + adId + " not found.");
    }

    private static void displayFree_AddsMoreThan3Months(ArrayList<Advertisement> ads_List) {
        for (Advertisement ad : ads_List) {
            if (ad instanceof Free_Add) {
                Free_Add Free_Add = (Free_Add) ad;
                if (Free_Add.getFree_Add_Time_Duration() > 3) {
                    System.out.println("Free Add - ID: " + Free_Add.advertisement_Id +
                            ", Client: " + Free_Add.client_Name +
                            ", Start Date: " + Free_Add.start_Date +
                            ", Duration: " + Free_Add.getFree_Add_Time_Duration() + " months");
                }
            }
        }
    }

    private static void displayTotalIncomeFromCommercial_Add(ArrayList<Advertisement> ads_List) {
        double totalIncome = 0;
        for (Advertisement ad : ads_List) {
            if (ad instanceof Commercial_Add) {
                Commercial_Add Commercial_Add = (Commercial_Add) ad;
                totalIncome += Commercial_Add.addCost();
            }
        }
        System.out.println("Total Income from Commercial Adds: $" + totalIncome);
    }
}
