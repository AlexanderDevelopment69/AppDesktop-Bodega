package com.sfc.appdesktopbodega.Controller.Configuration;

import com.jfoenix.controls.JFXTextField;

import com.sfc.appdesktopbodega.ConnectionMySQL.BackupMYSQL;
import com.sfc.appdesktopbodega.Model.Configuration;
import io.github.palexdev.materialfx.controls.MFXProgressBar;
import io.github.palexdev.materialfx.controls.MFXScrollPane;
import io.github.palexdev.materialfx.controls.MFXToggleButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConfigurationController implements Initializable {

    @FXML
    private AnchorPane stackDashboard;

    @FXML
    private MFXScrollPane scrollPaneV;
    @FXML
    private JFXTextField attemps;
    @FXML
    private JFXTextField addAttemps;
    @FXML
    private JFXTextField addActivityTime;
    @FXML
    private JFXTextField activityTime;
    @FXML
    private Label progressLabel;

    @FXML
    private MFXProgressBar determinate;

    @FXML
    private MFXToggleButton toggleCaptcha;

    @FXML
    private MFXToggleButton toggleAutentification;

    @FXML
    private MFXToggleButton toggleBackup;

    @FXML
    private MFXProgressBar barNivelSecurity;
    @FXML
    private Label labelSecurity;
    double sNoSeguro = 0.0;
    double sBajo = 0.20;
    double sMedio = 0.50;
    double sAlto = 1.0;


    @FXML
    void togglebCatpcha() {

//        if (toggleCaptcha.isSelected()) {
//            Animation a1 = AnimationUtils.TimelineBuilder.build()
//                    .add(
//                            AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.20, MFXAnimationFactory.getInterpolatorV1())).getAnimation();
//
//
//            a1.play();
//            barNivelSecurity.getRanges1().add(NumberRange.of(0.0, 0.20));
//            labelSecurity.setText("Poco seguro");
//            labelSecurity.setStyle("-fx-text-fill: red");
//
//        } else {
//
//            if (!toggleCaptcha.isSelected()) {
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(
//                                AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.0, MFXAnimationFactory.getInterpolatorV2()))
//                        .getAnimation();
//                a1.play();
//
//                barNivelSecurity.getRanges1().add(NumberRange.of(0.0, 0.0));
//                labelSecurity.setText("Nada seguro");
//                labelSecurity.setStyle("-fx-text-fill: red");
//
//
//            }
//
//
//        }
//
//        //validacion
//        if (toggleCaptcha.isSelected() && toggleAutentification.isSelected() && toggleBackup.isSelected()) {
//            Animation a1 = AnimationUtils.TimelineBuilder.build()
//                    .add(
//                            AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 1.0, MFXAnimationFactory.getInterpolatorV1())
//
//                    )
//                    .getAnimation();
//            a1.play();
//
//            barNivelSecurity.getRanges3().add(NumberRange.of(0.0, 1.0));
//            labelSecurity.setText("Seguro");
//            labelSecurity.setStyle("-fx-text-fill: green");
//
//
//        } else {
//
//            if (!toggleCaptcha.isSelected() && toggleAutentification.isSelected() && toggleBackup.isSelected()) {
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(
//                                AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.8, MFXAnimationFactory.getInterpolatorV2())
//
//                        )
//                        .getAnimation();
//                a1.play();
//
//                barNivelSecurity.getRanges2().add(NumberRange.of(1.0, 0.8));
//                labelSecurity.setText("Medio Seguro");
//                labelSecurity.setStyle("-fx-text-fill: Blue");
//
//
//            }
//            if (toggleCaptcha.isSelected() && !toggleAutentification.isSelected() && toggleBackup.isSelected()) {
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(
//                                AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.7, MFXAnimationFactory.getInterpolatorV2())
//
//                        )
//                        .getAnimation();
//                a1.play();
//
//                barNivelSecurity.getRanges2().add(NumberRange.of(1.0, 0.7));
//                labelSecurity.setText("Medio Seguro");
//                labelSecurity.setStyle("-fx-text-fill: Blue");
//
//
//            }
//
//            if (toggleCaptcha.isSelected() && toggleAutentification.isSelected() && !toggleBackup.isSelected()) {
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(
//                                AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.5, MFXAnimationFactory.getInterpolatorV2())
//
//                        )
//                        .getAnimation();
//                a1.play();
//
//                barNivelSecurity.getRanges2().add(NumberRange.of(1.0, 0.5));
//                labelSecurity.setText("Medio Seguro");
//                labelSecurity.setStyle("-fx-text-fill: Blue");
//
//
//            }
//
//            if (toggleCaptcha.isSelected() && !toggleAutentification.isSelected() && !toggleBackup.isSelected()) {
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(
//                                AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.2, MFXAnimationFactory.getInterpolatorV2())
//
//                        )
//                        .getAnimation();
//                a1.play();
//
//                barNivelSecurity.getRanges1().add(NumberRange.of(1.0, 0.2));
//                labelSecurity.setText("Poco Seguro");
//                labelSecurity.setStyle("-fx-text-fill: Red");
//
//
//            }
//            if (!toggleCaptcha.isSelected() && toggleAutentification.isSelected() && !toggleBackup.isSelected()) {
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(
//                                AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.3, MFXAnimationFactory.getInterpolatorV2())
//
//                        )
//                        .getAnimation();
//                a1.play();
//
//                barNivelSecurity.getRanges1().add(NumberRange.of(1.0, 0.3));
//                labelSecurity.setText("Poco Seguro");
//                labelSecurity.setStyle("-fx-text-fill: Red");
//
//
//            }
//            if (!toggleCaptcha.isSelected() && !toggleAutentification.isSelected() && toggleBackup.isSelected()) {
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(
//                                AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.5, MFXAnimationFactory.getInterpolatorV2())
//
//                        )
//                        .getAnimation();
//                a1.play();
//
//                barNivelSecurity.getRanges2().add(NumberRange.of(1.0, 0.5));
//                labelSecurity.setText("Medio Seguro");
//                labelSecurity.setStyle("-fx-text-fill: Blue");
//
//
//            }
//
//            if (toggleCaptcha.isSelected() && toggleAutentification.isSelected()) {
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(
//                                AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.5, MFXAnimationFactory.getInterpolatorV1())
//
//                        )
//                        .getAnimation();
//                a1.play();
//
//                barNivelSecurity.getRanges2().add(NumberRange.of(0.0, 0.5));
//                labelSecurity.setText("Medio Seguro");
//                labelSecurity.setStyle("-fx-text-fill: Blue");
//
//
//            } else {
//
//                if (toggleCaptcha.isSelected() && !toggleAutentification.isSelected()) {
//                    Animation a1 = AnimationUtils.TimelineBuilder.build()
//                            .add(
//                                    AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.2, MFXAnimationFactory.getInterpolatorV2())
//
//                            )
//                            .getAnimation();
//                    a1.play();
//
//                    barNivelSecurity.getRanges1().add(NumberRange.of(0.5, 0.2));
//                    labelSecurity.setText("Poco Seguro");
//                    labelSecurity.setStyle("-fx-text-fill: Red");
//
//
//                }
//                if (!toggleCaptcha.isSelected() && toggleAutentification.isSelected()) {
//                    Animation a1 = AnimationUtils.TimelineBuilder.build()
//                            .add(
//                                    AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.3, MFXAnimationFactory.getInterpolatorV2())
//
//                            )
//                            .getAnimation();
//                    a1.play();
//
//                    barNivelSecurity.getRanges1().add(NumberRange.of(0.5, 0.3));
//                    labelSecurity.setText("Poco Seguro");
//                    labelSecurity.setStyle("-fx-text-fill: Red");
//
//
//                }
//
//            }
//
//        }

    }


    @FXML
    void togglebAutentification() {

//
//        if (toggleAutentification.isSelected()) {
//            Animation a1 = AnimationUtils.TimelineBuilder.build()
//                    .add(AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.3, MFXAnimationFactory.getInterpolatorV1())).getAnimation();
//            a1.play();
//            barNivelSecurity.getRanges1().add(NumberRange.of(0.0, 0.3));
//            labelSecurity.setText("Poco Seguro");
//            labelSecurity.setStyle(" -fx-text-fill: red");
//
//        } else {
//
//            if (!toggleAutentification.isSelected()) {
//
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(
//                                AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.0, MFXAnimationFactory.getInterpolatorV2())).getAnimation();
//                a1.play();
//
//                barNivelSecurity.getRanges1().add(NumberRange.of(0.3, 0.0));
//                labelSecurity.setText("Nada Seguro");
//                labelSecurity.setStyle(" -fx-text-fill: red");
//
//            }
//        }
//        //validacion
//        if (toggleCaptcha.isSelected() && toggleAutentification.isSelected() && toggleBackup.isSelected()) {
//            Animation a1 = AnimationUtils.TimelineBuilder.build()
//                    .add(
//                            AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 1.0, MFXAnimationFactory.getInterpolatorV1())
//
//                    )
//                    .getAnimation();
//            a1.play();
//
//            barNivelSecurity.getRanges3().add(NumberRange.of(0.0, 1.0));
//            labelSecurity.setText("Seguro");
//            labelSecurity.setStyle("-fx-text-fill: green");
//
//
//        } else {
//
//            if (!toggleCaptcha.isSelected() && toggleAutentification.isSelected() && toggleBackup.isSelected()) {
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(
//                                AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.8, MFXAnimationFactory.getInterpolatorV2())
//
//                        )
//                        .getAnimation();
//                a1.play();
//
//                barNivelSecurity.getRanges2().add(NumberRange.of(1.0, 0.8));
//                labelSecurity.setText("Medio Seguro");
//                labelSecurity.setStyle("-fx-text-fill: Blue");
//
//
//            }
//            if (toggleCaptcha.isSelected() && !toggleAutentification.isSelected() && toggleBackup.isSelected()) {
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(
//                                AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.7, MFXAnimationFactory.getInterpolatorV2())
//
//                        )
//                        .getAnimation();
//                a1.play();
//
//                barNivelSecurity.getRanges2().add(NumberRange.of(1.0, 0.7));
//                labelSecurity.setText("Medio Seguro");
//                labelSecurity.setStyle("-fx-text-fill: Blue");
//
//
//            }
//
//            if (toggleCaptcha.isSelected() && toggleAutentification.isSelected() && !toggleBackup.isSelected()) {
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(
//                                AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.5, MFXAnimationFactory.getInterpolatorV2())
//
//                        )
//                        .getAnimation();
//                a1.play();
//
//                barNivelSecurity.getRanges2().add(NumberRange.of(1.0, 0.5));
//                labelSecurity.setText("Medio Seguro");
//                labelSecurity.setStyle("-fx-text-fill: Blue");
//
//
//            }
//
//            if (toggleCaptcha.isSelected() && !toggleAutentification.isSelected() && !toggleBackup.isSelected()) {
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(
//                                AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.2, MFXAnimationFactory.getInterpolatorV2())
//
//                        )
//                        .getAnimation();
//                a1.play();
//
//                barNivelSecurity.getRanges1().add(NumberRange.of(1.0, 0.2));
//                labelSecurity.setText("Poco Seguro");
//                labelSecurity.setStyle("-fx-text-fill: Red");
//
//
//            }
//            if (!toggleCaptcha.isSelected() && toggleAutentification.isSelected() && !toggleBackup.isSelected()) {
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(
//                                AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.3, MFXAnimationFactory.getInterpolatorV2())
//
//                        )
//                        .getAnimation();
//                a1.play();
//
//                barNivelSecurity.getRanges1().add(NumberRange.of(1.0, 0.3));
//                labelSecurity.setText("Poco Seguro");
//                labelSecurity.setStyle("-fx-text-fill: Red");
//
//
//            }
//            if (!toggleCaptcha.isSelected() && !toggleAutentification.isSelected() && toggleBackup.isSelected()) {
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(
//                                AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.5, MFXAnimationFactory.getInterpolatorV2())
//
//                        )
//                        .getAnimation();
//                a1.play();
//
//                barNivelSecurity.getRanges2().add(NumberRange.of(1.0, 0.5));
//                labelSecurity.setText("Medio Seguro");
//                labelSecurity.setStyle("-fx-text-fill: Blue");
//
//
//            }
//
//            if (toggleCaptcha.isSelected() && toggleAutentification.isSelected()) {
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(
//                                AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.5, MFXAnimationFactory.getInterpolatorV1())
//
//                        )
//                        .getAnimation();
//                a1.play();
//
//                barNivelSecurity.getRanges2().add(NumberRange.of(0.0, 0.5));
//                labelSecurity.setText("Medio Seguro");
//                labelSecurity.setStyle("-fx-text-fill: Blue");
//
//
//            } else {
//
//                if (toggleCaptcha.isSelected() && !toggleAutentification.isSelected()) {
//                    Animation a1 = AnimationUtils.TimelineBuilder.build()
//                            .add(
//                                    AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.2, MFXAnimationFactory.getInterpolatorV2())
//
//                            )
//                            .getAnimation();
//                    a1.play();
//
//                    barNivelSecurity.getRanges1().add(NumberRange.of(0.5, 0.2));
//                    labelSecurity.setText("Poco Seguro");
//                    labelSecurity.setStyle("-fx-text-fill: Red");
//
//
//                }
//                if (!toggleCaptcha.isSelected() && toggleAutentification.isSelected()) {
//                    Animation a1 = AnimationUtils.TimelineBuilder.build()
//                            .add(
//                                    AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.3, MFXAnimationFactory.getInterpolatorV2())
//
//                            )
//                            .getAnimation();
//                    a1.play();
//
//                    barNivelSecurity.getRanges1().add(NumberRange.of(0.5, 0.3));
//                    labelSecurity.setText("Poco Seguro");
//                    labelSecurity.setStyle("-fx-text-fill: Red");
//
//
//                }
//
//            }
//        }


    }


    @FXML
    void togglebBackup() {

//        if (toggleBackup.isSelected()) {
//            Animation a1 = AnimationUtils.TimelineBuilder.build()
//                    .add(AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.5, MFXAnimationFactory.getInterpolatorV1())).getAnimation();
//            a1.play();
//            barNivelSecurity.getRanges2().add(NumberRange.of(0.0, 0.5));
//            labelSecurity.setText("Medio Seguro");
//            labelSecurity.setStyle("-fx-text-fill: blue");
//
//        } else {
//            if (!toggleBackup.isSelected()) {
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.0, MFXAnimationFactory.getInterpolatorV2())).getAnimation();
//                a1.play();
//                barNivelSecurity.getRanges1().add(NumberRange.of(0.5, 0.0));
//                labelSecurity.setText("Nada Seguro");
//                labelSecurity.setStyle("-fx-text-fill: RED");
//
//            }
//
//        }
//
//        //validacion
//        if (toggleCaptcha.isSelected() && toggleAutentification.isSelected() && toggleBackup.isSelected()) {
//            Animation a1 = AnimationUtils.TimelineBuilder.build()
//                    .add(
//                            AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 1.0, MFXAnimationFactory.getInterpolatorV1())
//
//                    )
//                    .getAnimation();
//            a1.play();
//
//            barNivelSecurity.getRanges3().add(NumberRange.of(0.0, 1.0));
//            labelSecurity.setText("Seguro");
//            labelSecurity.setStyle("-fx-text-fill: green");
//
//
//        } else {
//
//            if (!toggleCaptcha.isSelected() && toggleAutentification.isSelected() && toggleBackup.isSelected()) {
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(
//                                AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.8, MFXAnimationFactory.getInterpolatorV2())
//
//                        )
//                        .getAnimation();
//                a1.play();
//
//                barNivelSecurity.getRanges2().add(NumberRange.of(1.0, 0.8));
//                labelSecurity.setText("Medio Seguro");
//                labelSecurity.setStyle("-fx-text-fill: Blue");
//
//
//            }
//            if (toggleCaptcha.isSelected() && !toggleAutentification.isSelected() && toggleBackup.isSelected()) {
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(
//                                AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.7, MFXAnimationFactory.getInterpolatorV2())
//
//                        )
//                        .getAnimation();
//                a1.play();
//
//                barNivelSecurity.getRanges2().add(NumberRange.of(1.0, 0.7));
//                labelSecurity.setText("Medio Seguro");
//                labelSecurity.setStyle("-fx-text-fill: Blue");
//
//
//            }
//
//            if (toggleCaptcha.isSelected() && toggleAutentification.isSelected() && !toggleBackup.isSelected()) {
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(
//                                AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.5, MFXAnimationFactory.getInterpolatorV2())
//
//                        )
//                        .getAnimation();
//                a1.play();
//
//                barNivelSecurity.getRanges2().add(NumberRange.of(1.0, 0.5));
//                labelSecurity.setText("Medio Seguro");
//                labelSecurity.setStyle("-fx-text-fill: Blue");
//
//
//            }
//
//            if (toggleCaptcha.isSelected() && !toggleAutentification.isSelected() && !toggleBackup.isSelected()) {
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(
//                                AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.2, MFXAnimationFactory.getInterpolatorV2())
//
//                        )
//                        .getAnimation();
//                a1.play();
//
//                barNivelSecurity.getRanges1().add(NumberRange.of(1.0, 0.2));
//                labelSecurity.setText("Poco Seguro");
//                labelSecurity.setStyle("-fx-text-fill: Red");
//
//
//            }
//            if (!toggleCaptcha.isSelected() && toggleAutentification.isSelected() && !toggleBackup.isSelected()) {
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(
//                                AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.3, MFXAnimationFactory.getInterpolatorV2())
//
//                        )
//                        .getAnimation();
//                a1.play();
//
//                barNivelSecurity.getRanges1().add(NumberRange.of(1.0, 0.3));
//                labelSecurity.setText("Poco Seguro");
//                labelSecurity.setStyle("-fx-text-fill: Red");
//
//
//            }
//            if (!toggleCaptcha.isSelected() && !toggleAutentification.isSelected() && toggleBackup.isSelected()) {
//                Animation a1 = AnimationUtils.TimelineBuilder.build()
//                        .add(
//                                AnimationUtils.KeyFrames.of(1000, barNivelSecurity.progressProperty(), 0.5, MFXAnimationFactory.getInterpolatorV2())
//
//                        )
//                        .getAnimation();
//                a1.play();
//
//                barNivelSecurity.getRanges2().add(NumberRange.of(1.0, 0.5));
//                labelSecurity.setText("Medio Seguro");
//                labelSecurity.setStyle("-fx-text-fill: Blue");
//
//
//            }
//
//
//        }


    }

    public void barraAnimacion() {
//        progressLabel.textProperty().bind(Bindings.createStringBinding(
//                () -> new Formatter().format("%.2f", determinate.getProgress()).toString().replace(",", "."),
//                determinate.progressProperty()
//        ));
//        progressLabel.textFillProperty().bind(Bindings.createObjectBinding(
//                () -> progressLabel.getText().equals("1.00") ? Color.web("#85CB33") : Color.BLACK,
//                progressLabel.textProperty()
//        ));
//
//        Animation a1 = AnimationUtils.TimelineBuilder.build()
//                .add(
//                        AnimationUtils.KeyFrames.of(2000, determinate.progressProperty(), 0.3, MFXAnimationFactory.getInterpolatorV1()),
//                        AnimationUtils.KeyFrames.of(4000, determinate.progressProperty(), 0.6, MFXAnimationFactory.getInterpolatorV1()),
//                        AnimationUtils.KeyFrames.of(6000, determinate.progressProperty(), 1.0, MFXAnimationFactory.getInterpolatorV1())
//                )
//                .getAnimation();
//
//        Animation a2 = AnimationUtils.TimelineBuilder.build()
//                .add(
//                        AnimationUtils.KeyFrames.of(1000, determinate.progressProperty(), 0, MFXAnimationFactory.getInterpolatorV2())
//                )
//                .getAnimation();
//
//        a1.setOnFinished(end -> AnimationUtils.PauseBuilder.build()
//                .setDuration(Duration.seconds(1))
//                .setOnFinished(event -> a2.playFromStart())
//                .getAnimation()
//                .play()
//        );
//        a2.setOnFinished(end -> AnimationUtils.PauseBuilder.build()
//                .setDuration(Duration.seconds(1))
//                .setOnFinished(event -> a1.playFromStart())
//                .getAnimation()
//                .play()
//        );
//
//        a1.play();
//
//        determinate.getRanges1().add(NumberRange.of(0.0, 0.30));
//        determinate.getRanges2().add(NumberRange.of(0.31, 0.60));
//        determinate.getRanges3().add(NumberRange.of(0.61, 1.0));


    }

    //Metodo para obtener los datos de parametros de configuracion
    public void DataConfiguration()  {

        try {

            Configuration configuration = new Configuration();
            configuration.GetDataConfiguration(1);{
                attemps.setText(configuration.getConf_valor());
            }
            configuration.GetDataConfiguration(2);{
                activityTime.setText(configuration.getConf_valor());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void saveControls(ActionEvent event) throws SQLException {
            Configuration configuration=new Configuration();
//            if(addAttemps.getText().isBlank()){
//                configuration.UpdateConfiguration(addActivityTime.getText(),3);
//            }
//            if(addActivityTime.getText().isBlank()){
//                configuration.UpdateConfiguration(addAttemps.getText(),2);
//            }
            if(addAttemps.getText().isBlank()&& addActivityTime.getText().isBlank()){

            }

            if(!addAttemps.getText().isBlank()&& addActivityTime.getText().isBlank()){
                configuration.UpdateConfiguration(addAttemps.getText(),1);
                addAttemps.setText("");
            }
            if(addAttemps.getText().isBlank() && !addActivityTime.getText().isBlank()){
                configuration.UpdateConfiguration(addActivityTime.getText(),2);
                addActivityTime.setText("");
            }
            if(!addAttemps.getText().isBlank()  && !addActivityTime.getText().isBlank()){
                configuration.UpdateConfiguration(addAttemps.getText(),1);
                configuration.UpdateConfiguration(addActivityTime.getText(),2);
                addAttemps.setText("");
                addActivityTime.setText("");
            }



//            configuration.UpdateConfiguration(addAttemps.getText(),2);
//            configuration.UpdateConfiguration(addActivityTime.getText(),3);
            DataConfiguration();

    }

    @FXML
    void saveBackup(ActionEvent event)  {
        BackupMYSQL backupMYSQL=new BackupMYSQL();
        new Thread(backupMYSQL::backup).start();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        barraAnimacion();
        //
//        DataConfiguration();

//        new Thread(this::DataConfiguration).start();
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
               DataConfiguration();
            }
// do your GUI stuff here
        });


    }
}