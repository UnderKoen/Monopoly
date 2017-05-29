package nl.UnderKoen.monopoly.view.elements;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
                Rectangle base = new Rectangle(80,80);
                base.setFill(Color.rgb(202,250,222));
                base.setStroke(Color.BLACK);
                getChildren().add(base);

                Text text = new Text("COLLECT\n€" + street.getPrice() + " SALARY\nAS YOU PASS");
                text.setTextAlignment(TextAlignment.CENTER);
                text.setFont(new Font(7));
                text.setRotate(-45);
                text.setTranslateY(11);
                text.setTranslateX(0);
                getChildren().add(text);

                ImageView icon = new ImageView(new Image(Main.class.getResource("/icon/start.png").toString()));
                icon.setFitHeight(70);
                icon.setFitWidth(70);
                setAlignment(icon, Pos.CENTER);
                getChildren().add(icon);

                setMaxSize(80, 80);
                break;
            case JAIL:
                base = new Rectangle(80,80);
                base.setFill(Color.rgb(202,250,222));
                base.setStroke(Color.BLACK);
                getChildren().add(base);

                icon = new ImageView(new Image(Main.class.getResource("/icon/jail.png").toString()));
                icon.setFitHeight(80);
                icon.setFitWidth(80);
                setAlignment(icon, Pos.CENTER);
                getChildren().add(icon);

                setMaxSize(80, 80);
                break;
            case VISIT:
                base = new Rectangle(80,80);
                base.setFill(Color.rgb(202,250,222));
                base.setStroke(Color.BLACK);
                getChildren().add(base);

                text = new Text("GO TO");
                text.setFont(new Font(10));
                text.setRotate(-45);
                text.setTranslateY(13);
                text.setTranslateX(2);
                getChildren().add(text);

                icon = new ImageView(new Image(Main.class.getResource("/icon/gotoJail.png").toString()));
                icon.setRotate(-45);
                icon.setFitHeight(50);
                icon.setFitWidth(50);
                icon.setTranslateY(15);
                icon.setTranslateX(15);
                getChildren().add(icon);

                Text text2 = new Text("JAIL");
                text2.setFont(new Font(10));
                text2.setRotate(-45);
                text2.setTranslateY(57);
                text2.setTranslateX(48);
                getChildren().add(text2);

                setMaxSize(80, 80);
                break;
            case PARKING:
                base = new Rectangle(80,80);
                base.setFill(Color.rgb(202,250,222));
                base.setStroke(Color.BLACK);
                getChildren().add(base);

                text = new Text("FREE");
                text.setFont(new Font(10));
                text.setRotate(-45);
                text.setTranslateY(13);
                text.setTranslateX(5);
                getChildren().add(text);

                icon = new ImageView(new Image(Main.class.getResource("/icon/freeParking.png").toString()));
                icon.setRotate(-45);
                icon.setFitHeight(50);
                icon.setFitWidth(50);
                icon.setTranslateY(15);
                icon.setTranslateX(15);
                getChildren().add(icon);

                text2 = new Text("PARKING");
                text2.setFont(new Font(10));
                text2.setRotate(-45);
                text2.setTranslateY(54);
                text2.setTranslateX(40);
                getChildren().add(text2);

                setMaxSize(80, 80);
                break;
            case NORMAL:
                base = new Rectangle(50,80);
                base.setFill(Color.rgb(202,250,222));
                base.setStroke(Color.BLACK);
                getChildren().add(base);

                Rectangle color = new Rectangle(50,15);
                color.setFill(street.getTown().getColor());
                color.setStroke(Color.BLACK);
                getChildren().add(color);

                VBox top = new VBox(0);
                top.setAlignment(Pos.TOP_CENTER);
                top.setTranslateY(20);

                text = new Text(street.getName());
                text.setFont(new Font(6));
                text.setTextAlignment(TextAlignment.CENTER);
                top.getChildren().add(text);

                text2 = new Text(street.getTown().getName());
                text2.setFont(new Font(6));
                text2.setTextAlignment(TextAlignment.CENTER);
                top.getChildren().add(text2);

                getChildren().add(top);

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
                icon.setTranslateY(5);
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
