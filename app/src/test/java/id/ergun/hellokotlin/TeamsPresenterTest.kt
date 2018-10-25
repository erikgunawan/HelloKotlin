package id.ergun.hellokotlin

import com.google.gson.Gson
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class TeamsPresenterTest {

    @Mock
    private lateinit var teamsView: TeamsView

    @Mock
    private lateinit var apiRepository: ApiRepository

    @Mock
    private lateinit var gson: Gson

    private lateinit var presenter: TeamsPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = TeamsPresenter(teamsView, apiRepository, gson, ContextProviderTest())
    }

    @Test
    fun getTeamListTest() {
        val teams: MutableList<Team> = mutableListOf()
        val response = TeamResponse(teams)
        val league = "English Premiere League"

        `when`(gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeams(league)),
                TeamResponse::class.java
        )).thenReturn(response)

        presenter.getTeamList(league)

        verify(teamsView).showLoading()
        verify(teamsView).showTeamList(teams)
        verify(teamsView).hideLoading()
    }
}