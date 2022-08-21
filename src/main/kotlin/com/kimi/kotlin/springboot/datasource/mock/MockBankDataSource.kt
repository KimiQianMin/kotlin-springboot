package com.kimi.kotlin.springboot.datasource.mock

import com.kimi.kotlin.springboot.datasource.BankDataSource
import com.kimi.kotlin.springboot.model.Bank
import org.springframework.stereotype.Repository
import java.lang.IllegalArgumentException

@Repository
class MockBankDataSource : BankDataSource {

    var banks = mutableListOf(
        Bank("001", 0.0, 1),
        Bank("002", 0.0, 1),
        Bank("003", 0.0, 1)
    )

    override fun getBanks(): Collection<Bank> = banks

    override fun retrieveBanks(): Collection<Bank> = banks

    override fun getBank(accountNumber: String): Bank =
        banks.firstOrNull() { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("$accountNumber is not existing")

    override fun addBank(bank: Bank): Bank {
        if (banks.any { it.accountNumber == bank.accountNumber }) {
            throw IllegalArgumentException("Bank with account number ${bank.accountNumber} already existing")
        }

        banks.add(bank)
        return bank
    }

    override fun deleteBank(accountNumber: String): Unit {

    }

}