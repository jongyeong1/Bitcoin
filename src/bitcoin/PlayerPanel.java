package bitcoin;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

public class PlayerPanel extends JPanel {

     private File vlcInstallPath = new File("D:/vlc");
     private EmbeddedMediaPlayer player;

     public PlayerPanel() {
      //   NativeLibrary.addSearchPath("libvlc", vlcInstallPath.getAbsolutePath());
         EmbeddedMediaPlayerComponent videoCanvas = new EmbeddedMediaPlayerComponent();
         this.setLayout(new BorderLayout());
         this.add(videoCanvas, BorderLayout.CENTER);
         this.player = videoCanvas.getMediaPlayer();
     }

     public void play(String media) {
    	 
         player.prepareMedia(media);
         player.parseMedia();
         player.play();
     }
 }

 class VideoPlayer extends JFrame {

     public VideoPlayer() {
          PlayerPanel player = new PlayerPanel();
          this.setTitle("Swing Video Player");
          this.setDefaultCloseOperation(EXIT_ON_CLOSE);
          this.setLayout(new BorderLayout());
          this.setSize(640, 480);
          this.setLocationRelativeTo(null);
          this.add(player, BorderLayout.CENTER);
          this.validate();
          this.setVisible(true);

          player.play("http://174.132.240.162:8000/;stream.nsv");
     }

      public static void main(String[] args) {
          new VideoPlayer();
      }
 }