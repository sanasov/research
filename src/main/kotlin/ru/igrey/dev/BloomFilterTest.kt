package ru.igrey.dev

import com.google.common.hash.BloomFilter
import com.google.common.hash.Funnels
import java.util.stream.IntStream


class BloomFilterTest {
    companion object {


        fun test() {
            val filter = BloomFilter.create(
                    Funnels.integerFunnel(),
                    1000_000,
                    0.00001)


            IntStream.range(0, 1000_000).forEach(filter::put)

            // Copy
            // We added only three elements, and we defined that the maximum number of insertions will be 500, so our Bloom filter should yield very accurate results. Let's test it using the mightContain() method:
            var totalFalse = 0
            IntStream.range(2000_000, 3000_000).forEach {
                if(!filter.mightContain(it)) totalFalse++
            }
            println(totalFalse)
        }

    }

}

fun main() {
    BloomFilterTest.test()
}