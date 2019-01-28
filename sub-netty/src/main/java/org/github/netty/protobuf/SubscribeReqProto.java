// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SubscribeReq.proto

package org.github.netty.protobuf;

@SuppressWarnings("ALL")
public final class SubscribeReqProto {
  private SubscribeReqProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface SubscribeReqOrBuilder extends
      // @@protoc_insertion_point(interface_extends:protobuf.SubscribeReq)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 subReqId = 1;</code>
     */
    int getSubReqId();

    /**
     * <code>string username = 2;</code>
     */
    String getUsername();
    /**
     * <code>string username = 2;</code>
     */
    com.google.protobuf.ByteString
        getUsernameBytes();

    /**
     * <code>string password = 3;</code>
     */
    String getPassword();
    /**
     * <code>string password = 3;</code>
     */
    com.google.protobuf.ByteString
        getPasswordBytes();

    /**
     * <code>string productName = 4;</code>
     */
    String getProductName();
    /**
     * <code>string productName = 4;</code>
     */
    com.google.protobuf.ByteString
        getProductNameBytes();

    /**
     * <code>repeated string address = 5;</code>
     */
    java.util.List<String>
        getAddressList();
    /**
     * <code>repeated string address = 5;</code>
     */
    int getAddressCount();
    /**
     * <code>repeated string address = 5;</code>
     */
    String getAddress(int index);
    /**
     * <code>repeated string address = 5;</code>
     */
    com.google.protobuf.ByteString
        getAddressBytes(int index);
  }
  /**
   * Protobuf type {@code protobuf.SubscribeReq}
   */
  public  static final class SubscribeReq extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:protobuf.SubscribeReq)
      SubscribeReqOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use SubscribeReq.newBuilder() to construct.
    private SubscribeReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private SubscribeReq() {
      subReqId_ = 0;
      username_ = "";
      password_ = "";
      productName_ = "";
      address_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private SubscribeReq(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              subReqId_ = input.readInt32();
              break;
            }
            case 18: {
              String s = input.readStringRequireUtf8();

              username_ = s;
              break;
            }
            case 26: {
              String s = input.readStringRequireUtf8();

              password_ = s;
              break;
            }
            case 34: {
              String s = input.readStringRequireUtf8();

              productName_ = s;
              break;
            }
            case 42: {
              String s = input.readStringRequireUtf8();
              if (!((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
                address_ = new com.google.protobuf.LazyStringArrayList();
                mutable_bitField0_ |= 0x00000010;
              }
              address_.add(s);
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
          address_ = address_.getUnmodifiableView();
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.github.netty.protobuf.SubscribeReqProto.internal_static_protobuf_SubscribeReq_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.github.netty.protobuf.SubscribeReqProto.internal_static_protobuf_SubscribeReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.github.netty.protobuf.SubscribeReqProto.SubscribeReq.class, org.github.netty.protobuf.SubscribeReqProto.SubscribeReq.Builder.class);
    }

    private int bitField0_;
    public static final int SUBREQID_FIELD_NUMBER = 1;
    private int subReqId_;
    /**
     * <code>int32 subReqId = 1;</code>
     */
    public int getSubReqId() {
      return subReqId_;
    }

    public static final int USERNAME_FIELD_NUMBER = 2;
    private volatile Object username_;
    /**
     * <code>string username = 2;</code>
     */
    public String getUsername() {
      Object ref = username_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        username_ = s;
        return s;
      }
    }
    /**
     * <code>string username = 2;</code>
     */
    public com.google.protobuf.ByteString
        getUsernameBytes() {
      Object ref = username_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        username_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PASSWORD_FIELD_NUMBER = 3;
    private volatile Object password_;
    /**
     * <code>string password = 3;</code>
     */
    public String getPassword() {
      Object ref = password_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        password_ = s;
        return s;
      }
    }
    /**
     * <code>string password = 3;</code>
     */
    public com.google.protobuf.ByteString
        getPasswordBytes() {
      Object ref = password_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        password_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PRODUCTNAME_FIELD_NUMBER = 4;
    private volatile Object productName_;
    /**
     * <code>string productName = 4;</code>
     */
    public String getProductName() {
      Object ref = productName_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        productName_ = s;
        return s;
      }
    }
    /**
     * <code>string productName = 4;</code>
     */
    public com.google.protobuf.ByteString
        getProductNameBytes() {
      Object ref = productName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        productName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ADDRESS_FIELD_NUMBER = 5;
    private com.google.protobuf.LazyStringList address_;
    /**
     * <code>repeated string address = 5;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getAddressList() {
      return address_;
    }
    /**
     * <code>repeated string address = 5;</code>
     */
    public int getAddressCount() {
      return address_.size();
    }
    /**
     * <code>repeated string address = 5;</code>
     */
    public String getAddress(int index) {
      return address_.get(index);
    }
    /**
     * <code>repeated string address = 5;</code>
     */
    public com.google.protobuf.ByteString
        getAddressBytes(int index) {
      return address_.getByteString(index);
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (subReqId_ != 0) {
        output.writeInt32(1, subReqId_);
      }
      if (!getUsernameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, username_);
      }
      if (!getPasswordBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, password_);
      }
      if (!getProductNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, productName_);
      }
      for (int i = 0; i < address_.size(); i++) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, address_.getRaw(i));
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (subReqId_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, subReqId_);
      }
      if (!getUsernameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, username_);
      }
      if (!getPasswordBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, password_);
      }
      if (!getProductNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, productName_);
      }
      {
        int dataSize = 0;
        for (int i = 0; i < address_.size(); i++) {
          dataSize += computeStringSizeNoTag(address_.getRaw(i));
        }
        size += dataSize;
        size += 1 * getAddressList().size();
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof org.github.netty.protobuf.SubscribeReqProto.SubscribeReq)) {
        return super.equals(obj);
      }
      org.github.netty.protobuf.SubscribeReqProto.SubscribeReq other = (org.github.netty.protobuf.SubscribeReqProto.SubscribeReq) obj;

      boolean result = true;
      result = result && (getSubReqId()
          == other.getSubReqId());
      result = result && getUsername()
          .equals(other.getUsername());
      result = result && getPassword()
          .equals(other.getPassword());
      result = result && getProductName()
          .equals(other.getProductName());
      result = result && getAddressList()
          .equals(other.getAddressList());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + SUBREQID_FIELD_NUMBER;
      hash = (53 * hash) + getSubReqId();
      hash = (37 * hash) + USERNAME_FIELD_NUMBER;
      hash = (53 * hash) + getUsername().hashCode();
      hash = (37 * hash) + PASSWORD_FIELD_NUMBER;
      hash = (53 * hash) + getPassword().hashCode();
      hash = (37 * hash) + PRODUCTNAME_FIELD_NUMBER;
      hash = (53 * hash) + getProductName().hashCode();
      if (getAddressCount() > 0) {
        hash = (37 * hash) + ADDRESS_FIELD_NUMBER;
        hash = (53 * hash) + getAddressList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static org.github.netty.protobuf.SubscribeReqProto.SubscribeReq parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.github.netty.protobuf.SubscribeReqProto.SubscribeReq parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.github.netty.protobuf.SubscribeReqProto.SubscribeReq parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.github.netty.protobuf.SubscribeReqProto.SubscribeReq parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.github.netty.protobuf.SubscribeReqProto.SubscribeReq parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.github.netty.protobuf.SubscribeReqProto.SubscribeReq parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.github.netty.protobuf.SubscribeReqProto.SubscribeReq parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.github.netty.protobuf.SubscribeReqProto.SubscribeReq parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.github.netty.protobuf.SubscribeReqProto.SubscribeReq parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static org.github.netty.protobuf.SubscribeReqProto.SubscribeReq parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.github.netty.protobuf.SubscribeReqProto.SubscribeReq parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.github.netty.protobuf.SubscribeReqProto.SubscribeReq parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(org.github.netty.protobuf.SubscribeReqProto.SubscribeReq prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code protobuf.SubscribeReq}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:protobuf.SubscribeReq)
        org.github.netty.protobuf.SubscribeReqProto.SubscribeReqOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return org.github.netty.protobuf.SubscribeReqProto.internal_static_protobuf_SubscribeReq_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return org.github.netty.protobuf.SubscribeReqProto.internal_static_protobuf_SubscribeReq_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                org.github.netty.protobuf.SubscribeReqProto.SubscribeReq.class, org.github.netty.protobuf.SubscribeReqProto.SubscribeReq.Builder.class);
      }

      // Construct using org.github.netty.protobuf.SubscribeReqProto.SubscribeReq.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        subReqId_ = 0;

        username_ = "";

        password_ = "";

        productName_ = "";

        address_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000010);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return org.github.netty.protobuf.SubscribeReqProto.internal_static_protobuf_SubscribeReq_descriptor;
      }

      public org.github.netty.protobuf.SubscribeReqProto.SubscribeReq getDefaultInstanceForType() {
        return org.github.netty.protobuf.SubscribeReqProto.SubscribeReq.getDefaultInstance();
      }

      public org.github.netty.protobuf.SubscribeReqProto.SubscribeReq build() {
        org.github.netty.protobuf.SubscribeReqProto.SubscribeReq result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public org.github.netty.protobuf.SubscribeReqProto.SubscribeReq buildPartial() {
        org.github.netty.protobuf.SubscribeReqProto.SubscribeReq result = new org.github.netty.protobuf.SubscribeReqProto.SubscribeReq(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        result.subReqId_ = subReqId_;
        result.username_ = username_;
        result.password_ = password_;
        result.productName_ = productName_;
        if (((bitField0_ & 0x00000010) == 0x00000010)) {
          address_ = address_.getUnmodifiableView();
          bitField0_ = (bitField0_ & ~0x00000010);
        }
        result.address_ = address_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof org.github.netty.protobuf.SubscribeReqProto.SubscribeReq) {
          return mergeFrom((org.github.netty.protobuf.SubscribeReqProto.SubscribeReq)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(org.github.netty.protobuf.SubscribeReqProto.SubscribeReq other) {
        if (other == org.github.netty.protobuf.SubscribeReqProto.SubscribeReq.getDefaultInstance()) return this;
        if (other.getSubReqId() != 0) {
          setSubReqId(other.getSubReqId());
        }
        if (!other.getUsername().isEmpty()) {
          username_ = other.username_;
          onChanged();
        }
        if (!other.getPassword().isEmpty()) {
          password_ = other.password_;
          onChanged();
        }
        if (!other.getProductName().isEmpty()) {
          productName_ = other.productName_;
          onChanged();
        }
        if (!other.address_.isEmpty()) {
          if (address_.isEmpty()) {
            address_ = other.address_;
            bitField0_ = (bitField0_ & ~0x00000010);
          } else {
            ensureAddressIsMutable();
            address_.addAll(other.address_);
          }
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        org.github.netty.protobuf.SubscribeReqProto.SubscribeReq parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (org.github.netty.protobuf.SubscribeReqProto.SubscribeReq) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int subReqId_ ;
      /**
       * <code>int32 subReqId = 1;</code>
       */
      public int getSubReqId() {
        return subReqId_;
      }
      /**
       * <code>int32 subReqId = 1;</code>
       */
      public Builder setSubReqId(int value) {

        subReqId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 subReqId = 1;</code>
       */
      public Builder clearSubReqId() {

        subReqId_ = 0;
        onChanged();
        return this;
      }

      private Object username_ = "";
      /**
       * <code>string username = 2;</code>
       */
      public String getUsername() {
        Object ref = username_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          username_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>string username = 2;</code>
       */
      public com.google.protobuf.ByteString
          getUsernameBytes() {
        Object ref = username_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          username_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string username = 2;</code>
       */
      public Builder setUsername(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }

        username_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string username = 2;</code>
       */
      public Builder clearUsername() {

        username_ = getDefaultInstance().getUsername();
        onChanged();
        return this;
      }
      /**
       * <code>string username = 2;</code>
       */
      public Builder setUsernameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);

        username_ = value;
        onChanged();
        return this;
      }

      private Object password_ = "";
      /**
       * <code>string password = 3;</code>
       */
      public String getPassword() {
        Object ref = password_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          password_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>string password = 3;</code>
       */
      public com.google.protobuf.ByteString
          getPasswordBytes() {
        Object ref = password_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          password_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string password = 3;</code>
       */
      public Builder setPassword(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }

        password_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string password = 3;</code>
       */
      public Builder clearPassword() {

        password_ = getDefaultInstance().getPassword();
        onChanged();
        return this;
      }
      /**
       * <code>string password = 3;</code>
       */
      public Builder setPasswordBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);

        password_ = value;
        onChanged();
        return this;
      }

      private Object productName_ = "";
      /**
       * <code>string productName = 4;</code>
       */
      public String getProductName() {
        Object ref = productName_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          productName_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>string productName = 4;</code>
       */
      public com.google.protobuf.ByteString
          getProductNameBytes() {
        Object ref = productName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          productName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string productName = 4;</code>
       */
      public Builder setProductName(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }

        productName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string productName = 4;</code>
       */
      public Builder clearProductName() {

        productName_ = getDefaultInstance().getProductName();
        onChanged();
        return this;
      }
      /**
       * <code>string productName = 4;</code>
       */
      public Builder setProductNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);

        productName_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.LazyStringList address_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      private void ensureAddressIsMutable() {
        if (!((bitField0_ & 0x00000010) == 0x00000010)) {
          address_ = new com.google.protobuf.LazyStringArrayList(address_);
          bitField0_ |= 0x00000010;
         }
      }
      /**
       * <code>repeated string address = 5;</code>
       */
      public com.google.protobuf.ProtocolStringList
          getAddressList() {
        return address_.getUnmodifiableView();
      }
      /**
       * <code>repeated string address = 5;</code>
       */
      public int getAddressCount() {
        return address_.size();
      }
      /**
       * <code>repeated string address = 5;</code>
       */
      public String getAddress(int index) {
        return address_.get(index);
      }
      /**
       * <code>repeated string address = 5;</code>
       */
      public com.google.protobuf.ByteString
          getAddressBytes(int index) {
        return address_.getByteString(index);
      }
      /**
       * <code>repeated string address = 5;</code>
       */
      public Builder setAddress(
          int index, String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureAddressIsMutable();
        address_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string address = 5;</code>
       */
      public Builder addAddress(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureAddressIsMutable();
        address_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string address = 5;</code>
       */
      public Builder addAllAddress(
          Iterable<String> values) {
        ensureAddressIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, address_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string address = 5;</code>
       */
      public Builder clearAddress() {
        address_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000010);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string address = 5;</code>
       */
      public Builder addAddressBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        ensureAddressIsMutable();
        address_.add(value);
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:protobuf.SubscribeReq)
    }

    // @@protoc_insertion_point(class_scope:protobuf.SubscribeReq)
    private static final org.github.netty.protobuf.SubscribeReqProto.SubscribeReq DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new org.github.netty.protobuf.SubscribeReqProto.SubscribeReq();
    }

    public static org.github.netty.protobuf.SubscribeReqProto.SubscribeReq getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<SubscribeReq>
        PARSER = new com.google.protobuf.AbstractParser<SubscribeReq>() {
      public SubscribeReq parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new SubscribeReq(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<SubscribeReq> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<SubscribeReq> getParserForType() {
      return PARSER;
    }

    public org.github.netty.protobuf.SubscribeReqProto.SubscribeReq getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_protobuf_SubscribeReq_descriptor;
  private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_protobuf_SubscribeReq_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\022SubscribeReq.proto\022\010protobuf\"j\n\014Subscr" +
      "ibeReq\022\020\n\010subReqId\030\001 \001(\005\022\020\n\010username\030\002 \001" +
      "(\t\022\020\n\010password\030\003 \001(\t\022\023\n\013productName\030\004 \001(" +
      "\t\022\017\n\007address\030\005 \003(\tB(\n\023org.github.protobu" +
      "fB\021SubscribeReqProtob\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_protobuf_SubscribeReq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_protobuf_SubscribeReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_protobuf_SubscribeReq_descriptor,
        new String[] { "SubReqId", "Username", "Password", "ProductName", "Address", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
