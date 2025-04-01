import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.Arrays;

public class App extends Application {
    ArrayList<String> weight = new ArrayList<String>(Arrays.asList("kg","lb","gram","ounces"));
    ArrayList<String> distance = new ArrayList<String>(Arrays.asList("km","miles","mm","inch"));
    String converting_to;
    String converting_from;
    double units;
    String converted_units_value;
    int convert_state = 0; //0 is converting from, 1 is converting to

    public static double Convert_Value(double units, String converting_from, String converting_to) {
        double result = 0;
    
    
        switch (converting_from){
            //Weight conversions
            case "kg":
                result = switch (converting_to){
                    case "lb" -> units * 2.20462;
                    case "gram" -> units * 1000;
                    case "ounces" -> units * 2.20462;
                    default -> units;
                };
                break;
            case "lb":
                result = switch (converting_to){
                    case "kg" -> units * 0.453592;
                    case "gram" -> units * 453.592;
                    case "ounces" -> units * 16;
                    default -> units;
                };
                break;
            case "gram":
                result = switch (converting_to){
                    case "kg" -> units * 0.001;
                    case "lb" -> units * 0.00220462;
                    case "ounces" -> units * 0.03527396;
                    default -> units;
                };
                break;
            case "ounces":
                result = switch (converting_to){
                    case "kg" -> units * 0.0283495;
                    case "lb" -> units * 0.0625;
                    case "gram" -> units * 28.3495;
                    default -> units;
                };
                break;
    
            // Distance conversions
            case "km":
                result = switch (converting_to){
                    case "miles" -> units * 0.621371;
                    case "mm" -> units * 1_000_000;
                    case "inch" -> units * 39_370.1;
                    default -> units;
                };
                break;
            case "miles":
                result = switch (converting_to){
                    case "km" -> units * 1.60934;
                    case "mm" -> units * 1_609_340;
                    case "inch" -> units * 63_360;
                    default -> units;
                };
                break;
            case "mm":
                result = switch (converting_to){
                    case "km" -> units * 1e-6;
                    case "miles" -> units * 6.2137e-7;
                    case "inch" -> units * 0.0393701;
                    default -> units;
                };
                break;
            case "inch":
                result = switch (converting_to){
                    case "km" -> units * 0.0000254;
                    case "mm" -> units * 25.4;
                    case "miles" -> units * 0.0000157828;
                    default -> units;
                };
                break;
        }
        return result;
    }
    @Override
    public void start(Stage primaryStage) {
        // Set the title of the window
        primaryStage.setTitle("Metric Converter");
        primaryStage.setResizable(false);

        Label converting_from_label = new Label("Converting from:");
        converting_from_label.setStyle("-fx-font-size: 24px; -fx-text-fill: black;");
        converting_from_label.setLayoutX(480);
        converting_from_label.setLayoutY(0);

        Label converting_from_status = new Label();
        converting_from_status.setStyle("-fx-font-size: 24px; -fx-text-fill: black;");
        converting_from_status.setLayoutX(670);
        converting_from_status.setLayoutY(0);


        Label converting_to_label = new Label("Converting to:");
        converting_to_label.setStyle("-fx-font-size: 24px; -fx-text-fill: black;");
        converting_to_label.setLayoutX(480);
        converting_to_label.setLayoutY(80);

        Label converting_to_status = new Label();
        converting_to_status.setStyle("-fx-font-size: 24px; -fx-text-fill: black;");
        converting_to_status.setLayoutX(670);
        converting_to_status.setLayoutY(80);

        Label converted_units = new Label();
        converted_units.setStyle("-fx-font-size: 22px; -fx-text-fill: black;");
        converted_units.setLayoutX(290);
        converted_units.setLayoutY(210);

        Button kg = new Button();
        kg.setText("kg");
        kg.setStyle("-fx-background-color: gray; -fx-text-fill: white;");
        kg.setLayoutX(0);
        kg.setLayoutY(0);
        kg.setPrefSize(100, 50);
        
        kg.setOnAction(e -> {
            if (convert_state == 0) {
                converting_from = "kg";
                convert_state = 1;
                converting_from_status.setText("kg");
            }else {
                converting_to = "kg";
                convert_state = 0;
                converting_to_status.setText("kg");
            }
        });
        
        Button lb = new Button();  
        lb.setText("lb");  
        lb.setStyle("-fx-background-color: gray; -fx-text-fill: white;");
        lb.setLayoutX(120);
        lb.setLayoutY(0);
        lb.setPrefSize(100, 50);
        
        lb.setOnAction(e -> {
            if (convert_state == 0) {
                converting_from = "lb";  
                convert_state = 1;
                converting_from_status.setText("lb");
            } else {
                converting_to = "lb";  
                convert_state = 0;
                converting_to_status.setText("lb");
            }
        });

        Button gram = new Button();  
        gram.setText("gram");  
        gram.setStyle("-fx-background-color: gray; -fx-text-fill: white;");
        gram.setLayoutX(240);
        gram.setLayoutY(0);
        gram.setPrefSize(100, 50);

        gram.setOnAction(e -> {
            if (convert_state == 0) {
                converting_from = "gram";  
                convert_state = 1;
                converting_from_status.setText("gram");
            } else {
                converting_to = "gram";  
                convert_state = 0;
                converting_to_status.setText("gram");
            }
        });

        Button ounces = new Button();  
        ounces.setText("ounces");  
        ounces.setStyle("-fx-background-color: gray; -fx-text-fill: white;");
        ounces.setLayoutX(360);
        ounces.setLayoutY(0);
        ounces.setPrefSize(100, 50);

        ounces.setOnAction(e -> {
            if (convert_state == 0) {
                converting_from = "ounces";  
                convert_state = 1;
                converting_from_status.setText("ounces");
            } else {
                converting_to = "ounces";  
                convert_state = 0;
                converting_to_status.setText("ounces");
            }
        });

        

        Button km = new Button();  
        km.setText("km");  
        km.setStyle("-fx-background-color: gray; -fx-text-fill: white;");
        km.setLayoutX(0);
        km.setLayoutY(80);
        km.setPrefSize(100, 50);

        km.setOnAction(e -> {
            if (convert_state == 0) {
                converting_from = "km";  
                convert_state = 1;
                converting_from_status.setText("km");
            } else {
                converting_to = "km";  
                convert_state = 0;
                converting_to_status.setText("km");
            }
        });

        Button miles = new Button();  
        miles.setText("miles");  
        miles.setStyle("-fx-background-color: gray; -fx-text-fill: white;");
        miles.setLayoutX(120);
        miles.setLayoutY(80);
        miles.setPrefSize(100, 50);

        miles.setOnAction(e -> {
            if (convert_state == 0) {
                converting_from = "miles";  
                convert_state = 1;
                converting_from_status.setText("miles");
            } else {
                converting_to = "miles";  
                convert_state = 0;
                converting_to_status.setText("miles");
            }
        });

        Button mm = new Button();  
        mm.setText("mm");  
        mm.setStyle("-fx-background-color: gray; -fx-text-fill: white;");
        mm.setLayoutX(240);
        mm.setLayoutY(80);
        mm.setPrefSize(100, 50);

        mm.setOnAction(e -> {
            if (convert_state == 0) {
                converting_from = "mm";  
                convert_state = 1;
                converting_from_status.setText("inch");
            } else {
                converting_to = "mm";  
                convert_state = 0;
                converting_to_status.setText("mm");
            }
        });

        Button inch = new Button();  
        inch.setText("inch");  
        inch.setStyle("-fx-background-color: gray; -fx-text-fill: white;");
        inch.setLayoutX(360);
        inch.setLayoutY(80);
        inch.setPrefSize(100, 50);

        inch.setOnAction(e -> {
            if (convert_state == 0) {
                converting_from = "inch";  
                convert_state = 1;
                converting_from_status.setText("inch");
            } else {
                converting_to = "inch";  
                convert_state = 0;
                converting_to_status.setText("inch");
            }
        });

        

        TextField text_field = new TextField();
        text_field.setLayoutX(0);
        text_field.setLayoutY(200);
        text_field.setPrefSize(200, 50);



        Button convert = new Button();  
        convert.setText("convert");  
        convert.setStyle("-fx-background-color: gray; -fx-text-fill: white;");
        convert.setLayoutX(220);
        convert.setLayoutY(210);
        

        convert.setOnAction(e -> {
            try {
                if(((weight.contains(converting_to) && weight.contains(converting_to)) || (distance.contains(converting_from) && distance.contains(converting_from)))) {
                    units = Double.parseDouble(text_field.getText());
                    units = Convert_Value(units, converting_from, converting_to);
                    converted_units_value = Double.toString(units);
                    converted_units.setText(converted_units_value);
                    converting_to = "";
                    converting_to_status.setText("");
                    converting_from = "";
                    converting_from_status.setText("");
                    converted_units_value = "";

                }else {
                    converted_units.setText("Error, compare valid metrics");
                    converting_to = "";
                    converting_to_status.setText("");
                    converting_from = "";
                    converting_from_status.setText("");
                    converted_units_value = "";
                }
                
                
            }catch(NumberFormatException Error) {
                converted_units.setText("Error, please enter valid number");
                converting_to = "";
                converting_to_status.setText("");
                converting_from = "";
                converting_from_status.setText("");
                converted_units_value = "";
            }
            

        });


        
        Pane root = new Pane();
        root.getChildren().add(kg);
        root.getChildren().add(lb);
        root.getChildren().add(gram);
        root.getChildren().add(ounces);

        root.getChildren().add(km);
        root.getChildren().add(miles);
        root.getChildren().add(mm);
        root.getChildren().add(inch);

        root.getChildren().add(converting_from_label);
        root.getChildren().add(converting_to_label);
        root.getChildren().add(converting_from_status);
        root.getChildren().add(converting_to_status);

        root.getChildren().add(text_field);
        root.getChildren().add(converted_units);
        root.getChildren().add(convert);

        Scene scene = new Scene(root, 800, 400); // Scene size: 800x400
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
