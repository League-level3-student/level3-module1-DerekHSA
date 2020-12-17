package _02_Integer_Stack;

import java.util.Iterator;

public class IntegerStack {
	private int[] array;
	
	public IntegerStack() {
		array = new int[0];
	}
	
	
	public void push(int v) {
		int[] array2 = new int[array.length+1];
		array2[array.length]=v;
		for (int i = 0; i < array.length; i++) {
			array2[i]=array[i];
		}
		array=array2;
	}
	
	public int pop() {
		int a = array[array.length-1];
		int[] array2 = new int[array.length-1];
		for (int i = 0; i < array2.length; i++) {
			array2[i]=array[i];
		}
		array=array2;
		
		return a;
	}
	
	public void clear() {
		int[] array2 = new int[0];
		array=array2;
	}
	
	
	public int size() {
		return array.length;
	}
}
