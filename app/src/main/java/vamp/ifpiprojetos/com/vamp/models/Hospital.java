package vamp.ifpiprojetos.com.vamp.models;

import java.util.List;

/**
 * Created by Jefferson Lima on 27/03/2017.
 */

public class Hospital extends Core{
    private List<Receiver> receiver;

    @Override
    public String toString() {
        return getId() + " - " + getName();
    }
}
