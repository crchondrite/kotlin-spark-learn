package database.mongodb

import com.mongodb.MongoClient
import com.mongodb.MongoClientOptions
import com.mongodb.ServerAddress
import org.bson.codecs.configuration.CodecRegistries.fromProviders
import org.bson.codecs.configuration.CodecRegistries.fromRegistries
import org.bson.codecs.pojo.PojoCodecProvider
import org.mongodb.morphia.Datastore
import org.mongodb.morphia.Morphia

object DataStore {
    val DB: Datastore

    init {
        val pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build()))
        val options = MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build()
        val client = MongoClient(ServerAddress("localhost", 27017), options)

        val morphia = Morphia().mapPackage("entity")
        DB = morphia.createDatastore(client, "local")
    }
}