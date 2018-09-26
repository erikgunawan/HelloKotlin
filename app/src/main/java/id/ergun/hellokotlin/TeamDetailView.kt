package id.ergun.hellokotlin

interface TeamDetailView {
    fun showLoading()
    fun hideLoading()
    fun showTeamDetail(data: List<Team>)
}