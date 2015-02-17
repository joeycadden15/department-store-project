
package dept.store;


import java.util.List;
import java.util.Scanner;



public class DeptStore {
    
   

   public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        
       Model model = Model.getInstance();
        
        Shop s ;
        
        int opt;
        do {
            System.out.println("1. Create shop");
            System.out.println("2. Edit shop");
            System.out.println("3. Delete existing shop");
            System.out.println("4. View all shops");
            System.out.println("5. Exit");
            System.out.println();
            
            System.out.println("Enter option: ");
            String line = keyboard.nextLine();
            opt = Integer.parseInt(line);
            
            System.out.println(" you choose option:" + opt);
            switch (opt) {
                case 1: {
                    System.out.println("Creating shop");
                    createShop(keyboard, model);
    
                    break;
                }
                     case 2: {
                    System.out.println("editing shop");
                    editShop(keyboard, model);
                    
                    break;
                }
                case 3: {
                    System.out.println("Deleting shop");
                    deleteShop(keyboard, model);
                    break;
                }
                case 4: {
                    System.out.println("Viewing all shops");
                    viewShops(model);
                    break;
                }
            }
           
        

   
    }
             while (opt != 5);
             System.out.println("Goodbye");
        
   }
   
    private static void createShop(Scanner keyb, Model mdl) {
        Shop s = readShop(keyb);
        if (mdl.addShop(s)) {
            System.out.println("Shop was successfully added!");
        } else {
            System.out.println("Shop not added to database.");
        }
        System.out.println();
    }
    
      private static void editShop(Scanner keyboard, Model model) {
         System.out.println("Enter the Id Shop that you want to edit :");
        int id = Integer.parseInt(keyboard.nextLine());
        Shop s;

        s = model.findShopByShopId(id);
        if (s != null) {
            editShopDetails(keyboard, s);
            if (model.editShop(s)) {
                System.out.println("Shop updated");
            } else {
                System.out.println("Shop was not updated");
            }
        } else {
            System.out.println("Shop not found");
        }
    }
  
    
    
    private static void deleteShop(Scanner keyboard, Model model) {
        System.out.println("Enter the Id Shop that you want to delete :");
        int id = Integer.parseInt(keyboard.nextLine());
        Shop s;

        s = model.findShopByShopId(id);
        if (s != null) {
            if (model.removeShop(s)) {
                System.out.println("Shop Deleted");
            } else {
                System.out.println("Shop was not deleted");
            }
        } else {
            System.out.println("Shop not found");
        }
    }


    private static void viewShops(Model mdl) {
      List<Shop> shops = mdl.getShops();
       System.out.println();
        if (shops.isEmpty()) {
           System.out.println("there are no shops in this database");   
                  }
                   else{
                   System.out.printf(" %-20s %-20s %-20s %-20s %-10s %-8s",  "name", "address", "manager", "number", "date", "region");
                   for(Shop sh : shops){
                   System.out.printf(" %-20s %-20s %-20s %-20f %-10s %-8s", 
                   
                   sh.getName(),
                   sh.getAddress(),
                   sh.getManager(),
                   sh.getNumber(),
                   sh.getDate(),
                   sh.getRegion());
                              
                        }
                    }
                
                    System.out.println();
      
    }
    private static Shop readShop(Scanner keyb) {
        String name, address, manager, date, region;
        double  number;
        String line;

        name = getString(keyb, "Enter name: ");
        address = getString(keyb, "Enter address: ");
        manager = getString(keyb, "Enter manager name: ");
        date = getString(keyb, "Enter date registered: ");
        region = getString(keyb, "Enter region: ");
       
        line = getString(keyb, "Enter phone number: ");
        number = Double.parseDouble(line);

        Shop s = 
                new Shop( name, address, manager, 
                        number, date, region);
        
        return s;
    
}
     private static String getString(Scanner keyboard, String prompt) {
        System.out.print(prompt);
        return keyboard.nextLine();
    }

    private static void editShopDetails(Scanner keyboard, Shop s) {
        String name, address, manager, date, region;
        int id;
        double  number;
        String line;
        
        name = getString(keyboard, "Enter name: [" + s.getName() + "]: ");
        address = getString(keyboard, "Enter address: [" + s.getAddress() + "]: ");
        manager = getString(keyboard, "Enter manager name: [" + s.getManager() + "]: ");
        date = getString(keyboard, "Enter date registered:[" + s.getDate() + "]: ");
        region = getString(keyboard, "Enter region:  [" + s.getRegion() + "]: ");
        line = getString(keyboard, "Enter phone number:[" + s.getNumber() + "]: ");
        number = Double.parseDouble(line);
        
         if (name.length() != 0) {
            s.setName(name);
        }
          if (address.length() != 0) {
            s.setAddress(address);
        }
           if (manager.length() != 0) {
            s.setManager(manager);
        }
            if (date.length() != 0) {
            s.setDate(date);
        }
             if (region.length() != 0) {
            s.setRegion(region);
        }
              if (line.length() != 0) {
            number = Integer.parseInt(line);
            s.setNumber(number);
        }
            
     }
    

  
    
}


