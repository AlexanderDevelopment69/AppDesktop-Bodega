package com.sfc.appdesktopbodega.Controller.Product.Category;

import animatefx.animation.BounceOut;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.sfc.appdesktopbodega.Model.Product;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyListView;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdateCategoryController implements Initializable {



    @FXML
    private StackPane stackPane;
    @FXML
    private Pane pane;
    @FXML
    private MFXLegacyListView<Label> categoryList;

    @FXML
    private JFXTextField category;

    @FXML
    private JFXTextArea categoryDescription;

    @FXML
    private JFXTextField search;




    @FXML
    void updateCategory(ActionEvent event) throws SQLException {
        String id = null;
        Product products=new Product(category.getText(),categoryDescription.getText());
        //obtener caracteres numericos de una cadena
        String cadena = categoryList.getSelectionModel().getSelectedItem().getText();

        String patron ="\\d+";
        Pattern pattern= Pattern.compile(patron);
        Matcher matcher= pattern.matcher(cadena);

        while(matcher.find()){
//            category.setText(matcher.group());

            id=matcher.group();

        }
//        products.UpdateCategory(id);

    if(products.UpdateCategory(id)) {

        Label text= new Label("Registro exitoso");
        pane.getChildren().add(text);
        text.setLayoutX(100);
        text.setLayoutY(750);
        text.setStyle("-fx-text-fill: #84FC9A;-fx-font-size: 22");
        new BounceOut(text).play();
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> text.setText(null));
        pause.play();
        showCategoryList();

    }
    else{
        Label text= new Label("Categoria Existente");
        pane.getChildren().add(text);
        text.setLayoutX(70);
        text.setLayoutY(750);
        text.setStyle("-fx-text-fill: #FA8072;-fx-font-size: 22");
        new BounceOut(text).play();
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> text.setText(null));
        pause.play();

    }

    }

    @FXML
    void cancel(ActionEvent event) {
        category.setText("");
        categoryDescription.setText("");
    }


    public void showCategoryList() {

        try {
            Product products = new Product();
            ObservableList<String> items = products.GetDataCategory();
//    System.out.println(items);
//    for (int i = 0; i < items.size(); i++) {
//        System.out.println(items.get(i));

//}

            ObservableList<Label> values = FXCollections.observableArrayList();
            Label[] l = new Label[items.size()];
            for (int i = 0; i < items.size(); i++) {
                values.addAll(l[i] = createLegacyLabel(items.get(i)));
            }

            categoryList.setItems(values);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private Label createLegacyLabel(String text)  {

        ImageView item = new ImageView("/com/sfc/appdesktopbodega/Images/pointGreen.png");
        item.setFitHeight(10);
        item.setFitWidth(10);
        item.setPreserveRatio(true);
        Label label = new Label(text);
        label.setStyle("-fx-background-color: transparent; -fx-text-fill: #575759");
        label.setGraphic(item);
        label.setGraphicTextGap(10);
        label.setPadding(new Insets(5,0,5,5));
        return label;
    }



    @FXML
    void selectCategory(MouseEvent event) {
        try {
            Product products = new Product();
            String cadena = categoryList.getSelectionModel().getSelectedItem().getText();
            String cadenaDescription = categoryList.getSelectionModel().getSelectedItem().getText();


                //obtener caracteres, solo texto de una cadena
                category.setText(cadenaDescription.substring(3).trim());
                // -----------------------------

                //obtener caracteres numericos de una cadena
                String patron = "\\d+";
                Pattern pattern = Pattern.compile(patron);
                Matcher matcher = pattern.matcher(cadena);

                while (matcher.find()) {
//            category.setText(matcher.group());

                    products.GetCategoryDescription(matcher.group());
                    categoryDescription.setText(products.getCategoryDescription());
                }
                // -----------------------------


        }catch (Exception e){

        }
    }
    @FXML
    void searchCategory(KeyEvent event) {
        String Buscar=search.getText();
        try {
            Product products=new Product();
            ObservableList<String> items=products.SearchCategory(Buscar);

            ObservableList<Label> values = FXCollections.observableArrayList();
            Label[] l = new Label[items.size()];
            for (int i = 0; i < items.size(); i++) {
                values.addAll(l[i] = createLegacyLabel(items.get(i)));
            }

            categoryList.setItems(values);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new Thread(this::showCategoryList).start();
    }
}
