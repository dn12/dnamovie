package net.adiwilaga.dnamovie.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.co.xl.sisternet.presenter.viewinterface.DataListInterface
import id.co.xl.sisternet.presenter.viewinterface.DataObjectInterface
import id.co.xl.sisternet.presenter.viewinterface.ItemClickListener
import kotlinx.android.synthetic.main.activity_main.*
import net.adiwilaga.dnamovie.BuildConfig
import net.adiwilaga.dnamovie.R
import net.adiwilaga.dnamovie.model.genre
import net.adiwilaga.dnamovie.model.movie
import net.adiwilaga.dnamovie.model.moviedetail
import net.adiwilaga.dnamovie.presenter.adapter.MovieListAdapter
import net.adiwilaga.dnamovie.presenter.logic.MoviePresenter
import java.util.*


class MainActivity : BaseActivity() {


    lateinit var presenter:MoviePresenter
    var page=1

    lateinit var lsMovie:ArrayList<movie>
    lateinit var lsGenre:ArrayList<genre>
    lateinit var lssGenre:ArrayList<String>
    lateinit var adp:MovieListAdapter
    lateinit var gadp:ArrayAdapter<String>
    var gen=0
    var onload=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter= MoviePresenter(APIServices)
        lsMovie=ArrayList()
        lsGenre=ArrayList()
        lssGenre=ArrayList()

        adp= MovieListAdapter(lsMovie,lsGenre,this,object:ItemClickListener<movie>{
            override fun onItemClicked(res: movie) {
                gotoDetail(res)

            }

        })

        ShowLoadingDialog()
        presenter.getGenre(object:DataListInterface<genre>{
            override fun onGetDataSuccess(res: List<genre>,pg:Int) {
                lsGenre.clear()
                lsGenre.addAll(res)

                lssGenre.clear()
                lssGenre.add("All")
                for(s in res){
                    lssGenre.add(s.name)
                }
                gadp.notifyDataSetChanged()

                getMovie()
            }

            override fun onGetDataFailed(error: String) {
                DismisLoadingDialog()
                Toast(error)
            }
        })







        recycler_view.adapter=adp
        recycler_view.layoutManager=LinearLayoutManager(this)
        recycler_view.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    getMovie()
                }
            }
        })




        gadp= ArrayAdapter(ctx,android.R.layout.simple_dropdown_item_1line,lssGenre)
        spgenre.adapter=gadp
        spgenre.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {
                gen=pos
                page=1
                getMovie()
            }

        }


    }

    fun getMovie(){
        if(!onload && page>0) {
            onload=true
            ShowLoadingDialog()


            var sgen = ""
            if (gen > 0)
                sgen = lsGenre.get(gen - 1).id.toString()


            presenter.getMovie(page, sgen, object : DataListInterface<movie> {
                override fun onGetDataSuccess(res: List<movie>, pg: Int) {
                    onload=false
                    DismisLoadingDialog()
                    if (page == 1)
                        lsMovie.clear()

                    lsMovie.addAll(res)
                    page = pg
                    adp.notifyDataSetChanged()

                }

                override fun onGetDataFailed(error: String) {
                    onload=false
                    DismisLoadingDialog()
                    Toast(error)
                }
            })
        }
    }


    fun gotoDetail(mov:movie){

        ShowLoadingDialog()
        presenter.getMovieDetail(mov.id,object :DataObjectInterface<moviedetail>{
            override fun onGetDataSuccess(res: moviedetail) {
                DismisLoadingDialog()
                var ii= Intent(ctx, MovieDetailActivity::class.java)
                res.sgenre=mov.sgenre
                ii.putExtra("movie",res)
                startActivity(ii)


            }

            override fun onGetDataFailed(res: String) {
                DismisLoadingDialog()
                Toast(res)
            }

        })



    }
}
