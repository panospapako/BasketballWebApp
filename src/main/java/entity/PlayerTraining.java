package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ppapakostas
 */
@Entity
@Table(name = "Player_Training")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "PlayerTraining.findAll", query = "SELECT p FROM PlayerTraining p"),
        @NamedQuery(name = "PlayerTraining.findByPTCode", query = "SELECT p FROM PlayerTraining p WHERE p.pTCode = :pTCode"),
        @NamedQuery(name = "PlayerTraining.findByPerformance", query = "SELECT p FROM PlayerTraining p WHERE p.performance = :performance")})
public class PlayerTraining implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PTCode")
    private Integer pTCode;
    @Column(name = "performance")
    private Integer performance;
    @JoinColumn(name = "playerId", referencedColumnName = "idNumber")
    @ManyToOne(optional = false)
    private Player playerId;
    @JoinColumn(name = "trainId", referencedColumnName = "trainId")
    @ManyToOne(optional = false)
    private Training trainId;

    public PlayerTraining() {
    }

    public PlayerTraining(Integer pTCode) {
        this.pTCode = pTCode;
    }

    public Integer getPTCode() {
        return pTCode;
    }

    public void setPTCode(Integer pTCode) {
        this.pTCode = pTCode;
    }

    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

    public Player getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Player playerId) {
        this.playerId = playerId;
    }

    public Training getTrainId() {
        return trainId;
    }

    public void setTrainId(Training trainId) {
        this.trainId = trainId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pTCode != null ? pTCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlayerTraining)) {
            return false;
        }
        PlayerTraining other = (PlayerTraining) object;
        if ((this.pTCode == null && other.pTCode != null) || (this.pTCode != null && !this.pTCode.equals(other.pTCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PlayerTraining[ pTCode=" + pTCode + " ]";
    }

}