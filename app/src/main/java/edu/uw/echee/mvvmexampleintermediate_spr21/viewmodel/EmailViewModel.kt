package edu.uw.echee.mvvmexampleintermediate_spr21.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class EmailViewModel: ViewModel() {

    val numOfEmails = MutableStateFlow(0)

    fun fetchEmails() = viewModelScope.launch {
        numOfEmails.emit( numOfEmails.value + 1 )
    }

    fun deleteEmail() = viewModelScope.launch {
        numOfEmails.emit( numOfEmails.value - 1 )
    }

}
