import java.io.IOException;
import java.util.Scanner;

import utils.Canvas;

/**
 * Main class of the program
 * @author ealarcon
 */
public class Main {
	
	/**
	 * Main program. Prompts the command line to the user and deliver its commands.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("enter command: ");
		String command = scanner.nextLine();
		Canvas canvas = new Canvas();
		while(!command.equals("Q")) {
			String[] agmts = command.split(" ");
			switch(agmts[0]) {
				case "C" :
					canvas = new Canvas(Integer.parseInt(agmts[1]),
							Integer.parseInt(agmts[2]));
					System.out.println(canvas.draw());
					break;
				case "L" :
					canvas.drawLine(Integer.parseInt(agmts[1]), Integer.parseInt(agmts[2]),
							Integer.parseInt(agmts[3]), Integer.parseInt(agmts[4]));
					System.out.println(canvas.draw());
					break;
				case "R" :
					canvas.drawRectangle(Integer.parseInt(agmts[1]), Integer.parseInt(agmts[2]),
							Integer.parseInt(agmts[3]), Integer.parseInt(agmts[4]));
					System.out.println(canvas.draw());
					break;
				case "B" :
					canvas.fillArea(Integer.parseInt(agmts[1]), Integer.parseInt(agmts[2]),
							agmts[3].charAt(0));
					System.out.println(canvas.draw());
					break;
			}
			System.out.print("enter command: ");
			command = scanner.nextLine();
		}
		scanner.close();
		System.exit(0);
	}
	
}
