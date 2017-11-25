package service

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible
import kotlin.test.*

object SuperItemServiceSpec : Spek({
    describe("SuperItemService Testing...") {
        on("test mock") {
            it("this method should return 1") {
                assertEquals(1, SuperItemService.shouldReturnOne())
            }
            it("should return 2, just because create mock object and stubbing a public method must return 2") {
                val service = mock(SuperItemService::class.java)
                `when`(service.shouldReturnOne()).thenReturn(2)
                assertEquals(2, service.shouldReturnOne())
            }
            it("access public and private property declare kotlin object via java reflection") {
                // FIXME Kotlin reflection cannot access to private property in object
                val jClass = SuperItemService::class.java
                val publicField = jClass.getDeclaredField("publicProperty")
                publicField.isAccessible = true
                println(publicField.name + " + " + publicField.get(SuperItemService))


                val privateField = jClass.getDeclaredField("privateProperty")
                privateField.isAccessible = true
                println(privateField.name + " + " + privateField.get(SuperItemService))
                assertTrue(true)
            }

            it("access public and private property declare kotlin class via kotlin reflection") {
                val kClass = model.TestClass::class

                kClass.memberProperties.forEach {
                    it.isAccessible = true
                    println(it.name + " + " + it.get(model.TestClass(1, "name")))
                }

                println(model.TestClass::name.get(model.TestClass(2, "fizz")))
                assertTrue(true)
            }

            it("access public and private property declare kotlin data class via kotlin reflection") {
                val kClass = model.TestDataClass::class

                kClass.memberProperties.forEach {
                    it.isAccessible = true
                    println(it.name + it.get(model.TestDataClass(1, "name")))
                }

                println(model.TestDataClass::name.get(model.TestDataClass(2, "buzz")))
                assertTrue(true)
            }

            it("cannot access private property in kotlin object via kotlin reflection") {
                val kClass = SuperItemService::class

                // SuperItemService has private property
                assertFailsWith(IllegalArgumentException::class) {
                    kClass.memberProperties.forEach {
                        it.isAccessible = true
                        println(it.name + it.get(SuperItemService))
                    }
                }
            }
        }
    }

})
