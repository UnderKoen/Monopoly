package nl.UnderKoen.monopoly.server.model.map;

import javafx.scene.paint.Color;
import nl.UnderKoen.monopoly.common.interfaces.map.Town;
import nl.UnderKoen.monopoly.common.interfaces.map.streets.NormalStreet;

import java.util.List;

/**
 * Created by Under_Koen on 07-06-17.
 */
public class ServerTown implements Town {
    private String name;
    private int id;
    private Color color;
    private List<NormalStreet> streets;

    @Override
    public List<NormalStreet> getStreets() {
        return streets;
    }

    public void setStreets(List<NormalStreet> streets) {
        this.streets = streets;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
