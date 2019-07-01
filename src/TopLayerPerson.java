import java.util.*;
public class TopLayerPerson {
	
//	Method to find the highest number of Parents
	public static List<Person> highestParents(List<Person> listOfPeople) {
		List<Person> parents = findAllChildren(null,listOfPeople);
		int [] parentsCount = new int[parents.size()];
		for(Person p : parents)
		{
			parentsCount[parents.indexOf(p)] = parentChildCount(p,listOfPeople);
		}
		List<Person> topLayerPersons = new ArrayList<Person>();
		int maxNumber = 0;
		for(int i=0; i< parentsCount.length; i++)
		{
			if(parentsCount[i] > maxNumber)
				maxNumber = parentsCount[i];
		}
		for(Person p : parents)
		{
			if(parentsCount[parents.indexOf(p)] == maxNumber)
				topLayerPersons.add(p);
		}
		return topLayerPersons;
	}
	
//	Method to find the number of all descendants
	public static List<Person> findAllChildren(Person people, List<Person> listOfPeople)
	{
		List<Person> listChildren = new ArrayList<Person>();
		if(people == null)
		{
			for(Person p : listOfPeople)
			{
				if(p.getParent_id() == null)
					listChildren.add(p);
			}
			return listChildren;
		}
		
		for(Person p : listOfPeople)
		{
			if(p.getParent_id() != null && p.getParent_id() == people.getId())
				listChildren.add(p);
		}
		return listChildren;
	}
	
//// Method to find the biggest number of children
//	public static int parentChildCount(Person people, List<Person> listOfPeople) {
//		List<Person> listChildren = findAllChildren(people, listOfPeople);
//		if(listChildren == null || listChildren.size() == 0) {
//			return 0;
//		}
//		int numberOfChildern = listChildren.size();
//		for(Person child : listChildren) {
//			numberOfChildern += parentChildCount(child, listOfPeople);
//		}
//		return numberOfChildern;
//	}
	
// Method to find the biggest number of Layers (hierarchy)
	public static int parentChildCount(Person people, List<Person> listOfPeople) {
		List<Person> listChildren = findAllChildren(people, listOfPeople);
		if(listChildren == null || listChildren.size() == 0) {
			return 0;
		}
		int [] layerNumber = new int[listChildren.size()];
		for(Person child : listChildren) {
			layerNumber[listChildren.indexOf(child)] = parentChildCount(child, listOfPeople);
		}
		int maxLayer = 0;
		for(int i=0; i< layerNumber.length; i++)
			if(layerNumber[i] > maxLayer)
				maxLayer = layerNumber[i];
		return maxLayer + 1;
	}
	
	
	public static void main(String[] args) {
		List<Person> listOfPeople = new ArrayList<Person>();
		listOfPeople.add(new Person(9,8));
		listOfPeople.add(new Person(8,3));
		listOfPeople.add(new Person(7,3));
		listOfPeople.add(new Person(10,6));
		listOfPeople.add(new Person(11,5));
		listOfPeople.add(new Person(6,2));
		listOfPeople.add(new Person(5,2));
		listOfPeople.add(new Person(4,1));
		listOfPeople.add(new Person(3,null));
		listOfPeople.add(new Person(2,null));
		listOfPeople.add(new Person(1,null));
		System.out.println(listOfPeople);
		List<Person> result = highestParents(listOfPeople);
		System.out.println(result);
	}

}

