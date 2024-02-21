public class Record {
    // declaring attributes
    private String recordId;
    private String customerId;
    private String loanType;
    private float interest;
    private int amountToPay;
    private int loanTerm;

    // Default record values
    public Record() {
        this.recordId = "000000";
        this.customerId = "AAA000";
        this.loanType = "Other";
        this.interest = 0;
        this.amountToPay = 0;
        this.loanTerm = 0;
    }

    // Custom record
    public Record(String recordId, String customerId, String loanType, float interest, int amountToPay, int loanTerm) {
        this.recordId = recordId;
        this.customerId = customerId;
        this.loanType = loanType;
        this.interest = interest;
        this.amountToPay = amountToPay;
        this.loanTerm = loanTerm;
    }


    // Getters and setters for each attribute
    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public int getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(int amountToPay) {
        this.amountToPay = amountToPay;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int yearTerm) {
        this.loanTerm = yearTerm;
    }
}
