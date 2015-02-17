package dept.store;


public class Region {
   

    private String name;
    private String manager;
    private double number;
     private String email;
    private String date;
    private String contact;

    public Region(String n, String m, double num, String e, String d, String c) {
        this.name = n;
        this.manager = m;
        this.number = num;
        this.email = e;
        this.date = d;
        this.contact = c;

    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
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

    public void setNumber(double num) {
        this.number = num;
    }
    
     public String getEmail() {
        return email;
    }

    public void setEmail(String e) {
        this.email = e;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String d) {
        this.date = d;
    }
    
    public String getContact() {
        return contact;
    }

    public void setContact(String c) {
        this.contact = c;
    }

}


