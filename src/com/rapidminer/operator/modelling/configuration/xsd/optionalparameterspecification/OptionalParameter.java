//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.17 at 05:31:15 PM CET 
//


package com.rapidminer.operator.modelling.configuration.xsd.optionalparameterspecification;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for optionalParameter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="optionalParameter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mlnEngines">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mlnEngine" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="categories" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="category" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="parameterConditions" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="parameterCondition" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="key" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="description" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="flag" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="numberOfArguments" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="inferenceArgument" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="learnArgument" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="expert" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="minInt" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="maxInt" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="defaultCategoryIndex" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="defaultInt" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="defaultBoolean" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="parameterType" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="INT"/>
 *             &lt;enumeration value="STRING"/>
 *             &lt;enumeration value="CATEGORY"/>
 *             &lt;enumeration value="LIST"/>
 *             &lt;enumeration value="BOOLEAN"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "optionalParameter", propOrder = {
    "mlnEngines",
    "categories",
    "parameterConditions"
})
public class OptionalParameter {

    @XmlElement(required = true)
    protected OptionalParameter.MlnEngines mlnEngines;
    protected OptionalParameter.Categories categories;
    protected OptionalParameter.ParameterConditions parameterConditions;
    @XmlAttribute(name = "key", required = true)
    protected String key;
    @XmlAttribute(name = "description", required = true)
    protected String description;
    @XmlAttribute(name = "flag")
    protected String flag;
    @XmlAttribute(name = "numberOfArguments", required = true)
    protected int numberOfArguments;
    @XmlAttribute(name = "inferenceArgument", required = true)
    protected boolean inferenceArgument;
    @XmlAttribute(name = "learnArgument", required = true)
    protected boolean learnArgument;
    @XmlAttribute(name = "expert", required = true)
    protected boolean expert;
    @XmlAttribute(name = "minInt")
    protected Integer minInt;
    @XmlAttribute(name = "maxInt")
    protected Integer maxInt;
    @XmlAttribute(name = "defaultCategoryIndex")
    protected Integer defaultCategoryIndex;
    @XmlAttribute(name = "defaultInt")
    protected Integer defaultInt;
    @XmlAttribute(name = "defaultBoolean")
    protected Boolean defaultBoolean;
    @XmlAttribute(name = "parameterType", required = true)
    protected String parameterType;

    /**
     * Gets the value of the mlnEngines property.
     * 
     * @return
     *     possible object is
     *     {@link OptionalParameter.MlnEngines }
     *     
     */
    public OptionalParameter.MlnEngines getMlnEngines() {
        return mlnEngines;
    }

    /**
     * Sets the value of the mlnEngines property.
     * 
     * @param value
     *     allowed object is
     *     {@link OptionalParameter.MlnEngines }
     *     
     */
    public void setMlnEngines(OptionalParameter.MlnEngines value) {
        this.mlnEngines = value;
    }

    /**
     * Gets the value of the categories property.
     * 
     * @return
     *     possible object is
     *     {@link OptionalParameter.Categories }
     *     
     */
    public OptionalParameter.Categories getCategories() {
        return categories;
    }

    /**
     * Sets the value of the categories property.
     * 
     * @param value
     *     allowed object is
     *     {@link OptionalParameter.Categories }
     *     
     */
    public void setCategories(OptionalParameter.Categories value) {
        this.categories = value;
    }

    /**
     * Gets the value of the parameterConditions property.
     * 
     * @return
     *     possible object is
     *     {@link OptionalParameter.ParameterConditions }
     *     
     */
    public OptionalParameter.ParameterConditions getParameterConditions() {
        return parameterConditions;
    }

    /**
     * Sets the value of the parameterConditions property.
     * 
     * @param value
     *     allowed object is
     *     {@link OptionalParameter.ParameterConditions }
     *     
     */
    public void setParameterConditions(OptionalParameter.ParameterConditions value) {
        this.parameterConditions = value;
    }

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the flag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlag() {
        return flag;
    }

    /**
     * Sets the value of the flag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlag(String value) {
        this.flag = value;
    }

    /**
     * Gets the value of the numberOfArguments property.
     * 
     */
    public int getNumberOfArguments() {
        return numberOfArguments;
    }

    /**
     * Sets the value of the numberOfArguments property.
     * 
     */
    public void setNumberOfArguments(int value) {
        this.numberOfArguments = value;
    }

    /**
     * Gets the value of the inferenceArgument property.
     * 
     */
    public boolean isInferenceArgument() {
        return inferenceArgument;
    }

    /**
     * Sets the value of the inferenceArgument property.
     * 
     */
    public void setInferenceArgument(boolean value) {
        this.inferenceArgument = value;
    }

    /**
     * Gets the value of the learnArgument property.
     * 
     */
    public boolean isLearnArgument() {
        return learnArgument;
    }

    /**
     * Sets the value of the learnArgument property.
     * 
     */
    public void setLearnArgument(boolean value) {
        this.learnArgument = value;
    }

    /**
     * Gets the value of the expert property.
     * 
     */
    public boolean isExpert() {
        return expert;
    }

    /**
     * Sets the value of the expert property.
     * 
     */
    public void setExpert(boolean value) {
        this.expert = value;
    }

    /**
     * Gets the value of the minInt property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinInt() {
        return minInt;
    }

    /**
     * Sets the value of the minInt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinInt(Integer value) {
        this.minInt = value;
    }

    /**
     * Gets the value of the maxInt property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxInt() {
        return maxInt;
    }

    /**
     * Sets the value of the maxInt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxInt(Integer value) {
        this.maxInt = value;
    }

    /**
     * Gets the value of the defaultCategoryIndex property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDefaultCategoryIndex() {
        return defaultCategoryIndex;
    }

    /**
     * Sets the value of the defaultCategoryIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDefaultCategoryIndex(Integer value) {
        this.defaultCategoryIndex = value;
    }

    /**
     * Gets the value of the defaultInt property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDefaultInt() {
        return defaultInt;
    }

    /**
     * Sets the value of the defaultInt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDefaultInt(Integer value) {
        this.defaultInt = value;
    }

    /**
     * Gets the value of the defaultBoolean property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDefaultBoolean() {
        return defaultBoolean;
    }

    /**
     * Sets the value of the defaultBoolean property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDefaultBoolean(Boolean value) {
        this.defaultBoolean = value;
    }

    /**
     * Gets the value of the parameterType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParameterType() {
        return parameterType;
    }

    /**
     * Sets the value of the parameterType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParameterType(String value) {
        this.parameterType = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="category" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "category"
    })
    public static class Categories {

        protected List<OptionalParameter.Categories.Category> category;

        /**
         * Gets the value of the category property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the category property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCategory().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OptionalParameter.Categories.Category }
         * 
         * 
         */
        public List<OptionalParameter.Categories.Category> getCategory() {
            if (category == null) {
                category = new ArrayList<OptionalParameter.Categories.Category>();
            }
            return this.category;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Category {

            @XmlAttribute(name = "label")
            protected String label;

            /**
             * Gets the value of the label property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLabel() {
                return label;
            }

            /**
             * Sets the value of the label property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLabel(String value) {
                this.label = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="mlnEngine" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "mlnEngine"
    })
    public static class MlnEngines {

        @XmlElement(required = true)
        protected List<OptionalParameter.MlnEngines.MlnEngine> mlnEngine;

        /**
         * Gets the value of the mlnEngine property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mlnEngine property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMlnEngine().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OptionalParameter.MlnEngines.MlnEngine }
         * 
         * 
         */
        public List<OptionalParameter.MlnEngines.MlnEngine> getMlnEngine() {
            if (mlnEngine == null) {
                mlnEngine = new ArrayList<OptionalParameter.MlnEngines.MlnEngine>();
            }
            return this.mlnEngine;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class MlnEngine {

            @XmlAttribute(name = "key")
            protected String key;

            /**
             * Gets the value of the key property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKey() {
                return key;
            }

            /**
             * Sets the value of the key property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKey(String value) {
                this.key = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="parameterCondition" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "parameterCondition"
    })
    public static class ParameterConditions {

        protected List<OptionalParameter.ParameterConditions.ParameterCondition> parameterCondition;

        /**
         * Gets the value of the parameterCondition property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the parameterCondition property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getParameterCondition().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OptionalParameter.ParameterConditions.ParameterCondition }
         * 
         * 
         */
        public List<OptionalParameter.ParameterConditions.ParameterCondition> getParameterCondition() {
            if (parameterCondition == null) {
                parameterCondition = new ArrayList<OptionalParameter.ParameterConditions.ParameterCondition>();
            }
            return this.parameterCondition;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class ParameterCondition {

            @XmlAttribute(name = "class")
            protected String clazz;

            /**
             * Gets the value of the clazz property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getClazz() {
                return clazz;
            }

            /**
             * Sets the value of the clazz property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setClazz(String value) {
                this.clazz = value;
            }

        }

    }

}
