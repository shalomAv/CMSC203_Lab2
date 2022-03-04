import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button b1,b2,b3,b4,b5,bf;
	Label l1;
	TextField t1;
	//  declare two HBoxes
	HBox H1,H2;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager manager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	public FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		b1=new Button("Hello");
		b2=new Button("Howdy");
		b3=new Button("Chinese");
		b4=new Button("Clear");
		bf=new Button("Bonjour");
		b5=new Button("Exit");
		l1=new Label("Feedback");
		t1=new TextField("TextField");
		//  instantiate the HBoxes
		H1=new HBox();
		H2=new HBox();
		//student Task #4:
		//  instantiate the DataManager instance
		 manager =new DataManager();
		//  set margins and set alignment of the components
		HBox.setMargin(b1, new Insets(30,0,0,48));
		HBox.setMargin(b2, new Insets(30,0,0,48));
		HBox.setMargin(b3, new Insets(30,0,0,48));
		HBox.setMargin(b4, new Insets(30,0,0,48));
		HBox.setMargin(b5, new Insets(30,0,0,48));
		HBox.setMargin(bf, new Insets(30,0,0,48));
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		H1.getChildren().addAll(t1,l1);
		//  add the buttons to the other HBox
		 H2.getChildren().addAll(b1,b2,b3,bf,b4,b5);
		//  add the HBoxes to this FXMainPanel (a VBox)
		 getChildren().addAll(H1,H2); 
		    b1.setOnAction(new  ButtonHandler());
			b2.setOnAction(new  ButtonHandler());
			b3.setOnAction(new  ButtonHandler());
			b4.setOnAction(new  ButtonHandler());
			b5.setOnAction(new  ButtonHandler());
			bf.setOnAction(new  ButtonHandler());
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {
		
		public void handle (ActionEvent e) {
			if(e.getTarget().equals(b1)) {
				t1.setText(manager.getHello());
			}
			else if (e.getTarget().equals(b2)) {
				t1.setText(manager.getHowdy());
			}
			else if (e.getTarget().equals(b3)) {
				t1.setText(manager.getChinese());
			}
			else if (e.getTarget().equals(bf)) {
				t1.setText(manager.getFrench());
			}
			else if (e.getTarget().equals(b4)) {
				t1.setText("");
			}
			else if (e.getTarget().equals(b5)) {
				Platform.exit();
				System.exit(0);
			}
			
		}
	
}

}
	