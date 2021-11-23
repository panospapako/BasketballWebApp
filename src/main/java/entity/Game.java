package entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author ppapakostas
 */
@Entity
@Table(name = "Game")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Game.findAll", query = "SELECT g FROM Game g"),//JPQL
        @NamedQuery(name = "Game.findByGameId", query = "SELECT g FROM Game g WHERE g.gameId = :gameId"),
        @NamedQuery(name = "Game.findByGDate", query = "SELECT g FROM Game g WHERE g.gDate = :gDate"),
        @NamedQuery(name = "Game.findByOppTeam", query = "SELECT g FROM Game g WHERE g.oppTeam = :oppTeam"),
        @NamedQuery(name = "Game.findByOppScore", query = "SELECT g FROM Game g WHERE g.oppScore = :oppScore"),
        @NamedQuery(name = "Game.findByMyScore", query = "SELECT g FROM Game g WHERE g.myScore = :myScore")})
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gameId")
    private Integer gameId;
    @Column(name = "gDate")
    @Temporal(TemporalType.DATE)
    private Date gDate;
    @Size(max = 60)
    @Column(name = "oppTeam")
    private String oppTeam;
    @Column(name = "oppScore")
    private Integer oppScore;
    @Column(name = "myScore")
    private Integer myScore;
    @JoinColumn(name = "stadId", referencedColumnName = "stadId")
    @ManyToOne(optional = false)
    private Stadium stadId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gameId", fetch = FetchType.LAZY)
    private List<PlayerGame> playerGameList;

    public Game() {
    }

    public Game(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Date getGDate() {
        return gDate;
    }

    public void setGDate(Date gDate) {
        this.gDate = gDate;
    }

    public String getOppTeam() {
        return oppTeam;
    }

    public void setOppTeam(String oppTeam) {
        this.oppTeam = oppTeam;
    }

    public Integer getOppScore() {
        return oppScore;
    }

    public void setOppScore(Integer oppScore) {
        this.oppScore = oppScore;
    }

    public Integer getMyScore() {
        return myScore;
    }

    public void setMyScore(Integer myScore) {
        this.myScore = myScore;
    }

    public Stadium getStadId() {
        return stadId;
    }

    public void setStadId(Stadium stadId) {
        this.stadId = stadId;
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
        hash += (gameId != null ? gameId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Game)) {
            return false;
        }
        Game other = (Game) object;
        if ((this.gameId == null && other.gameId != null) || (this.gameId != null && !this.gameId.equals(other.gameId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Game[ gameId=" + gameId + " ]";
    }
}
