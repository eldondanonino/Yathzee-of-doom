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

public class Hand extends Parent
{
    public Hand(){
    int i = 0;
    Dice[] hand;



        Rectangle hbackground = new Rectangle();
        hbackground.setWidth(700);
        hbackground.setHeight(350);
        hbackground.setX(050);
        hbackground.setY(175);
        hbackground.setFill(Color.GREEN);
        this.getChildren().add(hbackground);

            hand = new Dice[]{
                new Dice("1", i, 350),
                new Dice("2", i + 150, 350),
                new Dice("3", i + 300, 350),
                new Dice("4", i + 450, 350),
                new Dice("5", i + 600, 350)
            };
            for(Dice dice : hand)
            {
                this.getChildren().add(dice);
            }
    }
}
