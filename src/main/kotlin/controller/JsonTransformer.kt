package controller

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import spark.ResponseTransformer

object JsonTransformer : ResponseTransformer {
    private val adapter : JsonAdapter<Any> =
            Moshi.Builder().add(KotlinJsonAdapterFactory()).build().adapter(Any::class.java)

    override fun render(model: Any?) = adapter.toJson(model) ?: "[]"
}