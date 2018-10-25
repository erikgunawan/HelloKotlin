package id.ergun.hellokotlin

object TheSportDBApi {

//    fun getTeams(league: String?): String {
        fun getTeams(league: String?): String {
//            return Uri.parse(BuildConfig.BASE_URL).buildUpon()
//                    .appendPath("api")
//                    .appendPath("v1")
//                    .appendPath("json")
//                    .appendPath(BuildConfig.TSDB_API_KEY)
//                    .appendPath("search_all_teams.php")
//                    .appendQueryParameter("l", league)
//                    .build()
//                    .toString()
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/search_all_teams.php?l=" + league
    }

    fun getTeamDetail(teamId: String?): String {
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookupteam.php?id=" + teamId
    }
}