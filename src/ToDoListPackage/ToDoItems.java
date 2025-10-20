package ToDoListPackage;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ToDoItems {
	Scanner scan = new Scanner(System.in);
	private int id = 1;
	private String item;
	private HashMap<Integer, String> hashMap = new HashMap<>();
	private boolean flag = true;
	private HashMap<String, Integer> completedMap = new HashMap<>();
	private int count = 1;
	// private String completedItems;
	public ToDoItems() {
		Choose();
	}

	public void display() {
		System.out.println("\t*** To-Do List ***");
		System.out.println("-what do you want to do :");
		System.out.println("1-Add Item");
		System.out.println("2-Delete Item");
		System.out.println("3-Serach Item");
		System.out.println("4-Exit Item");
		System.out.println("5-Show Un-Complaeted Items");
		System.out.println("6-Show the list of Items");
		System.out.println("7-mark As Complete");
		System.out.println("8-Show Completed Items");
		System.out.println("-Choose a number :");
		}

		public void Choose() {
			try {
				while (flag) {
				display();
				int choice = scan.nextInt();
				switch (choice) {
					case 1 -> addItem();
					case 2 -> deleteItem();
					case 3 -> searchItem();
					case 4 -> {
						System.out.println("Bye");
						Exit();
					}
					case 6 -> ShowItems();
					case 5 -> UnCompletedItems();
					case 7 -> markAsComplet();
					case 8 -> showCompletedItems();
					default -> System.out.println("Invalid Input Choose Number Between 1 and 8");
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input");
		}
		}

	private void Exit() {
		flag = false;
	}
	private void ShowItems() {
		if (hashMap.isEmpty()) {
			System.out.println("Nothing to Show The List Is Empty");
		} else {
		for (Map.Entry<Integer, String> key : hashMap.entrySet()) {
			System.out.print("(" + key.getValue() + "=" + key.getKey() + ")");
		}
		System.out.println();
	}
}
	private void markAsComplet() {
		if (hashMap.isEmpty()) {
			System.out.println("Empty List");
		} else {
		System.out.println("What the ID of items that you compelet : ");
		int completeID = scan.nextInt();
		  if (hashMap.containsKey(completeID)) {
		String completeItem = null;
		for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
			if (entry.getKey().equals(completeID)) {
				completeItem = entry.getValue();
				hashMap.remove(completeID, completeItem);
				setItem("Completed");
				System.out.println("Item :" + completeItem + " Is Completed");
				break;
			}
		}
		String sendTo = completeItem;
		completedMap.put(sendTo, count);
	} else {
		System.out.println("ID Not Found");
	}
}
}

private void showCompletedItems() {
	String key = null;
	int value = 1;
	count++;
	if (hashMap.isEmpty() && count <= 1) {
		System.out.println("Completed List Is Empty");
	}
	else if (count > 1) {
		for(Map.Entry<String, Integer> show:completedMap.entrySet()) {
			key = show.getKey();
			value = show.getValue();
		}
		System.out.println("The Completed Item :" + key + "=" + value);
	}

}
	public int getId() {
		return id;
	}
	public String getItem() {
		return item;
	}
	private void searchItem() {
		System.out.println("Search about what ?");
		System.out.println("1-Completed item");
		System.out.println("2-UnCompleted item");
		switch (scan.nextInt()) {
		case 1 -> showCompletedItems();
		case 2 -> UnCompletedItems();
		}

	}
	private void UnCompletedItems() {
		if (hashMap.isEmpty()) {
			System.out.println("Empty List");
		} else {
		System.out.println("This IS You Un-Completed List :");
		for (String print : hashMap.values()) {
			System.out.println(print);
		}
	}
	}
	private void deleteItem() {
		if (hashMap.isEmpty()) {
			System.out.println("Empty List");
		} else {
		System.out.println("Enter The ID You Want To Delete :");
  int deleteID=scan.nextInt();
		if (hashMap.containsKey(deleteID)) {
			hashMap.remove(deleteID);
			System.out.println("Item Deleted");
		} else {
			System.out.println("ID Not Found");
		}
		System.out.println(hashMap);
	}
}
	public void addItem() {
		System.out.println("Enter what do you want to add :" + scan.nextLine().trim());
		item = scan.nextLine().trim();
		hashMap.put(id, item);
		ShowItems();
		id++;
		
	}
	public Integer setId(int id) {
		this.id = id;
		return id;
	}
	public void setItem(String item) {
		this.item = item;
	}
}
