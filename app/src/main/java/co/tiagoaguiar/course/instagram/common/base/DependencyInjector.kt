package co.tiagoaguiar.course.instagram.common.base

import android.content.Context
import co.tiagoaguiar.course.instagram.add.data.AddFakeDataSource
import co.tiagoaguiar.course.instagram.add.data.AddLocalDataSource
import co.tiagoaguiar.course.instagram.add.data.AddRepository
import co.tiagoaguiar.course.instagram.home.data.FeedMemoryCache
import co.tiagoaguiar.course.instagram.home.data.HomeDataSourceFactory
import co.tiagoaguiar.course.instagram.home.data.HomeRepository
import co.tiagoaguiar.course.instagram.login.data.FakeDataSource
import co.tiagoaguiar.course.instagram.login.data.LoginRepository
import co.tiagoaguiar.course.instagram.post.data.PostLocalDataSource
import co.tiagoaguiar.course.instagram.post.data.PostRepository
import co.tiagoaguiar.course.instagram.profile.data.PostListMemoryCache
import co.tiagoaguiar.course.instagram.profile.data.ProfileDataSourceFactory
import co.tiagoaguiar.course.instagram.profile.data.ProfileMemoryCache
import co.tiagoaguiar.course.instagram.profile.data.ProfileRepository
import co.tiagoaguiar.course.instagram.register.data.FakeRegisterDataSource
import co.tiagoaguiar.course.instagram.register.data.RegisterRepository
import co.tiagoaguiar.course.instagram.splash.data.FakeLocalDataSource
import co.tiagoaguiar.course.instagram.splash.data.SplashRepository

object DependencyInjector {

  fun splashRepository() : SplashRepository {
    return SplashRepository(FakeLocalDataSource())
  }

  fun loginRepository() : LoginRepository {
    return LoginRepository(FakeDataSource())
  }

  fun registerEmailRepository() : RegisterRepository {
    return RegisterRepository(FakeRegisterDataSource())
  }

  fun profileRepository() : ProfileRepository {
    return ProfileRepository(ProfileDataSourceFactory(ProfileMemoryCache, PostListMemoryCache))
  }

  fun homeRepository() : HomeRepository {
    return HomeRepository(HomeDataSourceFactory(FeedMemoryCache))
  }

  fun addRepository(): AddRepository{
    return AddRepository(AddFakeDataSource(), AddLocalDataSource())
  }

  fun postRepository(context: Context): PostRepository {
    return PostRepository(PostLocalDataSource(context))
  }

}