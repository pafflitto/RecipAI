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
            .setContext("Your an API that only returns a JSON response and you follow the JSON syntax very strictly")
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
        private fun getUrlInputPrompt(url: String) = Message
            .newBuilder()
            .setContent("Format the details of the recipe from this link $url in JSON format.")
            .build()

        private val urlExample = Example
            .newBuilder()
            .setInput(getUrlInputPrompt("https://www.halfbakedharvest.com/hot-honey-chicken/"))
            .setOutput(AiExamples.jsonResponseExample)
            .build()
    }
}