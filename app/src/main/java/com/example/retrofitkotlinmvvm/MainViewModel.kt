package com.example.retrofitkotlinmvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

public class MainViewModel(application: Application) : AndroidViewModel(application){

    val repository  :QuotesRepository

    init {

        val quotesAPI = RetrofitHelper.getInstance().create(QuotesAPI::class.java)
        repository = QuotesRepository(quotesAPI)

        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuotes(1)
        }
    }

    val quotes : LiveData<QuoteList>
    get() = repository.quotes


}