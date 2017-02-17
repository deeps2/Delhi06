# Delhi06 <img src="app/src/main/res/mipmap-xhdpi/ic_launcher.png"/> 
<b>Google PlayStore:</b> https://play.google.com/store/apps/details?id=com.shikhardeep.android.delhi06 </br>
<b>Video Demo:</b> https://www.youtube.com/watch?v=lHbmthUxH7c

ScreenShots
------------
<img src="/screenshots/1.jpg" width=300/>&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;<img src="/screenshots/2.jpg" width=300/>
<br/><br/><br/>
<img src="/screenshots/3.jpg" width=300/>&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;<img src="/screenshots/4.jpg" width=300/>

<b>NOTE: There are two branches for this project. master branch is the offline one. Second branch is firebase branch which reads contents from Firebase DB in real time via internet connection.</b>

<b>This readme is for firebase branch</b>

What's different in firebase branch
------------------------------------------
Unlike the code which is in master branch, this branch doesn't contains places' information (such as images, description, coordinates etc) inside the app code thus making the app size small.

The major advantage is, the app reads all the place information from the <b>Firebase DB in Real Time</b> via Internet. As there was no such API according to this Tour app requirements, I can upload a new place or modify existing place's information in Firebase DB (which is a NO-SQL DB) in JSON format whenever I want and Firebase will take care to push the changes across all the devices in milliseconds.

Unlike most apps which use a public API (such as Google Places API or Google Books API etc) to display the information, <b>this app doesn't uses any API to retrieve the place information</b>. All the information will be retrieved from Firebase DB. This will allow you to provide only those information which you need in your app and using Firebase as backend saves time also as you don't have to write any server side code or think about scalability. 

About App
---------
A simple tour app which will help you to explore famous places, restaurants, religious sites and shopping places in Delhi, India.

When you click on the CardView, a new activity will open which has detail description about the corresponding place. You can read the place description (in the Expandable TextView). Below that you can see a small Map with a marker at the place location. You can start navigation by clicking on the arrow in the Map. Contact Number is also provided and clicking on it will open the call-dialer screen. At the Bottom, there is an Image Slider showing different pictures of the place.

Components Used
-------------------
Firebase DB & Firebase Storage</br>
FirebaseRecyclerAdapter</br>
FirbaseUI</br>
GoogleMaps API</br>
Two External Libraries(see below)</br>
CoordinatorLayout, AppBarLayout, Toolbar</br>
Fragments, ViewPager, TabLayout, RecyclerView</br> 

<b>Pic Courtesy</b>: www.uplabs.com, GoogleImages, Wikipedia

Libraries Used
---------------
https://github.com/Manabu-GT/ExpandableTextView

https://github.com/daimajia/AndroidImageSlider

PlayStore:
----------
https://play.google.com/store/apps/details?id=com.shikhardeep.android.delhi06

Hope you will like it :-)
