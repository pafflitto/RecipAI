// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ai/generativelanguage/v1beta2/citation.proto

package com.google.ai.generativelanguage.v1beta2;

public interface CitationSourceOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.ai.generativelanguage.v1beta2.CitationSource)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Optional. Start of segment of the response that is attributed to this
   * source.
   * Index indicates the start of the segment, measured in bytes.
   * </pre>
   *
   * <code>optional int32 start_index = 1 [(.google.api.field_behavior) = OPTIONAL];</code>
   * @return Whether the startIndex field is set.
   */
  boolean hasStartIndex();
  /**
   * <pre>
   * Optional. Start of segment of the response that is attributed to this
   * source.
   * Index indicates the start of the segment, measured in bytes.
   * </pre>
   *
   * <code>optional int32 start_index = 1 [(.google.api.field_behavior) = OPTIONAL];</code>
   * @return The startIndex.
   */
  int getStartIndex();

  /**
   * <pre>
   * Optional. End of the attributed segment, exclusive.
   * </pre>
   *
   * <code>optional int32 end_index = 2 [(.google.api.field_behavior) = OPTIONAL];</code>
   * @return Whether the endIndex field is set.
   */
  boolean hasEndIndex();
  /**
   * <pre>
   * Optional. End of the attributed segment, exclusive.
   * </pre>
   *
   * <code>optional int32 end_index = 2 [(.google.api.field_behavior) = OPTIONAL];</code>
   * @return The endIndex.
   */
  int getEndIndex();

  /**
   * <pre>
   * Optional. URI that is attributed as a source for a portion of the text.
   * </pre>
   *
   * <code>optional string uri = 3 [(.google.api.field_behavior) = OPTIONAL];</code>
   * @return Whether the uri field is set.
   */
  boolean hasUri();
  /**
   * <pre>
   * Optional. URI that is attributed as a source for a portion of the text.
   * </pre>
   *
   * <code>optional string uri = 3 [(.google.api.field_behavior) = OPTIONAL];</code>
   * @return The uri.
   */
  java.lang.String getUri();
  /**
   * <pre>
   * Optional. URI that is attributed as a source for a portion of the text.
   * </pre>
   *
   * <code>optional string uri = 3 [(.google.api.field_behavior) = OPTIONAL];</code>
   * @return The bytes for uri.
   */
  com.google.protobuf.ByteString
      getUriBytes();

  /**
   * <pre>
   * Optional. License for the GitHub project that is attributed as a source for
   * segment.
   * License info is required for code citations.
   * </pre>
   *
   * <code>optional string license = 4 [(.google.api.field_behavior) = OPTIONAL];</code>
   * @return Whether the license field is set.
   */
  boolean hasLicense();
  /**
   * <pre>
   * Optional. License for the GitHub project that is attributed as a source for
   * segment.
   * License info is required for code citations.
   * </pre>
   *
   * <code>optional string license = 4 [(.google.api.field_behavior) = OPTIONAL];</code>
   * @return The license.
   */
  java.lang.String getLicense();
  /**
   * <pre>
   * Optional. License for the GitHub project that is attributed as a source for
   * segment.
   * License info is required for code citations.
   * </pre>
   *
   * <code>optional string license = 4 [(.google.api.field_behavior) = OPTIONAL];</code>
   * @return The bytes for license.
   */
  com.google.protobuf.ByteString
      getLicenseBytes();
}
