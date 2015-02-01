package com.rapidminer.operator.modelling.converters.utilities;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduce;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.Mappable;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.Reducer;
import com.rapidminer.operator.modelling.model.MLNNamedObject;

public class ConverterUtilities {
	public static final String NEW_LINE = "\n", SPACE = " ", EQUALS = "=", EXCL = "!",
			SQUARE_BRACKET_LEFT="{", SQUARE_BRACKET_RIGHT = "}", PARENTHESIS_LEFT = "(",
			PARENTHESIS_RIGHT=")", TRUE="true", FALSE="false", STAR="*", COLON = ":",
			PERIOD = ".", CLASS_CAST_ERROR = "Attempted to compose list of different objects.";
	
	public static String listToString(List<String> strings, String separator) throws MLNException {
		final String sep = separator;
		try {
			String str = MapReduce.reduce(strings, new Reducer<String, String>() {
				@Override
				public String reduce(String existingCombination, String newElement) {
					StringBuilder sb = new StringBuilder();
					sb.append(existingCombination);
					sb.append(sep);
					sb.append(newElement);
					return sb.toString();
				}
	
				@Override
				public String reduce(String firstElement) {
					return firstElement;
				}
			});
			if (str == null)
				str ="";
			return str;
		} catch (MapReduceException e) {
			throw new MLNException(e.getMessage());
		}
	}
	
	public static String safeToString(Double number) {
		DecimalFormat df = new DecimalFormat("#.#############");
		return df.format(number);
	}
	
	public static <S> List<String> namedMlnObjectsToStrings(List<S> objects) throws MLNException {
		try {
			return MapReduce.map(objects, new Mappable<S, String>() {
				@Override
				public String apply(S object)  {
					if (object instanceof MLNNamedObject) {
						return ((MLNNamedObject) object).getName();
					} else {
						return null;
					}
				}
			});
		} catch (MapReduceException e) {
			throw new MLNException(e.getMessage());
		}
	}

	public static List<String> doubleListToString(List<Double> doubles) throws MLNException {
		try {
			return MapReduce.map(doubles, 
					new Mappable<Double, String>() {
				@Override
				public String apply(Double obj) throws MapReduceException {
					return obj.toString();
				}
			});
		} catch (MapReduceException e) {
			throw new MLNException(e.getMessage());
		}
	}
	
	public static List<String> integerListToString(List<Integer> integers) throws MLNException {
		try {
			return MapReduce.map(integers, 
					new Mappable<Integer, String>() {
				@Override
				public String apply(Integer obj) throws MapReduceException {
					return obj.toString();
				}
			});
		} catch (MapReduceException e) {
			throw new MLNException(e.getMessage(), e);
		}
	}
	
	public static List<Integer> doublesToIntegers(List<Double> doubles) throws 
		MLNException {
		try {
			return MapReduce.map(doubles, 
					new Mappable<Double, Integer>() {
				@Override
				public Integer apply(Double obj) {
					return obj.intValue();
				}
			});
		} catch (MapReduceException e) {
			throw new MLNException(e.getMessage());
		}
	}

	public static String buildString(String... strings) {
		StringBuilder sb = new StringBuilder();
		for (String str: strings) {
			if (str != null) {
				sb.append(str);
			}
		}
		return sb.toString();
	}

	public static String parenthesize(String text) {
		return buildString(PARENTHESIS_LEFT, text, PARENTHESIS_RIGHT);
	}
	
	public static String squareBracket(String text) {
		return buildString(SQUARE_BRACKET_LEFT, text, SQUARE_BRACKET_RIGHT);
	}
	
	public static String space(String text) {
		return buildString(SPACE, text, SPACE);
	}
	
	//TODO: Check if needed.
	@SafeVarargs
	public static <T> List<T> compose(T... elements) {
		//TODO: Add unit test to test exception.
		List<T> list = new ArrayList<T>();
		for (T element: elements) {
			try {
				list.add(element);
			} catch (ClassCastException e) {
				throw new RuntimeException(e);
			}
		}
		return list;
	}

	public static <T> List<T> addElement(List<T> list, T element) {
		list.add(element);
		return list;
	}

	public static <T> List<T> addElement(T element) {
		List<T> list = new ArrayList<T>();
		list.add(element);
		return list;
	}
	
	public static <T> boolean arrayContains(T[] arr, T key) {
		Arrays.sort(arr);
		return (Arrays.binarySearch(arr, key)>=0);
	}
	
}
