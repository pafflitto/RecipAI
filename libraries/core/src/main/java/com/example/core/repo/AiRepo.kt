package com.example.core.repo

import android.util.Log
import com.example.core.data.AiExamples
import com.example.core.data.Recipe
import com.example.core.data.RecipeRequestParams
import com.example.core.data.RecipeResponse
import com.example.core.data.toRecipe
import com.example.core.service.GenerativeDiscussService
import com.google.ai.generativelanguage.v1beta2.Example
import com.google.ai.generativelanguage.v1beta2.GenerateMessageRequest
import com.google.ai.generativelanguage.v1beta2.Message
import com.google.ai.generativelanguage.v1beta2.MessagePrompt
import kotlinx.serialization.json.Json

interface AiRepo {
    suspend fun requestRecipeFor(params: RecipeRequestParams)
    suspend fun requestRecipeFromLink(url: String): Result<Recipe>
}

class AiRepoImpl(
    service: GenerativeDiscussService
) : AiRepo {
    private val client = service.getClient()

    override suspend fun requestRecipeFor(params: RecipeRequestParams) {
    }

    override suspend fun requestRecipeFromLink(url: String): Result<Recipe> {
        val prompt = createUrlPrompt(url)
        return sendRequest(prompt, 0f)
    }

    private fun createUrlPrompt(
        input: String
    ): MessagePrompt {
        val message = Message
            .newBuilder()
            .setAuthor("0")
            .setContent(input)
            .build()

        return MessagePrompt
            .newBuilder()
            .setContext(
                "Your an API that only returns a JSON response and you follow the JSON syntax very strictly." +
                "Your JSON follows the same structure as this example ${AiExamples.jsonResponseExample}"
            )
            .addMessages(message)
            .addExamples(urlExample)
            .build()
    }

    private fun sendRequest(
        prompt: MessagePrompt,
        temp: Float
    ): Result<Recipe> {
        val request = GenerateMessageRequest
            .newBuilder()
            .setModel(aiModel)
            .setPrompt(prompt)
            .setTemperature(temp)
            .setCandidateCount(1)
            .build()

        return try {
            Log.e("AiRepo", prompt.messagesList.first().content)
            val response = client.generateMessage(request)
            val returnedMessage = response.candidatesList.first().content
            Log.e("AiRepo", returnedMessage)
            val jsonStartIndex = returnedMessage.indexOfFirst { it == '{' }
            val jsonEndIndex = returnedMessage.indexOfLast { it == '}' }
            val jsonToParse = returnedMessage.substring(jsonStartIndex, jsonEndIndex + 1)
            val recipeResponse = Json.decodeFromString<RecipeResponse>(
                jsonToParse
            )
            Log.e("AiRepo", recipeResponse.toString())
            Result.success(recipeResponse.toRecipe())
        } catch (e: Exception) {
            Log.e("AiRepo", e.stackTraceToString())
            Result.failure(e)
        }
    }

    companion object {

        private const val aiModel = "models/chat-bison-001"
        private fun getPastedTextPrompt(text: String) = Message
            .newBuilder()
            .setContent("Parse a recipe from this text and format in a JSON response.\n $text")
            .build()

        private val urlExample = Example
            .newBuilder()
            .setInput(
                getPastedTextPrompt("Baked Crunchy Hot Honey Chicken\n" +
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
                )
            )
            .setOutput(AiExamples.jsonResponseExample)
            .build()
    }
}