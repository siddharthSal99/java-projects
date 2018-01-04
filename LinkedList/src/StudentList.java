/*	$iddharth $alunkhe
 * The StudentList class is a LinkedList that contains nodes that each represent a student. Since each student has a first and last name and a GPA, the StudentList can be organized 
 * alphabetically by last name and GPA. This Linked List provides an easier way of keeping the entire class as a single unit, connected with each other by some order(last name, GPA)
 * 
 * 
 */
public class StudentList {
	//keeps track of the head node, the first link in the linked list of StudentNodes
	private StudentNode headNode;
	//keeps track of the number of elements in the linked list
	private int listSize;
/*
 * This constructor sets the head node of the linked list to the given StudentNode since this is the first node added.
 * It also initializes the size of the list to 1 since there is now 1 element
 * 
 * parameters: StudentNode headNode; the first node added to the linked list.
 * 
 */
	public StudentList(StudentNode headNode){
		this.headNode = headNode;
		listSize = 1;
	}
	/*
	 * This constructor sets the head node of the linked list to the given Student since this is the first node added.
	 * It creates a node from the given student and delegates to the other constructor
	 * It also initializes the size of the list to 1 since there is now 1 element
	 * 
	 * parameters: Student stu; the first student added to the linked list.
	 * 
	 */
	public StudentList(Student stu){
		this(new StudentNode(stu));
		listSize = 1;
	}
	/*
	 * This inserts the given student to the correct location alphabetically by last name. this can only be done if the Linked List has been sorted by last name prior to the addition
	 * of the new student. If the Linked List is empty (size == 0), then this sets the head node to the corresponding node of the 
	 * given Student. If the last names are the same, then the first names are compared alphabetically.
	 * 
	 * Parameters: Student stu; the student being added to the Linked List
	 * returns: none
	 */
	public void insertByLastName(Student student){
		String name = student.getLastName();
		StudentNode node = new StudentNode(student);
		if(headNode ==  null){
			this.headNode = node;
			listSize++;
			return;
		}
		StudentNode prev = null;
		StudentNode currNode = headNode;
		while(currNode != null && name.compareTo(currNode.getValue().getLastName()) > 0){
			prev = currNode;
			currNode = currNode.getNext();
		}
		if(currNode != null && name.equalsIgnoreCase(currNode.getValue().getLastName())){
			if( name.compareTo(currNode.getValue().getFirstName()) > 0){
				node.setNext(currNode.getNext()); currNode.setNext(node); 
				return;
			}
			else{
				prev.setNext(node); node.setNext(currNode);
			}
		}
		if(currNode == null){
			prev.setNext(node);
		}
		else if(prev ==  null){
			node.setNext(headNode);
			this.headNode = node;
		}
		else
		{prev.setNext(node); node.setNext(currNode);}
		listSize++;
	}
	/*
	 * This inserts the given student to the correct location numerically by average. this can only be done if the Linked List has been 
	 * sorted by average prior to the addition of the new student. If the Linked List is empty (size == 0), then this sets the head 
	 * node to the corresponding node of the given Student.
	 * 
	 * Parameters: Student stu; the student being added to the Linked List
	 * returns: none
	 */
	public void insertByAverage(Student student){
		//System.out.println(student);
		int GPA = student.getGPA();
		StudentNode node = new StudentNode(student);
		if(headNode ==  null){
			this.headNode = node;
			return;
		}
		StudentNode prev = null;
		StudentNode currNode = headNode;
		while(currNode != null && GPA > currNode.getValue().getGPA()){
			prev = currNode;
			currNode = currNode.getNext();
		}
		if(currNode == null){
			prev.setNext(node);
		}
		else if(prev ==  null){
			node.setNext(headNode);
			this.headNode = node;
		}
		else
		{prev.setNext(node); node.setNext(currNode);}
		listSize++;
	}
	
	
	/*
	 * prints the Student List in the form FirstName LastName, "average = " average 
	 * there is a new line for each student printed.
	 * 
	 * parameters: none
	 * returns: none
	 */
	public String toString(){
		String str = "";
		StudentNode node = headNode;
		while(node != null){
			str += node.getValue().toString() + "\n";
			node = node.getNext();
		}
		
		return str;
	}
	/*
	 * Removes a student with a given first and last name and grade average. The student is removed only if all three parameters correspond. 
	 * It resets the headNode as necessary and keeps the linked list connected, even after the removal.
	 * 
	 * parameters: student stu; Student to be removed
	 * returns: the removed student, or null if no one was removed.
	 */
	public Student removeStudent(Student stu){
		StudentNode prev = null;
		StudentNode curr = headNode;
		String fName = stu.getFirstName();
		String lName = stu.getLastName();
		int GPA = stu.getGPA();
		int i = 0;
		while(i < listSize + 1){
			if(curr.getValue().getFirstName().equals(fName) && curr.getValue().getLastName().equals(lName) && GPA == curr.getValue().getGPA()){
				if(i == 0){	this.headNode = curr.getNext(); return stu;	}
				prev.setNext(curr.getNext());
				listSize--;
				return stu;
			}
			prev = curr;
			curr = curr.getNext();
			i++;
		}
		return null;
	}
	/*
	 * returns the headNode
	 * param: none
	 * returns: StudentNode headNode; the current headNode of the Linked List
	 */
	public StudentNode getHeadNode(){
		return headNode;
	}
	/*
	 * Sorts the given linked list numerically by grade averages of the members of the classroom from least to greatest. 
	 * The headNode has the lowest average.
	 * 
	 * parameters: none
	 * returns: none
	 * 
	 */
	public void sortByAverage(){
		StudentList list = new StudentList(removeStudent(headNode.getValue()));
		int size = listSize;
		for(int i = 0; i < size - 1; i++){
			list.insertByAverage(removeStudent(headNode.getValue()));
		}
		headNode = list.getHeadNode();
	}
	/*
	 * Sorts the given linked list alphabetically by last name of the members of the classroom from a to z. The headNode has the earliest 
	 * alphabetical name.
	 * 
	 * parameters: none
	 * returns: none
	 * 
	 */
	public void sortByLastName(){
		StudentList list = new StudentList(this.removeStudent(this.headNode.getValue()));
		int size = listSize;
		for(int i = 0; i < size - 1; i++){
			list.insertByLastName(this.removeStudent(headNode.getValue()));
		}
		headNode = list.getHeadNode();
	}


	public static void main(String[]args){
		//given students
		Student s1 = new Student("Thomas", "Edgars", 89);
		Student s2 = new Student("Jennifer", "Smith", 86);
		Student s3 = new Student("Harold", "Umberton", 78);
		Student s4 = new Student("Frank", "Martin", 60);
		Student s5 = new Student("Jeremy", "Andrews", 83);
		Student s6 = new Student("Laura", "Roberts", 93);
		Student s7 = new Student("Adele", "Lincoln", 95);
		Student s8 = new Student("Peter", "Smith", 91);
		Student s9 = new Student("Larry", "Peterson", 72);
		StudentList testList = new StudentList(s1);
		testList.insertByLastName(s2);
		testList.insertByLastName(s3);
		testList.insertByLastName(s4);
		testList.insertByLastName(s5);
		testList.insertByLastName(s6);
		testList.insertByLastName(s7);
		testList.insertByLastName(s8);
		testList.insertByLastName(s9);
		System.out.println(testList);
		testList.removeStudent(new Student("Frank", "Martin", 60));
		System.out.println(testList);
		testList.sortByAverage();
		System.out.println(testList);
		testList.insertByAverage(new Student("Alice", "Henderson", 90));
		System.out.println(testList);
		testList.sortByLastName();
		System.out.println(testList);
		
		
		
		
		
		
		
//		testList.insertByAverage(s2);
//		testList.insertByAverage(s3);
//		testList.insertByAverage(s4);
//		testList.insertByAverage(s5);
//		testList.insertByAverage(s6);
//		testList.insertByAverage(s7);
//		testList.insertByAverage(s8);
//		testList.insertByAverage(s9);
//		System.out.println(testList);
//		testList.sortByLastName();
//		//testList.removeStudent(s5);
//		//testList.removeStudent(s4);
//		//testList.removeStudent(s3);
//		//testList.removeStudent(s2);
//		//testList.removeStudent(s9);
//		System.out.println(testList);
//		testList.sortByAverage();
//		System.out.println(testList);


	}

}
