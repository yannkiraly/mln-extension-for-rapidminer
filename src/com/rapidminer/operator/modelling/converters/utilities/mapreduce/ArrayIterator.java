package com.rapidminer.operator.modelling.converters.utilities.mapreduce;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
	private E[] arr;
	private int counter;
	
	public ArrayIterator(E[] arr) {
		this.arr = arr;
		counter = -1;
	}
	
	@Override
	public boolean hasNext() {
		return (counter < (arr.length-1));
	}

	@Override
	public E next() {
		counter++;
		return arr[counter];
	}

}
