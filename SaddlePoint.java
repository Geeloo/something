package java8exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaddlePoint {
	static Logger logger = LoggerFactory.getLogger(SaddlePoint.class);
	private static double[][] matrix = new double[][]{{1,2,3,9},
													  {4,4,4,9},
													  {3,4,1,8},
													  {4,4,6,7}};
	public static void main(String[] args) {
		List<Position> saddles = getSaddlePoint(horizontallyMax(),verticallyMin());
		List<Position> saddles2 = getSaddlePoint(horizontallyMin(),verticallyMax());
		System.out.println(Arrays.deepToString(saddles.toArray(new Position[]{})));
		System.out.println(Arrays.deepToString(saddles2.toArray(new Position[]{})));
		
		
	}
	
	private static List<Position> getSaddlePoint(List<Position> horizontallySearch, List<Position> verticallySearch) {
		return horizontallySearch.stream().filter(h -> verticallySearch.contains(h)).collect(Collectors.toList());
	}

	private static List<Position> verticallyMin() {
		List<Position> r = new ArrayList<Position>();
		List<Position> r_temp = new ArrayList<Position>();
		for(int j = 0 ; j < matrix[0].length ; j++){			
			int minI = 0;
			for(int i = 0 ; i < matrix.length ; i++){
				if(matrix[i][j] < matrix[minI][j]){
					r_temp.clear();
					r_temp.add(new Position(i,j));
					minI = i;					
				}else if(matrix[i][j] == matrix[minI][j]){
					r_temp.add(new Position(i,j));
				}
			}
			r.addAll(r_temp);
			r_temp.clear();
		}
		logger.debug("vertical min = " + Arrays.toString(r.toArray(new Position[0])));
		return r;
	}
	private static List<Position> verticallyMax() {
		List<Position> r = new ArrayList<Position>();
		List<Position> r_temp = new ArrayList<Position>();
		for(int j = 0 ; j < matrix[0].length ; j++){
			int maxI = 0;
			for(int i = 0 ; i < matrix.length ; i++){
				if(matrix[i][j] > matrix[maxI][j]){
					r_temp.clear();
					r_temp.add(new Position(i,j));
					maxI = i;	
				}else if(matrix[i][j] == matrix[maxI][j]){
					r_temp.add(new Position(i,j));
				}
			}
			r.addAll(r_temp);
			r_temp.clear();
		}
		logger.debug("vertical max = " + Arrays.toString(r.toArray(new Position[0])));
		return r;
	}
	private static List<Position> horizontallyMax() {
		List<Position> r = new ArrayList<Position>();
		List<Position> r_temp = new ArrayList<Position>();
		for(int i = 0 ; i < matrix.length ; i++){
			int maxJ = 0;
			for(int j = 0 ; j < matrix[0].length ; j++){
				if(matrix[i][j] > matrix[i][maxJ]){
					r_temp.clear();
					r_temp.add(new Position(i,j));
					maxJ = j;
				}else if(matrix[i][j] == matrix[i][maxJ]){
					r_temp.add(new Position(i,j));
				}
			}
			r.addAll(r_temp);
			r_temp.clear();
		}
		logger.debug("horizontal max = " + Arrays.toString(r.toArray(new Position[0])));
		return r;
	}
	private static List<Position> horizontallyMin() {
		List<Position> r = new ArrayList<Position>();
		List<Position> r_temp = new ArrayList<Position>();
		for(int i = 0 ; i < matrix.length ; i++){
			int minJ = 0;
			for(int j = 0 ; j < matrix[0].length ; j++){
				if(matrix[i][j] < matrix[i][minJ]){
					r_temp.clear();
					r_temp.add(new Position(i,j));
					minJ = j;
				}else if(matrix[i][j] == matrix[i][minJ]){
					r_temp.add(new Position(i,j));
				}
			}
			r.addAll(r_temp);
			r_temp.clear();
		}
		logger.debug("horizontal min = " + Arrays.toString(r.toArray(new Position[0])));
		return r;
	}
	private static class Position{
		public int i,j;
		public Position(int i,int j){
			this.i = i;
			this.j = j;
		}
		@Override
		public boolean equals(Object p){
			if(p instanceof Position){
				Position position = (Position) p;
				if(position.i == this.i &&  position.j == this.j){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}	
		}
		@Override
		public String toString(){
			return "(i = " + i + ", j = " + j + ")";
		}
	}
}
