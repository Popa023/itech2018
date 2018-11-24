package com.razvanpopescu.socialresp

import com.razvanpopescu.socialresp.models.UserModel

class AppConfig{

    companion object {

        var server = "http://10.10.10.147:5000"
        var token : String? = null
        var user : UserModel? = null
        //aaa mail aa pass
//    10.10.10.147:5000/auth/login?email=aaa&password=aa
    }

}