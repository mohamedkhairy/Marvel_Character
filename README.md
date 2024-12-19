# Marvel Character

<h3> This app was built following Multi-module Architecture (Modularization) 
<h3> Each feature module is built upon the clean Architecture layers packages
<h4> using Gradle version catalog for dependency management
<h4> Jetpack compose for building UI state
<h4> Compose navigation system
<h4> Dagger Hilt<br>
<h4> Unit Test<br>
<h4> Compose UI Test<be>
<h4> APK -> https://github.com/mohamedkhairy/Marvel_Character/blob/master/app/release/app-release.apk
  
<br>
<h3> ******* ->  
<h4>secrets.defaults.properties -> to run the code you should provide public-key and private-key in this file 
<h3>The App module</h3>
<h5>app -> have MainActivity, the navigation system of the app, and application class</h5>
<h5>core -> have the most usable components through the app</h5>
<h5>feature.Home -> <br> the home screen, that List of Marvel Characters, also it contains a unit test and Compose UI test for this module</h5>
<h5>feature.Details -> <br> The Details screen, which display the details related to the selected Character</h5>



<br>
<h3> *** There is a to-do list for what should be done next. ->
<h5> Remove the hard-coded text on the string.xml file
<h5> Perform a Unit test and UI test on the Details module and ensure they work as expected.
<h5> there's also some enhancement related to the UI



