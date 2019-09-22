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
//    public void save() {
//        try(Connection con = DB.sql2o.open()) {
//            String sql = "INSERT INTO persons (id, health, age) VALUES (:id, :health, :age)";
//            this.id = (int) con.createQuery(sql, true)
//                    .addParameter("id", this.id)
//                    .addParameter("health", this.health)
//                    .addParameter("age", this.age)
//                    .executeUpdate()
//                    .getKey();
//        }
//    }
//
//    public static List<EndangeredAnimals> all() {
//        String sql = "SELECT * FROM monsters;";
//        try(Connection con = DB.sql2o.open()) {
//            return con.createQuery(sql).executeAndFetch(EndangeredAnimals.class);
//        }
//    }
//    public static EndangeredAnimals find(int id) {
//        try(Connection con = DB.sql2o.open()) {
//            String sql = "SELECT * FROM monsters where id=:id";
//            EndangeredAnimals animals = con.createQuery(sql)
//                    .addParameter("id", id)
//                    .executeAndFetchFirst(EndangeredAnimals.class);
//            return animals;
//        }
//    }
}