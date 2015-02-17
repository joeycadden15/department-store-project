package dept.store;


public class Shop {
    
    private int id;
    private String name;
    private String address;
    private String manager;
    private double number;
    private String date;
    private String region;

    public Shop(  int id, String n, String a, String m, double num, String d, String r) {
        
        this.id  = id;
        this.name = n;
        this.address = a;
        this.manager = m;
        this.number = num;
        this.date = d;
        this.region = r;

    }

    
    public Shop(String n, String a, String m, double num, String d, String r)  {
        this(-1, n, a, m, num, d, r);
    }

    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String a) {
        this.address = a;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String m) {
        this.manager = m;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double n) {
        this.number = n;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String d) {
        this.date = d;
    }
    
    public String getRegion() {
        return region;
    }

    public void setRegion(String r) {
        this.region = r;
    }

    
    }

