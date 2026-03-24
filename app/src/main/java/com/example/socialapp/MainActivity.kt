package com.example.socialapp

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.Build
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresPermission
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import java.util.Calendar

/**
 * Social Sparks App - Main Activity
 * IMAD5112 Assignment 1
 *
 * This app provides social interaction suggestions based on the time of day input.
 * Features include: Random suggestions, Favorites, History, Share, and Current Time detection
 *
 * @author [Levesh Moodley]
 * @studentNumber [ST10508270]
 * @version 2.0
 */
class MainActivity : AppCompatActivity() {

    // Tag for logging
    companion object {
        private const val TAG = "SocialSparksApp"
        private const val PREFS_NAME = "SocialSparksPrefs"
        private const val KEY_FAVORITES = "favorites"
        private const val KEY_HISTORY = "history"
    }

    // UI Components
    private lateinit var etTimeInput: TextInputEditText
    private lateinit var btnGetSuggestion: Button
    private lateinit var btnReset: Button
    private lateinit var btnExit: Button
    private lateinit var btnRandom: Button
    private lateinit var btnShare: Button
    private lateinit var btnCurrentTime: Button
    private lateinit var btnHistory: Button
    private lateinit var btnFavorite: ImageButton
    private lateinit var tvSuggestion: TextView
    private lateinit var tvTimeDisplay: TextView

    // Data variables
    private lateinit var sharedPreferences: SharedPreferences
    private var currentSuggestion = ""
    private var isFavorite = false

    // Random suggestions list
    private val randomSparks = listOf(
        "🎵 Send a song that reminds you of a friend",
        "📸 Share a throwback photo with a loved one",
        "💌 Write a handwritten note (or text) to someone special",
        "🎮 Invite a friend for a quick online game",
        "📚 Recommend a book or podcast to a friend",
        "🌱 Send a plant picture and ask how someone's day is going",
        "☕ Surprise a coworker with coffee",
        "🎉 Send a birthday wish (even if it's not their birthday!)",
        "🎨 Share a funny meme that made you laugh today",
        "📞 Call someone you haven't spoken to in a while",
        "💝 Send a random compliment to a friend",
        "🍪 Bake cookies and share them with a neighbor",
        "📖 Share an interesting fact you learned today",
        "🎬 Recommend a movie or TV show to watch",
        "🌿 Send a relaxing meditation or nature video"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: Activity started - Initializing UI components")

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        // Initialize UI components
        initializeViews()

        // Set up click listeners
        setupClickListeners()

        Log.i(TAG, "App initialized successfully - Ready for user input")
    }

    /**
     * Initialize all view components
     */
    private fun initializeViews() {
        etTimeInput = findViewById(R.id.etTimeInput)
        btnGetSuggestion = findViewById(R.id.btnGetSuggestion)
        btnReset = findViewById(R.id.btnReset)
        btnExit = findViewById(R.id.btnExit)
        btnRandom = findViewById(R.id.btnRandom)
        btnShare = findViewById(R.id.btnShare)
        btnCurrentTime = findViewById(R.id.btnCurrentTime)
        btnHistory = findViewById(R.id.btnHistory)
        btnFavorite = findViewById(R.id.btnFavorite)
        tvSuggestion = findViewById(R.id.tvSuggestion)
        tvTimeDisplay = findViewById(R.id.tvTimeDisplay)

        Log.v(TAG, "All views initialized successfully")
    }

    /**
     * Set up click listeners for buttons
     */
    private fun setupClickListeners() {
        // Get Suggestion Button Click Listener
        btnGetSuggestion.setOnClickListener {
            Log.d(TAG, "Get Suggestion button clicked")
            vibratePhone()
            getSocialSuggestion()
        }

        // Reset Button Click Listener
        btnReset.setOnClickListener @androidx.annotation.RequiresPermission(android.Manifest.permission.VIBRATE) {
            Log.d(TAG, "Reset button clicked - Clearing all fields")
            vibratePhone()
            resetFields()
        }

        // Exit Button Click Listener
        btnExit.setOnClickListener {
            Log.d(TAG, "Exit button clicked - Closing app")
            vibratePhone()
            finishAffinity()
        }

        // Random Suggestion Button
        btnRandom.setOnClickListener {
            Log.d(TAG, "Random button clicked")
            vibratePhone()
            getRandomSuggestion()
        }

        // Share Button
        btnShare.setOnClickListener {
            Log.d(TAG, "Share button clicked")
            vibratePhone()
            shareSuggestion()
        }

        // Current Time Button
        btnCurrentTime.setOnClickListener {
            Log.d(TAG, "Current Time button clicked")
            vibratePhone()
            getCurrentTimeSuggestion()
        }

        // History Button
        btnHistory.setOnClickListener @androidx.annotation.RequiresPermission(android.Manifest.permission.VIBRATE) {
            Log.d(TAG, "History button clicked")
            vibratePhone()
            showHistory()
        }

        // Favorite Button
        btnFavorite.setOnClickListener {
            Log.d(TAG, "Favorite button clicked - Current favorite status: $isFavorite")
            vibratePhone()
            toggleFavorite()
        }
    }

    /**
     * Get social suggestion based on time input
     * Uses if-else statements to determine the appropriate suggestion
     */
    private fun getSocialSuggestion() {
        // Get user input and trim whitespace
        val timeInput = etTimeInput.text.toString().trim()

        Log.d(TAG, "User input received: '$timeInput'")

        // Validate input - Check if empty
        if (timeInput.isEmpty()) {
            Log.w(TAG, "Empty input detected - Showing error message")
            showError("Please enter a time of day to get a suggestion!")
            return
        }

        // Display the entered time
        tvTimeDisplay.text = "Time selected: $timeInput"

        // Convert to lowercase for case-insensitive comparison
        val normalizedInput = timeInput.lowercase()
        Log.v(TAG, "Normalized input for comparison: '$normalizedInput'")

        // IF-ELSE statement implementation
        // Determine suggestion based on time input
        val suggestion = when {
            normalizedInput.contains("morning") && !normalizedInput.contains("mid") -> {
                Log.i(TAG, "Morning time detected - Providing morning suggestion")
                "🌅 Send a 'Good morning' text to a family member"
            }
            normalizedInput.contains("mid-morning") ||
                    (normalizedInput.contains("mid") && normalizedInput.contains("morning")) -> {
                Log.i(TAG, "Mid-morning detected - Providing mid-morning suggestion")
                "☕ Reach out to a colleague with a quick 'Thank you'"
            }
            normalizedInput.contains("afternoon") && normalizedInput.contains("snack") -> {
                Log.i(TAG, "Afternoon snack time detected - Providing snack time suggestion")
                "🍪 Send a quick 'thinking of you' message"
            }
            normalizedInput.contains("afternoon") -> {
                Log.i(TAG, "Afternoon detected - Providing afternoon suggestion")
                "😄 Share a funny meme or interesting link with a friend"
            }
            normalizedInput.contains("dinner") -> {
                Log.i(TAG, "Dinner time detected - Providing dinner suggestion")
                "📞 Call a friend or relative for a 5-minute catch-up"
            }
            normalizedInput.contains("night") ||
                    normalizedInput.contains("evening") ||
                    normalizedInput.contains("after dinner") -> {
                Log.i(TAG, "Night/Evening detected - Providing night suggestion")
                "💭 Leave a thoughtful comment on a friend's post"
            }
            else -> {
                Log.w(TAG, "Invalid time input received: '$timeInput'")
                null
            }
        }

        // Display suggestion or error message
        if (suggestion != null) {
            updateSuggestion(suggestion)
        } else {
            tvSuggestion.text = ""
            showError("Hmm, that time isn't recognized. Try: Morning, Afternoon, Dinner, Night, etc.")
            Log.e(TAG, "Invalid time input - Could not generate suggestion")
        }
    }

    /**
     * Get random suggestion from the randomSparks list
     */
    private fun getRandomSuggestion() {
        val randomSuggestion = randomSparks.random()
        Log.d(TAG, "Random suggestion generated: $randomSuggestion")
        updateSuggestion(randomSuggestion)
        tvTimeDisplay.text = "✨ Random Spark ✨"
        showSuccess("Here's a surprise spark!")
    }

    /**
     * Get suggestion based on current device time
     */
    private fun getCurrentTimeSuggestion() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        val timeString = String.format("%02d:%02d", hour, minute)

        Log.d(TAG, "Current time detected: $timeString (hour: $hour)")

        val suggestion = when (hour) {
            in 5..11 -> "🌅 Good morning! Send a 'Good morning' text to a family member"
            in 11..13 -> "☕ Mid-morning! Reach out to a colleague with a quick 'Thank you'"
            in 13..16 -> "😄 Afternoon! Share a funny meme or interesting link with a friend"
            in 16..18 -> "🍪 Snack time! Send a quick 'thinking of you' message"
            in 18..20 -> "📞 Dinner time! Call a friend or relative for a 5-minute catch-up"
            in 20..23, in 0..4 -> "💭 Night time! Leave a thoughtful comment on a friend's post"
            else -> "✨ Any time is a good time to connect with someone!"
        }

        updateSuggestion(suggestion)
        tvTimeDisplay.text = "Current time: $timeString 🌙"
        showSuccess("Auto-detected current time!")
        Log.i(TAG, "Current time suggestion provided: $suggestion")
    }

    /**
     * Share current suggestion with other apps
     */
    private fun shareSuggestion() {
        if (currentSuggestion.isNotEmpty()) {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "✨ Social Sparks says: $currentSuggestion\n\nStay connected and spread kindness! 💫")
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, "Share this spark!"))
            Log.d(TAG, "Suggestion shared: $currentSuggestion")
            showSuccess("Sharing spark! ✨")
        } else {
            showError("Get a spark first to share it!")
            Log.w(TAG, "Share attempted with no suggestion available")
        }
    }

    /**
     * Toggle favorite status for current suggestion
     */
    private fun toggleFavorite() {
        if (currentSuggestion.isEmpty()) {
            showError("Get a spark first to save it!")
            return
        }

        val favorites = sharedPreferences.getStringSet(KEY_FAVORITES, mutableSetOf())?.toMutableSet() ?: mutableSetOf()

        if (!isFavorite) {
            // Save to favorites
            favorites.add(currentSuggestion)
            sharedPreferences.edit().putStringSet(KEY_FAVORITES, favorites).apply()
            btnFavorite.setImageResource(android.R.drawable.btn_star_big_on)
            isFavorite = true
            showSuccess("Added to favorites! ⭐")
            Log.d(TAG, "Suggestion added to favorites: $currentSuggestion")
        } else {
            // Remove from favorites
            favorites.remove(currentSuggestion)
            sharedPreferences.edit().putStringSet(KEY_FAVORITES, favorites).apply()
            btnFavorite.setImageResource(android.R.drawable.btn_star_big_off)
            isFavorite = false
            showSuccess("Removed from favorites 💔")
            Log.d(TAG, "Suggestion removed from favorites: $currentSuggestion")
        }
    }

    /**
     * Show history of recent suggestions
     */
    private fun showHistory() {
        val historySet = sharedPreferences.getStringSet(KEY_HISTORY, emptySet()) ?: emptySet()
        val historyList = historySet.toList()

        if (historyList.isNotEmpty()) {
            val historyText = historyList.take(10).joinToString("\n\n") { "• $it" }

            AlertDialog.Builder(this)
                .setTitle("📜 Recent Sparks")
                .setMessage(historyText)
                .setPositiveButton("Close") { _, _ ->
                    Log.d(TAG, "History dialog closed")
                }
                .setNeutralButton("Clear History") { _, _ ->
                    clearHistory()
                }
                .show()
            Log.d(TAG, "History displayed with ${historyList.size} items")
        } else {
            showError("No sparks in history yet! Get some suggestions first!")
            Log.d(TAG, "History is empty")
        }
    }

    /**
     * Clear suggestion history
     */
    private fun clearHistory() {
        sharedPreferences.edit().remove(KEY_HISTORY).apply()
        showSuccess("History cleared! 📜✨")
        Log.d(TAG, "Suggestion history cleared")
    }

    /**
     * Add suggestion to history
     */
    private fun addToHistory(suggestion: String) {
        val historySet = sharedPreferences.getStringSet(KEY_HISTORY, mutableSetOf())?.toMutableSet() ?: mutableSetOf()
        val historyList = historySet.toMutableList()

        // Add to beginning and keep only last 10
        historyList.add(0, suggestion)
        while (historyList.size > 10) {
            historyList.removeAt(historyList.size - 1)
        }

        sharedPreferences.edit().putStringSet(KEY_HISTORY, historyList.toSet()).apply()
        Log.v(TAG, "Suggestion added to history: $suggestion")
    }

    /**
     * Update the displayed suggestion and related UI elements
     */
    private fun updateSuggestion(suggestion: String) {
        currentSuggestion = suggestion
        tvSuggestion.text = suggestion

        // Add to history
        addToHistory(suggestion)

        // Update favorite button status
        val favorites = sharedPreferences.getStringSet(KEY_FAVORITES, mutableSetOf()) ?: setOf()
        isFavorite = favorites.contains(suggestion)
        btnFavorite.setImageResource(if (isFavorite) android.R.drawable.btn_star_big_on else android.R.drawable.btn_star_big_off)

        Log.d(TAG, "Suggestion updated: $suggestion")
    }

    /**
     * Reset all input fields and displays
     */
    private fun resetFields() {
        etTimeInput.text?.clear()
        tvSuggestion.text = ""
        tvTimeDisplay.text = ""
        currentSuggestion = ""
        isFavorite = false
        btnFavorite.setImageResource(android.R.drawable.btn_star_big_off)

        // Clear focus from input field
        etTimeInput.clearFocus()

        Log.d(TAG, "All fields have been reset")
        Toast.makeText(this, "Fields cleared! Ready for new input ✨", Toast.LENGTH_SHORT).show()
    }

    /**
     * Display error message to user
     * @param message The error message to display
     */
    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        tvTimeDisplay.text = "⚠️ Please try again"
        Log.e(TAG, "Error displayed to user: $message")
    }

    /**
     * Display success message to user
     * @param message The success message to display
     */
    private fun showSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        Log.i(TAG, "Success: $message")
    }

    /**
     * Provide haptic feedback on button presses
     */
    @RequiresPermission(Manifest.permission.VIBRATE)
    private fun vibratePhone() {
        try {
            val vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(30, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                @Suppress("DEPRECATION")
                vibrator.vibrate(30)
            }
        } catch (e: Exception) {
            Log.w(TAG, "Vibration not supported on this device")
        }
    }
}
