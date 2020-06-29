package at.cc.jku.WorkingTasks;

public class Main {
    public static void main(String[] args) {
        System.out.println("Working Tasts");

        EmployeeDAO employeeDAO = new EmployeeDAO();

        String firstName = "Johannes";
        String familyName = "Küng";
        int personalNumber = 101210;
        EmployeeVO employee = employeeDAO.getEmployeeByPersonalNumber(personalNumber);

        if (employee == null) {
            System.out.println("der benutzer ist nicht vorhanden");

            employee = new EmployeeVO(personalNumber, firstName, familyName);
            employeeDAO.addEmployee(employee);
        }

        System.out.println(employee.getId() + ";" + employee.getPersonalNumber() + ";" + employee.getFirstName() + ";" + employee.getFamilyName());
    }
}
