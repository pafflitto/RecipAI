// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ai/generativelanguage/v1beta2/discuss_service.proto

package com.google.ai.generativelanguage.v1beta2;

public final class DiscussServiceProto {
  private DiscussServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ai_generativelanguage_v1beta2_GenerateMessageRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ai_generativelanguage_v1beta2_GenerateMessageRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ai_generativelanguage_v1beta2_GenerateMessageResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ai_generativelanguage_v1beta2_GenerateMessageResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ai_generativelanguage_v1beta2_Message_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ai_generativelanguage_v1beta2_Message_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ai_generativelanguage_v1beta2_MessagePrompt_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ai_generativelanguage_v1beta2_MessagePrompt_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ai_generativelanguage_v1beta2_Example_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ai_generativelanguage_v1beta2_Example_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ai_generativelanguage_v1beta2_CountMessageTokensRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ai_generativelanguage_v1beta2_CountMessageTokensRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ai_generativelanguage_v1beta2_CountMessageTokensResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ai_generativelanguage_v1beta2_CountMessageTokensResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n:google/ai/generativelanguage/v1beta2/d" +
      "iscuss_service.proto\022$google.ai.generati" +
      "velanguage.v1beta2\0323google/ai/generative" +
      "language/v1beta2/citation.proto\0321google/" +
      "ai/generativelanguage/v1beta2/safety.pro" +
      "to\032\034google/api/annotations.proto\032\027google" +
      "/api/client.proto\032\037google/api/field_beha" +
      "vior.proto\032\031google/api/resource.proto\"\316\002" +
      "\n\026GenerateMessageRequest\022>\n\005model\030\001 \001(\tB" +
      "/\340A\002\372A)\n\'generativelanguage.googleapis.c" +
      "om/Model\022H\n\006prompt\030\002 \001(\01323.google.ai.gen" +
      "erativelanguage.v1beta2.MessagePromptB\003\340" +
      "A\002\022\035\n\013temperature\030\003 \001(\002B\003\340A\001H\000\210\001\001\022!\n\017can" +
      "didate_count\030\004 \001(\005B\003\340A\001H\001\210\001\001\022\027\n\005top_p\030\005 " +
      "\001(\002B\003\340A\001H\002\210\001\001\022\027\n\005top_k\030\006 \001(\005B\003\340A\001H\003\210\001\001B\016" +
      "\n\014_temperatureB\022\n\020_candidate_countB\010\n\006_t" +
      "op_pB\010\n\006_top_k\"\343\001\n\027GenerateMessageRespon" +
      "se\022A\n\ncandidates\030\001 \003(\0132-.google.ai.gener" +
      "ativelanguage.v1beta2.Message\022?\n\010message" +
      "s\030\002 \003(\0132-.google.ai.generativelanguage.v" +
      "1beta2.Message\022D\n\007filters\030\003 \003(\01323.google" +
      ".ai.generativelanguage.v1beta2.ContentFi" +
      "lter\"\247\001\n\007Message\022\023\n\006author\030\001 \001(\tB\003\340A\001\022\024\n" +
      "\007content\030\002 \001(\tB\003\340A\002\022[\n\021citation_metadata" +
      "\030\003 \001(\01326.google.ai.generativelanguage.v1" +
      "beta2.CitationMetadataB\003\340A\003H\000\210\001\001B\024\n\022_cit" +
      "ation_metadata\"\261\001\n\rMessagePrompt\022\024\n\007cont" +
      "ext\030\001 \001(\tB\003\340A\001\022D\n\010examples\030\002 \003(\0132-.googl" +
      "e.ai.generativelanguage.v1beta2.ExampleB" +
      "\003\340A\001\022D\n\010messages\030\003 \003(\0132-.google.ai.gener" +
      "ativelanguage.v1beta2.MessageB\003\340A\002\"\206\001\n\007E" +
      "xample\022<\n\005input\030\001 \001(\0132-.google.ai.genera" +
      "tivelanguage.v1beta2.Message\022=\n\006output\030\002" +
      " \001(\0132-.google.ai.generativelanguage.v1be" +
      "ta2.Message\"\245\001\n\031CountMessageTokensReques" +
      "t\022>\n\005model\030\001 \001(\tB/\340A\002\372A)\n\'generativelang" +
      "uage.googleapis.com/Model\022H\n\006prompt\030\002 \001(" +
      "\01323.google.ai.generativelanguage.v1beta2" +
      ".MessagePromptB\003\340A\002\"1\n\032CountMessageToken" +
      "sResponse\022\023\n\013token_count\030\001 \001(\0052\226\004\n\016Discu" +
      "ssService\022\373\001\n\017GenerateMessage\022<.google.a" +
      "i.generativelanguage.v1beta2.GenerateMes" +
      "sageRequest\032=.google.ai.generativelangua" +
      "ge.v1beta2.GenerateMessageResponse\"k\202\323\344\223" +
      "\002.\")/v1beta2/{model=models/*}:generateMe" +
      "ssage:\001*\332A4model,prompt,temperature,cand" +
      "idate_count,top_p,top_k\022\337\001\n\022CountMessage" +
      "Tokens\022?.google.ai.generativelanguage.v1" +
      "beta2.CountMessageTokensRequest\032@.google" +
      ".ai.generativelanguage.v1beta2.CountMess" +
      "ageTokensResponse\"F\202\323\344\223\0021\",/v1beta2/{mod" +
      "el=models/*}:countMessageTokens:\001*\332A\014mod" +
      "el,prompt\032$\312A!generativelanguage.googlea" +
      "pis.comB\231\001\n(com.google.ai.generativelang" +
      "uage.v1beta2B\023DiscussServiceProtoP\001ZVgoo" +
      "gle.golang.org/genproto/googleapis/ai/ge" +
      "nerativelanguage/v1beta2;generativelangu" +
      "ageb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.ai.generativelanguage.v1beta2.CitationProto.getDescriptor(),
          com.google.ai.generativelanguage.v1beta2.SafetyProto.getDescriptor(),
          com.google.api.AnnotationsProto.getDescriptor(),
          com.google.api.ClientProto.getDescriptor(),
          com.google.api.FieldBehaviorProto.getDescriptor(),
          com.google.api.ResourceProto.getDescriptor(),
        });
    internal_static_google_ai_generativelanguage_v1beta2_GenerateMessageRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_google_ai_generativelanguage_v1beta2_GenerateMessageRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ai_generativelanguage_v1beta2_GenerateMessageRequest_descriptor,
        new java.lang.String[] { "Model", "Prompt", "Temperature", "CandidateCount", "TopP", "TopK", "Temperature", "CandidateCount", "TopP", "TopK", });
    internal_static_google_ai_generativelanguage_v1beta2_GenerateMessageResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_google_ai_generativelanguage_v1beta2_GenerateMessageResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ai_generativelanguage_v1beta2_GenerateMessageResponse_descriptor,
        new java.lang.String[] { "Candidates", "Messages", "Filters", });
    internal_static_google_ai_generativelanguage_v1beta2_Message_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_google_ai_generativelanguage_v1beta2_Message_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ai_generativelanguage_v1beta2_Message_descriptor,
        new java.lang.String[] { "Author", "Content", "CitationMetadata", "CitationMetadata", });
    internal_static_google_ai_generativelanguage_v1beta2_MessagePrompt_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_google_ai_generativelanguage_v1beta2_MessagePrompt_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ai_generativelanguage_v1beta2_MessagePrompt_descriptor,
        new java.lang.String[] { "Context", "Examples", "Messages", });
    internal_static_google_ai_generativelanguage_v1beta2_Example_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_google_ai_generativelanguage_v1beta2_Example_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ai_generativelanguage_v1beta2_Example_descriptor,
        new java.lang.String[] { "Input", "Output", });
    internal_static_google_ai_generativelanguage_v1beta2_CountMessageTokensRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_google_ai_generativelanguage_v1beta2_CountMessageTokensRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ai_generativelanguage_v1beta2_CountMessageTokensRequest_descriptor,
        new java.lang.String[] { "Model", "Prompt", });
    internal_static_google_ai_generativelanguage_v1beta2_CountMessageTokensResponse_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_google_ai_generativelanguage_v1beta2_CountMessageTokensResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ai_generativelanguage_v1beta2_CountMessageTokensResponse_descriptor,
        new java.lang.String[] { "TokenCount", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.ClientProto.defaultHost);
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.AnnotationsProto.http);
    registry.add(com.google.api.ClientProto.methodSignature);
    registry.add(com.google.api.ResourceProto.resourceReference);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.ai.generativelanguage.v1beta2.CitationProto.getDescriptor();
    com.google.ai.generativelanguage.v1beta2.SafetyProto.getDescriptor();
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.api.ClientProto.getDescriptor();
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
