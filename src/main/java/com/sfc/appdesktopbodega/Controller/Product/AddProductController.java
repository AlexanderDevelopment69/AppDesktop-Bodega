package com.sfc.appdesktopbodega.Controller.Product;

import animatefx.animation.FadeInLeft;
import com.jfoenix.controls.*;
import com.jfoenix.validation.DoubleValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import com.sfc.appdesktopbodega.Model.Product;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyTableView;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddProductController implements Initializable {

    @FXML
    private AnchorPane stackDashboard;
    @FXML
    private Label labelTitle;

    @FXML
    private Label labelDescription;
    @FXML
    private Label labelDescription2;

    @FXML
    private JFXTextField search;

    @FXML
    private JFXTextField code;

    @FXML
    private JFXTextField product;

    @FXML
    private JFXComboBox<String> cmCategory;

    @FXML
    private JFXTextField brand;

    @FXML
    private JFXTextField cost;

    @FXML
    private JFXTextField price;

    @FXML
    private JFXTextField image;

    @FXML
    private MFXLegacyTableView<Product> productTable;
    @FXML
    private TableColumn<?, ?> tbCode;
    @FXML
    private TableColumn<?, ?> tbCodeProduct;

    @FXML
    private TableColumn<?, ?> tbProduct;

    @FXML
    private TableColumn<?, ?> tbCategory;

    @FXML
    private TableColumn<?, ?> tbBrand;

    @FXML
    private TableColumn<?, ?> tbCost;

    @FXML
    private TableColumn<?, ?> tbPrice;


    @FXML
    private ImageView photo;

    @FXML
    private JFXDrawer drawer;

//    @FXML
//    private MFXLabel addCategory;
//    @FXML
//    private MFXLabel updateCategory;
    @FXML
    private StackPane MenuDrawerADD;
    @FXML
    private StackPane MenuDrawerUP;
    Stage stage = null;


    @FXML
    void cancel(ActionEvent event) {
        code.setText("");
        product.setText("");
        brand.setText("");
        cmCategory.setValue(null);
        cost.setText("");
        price.setText("");
        image.setText("");
    }

    @FXML
    void deleteProduct(ActionEvent event) throws SQLException {
        Product products = productTable.getSelectionModel().getSelectedItem();

        if (products == null) {
            JOptionPane.showMessageDialog(null, "Selecciona un usuario");
        } else {

            products.DeleteProduct();
            showProduct();
            JFXSnackbar snackbar = new JFXSnackbar(stackDashboard);
            snackbar.setPrefWidth(603);
            snackbar.setStyle("-fx-background-color: red ");
            snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Producto Eliminado")));

        }

    }




    @FXML
    void addProduct(ActionEvent event) throws SQLException, FileNotFoundException {
        //Instancia para obtener el id de categoria
        Product getcategory = new Product();
        String id = String.valueOf(cmCategory.getValue());
        //Obtiene el id a partir del nombre de categoria selecionada del combobox
        getcategory.GetICMB(id);
        String idCategory = getcategory.getCategory();
        System.out.println(idCategory);
//        String c=cmCategory.getSelectionModel().getSelectedItem().toString();




        String DOUBLE_POSITIVE = "(\\d+)?\\.(\\d+)";
        String INT_POSITIVE ="^\\+?(0|[1-9]\\d*)$";
        String DECIMAL ="\\d+\\.?\\d*";

//        DoubleValidator digit = new DoubleValidator();
//        digit.setMessage("Solo digitos!");
//
//        RequiredFieldValidator validator = new RequiredFieldValidator();
//        ImageView item = new ImageView("/Images/inputBlank.png");
//        validator.setMessage("Completa el campo vacio!");
//        item.setFitHeight(15);
//        item.setFitWidth(15);
//        item.setPreserveRatio(true);
//        validator.setIcon(item);

//        if (code.getText().isBlank()) {
//            code.getValidators().add(validator);
//            code.validate();
//            code.focusedProperty().addListener((o, oldVal, newVal) -> {
//                if (!newVal) {
//                    code.validate();
//                }
//            });
//
//        }
//        if (product.getText().isBlank()) {
//            product.getValidators().add(validator);
//            product.validate();
//            product.focusedProperty().addListener((o, oldVal, newVal) -> {
//                if (!newVal) {
//                    product.validate();
//                }
//            });
//        }
//        if (brand.getText().isBlank()) {
//            brand.getValidators().add(validator);
//            brand.validate();
//            brand.focusedProperty().addListener((o, oldVal, newVal) -> {
//                if (!newVal) {
//                    brand.validate();
//                }
//            });
//        }
//        if (cmCategory.getValue() == null) {
//            cmCategory.getValidators().add(validator);
//            cmCategory.validate();
//            cmCategory.focusedProperty().addListener((o, oldVal, newVal) -> {
//                if (!newVal) {
//                    cmCategory.validate();
//                }
//            });
//        }
//
//
//        if (cost.getText().isBlank()) {
//            cost.getValidators().add(validator);
//            cost.validate();
//            cost.focusedProperty().addListener((o, oldVal, newVal) -> {
//                if (!newVal) {
//                    cost.validate();
//                }
//            });
//        }
//
//
//        if (price.getText().isBlank()) {
//            price.getValidators().add(validator);
//            price.validate();
//            price.focusedProperty().addListener((o, oldVal, newVal) -> {
//                if (!newVal) {
//                    price.validate();
//                }
//            });
//        }
//        if (image.getText().isBlank()) {
//            image.getValidators().add(validator);
//            image.validate();
//            image.focusedProperty().addListener((o, oldVal, newVal) -> {
//                if (!newVal) {
//                    image.validate();
//                }
//            });
//        }
//
//        if (!cost.getText().matches(DECIMAL)) {
//            cost.getValidators().add(digit);
//            cost.validate();
//            cost.focusedProperty().addListener((o, oldVal, newVal) -> {
//                if (!newVal) {
//                    cost.validate();
//                }
//            });
//        }
//
//            if (!price.getText().matches(DECIMAL)) {
//                price.getValidators().add(digit);
//                price.validate();
//                price.focusedProperty().addListener((o, oldVal, newVal) -> {
//                    if (!newVal) {
//                        price.validate();
//                    }
//                });
//            }


    if(code.getText().isBlank() || product.getText().isBlank() || cmCategory.getValue()==null || brand.getText().isBlank()||price.getText().isBlank() ||cost.getText().isBlank()||image.getText().isBlank()){

    }
    if(idCategory==null){
        cmCategory.setStyle("-fx-text-fill: red");
        cmCategory.setValue("Error de Campo");
    }

    else {
        if((cost.getText().matches(DOUBLE_POSITIVE)||cost.getText().matches(INT_POSITIVE) && ((price.getText().matches(DOUBLE_POSITIVE)||price.getText().matches(INT_POSITIVE)))) && (idCategory!=null) && !image.getText().isBlank()) {
            // Añade los productos
            // Nueva instancia
            Product products = new Product(code.getText(), product.getText(), idCategory, brand.getText(), Double.parseDouble(cost.getText()), Double.parseDouble(price.getText()), 0, image.getText());

            if (products.AddProduct()) {
                JFXSnackbar snackbar = new JFXSnackbar(stackDashboard);
                snackbar.setPrefWidth(603);
                snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Producto Creado")));

            } else {
                JFXSnackbar snackbar = new JFXSnackbar(stackDashboard);
                snackbar.setPrefWidth(603);
                snackbar.setStyle("-fx-background-color: red ");
                snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Producto Existente")));
            }


            showProduct();

        }

    }



    }

    @FXML
    void selectionProduct(MouseEvent event) throws FileNotFoundException, SQLException {
        Product products = productTable.getSelectionModel().getSelectedItem();



        if (products == null) {

        } else {
            code.setText(products.getCodeProduct());
            product.setText(products.getProduct());
            brand.setText(products.getBrand());
            cmCategory.setValue(products.getCategory());
            cost.setText(String.valueOf(products.getCost()));
            price.setText(String.valueOf(products.getPrice()));

            products.GetPhotoProduct(products.getCodeProduct());;
            photo.setImage(products.getImage());

        }

//        stackDashboard.addEventFilter(MouseEvent.MOUSE_CLICKED, evt -> {
//            Node source = evt.getPickResult().getIntersectedNode();
//
//            // move up through the node hierarchy until a TableRow or scene root is found
//            while (source != null && !(source instanceof TableRow)) {
//                source = source.getParent();
//            }
//
//
//            // clear selection on click anywhere but on a filled row
//            if (source == null || (source instanceof TableRow && ((TableRow) source).isEmpty())) {
//                productTable.getSelectionModel().clearSelection();
//            }
//        });
    }




    @FXML
    void uploadImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(stage);
        System.out.println(selectedFile);
        image.setText(String.valueOf(selectedFile));
    }


    void showProduct() {
//        UserTable = FXCollections.observableArrayList();
        tbCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        tbCodeProduct.setCellValueFactory(new PropertyValueFactory<>("codeProduct"));
        tbProduct.setCellValueFactory(new PropertyValueFactory<>("product"));
        tbCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        tbBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        tbCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        tbPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        try {
            Product products = new Product();
            ObservableList<Product> items = products.GetDataProduct();
            this.productTable.setItems(items);
            productTable.refresh();
        } catch (SQLException e) {
            System.out.println(e);
            
        }

    }

    @FXML
    void updateProduct(ActionEvent event) throws SQLException {
        Product products = productTable.getSelectionModel().getSelectedItem();
        if (products == null) {
            JFXSnackbar snackbar = new JFXSnackbar(stackDashboard);
            snackbar.setPrefWidth(603);
            snackbar.setStyle("-fx-background-color: red ");
            snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Selecciona un Producto")));
        } else {
            products.UpdateProduct(product.getText());
            showProduct();
            JFXSnackbar snackbar = new JFXSnackbar(stackDashboard);
            snackbar.setPrefWidth(603);
            snackbar.setStyle("-fx-background-color: red ");
            snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Producto Actualizado")));

        }
    }


    @FXML
    void searchProduct(KeyEvent event) {
        String Buscar = search.getText();
        try {
            Product products = new Product();
            ObservableList<Product> items = products.Search(Buscar);
            this.productTable.setItems(items);
            productTable.refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public void showCategoryNameCMBOX(){

        Product products=new Product();
        ObservableList<String> items=products.GetCategoryName();
        cmCategory.setItems(items);

    }

    public void ValidationTextfields(){


        DoubleValidator digit = new DoubleValidator();
        String pattern = "^(-([1-9]\\\\d*\\\\.\\\\d*|0\\\\.\\\\d*[1-9]\\\\d*))|0?\\\\.0+|0$";
        String DOUBLE_POSITIVE = "(\\d+)?\\.(\\d+)";
        String INT_POSITIVE ="^\\+?(0|[1-9]\\d*)$";
        String DECIMAL ="\\d+\\.?\\d*";
        digit.setMessage("Solo digitos!");


        RequiredFieldValidator validator = new RequiredFieldValidator();
        ImageView item = new ImageView("/com/sfc/appdesktopbodega/Images/inputBlank.png");
        validator.setMessage("Completa el campo vacio!");
        item.setFitHeight(15);
        item.setFitWidth(15);
        item.setPreserveRatio(true);
        validator.setIcon(item);
        digit.setIcon(item);


        code.getValidators().add(validator);
        product.getValidators().add(validator);
        brand.getValidators().add(validator);
        cost.getValidators().add(validator);
        price.getValidators().add(validator);
        cost.getValidators().add(digit);
        price.getValidators().add(digit);
        cmCategory.getValidators().add(validator);
        image.getValidators().add(validator);

        code.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                code.validate();
            }
        });
        product.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                product.validate();
            }
        });
        brand.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                brand.validate();
            }
        });
        cmCategory.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                cmCategory.validate();
            }
        });
        cost.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                cost.validate();
            }
        });
        price.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                price.validate();
            }
        });
       image.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                image.validate();
            }
        });



    }


//    public void showDrawerPane(){
//
//        try {
//            MenuDrawerADD = FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Product/Category/AddCategory.fxml"));
//            MenuDrawerUP = FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Product/Category/UpdateCategory.fxml"));
////            drawer.setSidePane(box);
//
////            MenuDrawer.prefHeightProperty().bind(stackDashboard.widthProperty());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        };
//
//        drawer.setOnDrawerClosed(e -> drawer.setSidePane());
//
//
//        addCategory.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event) -> {
//            if (drawer.isOpening()) {
//
//                drawer.close();
//            } else {
//
//                drawer.setSidePane(MenuDrawerADD);
//                drawer.open();
//                drawer.toFront();
////                drawer.setMinWidth(300);
//
//
//
//            }
//
//        });
//
//        updateCategory.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event) -> {
//            if (drawer.isOpening()) {
//
//                drawer.close();
//
//            } else {
//
//                drawer.setSidePane(MenuDrawerUP);
//                drawer.open();
//                drawer.toFront();
////                drawer.setMinWidth(300);
//
//
//            }
//
//        });
//
//    }


//public void showDrawerPaneAddCategory() {
//
//        drawer.setOnDrawerClosed(e -> drawer.setSidePane());
//        addCategory.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event) -> {
//        if (drawer.isOpening()) {
//            drawer.close();
//        } else {
//            try{
//                MenuDrawerADD = FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Product/Category/AddCategory.fxml"));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//            drawer.setSidePane(MenuDrawerADD);
//            drawer.open();
//            drawer.toFront();
////                drawer.setMinWidth(300);
//
//
//        }
//
//    });
//
//
//
//}

//public void showDrawerPaneUpdateCategory(){
//        drawer.setOnDrawerClosed(e -> drawer.setSidePane());
//        updateCategory.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event) -> {
//        if (drawer.isOpening()) {
//
//            drawer.close();
//
//        } else {
//
//            try {
//                MenuDrawerUP = FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Product/Category/UpdateCategory.fxml"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            drawer.setSidePane(MenuDrawerUP);
//            drawer.open();
//            drawer.toFront();
////                drawer.setMinWidth(300);
//
//        }
//
//    });
//
//
//}



    //USADO AHORA /------------------------------------------

//    @FXML
//    void addCategory(MouseEvent event) throws IOException {
//        MenuDrawerADD = FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Product/Category/AddCategory.fxml"));
////        drawer.setOnDrawerClosed(e -> drawer.setSidePane());
//        if (drawer.isOpening()) {
//                drawer.close();
//            } else {
//                drawer.setSidePane(MenuDrawerADD);
//                drawer.open();
//                drawer.toFront();
//
////                drawer.setMinWidth(300);
//
//
//            }
//
//
//    }
//    @FXML
//    void updateCategory(MouseEvent event) throws IOException {
//
//        MenuDrawerUP = FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Product/Category/UpdateCategory.fxml"));
//
////        drawer.setOnDrawerClosed(e -> drawer.setSidePane());
//        if (drawer.isOpening()) {
//
//            drawer.close();
//
//        } else {
//            drawer.setSidePane(MenuDrawerUP);
//            drawer.open();
//            drawer.toFront();
////                drawer.setMinWidth(300);
//
//        }


//    }
    //------------------------------------------------------------------------------
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ValidationTextfields();
//        new Thread(this::showProduct).start();
//        new Thread(this::showCategoryNameCMBOX).start();
//        new Thread(this::showDrawerPane).start();


        // do your GUI stuff here
        Platform.runLater(() -> {
           showProduct();
           showCategoryNameCMBOX();

            //Titulos de la scena
            new FadeInLeft(labelTitle).play();
            labelTitle.setVisible(true);
            new FadeInLeft(labelDescription).play();
            labelDescription.setVisible(true);
            new FadeInLeft(labelDescription2).play();
            labelDescription2.setVisible(true);
            FadeTransition fts = new FadeTransition(Duration.millis(300),productTable);
            fts.setFromValue(0);
            fts.setToValue(1);
            fts.play();


        });


    }

}


