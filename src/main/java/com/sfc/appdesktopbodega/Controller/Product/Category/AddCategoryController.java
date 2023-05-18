package com.sfc.appdesktopbodega.Controller.Product.Category;

import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbarLayout;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.sfc.appdesktopbodega.Model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddCategoryController implements Initializable {


    @FXML
    private StackPane stackPane;

    @FXML
    private JFXTextField categoryCode;

    @FXML
    private JFXTextField category;

    @FXML
    private JFXTextArea categoryDescription;

    @FXML
    void addCategory() throws SQLException, IOException {



        if(category.getText().isBlank()){


        }
        else{
            //Registro de categorias
            Product products= new Product(category.getText(),categoryDescription.getText());
            if(products.AddCategory()){

                clearTexfieds();
                showCategoryID();


            }
            else{
                JFXSnackbar snackbar = new JFXSnackbar(stackPane);
                snackbar.setPrefWidth(300);
                snackbar.setStyle("-fx-background-color: red ");
                snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Categoria ya existe")));
            }


        }



    }




















    @FXML
    void cancel(ActionEvent event) {


    }

    void clearTexfieds(){
        category.setText("");
        categoryDescription.setText(" ");

    }


    void showCategoryID() {

        try {
            categoryCode.setText(new Product().GetCategoryID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }














    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        new Thread(this::showCategoryID).start();




        RequiredFieldValidator validator = new RequiredFieldValidator();
        ImageView item = new ImageView("/com/sfc/appdesktopbodega/Images/inputBlank.png");
        validator.setMessage("Completa el campo vacio!");
        item.setFitHeight(15);
        item.setFitWidth(15);
        item.setPreserveRatio(true);
        validator.setIcon(item);



        category.getValidators().add(validator);
        categoryDescription.getValidators().add(validator);

        category.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                category.validate();
            }
        });
        categoryDescription.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                categoryDescription.validate();
            }
        });
















    }
}
