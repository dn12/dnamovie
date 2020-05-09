package id.co.xl.sisternet.presenter.viewinterface

interface DataListInterface<T> {

    fun onGetDataSuccess(res:List<T>, pg:Int)
    fun onGetDataFailed(error:String)

}