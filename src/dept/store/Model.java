package dept.store;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Model {

    private static Model instance = null;

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    List<Shop> shops;
    ShopTableGateway gateway;

    private Model() {
        try {
            Connection conn = DBconnection.getInstance();
            this.gateway = new ShopTableGateway(conn);

            this.shops = gateway.getShops();
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Shop> getShops() {
        return this.shops;
    }
    
     public boolean addShop(Shop s) {
          boolean result = false;
        try {
            int id = this.gateway.insertShop(s.getName(), s.getAddress(), s.getManager(),s.getNumber(), s.getDate(), s.getRegion());
            
            if (id != -1) {
                s.setId(id);
                this.shops.add(s);
                 result = true;
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
  return result;
}
       public boolean removeShop(Shop s){
      boolean removed = false;
      
     try {
         // Removes the Shop in the database
         removed = this.gateway.deleteShop(s.getId());
         if(removed){
             removed = this.shops.remove(s);
           }
         } 
         catch (SQLException ex){
             Logger.getLogger(Model.class.getName()).log(Level.SEVERE,null,ex);
       }
      return removed;
    }

    Shop findShopByShopId(int id) {
        
    {
       Shop s = null;
       int i = 0;
       boolean found = false;
       while (i < this.shops.size() && !found)
       {
           s = this.shops.get(i);
           if (s.getId() == id)
           {
               found = true;
           }
           else 
           {
               i++;
           }
        }
       if (!found)
       {
           s = null;
       }
       return s;
    }
    }

  
        
      
    boolean editShop(Shop s) {
        
         boolean updated = false;
        
         try 
        {
            // Removes the Shop in the database
            updated = this.gateway.editShop(s);
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE,null,ex);
        }
        return updated;  }
}
