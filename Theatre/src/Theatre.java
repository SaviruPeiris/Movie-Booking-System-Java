import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class Theatre {
    public static void Introduction() {
        System.out.println("Welcome to the New Theatre");
    }
    //When you make this arrays public you can use them both inside and outside the class.
    public static int[] Row_1 = new int[12]; //Row_1 with 12 elements
    public static int[] Row_2 = new int[16];    //Row_2 with 16 elements
    public static int[] Row_3 = new int[20];    //Row_3 with 20 elements
    public static ArrayList<Ticket>TicketArray=new ArrayList<Ticket>(); //New Arraylist-TicketArray
    public static int row_number;
    public static int seat_number;
    public static int Row;
    public static int Seat;
    public static double Price;


    //buy_ticket method-first it will ask you the row number.
    // If the row number is between 1-3 next it will ask you the seat number.
    //The seat should be in between 0 to the row length.
    //line 35-If the seat number is 0 It's available
    //line 37-After booking the seat number should be assigned to 1 and Its booked(not equal)
    public static void buy_ticket() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("");
            System.out.println("        BUY TICKET");
            System.out.println("");
            System.out.print("Enter the row number  :");
            row_number = input.nextInt();
            if (row_number > 0 && row_number <= 3) {
                System.out.print("Enter the seat number :");
                seat_number = input.nextInt();
                if (row_number == 1) {
                    if (seat_number > 0 && seat_number <= Row_1.length) {
                        if (Row_1[seat_number - 1] == 0) {
                            System.out.println("The seat is Available");
                            Price=2000;
                            Row_1[seat_number - 1] = 1;
                            System.out.println("Seat booked Successfully");
                        } else {
                            System.out.println("The seat is Occupied");
                            buy_ticket();
                        }
                    } else {
                        System.out.println("Invalid seat number. Please try again");
                        buy_ticket();
                    }


                } else if (row_number == 2) {
                    if (seat_number > 0 && seat_number <= Row_2.length) {
                        if (Row_2[seat_number - 1] == 0) {
                            System.out.println("The seat is available");
                            Price=1500;
                            Row_2[seat_number - 1] = 1;
                            System.out.println("Seat booked successfully");
                        } else {
                            System.out.println("The seat is occupied");
                            buy_ticket();
                        }
                    } else {
                        System.out.println("Invalid seat number. Please try again");
                        buy_ticket();
                    }


                } else if (row_number == 3) {
                    if (seat_number > 0 && seat_number <= Row_3.length) {
                        if (Row_3[seat_number - 1] == 0) {
                            System.out.println("The seat is available");
                            Price=1000;
                            Row_3[seat_number - 1] = 1;
                            System.out.println("Seat booked successfully");
                        } else {
                            System.out.println("The seat is occupied");
                            buy_ticket();
                        }
                    } else {
                        System.out.println("Invalid seat number. Please try again");
                        buy_ticket();
                    }

                }
            } else {
                System.out.println("Invalid Row number.Please try again");
                buy_ticket();
            }
        } catch (Exception e) {
            System.out.println("Please Enter an Integer.");
            buy_ticket();
        }
        buy_ticket_extend(row_number,seat_number);
    }

    //Extending the buy_ticket method
    //First it will ask you the email with some validations.
    //Next it will ask you the first name,surname and the price
    //Create a object which is connected with the Person and Ticket constructor.
    //Object.method_name()-Calling the print method
    //Add the ticket information to the arraylist
    public static void buy_ticket_extend(int row_number,int seat_number) {
        Scanner input = new Scanner(System.in);
        String email;
        String firstname;
        String surname;
        do {
            System.out.println(" ");
            System.out.print("Enter your email\t\t:");
            email = input.next();
            if (email.contains("@") && email.contains(".com")) {
                break;
            } else {
                System.out.println("Invalid Email Address.Try Again!!");
                continue;
            }
        } while (true);


        while (true) {
            System.out.print("Enter your First name\t:");
            firstname = input.next();
            if(firstname.matches("[a-zA-Z]+")){
                break;
            } else {
                System.out.println("Please enter a valid name");
                System.out.println(" ");
                continue;
            }
        }

        while (true) {
            System.out.print("Enter your Surname\t\t:");
            surname = input.next();
            if (surname.matches("[a-zA-Z]+")) {
                break;
            } else {
                System.out.println("Please enter a valid name");
                System.out.println(" ");
                continue;
            }
        }

        System.out.println("");
        Person P1 = new Person(firstname,surname,email);
        Ticket T1 = new Ticket(row_number, seat_number, Price, P1);
        T1.print();
        TicketArray.add(T1);
        main(new String[0]);
    }



    //Printing the seating area
    //Creating 3 for loops for each row with validations-If row[i]==0 Print '0' else Print 'X'
    //Finally call the main method
    public static void print_seating_area() {
        System.out.println(" ");
        System.out.println("           PRINT SEATING AREA");
        System.out.println(" ");
        System.out.println("              *************");
        System.out.println("              *   STAGE   *");
        System.out.println("              *************");
        System.out.println(" ");
        for (int i = 0; i < Row_1.length; i++){
            if(i==0){
                System.out.print("        ");
            }
            if (i == 6) {
                System.out.print("  ");
            }
            if (Row_1[i] == 0) {
                System.out.print("0"+" ");
            } else {
                System.out.print("X"+" ");
            }
        }
        System.out.println(" ");
        for (int i = 0; i < Row_2.length; i++) {
            if(i==0){
                System.out.print("    ");
            }
            if (i == 8) {
                System.out.print("  ");
            }
            if (Row_2[i] == 0) {
                System.out.print("0"+" ");
            } else {
                System.out.print("X"+" ");
            }
        }
        System.out.println(" ");
        for (int i = 0; i < Row_3.length; i++) {
            if(i==0){
                System.out.print("");
            }
            if (i == 10) {
                System.out.print("  ");
            }
            if (Row_3[i] == 0) {
                System.out.print("0"+" ");
            } else {
                System.out.print("X"+" ");
            }
        }
        System.out.println(" ");
        main(new String[0]);
    }

    //Cancel_ticket method
    //First it will ask you the Row and if it's correct it will ask you the seat
    //The Seat should be between 0 to row length
    //If the seat is '1' only you'll attend the if block and it will turn into '0'after cancelling
    public static void cancel_ticket() {
        try {
            Scanner input=new Scanner(System.in);
            System.out.println("");
            System.out.println("      CANCEL TICKET");
            System.out.println(" ");
            System.out.print("Enter the row number: ");
            Row = input.nextInt();
            if (Row == 1) {
                System.out.print("Enter the seat number:");
                Seat = input.nextInt();
                if (Seat <= Row_1.length && Seat > 0) {
                    if (Row_1[Seat - 1] == 1) {
                        Row_1[Seat - 1] = 0;
                        System.out.println("You have Successfully cancelled the booking");
                        cancel_ticket_extend(Row,Seat);
                    } else {
                        System.out.println("The seat Isn't Booked and It's Available");
                        main(new String[0]);
                    }
                } else {
                    System.out.println("Please enter a valid input Seat number");
                    cancel_ticket();
                }

            } else if (Row == 2) {
                System.out.print("Enter the seat number:");
                int Seat = input.nextInt();
                if (Seat <= Row_2.length && Seat > 0) {
                    if (Row_2[Seat - 1] == 1) {
                        Row_2[Seat - 1] = 0;
                        System.out.println("You have Successfully cancelled the booking");
                        cancel_ticket_extend(Row,Seat);
                    } else {
                        System.out.println("The seat Isn't booked and It's Available");
                        main(new String[0]);
                    }
                } else {
                    System.out.println("Please enter a valid input Seat number");
                    cancel_ticket();
                }

            } else if (Row == 3) {
                System.out.print("Enter the seat number:");
                int Seat = input.nextInt();
                if (Seat <= Row_3.length && Seat > 0) {
                    if (Row_3[Seat - 1] == 1) {
                        Row_3[Seat - 1] = 0;
                        System.out.println("You have Successfully cancelled the booking");
                        cancel_ticket_extend(Row,Seat);
                    } else {
                        System.out.println("The seat isn't booked and It's available");
                        main(new String[0]);
                    }
                } else {
                    System.out.println("Enter a valid seat number");
                    cancel_ticket();
                }
            }else{
                System.out.println("Enter a valid row number");
                cancel_ticket();
            }

        } catch (Exception e) {
            System.out.println("Please Enter an integer.");
            cancel_ticket();
        }
        //cancel_ticket_extend(Row,Seat);
        main(new String[0]);
    }
    public static void cancel_ticket_extend(int row,int Column){
        for(int i=0; i<TicketArray.size();i++){
            if(TicketArray.get(i).getRow_number()==row & TicketArray.get(i).getSeat_number()==Column){
                TicketArray.remove(i);
                System.out.println("");
                break;
            }
        }
    }

    //show_available()
    public static void show_available(){
        System.out.println(" ");
        System.out.println("            AVAILABLE TICKETS");
        System.out.println("");
        System.out.print("Seats Available in row 1:"+" ");
        for(int i=0;i< Row_1.length;i++){
            if(Row_1[i]==0){
                System.out.print((i+1)+" ");
            }
        }
        System.out.println();
        System.out.print("Seats Available in row 2:"+" ");
        for(int i=0;i< Row_2.length;i++){
            if(Row_2[i]==0){
                System.out.print((i+1)+" ");
            }
        }
        System.out.println();
        System.out.print("Seats available in row 3:"+" ");
        for(int i=0;i< Row_3.length;i++){
            if(Row_3[i]==0){
                System.out.print((i+1)+" ");
            }
        }
        System.out.println();
        main(new String[0]);
    }

    public static void save() {
        try {
            PrintWriter myWriter=new PrintWriter("Text.txt");
            myWriter.print("Seats available in Row 1:"+" ");
            for(int i=0;i< Row_1.length;i++) {
                if (Row_1[i] == 0) {
                    myWriter.print((i+1) + " ");
                }
            }
            myWriter.print("\n");
            myWriter.print("Seats available in Row 2:"+" ");
            for(int i=0;i< Row_2.length;i++) {
                if (Row_2[i] == 0) {
                    myWriter.print((i + 1) + " ");
                }
            }
            myWriter.print("\n");
            myWriter.print("Seats available in Row 3:"+" ");
            for(int i=0;i< Row_3.length;i++) {
                if (Row_3[i] == 0) {
                    myWriter.print((i + 1) + " ");
                }
            }
            myWriter.close();
            System.out.println("Successfully created the file");
        } catch (Exception ex) {
            System.out.println("An error occurred");
            save();
        }main(new String[0]);
    }

    public static void load(){
        try{
            System.out.println(" ");
            System.out.println("        LOADED INFORMATION");
            System.out.println("");
            File filename=new File("Text.txt");
            Scanner input=new Scanner(filename);
            String fileLine;
            while(input.hasNextLine()){
                fileLine=input.nextLine();
                System.out.println(fileLine);
            }
        }catch(IOException ex) {
            System.out.println(ex);
        }
        main(new String[0]);
    }


    public static void show_tickets_info(){
        System.out.println(" ");
        System.out.println("            TICKET INFORMATION");
        System.out.println(" ");
        Scanner input=new Scanner(System.in);
        double total=0;
        for(Ticket T:TicketArray){
            System.out.println("--------------------------------------------------------------------");
            T.print();
            total=T.Price+total;
        }
        System.out.println("The Total price of the ticket is:"+total);
        System.out.println("--------------------------------------------------------------------");
        while(true){
            System.out.println(" ");
            System.out.print("Would you like to enter the Main Menu(y/n):");
            String YesNo=input.next();
            if(YesNo.equalsIgnoreCase("y")){
                main(new String[0]);
            }
            else if(YesNo.equalsIgnoreCase("n")){
                System.out.println("Thank you so much for coming!!");
                main(new String[0]);
            }
            else{
                System.out.println("Invalid Input.");
                continue;
            }
        }
    }

    public static void sort_tickets(){
        System.out.println(" ");
        System.out.println("            SORTED TICKET INFORMATION");
        System.out.println(" ");
        Ticket x;
        ArrayList<Ticket> tickets = new ArrayList<>(TicketArray);
        for (int i = 0; i < tickets.size() - 1; i++) {
            for (int j = 1; j < (tickets.size() - i); j++) {
                if (tickets.get(j).Price < tickets.get(j - 1).Price) {

                    // Swapping of tickets
                    x = tickets.get(j - 1);
                    tickets.set((j - 1), tickets.get(j));
                    tickets.set(j, x);
                }
            }
        }
        for (Ticket t : tickets) {
            System.out.println("-------------------------------------------------------------------");
            t.print();
        }
        main(new String[0]);
    }


    public static void main (String[]args) {
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------");
        Introduction();
        System.out.println(" ");
        System.out.println("Please select an Option:");
        System.out.println("1)Buy a ticket");
        System.out.println("2)Print seating area");
        System.out.println("3)Cancel ticket");
        System.out.println("4)List available seats");
        System.out.println("5)Save to file");
        System.out.println("6)Load from file");
        System.out.println("7)Print ticket information");
        System.out.println("8)Sort tickets by price");
        System.out.println("0)Quit");
        System.out.println("--------------------------------------------------------------------");


        while (true) {
            try {
                System.out.print("Enter Option :");
                System.out.print("");
                int option = input.nextInt();
                switch (option) {
                    case 1:buy_ticket();break;
                    case 2: print_seating_area();break;
                    case 3:cancel_ticket();break;
                    case 4:show_available();break;
                    case 5:save();break;
                    case 6: load();break;
                    case 7: show_tickets_info();break;
                    case 8: sort_tickets();break;
                    case 0:System.exit(0);break;
                    default: System.out.println("Please Enter a Valid Option");
                        main(new String[0]);
                }
                if (option==0){
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please Enter an Integer");
                main(new String[0]);
            }

        }
    }


}
