package dbHandler;

public class Const {

    public static final String USER_TABLE = "users";

    private String id;

    private int USERS_ID;
    private String USER_FIRSTNAME ;
    private String USER_LASTNAME ;
    private String USER_MAIL ;
    private String USER_LOCATION;

    public Const(int USERS_ID,String USER_FIRSTNAME,String USER_LASTNAME, String USER_MAIL,String USER_LOCATION) {
        this.USERS_ID = USERS_ID;
        this.USER_FIRSTNAME = USER_FIRSTNAME;
        this.USER_LASTNAME = USER_LASTNAME;
        this.USER_MAIL = USER_MAIL;
        this.USER_LOCATION = USER_LOCATION;
    }
    public Const(){}




    public int getUSERS_ID() {
        return USERS_ID;
    }

    public void setUSERS_ID(int USERS_ID) {
        this.USERS_ID = USERS_ID;
    }

    public String getUSER_FIRSTNAME() {
        return USER_FIRSTNAME;
    }

    public void setUSER_FIRSTNAME(String USER_FIRSTNAME) {
        this.USER_FIRSTNAME = USER_FIRSTNAME;
    }

    public String getUSER_LASTNAME() {
        return USER_LASTNAME;
    }

    public void setUSER_LASTNAME(String USER_LASTNAME) {
        this.USER_LASTNAME = USER_LASTNAME;
    }

    public String getUSER_MAIL() {
        return USER_MAIL;
    }

    public void setUSER_MAIL(String USER_MAIL) {
        this.USER_MAIL = USER_MAIL;
    }

    public String getUSER_LOCATION() {
        return USER_LOCATION;
    }

    public void setUSER_LOCATION(String USER_LOCATION) {
        this.USER_LOCATION = USER_LOCATION;
    }

}
