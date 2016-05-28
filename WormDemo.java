package day02.worm;

import java.util.Scanner;

public class WormDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WormPane pane = new WormPane();
		Worm worm = pane.getWorm();
		
		pane.print();
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			String dir = scanner.nextLine();
			if(dir.equalsIgnoreCase("q")||worm.isLived()==false){
				System.out.println("end");
				break;
			}else if(dir.equalsIgnoreCase("w")){
				worm.step(worm.UP,worm);
			}else if(dir.equalsIgnoreCase("a")){
				worm.step(worm.LEFT,worm);
			}else if(dir.equalsIgnoreCase("s")){
				worm.step(worm.DOWN,worm);
			}else if(dir.equalsIgnoreCase("d")){
				worm.step(worm.RIGHT,worm);
			}else{
				worm.step();
			}
			pane.print();
		}

	}

}
