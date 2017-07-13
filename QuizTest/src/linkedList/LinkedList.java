package linkedList;

public class LinkedList {
	private Item firstItem;
	private Item lastItem;
	public LinkedList(){
		setFirstItem(null);
		setLastItem(null);
	}
	public Item getFirstItem() {
		return firstItem;
	}
	public void setFirstItem(Item firstItem) {
		this.firstItem = firstItem;
	}
	public Item getLastItem() {
		return lastItem;
	}
	public void setLastItem(Item lastItem) {
		this.lastItem = lastItem;
	}
	
	public boolean isEmpty(){
		return firstItem == null;
	}
	
	public void insertFirst(int itemData){
		Item newItem = new Item(itemData);
		if(isEmpty()) setLastItem(newItem);
		newItem.next = getFirstItem();
		setFirstItem(newItem);
	}
	public void insertLast(int itemData){
		Item newItem = new Item(itemData);
		if(isEmpty()) 
			setFirstItem(newItem);
		else
			getLastItem().next = newItem;
		setLastItem(newItem);
	}
	
	private Item getItemNearLast(Item item){
		Item currentItem = item;
		Item nextItem = currentItem.next;
		while (nextItem.next != null) {
			currentItem = nextItem;
			nextItem = currentItem.next;
		}
		return currentItem;
//		if(nextItem == null){
//			return item;
//		}
//		return getItemNearLast(nextItem);
	}
	private void deleteItemBaseOnValue(int data){
		Item preItem = null;
		Item currentItem = getFirstItem();
		Item nextItem = currentItem.next;
		while (currentItem != null) {
			if(currentItem.data > data){
				System.out.println("data removed is " + currentItem.data);
				if(preItem == null){//first item
					setFirstItem(currentItem.next);
				}else{
					preItem.next = nextItem;
				}
				if(currentItem.next == null){//last item
					setLastItem(preItem);
				}
				currentItem.next = null;
			}else{
				preItem = currentItem;
			}
			currentItem = nextItem;
			if(currentItem != null) nextItem = currentItem.next;
		}
		
	}
	
	public void removeLast(){
		if(!isEmpty()){
			Item deleteItem = getLastItem();
			int dataDeleted = deleteItem.data;
			if (getFirstItem().next == null){// if only one item
				setLastItem(null);
				setFirstItem(null);
				System.out.println("data removed is " + dataDeleted);
			}else{
				
				Item itemNearLast = getItemNearLast(getFirstItem());
				
				itemNearLast.next = null; // set itemNearLast -> null
				setLastItem(itemNearLast); // set lastItem -> itemNearLast
				
				System.out.println("data removed is " + dataDeleted);
			}
			
		}else{
			System.out.println("list is empty");
		}
		
	}
	
	public void removeItemHigher(int data) {
		if(!isEmpty()){
			if (getFirstItem().next == null && getFirstItem().data > data){// if only one item
				System.out.println("data removed is " + getFirstItem().data);
				setLastItem(null);
				setFirstItem(null);
			}else{
				deleteItemBaseOnValue(data);
			}
			
		}else{
			System.out.println("list is empty");
		}
		
	}
	@Override
	public String toString() {
		String str = "";
		str = str + "List (first-->last): ";
        Item current = getFirstItem(); // start at beginning
        while (current != null) // until end of list,
        {
        	str = str + current.toString(); // print data
            current = current.next; // move to next link
        }
        return str;
	}
	
	
}
