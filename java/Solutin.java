import java.util.Scanner;

class Employee{
    private int employeeId;
    private String employeeName;
    private double salary;
    private String designation;
    private int ssnNo;
    private int age;
    
    public Employee(int employeeId, String employeeName, double salary, String designation, int ssnNo, int age) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.designation = designation;
        this.ssnNo = ssnNo;
        this.age = age;
    }
    public Employee() {
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getDesignation() {
        return designation;
    }
    public void setGrade(String grade) {
        this.designation = grade;
    }
    public int getSsnNo() {
        return ssnNo;
    }
    public void setSsnNo(int ssnNo) {
        this.ssnNo = ssnNo;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
}

public class Solutin {
    public static void main(String[] args) {
        int emp_Id;
        String emp_Name;
        double salary;
        String desigantion;
        int ssnNo;
        int emp_age;
        Scanner in = new Scanner(System.in);  
        Employee[] emp = new Employee[4];
        for(int i=0;i<emp.length;i++){
            emp_Id = in.nextInt();
            in.nextLine();
            emp_Name = in.nextLine();
            salary = in.nextDouble();
            in.nextLine();
            desigantion = in.nextLine();
            ssnNo = in.nextInt();
            in.nextLine();
            emp_age = in.nextInt();
            emp[i] = new Employee(emp_Id, emp_Name, salary, desigantion,ssnNo,emp_age);
        }
        in.nextLine();
        int inputId = in.nextInt();
        in.close();
        double resultavg=findAvgAge(emp);
        Employee emp1=findById(emp,inputId);
        if(resultavg==0){
            System.out.println("No employee");
        }
        else{
            System.out.println("Average Age-"+resultavg);
        }
        if(emp1==null){
            System.out.println("no employee");
        }
        else{
            System.out.println(emp1.getEmployeeId()+":"+emp1.getEmployeeName()+":"+emp1.getSsnNo());
        }
    }

    private static Employee findById(Employee[] emp, int inputId) {
        Employee[] emp1=new Employee[1];
        for(int i=0;i<emp.length;i++){
            if(inputId==emp[i].getEmployeeId()){
                emp1[i]=emp[i];
            }
        }
        return emp1[0];
    }

    private static double findAvgAge(Employee[] emp) {
        int sumAge=0,count=0;
        for(int i=0; i<emp.length;i++){
            sumAge=sumAge+emp[i].getAge();
            count++;
        }
        return (sumAge/count);
    }

    
    
}
