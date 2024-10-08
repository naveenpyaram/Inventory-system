package InventorySystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventorySystem {
	  public static List<Item> products = new ArrayList();
	  public static Scanner scanner = new Scanner(System.in);
	public static void main(String [] args) {
		System.out.println("hello world");
		int choice;

        do {
            System.out.println("1. Add Item");
            System.out.println("2. Update Item");
            System.out.println("3. Delete Item");
            System.out.println("4. Display Items");
            System.out.println("5. Find Item");
            System.out.println("6. Exit");
            System.out.println("Select an option from 1 - 6 :");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    updateItem();
                    break;
                case 3:
                    deleteItem();
                    break;
                case 4:
                    displayItems();
                    break;
                case 5:
                    findItem();
                    break;
                case 6:
                    System.out.println("Exiting the application");
                    break;
                default:
                    System.out.println("Invalid, Enter the choice within the range only :");
            }
        } while (choice != 6);
	}
	 public static void addItem() {
	        System.out.println("Add items into the list :");
	        System.out.println("Enter the item id (from 1 to 999)");

	        int id = Integer.parseInt(scanner.nextLine());

	        if (id > 0 && id <= 999) {
	            System.out.println("Enter the item name");
	            String name = scanner.nextLine();
	            System.out.println("Enter the item price");
	            double price = Double.parseDouble(scanner.nextLine());
	            System.out.println("Enter the item quantity");
	            int quantity = Integer.parseInt(scanner.nextLine());

	            Item item = new Item(id, name, price, quantity);
	            products.add(item);
	            System.out.println("Product details added successfully");
	        } else {
	            System.out.println("Enter the valid id from 1 - 999");
	        }
	    }
	 public static void updateItem() {
	        if (products.isEmpty()) {
	            System.out.println("The List is Empty, First add the items into the List");
	        } else {
	            System.out.println("Enter item index to update");
	            int index = Integer.parseInt(scanner.nextLine());

	            if (index >= 0 && index < products.size()) {
	                System.out.println("Enter the new item id");
	                int newId = Integer.parseInt(scanner.nextLine());
	                System.out.println("Enter the new item name");
	                String newName = scanner.nextLine();
	                System.out.println("Enter the new item price");
	                double newPrice = Double.parseDouble(scanner.nextLine());
	                System.out.println("Enter the new item quantity");
	                int newQuantity = Integer.parseInt(scanner.nextLine());
	                Item item = products.get(index);
	                item.setId(newId);
	                item.setName(newName);
	                item.setPrice(newPrice);
	                item.setQuantity(newQuantity);

	                System.out.println("New product details added successfully");
	            } else {
	                System.out.println("Enter a valid item index (0 to " + (products.size() - 1) + ")");
	            }
	        }
	    }
	 public static void deleteItem() {
		    if (products.isEmpty()) {
		        System.out.println("The List is Empty, First add the items into the List");
		    } else {
		        System.out.println("You can delete an item by index number or id number");
		        System.out.println("If you want to delete an item by its index choose: 0");
		        System.out.println("If you want to delete an item by its id choose: 1");

		        int deleteChoice = Integer.parseInt(scanner.nextLine());

		        if (deleteChoice == 0) {
		            System.out.println("Enter the item index to be deleted");
		            int index = Integer.parseInt(scanner.nextLine());

		            if (index < 0 || index >= products.size()) {
		                System.out.println("Enter a valid item index (0 to " + (products.size() - 1) + ")");
		            } else {
		                products.remove(index);
		                System.out.println("Item deleted successfully");
		            }
		        } else {
		            System.out.println("Enter the item id to be deleted");
		            int id = Integer.parseInt(scanner.nextLine());

		            Item item = products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);

		            if (item != null) {
		                products.remove(item);
		                System.out.println("Item deleted successfully");
		            } else {
		                System.out.println("Item not found");
		            }
		        }
		    }
		}
	 public static void displayItems() {
		    if (products.isEmpty()) {
		        System.out.println("The List is Empty, First add the items into the List");
		    } else {
		        System.out.println("Tasks in the list:");
		        for (int i = 0; i < products.size(); i++) {
		            System.out.println(i + ". " + products.get(i));
		        }
		    }
		}
	 public static void findItem() {
		    if (products.isEmpty()) {
		        System.out.println("The List is Empty, First add the items into the List");
		    } else {
		        System.out.println("Enter the id to find an item");
		        int id = Integer.parseInt(scanner.nextLine());

		        boolean found = false;
		        for (Item item : products) {
		            if (item.getId() == id) {
		                System.out.println("Id: " + item.getId() + ", Name: " + item.getName() + ", Price: " + item.getPrice() + ", Quantity: " + item.getQuantity());
		                found = true;
		                break;
		            }
		        }

		        if (!found) {
		            System.out.println("Item not found");
		        }
		    }
		}

}
