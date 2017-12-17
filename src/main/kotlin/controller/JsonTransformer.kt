package controller

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi

object JsonTransformer {
    val moshi: Moshi =
        Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    inline fun <reified T> render(model: T) = moshi.adapter(T::class.java).toJson(model) ?: "[]"
}