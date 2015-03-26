package com.momo.myfuncation.utils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.momo.myfuncation.R;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

/**
 * ImageCacheLoader工具
 * 
 * @author momo
 *         2014-12-27下午3:35:57
 */
public class ImageCacheUtil {

	/**
	 * 必须在application create的时候调用
	 * 
	 * @param context
	 */

	public static void init(Context context) {
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
				.threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory()
				.diskCacheFileNameGenerator(new Md5FileNameGenerator()).diskCacheSize(30 * 1024 * 1024)
				.tasksProcessingOrder(QueueProcessingType.LIFO).build();
		ImageLoader.getInstance().init(config);
	}

	static DisplayImageOptions	defaultOptions;
	static DisplayImageOptions	headPortraitOptions;
	static DisplayImageOptions	emptyOptions;

	public static DisplayImageOptions defaultOptions() {
		if (defaultOptions == null) {
			defaultOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true)
					.considerExifParams(true).showImageOnLoading(R.drawable.ic_launcher)
					.showImageForEmptyUri(R.drawable.ic_launcher).showImageOnFail(R.drawable.ic_launcher)
					.bitmapConfig(Bitmap.Config.RGB_565).build();
		}
		return defaultOptions;
	}

	public static DisplayImageOptions emptyOptions() {
		if (defaultOptions == null) {
			defaultOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true)
					.considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).build();
		}
		return defaultOptions;
	}

	public static class AnimateFirstDisplayListener extends SimpleImageLoadingListener {

		static final List<String>	displayedImages	= Collections.synchronizedList(new LinkedList<String>());

		@Override
		public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
			if (loadedImage != null) {
				ImageView imageView = (ImageView) view;
				boolean firstDisplay = !displayedImages.contains(imageUri);
				if (firstDisplay) {
					FadeInBitmapDisplayer.animate(imageView, 500);
					displayedImages.add(imageUri);
				}
			}
		}
	}
}
