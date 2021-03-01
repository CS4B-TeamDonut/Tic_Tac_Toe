package io.github.teamdonut.proj;

import io.github.teamdonut.proj.utils.Logger;
import javafx.scene.media.AudioClip;

public final class EventSoundPing {
    private static EventSoundPing instance;
    private final String buttonSound1 = "soundEffects/button_sound_1.mp3";
    private final String buttonSound2 = "soundEffects/button_sound_2.mp3";
    private AudioClip clip;

    public static EventSoundPing getInstance() {
        if (instance == null)
            instance = new EventSoundPing();
        return instance;
    }

    private EventSoundPing() {}

    public void playButtonSound1() {
        try {
            clip = new AudioClip(getClass().getResource(buttonSound1).toString());
            clip.play();
        } catch (Exception e) {
            Logger.log(e);
        }
    }

    public void playButtonSound2() {
        try {
            clip = new AudioClip(getClass().getResource(buttonSound2).toString());
            clip.play();
        } catch (Exception e) {
            Logger.log(e);
        }
    }
}
