package linkedList;

public class LinkedListApp {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.insertFirst(5);
		linkedList.insertFirst(6);
		linkedList.insertFirst(4);
		linkedList.insertFirst(7);
		linkedList.insertFirst(9);
		System.out.println(linkedList.toString());
		linkedList.removeItemHigher(5);
		linkedList.removeLast();
		System.out.println(linkedList.toString());
		System.out.println("Head Item " + linkedList.getFirstItem());
		System.out.println("Tail Item " + linkedList.getLastItem());
		
	}

}
