package com.example.video_call_application

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton
import com.zegocloud.uikit.service.defines.ZegoUIKitUser
import org.w3c.dom.Text
import java.util.Collections

class MainActivity : AppCompatActivity() {
    lateinit var currentUsernameTextView: TextView
    lateinit var targetUsernameInput: EditText
    lateinit var voiceCallButton: ZegoSendCallInvitationButton
    lateinit var videoCallButton: ZegoSendCallInvitationButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        currentUsernameTextView = findViewById(R.id.current_username_textview)
        targetUsernameInput = findViewById(R.id.target_username_input)
        voiceCallButton = findViewById(R.id.voice_call_button)
        videoCallButton = findViewById(R.id.video_call_button)

        currentUsernameTextView.text = "Hello  " + intent.getStringExtra("username")

        targetUsernameInput.addTextChangedListener{
        val targetUsername = targetUsernameInput.text.toString()
            setupVoiceCall(targetUsername)
            setupVideoCall(targetUsername)
        }
    }
    fun setupVoiceCall(username : String){
        voiceCallButton.setIsVideoCall(false)
        voiceCallButton.resourceID = "zego_uikit_call"
        voiceCallButton.setInvitees(Collections.singletonList(ZegoUIKitUser(username,username)))
    }

    fun setupVideoCall(username : String){
        videoCallButton.setIsVideoCall(true)
        videoCallButton.resourceID = "zego_uikit_call"
        videoCallButton.setInvitees(Collections.singletonList(ZegoUIKitUser(username,username)))
    }

}