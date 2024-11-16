class Employee implements Comparable<Employee>{
    String fName;
    String lName;
    int employeeID;
    int salary;

    Employee(String fName,String lName, int employeeID, int salary){
        this.fName = fName;
        this.lName = lName;
        this.employeeID = employeeID;
        this.salary = salary;
    }

    public String toString(){
        return "ID: "+ employeeID + " " + fName + " " + lName + " salary =$" + salary;
    }

    @Override
    public int compareTo(Employee that){
        if (this.employeeID > that.employeeID)
            return 1;
        else
            return -1;
    }
}
