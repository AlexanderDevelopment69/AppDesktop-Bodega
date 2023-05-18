package com.sfc.appdesktopbodega.Controller.Sale.ProductRecognition;

import animatefx.animation.ZoomIn;
import com.jfoenix.controls.JFXButton;
import io.github.palexdev.materialfx.controls.MFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductRecognitionController implements Initializable {
    @FXML
    private AnchorPane root;
    @FXML
    private MFXToggleButton toogleButton;
    @FXML
    private JFXButton btnClose;

    @FXML
    private StackPane imgStack;
    @FXML
    private ImageView currentFrame;
    @FXML
    private StackPane rootElement;
    @FXML
    private JFXButton start_btn;

    Stage stage =null;
//
//    private Timer timer;
//    ImageView frameView;
//    private VideoCapture capture = new VideoCapture();
//
//    //    VideoCapture capture = new VideoCapture("http://192.168.88.14:4747/video", Videoio.CAP_FFMPEG);
//    static {
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//    }




    @FXML
    void startCamera(ActionEvent event) {
//
////
//        // check: the main class is accessible?
//        if (this.rootElement != null) {
//            // get the ImageView object for showing the video stream
//            final ImageView frameView = currentFrame;
//            frameView.fitWidthProperty().bind(imgStack.widthProperty());
//            frameView.fitHeightProperty().bind(imgStack.heightProperty());
//            // check if the capture stream is opened
//            if (!this.capture.isOpened()) {
//                // start the video capture
//                this.capture.open(0, Videoio.CAP_DSHOW);
//                // grab a frame every 33 ms (30 frames/sec)
//                TimerTask frameGrabber = new TimerTask() {
//                    @Override
//                    public void run() {
//                        Image tmp = grabFrame();
//
//                        Platform.runLater(new Runnable() {
//                            @Override
//                            public void run() {
//                                frameView.setImage(tmp);
//                            }
//                        });
//
//                    }
//                };
//                this.timer = new Timer();
//                //set the timer scheduling, this allow you to perform frameGrabber every 33ms;
//                this.timer.schedule(frameGrabber, 0,
//                        33);
//                this.start_btn.setText("Stop Camera");
//            } else {
//                this.start_btn.setText("Start Camera");
//                // stop the timer
//                if (this.timer != null) {
//                    this.timer.cancel();
//                    this.timer = null;
//                }
//                // release the camera
//                this.capture.release();
//                // clear the image container
//                frameView.setImage(null);
//            }
//        }
    }


    @FXML
    void action(MouseEvent event) {

        if (toogleButton.isSelected()){
            System.out.println("prendido");
            currentFrame.setVisible(true);

        }else{
            System.out.println("apagado");
            currentFrame.setVisible(false);
        }


//        if (toogleButton.isSelected()) {
//
//            frameView = currentFrame;
//            // get the ImageView object for showing the video stream
//
//            frameView.fitWidthProperty().bind(imgStack.widthProperty());
//            frameView.fitHeightProperty().bind(imgStack.heightProperty());
//            // check if the capture stream is opened
//            if (!this.capture.isOpened()) {
//                // start the video capture
//                this.capture.open(0, Videoio.CAP_DSHOW);
//                // grab a frame every 33 ms (30 frames/sec)
//                TimerTask frameGrabber = new TimerTask() {
//                    @Override
//                    public void run() {
//                        Image tmp = grabFrame();
//
//                        Platform.runLater(new Runnable() {
//                            @Override
//                            public void run() {
//                                frameView.setImage(tmp);
//                            }
//                        });
//
//                    }
//                };
//                this.timer = new Timer();
//                //set the timer scheduling, this allow you to perform frameGrabber every 33ms;
//                this.timer.schedule(frameGrabber, 0,
//                        33);
//                this.toogleButton.setText("Detener Camara");
//
//
//            }
//        } else {
//
//
//            this.toogleButton.setText("Encender Camara");
//            // stop the timer
//            if (this.timer != null) {
//                this.timer.cancel();
//                this.timer = null;
//            }
//            // release the camera
//            this.capture.release();
//            // clear the image container
//            frameView.setImage(null);
//
//
//        }
//














    }

    @FXML
    void close(ActionEvent event) {
        Stage myStage = (Stage) this.btnClose.getScene().getWindow();

        myStage.close();
    }
    @FXML
    void maximize(ActionEvent event) {
        stage = (Stage) root.getScene().getWindow();
//        new FadeIn(root).play();
        new ZoomIn(root).play();

        if(stage.isMaximized()){
            stage.setMaximized(false);

        }else{

            stage.setMaximized(true);

        }

    }

    @FXML
    void go(ActionEvent event) {

    }


//    private Image grabFrame() {
//        //init
//        Image imageToShow = null;
//        Mat frame = new Mat();
//        // check if the capture is open
//        if (this.capture.isOpened()) {
//            try {
//                // read the current frame
//                this.capture.read(frame);
//                // if the frame is not empty, process it
//                if (!frame.empty()) {
//                    // convert the image to gray scale
////                    Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2GRAY);
//                    // convert the Mat object (OpenCV) to Image (JavaFX)
//                    imageToShow = mat2Image(frame);
//                }
//            } catch (Exception e) {
//                // log the error
//                System.err.println("ERROR: " + e.getMessage());
//            }
//        }
//        return imageToShow;
//    }
//
//    private Image mat2Image(Mat frame) {
//
//        // create a temporary buffer
//        MatOfByte buffer = new MatOfByte();
//        // encode the frame in the buffer
//        Imgcodecs.imencode(".png", frame, buffer);
//
//        // build and return an Image created from the image encoded in the buffer
//        return new Image(new ByteArrayInputStream(buffer.toArray()));
//    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {




    }
}
