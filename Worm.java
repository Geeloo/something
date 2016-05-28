package day02.worm;

import java.util.LinkedList;
import java.util.Random;
public class Worm {
	Random r = new Random();
	private LinkedList<Node> nodes = new LinkedList<Node>();
	private int dir;
	public final static int UP = -10;
	public final static int DOWN = 10;
	public final static int LEFT = -1;
	public final static int RIGHT = 1;
	
	private  boolean lived = true;//true 表示蛇还活着  flase 就是表示死了；
	
	public  boolean isLived(){
		return this.lived;
	}
	public Worm(){
		nodes.add(new Node(2,10));
		nodes.add(new Node(3,10));
		nodes.add(new Node(4,10));
		nodes.add(new Node(4,11));
		nodes.add(new Node(5,11));
		nodes.add(new Node(6,11));
		dir = UP;
	}
	public Worm(LinkedList<Node> nodes){
		this.nodes.clear();
		this.nodes.addAll(nodes);
	}
	
	public void step(){
		Node oldHead = nodes.getFirst();
		int i = oldHead.getI() + dir/10;
		int j = oldHead.getJ() + dir%10;	
		if(i==0||i==19||j==0||j==31||this.contains(i, j)){
			this.lived = false;
			return;
		}
		
		Node newHead = new Node(i,j);
		
		nodes.addFirst(newHead);
		
		if(newHead.getI()==WormPane.getDou().getI()
				&&newHead.getJ()==WormPane.getDou().getJ()){
			while(true){
			Dou dou =	new Dou(r.nextInt(18)+1,r.nextInt(30)+1);
			WormPane.setDou(dou);
			if(this.contains(dou.getI(), dou.getJ())) continue;
			break;
			}
			return;
		}
		
		else nodes.removeLast();
	}
	
	
	public void step(int dir,Worm worm){
		if(this.dir ==-dir){
			System.out.println("error!");
		}else{
			this.dir = dir;
		}
		step();
	}
	public boolean contains(int i,int j){
		Node node = new Node(i,j);
		if(nodes.contains(node))
		return true;
		else return false;
	}
	
}
