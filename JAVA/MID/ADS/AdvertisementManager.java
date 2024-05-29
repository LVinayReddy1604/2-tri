import java.util.Scanner;

class Advertisement {
    private static int nextId = 1;

    protected int Advertisement_id;
    protected String Client_Name;
    protected String start_date;

    public Advertisement(String Client_Name, String start_date) {
        this.Advertisement_id = nextId++;
        this.Client_Name = Client_Name;
        this.start_date = start_date;
    }
}

class Commercial_Add extends Advertisement {
    private int size_of_add;
    private double price_per_cm;

    public Commercial_Add(String Client_Name, String start_date, int size_of_add, double price_per_cm) {
        super(Client_Name, start_date);
        this.size_of_add = size_of_add;
        this.price_per_cm = price_per_cm;
    }

    public int getsize_of_add() {
        return size_of_add;
    }

    public double getprice_per_cm() {
        return price_per_cm;
    }

    public double addCost() {
        return size_of_add * price_per_cm;
    }
}

class Free_Add extends Advertisement {
    private int free_add_time_duration;

    public Free_Add(String Client_Name, String start_date, int free_add_time_duration) {
        super(Client_Name, start_date);
        this.free_add_time_duration = free_add_time_duration;
    }

    public int getfree_add_time_duration() {
        return free_add_time_duration;
    }
}

public class AdvertisementManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MAX_ADS = 50;
        Advertisement[] adsArray = new Advertisement[MAX_ADS];
        int adsCount = 0;

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
                    if (adsCount < MAX_ADS) {
                        adsArray[adsCount++] = readCommercial_Add(scanner);
                    } else {
                        System.out.println("Maximum number of advertisements reached!");
                    }
                    break;
                case 2:
                    if (adsCount < MAX_ADS) {
                        adsArray[adsCount++] = readFree_Add(scanner);
                    } else {
                        System.out.println("Maximum number of advertisements reached!");
                    }
                    break;
                case 3:
                    displayAdvertisementDetails(adsArray, adsCount);
                    break;
                case 4:
                    displayCommercial_AddCost(scanner, adsArray, adsCount);
                    break;
                case 5:
                    displayFree_AddsMoreThan3Months(adsArray, adsCount);
                    break;
                case 6:
                    displayTotalIncomeFromCommercial_Add(adsArray, adsCount);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Commercial_Add readCommercial_Add(Scanner scanner) {
        System.out.println("Enter client name:");
        String Client_Name = scanner.next();
        System.out.println("Enter start date:");
        String start_date = scanner.next();
        System.out.println("Enter size of add in cm:");
        int size_of_add = scanner.nextInt();
        System.out.println("Enter price per cm:");
        double price_per_cm = scanner.nextDouble();

        return new Commercial_Add(Client_Name, start_date, size_of_add, price_per_cm);
    }

    private static Free_Add readFree_Add(Scanner scanner) {
        System.out.println("Enter client name:");
        String Client_Name = scanner.next();
        System.out.println("Enter start date:");
        String start_date = scanner.next();
        System.out.println("Enter free add time duration in months:");
        int free_add_time_duration = scanner.nextInt();

        return new Free_Add(Client_Name, start_date, free_add_time_duration);
    }

    private static void displayAdvertisementDetails(Advertisement[] adsArray, int adsCount) {
        for (int i = 0; i < adsCount; i++) {
            Advertisement ad = adsArray[i];
            if (ad instanceof Commercial_Add) {
                Commercial_Add Commercial_Add = (Commercial_Add) ad;
                System.out.println("Commercial Add - ID: " + Commercial_Add.Advertisement_id +
                        ", Client: " + Commercial_Add.Client_Name +
                        ", Start Date: " + Commercial_Add.start_date +
                        ", Size: " + Commercial_Add.getsize_of_add() + " cm" +
                        ", Price: $" + Commercial_Add.getprice_per_cm() + " per cm" +
                        ", Cost: $" + Commercial_Add.addCost());
            } else if (ad instanceof Free_Add) {
                Free_Add Free_Add = (Free_Add) ad;
                System.out.println("Free Add - ID: " + Free_Add.Advertisement_id +
                        ", Client: " + Free_Add.Client_Name +
                        ", Start Date: " + Free_Add.start_date +
                        ", Duration: " + Free_Add.getfree_add_time_duration() + " months");
            }
        }
    }

    private static void displayCommercial_AddCost(Scanner scanner, Advertisement[] adsArray, int adsCount) {
        System.out.println("Enter Advertisement ID for Commercial Add:");
        int adId = scanner.nextInt();

        for (int i = 0; i < adsCount; i++) {
            Advertisement ad = adsArray[i];
            if (ad instanceof Commercial_Add && ad.Advertisement_id == adId) {
                Commercial_Add Commercial_Add = (Commercial_Add) ad;
                System.out.println("Advertisement ID: " + adId +
                        ", Client: " + Commercial_Add.Client_Name +
                        ", Start Date: " + Commercial_Add.start_date +
                        ", Cost: $" + Commercial_Add.addCost());
                return;
            }
        }

        System.out.println("Commercial Add with Advertisement ID " + adId + " not found.");
    }

    private static void displayFree_AddsMoreThan3Months(Advertisement[] adsArray, int adsCount) {
        for (int i = 0; i < adsCount; i++) {
            Advertisement ad = adsArray[i];
            if (ad instanceof Free_Add) {
                Free_Add Free_Add = (Free_Add) ad;
                if (Free_Add.getfree_add_time_duration() > 3) {
                    System.out.println("Free Add - ID: " + Free_Add.Advertisement_id +
                            ", Client: " + Free_Add.Client_Name +
                            ", Start Date: " + Free_Add.start_date +
                            ", Duration: " + Free_Add.getfree_add_time_duration() + " months");
                }
            }
        }
    }

    private static void displayTotalIncomeFromCommercial_Add(Advertisement[] adsArray, int adsCount) {
        double totalIncome = 0;
        for (int i = 0; i < adsCount; i++) {
            Advertisement ad = adsArray[i];
            if (ad instanceof Commercial_Add) {
                Commercial_Add Commercial_Add = (Commercial_Add) ad;
                totalIncome += Commercial_Add.addCost();
            }
        }
        System.out.println("Total Income from Commercial Adds: $" + totalIncome);
    }
}
