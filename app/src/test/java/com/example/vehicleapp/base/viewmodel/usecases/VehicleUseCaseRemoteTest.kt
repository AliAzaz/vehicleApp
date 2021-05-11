package com.example.vehicleapp.base.viewmodel.usecases

import com.example.vehicleapp.MockTestUtil
import com.example.vehicleapp.base.repository.GeneralRepository
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * @author AliAzazAlam on 4/21/2021.
 */
@RunWith(JUnit4::class)
class VehicleUseCaseRemoteTest {

    @MockK
    private lateinit var repository: GeneralRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `test getSearchImages gives list of images`() = runBlocking {
        //Given
        val usecase = VehicleUseCaseRemote(repository)
        val mockImages = MockTestUtil.createImages()

        //When
/*        coEvery { repository.getSearchImages(1,"") }
            .returns(flowOf(mockImages))

        //Invoke
        val imageListFlow = usecase(1,"")

        //Then
        MatcherAssert.assertThat(imageListFlow, CoreMatchers.notNullValue())

        val imageListDataState = imageListFlow.first()
        MatcherAssert.assertThat(imageListDataState, CoreMatchers.notNullValue())

        MatcherAssert.assertThat(imageListDataState, CoreMatchers.notNullValue())
        MatcherAssert.assertThat(
            imageListDataState.imagesInfo.size,
            CoreMatchers.`is`(mockImages.imagesInfo.size)
        )*/


    }



    @After
    fun tearDown() {
    }
}