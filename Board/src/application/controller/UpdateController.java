package application.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

	Board board = null;
	private BoardServiceImpl bs = new BoardServiceImpl();
	
	private int no;
	
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
    
    public void passData(int no) {
		this.no = no;
	}
    
    @FXML
    public void initialize() {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd일 (E) HH:mm:ss");
    	// board = bs.select(no);
    	board = bs.select(1);
    	title.setText(board.getTitle());
    	content.setText(board.getContent());
    	writer.setText(board.getWriter());
    	updDate.setText(sdf.format(board.getUpdDate()));
    	regDate.setText(sdf.format(board.getRegDate()));
    }
    
    @FXML
    void updBoard(ActionEvent event) throws IOException {
    	Calendar cal = Calendar.getInstance();
    	board.setTitle(title.getText());
    	board.setContent(content.getText());
    	board.setWriter(writer.getText());
    	board.setUpdDate(cal.getTime());
    	bs.update(board);
    	Main.setRoot("UI/List");
    }
    
}
