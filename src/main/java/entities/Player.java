/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
//to do serializable

/**
 * @author ppapakostas
 */

@Entity
@Table(name = "Player")//Optional(name is the same)
public class Player implements Serializable {

    @Id//this is a primary key
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNumber")//optional
    private Integer idNumber;
    @Basic(optional = false)
    @Column(name = "lname")
    private String lName;
    @Basic(optional = false)
    @Column(name = "fname")
    private String fName;
    @Basic(optional = false)
    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;
    @Basic(optional = false)
    @Column(name = "weight")
    private double weight;
    @Basic(optional = false)
    @Column(name = "height")
    private double height;

//TO DO: RELATIONS

    /*Constructors*/
    public Player() {
    }

    public Player(Integer idNumber, String lName, String fName, LocalDate dateOfBirth, double weight, double height) {
        this.idNumber = idNumber;
        this.lName = lName;
        this.fName = fName;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.height = height;
    }

    public Player(String lName, String fName, LocalDate dateOfBirth, double weight, double height) {
        this.lName = lName;
        this.fName = fName;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.height = height;
    }

    public Player(Integer idNumber, String lName, String fName) {
        this.idNumber = idNumber;
        this.lName = lName;
        this.fName = fName;
    }

    public Player(String lName, String fName) {
        this.lName = lName;
        this.fName = fName;
    }

    /*Getters - Setters*/
    public Integer getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    /*Other Methods*/
    @Override
    public int hashCode() {
        int myNumber = 100;
        //hash = hash+1   Συνθήκη ? Τιμή εάν η συνθήκη true: Τιμή εάν η συνθήκη false
        myNumber += (idNumber != null ? idNumber : 0);
        return myNumber;
    }

    @Override
    public boolean equals(Object object) { //βάζω object γιατί δεν μπορώ να βάλω Player
        if (!(object instanceof Player)) { //ελέγχω αν το object είναι κλάση Player
            return false;
        }
        Player other = (Player) object;
        if ((this.idNumber == null && other.idNumber != null) || (this.idNumber != null && !this.idNumber.equals(other.idNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Player:[ID Number: " + this.idNumber + " , Name: " + this.lName + "" + this.fName + " , Date Of Birth: " + this.dateOfBirth + " , Weight: " + this.weight + " , Height: " + this.height + "]";
    }
}//class
