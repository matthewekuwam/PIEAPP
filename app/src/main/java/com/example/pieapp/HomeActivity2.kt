package com.example.pieapp

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.material.circularreveal.cardview.CircularRevealCardView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.slider.Slider

class HomeActivity2 : AppCompatActivity() {
    private lateinit var mAdView: AdView
    private lateinit var image_slider:ImageSlider

    private lateinit var tvname:TextView
private lateinit var card_about:CircularRevealCardView
private lateinit var card_causes:CircularRevealCardView
private lateinit var card_symptom:CircularRevealCardView
private lateinit var card_prevention:CircularRevealCardView
private lateinit var card_toll_free:CircularRevealCardView
private lateinit var card_location:CircularRevealCardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)
        tvname = findViewById(R.id.tvname)
//        receiving data that was sent from previous actvity
       val username = intent.getStringExtra("username")
        tvname.text = username
//        initializing the cards
card_about = findViewById(R.id.card_about)
card_causes = findViewById(R.id.card_causes)
card_symptom = findViewById(R.id.card_symptoms)
card_prevention = findViewById(R.id.card_prevention)
card_toll_free = findViewById(R.id.card_toll_free)
card_location = findViewById(R.id.card_location)
image_slider = findViewById(R.id.image_slider)

card_about.setOnClickListener{
    val cardnumber = 0
    navigateToDetails(cardnumber)
}
card_causes.setOnClickListener{
    val cardnumber =1
    navigateToDetails(cardnumber)
}
card_symptom.setOnClickListener{
    val cardnumber = 2
    navigateToDetails(cardnumber)
}
  card_prevention.setOnClickListener{
            val cardnumber = 3
            navigateToDetails(cardnumber)
        }
 card_toll_free.setOnClickListener{
            val cardnumber = 4
            navigateToDetails(cardnumber)
        }
 card_location.setOnClickListener{
           val mapsActivity = Intent(this,MapsActivity::class.java)
     startActivity(mapsActivity)
        }
        //add this after setContentView(R.layout.activity_main)
        mAdView = findViewById(R.id.adView)


        loadCarousel()
        initializeAds()
        loadBannerAd()



    }

    private fun loadCarousel() {
        val imageList = ArrayList<SlideModel>() // Create image list

        imageList.add(SlideModel("https://thumbs.dreamstime.com/b/modern-house-solar-panels-roof-beautiful-modern-house-solar-panels-roof-interior-exterior-147125536.jpg", "New house", ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel("https://thumbs.dreamstime.com/b/beautiful-village-house-garden-picture-56425297.jpg", "Classic House with flower garden",ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel("https://thumbs.dreamstime.com/b/classy-furniture-wooden-terrace-green-beautiful-garden-furniture-wooden-terrace-green-beautiful-garden-213239390.jpg", "Cape cod house",ScaleTypes.CENTER_CROP))

        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)
        imageSlider.startSliding(3000) // with new period


    }

    private fun initializeAds() {
        MobileAds.initialize(this) { }

    }

    private fun  navigateToDetails(cardnumber :Int){
        startActivity(Intent(this,DetailActivity::class.java).putExtra("cardnumber",cardnumber))
     }
    private fun loadBannerAd() {
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }


    override fun onStart() {
        super.onStart()
//        requesting for run time permission (allow this app to use location in your phoe)
        if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                1
            )
        }

    }

    }
