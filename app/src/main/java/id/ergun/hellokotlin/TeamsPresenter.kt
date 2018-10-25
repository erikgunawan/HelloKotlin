package id.ergun.hellokotlin

import com.google.gson.Gson
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class TeamsPresenter(private val teamsView: TeamsView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson,
                     private val contextProvider: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getTeamList(league: String?) {
        teamsView.showLoading()

        async(contextProvider.main){
            val data = bg {
                gson.fromJson(apiRepository
                        .doRequest(TheSportDBApi.getTeams(league)),
                        TeamResponse::class.java
                )
            }

            teamsView.showTeamList(data.await().teams)
            teamsView.hideLoading()
        }
    }
}