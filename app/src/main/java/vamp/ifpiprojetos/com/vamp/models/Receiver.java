package vamp.ifpiprojetos.com.vamp.models;

/**
 * Created by Jefferson Lima on 27/03/2017.
 */

public class Receiver extends Donor{
    @Override
    public String toString() {
        return getName() + " * " + getId() + " - " + getGenre() + " ! " + getBloodType();
    }
}
