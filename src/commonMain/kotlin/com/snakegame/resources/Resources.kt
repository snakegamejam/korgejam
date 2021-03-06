package com.snakegame.resources

import com.soywiz.korau.format.mp3.JavaMp3Decoder
import com.soywiz.korau.sound.NativeSound
import com.soywiz.korau.sound.NativeSoundChannel
import com.soywiz.korau.sound.readMusic
import com.soywiz.korau.sound.readSound
import com.soywiz.korge.atlas.Atlas
import com.soywiz.korge.atlas.readAtlas
import com.soywiz.korge.view.Views
import com.soywiz.korim.font.BitmapFont
import com.soywiz.korim.font.Font
import com.soywiz.korim.font.readBitmapFont
import com.soywiz.korio.file.std.resourcesVfs

class Resources(val views: Views) {
    companion object{
        lateinit var snakeAtlas:Atlas
        lateinit var font: BitmapFont
        lateinit var appleSound: NativeSound
        lateinit var bubbleTalk: NativeSound
        lateinit var explosion: NativeSound
        lateinit var channel: NativeSoundChannel
        lateinit var larrioMusic: NativeSound
        lateinit var pacmanMusic: NativeSound
        lateinit var snakeMusic: NativeSound
        lateinit var levelWarp: NativeSound
        lateinit var pacmanDead: NativeSound
        lateinit var levelCompleted: NativeSound

        private var loaded = false
    }

    suspend fun loadAll() {
        if(loaded) return
        loaded = true
        snakeAtlas = resourcesVfs["snake.atlas.json"].readAtlas(views)
        font = resourcesVfs["texts/I-pixel-u.fnt"].readBitmapFont()
        appleSound = resourcesVfs["sounds/AppleItem.wav"].readSound()
        bubbleTalk = resourcesVfs["sounds/BubbleTalk.wav"].readSound()
        explosion = resourcesVfs["sounds/Explosion.wav"].readSound()
        larrioMusic = resourcesVfs["sounds/LarrioMusic.wav"].readMusic()
        pacmanMusic = resourcesVfs["sounds/PacMan_music.mp3"].readMusic()
        snakeMusic = resourcesVfs["sounds/Snake_Music.mp3"].readMusic()
        channel = snakeMusic.play()
        channel.stop()
        levelWarp = resourcesVfs["sounds/LevelWarp.wav"].readSound()
        pacmanDead = resourcesVfs["sounds/PacmanDead.wav"].readSound()
        levelCompleted = resourcesVfs["sounds/LevelCompleted.mp3"].readSound()
    }
}

