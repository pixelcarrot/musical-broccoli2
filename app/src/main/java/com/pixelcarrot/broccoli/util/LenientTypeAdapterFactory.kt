package com.pixelcarrot.broccoli.util

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.io.IOException

class LenientTypeAdapterFactory : TypeAdapterFactory {

    override fun <T> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T>? {
        val delegate: TypeAdapter<T> = gson.getDelegateAdapter(this, type)
        return createCustomTypeAdapter(delegate)
    }

    private fun <T> createCustomTypeAdapter(delegate: TypeAdapter<T>): TypeAdapter<T> {
        return object : TypeAdapter<T>() {
            @Throws(IOException::class)
            override fun write(out: JsonWriter, value: T) {
                delegate.write(out, value)
            }

            @Throws(IOException::class)
            override fun read(`in`: JsonReader): T {
                `in`.isLenient = true
                return delegate.read(`in`)
            }
        }
    }
}
