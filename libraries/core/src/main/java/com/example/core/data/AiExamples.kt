package com.example.core.data

import com.google.ai.generativelanguage.v1beta2.Message

object AiExamples {
    val jsonResponseExample: Message = Message.newBuilder().setContent(
        "{\n" + "  \"cuisine\": \"American\",\n" + "  \"name\": \"Hot Honey Chicken\",\n" + "  \"ingredients\": [\n" + "    \"1 pound boneless, skinless chicken breasts, cut into 1-inch pieces\",\n" + "    \"1/2 cup all-purpose flour\",\n" + "    \"1 tablespoon grated ginger\",\n" + "    \"1/2 cup chopped green onions\",\n" + "    \"1/4 cup chopped cilantro\"\n" + "  ],\n" + "  \"instructions\": [\n" + "    \"Preheat oven to 400 degrees F (200 degrees C). Grease a baking sheet.\",\n" + "    \"Transfer the chicken to the prepared baking sheet and bake for 10-15 minutes, or until heated through.\",\n" + "    \"Serve immediately with cilantro, if desired.\"\n" + "  ],\n" + "  \"cookTimeMinutes\": 30,\n" + "  \"prepTimeMinutes\": 15,\n" + "  \"servings\": 4\n" + "}"
    ).build()

    val jsonSchema =
        "{\n" + "  \"schema\": \"http://json-schema.org/draft-04/schema#\",\n" + "  \"type\": \"object\",\n" + "  \"properties\": {\n" + "    \"cuisine\": {\n" + "      \"type\": \"string\"\n" + "    },\n" + "    \"name\": {\n" + "      \"type\": \"string\"\n" + "    },\n" + "    \"ingredients\": {\n" + "      \"type\": \"array\",\n" + "      \"items\": {\n" + "\t\t\"type\" : “string\"\n" + "        \n" + "      }\n" + "    },\n" + "    \"instructions\": {\n" + "      \"type\": \"array\",\n" + "      \"items\": {\n" + "\t\t\"type\" : \"string\"\n" + "\t  }\n" + "    },\n" + "    \"durationInMinutes\": {\n" + "      \"type\": \"integer\"\n" + "    },\n" + "    \"cookTimeMinutes\": {\n" + "      \"type\": \"integer\"\n" + "    },\n" + "    \"prepTimeMinutes\": {\n" + "      \"type\": \"integer\"\n" + "    },\n" + "    \"servings\": {\n" + "      \"type\": \"integer\"\n" + "    }\n" + "  },\n" + "  \"required\": [\n" + "    \"cuisine\",\n" + "    \"name\",\n" + "    \"ingredients\",\n" + "    \"instructions\",\n" + "    \"prepTimeInMinutes\",\n" + "    \"cookTimeInMinutes\",\n" + "    \"servings\"\n" + "  ]\n" + "}"
}
