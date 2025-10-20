package ToDoListPackage;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class versiontwo {
	Scanner scan = new Scanner(System.in);
	private int id = 1;
	private boolean isDone = false;
	// private HashMap<String, Boolean> item = new HashMap<>();
	private HashMap<Integer,HashMap<String,Boolean> > hashMap = new HashMap<>();
	private boolean flag = true;
	private int count = 1;
	public versiontwo() {
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
		System.out.println("9-Upadte Items");
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
					case 6 -> ShowItems(hashMap);
					case 5 -> UnCompletedItems();
					case 7 -> markAsComplet();
					case 8 -> showCompletedItems(null);
					case 9 -> update();
					default -> System.out.println("Invalid Input Choose Number Between 1 and 9");
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input");
		}
		}

	private void Exit() {
		flag = false;
	}

	private void ShowItems(HashMap<Integer, HashMap<String, Boolean>> hashMap) {
		if (hashMap.isEmpty()) {
			System.out.println("Nothing to Show The List Is Empty");
		} else {
			for (Map.Entry<Integer, HashMap<String, Boolean>> map : hashMap.entrySet()) {
				int key = map.getKey();
				HashMap<String, Boolean> value = map.getValue();
				for (Map.Entry<String, Boolean> iterateMap : value.entrySet()) {
					System.out.print("( " + iterateMap.getKey() + "= " + key + ")");
				}
		}
		System.out.println();
	}
}
	private void markAsComplet() {
		if (hashMap.isEmpty()) {
			System.out.println("Empty List");
		} else {
		System.out.println("What the ID of items that you compelet : ");
		int completedID = scan.nextInt();
		if (hashMap.containsKey(completedID)) {
			boolean isDone = true;
			HashMap<String, Boolean> completeHash = hashMap.get(completedID);
				HashMap<String, Integer> completedHash = new HashMap<String, Integer>();
				for (Map.Entry<String, Boolean> passMap : completeHash.entrySet()) {
					String completedItem = passMap.getKey();
					setDone(true);
					completedHash.put(completedItem, completedID);
					System.out.println("{ " + passMap.getKey() + " is Done " + isDone + " }");
				}
				hashMap.remove(completedID);
				showCompletedItems(completedHash);
			} else {
				System.out.println("ID not Found!");
		}
	}
}


private void showCompletedItems(HashMap<String, Integer> completedHash2) {
	HashMap<String, Integer> h = completedHash2;
	if (completedHash2 == null || completedHash2.isEmpty()) {
		System.out.println("Completed List Is Empty");
	}
	else if (isDone() == true) {
		for (Map.Entry<String, Integer> show : h.entrySet()) {
			count = show.getValue();
			String key=show.getKey();
			System.out.println("( " + key + " ID for it =" + count + " is Done ?" + isDone + " )");
			}
	}
}
	public int getId() {
		return id;
	}
	private void searchItem() {
		System.out.println("Search about what ?");
		System.out.println("1-Completed item");
		System.out.println("2-UnCompleted item");
		switch (scan.nextInt()) {
		case 1 -> showCompletedItems(null);
		case 2 -> UnCompletedItems();
		}

	}
	private void UnCompletedItems() {
		if (hashMap.isEmpty()) {
			System.out.println("Empty List");
		} else if (isDone == false) {
			ShowItems(hashMap);

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

		System.out.print("this is the rest of items");
		ShowItems(hashMap);
	}
}
	public void addItem() {
		System.out.println("Enter what do you want to add :" + scan.nextLine().trim());
		String input = scan.nextLine().trim();

		HashMap<String, Boolean> item = new HashMap<>();
		setDone(false);
		item.put(input, false);
		hashMap.put(id, item);
		ShowItems(hashMap);
		id++;
	}

	public void update() {
		if (hashMap.isEmpty()) {
			System.out.println("The list is empty");
		} else {
			System.out.println("Enter the ID for the item you want to Update :");
		int key = scan.nextInt();
		if (!hashMap.containsKey(key)) {
			System.out.println(" Choose Number :" + "\n 1.add \n 2.delete :");
			int user = scan.nextInt();
			switch (user) {
			case 1 -> addItem();
			case 2 -> deleteItem();
			}
		} else {
			System.out.println("ID Not Found");
		}
	}
	}

	public Integer setId(int id) {
		this.id = id;
		return id;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
}
