package com.sfc.appdesktopbodega.Controller.MainView;

import io.github.palexdev.materialfx.controls.MFXTreeItem;
import io.github.palexdev.materialfx.controls.MFXTreeView;
import io.github.palexdev.materialfx.font.MFXFontIcon;
import io.github.palexdev.materialfx.utils.ColorUtils;
import io.github.palexdev.materialfx.utils.ScrollUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private MFXTreeView<HBox> treeViewHide;




    public MFXTreeItem<HBox> createNodeRoot() {
        MFXTreeItem<HBox> root = new MFXTreeItem<>(createBox("mfx-google", "Google Root"));

        MFXTreeItem<HBox> item1 = new MFXTreeItem<>(createBox("mfx-google", "ITEM1"));
        item1.getItems().addAll(List.of(
                        new MFXTreeItem<>(createBox("mfx-google", "ITEM1-Sub1")),
                        new MFXTreeItem<>(createBox("mfx-google", "ITEM1-Sub2"))
                )
        );

        MFXTreeItem<HBox> item2 = new MFXTreeItem<>(createBox("mfx-calendar-black", "ITEM2"));
        item2.getItems().addAll(List.of(
                        new MFXTreeItem<>(createBox("mfx-calendar-black", "ITEM2-Sub1")),
                        new MFXTreeItem<>(createBox("mfx-calendar-black", "ITEM2-Sub2")),
                        new MFXTreeItem<>(createBox("mfx-calendar-black", "ITEM2-Sub3")),
                        new MFXTreeItem<>(createBox("mfx-calendar-black", "ITEM2-Sub4"))
                )
        );

        MFXTreeItem<HBox> item3 = new MFXTreeItem<>(createBox("mfx-exclamation-triangle", "ITEM3"));

        MFXTreeItem<HBox> item4 = new MFXTreeItem<>(createBox("mfx-circle", "ITEM4"));
        item4.getItems().add(
                new MFXTreeItem<>(createBox("mfx-info-circle", "ITEM4-Sub1"))
        );

        MFXTreeItem<HBox> item5 = new MFXTreeItem<>(createBox("mfx-circle", "ITEM5"));
        item5.getItems().addAll(List.of(
                        new MFXTreeItem<>(createBox("mfx-circle", "ITEM5-Sub1")),
                        new MFXTreeItem<>(createBox("mfx-circle", "ITEM5-Sub2")),
                        new MFXTreeItem<>(createBox("mfx-circle", "ITEM5-Sub3"))
                )
        );

        root.getItems().addAll(List.of(item1, item2, item3, item4, item5));
        return root;
    }
    private HBox createBox(String iconDescription, String text) {
        MFXFontIcon icon = new MFXFontIcon(iconDescription, ColorUtils.getRandomColor());
        HBox hBox = new HBox(10, icon, new Label(text));
        hBox.setAlignment(Pos.CENTER_LEFT);
        return hBox;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        treeViewHide.setRoot(createNodeRoot());
        treeViewHide.setShowRoot(false);
        ScrollUtils.addSmoothScrolling(treeViewHide);



    }


}
