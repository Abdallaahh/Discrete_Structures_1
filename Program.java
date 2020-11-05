import java.util.ArrayList;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		
		//Receive Universe as input
		ArrayList<String> universe = new ArrayList<String>();
		int subsetNum;
	    Scanner reader = new Scanner(System.in);
	    int flag = 0;
	    while (flag==0) {
	    	System.out.println("Input string:");
	    	universe.add(reader.next());
	    	while(true) {
	    		System.out.println("Do you want to add more to the universe? (y/n)");
	    		String input = reader.next();
		    	if(input.compareTo("n")==0) {
		    		flag=1;
		    		break;
		    	}
		    	else if (input.compareTo("y")!=0) {
		    		System.out.println("Invalid input. Please try again.");
		    	}
		    	else {
		    		break;
		    	}
		 
	    	}

	    }
	    universe = SetUtils.removeDuplicates(universe);
	 
	    //Print out universe with the index of each element
	    System.out.println("The universe contains:");
	    for (int i=0;i<universe.size();i++) {
	    	System.out.println(""+ (i+1) + "- " + universe.get(i));
	    }
	    
	    //Create one or more sets that are subsets of the universe.
	    System.out.println("\nPlease enter the number of required sets:");
	    subsetNum=-1;
	    while(subsetNum < 0) {
	    	subsetNum=reader.nextInt();
    	}
	    
	    ArrayList<ArrayList<String>> subsets = new ArrayList<ArrayList<String>>();
	    for (int i = 0; i < subsetNum ; i++) {
	    	ArrayList<String> currentSubset = new ArrayList<String>();
	    	System.out.println("Please select index from universe to place in set " + (i+1) + ":");
	    	flag = 0;
	    	int index;
		    while (flag==0) {
		    	
		    	//checking if the user wants to add
		    	while(true) {
		    		System.out.println("Do you want to add to the set? (y/n)");
		    		String input = reader.next();
			    	if(input.compareTo("n")==0) {
			    		flag=1;
			    		break;
			    	}
			    	else if (input.compareTo("y")!=0) {
			    		System.out.println("Invalid input. Please try again.");
			    	}
			    	else {
			    		break;
			    	}
		    	}
		    	if (flag == 1)
		    		break;
		    	
		    	index=-1;
		    	System.out.println("Input index:");
		    	while(index>universe.size() || index<1) {
		    		index = reader.nextInt();
		    	}
		    	currentSubset.add(universe.get(index-1));

		    }
		    
	    	subsets.add(SetUtils.removeDuplicates(currentSubset));
	    }
	    
	    //Operations
	    int exitFlag = 0;
	    while(exitFlag==0) {
	    	System.out.println("\n===========================\nPlease select an operation:\n===========================\n1-Union of two sets\n2-Intersection of two sets\n3-Complement of a set\n4-Print universe\n5-Print specific set\n6-Exit");
	    	int selection = reader.nextInt();
	    	ArrayList<String> result = new ArrayList<String>();
	    	if(selection==6) {
	    		exitFlag=1;
	    	}
	    	else if (selection == 1 || selection == 2) {
	    		if (subsetNum < 2) {
	    			System.out.println("Cannot perform operation as there are less than 2 specified sets in the universe.");
	    		}
	    		else {
		    		SetUtils op = new SetUtils(universe);
		    		int sub=-1;
		    		System.out.println("Please select first required set:");
		    		while(sub>subsetNum || sub<1) {
		    			sub=reader.nextInt();
		    		}
		    		ArrayList<String> list1= subsets.get(sub-1);
		    		sub=-1;
		    		System.out.println("Please select second required set:");
		    		while(sub>subsetNum || sub<1) {
		    			sub=reader.nextInt();
		    		}		
		    		ArrayList<String> list2= subsets.get(sub-1);
		    		if (selection == 1) {
		    			result = op.union(list1, list2);
			    		System.out.println("The union of the two sets contains:");
		    		}
		    		else {
		    			result = op.intersection(list1, list2);
			    		System.out.println("The intersection of the two sets contains:");
		    		}
	    		}
	    	    
	    	}
	    	else if (selection == 3) {
	    		if (subsetNum < 1) {
	    			System.out.println("Cannot perform operation as there are no specified sets in the universe.");
	    		}
	    		else {
		    		SetUtils op = new SetUtils(universe);
		    		int sub=-1;
		    		System.out.println("Please select the required set:");
		    		while(sub>subsetNum || sub<1) {
		    			sub=reader.nextInt();
		    		}
		    		ArrayList<String> list1= subsets.get(sub-1);
		    		result = op.complement(list1);
		    		System.out.println("The complement of the set contains:");
	    		}
	    	}
	    	else if (selection == 4) {
	    		result = universe;
	    		System.out.println("The universe contains:");
	    	}
	    	else {
	    		if (subsetNum < 1) {
	    			System.out.println("Cannot perform operation as there are no specified sets in the universe.");
	    		}
	    		else {
		    		int sub=-1;
		    		System.out.println("Please select the required set:");
		    		while(sub>subsetNum || sub<1) {
		    			sub=reader.nextInt();
		    		}
		    		result = subsets.get(sub-1);
		    		System.out.println("The specified set contains:");
	    		}
	    	}
	    	for (int i=0;i<result.size();i++) {
	    	    System.out.println(""+ (i+1) + "- " + result.get(i));
	    	}
	    }
	    
	    
	    reader.close();
	  }
}
