// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ai/generativelanguage/v1beta2/text_service.proto

package com.google.ai.generativelanguage.v1beta2;

public interface EmbedTextResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.ai.generativelanguage.v1beta2.EmbedTextResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Output only. The embedding generated from the input text.
   * </pre>
   *
   * <code>optional .google.ai.generativelanguage.v1beta2.Embedding embedding = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return Whether the embedding field is set.
   */
  boolean hasEmbedding();
  /**
   * <pre>
   * Output only. The embedding generated from the input text.
   * </pre>
   *
   * <code>optional .google.ai.generativelanguage.v1beta2.Embedding embedding = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return The embedding.
   */
  com.google.ai.generativelanguage.v1beta2.Embedding getEmbedding();
  /**
   * <pre>
   * Output only. The embedding generated from the input text.
   * </pre>
   *
   * <code>optional .google.ai.generativelanguage.v1beta2.Embedding embedding = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   */
  com.google.ai.generativelanguage.v1beta2.EmbeddingOrBuilder getEmbeddingOrBuilder();
}
