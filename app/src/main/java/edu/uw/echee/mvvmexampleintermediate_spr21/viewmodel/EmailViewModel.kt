package edu.uw.echee.mvvmexampleintermediate_spr21.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.uw.echee.mvvmexampleintermediate_spr21.model.Email
import edu.uw.echee.mvvmexampleintermediate_spr21.model.Inbox
import edu.uw.echee.mvvmexampleintermediate_spr21.repository.EmailRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class EmailViewModel: ViewModel() {
    private lateinit var emailRepository: EmailRepository

    val allEmails = MutableStateFlow<List<Email>>(listOf())

    fun setUp(emailRepository: EmailRepository) {
        this.emailRepository = emailRepository
    }

    fun fetchEmails() {
        viewModelScope.launch {

            val inbox: Inbox = emailRepository.getInbox()
            val emails: List<Email> = inbox.emails

            allEmails.value = emails

        }
    }

//    fun deleteEmail()  {
//        allEmails.value =allEmails.value - 1
//    }

}
