import org.sql2o.*;
import java.util.List;

public class Sighting{
    private String rangername;
    private String location;


    public Sighting (String rangername, String location){
        this.rangername = rangername;
        this.location = location;
    }

    public String getRangername(){
        return rangername;
    }

    public String getLocation(){
        return location;
    }

    }