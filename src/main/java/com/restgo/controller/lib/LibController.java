package com.restgo.controller.lib;

import com.restgo.App;
import com.restgo.controller.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class LibController {
    @FXML
    public BorderPane mainFrame;
    @FXML
    private Label username;
    @FXML
    private Label panelName;
    @FXML
    private Button headerBorder_addButton;
    @FXML
    private Button headerBorder_logoutButton;
    @FXML
    private Button leftBorder_dashboardButton;
    @FXML
    private Button leftBorder_booksButton;
    @FXML
    private Button leftBorder_myBooksButton;
    @FXML
    private Button leftBorder_borrowedBooksButton;
    @FXML
    private Button leftBorder_readersButton;
    @FXML
    private Button blockedReaders;
    @FXML
    private Button borrowedBooks;

    public static BorderPane pane;

    public void initialize() {
        pane = mainFrame;
        username.setText(LoginController.userName);
        panelName.setText("Empty Panel");
    }

    @FXML
    public void logout(ActionEvent event) throws IOException {
        App.setRoot("login");
    }

    @FXML
    public void setUsersListPane(ActionEvent event) throws IOException {
        panelName.setText("Students");
        mainFrame.setCenter(App.loadFXML("admin","students"));
    }

    @FXML
    public void setBooksListPane(ActionEvent event) throws IOException {
        panelName.setText("Books");
        mainFrame.setCenter(App.loadFXML("admin","books"));
    }

    @FXML
    public void setBlockedReadersListPane() throws IOException {
        panelName.setText("Blocked Users");
        mainFrame.setCenter(App.loadFXML("lib","blockedusers"));
    }

    @FXML
    public void setBorrowedBooksListPane(ActionEvent event) throws IOException {
        panelName.setText("Books");
        mainFrame.setCenter(App.loadFXML("lib","borrowedbooks"));
    }

    public static void updateUI(String fxml) throws IOException {
        pane.setCenter(App.loadFXML("admin",fxml));
    }

    public static void updateBlockedUI(String fxml) throws IOException {
        pane.setCenter(App.loadFXML("lib",fxml));
    }
}
