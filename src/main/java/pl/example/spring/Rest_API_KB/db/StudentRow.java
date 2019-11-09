package pl.example.spring.Rest_API_KB.db;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentRow {
    @Id
    private long id;
    private String name;
    private String number;
    private String grupa;

    // Czy ma być też grupa?
    public StudentRow(long id, String name, String number, String grupa) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.grupa = grupa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGroup() {
        return grupa;
    }

    public void setGroup(String group) {
        this.grupa = grupa;
    }
}