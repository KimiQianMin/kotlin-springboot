package com.kimi.kotlin.springboot.service

import com.kimi.kotlin.springboot.datasource.BankDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BankServiceTest {

    private val bankDataSource: BankDataSource = mockk(relaxed = true)

    private val bankSerivce = BankService(bankDataSource)

    @Test
    fun `should call its data source to retrieve banks`() {
        // given
        //every { bankDataSource.retrieveBanks() } returns emptyList()

        // when
        this.bankSerivce.getBanks()

        // then
        verify(exactly = 1) { bankDataSource.retrieveBanks() }
    }


}