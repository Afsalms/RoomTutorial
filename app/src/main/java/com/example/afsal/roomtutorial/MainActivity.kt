package com.example.afsal.roomtutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.afsal.roomtutorial.database.DatabaseHelper
import com.example.afsal.roomtutorial.models.Task
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var databaseObj:DatabaseHelper;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        databaseObj = DatabaseHelper.getInstance(applicationContext)
        loadDataFromDb()
        Thread.sleep(1000)


        button.setOnClickListener {
            var task = Task()
            task.name = inputField.text.toString()
            Thread{
                databaseObj.taskDao().addNewTask(task)
            }.start()

            textView.text = inputField.text.toString()+  "\n" + textView.text.toString()
            inputField.text = null
        }

    }
    fun loadDataFromDb(){
        Thread{
            var taskList = databaseObj.taskDao().getAllTask()
            textView.text = null
            taskList.forEach {
                textView.text = textView.text.toString() + "\n" +it.name
            }
        }.start()
    }
}
