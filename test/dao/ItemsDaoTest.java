package dao;

import java.util.ArrayList;

import entity.Items;

public class ItemsDaoTest {
	static void getAllItemsTest() {
		ArrayList<Items> list = new ItemsDao().getAllItems();
		for(Items i: list) {
			System.out.println(i);
		}
	}
	
	static void getItemsByIdTest() {
		System.out.println(new ItemsDao().getItemsById(1));
	}
	
	static void getViewListTest() {
		String listId = "1,2,3,4,5,6";
		ArrayList<Items> list = new ItemsDao().getViewList(listId);
		for(Items i: list) {
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		getAllItemsTest();
		getItemsByIdTest();
		getViewListTest();
	}
}
