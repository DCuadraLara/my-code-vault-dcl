package tarea04;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Device Inventory Manager (Console Application).
 *
 * <p>
 * This program manages the inventory of IT devices in a store using a
 * two-dimensional array. Each row represents one device, and each column
 * represents one attribute.</p>
 *
 * <h2>Initial device registration</h2>
 * <ul>
 * <li>Prompts the user for how many devices to register and keeps asking until
 * a positive number is entered.</li>
 * <li>For each device, it requests and validates:
 * <ul>
 * <li><b>Device code</b> in the format {@code DISP-XXXX} (X are digits),
 * validated with a regular expression.</li>
 * <li><b>Device name</b>.</li>
 * <li><b>Type</b>: Computer, Monitor, Router, or Printer (entered using the
 * initial letter).</li>
 * <li><b>Status</b>: Available, In Repair, or Sold (entered using the initial
 * letter).</li>
 * <li><b>Price</b>: stored as text, but must be numeric and converted to a
 * decimal value for operations.</li>
 * </ul>
 * </li>
 * <li>Does not allow duplicate device codes; if a code already exists, an
 * informative message is shown.</li>
 * <li>If any input is invalid, the program re-prompts until valid data is
 * provided.</li>
 * </ul>
 *
 * <h2>Menu options</h2>
 * <ol>
 * <li><b>Display full inventory</b>: prints all registered devices in a clear,
 * readable table format.</li>
 * <li><b>Find device price by code</b>: prompts for a code and displays the
 * price of the matching device.</li>
 * <li><b>Quit</b>: exits the application.</li>
 * </ol>
 *
 * <h2>Requirements</h2>
 * <ul>
 * <li>All data is stored in a two-dimensional array (rows = devices, columns =
 * attributes).</li>
 * <li>Device codes are validated using a regular expression and must be
 * unique.</li>
 * <li>Only valid values are accepted for device type and status.</li>
 * <li>Price input must be numeric (even if stored as text).</li>
 * <li>The menu repeats until the user selects the exit option.</li>
 * <li>Output should be clear and well-structured, using formatted printing
 * (e.g., {@code printf}) when appropriate.</li>
 * <li>The program must continuously prompt the user until correct input is
 * provided.</li>
 * </ul>
 *
 * @author David
 * @version 1.0
 */
public class DeviceInventoryManager {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Variable Declarations
        //----------------------------------------------
        
        // Constants. 
        final int INVENTORY_COLUMN = 5;  //Número de columnnas que almacenaremos en el inventario.
        
        // Array column order.
        final int ID = 0;
        final int NAME = 1;
        final int TYPE = 2;
        final int STATUS = 3;
        final int PRICE = 4;

        // Input variables.
        int devices = 0, optionMenu = 0;
        double price = 0.0;
        String id, input, name, type, status, strPrice;

        // Auxiliary variables.
        boolean validNum = false,
                validIdRegister = false,
                validStatus = false,
                validPrice = false,
                validType = false,
                existId = false,
                found = false;


        // Class Scanner init. 
        Scanner sc = new Scanner(System.in);

        //----------------------------------------------
        //       Initial input (Number of Devices) 
        //----------------------------------------------  
        System.out.println("Exercise 1 - Device inventory management");
        System.out.println("-----------------------------------");

        // Number of devices input.
        while (!validNum) {
            System.out.print("Enter the number of devices you want to register: ");
            input = sc.nextLine().trim();
            
            System.out.println();
            
            try {
                // parse Str to int.
                devices = Integer.parseInt(input);

                if (devices > 0) {
                    validNum = true;
                } else {
                    System.err.println("Invalid number of devices.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a number.");
            }
        }

        //----------------------------------------------
        //      Device registration and Validation 
        //----------------------------------------------
        // We declare Bidimensional Array.
        String[][] inventory;

        // Create table.
        inventory = new String[devices][INVENTORY_COLUMN];

        // We create a regular expresion the class Pattern to check id 'DISP-XXXX'.
        Pattern deviceIdPattern = Pattern.compile("^DISP-[0-9]{4}$");

        // For each device do:
        for (int i = 0; i < devices; i++) {

            // Reset booleans.
            validIdRegister = false;
            validType = false;
            validStatus = false;
            validPrice = false;

            // Device - i
            System.out.printf("--- Device %d ---%n", i + 1);

            // -- Input - ID.
            while (!validIdRegister) {
                System.out.print("Enter a valid ID (DISP-XXXX): ");
                id = sc.nextLine().trim();

                if (!deviceIdPattern.matcher(id).matches()) {
                    System.err.println("Invalid format! Try again with a valid format -> DISP-0001");
                    continue;
                }

                existId = false; // Reset each attempt

                // check equal IDs.
                for (int row = 0; row < i; row++) {
                    if (inventory[row][ID] != null && inventory[row][ID].equals(id)) {
                        existId = true;
                        break;
                    }
                }

                // If exist ID, enter again.
                if (existId) {
                    System.err.println("ID already exists.");
                    continue;
                }

                // Valid = save.
                inventory[i][ID] = id;
                validIdRegister = true;
            }

            // -- Input - Device name.
            System.out.print("Enter a valid device name: ");
            name = sc.nextLine().trim();

            inventory[i][NAME] = name;

            // -- Input - Device type.
            while (!validType) {
                System.out.print("Enter the first letter of a valid device type (Ordenador | Monitor | Router | Impresora): ");
                type = sc.nextLine().trim().toUpperCase();

                if (type.isEmpty()) {
                    System.err.println("Input is empty!");
                    continue;
                }

                // Check type.
                switch (type) {
                    case "O":
                    case "M":
                    case "R":
                    case "I":
                        break;
                    default:
                        System.err.println("Invalid type. Try again.");
                        continue;
                }

                // Save on Array.
                inventory[i][TYPE] = type;
                validType = true;
            }

            // -- Input - Device status.
            while (!validStatus) {
                System.out.print("Enter the first letter of the device status (Disponible | Reparacion | Vendido): ");
                status = sc.nextLine().trim().toUpperCase();

                if (status.isEmpty()) {
                    System.err.println("Input is empty!");
                    continue;
                }

                switch (status) {
                    case "D":
                    case "R":
                    case "V":
                        break;
                    default:
                        System.err.println("Invalid status. Try again.");
                        continue;
                }

                // Save on Array.
                inventory[i][STATUS] = status;
                validStatus = true;
            }

            // -- Input - Device price.
            while (!validPrice) {
                System.out.print("Enter the price of the current device: ");
                strPrice = sc.nextLine().trim();

                if (strPrice.isEmpty()) {
                    System.err.println("Input is empty!");
                    continue;
                }

                // Parse string to double.
                try {
                    price = Double.parseDouble(strPrice);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input, only enter numbers.");
                    continue;
                }

                if (price <= 0.0) {
                    System.err.println("Price can't be 0 or negative. Try again.");
                    continue;
                }

                // Save on Array.
                inventory[i][PRICE] = strPrice;
                validPrice = true;
            }
            
            System.out.println();
        }

        //----------------------------------------------
        //                 OUTPUT
        //----------------------------------------------
        System.out.println();
        System.out.println("** MENU **");
        System.out.println("-----------");

        
        while (optionMenu != 3) {
            
            System.out.println("""
                               1- Display current inventory.
                               2- Find the price of a device by ID.
                               3- Quit.
                               """);

            System.out.println();
            
            // Menu input.
            try {
                System.out.print("Choose an option: ");
                optionMenu = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e) {
                System.err.println("Enter a valid menu option 1-3");
                continue;
            }
            
            // Process.
            switch (optionMenu) {
                case 1:
                    // Print inventory by rows.
                    System.out.println("-- DEVICE INVENTORY --");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.printf("%-8s %-12s %-20s %-10s %-12s %-10s%n",
                          "DEVICE", "ID", "NAME", "TYPE", "STATUS", "PRICE");
                    System.out.println("---------------------------------------------------------------------");
                    for(int row=0; row<inventory.length; row++) { // Rows
                        System.out.printf("%-8d %-12s %-20s %-10s %-12s %-10s%n",
                                row + 1,
                                inventory[row][ID],
                                inventory[row][NAME],
                                inventory[row][TYPE],
                                inventory[row][STATUS],
                                inventory[row][PRICE]);
                    }
                    
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println();
                    break;
                case 2:
                System.out.println("");
                    System.out.print("Enter the ID of the device you want to know the price: ");
                    input = sc.nextLine().trim();
                    
                    // Cheack empty input.
                    if(input.isEmpty()) {
                        System.err.println("Input is empty!");
                        break;
                    }
                    
                    // Find actual price by id.
                    for(int row=0; row<inventory.length;row++) {
                        if(input.equals(inventory[row][ID])) {
                            System.out.printf("The device %s actual cost it's: %s%n", inventory[row][ID], inventory[row][PRICE]);
                            found = true;
                        }
                    }
                    
                    if(!found){
                        System.out.println("The given ID does not correspond to any saved device.");
                    }
                        
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Goodbye! Closing program...");
                    break;
                default:
                    System.err.println("Invalid input. Enter a valid number 1-3.");
                    break;
            }
            
        }
        
    }
}
