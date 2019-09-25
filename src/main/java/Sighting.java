import org.sql2o.Connection;
import java.util.List;

public class Sighting{
    private int id;
    private String rangername;
    private String location;




    public Sighting (String rangername, String location){
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

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (rangername, location) VALUES (:rangername, :location)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("rangername", this.rangername)
                    .addParameter("location", this.location)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Sighting> all() {

        String s="select * from sightings;";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(s).throwOnMappingFailure(false).executeAndFetch(Sighting.class);
        }
    }


}