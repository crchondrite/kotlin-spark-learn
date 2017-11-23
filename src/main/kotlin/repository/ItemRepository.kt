package repository

import com.mongodb.MongoClient
import com.mongodb.MongoClientOptions
import com.mongodb.MongoClientURI
import com.mongodb.ServerAddress
import entity.Items
import org.bson.codecs.configuration.CodecRegistries.fromProviders
import org.bson.codecs.configuration.CodecRegistries.fromRegistries
import org.bson.codecs.pojo.PojoCodecProvider

object ItemRepository {

    private val pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build()))
    private val options = MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build()
    private val client  = MongoClient(ServerAddress("localhost", 27017), options)

    private val db = client.getDatabase("local")

    fun count(): Int = db.getCollection("items", Items::class.java).find().toList().count()
}