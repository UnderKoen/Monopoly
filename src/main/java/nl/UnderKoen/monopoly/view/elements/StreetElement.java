package nl.UnderKoen.monopoly.view.elements;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import nl.UnderKoen.monopoly.Main;
import nl.UnderKoen.monopoly.entities.Street;

/**
 * Created by Under_Koen on 23-05-17.
 */
public class StreetElement extends StackPane {
    public StreetElement(Street street) {
        setAlignment(Pos.TOP_LEFT);
        switch (street.getCategory()) {
            case START:
                ImageView icon;
                break;
            case JAIL:
                break;
            case VISIT:
                break;
            case PARKING:
                break;
            case NORMAL:
                Rectangle base = new Rectangle(50,80);
                base.setFill(Color.rgb(202,250,222));
                base.setStroke(Color.BLACK);
                getChildren().add(base);

                Rectangle color = new Rectangle(50,15);
                color.setFill(street.getColor());
                color.setStroke(Color.BLACK);
                getChildren().add(color);

                Text text = new Text(street.getName());
                text.setFont(new Font(6));
                setAlignment(text, Pos.TOP_CENTER);
                text.setTranslateY(20);
                getChildren().add(text);


                Text price = new Text("€" + street.getPrice());
                price.setFont(new Font(6));
                setAlignment(price, Pos.BOTTOM_CENTER);
                price.setTranslateY(-5);
                getChildren().add(price);

                setMaxSize(50, 80);
                break;
            case STATION:
                base = new Rectangle(50, 80);
                base.setFill(Color.rgb(202,250,222));
                base.setStroke(Color.BLACK);
                getChildren().add(base);

                text = new Text(street.getName());
                text.setTextAlignment(TextAlignment.CENTER);
                text.setFont(new Font(6));
                setAlignment(text, Pos.TOP_CENTER);
                text.setTranslateY(10);
                getChildren().add(text);

                icon = new ImageView(new Image(Main.class.getResource("/icon/station.png").toString()));
                icon.setFitHeight(40);
                icon.setFitWidth(45);
                icon.setTranslateY(5);
                setAlignment(icon, Pos.CENTER);
                getChildren().add(icon);

                price = new Text("€" + street.getPrice());
                price.setFont(new Font(6));
                setAlignment(price, Pos.BOTTOM_CENTER);
                price.setTranslateY(-5);
                getChildren().add(price);

                setMaxSize(50, 80);
                break;
            case WATER_WORKS:
                base = new Rectangle(50, 80);
                base.setFill(Color.rgb(202,250,222));
                base.setStroke(Color.BLACK);
                getChildren().add(base);

                text = new Text(street.getName());
                text.setTextAlignment(TextAlignment.CENTER);
                text.setFont(new Font(6));
                setAlignment(text, Pos.TOP_CENTER);
                text.setTranslateY(10);
                getChildren().add(text);

                icon = new ImageView(new Image(Main.class.getResource("/icon/waterWorks.png").toString()));
                icon.setFitHeight(25);
                icon.setFitWidth(40);
                setAlignment(icon, Pos.CENTER);
                getChildren().add(icon);

                price = new Text("€" + street.getPrice());
                price.setFont(new Font(6));
                setAlignment(price, Pos.BOTTOM_CENTER);
                price.setTranslateY(-5);
                getChildren().add(price);

                setMaxSize(50, 80);
                break;
            case ELECTRICITY:
                base = new Rectangle(50, 80);
                base.setFill(Color.rgb(202,250,222));
                base.setStroke(Color.BLACK);
                getChildren().add(base);

                text = new Text(street.getName());
                text.setTextAlignment(TextAlignment.CENTER);
                text.setFont(new Font(6));
                setAlignment(text, Pos.TOP_CENTER);
                text.setTranslateY(10);
                getChildren().add(text);

                icon = new ImageView(new Image(Main.class.getResource("/icon/electricity.png").toString()));
                icon.setFitHeight(50);
                icon.setFitWidth(40);
                setAlignment(icon, Pos.CENTER);
                getChildren().add(icon);

                price = new Text("€" + street.getPrice());
                price.setFont(new Font(6));
                setAlignment(price, Pos.BOTTOM_CENTER);
                price.setTranslateY(-5);
                getChildren().add(price);

                setMaxSize(50, 80);
                break;
            case CHANCE:
                base = new Rectangle(50, 80);
                base.setFill(Color.rgb(202,250,222));
                base.setStroke(Color.BLACK);
                getChildren().add(base);

                text = new Text(street.getName());
                text.setTextAlignment(TextAlignment.CENTER);
                text.setFont(new Font(6));
                setAlignment(text, Pos.TOP_CENTER);
                text.setTranslateY(10);
                getChildren().add(text);

                icon = new ImageView(new Image(Main.class.getResource("/icon/chance.png").toString()));
                icon.setFitHeight(60);
                icon.setFitWidth(30);
                icon.setTranslateY(5);
                setAlignment(icon, Pos.CENTER);
                getChildren().add(icon);

                setMaxSize(50, 80);
                break;
            case COMMUNITY_CHEST:
                base = new Rectangle(50, 80);
                base.setFill(Color.rgb(202,250,222));
                base.setStroke(Color.BLACK);
                getChildren().add(base);

                text = new Text(street.getName());
                text.setTextAlignment(TextAlignment.CENTER);
                text.setFont(new Font(6));
                setAlignment(text, Pos.TOP_CENTER);
                text.setTranslateY(10);
                getChildren().add(text);

                icon = new ImageView(new Image(Main.class.getResource("/icon/communityChest.png").toString()));
                icon.setFitHeight(40);
                icon.setFitWidth(40);
                setAlignment(icon, Pos.CENTER);
                getChildren().add(icon);

                setMaxSize(50, 80);
                break;
            case INCOME_TAX:
                base = new Rectangle(50, 80);
                base.setFill(Color.rgb(202,250,222));
                base.setStroke(Color.BLACK);
                getChildren().add(base);

                text = new Text(street.getName());
                text.setTextAlignment(TextAlignment.CENTER);
                text.setFont(new Font(6));
                setAlignment(text, Pos.TOP_CENTER);
                text.setTranslateY(10);
                getChildren().add(text);

                icon = new ImageView(new Image(Main.class.getResource("/icon/incomeTax.png").toString()));
                icon.setFitHeight(35);
                icon.setFitWidth(30);
                icon.setTranslateY(5);
                setAlignment(icon, Pos.CENTER);
                getChildren().add(icon);

                price = new Text("€" + street.getPrice());
                price.setFont(new Font(6));
                setAlignment(price, Pos.BOTTOM_CENTER);
                price.setTranslateY(-5);
                getChildren().add(price);

                setMaxSize(50, 80);
                break;
            case LUXURY_TAX:
                base = new Rectangle(50, 80);
                base.setFill(Color.rgb(202,250,222));
                base.setStroke(Color.BLACK);
                getChildren().add(base);

                text = new Text(street.getName());
                text.setTextAlignment(TextAlignment.CENTER);
                text.setFont(new Font(6));
                setAlignment(text, Pos.TOP_CENTER);
                text.setTranslateY(10);
                getChildren().add(text);

                icon = new ImageView(new Image(Main.class.getResource("/icon/luxuryTax.png").toString()));
                icon.setFitHeight(40);
                icon.setFitWidth(40);
                icon.setTranslateY(5);
                setAlignment(icon, Pos.CENTER);
                getChildren().add(icon);

                price = new Text("€" + street.getPrice());
                price.setFont(new Font(6));
                setAlignment(price, Pos.BOTTOM_CENTER);
                price.setTranslateY(-5);
                getChildren().add(price);

                setMaxSize(50, 80);
                break;
        }
    }
}
