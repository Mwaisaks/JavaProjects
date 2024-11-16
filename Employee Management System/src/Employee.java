class Employee implements Comparable<Employee>{
    String firstName;
    String lastName;
    int employeeID;
    int salary;

    Employee(String firstName,String lastName, int employeeID, int salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeID = employeeID;
        this.salary = salary;
    }

    //Getters

    public String getFirstName() {
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getEmployeeID(){
        return employeeID;
    }

    public int getSalary(){
        return salary;
    }

    public String toString(){
        return "ID: "+ employeeID + " " + firstName + " " + lastName + ", Salary = $" + salary;
    }

    @Override
    public int compareTo(Employee other){
        return Integer.compare(this.employeeID, other.employeeID);
        /*
        if (this.employeeID > that.employeeID)
            return 1;
        else
            return -1;
         */
    }
}
