package com.example.core.service

import com.google.ai.generativelanguage.v1beta2.DiscussServiceClient
import com.google.ai.generativelanguage.v1beta2.DiscussServiceSettings
import com.google.api.gax.core.FixedCredentialsProvider
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider
import com.google.api.gax.rpc.FixedHeaderProvider

class GenerativeDiscussService(
    private val apiKey: String
) {
    fun getClient(): DiscussServiceClient {
        // (This is a workaround because GAPIC java libraries don't yet support API key auth)
        val transportChannelProvider = InstantiatingGrpcChannelProvider.newBuilder()
            .setHeaderProvider(FixedHeaderProvider.create(hashMapOf("x-goog-api-key" to apiKey)))
            .build()

        // Create DiscussServiceSettings
        val settings = DiscussServiceSettings.newBuilder()
            .setTransportChannelProvider(transportChannelProvider)
            .setCredentialsProvider(FixedCredentialsProvider.create(null))
            .build()

        return DiscussServiceClient.create(settings)
    }
}