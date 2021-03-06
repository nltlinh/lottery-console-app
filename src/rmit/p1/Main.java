package rmit.p1;

import rmit.p1.Customer.*;
import rmit.p1.Lottery.*;
import rmit.p1.Lottery.ReleaseLottery;
import rmit.p1.Shop.*;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws CustomerException, ShopException {
        // default customers
        CustomerManager cusList = CustomerListCheck.CUSINSTANCE;

        Customer customer1 = new Customer("c00001", "Linh Nguyen", "110799", "HCM",
                "0466", "linh@gmail.com");
        Customer customer2 = new Customer("c00002", "Hao Ha", "050295", "HN",
                "0122", "hao@gmail.com");
        Customer customer3 = new Customer("c00003", "Thu Luu", "301190", "HCM",
                "6782", "thu@gmail.com");

        cusList.addCustomer(customer1);
        cusList.addCustomer(customer2);
        cusList.addCustomer(customer3);

        // UNDONE change test case
        /*CustomerListMemento customerListMemento = cusList.backup();
        cusList.deleteCustomer("c00001");
        cusList.restore(customerListMemento);
        cusList.viewAllcustomer();*/


        // default shops
        ShopManager shopList = ShopListCheck.SHOPINSTANCE;

        Shop shop1 = new Shop("s00001", "D1,HCM", "Eric", "2345",
                "eric@gmail.com", "20000");
        Shop shop2 = new Shop("s00002", "D4,HN", "Kim", "4689",
                "kim@gmail.com", "1000");
        Shop shop3 = new Shop("s00003", "BT,HCM", "Thuy", "7895",
                "thuy@gmail.com", "40000");

        shopList.addShop(shop1);
        shopList.addShop(shop2);
        shopList.addShop(shop3);

        // UNDONE change test case
        /*ShopListMemento shopListMemento = shopList.backup();
        shopList.deleteShop("s00001");
        shopList.restore(shopListMemento);
        shopList.viewAllShop();*/

        // Menu options
        Scanner input = new Scanner(System.in);
        int menuChoice;
        int menuChoice2;
        try {
            do {
                printMainMenu();
                menuChoice = input.nextInt();
                switch (menuChoice) {
                    // MODIFY customer
                    case 1:
                        CustomerMenu();
                        menuChoice2 = input.nextInt();
                        switch (menuChoice2) {
                            // delete customer
                            case 1:
                                Scanner idinput = new Scanner(System.in);
                                System.out.println("Enter ID of customer you want to delete: ");
                                String id = idinput.nextLine();
                                cusList.deleteCustomer(id);
                                break;
                            // add new customer
                            case 2:
                                cusList.addbyInput();
                                break;
                            // update existing customer
                            case 3:
                                cusList.updatebyInput();
                                break;
                            // view all customer
                            case 4:
                                cusList.viewAllcustomer();
                                break;
                            // search by ID
                            case 5:
                                Scanner idinput2 = new Scanner(System.in);
                                System.out.println("Enter ID of customer you want to view: ");
                                String id2 = idinput2.nextLine();
                                for (Customer c : cusList.viewCustomerID(id2)) {
                                    System.out.println(c);
                                }
                                break;
                            // search by keyword
                            case 6:
                                Scanner cusKeyword = new Scanner(System.in);
                                System.out.println("Enter keyword you want to search: ");
                                String cusKey = cusKeyword.nextLine();
                                //print result
                                for (Customer c : cusList.searchCustomer(cusKey)) {
                                    System.out.println(c);
                                }
                                break;
                            default: // invalid choice
                                System.err.println("INVALID option ! Please choose again. ");
                                break;
                        }
                        break;
                    // MODIFY shop
                    case 2:
                        ShopMenu();
                        menuChoice2 = input.nextInt();
                        switch (menuChoice2) {
                            // delete shop
                            case 1:
                                Scanner shopCode = new Scanner(System.in);
                                System.out.println("Enter CODE of shop you want to delete: ");
                                String code = shopCode.nextLine();
                                shopList.deleteShop(code);
                                break;
                            // add new shop
                            case 2:
                                shopList.addbyInput();
                                break;
                            // update existing shop
                            case 3:
                                shopList.updatebyInput();
                                break;
                            // view all shop
                            case 4:
                                shopList.viewAllShop();
                                break;
                            // search shop by CODE
                            case 5:
                                Scanner shopCode2 = new Scanner(System.in);
                                System.out.println("Enter CODE of shop you want to view: ");
                                String code2 = shopCode2.nextLine();
                                for (Shop s : shopList.viewShopCode(code2)) {
                                    System.out.println(s);
                                }
                                break;
                            // search shop by keyword
                            case 6:
                                Scanner shopKeyword = new Scanner(System.in);
                                System.out.println("Enter keyword you want to search: ");
                                String sKey = shopKeyword.nextLine();
                                for (Shop s : shopList.searchShop(sKey)) {
                                    System.out.println(s);
                                }
                                break;
                            default: // invalid choice
                                System.err.println("INVALID option ! Please choose again. ");
                                break;
                        }
                        break;
                    // LOTTERY
                    case 3:
                        LotteryMenu();
                        menuChoice2 = input.nextInt();
                        switch (menuChoice2) {
                            // lottery drawing & inform customer
                            case 1:
                                Lottery lottery1 = new ReleaseLottery(new LotteryDrawing());
                                cusList.subscribeLottery((ReleaseLottery) lottery1);
                                System.out.println("The lottery numbers are: " + Arrays.toString(lottery1.lottery()));
                                break;
                            // matching times
                            case 2:
                                TriggerBuying.countingTimes();
                                break;
                            // average of matching times
                            case 3:
                                System.out.println("Average of times that match: " + TriggerBuying.average());
                                break;
                            default: // invalid choice
                                System.err.println("INVALID option ! Please choose again. ");
                                break;
                        }
                        break;
                    case 4: // EXIT
                        System.out.println("Goodbye!");
                        break;
                    default: // invalid choice
                        System.err.println("INVALID option ! Please choose again. ");
                        break;
                }
            } while (menuChoice != 4); // while EXIT is not chosen continue print menu
            input.close();
        } catch (CustomerException e) {
            System.err.println("Error while editing Customer List");
        } catch (ShopException e) {
            System.err.println("Error while editing Shop List");
        } catch (InputMismatchException e){
            System.err.println("Invalid Selection ! The selection must be integer !");
        } catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Invalid Input ! Please check your information.");
        }
    }
    public static void printMainMenu() {
        System.out.println(" =====================================");
        System.out.println("|              MAIN MENU              |");
        System.out.println(" =====================================");
        System.out.println("|   1) Edit Customer List             |");
        System.out.println("|   2) Edit Shop List                 |");
        System.out.println("|   3) Lottery Drawing                |");
        System.out.println(" -------------------------------------");
        System.out.println("|   4) EXIT                           |");
        System.out.println(" -------------------------------------");
        System.out.print ( "Enter your Selection: " );
    }

    public static void CustomerMenu() {
        System.out.println(" =====================================");
        System.out.println("|          MODIFY CUSTOMER            |");
        System.out.println(" =====================================");
        System.out.println("|   1) Delete a customer by ID        |");
        System.out.println("|   2) Add new customer               |");
        System.out.println("|   3) Update all information by ID   |");
        System.out.println("|   4) View all customer              |");
        System.out.println("|   5) View a customer by ID          |");
        System.out.println("|   6) Search by keyword              |");
        System.out.println(" -------------------------------------");
        System.out.print ( "Enter your Selection: " );
    }
    public static void ShopMenu() {
        System.out.println(" =====================================");
        System.out.println("|            MODIFY SHOP              |");
        System.out.println(" =====================================");
        System.out.println("|   1) Delete a shop by CODE          |");
        System.out.println("|   2) Add new shop                   |");
        System.out.println("|   3) Update all information by CODE |");
        System.out.println("|   4) View all shop                 |");
        System.out.println("|   5) View a shop by CODE           |");
        System.out.println("|   6) Search by keyword             |");
        System.out.println(" -------------------------------------");
        System.out.print ( "Enter your Selection: " );
    }
    public static void LotteryMenu() {
        System.out.println(" =====================================");
        System.out.println("|               LOTTERY               |");
        System.out.println(" =====================================");
        System.out.println("|   1) Lottery Drawing               |");
        System.out.println("|   2) Match times                   |");
        System.out.println("|   3) Average match times           |");
        System.out.println(" -------------------------------------");
        System.out.print ( "Enter your Selection: " );
    }
}
