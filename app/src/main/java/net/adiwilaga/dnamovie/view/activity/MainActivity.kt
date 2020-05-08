package net.adiwilaga.dnamovie.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.co.xl.sisternet.presenter.viewinterface.DataListInterface
import id.co.xl.sisternet.presenter.viewinterface.ItemClickListener
import kotlinx.android.synthetic.main.activity_main.*
import net.adiwilaga.dnamovie.R
import net.adiwilaga.dnamovie.model.genre
import net.adiwilaga.dnamovie.model.movie
import net.adiwilaga.dnamovie.presenter.adapter.MovieListAdapter
import net.adiwilaga.dnamovie.presenter.logic.MoviePresenter
import java.util.ArrayList

class MainActivity : BaseActivity() {


    lateinit var presenter:MoviePresenter
    var page=1

    lateinit var lsMovie:ArrayList<movie>
    lateinit var lsGenre:ArrayList<genre>
    lateinit var adp:MovieListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        presenter= MoviePresenter(APIServices)
        lsMovie=ArrayList()
        lsGenre=ArrayList()
        adp= MovieListAdapter(lsMovie,lsGenre,this,object:ItemClickListener<movie>{
            override fun onItemClicked(res: movie) {

            }

        })

        ShowLoadingDialog()
        presenter.getGenre(object:DataListInterface<genre>{
            override fun onGetDataSuccess(res: List<genre>) {
                lsGenre.clear()
                lsGenre.addAll(res)


                presenter.getMovie(page, object:DataListInterface<movie>{
                    override fun onGetDataSuccess(res: List<movie>) {
                        DismisLoadingDialog()
                        lsMovie.clear()
                        lsMovie.addAll(res)
                        adp.notifyDataSetChanged()

                    }

                    override fun onGetDataFailed(error: String) {
                        DismisLoadingDialog()
                        Toast(error)
                    }
                })
            }

            override fun onGetDataFailed(error: String) {
                DismisLoadingDialog()
                Toast(error)
            }
        })







        recycler_view.adapter=adp
        recycler_view.layoutManager=LinearLayoutManager(this)
    }
}
