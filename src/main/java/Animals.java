import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Animals{
    private String name;
    private int id;

    public Animals(String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
