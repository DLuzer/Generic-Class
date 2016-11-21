import java.util.ArrayList;

public class main {
	public static void main(String[] args){
		OccurenceSet<Integer> set = new OccurenceSet<Integer>();
		ArrayList<Integer> intList = new ArrayList<>();
		set.add(1);
		set.add(3);
		set.add(5);
		set.add(5);
		set.add(3);
		set.add(3);
		set.add(3);
		set.add(6);
		System.out.println(set.toString());
		OccurenceSet<String> stringSet = new OccurenceSet<String>();
		stringSet.add("hello");
		stringSet.add("world");
		stringSet.add("hi");
		stringSet.add("hello");
		stringSet.add("hello");
		stringSet.add("world");
		System.out.println(stringSet.toString());
		System.out.println(set.retainAll(intList));
		System.out.println(set);
	}
}
