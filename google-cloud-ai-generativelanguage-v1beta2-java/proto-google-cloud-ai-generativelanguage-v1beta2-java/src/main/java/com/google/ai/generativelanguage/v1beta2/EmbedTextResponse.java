// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ai/generativelanguage/v1beta2/text_service.proto

package com.google.ai.generativelanguage.v1beta2;

/**
 * <pre>
 * The response to a EmbedTextRequest.
 * </pre>
 *
 * Protobuf type {@code google.ai.generativelanguage.v1beta2.EmbedTextResponse}
 */
public final class EmbedTextResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:google.ai.generativelanguage.v1beta2.EmbedTextResponse)
    EmbedTextResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use EmbedTextResponse.newBuilder() to construct.
  private EmbedTextResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private EmbedTextResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new EmbedTextResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.google.ai.generativelanguage.v1beta2.TextServiceProto.internal_static_google_ai_generativelanguage_v1beta2_EmbedTextResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.ai.generativelanguage.v1beta2.TextServiceProto.internal_static_google_ai_generativelanguage_v1beta2_EmbedTextResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.ai.generativelanguage.v1beta2.EmbedTextResponse.class, com.google.ai.generativelanguage.v1beta2.EmbedTextResponse.Builder.class);
  }

  private int bitField0_;
  public static final int EMBEDDING_FIELD_NUMBER = 1;
  private com.google.ai.generativelanguage.v1beta2.Embedding embedding_;
  /**
   * <pre>
   * Output only. The embedding generated from the input text.
   * </pre>
   *
   * <code>optional .google.ai.generativelanguage.v1beta2.Embedding embedding = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return Whether the embedding field is set.
   */
  @java.lang.Override
  public boolean hasEmbedding() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <pre>
   * Output only. The embedding generated from the input text.
   * </pre>
   *
   * <code>optional .google.ai.generativelanguage.v1beta2.Embedding embedding = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return The embedding.
   */
  @java.lang.Override
  public com.google.ai.generativelanguage.v1beta2.Embedding getEmbedding() {
    return embedding_ == null ? com.google.ai.generativelanguage.v1beta2.Embedding.getDefaultInstance() : embedding_;
  }
  /**
   * <pre>
   * Output only. The embedding generated from the input text.
   * </pre>
   *
   * <code>optional .google.ai.generativelanguage.v1beta2.Embedding embedding = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   */
  @java.lang.Override
  public com.google.ai.generativelanguage.v1beta2.EmbeddingOrBuilder getEmbeddingOrBuilder() {
    return embedding_ == null ? com.google.ai.generativelanguage.v1beta2.Embedding.getDefaultInstance() : embedding_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(1, getEmbedding());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getEmbedding());
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.google.ai.generativelanguage.v1beta2.EmbedTextResponse)) {
      return super.equals(obj);
    }
    com.google.ai.generativelanguage.v1beta2.EmbedTextResponse other = (com.google.ai.generativelanguage.v1beta2.EmbedTextResponse) obj;

    if (hasEmbedding() != other.hasEmbedding()) return false;
    if (hasEmbedding()) {
      if (!getEmbedding()
          .equals(other.getEmbedding())) return false;
    }
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasEmbedding()) {
      hash = (37 * hash) + EMBEDDING_FIELD_NUMBER;
      hash = (53 * hash) + getEmbedding().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.ai.generativelanguage.v1beta2.EmbedTextResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.ai.generativelanguage.v1beta2.EmbedTextResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.ai.generativelanguage.v1beta2.EmbedTextResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.ai.generativelanguage.v1beta2.EmbedTextResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.ai.generativelanguage.v1beta2.EmbedTextResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.ai.generativelanguage.v1beta2.EmbedTextResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.ai.generativelanguage.v1beta2.EmbedTextResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.ai.generativelanguage.v1beta2.EmbedTextResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.ai.generativelanguage.v1beta2.EmbedTextResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.google.ai.generativelanguage.v1beta2.EmbedTextResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.ai.generativelanguage.v1beta2.EmbedTextResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.ai.generativelanguage.v1beta2.EmbedTextResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.google.ai.generativelanguage.v1beta2.EmbedTextResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * The response to a EmbedTextRequest.
   * </pre>
   *
   * Protobuf type {@code google.ai.generativelanguage.v1beta2.EmbedTextResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.ai.generativelanguage.v1beta2.EmbedTextResponse)
      com.google.ai.generativelanguage.v1beta2.EmbedTextResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.ai.generativelanguage.v1beta2.TextServiceProto.internal_static_google_ai_generativelanguage_v1beta2_EmbedTextResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.ai.generativelanguage.v1beta2.TextServiceProto.internal_static_google_ai_generativelanguage_v1beta2_EmbedTextResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.ai.generativelanguage.v1beta2.EmbedTextResponse.class, com.google.ai.generativelanguage.v1beta2.EmbedTextResponse.Builder.class);
    }

    // Construct using com.google.ai.generativelanguage.v1beta2.EmbedTextResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getEmbeddingFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      embedding_ = null;
      if (embeddingBuilder_ != null) {
        embeddingBuilder_.dispose();
        embeddingBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.ai.generativelanguage.v1beta2.TextServiceProto.internal_static_google_ai_generativelanguage_v1beta2_EmbedTextResponse_descriptor;
    }

    @java.lang.Override
    public com.google.ai.generativelanguage.v1beta2.EmbedTextResponse getDefaultInstanceForType() {
      return com.google.ai.generativelanguage.v1beta2.EmbedTextResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.ai.generativelanguage.v1beta2.EmbedTextResponse build() {
      com.google.ai.generativelanguage.v1beta2.EmbedTextResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.ai.generativelanguage.v1beta2.EmbedTextResponse buildPartial() {
      com.google.ai.generativelanguage.v1beta2.EmbedTextResponse result = new com.google.ai.generativelanguage.v1beta2.EmbedTextResponse(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.google.ai.generativelanguage.v1beta2.EmbedTextResponse result) {
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.embedding_ = embeddingBuilder_ == null
            ? embedding_
            : embeddingBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.ai.generativelanguage.v1beta2.EmbedTextResponse) {
        return mergeFrom((com.google.ai.generativelanguage.v1beta2.EmbedTextResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.ai.generativelanguage.v1beta2.EmbedTextResponse other) {
      if (other == com.google.ai.generativelanguage.v1beta2.EmbedTextResponse.getDefaultInstance()) return this;
      if (other.hasEmbedding()) {
        mergeEmbedding(other.getEmbedding());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              input.readMessage(
                  getEmbeddingFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private com.google.ai.generativelanguage.v1beta2.Embedding embedding_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.ai.generativelanguage.v1beta2.Embedding, com.google.ai.generativelanguage.v1beta2.Embedding.Builder, com.google.ai.generativelanguage.v1beta2.EmbeddingOrBuilder> embeddingBuilder_;
    /**
     * <pre>
     * Output only. The embedding generated from the input text.
     * </pre>
     *
     * <code>optional .google.ai.generativelanguage.v1beta2.Embedding embedding = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     * @return Whether the embedding field is set.
     */
    public boolean hasEmbedding() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <pre>
     * Output only. The embedding generated from the input text.
     * </pre>
     *
     * <code>optional .google.ai.generativelanguage.v1beta2.Embedding embedding = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     * @return The embedding.
     */
    public com.google.ai.generativelanguage.v1beta2.Embedding getEmbedding() {
      if (embeddingBuilder_ == null) {
        return embedding_ == null ? com.google.ai.generativelanguage.v1beta2.Embedding.getDefaultInstance() : embedding_;
      } else {
        return embeddingBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * Output only. The embedding generated from the input text.
     * </pre>
     *
     * <code>optional .google.ai.generativelanguage.v1beta2.Embedding embedding = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     */
    public Builder setEmbedding(com.google.ai.generativelanguage.v1beta2.Embedding value) {
      if (embeddingBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        embedding_ = value;
      } else {
        embeddingBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Output only. The embedding generated from the input text.
     * </pre>
     *
     * <code>optional .google.ai.generativelanguage.v1beta2.Embedding embedding = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     */
    public Builder setEmbedding(
        com.google.ai.generativelanguage.v1beta2.Embedding.Builder builderForValue) {
      if (embeddingBuilder_ == null) {
        embedding_ = builderForValue.build();
      } else {
        embeddingBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Output only. The embedding generated from the input text.
     * </pre>
     *
     * <code>optional .google.ai.generativelanguage.v1beta2.Embedding embedding = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     */
    public Builder mergeEmbedding(com.google.ai.generativelanguage.v1beta2.Embedding value) {
      if (embeddingBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          embedding_ != null &&
          embedding_ != com.google.ai.generativelanguage.v1beta2.Embedding.getDefaultInstance()) {
          getEmbeddingBuilder().mergeFrom(value);
        } else {
          embedding_ = value;
        }
      } else {
        embeddingBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Output only. The embedding generated from the input text.
     * </pre>
     *
     * <code>optional .google.ai.generativelanguage.v1beta2.Embedding embedding = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     */
    public Builder clearEmbedding() {
      bitField0_ = (bitField0_ & ~0x00000001);
      embedding_ = null;
      if (embeddingBuilder_ != null) {
        embeddingBuilder_.dispose();
        embeddingBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Output only. The embedding generated from the input text.
     * </pre>
     *
     * <code>optional .google.ai.generativelanguage.v1beta2.Embedding embedding = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     */
    public com.google.ai.generativelanguage.v1beta2.Embedding.Builder getEmbeddingBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getEmbeddingFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * Output only. The embedding generated from the input text.
     * </pre>
     *
     * <code>optional .google.ai.generativelanguage.v1beta2.Embedding embedding = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     */
    public com.google.ai.generativelanguage.v1beta2.EmbeddingOrBuilder getEmbeddingOrBuilder() {
      if (embeddingBuilder_ != null) {
        return embeddingBuilder_.getMessageOrBuilder();
      } else {
        return embedding_ == null ?
            com.google.ai.generativelanguage.v1beta2.Embedding.getDefaultInstance() : embedding_;
      }
    }
    /**
     * <pre>
     * Output only. The embedding generated from the input text.
     * </pre>
     *
     * <code>optional .google.ai.generativelanguage.v1beta2.Embedding embedding = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.ai.generativelanguage.v1beta2.Embedding, com.google.ai.generativelanguage.v1beta2.Embedding.Builder, com.google.ai.generativelanguage.v1beta2.EmbeddingOrBuilder> 
        getEmbeddingFieldBuilder() {
      if (embeddingBuilder_ == null) {
        embeddingBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.ai.generativelanguage.v1beta2.Embedding, com.google.ai.generativelanguage.v1beta2.Embedding.Builder, com.google.ai.generativelanguage.v1beta2.EmbeddingOrBuilder>(
                getEmbedding(),
                getParentForChildren(),
                isClean());
        embedding_ = null;
      }
      return embeddingBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:google.ai.generativelanguage.v1beta2.EmbedTextResponse)
  }

  // @@protoc_insertion_point(class_scope:google.ai.generativelanguage.v1beta2.EmbedTextResponse)
  private static final com.google.ai.generativelanguage.v1beta2.EmbedTextResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.ai.generativelanguage.v1beta2.EmbedTextResponse();
  }

  public static com.google.ai.generativelanguage.v1beta2.EmbedTextResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<EmbedTextResponse>
      PARSER = new com.google.protobuf.AbstractParser<EmbedTextResponse>() {
    @java.lang.Override
    public EmbedTextResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<EmbedTextResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<EmbedTextResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.ai.generativelanguage.v1beta2.EmbedTextResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

