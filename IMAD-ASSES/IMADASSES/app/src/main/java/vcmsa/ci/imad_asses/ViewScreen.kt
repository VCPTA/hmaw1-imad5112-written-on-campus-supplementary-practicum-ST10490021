package vcmsa.ci.imad_asses

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ViewScreen : AppCompatActivity() {

    var results: TextView? = null

    var all_but: Button? = null
    var ave_but: Button? = null
    var back_but: Button? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_screen)

        results = findViewById<View>(R.id.Results_) as TextView

        all_but = findViewById<View>(R.id.all_) as Button
        ave_but = findViewById<View>(R.id.ave_) as Button
        back_but = findViewById<View>(R.id.return_) as Button

        val s1= intent.getStringExtra("Song1")
        val s2= intent.getStringExtra("Song2")
        val s3= intent.getStringExtra("Song3")
        val s4= intent.getStringExtra("Song4")

        val info_ = "${s1}\n${s2}\n${s3}\n${s4}"


        all_but!!.setOnClickListener(){

            results!!.text = info_
        }
        
        ave_but!!.setOnClickListener(){



        }

        back_but!!.setOnClickListener() {

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}