package ll;
import java.util.*;
public class linkedlist {
	Node head;
	public void add(int data)
	{
		Node newnode=new Node(data);
		if(head==null)
		{
			head=newnode;
		}
		else {
			newnode.next=head;
			head=newnode;
		}
	}
	public void insertatend(int data)
	{
		Node newnode=new Node(data);
		if(head==null)
		{
			head=newnode;
		}else {
			Node temp=head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=newnode;
		}
	}
	public void display()
	{
		Node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data+" -> ");
			temp=temp.next;
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		linkedlist list = new linkedlist();
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many elements do you want to insert?");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i+1) + ": ");
            int value = scanner.nextInt();
//            list.add(value);
            list.insertatend(value);
        }

        System.out.println("Your linked list is:");
        list.display();

        scanner.close();
       
	}

}
