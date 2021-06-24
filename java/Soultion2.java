import java.util.Scanner;

class Customer {
    private int id ;
    private String name;
    private double salary;
    private int age;
    public Customer(int id, String name, double salary, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    
}
public class Soultion2 {
    public static void main(String args[]) {
        int cid;
        String cname;
        double sal;
        int cage;
        Customer[] customer=new Customer[4];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<customer.length;i++){
            cid = sc.nextInt();sc.nextLine();
            cname = sc.nextLine();
            sal = sc.nextDouble();sc.nextLine();
           cage = sc.nextInt();
            customer[i] = new Customer(cid, cname, sal,cage);
        }
        sc.nextLine();
        int inputage = sc.nextInt();
        sc.close();
        Customer customer1=findMinimumSalaryCustomer(customer);
        Customer[] customer2=findCustomerByAge(customer,inputage);
        if(customer1==null){
            System.out.println("No Customer Found");
        }
        else{
            System.out.println("Name- "+customer1.getId()+"Name- "+customer1.getName()+"salary- "+customer1.getSalary()+" "+customer1.getAge() );
        }
        if(customer2.length==0){
            System.out.println("No Customer Found with the Age");
        }
        else{
            for(Customer c:customer2){
                System.out.println("Id- "+c.getId()+"Name- "+c.getName()+"age "+c.getAge()+"Salary "+c.getSalary());
            }
        }
        
    }   
    private static Customer[] findCustomerByAge(Customer[] customer, int inputage) {
        int count=0;
        for(int i=0;i<customer.length;i++){
            if(inputage==(customer[i].getAge()))
                count++;
        }
        if(count == 0)
            return null;
        Customer[] customers = new Customer[count];
        count = 0;
        for(int i=0;i<customer.length;i++){
            if(inputage==customer[i].getAge())
                customers[count++] = customer[i];
        }
        return customers;
    }
    public static Customer findMinimumSalaryCustomer(Customer[] customer){
        for(int i=0;i<customer.length;i++){
            for(int j=i+1;j<customer.length;j++){
                if(customer[i].getSalary()<customer[j].getSalary()){
                    Customer temp = customer[i];
                    customer[i] = customer[j];
                    customer[j] = temp;
                }
            }
        }
        return customer[customer.length-1];
    }
}
