package com.swing.app;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;



public class VLCMediaPlayer {

	public static void main(String[] args) {
		JSlider jSlider;
		JFrame f = new JFrame();
		f.setLocation(100,100);
		f.setSize(1000, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.black);
		canvas.setBounds(100, 500, 1050, 500);
		
		JPanel jPanel= new JPanel();
		jPanel.setLayout(new BorderLayout());
		jPanel.setBounds(100, 50, 1050, 600);
        
		jPanel.add(canvas, BorderLayout.CENTER);
		f.add(jPanel, BorderLayout.NORTH);
		
		JPanel p1 = new JPanel();
		p1.setBounds(100, 900, 105, 200);
		f.add(p1, BorderLayout.SOUTH);
		
		
		JButton playbutton = new JButton("play");
		playbutton.setBounds(50, 50, 150, 100);
		p1.add(playbutton);
		 
		JButton pausebutton = new JButton("pause");
		pausebutton.setBounds(80, 50, 150, 100);
		p1.add(pausebutton);
		
		JButton rewindButton = new JButton("rewind");
		rewindButton.setBounds(100, 50, 150, 100);
		p1.add(rewindButton);
		
		
		
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC");
	//	NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "src/lib");
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class );
		
		MediaPlayerFactory mpf = new MediaPlayerFactory();
		final EmbeddedMediaPlayer emp = mpf.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(f));
		emp.setVideoSurface(mpf.newVideoSurface(canvas));
	//	emp.toggleFullScreen();
		emp.setEnableMouseInputHandling(false);
		emp.setEnableKeyInputHandling(false);
		
		String file = "documentDecrypted.mp4";
		emp.prepareMedia(file);
		
		pausebutton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				emp.pause();
				final long time = emp.getTime();
				
			}
		});
		
		playbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				emp.play();
				
			}
		});
		
		rewindButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				emp.skip(-10000);
				
			}
		});
		
	}


}
