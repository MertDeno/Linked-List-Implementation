
public class linkedList {
	
	public Node head;
	public int countList;
	
	public linkedList(){
		head=new Node(0);
		countList=0;
	}
	
	public void showTheList(){
		Node current=head;
		
		while(current.next!=null){
			System.out.print(current.value+"->");
			current=current.next;
		}
		System.out.println(current.value);
	}
	
	public void appendData(int data){
		Node newNode=new Node(data);		
		Node current=head;
		
		while(current.next!=null){
			current=current.next;
		}
		
		current.next=newNode;
		countList++;
	}
	
	public void prependData(int data){
		Node newNode=new Node(data);
		
		newNode.next=head;
		head=newNode;
		countList++;
	}
	
	public void addWithIndex(int data,int index){
		Node newNode=new Node(data);
		Node current=head;
		
		int number=0;
		
		if(index>countList || index<1){
			System.out.println("Out ouf Bounds");
		}
		
		else if(index==0){
			prependData(data);
		}
		
		else{
			while(number<index-1){
				current=current.next;
				number++;
			}
			current.next=newNode.next;
			current.next=newNode;
			countList++;
		}
	}
	
	public boolean deleteNode(int data){
		Node current=head;
		while(current.next!=null){
			if(head.value==data){
				current.next=current.next.next;
				countList--;
				return true;
			}
			else if(current.next.value==data){
				current.next=current.next.next;
				countList--;
				return true;
			}
			current=current.next;
		}
		System.out.println("Not found");
		return false;
	}
	
	public void deleteNodeByIndex(int index){
		Node current=head;
		int number=0;
		
		if(index>countList || index<0){
			System.out.println("Out ouf Bounds");
		}
		
		else if(index==0){
			deleteFirstElement();
		}
		
		else{
			while(number<index-1){
				current=current.next;
				number++;
			}
			current.next=current.next.next;
			countList--;
		}
	}
	
	public void deleteFirstElement(){
		Node current=head;
		
		if(head==null){
			return;
		}
		else{
			current=head.next;
			head=head.next;
			countList--;
		}
				
	}
	
	public void getElement(int index){
		Node current=head;
		int number=0;
		
		if(index>countList || index<0){
			System.out.println("Out ouf Bounds lll");		
		}
		
		else if(index==0){
			System.out.println(current.value);
		}
		
		else{
			while(number<index){
				current=current.next;
				number++;
				if(number==index){
					System.out.println(current.value);
					break;
				}
			}
		}
	}
	
	public void setElement(int data,int index){
		Node current=head;
		int num=0;
		
		if(index>countList || index<0){
			System.out.println("Out of Bounds");
		}
		else{
			while(num<index-1){
				current=current.next;
				num++;
				if(num==index-1){
					current.value=data;
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		linkedList l = new linkedList();
		l.appendData(12);
		l.appendData(13);
		l.appendData(14);
		l.showTheList();
		System.out.println("\n");
		l.prependData(16);
		l.prependData(17);
		l.showTheList();
		System.out.println("\n");
		l.showTheList();
		l.showTheList();
		l.deleteFirstElement();
		l.showTheList();
		l.deleteNodeByIndex(0);
		l.showTheList();
		l.setElement(20, 3);
		l.showTheList();
	}

}
