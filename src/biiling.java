import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class menu
{
    static final int tea = 10;
    static final int coffee = 15;
    static final int snacks = 10;
    static final int idlli = 8;
    static final int dosa = 6;
}

class Bills
{
    Date date=new Date();
    String dt;
    String name;
    int phnno;
    ArrayList<String> things = new ArrayList<String>();
    double totalAmount;

    public Bills(String name, int phnno)
    {
        this.name = name;
        this.phnno = phnno;
    }

    void addItems(String item)
            {
        things.add(item);

    }



}
public class biiling
{


        static Scanner sc = new Scanner(System.in);
        public static void main(String[] args) {
            System.out.print("Enter your name: ");
            String name  = sc.next();
            System.out.print("Enter phone number: ");
            int phnno =sc.nextInt();
            Bills bill = new Bills(name,phnno);

            while (true)
            {
                System.out.println("Items and Cost");
                System.out.println("1. Tea - Rs.10");
                System.out.println("2. Coffee - Rs.15");
                System.out.println("3. Snacks - Rs.10");
                System.out.println("4. Idli - Rs.8");
                System.out.println("5. Dosha - Rs.6");
                System.out.println("6. Generate Bill");
                System.out.println("7. View all transactions");
                System.out.println("8. Exit");
                System.out.print(" enter your choice: ");
                int option  = sc.nextInt();

                {
                    switch (option){
                        case 1:
                            bill.addItems("tea");
                            break;
                        case 2:
                            bill.addItems("coffee");
                            break;
                        case 3:
                            bill.addItems("snacks");
                            break;
                        case 4:
                            bill.addItems("idli");
                            break;
                        case 5:
                            bill.addItems("dosha");
                            break;
                        case 6:
                            bill.generateBills();
                            break;
                    }
                }

}
