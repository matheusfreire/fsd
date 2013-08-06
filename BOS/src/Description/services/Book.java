/**
 * Book.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Description.services;

public class Book  implements java.io.Serializable {
    private java.lang.Boolean status;

    private Description description;

    private java.math.BigInteger collection_id;

    public Book() {
    }

    public Book(
           java.lang.Boolean status,
           Description description,
           java.math.BigInteger collection_id) {
           this.status = status;
           this.description = description;
           this.collection_id = collection_id;
    }


    /**
     * Gets the status value for this Book.
     * 
     * @return status
     */
    public java.lang.Boolean getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Book.
     * 
     * @param status
     */
    public void setStatus(java.lang.Boolean status) {
        this.status = status;
    }


    /**
     * Gets the description value for this Book.
     * 
     * @return description
     */
    public Description getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Book.
     * 
     * @param description
     */
    public void setDescription(Description description) {
        this.description = description;
    }


    /**
     * Gets the collection_id value for this Book.
     * 
     * @return collection_id
     */
    public java.math.BigInteger getCollection_id() {
        return collection_id;
    }


    /**
     * Sets the collection_id value for this Book.
     * 
     * @param collection_id
     */
    public void setCollection_id(java.math.BigInteger collection_id) {
        this.collection_id = collection_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Book)) return false;
        Book other = (Book) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.collection_id==null && other.getCollection_id()==null) || 
             (this.collection_id!=null &&
              this.collection_id.equals(other.getCollection_id())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getCollection_id() != null) {
            _hashCode += getCollection_id().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Book.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("services.Description", "Book"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("services.Description", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("services.Description", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("services.Description", "Description"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("collection_id");
        elemField.setXmlName(new javax.xml.namespace.QName("services.Description", "collection_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
