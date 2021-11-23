package entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ppapakostas
 */
@Entity
@Table(name = "Coach")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Coach.findAll", query = "SELECT c FROM Coach c"),
        @NamedQuery(name = "Coach.findByIdNumber", query = "SELECT c FROM Coach c WHERE c.idNumber = :idNumber"),
        @NamedQuery(name = "Coach.findByLName", query = "SELECT c FROM Coach c WHERE c.lName = :lName"),
        @NamedQuery(name = "Coach.findByFName", query = "SELECT c FROM Coach c WHERE c.fName = :fName"),
        @NamedQuery(name = "Coach.findByDateOfBirth", query = "SELECT c FROM Coach c WHERE c.dateOfBirth = :dateOfBirth"),
        @NamedQuery(name = "Coach.findByPhoneNumber", query = "SELECT c FROM Coach c WHERE c.phoneNumber = :phoneNumber"),
        @NamedQuery(name = "Coach.findByDateStarted", query = "SELECT c FROM Coach c WHERE c.dateStarted = :dateStarted"),
        @NamedQuery(name = "Coach.findBySalary", query = "SELECT c FROM Coach c WHERE c.salary = :salary")})
public class Coach implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNumber")
    private Integer idNumber;
    @Size(max = 60)
    @Column(name = "lName")
    private String lName;
    @Size(max = 60)
    @Column(name = "fName")
    private String fName;
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Size(max = 20)
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "dateStarted")
    @Temporal(TemporalType.DATE)
    private Date dateStarted;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salary")
    private Float salary;

    public Coach() {
    }

    public Coach(Integer idNumber) {
        this.idNumber = idNumber;
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



    public Integer getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNumber != null ? idNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coach)) {
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
        return "entity.Coach[ idNumber=" + idNumber + " ]";
    }
}
