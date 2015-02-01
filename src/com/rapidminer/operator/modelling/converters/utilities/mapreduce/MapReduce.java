package com.rapidminer.operator.modelling.converters.utilities.mapreduce;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapReduce {
	
	public static <S,T> List<T> map(Iterator<S> iterator, Mappable<S,T> mappable) throws MapReduceException {
		List<T> outIterable = new ArrayList<T>();
		while(iterator.hasNext())
			outIterable.add(mappable.apply(iterator.next()));
		return outIterable;
	}
	
	public static <S,T> List<T> map(List<S> list, Mappable<S,T> mappable) throws MapReduceException {
		return map(list.iterator(), mappable);
	}
	
	public static <S,T> T reduce(Iterator<S> iterator, Reducer<S,T> combiner) throws MapReduceException {
		T out = null;
		while (iterator.hasNext()) {
			S element = iterator.next();
			out = (out==null)?
					combiner.reduce(element):
						combiner.reduce(out, element);
		}
		return out;
	}
	
	public static <S,T> T reduce(List<S> list, Reducer<S,T> combiner) throws MapReduceException {
		T out = null;
		for (S element: list) {
			out = (out==null)?
					combiner.reduce(element):
						combiner.reduce(out, element);
		}
		return out;
	}
	
	public static <S, T> List<List<T>> listMap(Iterator<Iterator<S>> iterators, Iterator<Mappable<S,T>> 
		mappables) throws MapReduceException {
		List<List<T>> outLists = new ArrayList<List<T>>();
		while (iterators.hasNext() && mappables.hasNext()) {
			outLists.add(MapReduce.map(iterators.next(), mappables.next()));
		}
		return outLists;
	}
	
	public static <S, T> List<T> listReduce(Iterator<Iterator<S>> iterators, Iterator<Reducer<S,T>> reducers) 
		throws MapReduceException {
		List<T> outList = new ArrayList<T>();
		while (iterators.hasNext() && reducers.hasNext()) {
				outList.add(MapReduce.reduce(iterators.next(), reducers.next()));
		}
		return outList;
	}
	
	public static <T> List<T> filter(List<T> list, Filter<T> filter) throws MapReduceException {
		List<T> outList = new ArrayList<T>();
		for (T element: list) {
			if (filter.test(element))
				outList.add(element);
		}
		return outList;
	}
	
	public static <T> List<T> filter(Iterator<T> iterator, Filter<T> filter) throws MapReduceException {
		List<T> outList = new ArrayList<T>();
		T element;
		while (iterator.hasNext()) {
			element = iterator.next();
			if (filter.test(element))
				outList.add(element);
		}
		return outList;
	}
	
}
