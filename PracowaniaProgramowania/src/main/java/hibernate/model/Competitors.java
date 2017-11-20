package hibernate.model;

import javax.persistence.*;
/**
 * Created by jn on 2017-11-19.
 */

@Entity
@Table(name = "Competitors", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})})
public class Competitors {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name="First_Name")
    private String First_Name;

    @Column(name="Last_Name")
    private String Last_Name;

    @Column(name="Height")
    private int Height;

    @Column(name="Type")
    private String Type;

    @Column(name="Date_Of_Birth")
    private String Date_Of_Birth;

    public Competitors() {};

    public int GetId() {
        return id;
    }

    public String GetLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_name) {
        this.Last_Name=last_name;
    }

    public String GetFirst_Name(){
        return First_Name;
    }

    public void setFirst_Name(String first_name) {
        this.First_Name=first_name;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        this.Height=height;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type){
        this.Type=type;
    }

    public String getDate_Of_Birth(){
        return Date_Of_Birth;
    }

    public void setDate_Of_Birth(String date_of_birth){
        this.Date_Of_Birth=date_of_birth;
    }
}
