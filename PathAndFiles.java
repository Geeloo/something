package files;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;

public class PathAndFiles {
	
	public static void main(String[] args) {
		Path p = Paths.get("c:\\home\\ftp");
		System.out.println(p.toUri());
		try {
			Files.walk(p, 1200,FileVisitOption.FOLLOW_LINKS).filter(f -> f.toFile().isDirectory()).forEach(System.out::println);;;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(p.resolve("liyuan"));;
		
		
		int[] arr = new int[]{1,3,5,7,9,11,13,15};
		System.out.println("          " + "a" + "\t" + "b" + "\t" + "c" + "\t" + "result");
		for(int a : arr){
			for(int b : arr){
				for(int c : arr){
					
					System.out.println("current : " + a + "\t" + b + "\t" + c + "\t" + (a+b+c));
					if(a + b + c == 30){
						System.out.printf("%d\t%d\t%d",a,b,c);
					}
				}
			}
		}
		System.out.println("over");
		
		//---------------------------------
		
		
		elementNumbers = new int[elements.length];
		Arrays.fill(elementNumbers, 0);
		System.out.println(Arrays.toString(elements));
		System.out.println("-------------------------");
		printAll(elementNumbers,0);
	}
	/**
	 * 计算用不同数量的零钱凑成某一固定总钱数的所有可能
	 * 
	 * @param elementNumbers 每种零钱的个数
	 * @param currentIndex 当前计算的零钱下标
	 */
	private static void printAll(int[] elementNumbers,int currentIndex){
		int loopNumber = (int)(sum / elements[currentIndex]);
		for(int i = 0;i <= loopNumber+9;i++){
			elementNumbers[currentIndex] = i;
			double currSum = sum(elementNumbers);
			if( currSum == sum){
				System.out.println(Arrays.toString(elementNumbers));
				elementNumbers[currentIndex] = 0;
				break;
			}else if(currSum > sum){
				elementNumbers[currentIndex] = 0;
				break;
			}else{
				if(currentIndex < elements.length - 1){
					printAll(elementNumbers,currentIndex + 1);
				}
			}
		}
	}
	
	private static double sum(int[] elementNumbers){
		
		double sum = 0.0;
		for(int i = 0; i < elements.length; i++){
			sum += elements[i] * elementNumbers[i];
		}
		return Double.parseDouble(df.format(sum));
	}
	static DecimalFormat df = new DecimalFormat("0.0000");
	/**
	 * 总钱数
	 */
	static double sum = 110;
	/**
	 * 零钱
	 */
	static double[] elements = new double[]{1.1,2,5,10};
	/**
	 * 每种零钱的数量
	 */
	static int[] elementNumbers;
}

