package patterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable{

    private List<String> empList;

    public Employees(){
        empList = new ArrayList<String>();
    }

    public Employees(List<String> list){
        this.empList = list;
    }

    public void loadData(){
        //Read all employees from DataBAse and put into the list
        empList.add("Bob");
        empList.add("John");
        empList.add("David");
        empList.add("Lisa");
    }

    public List<String> getEmpList(){
        return empList;
    }

    public Object clone() {
        List<String> temp = new ArrayList<String>();
        for (String s: this.getEmpList()){
            temp.add(s);
        }
        return new Employees(temp);
    }

}
