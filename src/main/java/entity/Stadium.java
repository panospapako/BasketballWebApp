package entity;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ppapakostas
 */
@Entity
@Table(name = "Stadium")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Stadium.findAll", query = "SELECT s FROM Stadium s"),
        @NamedQuery(name = "Stadium.findByStadId", query = "SELECT s FROM Stadium s WHERE s.stadId = :stadId"),
        @NamedQuery(name = "Stadium.findBySName", query = "SELECT s FROM Stadium s WHERE s.sName = :sName"),
        @NamedQuery(name = "Stadium.findByLocation", query = "SELECT s FROM Stadium s WHERE s.location = :location"),
        @NamedQuery(name = "Stadium.findByCapacity", query = "SELECT s FROM Stadium s WHERE s.capacity = :capacity")})
public class Stadium implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stadId")
    private Integer stadId;
    @Size(max = 60)
    @Column(name = "sName")
    private String sName;
    @Size(max = 60)
    @Column(name = "location")
    private String location;
    @Column(name = "capacity")
    private Integer capacity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stadId")
    private List<Game> gameList;

    public Stadium() {
    }

    public Stadium(Integer stadId) {
        this.stadId = stadId;
    }

    public Stadium(String sName, String location, Integer capacity) {
        this.sName = sName;
        this.location = location;
        this.capacity = capacity;
    }

    public Stadium(Integer stadId, String sName, String location, Integer capacity) {
        this.stadId = stadId;
        this.sName = sName;
        this.location = location;
        this.capacity = capacity;
    }

    public Integer getStadId() {
        return stadId;
    }

    public void setStadId(Integer stadId) {
        this.stadId = stadId;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
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

    @XmlTransient
    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stadId != null ? stadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stadium)) {
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
        return "entity.Stadium[ stadId=" + stadId + sName+"  ]";
    }

}