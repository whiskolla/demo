package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.SQLException;

public class HelloController {
    @FXML
    private Button btnClose;
    @FXML
    private Button btnDownload;
    @FXML
    private TableView<Items> tvMain;
    @FXML
    protected void onCloseButtonClick() {
        Stage s = (Stage) btnClose.getScene().getWindow();
        s.close();
    }
    @FXML
    protected void onDownloadButtonClick() {
        try {
            DataAccessor da = DataAccessor.getDataAccessor();
            tvMain.getColumns().clear(); //удалим, что было (если было)

            TableColumn<Items, Integer> IdCol = new TableColumn<>("Id");
            TableColumn<Items, String> SNCol = new TableColumn<>("SN");
            TableColumn<Items, String> ItNCol = new TableColumn<>("ItN");

            IdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
            SNCol.setCellValueFactory(new PropertyValueFactory<>("SN"));
            ItNCol.setCellValueFactory(new PropertyValueFactory<>("ItN"));

            tvMain.getColumns().addAll(IdCol, SNCol, ItNCol);
            tvMain.getItems().addAll(da.getItems());
        } catch (SQLException e) {
            System.out.println("error o no");
        };
    }
}