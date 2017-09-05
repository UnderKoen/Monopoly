package nl.UnderKoen.monopoly.client.view.elements;

import javafx.scene.layout.StackPane;

/**
 * Created by Under_Koen on 23-05-17.
 */
public class StreetElement extends StackPane {
    /*public StreetElement(Street street) {
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

                ImageView img.icon = new ImageView(new Image(Client.class.getResource("/img.icon/start.png").toString()));
                img.icon.setFitHeight(70);
                img.icon.setFitWidth(70);
                setAlignment(img.icon, Pos.CENTER);
                getChildren().add(img.icon);

                setMaxSize(80, 80);
                break;
            case JAIL:
                base = new Rectangle(80,80);
                base.setFill(Color.rgb(202,250,222));
                base.setStroke(Color.BLACK);
                getChildren().add(base);

                img.icon = new ImageView(new Image(Client.class.getResource("/img.icon/jail.png").toString()));
                img.icon.setFitHeight(80);
                img.icon.setFitWidth(80);
                setAlignment(img.icon, Pos.CENTER);
                getChildren().add(img.icon);

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

                img.icon = new ImageView(new Image(Client.class.getResource("/img.icon/gotoJail.png").toString()));
                img.icon.setRotate(-45);
                img.icon.setFitHeight(50);
                img.icon.setFitWidth(50);
                img.icon.setTranslateY(15);
                img.icon.setTranslateX(15);
                getChildren().add(img.icon);

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

                img.icon = new ImageView(new Image(Client.class.getResource("/img.icon/freeParking.png").toString()));
                img.icon.setRotate(-45);
                img.icon.setFitHeight(50);
                img.icon.setFitWidth(50);
                img.icon.setTranslateY(15);
                img.icon.setTranslateX(15);
                getChildren().add(img.icon);

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

                img.icon = new ImageView(new Image(Client.class.getResource("/img.icon/station.png").toString()));
                img.icon.setFitHeight(40);
                img.icon.setFitWidth(45);
                img.icon.setTranslateY(5);
                setAlignment(img.icon, Pos.CENTER);
                getChildren().add(img.icon);

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

                img.icon = new ImageView(new Image(Client.class.getResource("/img.icon/waterWorks.png").toString()));
                img.icon.setFitHeight(25);
                img.icon.setFitWidth(40);
                setAlignment(img.icon, Pos.CENTER);
                getChildren().add(img.icon);

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

                img.icon = new ImageView(new Image(Client.class.getResource("/img.icon/electricity.png").toString()));
                img.icon.setTranslateY(5);
                img.icon.setFitHeight(50);
                img.icon.setFitWidth(40);
                setAlignment(img.icon, Pos.CENTER);
                getChildren().add(img.icon);

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

                img.icon = new ImageView(new Image(Client.class.getResource("/img.icon/chance.png").toString()));
                img.icon.setFitHeight(60);
                img.icon.setFitWidth(30);
                img.icon.setTranslateY(5);
                setAlignment(img.icon, Pos.CENTER);
                getChildren().add(img.icon);

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

                img.icon = new ImageView(new Image(Client.class.getResource("/img.icon/communityChest.png").toString()));
                img.icon.setFitHeight(40);
                img.icon.setFitWidth(40);
                setAlignment(img.icon, Pos.CENTER);
                getChildren().add(img.icon);

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

                img.icon = new ImageView(new Image(Client.class.getResource("/img.icon/incomeTax.png").toString()));
                img.icon.setFitHeight(35);
                img.icon.setFitWidth(30);
                img.icon.setTranslateY(5);
                setAlignment(img.icon, Pos.CENTER);
                getChildren().add(img.icon);

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

                img.icon = new ImageView(new Image(Client.class.getResource("/img.icon/luxuryTax.png").toString()));
                img.icon.setFitHeight(40);
                img.icon.setFitWidth(40);
                img.icon.setTranslateY(5);
                setAlignment(img.icon, Pos.CENTER);
                getChildren().add(img.icon);

                price = new Text("€" + street.getPrice());
                price.setFont(new Font(6));
                setAlignment(price, Pos.BOTTOM_CENTER);
                price.setTranslateY(-5);
                getChildren().add(price);

                setMaxSize(50, 80);
                break;
        }
    }*/
}
