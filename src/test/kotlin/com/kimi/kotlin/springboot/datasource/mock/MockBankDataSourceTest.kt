package com.kimi.kotlin.springboot.datasource.mock

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.function.Consumer

internal class MockBankDataSourceTest {

    private val mockDataSource = MockBankDataSource()

    @Test
    fun `should provide a collection of banks`() {
        // given
        // when
        val banks = mockDataSource.getBanks()

        // then
        assertThat(banks).isNotEmpty
    }

    @Test
    fun `should provide some mock data`() {
        // given

        // when
        val banks = mockDataSource.getBanks()

        // then
        assertThat(banks).satisfies(Consumer {
            assertThat(it.isNotEmpty())
        })

        assertThat(banks).allMatch { it.accountNumber.isNotEmpty() }

    }


}