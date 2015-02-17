package dept.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ShopTableGateway {
    
    private Connection mConnection;
    
    private static final String TABLE_NAME = "shop";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "shopName";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_MANAGER = "managerName";
    private static final String COLUMN_NUMBER = "number";
    private static final String COLUMN_DATE = "reg_date";
    private static final String COLUMN_REGION = "region";


    
    public ShopTableGateway(Connection connection){
        mConnection = connection;
    }
    
    public int insertShop ( String n, String a, String m, double num, String d, String r) throws SQLException {
        Shop  s = null;

        String query;       // the SQL query to execute
        PreparedStatement stmt;         // the java.sql.PreparedStatement object used to execute the SQL query
        int numRowsAffected;
        int id = -1;

        // the required SQL INSERT statement with place holders for the values to be inserted into the database
        query = "INSERT INTO " + TABLE_NAME + " (" +
                COLUMN_NAME + ", " +
                COLUMN_ADDRESS + ", " +
                COLUMN_MANAGER + ", " +
                COLUMN_NUMBER + ", " +
                COLUMN_DATE + 
                COLUMN_REGION +
                ") VALUES (?, ?, ?, ?, ?, ?)";

        // create a PreparedStatement object to execute the query and insert the values into the query
        stmt = mConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        
        stmt.setString(1, n);
        stmt.setString(2, a);
        stmt.setString(3, m);
        stmt.setDouble(4, num);
        stmt.setString(5, d);
        stmt.setString(6, r);

        //  execute the query and make sure that one and only one row was inserted into the database
        numRowsAffected = stmt.executeUpdate();
        if (numRowsAffected == 1) {
            // if one row was inserted, retrieve the id assigned to that row and create a Programmer object to return
            ResultSet keys = stmt.getGeneratedKeys();
            keys.next();

            id = keys.getInt(1);

            s = new Shop ( n, a, m, num, d, r);
        }

        // return the Programmer object created or null if there was a problem
        return id;
    }
    
     // Code for DELETING THE SHOP
    public boolean deleteShop(int id) throws SQLException
    {
        String query;
        PreparedStatement stmt;
        int numRowsAffected;
        
        // The required SQL DELETE statement with place holders for the id of the row to be removed
        query =" DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ? ";
    
        // Create a PreparedStatement object to execute the query and insert the id into the query
        stmt = mConnection.prepareStatement(query);
        stmt.setInt(1, id);

        // Execute the query
        numRowsAffected = stmt.executeUpdate();

        // Return true if one and only one row was deleted from the database
        return(numRowsAffected == 1);          
    }
    
      public List<Shop> getShops() throws SQLException {
        String query;       // the SQL query to execute
        Statement stmt;     // the java.sql.Statement object used to execute the
                            // SQL query
        ResultSet rs;       // the java.sql.ResultSet representing the result of
                            // SQL query 
        List<Shop> shops;   // the java.util.List containing the Programmer objects
                            // created for each row in the result of the query
                    // the id of a programmer
        String name, address, manager, date, region;
        int id;
        double  number;
        Shop s;       // a Programmer object created from a row in the result of
                            // the query

        // execute an SQL SELECT statement to get a java.util.ResultSet representing
        // the results of the SELECT statement
        query = "SELECT * FROM " + TABLE_NAME;
        stmt = this.mConnection.createStatement();
        rs = stmt.executeQuery(query);

        // iterate through the result set, extracting the data from each row
        // and storing it in a Programmer object, which is inserted into an initially
        // empty ArrayList
        shops = new ArrayList<Shop>();
        while (rs.next()) {
            id = rs.getInt(COLUMN_ID);
            name = rs.getString(COLUMN_NAME);
            address = rs.getString(COLUMN_ADDRESS);
            manager = rs.getString(COLUMN_MANAGER);
            number = rs.getDouble(COLUMN_NUMBER);
            date = rs.getString(COLUMN_DATE);
            region = rs.getString(COLUMN_REGION);

            s = new Shop( name, address, manager,  number, date, region);
            shops.add(s);
        }

        return shops;
   
    }

    boolean editShop(Shop s) throws SQLException {
   {
        String query;                   // The SQL Query to execute
        PreparedStatement stmt;         // The Java.sql. PreparedStatement object used to create the SQL Query
        int numRowsAffected;
        
        // The required SQL INSERT statement qith place holders for the values to be inserted
        query = "UPDATE " + TABLE_NAME + " SET " +
                  COLUMN_NAME + ", " +
                COLUMN_ADDRESS + ", " +
                COLUMN_MANAGER + ", " +
                COLUMN_NUMBER + ", " +
                COLUMN_DATE + 
                COLUMN_REGION +
                ") VALUES (?, ?, ?, ?, ?, ?)";
        
        // Create a PreparedStatement object to execute the query and insert the new value into the query
        stmt = mConnection.prepareStatement(query);
         stmt.setString(1, s.getName());
        stmt.setString(2, s.getAddress());
        stmt.setString(3, s.getManager());
        stmt.setDouble(4, s.getNumber());
        stmt.setString(5, s.getDate());
        stmt.setString(6, s.getRegion());
        
        
        // Execute the query
        numRowsAffected = stmt.executeUpdate();
        
        // Return true if one and only row was updated in the database
        return(numRowsAffected == 1);  }

    
    

}
    
}