Social Sparks is an Android app built for anyone who’s tired of losing touch with the people who matter. It’s designed for real life — busy schedules, weird hours, and all the moments in between. If you ever forget to check in with friends or just don’t know what to say, this app picks up the slack.

Why does it matter? These days, everyone’s juggling too much. You want to send that text, hop on a quick call, or at least let someone know you’re thinking of them…but the day gets away (again). Social Sparks is here to fix that.

Here’s what it tackles:

- You forget to reach out — or you mean to, but something always comes up.
- It’s awkward to start a convo out of nowhere.
- You want to keep in touch, but you have zero energy to figure out what to say.

How does it help? Social Sparks offers simple prompts — we call them “sparks” — based on the time of day. Nothing complicated, just tiny nudges:

- Get reminders that don’t nag — just gentle suggestions when you’re most likely to act.
- Build stronger relationships with small gestures, instead of overwhelming “catch up” marathons.
- Make connecting feel fun and breezy, not like another item on your to-do list.
- These moments add up — a quick message here, a funny meme there. You’re staying close without even trying.

So what can you actually do with the app? Here are the highlights:

Main Features:

- Get sparks custom-picked for the time. Enter any time of day, get a suggestion that fits (or just let the app figure it out for you).
- Feeling spontaneous? Hit “Random Spark” for a surprise social prompt.
- Like a certain suggestion? Save it for next time with just one tap.
- Want to track your streak? Your last ten sparks are logged so you can see your progress.
- Share directly: Find something good? Send it via any app — text, chat, wherever.
- Finished or want a fresh start? Clear everything with a reset.
- Every tap feels real: Soft haptic feedback makes the app feel interactive.
- The design adapts to any phone, looks good on all screens, and handles errors gracefully.

A few examples of what Social Sparks pops up:

- Morning: Text “Good morning!” to a family member (or whoever needs it).
- Mid-morning: Thank a colleague for something — anything, just a nice gesture.
- Afternoon: Send a meme or a fun link to a friend.
- Snack time: Shoot a “thinking of you” message to someone.
- Dinner: Quick call to a friend or relative, even just five minutes.
- Night: Drop a thoughtful comment on a friend’s post.
- Feeling random? Maybe you’ll be asked to share a song, send a photo, or something totally different.

Design-wise, it’s easy on the eyes. The whole thing uses soft ocean tones — deep greens, calm lavenders, a little seafoam and gentle gradients. Text is always clear (black on white for headers and important info), and you won’t get lost looking for buttons: they’re color-coded to hint at what each one does.

A few basics the design keeps in mind:

- Super simple layout. No clutter, clean lines, card-based for easy scanning.
- Feels friendly and modern. Soft edges and rounded corners.
- The background isn’t boring, but it doesn’t distract either. Just enough gradient for a fresh vibe.
- Consistent spacing and typography — headers stand out, everything’s readable.
- Uses emojis and warm language, so the app feels like a friend, not a formality.

Tech details coming up next. Everything’s built with Kotlin, runs on Android, and uses persistent storage so your favorites and history stick around even after you close the app. It’s lightweight, responsive, and just works. 

Whether you’re looking to build better habits, or just want an excuse to check in, Social Sparks helps you stay close — one spark at a time.



### Key Dependencies
```gradle
dependencies {
    implementation 'androidx.core:core-ktx:1.12.0'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.11.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
}


##🎮 How to Use
Basic Usage
Enter Time: Type a time of day (e.g., "Morning", "Afternoon", "Dinner", "Night")

Get Spark: Tap the "Get Spark" button to receive your social suggestion

Reset: Tap "Reset" to clear all fields and start over


Advanced Features
Feature	How to Use
🎲 Random Spark	Tap "Surprise" for a random creative suggestion
🌊 Current Time	Tap "Current Time" to auto-detect and get suggestion
⭐ Favorites	Tap the star icon to save a suggestion
📜 History	Tap "History" to see your recent sparks
📤 Share	Tap "Share" to send a spark via messaging apps
🚪 Exit	Tap "Exit" to close the app


Input Examples
Morning → Good morning text suggestion

Mid-morning → Thank you message suggestion

Afternoon → Meme sharing suggestion

Afternoon Snack → Thinking of you message

Dinner → Call suggestion

Night or Evening → Comment suggestion


🎥 Video Demonstration
Watch the Video
https://youtu.be/sn3FPoZD9xY


Click the badge above to watch the complete app demonstration


📁 Code Structure
MainActivity - Key Functions
class MainActivity : AppCompatActivity() {
    
    // Time-based suggestion using when statement
    private fun getSocialSuggestion() {
        val suggestion = when {
            normalizedInput.contains("morning") -> "🌅 Send a 'Good morning' text..."
            normalizedInput.contains("mid-morning") -> "☕ Reach out to a colleague..."
            normalizedInput.contains("afternoon") -> "😄 Share a funny meme..."
            // ... more conditions
        }
    }
    
    // Random suggestion from list
    private fun getRandomSuggestion() {
        val randomSuggestion = randomSparks.random()
    }
    
    // Current time detection
    private fun getCurrentTimeSuggestion() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        // ... logic based on hour
    }
    
    // Favorite management with SharedPreferences
    private fun toggleFavorite() {
        val favorites = sharedPreferences.getStringSet(KEY_FAVORITES, mutableSetOf())
        // ... save/remove logic
    }
    
    // Share suggestion
    private fun shareSuggestion() {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            putExtra(Intent.EXTRA_TEXT, "✨ Social Sparks says: $currentSuggestion")
            type = "text/plain"
        }
    }
}


Code Quality Features
Comprehensive Comments: Every function is documented

Logging: Strategic logging for debugging

Error Handling: Graceful error messages

Efficient Code: No redundancy, clean structure


👩‍💻 Author
Levesh Moodley

Student Number: [ST10508270]

Module: IMAD5112 - Introduction to Mobile Application Development

Institution: The Independent Institute of Education

Contact
GitHub: @leveshmoodley-sketch

Email: [leveshmoodley@gmail.com]

