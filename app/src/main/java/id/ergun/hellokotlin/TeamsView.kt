package id.ergun.hellokotlin

interface TeamsView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}