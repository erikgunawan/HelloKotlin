package id.ergun.hellokotlin

import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(private val mainView: MainView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson) {

    fun getTeamList(league: String?) {
        mainView.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(ApiRepository.TheSportDBApi.getTeams(league)),
                    TeamResponse::class.java
            )

            uiThread {
                mainView.hideLoading()
                mainView.showTeamList(data.teams)
            }
        }
    }
}