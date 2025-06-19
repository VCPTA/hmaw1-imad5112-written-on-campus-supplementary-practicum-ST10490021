package vcmsa.ci.imad_asses

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//St10490021
//Blessed Phiri

class MainActivity : AppCompatActivity() {

    var songs = arrayOfNulls<String>(4)
    var artists_ = arrayOfNulls<String>(4)
    var ratings = arrayOfNulls<Int>(4)
    var comments = arrayOfNulls<String>(4)

    /*var songs = mutableListOf<String>()
    var artists_ = mutableListOf<String>()
    var ratings = mutableListOf<Int>()
    var comments = mutableListOf<String>()*/


    var song_name: EditText? = null
    var artist_name: EditText? = null
    var rating_: EditText? = null
    var user_comment: EditText? = null


    var Add_but: Button? =null
    var navigate_but: Button? =null
    var exit_but: Button? =null

    var show:TextView? = null
    var show2:TextView? = null

    var counter = 0





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        song_name = findViewById<View>(R.id.Song_) as EditText
        artist_name = findViewById<View>(R.id.Artist_) as EditText
        rating_ = findViewById<View>(R.id.Rating_) as EditText
        user_comment = findViewById<View>(R.id.Comment_) as EditText

        Add_but = findViewById<View>(R.id.add_) as Button
        navigate_but = findViewById<View>(R.id.nav_) as Button
        exit_but = findViewById<View>(R.id.exit_) as Button

        show = findViewById<View>(R.id.View_) as TextView
        show2 = findViewById<View>(R.id.View_2) as TextView




        Add_but!!.setOnClickListener(){

            val song = song_name!!.text.toString()
            val artist = artist_name!!.text.toString()
            val rating = rating_!!.text.toString() // turn to int After error handling
            val comment = user_comment!!.text.toString()

            if (song.isNotEmpty() && artist.isNotEmpty() && rating.isNotEmpty() && comment.isNotEmpty()){

                val rate_int = rating.toInt()

                 val info = StringBuilder()




                    if(counter<songs.size){
                        songs[counter] = song
                        artists_[counter] = artist
                        ratings[counter] = rate_int
                        comments[counter] = comment

                        info.append("${songs[counter]} - ${artists_[counter]} -${ratings[counter]} - ${comments[counter]}\n")

                        show!!.text = info


                        song_name!!.text.clear()
                        artist_name!!.text.clear()
                        rating_!!.text.clear()
                        user_comment!!.text.clear()
                        counter++



                        val info2 = StringBuilder()

                        for (i in 0 until counter){


                            info2.append("${songs[i]} - ${artists_[i]} -${ratings[i]} - ${comments[i]}\n")

                            show2!!.text = info2


                        }


                    }
                    else{
                        Toast.makeText(this,"Song Limit Reached",Toast.LENGTH_LONG).show()

                    }







            }
            else{

                Toast.makeText(this,"Make sure all Fields are complete",Toast.LENGTH_LONG).show()
            }



        }

        navigate_but!!.setOnClickListener(){

            val song_1 = "${songs[0]} - ${artists_[0]} -${ratings[0]} - ${comments[0]}"
            val song_2 = "${songs[1]} - ${artists_[1]} -${ratings[1]} - ${comments[1]}"
            val song_3 = "${songs[2]} - ${artists_[2]} -${ratings[2]} - ${comments[2]}"
            val song_4 = "${songs[3]} - ${artists_[3]} -${ratings[3]} - ${comments[3]}"
            //var calcu = StringBuilder()
           /* for (i in 0 until songs.size){
                var num = 0

                calcu.append("${num + ratings[i]}")


                num+=
            }*/


            val intent = Intent(this,ViewScreen::class.java)
            intent.putExtra("Song1",song_1)
            intent.putExtra("Song2",song_2)
            intent.putExtra("Song3",song_3)
            intent.putExtra("Song4",song_4)




            startActivity(intent)
            finish()


        }

        exit_but!!.setOnClickListener(){
             finish()
            System.out.close()

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}