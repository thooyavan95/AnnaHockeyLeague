package com.ahl.annahockeyleague

import com.ahl.annahockeyleague.data.Action


sealed class DataState{
    object RequestSent : DataState()
    class Success(val data : Any) : DataState()
    class Failure(val action : Action, val errorMessage : String?) : DataState()
}


sealed class UIState<out T : Any>{
    object Loading : UIState<Nothing>()
    class DataAvailable<T : Any>(val data : T) : UIState<T>()
    class Error(val error : String?) : UIState<Nothing>()
}
