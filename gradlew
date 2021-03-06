<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    package="com.example.ayush.qapp" >

    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

    <application
        android:icon="@mipmap/my_icon"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/my_icon"
        android:supportsRtl="true"
        android:theme="@style/AppTheme" >
        <meta-data
            android:name="com.google.android.gms.ads.APPLICATION_ID"
            android:value="ca-app-pub-1203140157527769~6707095223" />
        <meta-data
            android:name="preloaded_fonts"
            android:resource="@array/preloaded_fonts" />

        <activity
            android:name=".MainActivity"
            android:label="@string/app_name"
            android:theme="@style/AppTheme.NoActionBar" />
        <activity
            android:name=".Love_Quotes"
            android:label="@string/love_quotes"
            android:parentActivityName=".MainActivity"
            android:theme="@style/AppTheme.NoActionBar" />
        <activity
            android:name=".Inspiration_Quotes"
            android:label="@string/inspirtaional_quotes"
            android:parentActivityName=".MainActivity"
            android:theme="@style/AppTheme.NoActionBar" />
        <activity
            android:name=".Breakup_Quotes"
            android:label="@string/break_quotes"
            android:parentActivityName=".MainActivity"
            android:theme="@style/AppTheme.NoActionBar" />
        <activity
            android:name=".Friendship_Quotes"
            android:label="@string/friendship_quotes"
            android:parentActivityName=".MainActivity"
            android:theme="@style/AppTheme.NoActionBar" />
        <activity
            android:name=".Favorite_Quotes"
            android:label="@string/favourite_quotes"
            android:parentActivityName=".MainActivity"
            android:theme="@style/AppTheme.NoActionBar" />
        <activity
            android:name=".Motivational_Quotes"
            android:label="@string/motivational_quotes"
            android:parentActivityName=".MainActivity"
            android:theme="@style/AppTheme.NoActionBar" />
        <activity
            android:name=".Failure_Quotes"
            android:label="@string/failure_quotes"
            android:parentActivityName=".MainActivity"
            android:theme="@style/AppTheme.NoActionBar" />
        <activity
            android:name=".Witty_Quotes"
            android:label="@string/witty_quotes"
            android:parentActivityName=".MainActivity"
            android:theme="@style/AppTheme.NoActionBar" />
        <activity
            android:name=".Help"
            android:label="@string/help"
            android:parentActivityName=".MainActivity"
            android:screenOrientation="portrait" />
        <activity android:name=".SplashScreen" >
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <action android:name="android.intent.action.VIEW" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity
            android:name=".Settings"
            android:label="Settings"
            android:parentActivityName=".MainActivity"
            android:screenOrientation="portrait" />
        <activity android:name=".solidColors" >
        </activity>
    </application>

</manifest>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    