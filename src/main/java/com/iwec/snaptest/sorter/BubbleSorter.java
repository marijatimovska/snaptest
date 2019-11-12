package com.iwec.snaptest.sorter;

import java.util.ArrayList;

public class BubbleSorter {
	private int j;

	public <T extends Comparable<T>> void sorter(ArrayList<T> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (j = 1; j < list.size(); j++) {
				if (list == null ||list.isEmpty() || list.size() < 2 ) {
					return;
				} else {
					if ((list.get(j)).compareTo(list.get(j - 1)) < 0) {
						swap(list);
					}
				}
			}
		}
	}

	private <T> void swap(ArrayList<T> list) {
		T temp = list.get(j);
		list.set(j, list.get(j - 1));
		list.set(j - 1, temp);

	}

}
