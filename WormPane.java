package day02.worm;

public class WormPane {
	private Worm worm;
	private static Dou dou;
	private int rows = 20;
	private int cols = 32;
	
	public static Dou getDou() {
		return dou;
	}
	
	public static void setDou(Dou dou) {
		WormPane.dou = dou;
	}

	public WormPane(){
		worm = new Worm();
		dou = new Dou(10,10);//≥ı ºŒª÷√£ª
	}
	public Worm getWorm(){
		return worm;		
	}
	public void print(){
		for(int r = 0 ;r<rows;r++){
			for(int c = 0;c<cols;c++){
				if(r==0||r==rows-1){
					System.out.print("-");
					}else if(c==0||c==cols-1){
						System.out.print("|");
					}else if(worm.contains(r,c)){
						System.out.print("#");
					}else if(this.dou.getI()==r&&this.dou.getJ()==c){
						System.out.print("O");
					}else{
						System.out.print(" ");
					}
					
				
			}
			System.out.println();
		}
	}

}
