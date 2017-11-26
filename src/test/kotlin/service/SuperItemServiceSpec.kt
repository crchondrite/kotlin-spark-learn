package service

import entity.SuperItem
import entity.Variation
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
        on("access property") {
            it("access public and private property declare kotlin object via java reflection") {
                val jClass = SuperItemService::class.java
                val publicField = jClass.getDeclaredField("publicProperty")
                publicField.isAccessible = true
                println(publicField.name + " : " + publicField.get(SuperItemService))

                val privateField = jClass.getDeclaredField("privateProperty")
                privateField.isAccessible = true
                println(privateField.name + " : " + privateField.get(SuperItemService))
                assertTrue(true)
            }
            it("access public and private property declare kotlin class via kotlin reflection") {
                val kClass = model.TestClass::class

                kClass.memberProperties.forEach {
                    it.isAccessible = true
                    println(it.name + " : " + it.get(model.TestClass(1, "name")))
                }

                println(model.TestClass::name.get(model.TestClass(2, "fizz")))
                assertTrue(true)
            }

            it("access public and private property declare kotlin data class via kotlin reflection") {
                val kClass = model.TestDataClass::class

                kClass.memberProperties.forEach {
                    it.isAccessible = true
                    println(it.name + " : " + it.get(model.TestDataClass(1, "name")))
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
                        println(it.name + " : " + it.get(SuperItemService))
                    }
                }
            }
        }
        on("access method") {
            it("this public method should return 1") {
                assertEquals(1, SuperItemService.shouldReturnOne())
            }
            it("this public method should return parameter value access via java reflection") {
                // FIXME kotlin cannot call method via reflection??
                val jClass = SuperItemService::class.java
                val method = jClass.getDeclaredMethod("shouldReturnOne")
                // method.isAccessible = true

                assertEquals(1, method.invoke(SuperItemService))
            }
            it("this private method should return parameter value access via java reflection") {
                // FIXME kotlin cannot call private method via reflection??
                // https://github.com/yyYank/kotlin-rev-solution/blob/master/docs/reflection.md
                val jClass = SuperItemService::class.java
                val method = jClass.getDeclaredMethod("shouldReturnParameter", Int::class.java)
                method.isAccessible = true

                val num = 10
                assertEquals(num, method.invoke(SuperItemService, num))
            }

            it("this public method should return 2, just because create mock object and stubbing a public method must return 2") {
                val service = mock(SuperItemService::class.java)
                `when`(service.shouldReturnOne()).thenReturn(2)
                assertEquals(2, service.shouldReturnOne())
            }
        }
        on("private method test") {
            val jClass = SuperItemService::class.java
            val method = jClass.getDeclaredMethod("matchVariationValue", SuperItem::class.java, String::class.java)
            method.isAccessible = true

            val entity1 = SuperItem("1", "name01", 1, true,
                    listOf(Variation(1, "a"), Variation(2, "b")))
            // TODO GABAGABA ENGLISH
            it("should return true when the entity has variation, value is given parameter") {
                val result = method.invoke(SuperItemService, entity1, "a")

                // safe (nullable) cast
                val bool: Boolean? = result as? Boolean
                // println("test start!!" + bool.toString())
                if (bool != null) assertTrue(bool, "get true!!") else assertTrue(false, "result is null")
            }
            it("should return false when the entity has variation, value is not given parameter") {
                val result = method.invoke(SuperItemService, entity1, "c")

                // smart casts
                if (result is Boolean) assertFalse(result, "get false!!") else fail("cast failed")
            }
        }
    }

})
