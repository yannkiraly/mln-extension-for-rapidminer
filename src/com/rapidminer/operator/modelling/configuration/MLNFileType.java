package com.rapidminer.operator.modelling.configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.modelling.configuration.xmlimportexport.ConfigurationReader;
import com.rapidminer.operator.modelling.converters.MLNConverter;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.ArrayIterator;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.Filter;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduce;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;


public class MLNFileType {
	
	static {
		instances = new HashMap<String, MLNFileType>();
	}
	
	/**
	 * Returns all MLN file types extracted from MLNFileTypeSpecifications.xml.
	 * 
	 * @return MLNFileType[]: MLN file types extracted from MLNFileTypeSpecifications.xml.
	 */
	public static MLNFileType[] values() {
		return instances.values().toArray(new MLNFileType[instances.size()]);
	}
	
	/**
	 * Clears all MLN engine values.
	 */
	public static void clearValues() {
		instances = new HashMap<String, MLNFileType>();
	}
	
	/**
	 * Returns an MLN filetpye for the provided key if it has been defined.
	 * 
	 * @param key: String representing the MLN file type to be returned.
	 * @return MLNFileType: File type associated with the key.
	 */
	public static MLNFileType fromKey(String key) {
		return instances.get(key);
	}
	
	private static void addInstance(MLNFileType engine) {
		instances.put(engine.getKey(), engine);
	}
	
	private static Map<String, MLNFileType> instances;
	
	private String key;
	private boolean queryAtomFileType;
	private boolean supportsLEConstraintConversion;
	private boolean supportsUnsupportedConstraintRemoval;
	
	/**
	 * Key used to save an MLN file type in meta data.
	 */
	public static final String METADATA_KEY = "file type";
	private boolean nonEvidenceAtomFileType;
	private Class<? extends MLNConverter> converter;
	
	/**
	 * Instantiates a new MLNEngine. To be used by {@link ConfigurationReader}.
	 * 
	 * @param key
	 * @param converter
	 * @param queryAtomFileType
	 * @param nonEvidenceAtomFileType
	 */
	public MLNFileType(String key, MLNConverter converter, 
			boolean queryAtomFileType, boolean nonEvidenceAtomFileType,
			boolean supportsLEConstraintConversion, boolean supportsUnsupportedConstraintRemoval) {
		this.key = key;
		this.converter = converter.getClass();
		this.queryAtomFileType = queryAtomFileType;
		this.nonEvidenceAtomFileType = nonEvidenceAtomFileType;
		this.supportsLEConstraintConversion = supportsLEConstraintConversion;
		this.supportsUnsupportedConstraintRemoval = supportsUnsupportedConstraintRemoval;
		addInstance(this);
	}
	
	/**
	 * Returns the MLN file type's key.
	 * 
	 * @return String: Key of the MLN file type
	 */
	public String getKey() {
		return key;
	}
	
	/**
	 * Returns true if the file type supports query atoms.
	 * 
	 * @return boolean: Whether or not the file type supports query atoms.
	 */
	public boolean isQueryAtomFileType() {
		return queryAtomFileType;
	}
	
	/**
	 * Returns the MLNFileType instances that support query atoms.
	 * 
	 * @return List<MLNFileType>: File types that support query atoms.
	 * @throws OperatorException
	 */
	public static List<MLNFileType> getQueryAtomFileTypes() throws OperatorException {
		try {
			return MapReduce.filter(new ArrayIterator<MLNFileType>(values()), new Filter<MLNFileType>() {
				@Override
				public boolean test(MLNFileType object) {
					if (object.isQueryAtomFileType())
						return true;
					else
						return false;	
				}	
			});
		} catch (MapReduceException e) {
			throw new OperatorException(e.getMessage());
		}
	}
	
	/**
	 * Returns true if the file type supports non-evidence atoms.
	 * 
	 * @return boolean: Whether or not the file type supports non-evidence atoms.
	 */
	public boolean isNonEvidenceAtomFileType() {
		return nonEvidenceAtomFileType;
	}

	/**
	 * Returns the converter class associated with the file type in MLNFileTypeSpecifications.xml.
	 * 
	 * @return Class<? extends MLNConverter>: Class of converter for this file type.
	 */
	public Class<? extends MLNConverter> getConverter() {
		return converter;
	}

	public boolean supportsLEConstraintConversion() {
		return supportsLEConstraintConversion;
	}
	
	public boolean supportsUnsupportedConstraintRemoval() {
		return supportsUnsupportedConstraintRemoval;
	}

}
