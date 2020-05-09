package net.adiwilaga.dnamovie.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie_detail.*
import net.adiwilaga.dnamovie.R
import net.adiwilaga.dnamovie.model.moviedetail

class MovieDetailActivity : BaseActivity() {


    lateinit var mov:moviedetail
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)



        mov= intent.getSerializableExtra("movie") as moviedetail

        if(mov==null)
            finish()



        setTitle(mov.title)
        ttitle.text=mov.title
        trate.text="Rate : ${mov.voteAverage}"
        tgenre.text="Genre: ${mov.sgenre}"
        trelease.text="Release Date: ${mov.releaseDate}"
        tduration.text="Duration: ${mov.runtime} min"
        toverview.text=mov.overview
        if(!mov.posterPath.isNullOrEmpty()){
            Glide.with(ctx).load("https://image.tmdb.org/t/p/w220_and_h330_face/${mov.posterPath}").into(img)
        }

//        if(mov.video)
//        tvideo.visibility=View.VISIBLE
//        else
//        tvideo.visibility=View.GONE
        tvideo.setOnClickListener {

            var ii = Intent(ctx, VideoListActivity::class.java)
            ii.putExtra("mid",mov.id)
            startActivity(ii)
        }
        treviews.setOnClickListener {

            var ii = Intent(ctx, ReviewsActivity::class.java)
            ii.putExtra("mid",mov.id)
            startActivity(ii)
        }

        Log.e(TAG,mov.id.toString())

    }
}
