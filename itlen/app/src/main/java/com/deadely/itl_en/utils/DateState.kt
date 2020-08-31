package com.deadely.itl_en.utils

sealed class DataState<out R> {
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val exception: Exception) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}

sealed class Event {
    object getUsersEvent : Event()
    object getActiveUserFromDBEvent : Event()
    object getUserByEmail : Event()
    object addUser : Event()
}

