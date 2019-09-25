import org.sql2o.Connection;
import org.sql2o.*;

import java.util.List;

public class Animals{
    private String name;
    private int id;
    private String age;
    private String health;

    public Animals(String name, String age, String health) {
        this.name = name;
        this.age = age;
        this.health = health;

    }



    public String getName() {

        return name;
    }

    public String getAge() {

        return age;
    }

    public String getHealth() {

        return health;
    }

    public int getId() {

        return id;
    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animal (name, age, health) VALUES (:name, :age, :health)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("age", this.age)
                    .addParameter("health", this.health)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Animals> all() {

        String s="select * from animal;";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(s).executeAndFetch(Animals.class);
        }
    }
}
