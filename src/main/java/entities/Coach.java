/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author ppapakostas
 */
@Entity
@Table(name = "Coach")
public class Coach implements Serializable {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNumber")
    private Integer idNumber;
    @Basic(optional = false)
    @Column(name = "lName")
    private String lName;
    @Basic(optional = false)
    @Column(name = "fName")
    private String fName;
    @Basic(optional = false)
    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;
    @Basic(optional = false)
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "dateStarted")
    private LocalDate dateStarted;
    @Basic(optional = false)
    @Column(name = "salary")
    private float salary;

    /*Constructors*/

    public Coach() {
    }

    public Coach(Integer idNumber, String lName, String fName, LocalDate dateOfBirth, String phoneNumber, LocalDate dateStarted, float salary) {
        this.idNumber = idNumber;
        this.lName = lName;
        this.fName = fName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.dateStarted = dateStarted;
        this.salary = salary;
    }

    public Coach(Integer idNumber, String lName, String fName) {
        this.idNumber = idNumber;
        this.lName = lName;
        this.fName = fName;
    }

    public Coach(String lName, String fName) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    /*Other Methods*/

    @Override
    public int hashCode() {
        int hash = 0;
        //hash = hash+1   Συνθήκη ? Τιμή εάν η συνθήκη true: Τιμή εάν η συνθήκη false
        hash += (idNumber != null ? idNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) { //βάζω object γιατί δεν μπορώ να βάλω Player
        if (!(object instanceof Coach)) { //ελέγχω αν το object είναι κλάση Player
            return false;
        }
        Coach other = (Coach) object;
        if ((this.idNumber == null && other.idNumber != null) || (this.idNumber != null && !this.idNumber.equals(other.idNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Coach:[Name: " + this.lName + this.fName + " , Date Of Birth: " + this.dateOfBirth + " , Phone Number: " + this.phoneNumber + " , Date Started: " + this.dateStarted + ", Salary: " + this.salary + "]";
    }

}
