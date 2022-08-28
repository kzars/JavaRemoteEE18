package homeworks.members;

public abstract class Member {
    //Fields
    protected String name;
    protected int age;
    protected String phoneNumber;
    protected String address;
    protected int salary;

    //Methods
    public void printSalary(){
        System.out.println("Salary: " + salary);
    }

}
