import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class XYZBank {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        List<Record> records = new ArrayList<>();

        System.out.print("\nEnter maximum records: ");
        int maxRecords = inputScanner.nextInt();

        // Creates 'maxRecords' number of records of which the user enters the data for
        for(int i = 0; i < maxRecords; i++){
            System.out.print("\nEnter default record?  (Y/N)  ");
            String defaultChoice = inputScanner.next();

            // User can opt to use the default record values or custom inputted values
            if (defaultChoice.equalsIgnoreCase("Y")){
                Record newRecord = new Record();
                records.add(newRecord);
                if (nextRecord(i, maxRecords, inputScanner)) break;

            } else if (defaultChoice.equalsIgnoreCase("N")) {
                System.out.print("\nEnter Record ID: ");
                String recordId = inputScanner.next();

                System.out.print("Enter Customer ID: ");
                String customerId = inputScanner.next();

                System.out.print("Enter Loan Type: ");
                String loanType = inputScanner.next();

                System.out.print("Enter Interest: ");
                int interest = inputScanner.nextInt();

                System.out.print("Enter amount left to pay: ");
                int amountToPay = inputScanner.nextInt();

                System.out.print("Enter Loan Term: ");
                int loanTerm = inputScanner.nextInt();

                Record newRecord = new Record(recordId, customerId, loanType, interest, amountToPay, loanTerm);
                records.add(newRecord);

                if (nextRecord(i, maxRecords, inputScanner)) break;

                // if invalid input is entered for defaultChoice, the iteration of the for loop is repeated until input is valid
            } else {
                i = i - 1;
            }
        }

        System.out.println("\n++++++++++++++++++++++++++\n    Outputting Records\n++++++++++++++++++++++++++\n");
        System.out.println("Maximum records: " + maxRecords);
        System.out.println("Registered records: " + records.size() + "\n");

        // table header
        System.out.printf("%-15s %-15s %-15s %-10s %-15s %-10s%n",
                "Record ID", "Customer ID", "Loan Type", "Interest", "Amount Left", "Loan Term");

        // output record data
        for (Record record : records) {
            System.out.printf("%-15s %-15s %-15s %-10s %-15s %-10s%n",
                    record.getRecordId(),
                    record.getCustomerId(),
                    record.getLoanType(),
                    record.getInterest() + "%",
                    "£" + (record.getAmountToPay() * 10000),
                    record.getLoanTerm() + " years");
        }
    }

    // method for asking user to input another record or not
    private static boolean nextRecord(int i, int maxRecords, Scanner inputScanner) {
        if(i < maxRecords - 1){
            String choice = getChoice(inputScanner);
            if (Objects.equals(choice.toUpperCase(), "N")) {
                return true;
            } else if (!choice.equalsIgnoreCase("Y")){
                System.out.println("Invalid answer.");
                getChoice(inputScanner);
            }
        }
        return false;
    }

    // used to decide whether to ask the user for inputs for a new record
    private static String getChoice(Scanner inputScanner) {
        System.out.print("\nEnter new record?  (Y/N)  ");
        return inputScanner.next();
    }

}