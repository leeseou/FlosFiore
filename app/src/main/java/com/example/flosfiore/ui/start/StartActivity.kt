package com.example.flosfiore.ui.start

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.flosfiore.R
import com.example.flosfiore.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    lateinit var binding : ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startBtn.setOnClickListener {
            setViews(false)
            supportFragmentManager.beginTransaction()
                .replace(R.id.start_login_flayout, LoginFragment())
                .commitAllowingStateLoss()
        }
    }

    // 뒤로가기 했을 때
    private var backPressedTime : Long = 0
    override fun onBackPressed() {
        // 만약 화면에 로그인 fragment가 있는 상황이라면 시작화면으로
        if(binding.startLoginFlayout.visibility == View.VISIBLE) {
            setViews(true)
        } else {    // 시작화면이라면
            // 2초내 다시 클릭하면 앱 종료
            if (System.currentTimeMillis() - backPressedTime < 2000) {
                finishAffinity()
                return
            }
            // 한 번 클릭했을 시 메시지
            Toast.makeText(this, "뒤로가기 버튼을 한번 더 누르시면 앱이 종료됩니다.", Toast.LENGTH_SHORT).show()
            backPressedTime = System.currentTimeMillis()
        }
    }

    // 화면 reset
    private fun setViews(isStart : Boolean) {
        if(isStart) {   // 시작화면으로
            binding.startIv.setImageResource(R.drawable.image_splash)
            binding.startIv.scaleType = ImageView.ScaleType.FIT_XY
            binding.startGreyIv.visibility = View.INVISIBLE
            binding.startBtn.visibility = View.VISIBLE
            binding.startLoginFlayout.visibility = View.INVISIBLE
        } else {        // 로그인 화면으로
            binding.startIv.setImageResource(R.drawable.img_start)
            binding.startIv.scaleType = ImageView.ScaleType.FIT_START
            binding.startGreyIv.visibility = View.VISIBLE
            binding.startBtn.visibility = View.INVISIBLE
            binding.startLoginFlayout.visibility = View.VISIBLE
        }
    }
}