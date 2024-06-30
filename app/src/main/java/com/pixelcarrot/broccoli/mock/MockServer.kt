package com.pixelcarrot.broccoli.mock

import android.content.Context
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import java.io.BufferedReader

object MockServer {
    private var mockWebServer: MockWebServer? = null
    private val serverStartDeferred = CompletableDeferred<String>()

    fun start(context: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            mockWebServer = MockWebServer().apply {
                dispatcher = object : Dispatcher() {
                    override fun dispatch(request: RecordedRequest): MockResponse {
                        return handleSongsRequest(context, request)
                    }
                }
                start(8080) // Start the server on port 8080
                serverStartDeferred.complete(url("/").toString())
            }
        }
    }

    fun shutdown() {
        CoroutineScope(Dispatchers.IO).launch {
            mockWebServer?.shutdown()
        }
    }

    private fun handleSongsRequest(context: Context, request: RecordedRequest): MockResponse {
        val path = request.path ?: return MockResponse().setResponseCode(404)
        val queryParams = path.substringAfter("?", "").split("&").associate {
            val (key, value) = it.split("=")
            key to value
        }

        val page = queryParams["page"]?.toIntOrNull() ?: 1
        val pageSize = queryParams["page_size"]?.toIntOrNull() ?: 500
        val totalPages = 66

        if (page > totalPages || page < 1 || pageSize != 500) {
            return MockResponse().setResponseCode(404)
        }

        val fileName = "spotify_songs_page_$page.json"
        val json =
            loadJsonFromAsset(context, fileName) ?: return MockResponse().setResponseCode(404)

        return MockResponse()
            .setResponseCode(200)
            .setBody(json)
    }

    private fun loadJsonFromAsset(context: Context, fileName: String): String? {
        return try {
            context.assets.open(fileName).bufferedReader().use(BufferedReader::readText)
        } catch (e: Exception) {
            null
        }
    }

}
