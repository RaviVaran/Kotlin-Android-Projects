package com.example.studentregistration.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
//DAO interface provides the necessary methods to interact with the student data stored in the database, allowing for CRUD (Create, Read, Update, Delete) operations.

@Dao // annotation marks the interface as a DAO interface.data access objects
interface StudentDao {
    @Insert
    suspend fun insertStudent(student: Student)  //can be suspended and resumed at a later time without blocking the main thread.

    @Update
    suspend fun updateStudent(student: Student)

    @Delete
    suspend fun deleteStudent(student: Student)
    //return type indicates that the query result will be observed as a LiveData object, allowing for reactive updates when the data changes.

    @Query("SELECT * FROM student_data_table")
    fun getAllStudents():LiveData<List<Student>>

}