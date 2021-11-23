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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ppapakostas
 */
@Entity
@Table(name = "Player_Game")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "PlayerGame.findAll", query = "SELECT p FROM PlayerGame p"),
        @NamedQuery(name = "PlayerGame.findByPGCode", query = "SELECT p FROM PlayerGame p WHERE p.pGCode = :pGCode"),
        @NamedQuery(name = "PlayerGame.findByPoints", query = "SELECT p FROM PlayerGame p WHERE p.points = :points"),
        @NamedQuery(name = "PlayerGame.findByPrize", query = "SELECT p FROM PlayerGame p WHERE p.prize = :prize")})
public class PlayerGame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PGCode")
    private Integer pGCode;
    @Column(name = "points")
    private Integer points;
    @Size(max = 60)
    @Column(name = "prize")
    private String prize;
    @JoinColumn(name = "gameId", referencedColumnName = "gameId")
    @ManyToOne(optional = false)
    private Game gameId;
    @JoinColumn(name = "playerId", referencedColumnName = "idNumber")
    @ManyToOne(optional = false)
    private Player playerId;

    public PlayerGame() {
    }

    public PlayerGame(Integer pGCode) {
        this.pGCode = pGCode;
    }

    public Integer getPGCode() {
        return pGCode;
    }

    public void setPGCode(Integer pGCode) {
        this.pGCode = pGCode;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public Game getGameId() {
        return gameId;
    }

    public void setGameId(Game gameId) {
        this.gameId = gameId;
    }

    public Player getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Player playerId) {
        this.playerId = playerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pGCode != null ? pGCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlayerGame)) {
            return false;
        }
        PlayerGame other = (PlayerGame) object;
        if ((this.pGCode == null && other.pGCode != null) || (this.pGCode != null && !this.pGCode.equals(other.pGCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PlayerGame[ pGCode=" + pGCode + " ]";
    }

}