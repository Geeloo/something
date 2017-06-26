package kit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Queen {
	private static final int LEN = 8;
	private static List<String> list = new ArrayList<String>();
	//private static int square[][] = new int[LEN][LEN];
	public static void main(String[] args) {	
		List<String> s = new LinkedList<String>();
		init(s,LEN);
		//System.out.println("s = \n" + s);
		putQueen(s);
	}
	private static void putQueen(List<String> s){
		if (s.isEmpty())
			System.out.println(list.toString());
		else {
			for (int i = 0; i < s.size(); i++) {
				moveTo(s, i, list, list.size());
				if(!canEat())					
					putQueen(s);				
				moveTo(list, list.size() - 1, s, i);
			}
		}
	}
	private static boolean canEat(){
		//boolean canEat = square[list.size()-1][Integer.parseInt(list.get(list.size()-1))] > 0;
		int i = 0;
		for(;i<list.size()-1;i++){
			if(Math.abs(list.size()-1 - i) == Math.abs(Integer.parseInt(list.get(list.size()-1)) - Integer.parseInt(list.get(i)))){
				return true;
			}				
		}
		return false;
	}
	private static void moveTo(List<String> src, int src_position,
			List<String> dest, int dest_position) {
		dest.add(dest_position, src.remove(src_position));
	}
	private static void init(List<String> s,int len){
		int i = -1;
		while(++i < len)
			s.add(i, String.valueOf(i));
	}
}
