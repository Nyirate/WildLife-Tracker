import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimals {
    public int id;
    public  String health;
    public String age;


    public EndangeredAnimals(int id, String health, String age) {
        this.id = id;
        this.health = health;
        this.age = age;

    }

    public int getId() {
        return id;
    }

    public String getHealth() {
        return health;
    }
    public String getAge() {
        return age;
    }
}