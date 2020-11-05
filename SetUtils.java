import java.util.ArrayList;

public class SetUtils {
	ArrayList<String> universe;
	
	SetUtils (ArrayList<String> universe){
		this.universe = universe;
	}
	
	SetUtils (){}
	

	ArrayList<String> union (ArrayList<String> list1, ArrayList<String> list2) {
		ArrayList<String> res = new ArrayList<String>();
		res.addAll(list1);
		res.addAll(list2);
		res = removeDuplicates (res);
		
		return res;
	}
	
	ArrayList<String> intersection (ArrayList<String> list1, ArrayList<String> list2) {
		ArrayList<String> res = new ArrayList<String>();
		
		for (String str : list1) {
			if (list2.contains(str))
				res.add(str);
		}

		return res;
	}
	
	ArrayList<String> complement (ArrayList<String> list) {
		ArrayList<String> res = new ArrayList<String>();
		res.addAll(universe);
		
		for (String str : list) {
			res.remove(str);
		}
		
		return res;
	}
	
	
	static ArrayList<String> removeDuplicates (ArrayList<String> list) {
		ArrayList<String> res = new ArrayList<String>();
		for (String str : list) {
			if (!res.contains(str))
				res.add(str);
		}
		
		return res;
		
	}
	
}
