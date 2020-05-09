package net.adiwilaga.dnamovie.presenter.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pierfrancescosoffritti.androidyoutubeplayer.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.AbstractYouTubePlayerListener
import id.co.xl.sisternet.presenter.viewinterface.ItemClickListener
import net.adiwilaga.dnamovie.R
import net.adiwilaga.dnamovie.model.video
import net.adiwilaga.dnamovie.view.activity.BaseActivity

class VideoListAdapter(val items: List<video>, val context: Context, val lst: ItemClickListener<video>) : RecyclerView.Adapter<VideoViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(LayoutInflater.from(context).inflate(R.layout.item_video, parent, false))
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val v=items.get(position)
        holder.title?.text=v.name
        holder.date?.text= v.type

        holder.yt.visibility=View.GONE

            (context as BaseActivity).lifecycle.addObserver(holder.yt)
            holder.yt.initialize({ initializedYouTubePlayer ->
                initializedYouTubePlayer.addListener(object : AbstractYouTubePlayerListener() {
                    override fun onStateChange(state: PlayerConstants.PlayerState) {
                        super.onStateChange(state)
                        if(state==PlayerConstants.PlayerState.PLAYING){
                            lst.onItemClicked(v)
                        }
                        if(state==PlayerConstants.PlayerState.ENDED){

                        }
                    }

                    override fun onReady() {
                        holder.yt.visibility=View.VISIBLE
                        var videoId = "6JYIGclVQdw"
//                    videoId = "https://www.youtube.com/watch?v=LEf27xuYcw4"

                        videoId = v.key
                            .replace("https://www.youtube.com/embed/", "")
                            .replace("http://www.youtube.com/embed/","")
                            .replace("?feature=player_detailpage","")
                        Log.e("Videoid",videoId)
                        initializedYouTubePlayer.cueVideo(videoId, 0f)

                    }
                })
            }, true)






    }
}


class VideoViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val main=view.findViewById<RelativeLayout>(R.id.main)
    val yt = view.findViewById<YouTubePlayerView>(R.id.yt)
    val title=view.findViewById<TextView>(R.id.ttitle)
    val date=view.findViewById<TextView>(R.id.tdate)
}