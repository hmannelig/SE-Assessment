import java.io.PrintStream;
import java.util.InputMismatchException;

public class PTTDirectorController {
	
	private InitialController initialController;
	private Model modelobject;
	private View viewObject;

	public PTTDirectorController(InitialController initialController, Model model, PrintStream ps) {
		this.initialController = initialController;
		this.modelobject = model;
		this.viewObject = new View(ps);
		this.showSelectedOptionFromScreen();
	}
	
	public void showSelectedOptionFromScreen() {
		boolean finishAction = false;
		while(!finishAction) {
			int input = this.viewObject.getUserInputInteger(this.modelobject.pttDirectorView());
			try {
				if (input == 1) {
					// Here is where the logic to create the new semester with the models and the database goes
				} else if(input == 2) {
					finishAction = true;
				} else {
					System.out.println("Enter a numerical value within the range");
				}
			} catch (InputMismatchException e) {
				System.out.println("noob");
			}
		}
	}
	
}