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
            System.out.print("Enter default record?  (Y/N)  ");
            String defaultChoice = inputScanner.next();

            // User can opt to use the default record values or custom inputted values
            if (defaultChoice.equalsIgnoreCase("Y")){
                Record newRecord = new Record();
                records.add(newRecord);
                if (nextRecord(i, maxRecords, inputScanner)) break;

            } else if (defaultChoice.equalsIgnoreCase("N")) {
                // declaring variables
                String recordId;
                String customerId;
                String loanType;
                String interest;
                String amountToPay;
                String loanTerm;

                // takes and validates custom user inputs for next record
                do {
                    System.out.print("\nEnter Record ID (Format: XXXXXX): ");
                    recordId = inputScanner.next();
                } while (!isValidRecordId(recordId));

                do {
                    System.out.print("Enter valid Customer ID (Format: AAAXXX): ");
                    customerId = inputScanner.next();
                } while (!isValidCustomerId(customerId));

                do {
                    System.out.print("Enter Loan Type (”Auto”, ”Builder”,”Mortgage”, ”Personal”, or ”Other”): ");
                    loanType = inputScanner.next();
                } while (!isValidLoanType(loanType));

                do {
                    System.out.print("Enter Interest Rate: ");
                    interest = inputScanner.next();
                } while (notFloat((interest)));

                do {
                    System.out.print("Enter amount left to pay in thousand's of pounds: ");
                    amountToPay = inputScanner.next();
                } while (notInteger((amountToPay)));

                do {
                    System.out.print("Enter Loan Term (Number of Years): ");
                    loanTerm = inputScanner.next();
                } while (notInteger((loanTerm)));

                // creates new Record object using user's custom inputs, then adds new object to the list of records
                Record newRecord = new Record(recordId, customerId.toUpperCase(), loanType.toUpperCase(),
                        Float.parseFloat(interest), Integer.parseInt(amountToPay), Integer.parseInt(loanTerm));
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

        // output record data in tabular format
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

    // Gets a Yes/No answer for a choice variable
    private static String getChoice(Scanner inputScanner) {
        System.out.print("\nEnter new record?  (Y/N)  ");
        return inputScanner.next();
    }


    // Methods for validating user inputs of a custom record
    private static boolean isValidRecordId(String input) {
        if (input.matches("[0-9]{6}")) {
            return true;
        } else {
            System.out.println("Invalid RecordID, please enter 6-digit number!");
            return false;
        }
    }

    private static boolean isValidCustomerId(String input) {
        if (input.matches("[a-zA-Z]{3}[0-9]{3}")) {
            return true;
        } else {
            System.out.println("Invalid Customer ID, please enter in the pattern AAAXXX");
            return false;
        }
    }

    private static boolean isValidLoanType(String input) {
        // builds list of valid loan types and checks if input is in the list
        List<String> loanTypes = new ArrayList<>();
        loanTypes.add("auto");
        loanTypes.add("builder");
        loanTypes.add("mortgage");
        loanTypes.add("personal");
        loanTypes.add("other");
        if(loanTypes.contains(input.toLowerCase())){
            return true;
        } else {
            System.out.println("Invalid Loan Type.");
            return false;
        }
    }

    public static boolean notInteger(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, please ensure you enter an integer.");
            return true;
        }
    }
    public static boolean notFloat(String input) {
        try {
            Float.parseFloat(input);
            return false;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, please ensure you enter a number.");
            return true;
        }
    }


}