package com.kimi.kotlin.springboot.datasource

import com.kimi.kotlin.springboot.model.Bank

interface BankDataSource {

    fun getBanks(): Collection<Bank>

    fun retrieveBanks(): Collection<Bank>

    fun getBank(accountNumber: String): Bank

    fun addBank(bank: Bank): Bank

    fun deleteBank(accountNumber: String): Unit

}