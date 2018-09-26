package id.ergun.hellokotlin

import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamsPresenter(private val teamsView: TeamsView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson) {

    fun getTeamList(league: String?) {
        teamsView.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(ApiRepository.TheSportDBApi.getTeams(league)),
                    TeamResponse::class.java
            )

            uiThread {
                teamsView.hideLoading()
                teamsView.showTeamList(data.teams)
            }
        }
    }
}