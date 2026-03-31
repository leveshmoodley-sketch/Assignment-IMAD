Social Sparks - Stay Connected App

Developer: [Levesh Moodley]  
Student Number: [ST10508270]  
Group: [1]  
Course: Introduction to Mobile Application Development  
Subject: IMAD5112

Links  
GitHub Repository: https://github.com/leveshmoodley-sketch/Assignment-IMAD
YouTube Video: https://youtu.be/sn3FPoZD9xY

---

Project Overview

Social Sparks is a mobile app I built for the Introduction to Mobile Application Development course. It runs on Kotlin and Android Studio. The app’s main focus is pretty simple: help people keep in touch by giving small, easy suggestions for connecting with others, based on what time it is.

I made this app to cover all the assignment requirements. That meant I had to write functional code that handled decisions using if statements, manage errors gracefully, and get familiar with GitHub for version control. The project also got a boost from GitHub Actions, which automated testing and code deployment.

---

Purpose and Features

Purpose  
Social Sparks tries to make keeping in touch less of a headache. When life gets busy, social connections slip through the cracks. This app tosses out quick ideas for connecting with friends, family, and coworkers throughout the day.

Key Features  
- Time-Based Suggestions: Just enter the time of day (morning, afternoon, dinner, night, etc.) and the app gives you a fitting social idea.
- Detects Current Time: If you’re not sure what to enter, it grabs the device’s time and suggests something on its own.
- Random Sparks: Need a little inspiration? The app can generate random, creative suggestions for you.
- Favorite Sparks: Save your best suggestions for later—stored with SharedPreferences so you’ll always find them quickly.
- Suggestion History: It keeps track of your last 10 suggestions, so you can look back at what you’ve tried.
- Share Feature: Send suggestions to friends directly with messaging apps or social media.
- Reset Function: Clear everything with a single tap.
- Error Handling: If you put something in wrong, the app’s replies are friendly and encouraging—not annoying or confusing.

The goal is for everything to feel smooth and easy, so you don’t get burned out by trying to stay connected.

---

Design Considerations

When putting together Social Sparks, I thought a lot about:

1. User Experience (UX): I wanted the app to feel simple and straightforward. Buttons are clear and everything flows fast—it’s easy to go from entering info to getting a suggestion. And the Ocean Breeze palette keeps things calm and stress-free.
2. Responsiveness: Whether you’re using a tiny phone or a big tablet, the app adjusts with Material Design components, so it looks good everywhere.
3. Simplicity: The whole layout stays minimal. Only what matters pops up—no clutter, less stress, and more accessibility.
4. Performance: The code’s snappy and light. Suggestions show up instantly after tapping and the app won’t drain your battery.
5. Accessibility: High contrast text makes things readable, even if you have vision difficulties. Buttons react visually and with haptic feedback for every interaction.
6. Color Psychology: Teals and seafoam greens set a relaxing mood. Lavender and sage accents keep it visually appealing but never distracting.

---

GitHub and GitHub Actions

GitHub handled all my version control. I made regular commits and pushes, so I could track progress and keep the codebase solid throughout development.

GitHub Repository Structure:
social-sparks-app/
├── .github/
│ └── workflows/
│ └── build.yml # CI/CD automation workflow
├── app/
│ ├── src/
│ │ ├── main/
│ │ │ ├── java/com/example/socialsparks/
│ │ │ │ └── MainActivity.kt
│ │ │ ├── res/
│ │ │ │ ├── drawable/
│ │ │ │ │ ├── gradient_background_chill.xml
│ │ │ │ │ └── suggestion_background_chill.xml
│ │ │ │ ├── layout/
│ │ │ │ │ └── activity_main.xml
│ │ │ │ └── values/
│ │ │ │ ├── colors.xml
│ │ │ │ └── themes.xml
│ │ │ └── AndroidManifest.xml
│ │ └── test/
│ └── build.gradle
├── README.md
└── .gitignore

GitHub Actions

I set up GitHub Actions to take care of building and testing automatically. Every time I push something to the main branch, the app runs through a build to make sure nothing’s broken. Tests run right after, so I catch bugs early. The workflow doesn’t just build—I get APK files uploaded as artifacts, ready to download and test on any device. Plus, it checks if the app builds on other environments, not just my machine, so there’s less chance of surprises down the road.

Inside the workflow file (`.github/workflows/build.yml`), I configured it to:
- Set up JDK 17, since the app uses Kotlin
- Run the Gradle build
- Execute the test suite
- Upload APK artifacts

This automation means I don’t have to worry about missing builds or letting bugs slip by. Every push gets a fresh build and test run, making delivery smoother.

---

Screenshots

--Uploaded on the main branch--

Video Demo:
Check out a video demo of the app here: [https://youtu.be/sn3FPoZD9xY]

---

Challenges and Learnings

Building this app wasn’t always smooth sailing. Here’s what I wrestled with:

1. SharedPreferences for Favorites and History
Saving suggestions needed to stick between app sessions. I dove into SharedPreferences and set up StringSet storage for favorites and history. Along the way, I had to manage null values to keep the data persistent after restarts.

2. Star Icon Tint Attribute Error
Tried using `android:tint` for the star icon, but it didn’t work on older devices. Switching to `app:tint` (the Material Components version) solved it and forced me to pay attention to correct namespace prefixes for Android features.

3. Case-Insensitive Input Matching
Users type all kinds of variations—“Morning,” “morning,” or “MORNING”—and expect the same results. I normalized input using `.lowercase()` and built flexible pattern matching for variations like “mid-morning” and “afternoon snack.”

4. GitHub Actions Build Configuration
My first workflow failed because Gradle didn’t have permissions. I added `chmod +x gradlew` to fix that, plus configured JDK 17 so Kotlin would play nicely.

These issues taught me a lot about debugging, version control, Android compatibility quirks, and setting up automated builds with GitHub Actions.

---

Future Enhancements

The app works well now, but there’s plenty more I’d like to add:

1. Dark Mode: Automatic theme switching to make the app nicer for night use.
2. Notification Reminders: Daily nudges that help users keep connected.
3. Widget Support: Quick suggestions on your home screen without opening the app.
4. Cloud Sync: Use Firebase to sync favorites across devices.
5. More Spark Categories: Mood-based and relationship-specific suggestions.
6. Analytics Dashboard: Track user engagement and visualize streaks.
7. Contact Integration: Connect with device contacts for instant actions—only with permission.

---

References

The Independent Institute of Education (2026). *Introduction to Mobile Application Development: IMAD5112/p/w Module Manual 2026*. [Unpublished course material].

---

List of Figures

- Figure 1: Main screen with empty state
- Figure 2: Suggestion after entering "Morning"
- Figure 3: Current time detection feature
- Figure 4: Random spark suggestion
- Figure 5: History dialog showing recent suggestions
- Figure 6: Favorite star highlighted
- Figure 7:Exit

---

Disclosure of AI Usage in My Assessment

I used AI tools to help out with several parts of the project. Here’s the rundown:

Section(s) where Generative AI was used:
- Code Development: Help with Kotlin syntax and Android Studio setup
- GitHub Actions: Creating and tweaking the workflow config
- Documentation: Structuring and formatting this README
- Debugging: Understanding and fixing error messages

Name of AI Tool(s) Used:
- Claude
- GitHub Copilot (GitHub)

Purpose/Intention:
- Code Assistance: Copilot helped write parts of the Kotlin code—especially for "when" statements and saving things with SharedPreferences.
- Meaning Making: ChatGPT clarified how GitHub Actions works and explained Android lifecycle methods.
- Debugging: AI helped me sort out tint attribute problems and Gradle config issues.
- Documentation Structure: Used AI to organize the README and make sure I included everything required.

Dates AI Was Used:
- Code Development: Throughout March 2026
- GitHub Actions Setup: March 25, 2026
- Documentation: March 30, 2026
- Debugging: March 28, 2026

Links to AI Chat(s) or Screenshots:

**On main*


Note: I reviewed, understood, and adapted all code and documentation myself. AI tools were just there for learning and troubleshooting—they didn’t replace my own work.

