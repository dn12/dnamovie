package net.adiwilaga.dnamovie.presenter.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import androidx.recyclerview.widget.RecyclerView
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import id.co.xl.sisternet.presenter.viewinterface.ItemClickListener
import net.adiwilaga.dnamovie.R
import net.adiwilaga.dnamovie.model.genre
import net.adiwilaga.dnamovie.model.movie

class MovieListAdapter(val items: ArrayList<movie>,val genres: ArrayList<genre>,  val context: Context, val lst: ItemClickListener<movie>) : RecyclerView.Adapter<MovieView>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MovieView {
            return MovieView(LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemViewType(position: Int): Int {
            return position
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MovieView, position: Int) {
        val n=items.get(position)

        holder.ttitle.text=n.title
        holder.tgenre.text=n.genreIds.toString()
        holder.trate.text="Rate : ${n.voteAverage}"

        var gen=""
        for (i in n.genreIds){
            for (j in genres){
                if(i==j.id) {
                    gen=gen+j.name+", "
                break
                }
            }



        }
        if (gen.length>2)
        holder.tgenre.text=gen.substring(0,gen.length-2)

        if(!n.posterPath.isNullOrEmpty()){
            Glide.with(context).load("https://image.tmdb.org/t/p/w220_and_h330_face/${n.posterPath}").into(holder.img)
        }

        if(position%2==0){
            holder.rlmain.setBackgroundColor(context.resources.getColor(R.color.green30))
        }else{
            holder.rlmain.setBackgroundColor(Color.TRANSPARENT)

        }



        holder.rlmain.setOnClickListener({
            lst.onItemClicked(n)
        })
    }
}


class MovieView(view: View) : RecyclerView.ViewHolder(view) {

    var rlmain = view.findViewById<RelativeLayout>(R.id.rlmain)
    var ttitle = view.findViewById<TextView>(R.id.ttitle)
    var trate = view.findViewById<TextView>(R.id.trate)
    var tgenre = view.findViewById<TextView>(R.id.tgenre)
    var img = view.findViewById<ImageView>(R.id.img)
}