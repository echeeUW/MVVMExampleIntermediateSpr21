package edu.uw.echee.mvvmexampleintermediate_spr21

import android.app.Application
import edu.uw.echee.mvvmexampleintermediate_spr21.repository.EmailRepository

class EmailApplication: Application() {

    lateinit var emailRepository: EmailRepository

    override fun onCreate() {
        super.onCreate()
        this.emailRepository = EmailRepository()
    }
}
