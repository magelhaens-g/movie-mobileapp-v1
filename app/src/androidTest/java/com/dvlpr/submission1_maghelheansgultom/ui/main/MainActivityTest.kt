package com.dvlpr.submission1_maghelheansgultom.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.dvlpr.submission1_maghelheansgultom.R
import com.dvlpr.submission1_maghelheansgultom.utils.DataDummy
import com.dvlpr.submission1_maghelheansgultom.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTVShows()

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadTvShows() {
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date)).check(matches(withText(dummyMovie[0].releaseDate)))
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(dummyMovie[0].genre)))
        onView(withId(R.id.tv_director_value)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_director_value)).check(matches(withText(dummyMovie[0].director)))
        onView(withId(R.id.tv_rating_value)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating_value)).check(matches(withText(dummyMovie[0].rating)))
        onView(withId(R.id.tv_desc_value)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_desc_value)).check(matches(withText(dummyMovie[0].desc)))
        onView(withId(R.id.imageView2)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.tv_status)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_status)).check(matches(withText(dummyTvShow[0].status)))
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(dummyTvShow[0].genre)))
        onView(withId(R.id.tv_creator_value)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_creator_value)).check(matches(withText(dummyTvShow[0].creator)))
        onView(withId(R.id.tv_rating_value)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating_value)).check(matches(withText(dummyTvShow[0].rating)))
        onView(withId(R.id.tv_desc_value)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_desc_value)).check(matches(withText(dummyTvShow[0].desc)))
        onView(withId(R.id.imageView2)).check(matches(isDisplayed()))
    }

    @Test
    fun backButton() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_back)).perform(click())
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_back)).perform(click())
    }

    @Test
    fun loadFavoriteMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_fav)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_fav)).perform(click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
    }

    @Test
    fun loadFavoriteTvShows() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_fav)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_fav)).perform(click())
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
    }

    @Test
    fun addAndRemoveFavoriteMovie(){
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_favorite)).perform(click())
        pressBack()
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_fav)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_fav)).perform(click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_favorite)).perform(click())
        pressBack()
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_not_found_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_not_found_movie)).check(matches(isDisplayed()))
    }

    @Test
    fun addAndRemoveFavoriteTvShow(){
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_favorite)).perform(click())
        pressBack()
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_fav)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_fav)).perform(click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_favorite)).perform(click())
        pressBack()
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_not_found_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_not_found_tv_show)).check(matches(isDisplayed()))
    }
}