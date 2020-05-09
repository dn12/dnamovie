package net.adiwilaga.dnamovie.view.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.co.xl.sisternet.presenter.viewinterface.DataListInterface
import id.co.xl.sisternet.presenter.viewinterface.ItemClickListener
import kotlinx.android.synthetic.main.activity_reviews.*
import net.adiwilaga.dnamovie.R
import net.adiwilaga.dnamovie.model.review
import net.adiwilaga.dnamovie.presenter.adapter.ReviewListAdapter
import net.adiwilaga.dnamovie.presenter.logic.MoviePresenter
import java.util.ArrayList

class ReviewsActivity : BaseActivity() {
    lateinit var presenter: MoviePresenter
    var page=1
    var onload=false
    var mid=0
    lateinit var lsReviews: ArrayList<review>
    lateinit var adp: ReviewListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reviews)

        setTitle(R.string.reviews)

        presenter= MoviePresenter(APIServices)

        lsReviews= ArrayList()
        adp= ReviewListAdapter(lsReviews,ctx,object : ItemClickListener<review> {
            override fun onItemClicked(res: review) {
            }

        })
        recycler_view.adapter=adp
        recycler_view.layoutManager= LinearLayoutManager(ctx)
        recycler_view.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    getReviews()
                }
            }
        })

        mid= intent.getIntExtra("mid",0)

        getReviews()

    }


    fun getReviews(){

        if(!onload && page>0) {
            onload=true
            ShowLoadingDialog()
            presenter.getMovieReview(mid, page,object : DataListInterface<review> {
                override fun onGetDataSuccess(res: List<review>, pg: Int) {
                    onload=false
                    DismisLoadingDialog()
                    lsReviews.clear()
                    lsReviews.addAll(res)
                    adp.notifyDataSetChanged()
                    page=pg
                }

                override fun onGetDataFailed(error: String) {
                    onload=false
                    DismisLoadingDialog()
                    Toast(error)
                }

            })
        }

    }
}
