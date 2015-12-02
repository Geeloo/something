package kit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShowAll {
	private static List<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		List<String> s = new LinkedList<String>();
		s.add("1");
		s.add("2");
		s.add("3");
		s.add("4");
		s.add("5");
		s.add("6");
		show(s);
	}

	public static void show(List<String> s) {
		if (s.isEmpty())
			System.out.println(list.toString());
		else {
			for (int i = 0; i < s.size(); i++) {
				moveTo(s, i, list, list.size());
				show(s);
				moveTo(list, list.size() - 1, s, i);
			}
		}
	}

	private static void moveTo(List<String> src, int src_position,
			List<String> dest, int dest_position) {
		dest.add(dest_position, src.remove(src_position));
	}

}
