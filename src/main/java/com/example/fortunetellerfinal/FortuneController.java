package com.example.fortunetellerfinal;

import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;

public class FortuneController implements Initializable {
    private ArrayList<String> fortunes = new ArrayList<>();
    @FXML
    private ChoiceBox<String> selectRemove;
    @FXML
    private Label fortunePrint;
    @FXML
    private TextField typeFortune;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fortunes.add("A long-lost friend will return with surprising news.");
        fortunes.add("Beware of a decision made in haste—it may echo longer than expected.");
        fortunes.add("A small risk you take soon will yield a big reward.");
        fortunes.add("Your trust may be misplaced—look twice before relying on someone's word.");
        fortunes.add("Love will blossom in the most unexpected of places.");
        fortunes.add("A secret you've kept may come to light—are you ready?");
        fortunes.add("An unexpected opportunity will knock; be ready to answer.");
        fortunes.add("A betrayal may come from someone you once called ally.");
        fortunes.add("Your talents will finally be recognized—success is near.");
        fortunes.add("Delays now may save you from future regret.");

        for (String fortune : fortunes) {
            selectRemove.getItems().add(fortune);
        }
        selectRemove.setValue("Select");
    }
    @FXML
    protected void onReadFortuneButtonClick() {
        if (!selectRemove.getItems().isEmpty()) {
            Random rand = new Random();
            int randomPull = rand.nextInt(fortunes.size());
            fortunePrint.setText(fortunes.get(randomPull));
        }
        else {
            fortunePrint.setText("No fortunes to read here.");
        }
    }
    @FXML
    protected void onRemoveButtonClick() {
        boolean pressedEmpty = false;
        String stringHolder = selectRemove.getValue();
        if (!selectRemove.getItems().isEmpty()) {
            fortunes.remove(stringHolder);
            selectRemove.getItems().remove(stringHolder);
            selectRemove.setValue("Select");
            if (stringHolder == "Select") {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Nothing Selected");
                alert.setContentText("Please select something to remove.");
                alert.showAndWait();
            }
        }
        else {
            pressedEmpty = true;
        }
        if (pressedEmpty) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty List");
            alert.setContentText("There's no fortune to remove.");
            alert.showAndWait();
        }
    }
    @FXML
    protected void onAddButtonClick() {
        String newFortune = typeFortune.getText().trim();
        try {
            if (!newFortune.isEmpty()) {
                fortunes.add(newFortune);
                selectRemove.getItems().add(newFortune);
            }
            else {
                throw new Exception();
            }
        }
        catch(Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty Text Field");
            alert.setContentText("There's no fortune to add.");
            alert.showAndWait();
        }
    }
}