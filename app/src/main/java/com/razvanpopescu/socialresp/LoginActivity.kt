package com.razvanpopescu.socialresp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import com.razvanpopescu.socialresp.models.UserModel
import kotlin.concurrent.thread
import khttp.responses.Response
import org.json.JSONArray
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun login(v: View?){

        thread {
            val url = AppConfig.server
            val response : Response = khttp.get("$url/auth/login?email=aaa&password=aa")
            AppConfig.token = response.text
            if(AppConfig.token != null){

                val userResponse : Response = khttp.get("$url/user/get?email=aaa")
                val userJsonArray : JSONArray = userResponse.jsonArray
                print(userJsonArray)
                val userInit : UserModel = Gson().fromJson(userJsonArray.toString(), UserModel::class.java)
                print(userInit)
                var myIntent = Intent(this, MapsActivity::class.java)
                startActivity(myIntent)
            }
            else {
                Toast.makeText(this,"Login failed",Toast.LENGTH_LONG)
            }
        }
    }

}
