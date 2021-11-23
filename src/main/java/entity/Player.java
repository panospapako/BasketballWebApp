package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ppapakostas
 */
@Entity
@Table(name = "Player")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p"),
        @NamedQuery(name = "Player.findByIdNumber", query = "SELECT p FROM Player p WHERE p.idNumber = :idNumber"),
        @NamedQuery(name = "Player.findByLName", query = "SELECT p FROM Player p WHERE p.lName = :lName"),
        @NamedQuery(name = "Player.findByFName", query = "SELECT p FROM Player p WHERE p.fName = :fName"),
        @NamedQuery(name = "Player.findByDateOfBirth", query = "SELECT p FROM Player p WHERE p.dateOfBirth = :dateOfBirth"),
        @NamedQuery(name = "Player.findByWeight", query = "SELECT p FROM Player p WHERE p.weight = :weight"),
        @NamedQuery(name = "Player.findByHeight", query = "SELECT p FROM Player p WHERE p.height = :height")})
public class Player implements Serializable {

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
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "height")
    private Integer height;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playerId")
    private List<PlayerTraining> playerTrainingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playerId")
    private List<PlayerGame> playerGameList;

    public Player() {
    }

    public Player(Integer idNumber) {
        this.idNumber = idNumber;
    }

    public Player(String lName, String fName, Date dateOfBirth, Integer weight, Integer height) {
        this.lName = lName;
        this.fName = fName;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.height = height;
    }

    public Player(Integer idNumber, String lName, String fName, Date dateOfBirth, Integer weight, Integer height) {
        this.idNumber = idNumber;
        this.lName = lName;
        this.fName = fName;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.height = height;
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @XmlTransient
    public List<PlayerTraining> getPlayerTrainingList() {
        return playerTrainingList;
    }

    public void setPlayerTrainingList(List<PlayerTraining> playerTrainingList) {
        this.playerTrainingList = playerTrainingList;
    }

    @XmlTransient
    public List<PlayerGame> getPlayerGameList() {
        return playerGameList;
    }

    public void setPlayerGameList(List<PlayerGame> playerGameList) {
        this.playerGameList = playerGameList;
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
        if (!(object instanceof Player)) {
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
        return "entity.Player[ idNumber=" + idNumber + " ]";
    }

}