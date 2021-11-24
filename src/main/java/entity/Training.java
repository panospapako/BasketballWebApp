package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ppapakostas
 */
@Entity
@Table(name = "Training")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Training.findAll", query = "SELECT t FROM Training t"),
        @NamedQuery(name = "Training.findByTrainId", query = "SELECT t FROM Training t WHERE t.trainId = :trainId"),
        @NamedQuery(name = "Training.findByTDateTime", query = "SELECT t FROM Training t WHERE t.tDateTime = :tDateTime")})
public class Training implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trainId")
    private Integer trainId;
    @Column(name = "tDateTime")
    private LocalDateTime tDateTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "training")
    private List<PlayerTraining> playerTrainingList;

    public Training() {
    }

    public Training(Integer trainId) {
        this.trainId = trainId;
    }

    public Training(LocalDateTime tDateTime) {
        this.tDateTime = tDateTime;
    }

    public Training(int trainId, LocalDateTime tDateTime) {
        this.trainId = trainId;
    }

    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    public LocalDateTime gettDateTime() {
        return tDateTime;
    }

    public void settDateTime(LocalDateTime tDateTime) {
        this.tDateTime = tDateTime;
    }

    @XmlTransient
    public List<PlayerTraining> getPlayerTrainingList() {
        return playerTrainingList;
    }

    public void setPlayerTrainingList(List<PlayerTraining> playerTrainingList) {
        this.playerTrainingList = playerTrainingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trainId != null ? trainId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Training)) {
            return false;
        }
        Training other = (Training) object;
        if ((this.trainId == null && other.trainId != null) || (this.trainId != null && !this.trainId.equals(other.trainId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Training[ trainId=" + trainId + " ]";
    }

}