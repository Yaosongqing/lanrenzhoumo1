package com.text.ysq.lanrenzhoumo.Https;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;

import com.text.ysq.lanrenzhoumo.R;
import com.text.ysq.lanrenzhoumo.Tools.LogUtils;

/**
 * 图片请求框架
 * 弊端：
 * 1、没有缓存
 * 2、没有压缩
 * @author yangjw
 *
 */
public class ImageAsyncLoader {

	public static final int MAX_HEIGHT = 400;
	
	public static ImageAsyncTask load(String path,ImageView imageView) {
		imageView.setTag(path);
		imageView.setImageResource(R.drawable.abc_ic_cab_done_holo_light);

		return new ImageAsyncTask(imageView, path);
	}
	
	public static class ImageAsyncTask extends AsyncTask<String, Integer, Bitmap> {

		private ImageView mImageView;
		private String path;
		public ImageAsyncTask(ImageView mImageView, String path) {
			super();
			this.mImageView = mImageView;
			this.path = path;
		}
		
		public void execute() {
			this.execute(path);
		}

		@Override
		protected Bitmap doInBackground(String... params) {
			InputStream is = null;
			try {
				URL url = new URL(params[0]);
				HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
				httpURLConnection.connect();
				if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
					is = httpURLConnection.getInputStream();
					int len = 0;
					byte[] buffer = new byte[1024];
					ByteArrayOutputStream arrayStream = new ByteArrayOutputStream();
					while((len = is.read(buffer)) != -1) {
						arrayStream.write(buffer, 0, len);
					}
					arrayStream.flush();
					byte[] streamByte = arrayStream.toByteArray();
					//二次采样，压缩图片
					BitmapFactory.Options options = new BitmapFactory.Options();
					options.inJustDecodeBounds = true;
					BitmapFactory.decodeByteArray(streamByte,0,streamByte.length,options);
					int outHeight = options.outHeight;
					Log.i(LogUtils.TAG, "doInBackground: outHeight="+options.outHeight);
					int heightRatio = outHeight/MAX_HEIGHT;
					options.inJustDecodeBounds = false;
					options.inSampleSize = heightRatio;
					Bitmap bitmap = BitmapFactory.decodeByteArray(streamByte, 0, streamByte.length,options);

					return bitmap;
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				close(is);
			}
			
			return null;
		}
		
		@Override
		protected void onPostExecute(Bitmap result) {
			super.onPostExecute(result);
			if (result == null ) {
				mImageView.setImageResource(R.drawable.abc_ic_clear_normal);
			} else if (path.equals(mImageView.getTag().toString())){
				mImageView.setImageBitmap(result);
			}
		}
		
	}
	
	private static void close(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
