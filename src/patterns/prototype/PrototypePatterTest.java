package patterns.prototype;

import java.util.List;

public class PrototypePatterTest {
    public static void main(String[] args) {

        Employees emps1 = new Employees();
        emps1.loadData();
        System.out.println("emps1: " + emps1.getEmpList());

        //Use clone method to get the new Employee object with same values
        Employees emps2 = (Employees) emps1.clone();
        System.out.println("emps2: " + emps2.getEmpList());

        Employees emps3 = (Employees) emps1.clone();

        List<String> list2 = emps2.getEmpList();
        list2.add("Shara");
        System.out.println(list2);

        List<String> list3 = emps3.getEmpList();
        list3.remove("Bob");
        System.out.println(list3);

    }
}
