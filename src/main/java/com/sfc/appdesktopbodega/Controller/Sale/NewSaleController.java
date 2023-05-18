package com.sfc.appdesktopbodega.Controller.Sale;


import animatefx.animation.ZoomIn;
import com.jfoenix.controls.*;
import com.jfoenix.validation.RequiredFieldValidator;

import com.sfc.appdesktopbodega.Model.Customer;
import com.sfc.appdesktopbodega.Model.Sale;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyTableView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;



public class NewSaleController  implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton btnScan;
    @FXML
    private Label labIdSale;

    @FXML
    private Label labIdSALE;

    @FXML
    private Label labCustomerSALE;

    @FXML
    private Label labDateSALE;

    @FXML
    private JFXTextField txtDni;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtUnits;
    @FXML
    private JFXTextField txtDiscount;

    public static JFXTextField static_dni;


    @FXML
    private Label labAmountSALE;

    @FXML
    private Label labDiscountSALE;




    @FXML
    private MFXLegacyTableView<Sale> saleTable;

    @FXML
    private TableColumn<?, ?> tbCodeProduct;

    @FXML
    private TableColumn<?, ?> tbProduct;

    @FXML
    private TableColumn<?, ?> tbUnits;

    @FXML
    private TableColumn<?, ?> tbPrice;

    @FXML
    private TableColumn<?, ?> tbDiscount;

    @FXML
    private TableColumn<?, ?> tbSubTotal;

    @FXML
    private JFXComboBox<String> cmProduct;



    @FXML
    private Label labelDescription;

    @FXML
    private Label labelTitle;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private StackPane MenuDrawerADDCustomer;


    @FXML
    private JFXTextField dni;

    @FXML
    private JFXTextField ruc;

    @FXML
    private JFXTextField names;

    @FXML
    private JFXTextField lastNames;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField home;

    @FXML
    private JFXTextField age;

    @FXML
    private JFXTextField phoneNumber;

    @FXML
    void addCustomer(ActionEvent event) throws SQLException, FileNotFoundException {





        if((dni.getText().isBlank()) || (names.getText().isBlank() || lastNames.getText().isBlank()) ){

        }
        else{
            Customer customer=new Customer(dni.getText(),ruc.getText(),names.getText(),lastNames.getText(),email.getText(),age.getText(),home.getText(),phoneNumber.getText());
            if(customer.AddCustomer()){
                txtDni.setText(dni.getText());
                txtName.setText(names.getText());
                JFXSnackbar snackbar = new JFXSnackbar(root);
                snackbar.setPrefWidth(603);
                snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Registro Exitoso")));


            }else{
                JFXSnackbar snackbar = new JFXSnackbar(root);
                snackbar.setPrefWidth(603);
                snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Cliente ya existe")));
            }
        }




    }

    @FXML
    void cancelCustomer(ActionEvent event) {

    }


    public void validationTextfields(){

        RequiredFieldValidator validator = new RequiredFieldValidator();
        ImageView item = new ImageView("/com/sfc/appdesktopbodega/Images/inputBlank.png");
        validator.setMessage("Completa el campo vacio!");
        item.setFitHeight(15);
        item.setFitWidth(15);
        item.setPreserveRatio(true);
        validator.setIcon(item);



        dni.getValidators().add(validator);
        ruc.getValidators().add(validator);
        names.getValidators().add(validator);
        lastNames.getValidators().add(validator);



        dni.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                dni.validate();
            }
        });
        ruc.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                ruc.validate();
            }
        });
        names.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                names.validate();
            }
        });
        lastNames.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                lastNames.validate();
            }
        });


    }






    @FXML
    private StackPane MenuDrawerSHOWInventory;

    private ObservableList<Sale> AddProductTable;
    @FXML
    private Pane validPane;



    @FXML
    void addProductSale() throws SQLException {
        String DOUBLE_POSITIVE = "(\\d+)?\\.(\\d+)";
        String INT_POSITIVE ="^\\+?(0|[1-9]\\d*)$";


        String product=String.valueOf(cmProduct.getValue());

        if(product==null || txtUnits.getText().isBlank() || txtDiscount.getText().isBlank()){

            JFXSnackbar snackbar = new JFXSnackbar(root);
            snackbar.setPrefWidth(603);
            snackbar.setStyle("-fx-background-color: red ");
            snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Completa los campos")));

        } else{
            int units= Integer.parseInt(txtUnits.getText());
            if(((txtUnits.getText().matches(INT_POSITIVE)) && (units>0))  && ((txtDiscount.getText().matches(INT_POSITIVE))|| txtDiscount.getText().matches(DOUBLE_POSITIVE))){
                Sale getProductinf=new Sale();
                getProductinf.GetDATAProduct(product);
                Sale sales= new Sale(product,Integer.parseInt(txtUnits.getText()),Double.parseDouble(txtDiscount.getText()),getProductinf.getCodeProduct(),getProductinf.getPrice());
                AddProductTable.add(sales);
                saleTable.setItems(AddProductTable);

                amount();
                discountAmount();


            }






        }

    }

    @FXML
    void cancel(ActionEvent event) {
       saleTable.getItems().clear();
       txtUnits.setText("");
       txtDiscount.setText("");
       cmProduct.setValue("");
       labDiscountSALE.setText("DESCUENTO");
       labAmountSALE.setText("TOTAL");

    }

    @FXML
    void cancelSale(ActionEvent event) {
        txtDni.setText("");
        txtName.setText("");
        labDiscountSALE.setText("Descuento");
        labAmountSALE.setText("TOTAL");
//        labCustomerSALE.setText("Cliente");
    }

    @FXML
    void generateSale(ActionEvent event) throws SQLException, IOException {

        if(labDiscountSALE.getText().equals("Descuento") || labAmountSALE.getText().equals("TOTAL") || labCustomerSALE.getText().isBlank() ){
            System.out.println("Verfica la venta");
        }
        else {

            Sale sales = new Sale("38", "30", Double.parseDouble(labDiscountSALE.getText().replace(',', '.')), Double.parseDouble(labAmountSALE.getText().replace(',', '.')));

            if (sales.GenerateSale()) {
                idSale();
                System.out.println("Venta exitosa");

                for (int i = 0; i < saleTable.getItems().size(); i++) {

                    String codeProduct = saleTable.getItems().get(i).getCodeProduct();
                    int units = saleTable.getItems().get(i).getUnits();
                    double priceSold = saleTable.getItems().get(i).getSubTotal();
                    double discount = saleTable.getItems().get(i).getDiscount();

                    System.out.println(saleTable.getItems().get(i).getCodeProduct());
                    System.out.println(saleTable.getItems().get(i).getUnits());
                    System.out.println(saleTable.getItems().get(i).getSubTotal());
                    System.out.println(saleTable.getItems().get(i).getDiscount());

                    Sale saleDetail = new Sale(String.valueOf(sales.GetIdSale() - 1), codeProduct, units, priceSold, discount);
                    if (saleDetail.GenerateSaleDetail()) {

                        PrinterJob printerJob = PrinterJob.createPrinterJob();
                        if (printerJob != null) {
                            PageLayout pageLayout = printerJob.getPrinter().createPageLayout(Paper.A4, PageOrientation.PORTRAIT, 0, 0, 0, 0);
                            Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Reports/Report.fxml"));
                            boolean success = printerJob.printPage(pageLayout, fxml);
                            if (success) {
                                printerJob.endJob();
                            }
                        }
                        System.out.println("registro de detalle exitoso");

                    } else {

                        System.out.println("Error");
                    }
//
                }

//
            } else {
                System.out.println("Venta no exitosa");

            }

        }




    }

    @FXML
    void removeProduct(ActionEvent event) throws IOException {
//           Sale sales= saleTable.getSelectionModel().getSelectedItem();
//
//            if(sales==null){
//
//
//            }
//            else{
//                saleTable.getItems().remove(sales);
//
//                amount();
//                discountAmount();
//            }
////



//        HostServices hs = getHostServices();
//        hs.showDocument("D:\\sw.pdf");

//        HostServices services = NewSaleController.getInstance().getHostServices();
//        services.showDocument(url);


    }



    @FXML
    void newCustomer(ActionEvent event) throws IOException {

//        drawer.setOnDrawerClosed(e -> drawer.setSidePane());
        if (drawer.isOpening()) {

            drawer.close();


        } else {
            drawer.setSidePane(MenuDrawerADDCustomer);
            drawer.open();
            drawer.toFront();
//                drawer.setMinWidth(300);

        }


    }

    @FXML
    void scanProduct(ActionEvent event) throws IOException {
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        validPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/sfc/appdesktopbodega/Sale/ProductRecognition/ProductRecognition.fxml")));
        Stage stage = new Stage();
        stage.initStyle( StageStyle.UNDECORATED );
//        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.TRANSPARENT);
        Scene scene=new Scene(validPane,858,606);
        stage.setMinHeight(606);
        stage.setMinWidth(858);

        scene.setFill(Color.TRANSPARENT);
        new ZoomIn(validPane).play();


        stage.setScene(scene);
        stage.show();


        stage.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> b, Boolean oldValue, Boolean newValue)
            {
                if(newValue == false) {
                    btnScan.setDisable(true);
                }

            }
        });

        stage.showingProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> b, Boolean oldValue, Boolean newValue)
            {
                if(newValue == false) {
                    btnScan.setDisable(false);
                }

            }
        });


        // Mover scena arrastrando la scena ----------------------
        scene.setOnMousePressed(pressEvent -> {
            scene.setOnMouseDragged(dragEvent -> {
                stage.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
                stage.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
            });
        });
        // Mover scena arrastrando la scena ----------------------






//        MenuDrawerSHOWInventory = FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Sale/InventoryDetail/InventoryDetail.fxml"));
//
////        drawer.setOnDrawerClosed(e -> drawer.setSidePane());
//        if (drawer.isOpening()) {
//
//            drawer.close();
//
//
//        } else {
//            drawer.setSidePane(MenuDrawerSHOWInventory);
//            drawer.open();
//            drawer.toFront();
////                drawer.setMinWidth(300);
//
//        }
    }





    public void showCategoryNameCMBOX(){

        Sale sales=new Sale();
        ObservableList<String> items=sales.GetProductName();
        cmProduct.setItems(items);

    }

    public void amount(){

        DecimalFormat formatter = new DecimalFormat("0.00");
        double amounts = saleTable.getItems().stream().mapToDouble(Sale::getSubTotal).sum();
        labAmountSALE.setText(formatter.format(amounts));
//       amount.setText(String.format("%.2f",amounts));
    }


    public void discountAmount(){

        DecimalFormat formatter = new DecimalFormat("0.00");
        double fulldiscount = saleTable.getItems().stream().mapToDouble(Sale::getDiscount).sum();
        labDiscountSALE.setText(formatter.format(fulldiscount));

//        discountAmount.setText(String.format("%.2f",fulldiscount));

    }


public void showSaleTable(){
    AddProductTable= FXCollections.observableArrayList();
    tbProduct.setCellValueFactory(new PropertyValueFactory<>("product"));
    tbUnits.setCellValueFactory(new PropertyValueFactory<>("units"));
    tbDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));

    tbCodeProduct.setCellValueFactory(new PropertyValueFactory<>("codeProduct"));
    tbPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

    tbSubTotal.setCellValueFactory(new PropertyValueFactory<>("subTotal"));


}

private void dateSale(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        labDateSALE.setText(dtf.format(LocalDateTime.now()));
}

private void idSale()  {
        try {
            labIdSale.setText(String.valueOf(new Sale().GetIdSale()));
        }catch (SQLException e){
            System.out.println(e);
        }
}



    @FXML
    void searchCustomer() {

//
        String Buscar = txtDni.getText();
        try {
            Sale sales = new Sale();
            sales.SearchCustomer(Buscar);
            txtName.setText(sales.getCustomer());



        } catch (SQLException e) {
            e.printStackTrace();
        }
//
//        txtDni.textProperty().addListener((observable, oldValue, newValue) -> {
//            System.out.println("textfield changed from " + oldValue + " to " + newValue);
//            Sale sales = new Sale();
//            try {
//                sales.SearchCustomer(newValue);
//              txtName.setText(sales.getProduct());
//
////                txtName.textProperty().setValue(sales.getCustomer());
//
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//
//        });



    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        validationTextfields();

        //Carga los productos al combobox
        showCategoryNameCMBOX();
        //Muestra los productos agregados a la tabla de venta
        showSaleTable();
        // OBTIENE LA FECHA Y HORA EN EL DETALLE DE VENTA
        dateSale();
        //OBTIENE EL ID DE VENTA
        idSale();
        //BUSCAR EL CLIENTE CUMPLIR EL PROCESO DE VENTA
        searchCustomer();

        // ENLAZAR EL CLIENTE AL DETALLE DE VENTA
        labCustomerSALE.textProperty().bind(txtName.textProperty());
        // ENLAZAR EL ID DE VENTA AL DETALLA DE VENTA
        labIdSALE.textProperty().bind(labIdSale.textProperty());

        //----------------------------

        //        name.textProperty().bind(dni.textProperty());

        //        dni.setOnAction(event -> System.out.println(dni.getText()));






if(labDiscountSALE.getText().isBlank()){
    System.out.println("Es igual");

}
else{
    System.out.println("No  es igual ");
}


    }





}
