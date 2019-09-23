import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Animals{
    private String name;
    private int id;
    private static ArrayList<Animals> instances = new ArrayList<Animals>();

    public Animals(String name, int id) {
        this.name = name;
        this.id = this.id;
    }

    public static ArrayList<Animals> all() {
        return instances;
    }

    public String getName() {

        return name;
    }

    public int getId() {

        return id;
    }
}
