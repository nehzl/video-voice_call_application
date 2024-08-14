package com.example.video_call_application

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.zegocloud.uikit.prebuilt.call.ZegoUIKitPrebuiltCallService
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig

class Mock_login_activity : AppCompatActivity() {
    lateinit var usernameInput:EditText
    lateinit var loginButton:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mock_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        usernameInput=findViewById(R.id.username_input)
        loginButton=findViewById(R.id.login)

        loginButton.setOnClickListener{
            val username = usernameInput.text.toString()

            val config = ZegoUIKitPrebuiltCallInvitationConfig()
            ZegoUIKitPrebuiltCallService.init(application,AppConstants.Appid,AppConstants.AppSign,username,username,config)
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("username",username)
            startActivity(intent)
        }
    }
}