package com.example.android.miwok;

/**
 * Created by subham on 11-10-2017.
 */

public class word {

   private String mDefaultTranslation;
   private String mMiwokTranslation;
   private int mImageResourceId=NO_IMAGE_FOUND;
   private static final int NO_IMAGE_FOUND=-1;
   private int mAudioResourceId;

    public word(String defaultTranslation,String miwokTranslation,int audioResourceId)
    {
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        mAudioResourceId=audioResourceId;
    }


    public word(String defaultTranslation,String miwokTranslation,int imageId,int audioResourceId)
    {
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        mImageResourceId=imageId;
        mAudioResourceId=audioResourceId;
    }

    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation()
    {
        return mMiwokTranslation;
    }

    public int getImageResourceId()
    {
        return mImageResourceId;
    }

    public int getAudioResourceId()
    {
        return mAudioResourceId;
    }

    public boolean hasImage()
    {
        return mImageResourceId!=NO_IMAGE_FOUND;
    }
}
