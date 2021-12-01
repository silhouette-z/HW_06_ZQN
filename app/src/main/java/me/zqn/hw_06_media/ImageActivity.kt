package me.zqn.hw_06_media

import android.os.Bundle

import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class ImageActivity : AppCompatActivity() {
    private val pages: MutableList<View> = ArrayList()
    var viewPager : ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        addImage("https://imgs.niusnews.com/upload/imgs/default/2017FebC/0209C/2.jpg")
        addImage("https://inews.gtimg.com/newsapp_bt/0/9081788294/1000")
        addImage("https://img.liuxue86.com/images/20180203/f6bb99c71b457762867cf98186e997fe.gif")
        addImage("https://img.ratoo.net/uploads/allimg/191111/7-191111162347.gif")
        val adapter = ViewAdapter()
        viewPager = findViewById(R.id.view_pager)
        adapter.setDatas(pages)
        viewPager!!.adapter = adapter
    }

    private fun addImage(path: String) {
        val imageView = layoutInflater.inflate(R.layout.activity_image_item, null) as ImageView
        Glide.with(this)
                .load(path)
                .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
                .error(R.drawable.error) //.transition(withCrossFade(4000))
                //.override(100, 100)
                .into(imageView)
        pages.add(imageView)
    }
}