import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TransferQueue;

class menu {
    static final int tea = 10;
    static final int coffee = 15;
    static final int snacks = 10;
    static final int idli = 8;
    static final int dosa = 6;
}

class Item {
    String item;
    int quantity;

    public Item(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}

class Bill {
    Date dtf =new  Date();
    String date;
    String name;
    long phoneNumber;

    ArrayList<Item> items = new ArrayList<Item>();
    double totalAmount;

    public Bill(String name, long phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    void addItems(String item, int quantity){
        items.add(new Item(item, quantity));
    }

    void generateBills(){
        Date now = new Date();
        double total = 0;
        System.out.println("------------- Bills ------------------");
        System.out.println("date: "+date);
        System.out.println("Customer name: "+name);
        System.out.println("Customer phone: "+phoneNumber);

        System.out.println("------- Items -------");
        for(Item item: items) {
            if(item.item=="tea"){
                total+=menu.tea*item.quantity;
                System.out.println("Tea: "+menu.tea+"*"+item.quantity+"="+(menu.tea*item.quantity));
            } else if (item.item=="coffee") {
                total+=menu.coffee*item.quantity;
                System.out.println("Coffee: "+menu.coffee+"*"+item.quantity+"="+(menu.coffee*item.quantity));
            }else if (item.item=="snacks") {
                total+=menu.snacks*item.quantity;
                System.out.println("Snacks: "+menu.snacks+"*"+item.quantity+"="+(menu.snacks*item.quantity));
            }
            else if (item.item=="idli") {
                total+=menu.idli*item.quantity;
                System.out.println("Idli: "+menu.idli+"*"+item.quantity+"="+(menu.idli*item.quantity));
            }
            else if (item.item=="dosha") {
                total+=menu.dosa*item.quantity;
                System.out.println("Dosha: "+menu.dosa+"*"+item.quantity+"="+(menu.dosa*item.quantity));
            }
        }
        totalAmount = total;
        System.out.println("Total Amount: "+totalAmount);
    }
}


public class Main {
    static ArrayList<Bill> transactions = new ArrayList<Bill>();
    static Scanner sc = new Scanner(System.in);

    static void displayTransactions() {
        System.out.println("---------------- Transactions ---------------------");
        for(Bill transaction: transactions) {
            System.out.println("Date: "+transaction.date);
            System.out.println("Customer : "+transaction.name);
            System.out.println("Phone : "+transaction.phoneNumber);
            System.out.println("Amount: "+transaction.totalAmount);
            System.out.println("-----------------------\n");
        }
    }

    public static void main(String[] args) {
        boolean newCustomer = true;
        Bill bill = null;
        while (true){
            if(newCustomer){
                System.out.print("\nPlease enter your name: ");
                String name  = sc.next();
                System.out.print("\nPlease enter phone number: ");
                long phone  = sc.nextLong();

                newCustomer = false;
            }
            System.out.println("Menu");
            System.out.println("1. Tea - Rs.10");
            System.out.println("2. Coffee - Rs.15");
            System.out.println("3. Snacks - Rs.10");
            System.out.println("4. Idli - Rs.8");
            System.out.println("5. Dosa - Rs.6");
            System.out.println("6. Generate Bill");
            System.out.println("7. View all transactions");
            System.out.println("8. Exit");

            System.out.print("Please enter your choice: ");
            int option  = sc.nextInt();

            switch (option){
                case 1:
                    System.out.print("Enter quantity: ");
                    bill.addItems("tea", sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter quantity: ");
                    bill.addItems("coffee", sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter quantity: ");
                    bill.addItems("snacks", sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter quantity: ");
                    bill.addItems("idli", sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter quantity: ");
                    bill.addItems("dosha", sc.nextInt());
                    break;
                case 6:
                    bill.generateBills();
                    transactions.add(bill);
                    newCustomer = true;
                    break;
                case 7:
                    displayTransactions();
                    newCustomer = true;
                    break;
                case 8:
                    System.exit(0);
                    break;

            }

        }
    }
}