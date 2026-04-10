import javax.sound.sampled.*;

public class SoundPlayer {

    private static Clip currentClip;

    private static String currentTrack = "";

    public static void playSound(String fileName, boolean loop) {
        if (fileName.equals(currentTrack) && currentClip != null && currentClip.isRunning()) {
            return;
        }
        currentTrack = fileName;

        try {
            if (currentClip != null) {
                currentClip.stop();
                currentClip.close();
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(
                    SoundPlayer.class.getResource("/" + fileName)
            );

            currentClip = AudioSystem.getClip();
            currentClip.open(audioStream);
            audioStream.close();

            if (loop) {
                currentClip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                currentClip.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        currentClip.addLineListener(event -> {
            if (event.getType() == LineEvent.Type.STOP) {
                currentClip.close();
                currentTrack = "";
            }
        });
    }
}