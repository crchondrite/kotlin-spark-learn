import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import repository.BookRepository
import kotlin.test.assertEquals

object BookRepositorySpec: Spek({
    describe("book repository") {
        on("get mock data") {
            it("should return correct isbn") {
                assertEquals("9784839961749", BookRepository.testBook().isbn)
            }
        }
    }
})