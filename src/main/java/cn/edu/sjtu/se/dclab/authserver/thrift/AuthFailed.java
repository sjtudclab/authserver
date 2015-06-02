/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package cn.edu.sjtu.se.dclab.authserver.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
/**
 * Structs can also be exceptions, if they are nasty.
 */
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-6-1")
public class AuthFailed extends TException implements org.apache.thrift.TBase<AuthFailed, AuthFailed._Fields>, java.io.Serializable, Cloneable, Comparable<AuthFailed> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("AuthFailed");

  private static final org.apache.thrift.protocol.TField REASON_FIELD_DESC = new org.apache.thrift.protocol.TField("reason", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField FAILURE_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("failureCode", org.apache.thrift.protocol.TType.I16, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new AuthFailedStandardSchemeFactory());
    schemes.put(TupleScheme.class, new AuthFailedTupleSchemeFactory());
  }

  public String reason; // required
  public short failureCode; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    REASON((short)1, "reason"),
    FAILURE_CODE((short)2, "failureCode");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // REASON
          return REASON;
        case 2: // FAILURE_CODE
          return FAILURE_CODE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __FAILURECODE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.REASON, new org.apache.thrift.meta_data.FieldMetaData("reason", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FAILURE_CODE, new org.apache.thrift.meta_data.FieldMetaData("failureCode", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AuthFailed.class, metaDataMap);
  }

  public AuthFailed() {
  }

  public AuthFailed(
    String reason,
    short failureCode)
  {
    this();
    this.reason = reason;
    this.failureCode = failureCode;
    setFailureCodeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public AuthFailed(AuthFailed other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetReason()) {
      this.reason = other.reason;
    }
    this.failureCode = other.failureCode;
  }

  public AuthFailed deepCopy() {
    return new AuthFailed(this);
  }

  @Override
  public void clear() {
    this.reason = null;
    setFailureCodeIsSet(false);
    this.failureCode = 0;
  }

  public String getReason() {
    return this.reason;
  }

  public AuthFailed setReason(String reason) {
    this.reason = reason;
    return this;
  }

  public void unsetReason() {
    this.reason = null;
  }

  /** Returns true if field reason is set (has been assigned a value) and false otherwise */
  public boolean isSetReason() {
    return this.reason != null;
  }

  public void setReasonIsSet(boolean value) {
    if (!value) {
      this.reason = null;
    }
  }

  public short getFailureCode() {
    return this.failureCode;
  }

  public AuthFailed setFailureCode(short failureCode) {
    this.failureCode = failureCode;
    setFailureCodeIsSet(true);
    return this;
  }

  public void unsetFailureCode() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __FAILURECODE_ISSET_ID);
  }

  /** Returns true if field failureCode is set (has been assigned a value) and false otherwise */
  public boolean isSetFailureCode() {
    return EncodingUtils.testBit(__isset_bitfield, __FAILURECODE_ISSET_ID);
  }

  public void setFailureCodeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __FAILURECODE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case REASON:
      if (value == null) {
        unsetReason();
      } else {
        setReason((String)value);
      }
      break;

    case FAILURE_CODE:
      if (value == null) {
        unsetFailureCode();
      } else {
        setFailureCode((Short)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case REASON:
      return getReason();

    case FAILURE_CODE:
      return Short.valueOf(getFailureCode());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case REASON:
      return isSetReason();
    case FAILURE_CODE:
      return isSetFailureCode();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof AuthFailed)
      return this.equals((AuthFailed)that);
    return false;
  }

  public boolean equals(AuthFailed that) {
    if (that == null)
      return false;

    boolean this_present_reason = true && this.isSetReason();
    boolean that_present_reason = true && that.isSetReason();
    if (this_present_reason || that_present_reason) {
      if (!(this_present_reason && that_present_reason))
        return false;
      if (!this.reason.equals(that.reason))
        return false;
    }

    boolean this_present_failureCode = true;
    boolean that_present_failureCode = true;
    if (this_present_failureCode || that_present_failureCode) {
      if (!(this_present_failureCode && that_present_failureCode))
        return false;
      if (this.failureCode != that.failureCode)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_reason = true && (isSetReason());
    list.add(present_reason);
    if (present_reason)
      list.add(reason);

    boolean present_failureCode = true;
    list.add(present_failureCode);
    if (present_failureCode)
      list.add(failureCode);

    return list.hashCode();
  }

  @Override
  public int compareTo(AuthFailed other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetReason()).compareTo(other.isSetReason());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReason()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.reason, other.reason);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFailureCode()).compareTo(other.isSetFailureCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFailureCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.failureCode, other.failureCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("AuthFailed(");
    boolean first = true;

    sb.append("reason:");
    if (this.reason == null) {
      sb.append("null");
    } else {
      sb.append(this.reason);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("failureCode:");
    sb.append(this.failureCode);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class AuthFailedStandardSchemeFactory implements SchemeFactory {
    public AuthFailedStandardScheme getScheme() {
      return new AuthFailedStandardScheme();
    }
  }

  private static class AuthFailedStandardScheme extends StandardScheme<AuthFailed> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, AuthFailed struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // REASON
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.reason = iprot.readString();
              struct.setReasonIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // FAILURE_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
              struct.failureCode = iprot.readI16();
              struct.setFailureCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, AuthFailed struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.reason != null) {
        oprot.writeFieldBegin(REASON_FIELD_DESC);
        oprot.writeString(struct.reason);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(FAILURE_CODE_FIELD_DESC);
      oprot.writeI16(struct.failureCode);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class AuthFailedTupleSchemeFactory implements SchemeFactory {
    public AuthFailedTupleScheme getScheme() {
      return new AuthFailedTupleScheme();
    }
  }

  private static class AuthFailedTupleScheme extends TupleScheme<AuthFailed> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, AuthFailed struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetReason()) {
        optionals.set(0);
      }
      if (struct.isSetFailureCode()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetReason()) {
        oprot.writeString(struct.reason);
      }
      if (struct.isSetFailureCode()) {
        oprot.writeI16(struct.failureCode);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, AuthFailed struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.reason = iprot.readString();
        struct.setReasonIsSet(true);
      }
      if (incoming.get(1)) {
        struct.failureCode = iprot.readI16();
        struct.setFailureCodeIsSet(true);
      }
    }
  }

}

