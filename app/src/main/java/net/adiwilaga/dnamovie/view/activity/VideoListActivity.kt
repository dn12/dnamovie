package net.adiwilaga.dnamovie.view.activity

import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.xl.sisternet.presenter.viewinterface.DataListInterface
import id.co.xl.sisternet.presenter.viewinterface.ItemClickListener
import kotlinx.android.synthetic.main.activity_video_list.*
import net.adiwilaga.dnamovie.R
import net.adiwilaga.dnamovie.model.video
import net.adiwilaga.dnamovie.presenter.adapter.VideoListAdapter
import net.adiwilaga.dnamovie.presenter.logic.MoviePresenter
import java.util.ArrayList

class VideoListActivity : BaseActivity() {

    lateinit var presenter:MoviePresenter

    lateinit var lsVideo:ArrayList<video>
    lateinit var adp:VideoListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_list)


        setTitle(R.string.videos)

        presenter= MoviePresenter(APIServices)

        lsVideo= ArrayList()
        adp= VideoListAdapter(lsVideo,ctx,object :ItemClickListener<video>{
            override fun onItemClicked(res: video) {
            }

        })
        recycler_view.adapter=adp
        recycler_view.layoutManager=LinearLayoutManager(ctx)


        var mid= intent.getIntExtra("mid",0)

        ShowLoadingDialog()
        presenter.getMovieVideo(mid,object:DataListInterface<video>{
            override fun onGetDataSuccess(res: List<video>, pg: Int) {
                DismisLoadingDialog()
                lsVideo.clear()
                lsVideo.addAll(res)
                adp.notifyDataSetChanged()
            }

            override fun onGetDataFailed(error: String) {
                DismisLoadingDialog()
                Toast(error)
            }

        })



    }
}
