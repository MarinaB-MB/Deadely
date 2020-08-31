package com.example.fb.repository

import com.example.fb.database.UserDao
import com.example.fb.database.mapToUser
import com.example.fb.database.mapToUserList
import com.example.fb.model.Group
import com.example.fb.model.User
import com.example.fb.network.RestAPI
import com.example.fb.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class Repository
@Inject constructor(val api: RestAPI, val ud: UserDao) {

//    suspend fun getUsersFromApi(): Flow<DataState<List<User>>> = flow {
//        try {
//            emit(DataState.Loading)
//            val usersFromApi = api.getUsers()
//            emit(DataState.Success(usersFromApi))
//        } catch (e: Exception) {
//            e.printStackTrace()
//            emit(DataState.Error(e))
//        }
//    }

    suspend fun getUserFromApi(id: String): Flow<DataState<User>> = flow {
        try {
            emit(DataState.Loading)
            val currentUserApi = api.getUserById(id)
            emit(DataState.Success(currentUserApi))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(DataState.Error(e))
        }
    }

    suspend fun getUserByEmail(email: String): Flow<DataState<User>> = flow {
        try {
            emit(DataState.Loading)
            val emailData = "{\"email\":\"$email\"}"
            val currentUserFromApi = api.getUserByEmail(emailData)
            emit(DataState.Success(currentUserFromApi))
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            emit(DataState.Error(e))
        }
    }

    suspend fun getWordsFromApi(): Flow<DataState<List<Group.Lesson.Word>>> = flow {
        try {
            emit(DataState.Loading)
            val wordsFromApi = api.getWords()
            emit(DataState.Success(wordsFromApi))
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            emit(DataState.Error(e))
        }
    }

    suspend fun getActiveUser(): Flow<DataState<User>> = flow {
        try {
            emit(DataState.Loading)
            val user = ud.getActiveUser(true).mapToUser()
            emit(DataState.Success(user))
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            emit(DataState.Error(e))
        }
    }

 }


