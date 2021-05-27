package edu.uw.echee.mvvmexampleintermediate_spr21.repository

import edu.uw.echee.mvvmexampleintermediate_spr21.model.Inbox
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class EmailRepository {
    private val service = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(EmailService::class.java)

    suspend fun getInbox() = service.getInbox()
}

interface EmailService {
    @GET("echeeUW/codesnippets/master/emails.json")
    suspend fun getInbox(): Inbox
}
