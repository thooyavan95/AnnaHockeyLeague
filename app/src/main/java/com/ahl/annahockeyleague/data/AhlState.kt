package com.ahl.annahockeyleague.data


sealed class DataState{
    object RequestSent : DataState()
    class Success(val data : Any) : DataState()
    class Failure(val dataFailedAction : DataFailedAction, val errorMessage : String?) : DataState()
}

