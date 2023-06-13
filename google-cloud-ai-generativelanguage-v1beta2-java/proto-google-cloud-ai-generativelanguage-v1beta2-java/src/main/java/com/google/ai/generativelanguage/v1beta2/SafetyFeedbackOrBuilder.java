// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ai/generativelanguage/v1beta2/safety.proto

package com.google.ai.generativelanguage.v1beta2;

public interface SafetyFeedbackOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.ai.generativelanguage.v1beta2.SafetyFeedback)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Safety rating evaluated from content.
   * </pre>
   *
   * <code>.google.ai.generativelanguage.v1beta2.SafetyRating rating = 1;</code>
   * @return Whether the rating field is set.
   */
  boolean hasRating();
  /**
   * <pre>
   * Safety rating evaluated from content.
   * </pre>
   *
   * <code>.google.ai.generativelanguage.v1beta2.SafetyRating rating = 1;</code>
   * @return The rating.
   */
  com.google.ai.generativelanguage.v1beta2.SafetyRating getRating();
  /**
   * <pre>
   * Safety rating evaluated from content.
   * </pre>
   *
   * <code>.google.ai.generativelanguage.v1beta2.SafetyRating rating = 1;</code>
   */
  com.google.ai.generativelanguage.v1beta2.SafetyRatingOrBuilder getRatingOrBuilder();

  /**
   * <pre>
   * Safety settings applied to the request.
   * </pre>
   *
   * <code>.google.ai.generativelanguage.v1beta2.SafetySetting setting = 2;</code>
   * @return Whether the setting field is set.
   */
  boolean hasSetting();
  /**
   * <pre>
   * Safety settings applied to the request.
   * </pre>
   *
   * <code>.google.ai.generativelanguage.v1beta2.SafetySetting setting = 2;</code>
   * @return The setting.
   */
  com.google.ai.generativelanguage.v1beta2.SafetySetting getSetting();
  /**
   * <pre>
   * Safety settings applied to the request.
   * </pre>
   *
   * <code>.google.ai.generativelanguage.v1beta2.SafetySetting setting = 2;</code>
   */
  com.google.ai.generativelanguage.v1beta2.SafetySettingOrBuilder getSettingOrBuilder();
}
