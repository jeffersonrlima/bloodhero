package vamp.ifpiprojetos.com.vamp.models;

import java.io.Serializable;

/**
 * Created by Jefferson Lima on 27/03/2017.
 */

public class Donor extends Core implements Serializable{
    private String bloodType;
    private double donates;


    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }


    public double getDonates() {
        return donates;
    }

    public void setDonates(double donates) {
        this.donates = donates;
    }

    @Override
    public String toString() {
        return getId() + " - " + getName() + " - " + getBloodType();
    }
}
