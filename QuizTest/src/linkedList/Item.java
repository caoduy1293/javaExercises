package linkedList;

public class Item {
	public int data;
	public Item next;
	public Item(int data){
		this.data = data;
	}
	@Override
	public String toString() {
		return "data: " + this.data + " ";
	}
	
}
