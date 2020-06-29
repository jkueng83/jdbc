package at.cc.jku.WorkingTasks;

public class EmployeeVO {
    private int id;
    private int personalNumber;
    private String firstName;
    private String familyName;

    public EmployeeVO(int id, int personalNumber, String firstName, String familyName) {
        this.id = id;
        this.personalNumber = personalNumber;
        this.firstName = firstName;
        this.familyName = familyName;
    }
    public EmployeeVO( int personalNumber, String firstName, String familyName) {
        this.id = 0;
        this.personalNumber = personalNumber;
        this.firstName = firstName;
        this.familyName = familyName;
    }

    public int getId() {
        return id;
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }
}
