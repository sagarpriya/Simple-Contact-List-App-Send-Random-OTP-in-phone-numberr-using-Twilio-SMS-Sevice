# Simple-Contact-List-App-Send-Random-OTP-in-phone-numberr-using-Twilio-SMS-Sevice
<<<<<<<<<BUILD A SIMPLE CONTACTS APP (WITH OTP SMS SENDING FUNCTIONALITY)>>>>>>

Overview
For this project, you will use a web / Android app that can send an OTP (via SMS) to a list of
contacts, one at a time.

This is Simple Contacts Android application which send Random OTP to phone number the phone number fetched through
JSON URL. The Contact list will display into Listview. And The details will store into Firebase Real-Time Database. In this Application we 
Fetch the OTP, date & Timestamp, and name of the contact person

To Send OTP to Phone Number i used Twilio SMS Service Free Trial Version Account to send OTP in Phone Numbers

Twilio is Third Party library so we have to add Dependency. 
compile 'com.twilio.sdk:twilio:7.23.0'

And also i used retrofit2 API
compile 'com.squareup.retrofit2:retrofit:2.1.0'


Dependency which i used
dependencies {
    implementation fileTree(include: ['*.jar'], dir: 'libs')
    implementation 'com.android.support:appcompat-v7:27.1.1'
    implementation 'com.android.support.constraint:constraint-layout:1.1.2'
    implementation 'com.android.support:support-v4:27.1.1'
    implementation 'com.google.firebase:firebase-database:16.0.1'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
    implementation 'com.android.support:design:27.1.1'
    // retrofit i was used to get twilio API
    compile 'com.twilio.sdk:twilio:7.23.0'
    compile 'com.squareup.retrofit2:retrofit:2.1.0'
    // multidex i added because i get some erorr
    implementation 'com.android.support:multidex:1.0.3'
    //firebase dependency
    implementation 'com.google.firebase:firebase-core:16.0.0'
    implementation 'com.firebaseui:firebase-ui-database:0.4.0'
    // cardview
    implementation 'com.android.support:cardview-v7:27.1.0'
    //recylerview
    implementation 'com.android.support:recyclerview-v7:27.1.1'
}
