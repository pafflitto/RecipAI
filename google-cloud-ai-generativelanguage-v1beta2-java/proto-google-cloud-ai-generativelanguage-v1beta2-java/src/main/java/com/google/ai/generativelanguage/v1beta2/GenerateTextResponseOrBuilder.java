// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ai/generativelanguage/v1beta2/text_service.proto

package com.google.ai.generativelanguage.v1beta2;

public interface GenerateTextResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.ai.generativelanguage.v1beta2.GenerateTextResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Candidate responses from the model.
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta2.TextCompletion candidates = 1;</code>
   */
  java.util.List<com.google.ai.generativelanguage.v1beta2.TextCompletion> 
      getCandidatesList();
  /**
   * <pre>
   * Candidate responses from the model.
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta2.TextCompletion candidates = 1;</code>
   */
  com.google.ai.generativelanguage.v1beta2.TextCompletion getCandidates(int index);
  /**
   * <pre>
   * Candidate responses from the model.
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta2.TextCompletion candidates = 1;</code>
   */
  int getCandidatesCount();
  /**
   * <pre>
   * Candidate responses from the model.
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta2.TextCompletion candidates = 1;</code>
   */
  java.util.List<? extends com.google.ai.generativelanguage.v1beta2.TextCompletionOrBuilder> 
      getCandidatesOrBuilderList();
  /**
   * <pre>
   * Candidate responses from the model.
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta2.TextCompletion candidates = 1;</code>
   */
  com.google.ai.generativelanguage.v1beta2.TextCompletionOrBuilder getCandidatesOrBuilder(
      int index);

  /**
   * <pre>
   * A set of content filtering metadata for the prompt and response
   * text.
   * This indicates which `SafetyCategory`(s) blocked a
   * candidate from this response, the lowest `HarmProbability`
   * that triggered a block, and the HarmThreshold setting for that category.
   * This indicates the smallest change to the `SafetySettings` that would be
   * necessary to unblock at least 1 response.
   * The blocking is configured by the `SafetySettings` in the request (or the
   * default `SafetySettings` of the API).
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta2.ContentFilter filters = 3;</code>
   */
  java.util.List<com.google.ai.generativelanguage.v1beta2.ContentFilter> 
      getFiltersList();
  /**
   * <pre>
   * A set of content filtering metadata for the prompt and response
   * text.
   * This indicates which `SafetyCategory`(s) blocked a
   * candidate from this response, the lowest `HarmProbability`
   * that triggered a block, and the HarmThreshold setting for that category.
   * This indicates the smallest change to the `SafetySettings` that would be
   * necessary to unblock at least 1 response.
   * The blocking is configured by the `SafetySettings` in the request (or the
   * default `SafetySettings` of the API).
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta2.ContentFilter filters = 3;</code>
   */
  com.google.ai.generativelanguage.v1beta2.ContentFilter getFilters(int index);
  /**
   * <pre>
   * A set of content filtering metadata for the prompt and response
   * text.
   * This indicates which `SafetyCategory`(s) blocked a
   * candidate from this response, the lowest `HarmProbability`
   * that triggered a block, and the HarmThreshold setting for that category.
   * This indicates the smallest change to the `SafetySettings` that would be
   * necessary to unblock at least 1 response.
   * The blocking is configured by the `SafetySettings` in the request (or the
   * default `SafetySettings` of the API).
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta2.ContentFilter filters = 3;</code>
   */
  int getFiltersCount();
  /**
   * <pre>
   * A set of content filtering metadata for the prompt and response
   * text.
   * This indicates which `SafetyCategory`(s) blocked a
   * candidate from this response, the lowest `HarmProbability`
   * that triggered a block, and the HarmThreshold setting for that category.
   * This indicates the smallest change to the `SafetySettings` that would be
   * necessary to unblock at least 1 response.
   * The blocking is configured by the `SafetySettings` in the request (or the
   * default `SafetySettings` of the API).
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta2.ContentFilter filters = 3;</code>
   */
  java.util.List<? extends com.google.ai.generativelanguage.v1beta2.ContentFilterOrBuilder> 
      getFiltersOrBuilderList();
  /**
   * <pre>
   * A set of content filtering metadata for the prompt and response
   * text.
   * This indicates which `SafetyCategory`(s) blocked a
   * candidate from this response, the lowest `HarmProbability`
   * that triggered a block, and the HarmThreshold setting for that category.
   * This indicates the smallest change to the `SafetySettings` that would be
   * necessary to unblock at least 1 response.
   * The blocking is configured by the `SafetySettings` in the request (or the
   * default `SafetySettings` of the API).
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta2.ContentFilter filters = 3;</code>
   */
  com.google.ai.generativelanguage.v1beta2.ContentFilterOrBuilder getFiltersOrBuilder(
      int index);

  /**
   * <pre>
   * Returns any safety feedback related to content filtering.
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta2.SafetyFeedback safety_feedback = 4;</code>
   */
  java.util.List<com.google.ai.generativelanguage.v1beta2.SafetyFeedback> 
      getSafetyFeedbackList();
  /**
   * <pre>
   * Returns any safety feedback related to content filtering.
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta2.SafetyFeedback safety_feedback = 4;</code>
   */
  com.google.ai.generativelanguage.v1beta2.SafetyFeedback getSafetyFeedback(int index);
  /**
   * <pre>
   * Returns any safety feedback related to content filtering.
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta2.SafetyFeedback safety_feedback = 4;</code>
   */
  int getSafetyFeedbackCount();
  /**
   * <pre>
   * Returns any safety feedback related to content filtering.
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta2.SafetyFeedback safety_feedback = 4;</code>
   */
  java.util.List<? extends com.google.ai.generativelanguage.v1beta2.SafetyFeedbackOrBuilder> 
      getSafetyFeedbackOrBuilderList();
  /**
   * <pre>
   * Returns any safety feedback related to content filtering.
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta2.SafetyFeedback safety_feedback = 4;</code>
   */
  com.google.ai.generativelanguage.v1beta2.SafetyFeedbackOrBuilder getSafetyFeedbackOrBuilder(
      int index);
}
