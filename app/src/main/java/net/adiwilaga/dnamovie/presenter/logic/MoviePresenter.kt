package net.adiwilaga.dnamovie.presenter.logic

import id.co.xl.sisternet.presenter.viewinterface.DataListInterface
import id.co.xl.sisternet.presenter.viewinterface.DataObjectInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import net.adiwilaga.dnamovie.API.api
import net.adiwilaga.dnamovie.dnamovieApplication
import net.adiwilaga.dnamovie.model.genre
import net.adiwilaga.dnamovie.model.movie
import net.adiwilaga.dnamovie.model.moviedetail


class MoviePresenter{

    private var disposable: Disposable? = null
    val APIServices: api

    constructor(APIServices: api) {
        this.APIServices = APIServices
    }



    fun getMovie(page:Int,gen:String,lst:DataListInterface<movie>) {



        disposable=APIServices.getMovie("popularity.desc", dnamovieApplication.APIKEY,gen,page.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({res->

                if(res.results.size>0) {
                    var ipage = res.page
                    if (res.totalPages > res.page)
                        ipage++

                    lst.onGetDataSuccess(res.results, ipage)
                }else
                    lst.onGetDataFailed("No Data Available")

                },{  error->
                    if(!error.message.isNullOrEmpty())
                        lst.onGetDataFailed(error.message!!)
                    else
                        lst.onGetDataFailed("Service Error")
                })
    }
    fun getMovieDetail(mid:Int,lst:DataObjectInterface<moviedetail>) {



        disposable=APIServices.getMovieDetail(mid, dnamovieApplication.APIKEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({res->


                    lst.onGetDataSuccess(res)

            },{  error->
                if(!error.message.isNullOrEmpty())
                    lst.onGetDataFailed(error.message!!)
                else
                    lst.onGetDataFailed("Service Error")
            })
    }
    fun getGenre(lst:DataListInterface<genre>) {



        disposable=APIServices.getGenre( dnamovieApplication.APIKEY )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({res->

                if(res.genres.size>0)
                    lst.onGetDataSuccess(res.genres,0)
                else
                    lst.onGetDataFailed("No Data Available")

            },{  error->
                if(!error.message.isNullOrEmpty())
                    lst.onGetDataFailed(error.message!!)
                else
                    lst.onGetDataFailed("Service Error")
            })
    }
}