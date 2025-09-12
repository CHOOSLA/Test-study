package com.example.voterestapiandroid

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class VoteViewModel : ViewModel(){
    var votes by mutableStateOf(emptyList<Vote>())
    var vote by mutableStateOf<Vote?>(null)


    fun fetchVotes(){
        viewModelScope.launch {
            votes = RetrofitCLient.voteApiService.getVotes();
        }
    }

    fun createVote(title: String, description: String){
     viewModelScope.launch {
         val newVote = Vote( title = title, description = description)
         val createdVote = RetrofitCLient.voteApiService.createVote(newVote)
         votes = votes + createdVote
     }
    }

    fun fetchVote(voteId: Int){
        viewModelScope.launch {
            vote = RetrofitCLient.voteApiService.getVote(voteId)
        }
    }
}