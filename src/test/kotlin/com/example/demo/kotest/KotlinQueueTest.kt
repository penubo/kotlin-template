package com.example.demo.kotest

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.kotest.matchers.types.shouldBeTypeOf
import java.util.Arrays

class KotlinQueueTest : FunSpec({
    val queue = KotlinQueue()

    afterTest {
        queue.clean()
    }

    test("push elements in the queue") {
        queue.push(1)
        queue.push(2)
        queue.push(3)
        queue.push(4)
        queue.size() shouldBe 4
    }

    test("raise exception if pop empty list") {
        shouldThrow<RuntimeException> {
            queue.pop()
        }
    }

    test("pop elements in order") {
        queue.push(1)
        queue.push(2)
        queue.push(3)
        queue.pop() shouldBe 1
        queue.pop() shouldBe 2
        queue.pop() shouldBe 3
    }

    test("return queue as list") {
        queue.asList().shouldBeInstanceOf<List<Int>>()
    }

})
