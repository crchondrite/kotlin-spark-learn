package service

import com.github.benmanes.caffeine.cache.Cache
import com.github.benmanes.caffeine.cache.Caffeine
import entity.Book
import repository.BookRepository
import java.util.concurrent.TimeUnit

object BookService {

    private val cache : Cache<String, Book> =
        Caffeine.newBuilder()
                .maximumSize(10_000)
                .expireAfterWrite(100, TimeUnit.MINUTES)
                .build()

    fun testCacheBook(isbn:String) : Book? = cache.get(isbn, { _ -> BookRepository.testCacheBook(isbn)} )
}