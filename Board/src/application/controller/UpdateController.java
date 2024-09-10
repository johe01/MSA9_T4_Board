package application.controller;

import java.io.IOException;

import application.Main;
import application.DTO.Board;
import application.Service.BoardService;
import application.Service.BoardServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class UpdateController {

	BoardServiceImpl bs = new BoardServiceImpl();
	Board board = bs.select(1);
    @FXML
    private TextArea content;

    @FXML
    private Text regDate;

    @FXML
    private TextField title;

    @FXML
    private Button updBtn;

    @FXML
    private Text updDate;

    @FXML
    private TextField writer;

    
    @FXML
    void updBoard(ActionEvent event) throws IOException {
    	Main.setRoot("UI/List");
    }

}
