// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ai/generativelanguage/v1beta2/model.proto

package com.google.ai.generativelanguage.v1beta2;

public interface ModelOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.ai.generativelanguage.v1beta2.Model)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Required. The resource name of the `Model`.
   * Format: `models/{model}` with a `{model}` naming convention of:
   * * "{base_model_id}-{version}"
   * Examples:
   * * `models/chat-bison-001`
   * </pre>
   *
   * <code>string name = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <pre>
   * Required. The resource name of the `Model`.
   * Format: `models/{model}` with a `{model}` naming convention of:
   * * "{base_model_id}-{version}"
   * Examples:
   * * `models/chat-bison-001`
   * </pre>
   *
   * <code>string name = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <pre>
   * Required. The name of the base model, pass this to the generation request.
   * Examples:
   * * `chat-bison`
   * </pre>
   *
   * <code>string base_model_id = 2 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The baseModelId.
   */
  java.lang.String getBaseModelId();
  /**
   * <pre>
   * Required. The name of the base model, pass this to the generation request.
   * Examples:
   * * `chat-bison`
   * </pre>
   *
   * <code>string base_model_id = 2 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The bytes for baseModelId.
   */
  com.google.protobuf.ByteString
      getBaseModelIdBytes();

  /**
   * <pre>
   * Required. The version number of the model.
   * This represents the major version
   * </pre>
   *
   * <code>string version = 3 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The version.
   */
  java.lang.String getVersion();
  /**
   * <pre>
   * Required. The version number of the model.
   * This represents the major version
   * </pre>
   *
   * <code>string version = 3 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The bytes for version.
   */
  com.google.protobuf.ByteString
      getVersionBytes();

  /**
   * <pre>
   * The human-readable name of the model. E.g. "Chat Bison".
   * The name can be up to 128 characters long and can consist of any UTF-8
   * characters.
   * </pre>
   *
   * <code>string display_name = 4;</code>
   * @return The displayName.
   */
  java.lang.String getDisplayName();
  /**
   * <pre>
   * The human-readable name of the model. E.g. "Chat Bison".
   * The name can be up to 128 characters long and can consist of any UTF-8
   * characters.
   * </pre>
   *
   * <code>string display_name = 4;</code>
   * @return The bytes for displayName.
   */
  com.google.protobuf.ByteString
      getDisplayNameBytes();

  /**
   * <pre>
   * A short description of the model.
   * </pre>
   *
   * <code>string description = 5;</code>
   * @return The description.
   */
  java.lang.String getDescription();
  /**
   * <pre>
   * A short description of the model.
   * </pre>
   *
   * <code>string description = 5;</code>
   * @return The bytes for description.
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <pre>
   * Maximum number of input tokens allowed for this model.
   * </pre>
   *
   * <code>int32 input_token_limit = 6;</code>
   * @return The inputTokenLimit.
   */
  int getInputTokenLimit();

  /**
   * <pre>
   * Maximum number of output tokens available for this model.
   * </pre>
   *
   * <code>int32 output_token_limit = 7;</code>
   * @return The outputTokenLimit.
   */
  int getOutputTokenLimit();

  /**
   * <pre>
   * The model's supported generation methods.
   * The method names are defined as Pascal case
   * strings, such as `generateMessage` which correspond to API methods.
   * </pre>
   *
   * <code>repeated string supported_generation_methods = 8;</code>
   * @return A list containing the supportedGenerationMethods.
   */
  java.util.List<java.lang.String>
      getSupportedGenerationMethodsList();
  /**
   * <pre>
   * The model's supported generation methods.
   * The method names are defined as Pascal case
   * strings, such as `generateMessage` which correspond to API methods.
   * </pre>
   *
   * <code>repeated string supported_generation_methods = 8;</code>
   * @return The count of supportedGenerationMethods.
   */
  int getSupportedGenerationMethodsCount();
  /**
   * <pre>
   * The model's supported generation methods.
   * The method names are defined as Pascal case
   * strings, such as `generateMessage` which correspond to API methods.
   * </pre>
   *
   * <code>repeated string supported_generation_methods = 8;</code>
   * @param index The index of the element to return.
   * @return The supportedGenerationMethods at the given index.
   */
  java.lang.String getSupportedGenerationMethods(int index);
  /**
   * <pre>
   * The model's supported generation methods.
   * The method names are defined as Pascal case
   * strings, such as `generateMessage` which correspond to API methods.
   * </pre>
   *
   * <code>repeated string supported_generation_methods = 8;</code>
   * @param index The index of the value to return.
   * @return The bytes of the supportedGenerationMethods at the given index.
   */
  com.google.protobuf.ByteString
      getSupportedGenerationMethodsBytes(int index);

  /**
   * <pre>
   * Controls the randomness of the output.
   * Values can range over `[0.0,1.0]`, inclusive. A value closer to `1.0` will
   * produce responses that are more varied, while a value closer to `0.0` will
   * typically result in less surprising responses from the model.
   * This value specifies default to be used by the backend while making the
   * call to the model.
   * </pre>
   *
   * <code>optional float temperature = 9;</code>
   * @return Whether the temperature field is set.
   */
  boolean hasTemperature();
  /**
   * <pre>
   * Controls the randomness of the output.
   * Values can range over `[0.0,1.0]`, inclusive. A value closer to `1.0` will
   * produce responses that are more varied, while a value closer to `0.0` will
   * typically result in less surprising responses from the model.
   * This value specifies default to be used by the backend while making the
   * call to the model.
   * </pre>
   *
   * <code>optional float temperature = 9;</code>
   * @return The temperature.
   */
  float getTemperature();

  /**
   * <pre>
   * For Nucleus sampling.
   * Nucleus sampling considers the smallest set of tokens whose probability
   * sum is at least `top_p`.
   * This value specifies default to be used by the backend while making the
   * call to the model.
   * </pre>
   *
   * <code>optional float top_p = 10;</code>
   * @return Whether the topP field is set.
   */
  boolean hasTopP();
  /**
   * <pre>
   * For Nucleus sampling.
   * Nucleus sampling considers the smallest set of tokens whose probability
   * sum is at least `top_p`.
   * This value specifies default to be used by the backend while making the
   * call to the model.
   * </pre>
   *
   * <code>optional float top_p = 10;</code>
   * @return The topP.
   */
  float getTopP();

  /**
   * <pre>
   * For Top-k sampling.
   * Top-k sampling considers the set of `top_k` most probable tokens.
   * This value specifies default to be used by the backend while making the
   * call to the model.
   * </pre>
   *
   * <code>optional int32 top_k = 11;</code>
   * @return Whether the topK field is set.
   */
  boolean hasTopK();
  /**
   * <pre>
   * For Top-k sampling.
   * Top-k sampling considers the set of `top_k` most probable tokens.
   * This value specifies default to be used by the backend while making the
   * call to the model.
   * </pre>
   *
   * <code>optional int32 top_k = 11;</code>
   * @return The topK.
   */
  int getTopK();
}
