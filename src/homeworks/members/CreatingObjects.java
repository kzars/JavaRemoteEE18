package homeworks.members;

public class CreatingObjects {
    public static void main(String[] args) {

        Employee employee = new Employee();
        Manager manager = new Manager();
        //Member member = new Member();

        employee.name = "qwerty";
        employee.age = 45;
        employee.phoneNumber = "+371312435";
        employee.address = "qwerty";
        employee.salary = 1234;
        employee.specialization = "qwerty";
        employee.printSalary();

        manager.name = "qwerty";
        manager.age = 45;
        manager.phoneNumber = "+371312435";
        manager.address = "qwerty";
        manager.salary = 145654;
        manager.department = "Sales";
        manager.printSalary();


    }
}
