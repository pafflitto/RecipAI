package com.example.core.repo

import android.util.Log
import com.example.core.data.AiConstants
import com.example.core.data.AiPrompts
import com.example.core.data.AiPrompts.fromPastedTextToMessage
import com.example.core.data.Recipe
import com.example.core.data.RecipeRequestParams
import com.example.core.data.RecipeResponse
import com.example.core.data.toRecipe
import com.example.core.service.GenerativeDiscussService
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
        val message = input.fromPastedTextToMessage()

        return MessagePrompt
            .newBuilder()
            .setContext(
                "Your an API that only returns a JSON response and you follow the JSON syntax very strictly." +
                "Your JSON follows the same structure as this example ${AiConstants.jsonResponseExample}"
            )
            .addMessages(message)
            .addExamples(AiPrompts.pasteInputExample)
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
            val response = client.generateMessage(request)
            val returnedMessage = response.candidatesList.first().content
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
    }
}