public class Ticket {
    int Row_number,Seat_number;
    double Price;
    Person Person;              //Person is the object that we have created in task 9
    public Ticket(int Row_number,int Seat_number,double Price,Person person){   //A constructor with 4 Parameters-Overloaded Constructor
        this.Row_number=Row_number;     //When you have the same variable name us this keyword,The constructor should have the same name as the class name
        this.Seat_number=Seat_number;
        this.Price=Price;
        this.Person=person;
    }

    public int getRow_number(){
        return Row_number;
    }
    public int getSeat_number(){
        return Seat_number;
    }
    public double getPrice(){
        return Price;
    }

    //A method to print all the Information-method name-print
    //This method will print all the information of the customer
    public void print(){
        System.out.println("Customer First Name\t\t:"+Person.Firstname);
        System.out.println("Customer Surname\t\t:"+Person.Surname);
        System.out.println("Customer Email\t\t\t:"+Person.email);
        System.out.println("Row Number\t\t\t\t:"+Row_number);
        System.out.println("Seat Number\t\t\t\t:"+Seat_number);
        System.out.println("Ticket Price\t\t\t:"+Price);
        System.out.println(" ");
    }

}
