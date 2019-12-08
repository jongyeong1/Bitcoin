package bitcoin;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.DefaultFullScreenStrategy;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class Ending {
	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		f.setLocation(100,100);
		f.setSize(200,100);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		 
		
		
		Canvas c = new Canvas();  
		c.setBackground(Color.black);
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(c);
		f.add(p);
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),"lib");
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(),LibVlc.class);
		MediaPlayerFactory mpf = new MediaPlayerFactory();
		EmbeddedMediaPlayer emp = mpf.newEmbeddedMediaPlayer(new DefaultFullScreenStrategy(f));
		emp.setVideoSurface(mpf.newVideoSurface(c));
		emp.toggleFullScreen();
		emp.setEnableMouseInputHandling(false);
		emp.setEnableKeyInputHandling(true);
		
		String file="fail.mp4";
		emp.prepareMedia(file);
		emp.play();
		
	}

}