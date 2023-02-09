import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class FXIncomeController {
	
	private ArrayList<MinerThread> minerList = new ArrayList<MinerThread>();

	@FXML 
	private Label text;  //THIS IS CAUSING THE ISSUE 
	
	
	
	public void startTextDump(ActionEvent e) {
		text.setText(null); 
	}
	
	
	public void addMiner()
	
	
	
	/* 
	private Circle myCirclSe; 
	private double x; 
	private double y; 
	
	
	public void up(ActionEvent e) {
		System.out.println("UP"); 
		myCircle.setCenterY(y-=10);
	}
	public void down(ActionEvent e) {
		System.out.println("DOWN"); 
		myCircle.setCenterY(y+=10);
	}
	public void left(ActionEvent e) {
		System.out.println("LEFT"); 
		myCircle.setCenterX(x-=10);
	}
	public void right(ActionEvent e) {
		System.out.println("RIGHT"); 
		myCircle.setCenterX(x+=10);
	}
	
	*/
}