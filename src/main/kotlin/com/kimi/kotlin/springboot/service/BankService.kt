package com.kimi.kotlin.springboot.service

import com.kimi.kotlin.springboot.datasource.BankDataSource
import com.kimi.kotlin.springboot.model.Bank
import org.springframework.stereotype.Service

@Service
class BankService(private val bankDataSource: BankDataSource) {

    fun getBanks(): Collection<Bank> = bankDataSource.retrieveBanks()

    fun getBank(accountNumber: String): Bank = bankDataSource.getBank(accountNumber)

    fun addBank(bank: Bank): Bank = bankDataSource.addBank(bank)

    fun deleteBank(accountNumber: String): Unit {
        val deleteResult = bankDataSource.deleteBank(accountNumber)
        println("deleteResult=$deleteResult")
    }

}