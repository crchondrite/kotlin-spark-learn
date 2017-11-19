package controller

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import spark.ResponseTransformer

class JsonTransformer : ResponseTransformer {
    override fun render(model: Any?): String {
        val adapter : JsonAdapter<Any> =
                Moshi.Builder().add(KotlinJsonAdapterFactory()).build().adapter(Any::class.java)
        return adapter.toJson(model)
    }
}