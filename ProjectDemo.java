import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Customer {
    private int customerId;
    private String name;
    private double billAmount;

    public Customer(int customerId, String name, double billAmount) {
        this.customerId = customerId;
        this.name = name;
        this.billAmount = billAmount;
    }

    // Getters and setters

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", name=" + name + ", billAmount=" + billAmount + "]";
    }
}

public class ProjectDemo {
    private static ArrayList<Customer> customerList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nCRUD Operations on Customer List:");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    viewCustomers();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addCustomer() {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Bill Amount: ");
        double billAmount = scanner.nextDouble();

        Customer newCustomer = new Customer(customerId, name, billAmount);
        customerList.add(newCustomer);

        System.out.println("Customer added successfully!");
    }

    private static void viewCustomers() {
        if (customerList.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            System.out.println("Customer List:");
            for (Customer customer : customerList) {
                System.out.println(customer);
            }
        }
    }

    private static void updateCustomer() {
        System.out.print("Enter Customer ID to update: ");
        int customerId = scanner.nextInt();

        boolean customerFound = false;
        Iterator<Customer> iterator = customerList.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getCustomerId() == customerId) {
                System.out.print("Enter new Customer Name: ");
                scanner.nextLine(); 
                String newName = scanner.nextLine();

                System.out.print("Enter new Bill Amount: ");
                double newBillAmount = 0.0;
                while (true) {
                    try {
                        newBillAmount = scanner.nextDouble();
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid double for Bill Amount.");
                        scanner.nextLine(); 
                    }
                }

                customer.setName(newName);
                customer.setBillAmount(newBillAmount);

                System.out.println("Customer updated successfully!");
                customerFound = true;
                break;
            }
        }

        if (!customerFound) {
            System.out.println("Customer with ID " + customerId + " not found.");
        }
    }

    private static void deleteCustomer() {
        System.out.print("Enter Customer ID to delete: ");
        int customerId = scanner.nextInt();

        boolean customerFound = false;
        Iterator<Customer> iterator = customerList.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getCustomerId() == customerId) {
                iterator.remove();
                System.out.println("Customer deleted successfully!");
                customerFound = true;
                break;
            }
        }

        if (!customerFound) {
            System.out.println("Customer with ID " + customerId + " not found.");
        }
    }
}
