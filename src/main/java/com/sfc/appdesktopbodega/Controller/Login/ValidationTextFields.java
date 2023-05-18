package com.sfc.appdesktopbodega.Controller.Login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.jfoenix.validation.base.ValidatorBase;
import javafx.scene.image.ImageView;

public class ValidationTextFields {

    private String pattern = "^(-([1-9]\\\\d*\\\\.\\\\d*|0\\\\.\\\\d*[1-9]\\\\d*))|0?\\\\.0+|0$";
    private String DOUBLE_POSITIVE = "(\\d+)?\\.(\\d+)";
    private String INT_POSITIVE ="^\\+?(0|[1-9]\\d*)$";
    private String DECIMAL ="\\d+\\.?\\d*";
    public static String patternPassword = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
    public static String patternEmail = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";



    public void emailValidator(JFXTextField email){

        RequiredFieldValidator validator = new RequiredFieldValidator();
        ImageView item = new ImageView("/com/sfc/appdesktopbodega/Images/inputBlank.png");
        validator.setMessage("Completa el campo vacio!");
        item.setFitHeight(15);
        item.setFitWidth(15);
        item.setPreserveRatio(true);
        validator.setIcon(item);

        ValidatorBase emailValidator = new ValidatorBase() {
            @Override
            protected void eval() {
                setMessage("Email no valido");
                if (!email.getText().matches(patternEmail)) {
                    hasErrors.set(true);
                }
                else hasErrors.set(false);
            }
        };
        email.getValidators().addAll(validator, emailValidator);

        email.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                email.validate();
            }
        });




       email.textProperty().addListener((obs, oldText, newText) -> {
            email.validate();
        });

    }

    public void dniValidator(JFXTextField dni){
        RequiredFieldValidator validator = new RequiredFieldValidator();
        ImageView item = new ImageView("/com/sfc/appdesktopbodega/Images/inputBlank.png");
        validator.setMessage("Completa el campo vacio!");
        item.setFitHeight(15);
        item.setFitWidth(15);
        item.setPreserveRatio(true);
        validator.setIcon(item);

        ValidatorBase dniValidator = new ValidatorBase() {
            @Override
            protected void eval() {
                setMessage("Dni no valido");
                if (dni.getText().length()!=8 ||!ValidationTextFields.isNumeric(dni.getText())) {
                    hasErrors.set(true);
                } else hasErrors.set(false);

            }

        };


//        ValidatorBase  correctDni = new ValidatorBase() {
//            @Override
//            protected void eval() {
//                setMessage("Correcto");
//                if (dni.getText().length()==8 && ValidationTextFields.isNumeric(dni.getText())) {
//                    hasErrors.set(true);
//                }
//                else hasErrors.set(false);
//
//            }
//
//        };



        dni.getValidators().addAll(validator, dniValidator);

        dni.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                dni.validate();
            }
        });



        dni.textProperty().addListener((obs, oldText, newText) -> {
            dni.validate();
//            if(newText.length()==8 && ValidationTextFields.isNumeric(newText)){
//                System.out.println("Correcto");
//            }


        });

    }

    public void passwordValidator(JFXPasswordField password){
        RequiredFieldValidator validator = new RequiredFieldValidator();
        ImageView item = new ImageView("/com/sfc/appdesktopbodega/Images/inputBlank.png");
        validator.setMessage("Completa el campo vacio!");
        item.setFitHeight(15);
        item.setFitWidth(15);
        item.setPreserveRatio(true);
        validator.setIcon(item);

        ValidatorBase passwordValidator = new ValidatorBase() {
            @Override
            protected void eval() {
                setMessage("Contraseña no valida");
                if (!password.getText().matches(patternPassword)) {
                    hasErrors.set(true);
                }
                else hasErrors.set(false);
            }
        };

        password.getValidators().addAll(validator, passwordValidator);

        password.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                password.validate();
            }
        });


        password.textProperty().addListener((obs, oldText, newText) -> {
            password.validate();
        });


    }



    public void equalPassword(JFXPasswordField repeatPassword, JFXPasswordField password){
        RequiredFieldValidator validator = new RequiredFieldValidator();
        ImageView item = new ImageView("/com/sfc/appdesktopbodega/Images/inputBlank.png");
        validator.setMessage("Completa el campo vacio!");
        item.setFitHeight(15);
        item.setFitWidth(15);
        item.setPreserveRatio(true);
        validator.setIcon(item);

        ValidatorBase equalPasswordValidator = new ValidatorBase() {
            @Override
            protected void eval() {
                setMessage("Contraseñas no iguales");
                if (!repeatPassword.getText().equals(password.getText())) {
                    hasErrors.set(true);
                }
                else hasErrors.set(false);
            }
        };

        repeatPassword.getValidators().addAll(validator, equalPasswordValidator);
        repeatPassword.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                repeatPassword.validate();
            }
        });

        repeatPassword.textProperty().addListener((obs, oldText, newText) -> {
            repeatPassword.validate();
        });


    }

    public static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

}
