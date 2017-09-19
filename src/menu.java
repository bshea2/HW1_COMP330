import java.util.Scanner;

public class menu {
	
	readFiles newFiles = new readFiles();
	
	boolean exit;
	
	public static void main(String[] args) {
		menu menu = new menu();
		menu.runMenu();
	}
	
	public void runMenu() {
		welcome();
		while(!exit) {
			printMenu();
			int choice = getInput();
			performAction(choice);
		}
	}
	
	private void welcome() {
		System.out.println("------------------------------------");
		System.out.println("        Welcome to the text         ");
		System.out.println("          report program.           ");
		System.out.println("------------------------------------");
	}
	
	private void printMenu() {
		System.out.println("\nPlease make a selection: ");
		System.out.println("1) General Report ");
		System.out.println("2) Individual Report");
		System.out.println("3) Search");
		System.out.println("0) Exit");
	}
	
	private int getInput() {
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		while(choice < 0 || choice > 3 ) {
			try {
				System.out.print("\nEnter your choice:");
				choice = Integer.parseInt(sc.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("Invalid selection: Please try again.");
			}
		}
		return choice;
	}
	
	private void performAction(int choice) {
		switch(choice) {
		case 0:
			exit = true;
			System.out.println("Thank you for using our application");
			break;
		case 1: newFiles.generalReport();
		case 2:
		case 3:
		default: 
			//System.out.println("An error has occured.");
			
		}
	}
}
