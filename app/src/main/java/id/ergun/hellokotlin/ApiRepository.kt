package id.ergun.hellokotlin

import android.net.Uri
import java.net.URL

class ApiRepository {

    fun doRequest(url: String) : String {
        return URL(url).readText()
    }

    object TheSportDBApi {
//        fun getTeams(league: String?): String {
//            return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/search_all_teams.php?l=" + league
//        }

        fun getTeams(league: String?): String {
            return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                    .appendPath("api")
                    .appendPath("v1")
                    .appendPath("json")
                    .appendPath(BuildConfig.TSDB_API_KEY)
                    .appendPath("search_all_teams.php")
                    .appendQueryParameter("l", league)
                    .build()
                    .toString()
        }

        fun getTeamDetail(teamId: String?): String{
            return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                    .appendPath("api")
                    .appendPath("v1")
                    .appendPath("json")
                    .appendPath(BuildConfig.TSDB_API_KEY)
                    .appendPath("lookupteam.php")
                    .appendQueryParameter("id", teamId)
                    .build()
                    .toString()
        }
    }
}