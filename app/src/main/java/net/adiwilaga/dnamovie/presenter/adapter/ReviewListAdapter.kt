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
import net.adiwilaga.dnamovie.model.review

class ReviewListAdapter(val items: ArrayList<review>, val context: Context, val lst: ItemClickListener<review>) : RecyclerView.Adapter<ReviewView>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ReviewView {
            return ReviewView(LayoutInflater.from(context).inflate(R.layout.item_review, parent, false))
    }

    override fun getItemViewType(position: Int): Int {
            return position
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ReviewView, position: Int) {
        val n=items.get(position)

        holder.ttitle.text=n.author
        holder.tdesc.text=n.content


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


class ReviewView(view: View) : RecyclerView.ViewHolder(view) {

    var rlmain = view.findViewById<RelativeLayout>(R.id.rlmain)
    var ttitle = view.findViewById<TextView>(R.id.ttitle)
    var tdesc = view.findViewById<TextView>(R.id.tdesc)

}