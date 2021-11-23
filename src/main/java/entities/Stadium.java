/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 * @author ppapakostas
 */
public class Stadium {

    private Integer stadId;
    private String sName;
    private String location;
    private Integer capacity;

    /*Constructors*/

    public Stadium() {
    }

    public Stadium(Integer stadId, String sName, String location, Integer capacity) {
        this.stadId = stadId;
        this.sName = sName;
        this.location = location;
        this.capacity = capacity;
    }

    public Stadium(Integer stadId, String sName) {
        this.stadId = stadId;
        this.sName = sName;
    }

    public Stadium(String sName) {
        this.sName = sName;
    }

    public Stadium(String sName, String location, Integer capacity) {
        this.sName = sName;
        this.location = location;
        this.capacity = capacity;
    }


    /*Getters-Setters*/

    public Integer getStadId() {
        return stadId;
    }

    public void setStadId(Integer stadId) {
        this.stadId = stadId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /*Other Methods*/

    @Override
    public int hashCode() {
        int hash = 0;
        //hash = hash+1   Συνθήκη ? Τιμή εάν η συνθήκη true: Τιμή εάν η συνθήκη false
        hash += (stadId != null ? stadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) { //βάζω object γιατί δεν μπορώ να βάλω Player
        if (!(object instanceof Player)) { //ελέγχω αν το object είναι κλάση Player
            return false;
        }
        Stadium other = (Stadium) object;
        if ((this.stadId == null && other.stadId != null) || (this.stadId != null && !this.stadId.equals(other.stadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Stadium:[Name: " + this.sName + " , Location: " + this.location + " , Capacity: " + this.capacity + "]";
    }
}
