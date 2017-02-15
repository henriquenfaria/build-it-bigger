Build It Bigger
======

This is Build It Bigger project of Udacity's Android Developer Nanodegree.
The purpose of this project was to built an app with multiple flavors that uses multiple libraries and Google Cloud Endpoint.

The finished app consists of 4 modules:

1. A Java library that provides jokes
2. A Google Cloud Endpoints (GCE) project that serves those jokes
3. An Android Library containing an activity for displaying jokes
4. An Android app that fetches jokes from the GCE module and passes them to the Android Library for display. Paid and Free (with ads) flavors.


Screens
------

![alt text](https://github.com/henriquenfaria/build-it-bigger/blob/master/art/main.png "Main")
![alt text](https://github.com/henriquenfaria/build-it-bigger/blob/master/art/joke.png "Joke")


Instructions
------
The code Google Cloud Endpoint is already configured to run properly on a Android Virtual Device. You just need to run the jokes-backend and run the app. If want to test it on a real device, please follow the instructions below:

1. Create a gradle.properties file inside your user's gradle file. On Windows, this is usually located at: `C:\Users\Username\.gradle` (replace Username path with your Windows user).
2. Edit this file and put the following line: `MyIpAddress="http://IP-ADDRESS:8080/_ah/api/"`
3. Replace the IP-ADDRESS part with the IP addres your real devices is connected to. For example: 192.168.0.105
4. Save the file and restart/run jokes-backend

Libraries
------

This project uses the following library:

[FindBugs Jsr305] (https://mvnrepository.com/artifact/com.google.code.findbugs/jsr305)


License
------

> Copyright 2017 Henrique Nunes Faria

> Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

> http://www.apache.org/licenses/LICENSE-2.0

> Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
