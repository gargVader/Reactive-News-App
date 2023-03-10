# Reactive News App
![Kotlin](https://img.shields.io/badge/kotlin-%230095D5.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)

Android app that shows top headlines from News API and allows you to save for offline reading

# π· Previews
Download [apk](https://github.com/gargVader/Reactive-News-App/releases/tag/v1)

[Demo video πΉ](https://drive.google.com/file/d/1v7DwMtX6meV7R4MmEpq9Ybcdm-laAl8O/view?usp=sharing)
<p align="center">
  <img width="250" src="Screenshots/1.png" />
  <img width="250" src="Screenshots/2.png" />
</p>

# π  Tech Stacks & Open Source Libraries

- Jetpack Compose
- ViewModel
- Hilt
- Compose Navigation
- Room
- Retrofit
- moshi

# File structure

<details>
    <summary>Click me</summary>

  ```
ββββnewsapp
    β   App.kt
    β   MainActivity.kt
    β
    ββββdata
    β   ββββlocal
    β   β       ArticleDao.kt
    β   β       ArticleDatabase.kt
    β   β
    β   ββββmapper
    β   β       ArticleMapper.kt
    β   β
    β   ββββmodel
    β   β       ArticleEntity.kt
    β   β       ArticleResponse.kt
    β   β       NewsApiResponse.kt
    β   β       Source.kt
    β   β
    β   ββββremote
    β   β       NewsApi.kt
    β   β
    β   ββββrepository
    β           ArticleRepositoryImpl.kt
    β
    ββββdi
    β       AppModule.kt
    β       DatabaseModule.kt
    β       RepositoryModule.kt
    β
    ββββdomain
    β   ββββrepository
    β           ArticleRepository.kt
    β
    ββββpresentation
    β   β   WebViewScreen.kt
    β   β
    β   ββββcommon
    β   β       ArticleCard.kt
    β   β
    β   ββββhome_screen
    β   β       ArticleItem.kt
    β   β       HomeScreen.kt
    β   β       HomeScreenState.kt
    β   β       HomeScreenViewModel.kt
    β   β
    β   ββββnavigation
    β   β       MainGraph.kt
    β   β       MainScreen.kt
    β   β       RootGraph.kt
    β   β       Screen.kt
    β   β
    β   ββββsaved_screen
    β           SavedArticleItem.kt
    β           SavedScreen.kt
    β           SavedScreenState.kt
    β           SavedScreenViewModel.kt
    β
    ββββui
    β   ββββtheme
    β           Color.kt
    β           Shape.kt
    β           Theme.kt
    β           Type.kt
    β
    ββββutil
            Resource.kt
  ```

</details>

