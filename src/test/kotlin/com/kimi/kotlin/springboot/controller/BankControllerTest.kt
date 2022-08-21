package com.kimi.kotlin.springboot.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.kimi.kotlin.springboot.model.Bank
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.web.servlet.*
import kotlin.coroutines.coroutineContext

@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest @Autowired constructor(
    var mockMvc: MockMvc,
    var objectMapper: ObjectMapper
) {


    @Test
    fun `should return all banks`() {
        // given

        // when

        // then
        mockMvc.get("/api/banks/getBanks1")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$[0].accountNumber") { value("001") }
            }

    }

    @Test
    fun `should return the bank with the given account number`() {
        // given
        val accountNumber = "003"

        // when

        // then
        mockMvc.get("/api/banks/$accountNumber")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.accountNumber") { value("$accountNumber") }
            }

    }

    @Test
    fun `should add the new bank`() {
        // given
        val newBank = Bank("004", 22.0, 2)

        // when
        val performPost = mockMvc.post("/api/banks") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(newBank)
        }

        // then
        performPost
            .andDo { print() }
            .andExpect {
                status { isCreated() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.accountNumber") { value(newBank.accountNumber) }
            }
    }

    @Test
    fun `should patch existing bank`() {
        // given
        val newBank = Bank("004", 22.0, 2)

        // when
        val performPost = mockMvc.patch("/api/banks") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(newBank)
        }

        // then
        performPost
            .andDo { print() }
            .andExpect {
                status { isCreated() }
                content {
                    content { contentType(MediaType.APPLICATION_JSON) }
                    json(objectMapper.writeValueAsString(newBank))
                }
            }

    }

    @Test
    @DirtiesContext
    fun `should delete existing bank`() {
        // given
        val accountNumber = "003"

        // when
        val performPost = mockMvc.delete("/api/banks/$accountNumber") {
            contentType = MediaType.APPLICATION_JSON
        }

        // then
        performPost
            .andDo { print() }
            .andExpect {
                status { isNoContent() }
//                content {
//                    content { contentType(MediaType.APPLICATION_JSON) }
//                    json(objectMapper.writeValueAsString(newBank))
//                }
            }

    }

}
