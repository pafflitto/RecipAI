package com.example.core.data

import com.google.ai.generativelanguage.v1beta2.Example
import com.google.ai.generativelanguage.v1beta2.Message

object AiPrompts {
    fun String.fromPastedTextToMessage() = Message
        .newBuilder()
        .setContent("Parse a recipe from this text and format in a JSON response.\n $this")
        .build()

    val pasteInputExample: Example = Example
        .newBuilder()
        .setInput(
            AiConstants.exampleRecipePaste.fromPastedTextToMessage()
        )
        .setOutput(AiConstants.jsonResponseExample)
        .build()
}

object AiConstants {
    val jsonResponseExample: Message = Message.newBuilder().setContent(
        "{\n" + "  \"cuisine\": \"American\",\n" + "  \"name\": \"Hot Honey Chicken\",\n" + "  \"ingredients\": [\n" + "    \"1 pound boneless, skinless chicken breasts, cut into 1-inch pieces\",\n" + "    \"1/2 cup all-purpose flour\",\n" + "    \"1 tablespoon grated ginger\",\n" + "    \"1/2 cup chopped green onions\",\n" + "    \"1/4 cup chopped cilantro\"\n" + "  ],\n" + "  \"instructions\": [\n" + "    \"Preheat oven to 400 degrees F (200 degrees C). Grease a baking sheet.\",\n" + "    \"Transfer the chicken to the prepared baking sheet and bake for 10-15 minutes, or until heated through.\",\n" + "    \"Serve immediately with cilantro, if desired.\"\n" + "  ],\n" + "  \"cookTimeMinutes\": 30,\n" + "  \"prepTimeMinutes\": 15,\n" + "  \"servings\": 4\n" + "}"
    ).build()

    internal const val exampleRecipePaste = "Baked Crunchy Hot Honey Chicken\n" +
            "Simple cornflake-crusted chicken baked up on a sheet pan until crispy and delicious - loved by everyone!\n" +
            "Prep Time\n" +
            "15minutes mins\n" +
            "Cook Time\n" +
            "25minutes mins\n" +
            "Total Time\n" +
            "40minutes mins\n" +
            "Course: Appetizer, Main CourseCuisine: AmericanDiet: Gluten FreeKey Ingredient: chicken, honey, hot sauce Servings: 6 Calories: 403kcal Author: Tieghan Gerard\n" +
            "Ingredients\n" +
            "6 cups cornflakes (use gluten free, if needed)\n" +
            "1/4 cup grated parmesan cheese\n" +
            "1 teaspoon smoked paprika\n" +
            "1/2 teaspoon onion powder\n" +
            "1/2 teaspoon garlic powder\n" +
            "2 large eggs, beaten\n" +
            "2 tablespoons hot sauce\n" +
            "2 pounds chicken breast tenderloins\n" +
            "extra virgin olive oil, for drizzling\n" +
            "Hot Honey\n" +
            "1/2 cup honey\n" +
            "2-3 tablespoons hot sauce\n" +
            "1-3 teaspoons cayenne pepper\n" +
            "3/4 teaspoon chipotle chili powder\n" +
            "1/2 teaspoon garlic powder\n" +
            "1/2 teaspoon onion powder\n" +
            "sea salt\n" +
            "fresh thyme, cilantro, or parsley, for serving\n" +
            "Instructions\n" +
            "1. Preheat the oven to 425° F. Line a baking sheet with parchment paper.\n" +
            "2. In a food processor, combine the cornflakes, parmesan, paprika, onion powder, garlic powder, and a pinch of salt. Pulse until you have fine crumbs. Alternatively, you can crush the crumbs in a ziplock bag by stepping on them. Dump the crumbs into a shallow bowl.\n" +
            "3. Beat the eggs in a bowl, add the hot sauce and chicken, and toss well to coat.\n" +
            "3. Dredge the chicken through the crumbs, covering fully. Place on the prepared baking sheet. For a thicker coating, dip the chicken back through the eggs, then through the crumbs a 2nd time. Place on the prepared baking sheet. Drizzle with olive oil. Bake for 20-25 minutes, until crisp all around.\n" +
            "4. Just before the chicken is done cooking, make the sauce. In a sauce pot, warm together the honey, hot sauce, cayenne, chili powder, onion powder, and garlic powder, plus a pinch of salt.\n" +
            "5. Drizzle the warm sauce over the chicken. Top with herbs. If the sauce thickens, warm for 5 seconds in the microwave. Enjoy!\n" +
            "Nutrition\n" +
            "Calories: 403kcal"
}
