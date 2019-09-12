package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Dice extends Parent {
    public String valueOfDice;
    private int posX = 0;
    private int posY = 0;

    Rectangle backgroundDice;
    Text diceValue;
    public Dice(String l, int posX, int posY)
    {

        backgroundDice = new Rectangle(100,100, Color.WHITE);
        this.getChildren().add(backgroundDice);

        diceValue = new Text(valueOfDice);
        diceValue.setFont(new Font(25));
        diceValue.setFill(Color.BLACK);
        diceValue.setX(25);
        diceValue.setY(45);
        this.getChildren().add(diceValue);
        this.setTranslateX(posX);
        this.setTranslateY(posY);
    }
}
