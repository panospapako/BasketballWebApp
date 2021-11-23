/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author ppapakostas
 */
@Entity
@Table(name = " Training")
public class Training implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainId")
    private int trainId;
    @Basic(optional = false)
    @Column(name="tDateTime")
    private LocalDateTime tDateTime;

    public Training() {
    }

    public Training(int trainID, LocalDateTime tDateTime) {
        this.trainId = trainID;
        this.tDateTime = tDateTime;
    }

    public Training(LocalDateTime tDateTime) {
        this.tDateTime = tDateTime;
    }

    public LocalDateTime gettDateTime() {
        return tDateTime;
    }

    public void settDateTime(LocalDateTime tDateTime) {
        this.tDateTime = tDateTime;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }


}
