import org.sql2o.*;
import java.util.List;

public class Sighting{
    private int id;
    private String rangername;
    private String location;


    public Sighting (int id, String rangername, String location){
        this.id = id;
        this.rangername = rangername;
        this.location = location;
    }
    public int getId(){
        return id;
    }

    public String getRangername(){
        return rangername;
    }

    public String getLocation(){
        return location;
    }

    }