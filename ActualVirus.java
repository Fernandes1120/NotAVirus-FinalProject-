import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActualVirus implements ActionListener {

	JFrame frame = new JFrame();
	JButton startButton = new JButton("Click Me For Free Bitcoin");
	JLabel timeLeft = new JLabel();
	JLabel virusRansom = new JLabel();
	
	int elapsedTime = 86400000;
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	boolean started = false;
	
	String seconds_string = String.format("%02d", seconds);
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			elapsedTime -= 1000;
			hours = (elapsedTime/3600000);
			minutes = (elapsedTime/60000) % 60;
			seconds = (elapsedTime/1000) % 60;
			
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes);
			hours_string = String.format("%02d", hours);
			
			timeLeft.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
		}

	});
	
	ActualVirus(){
		
		
		timeLeft.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
		timeLeft.setBounds(100, 100, 200, 100);
		timeLeft.setFont(new Font("Serif", Font.PLAIN, 35));
		timeLeft.setBorder(BorderFactory.createBevelBorder(1));
		timeLeft.setOpaque(true);
		timeLeft.setHorizontalAlignment(JTextField.CENTER);
		
		virusRansom.setText("Your Computer Will Blow Up In: ");
		virusRansom.setBounds(-25, 0, 500, 100);
		virusRansom.setFont(new Font("Monospaced", Font.PLAIN, 15));
		virusRansom.setOpaque(true);
		virusRansom.setHorizontalAlignment(JTextField.CENTER);

		startButton.setBounds(60, 200, 300, 100);
		startButton.setFont(new Font("Verdana", Font.PLAIN, 20));
		startButton.setFocusable(false);
		startButton.addActionListener(this);
			
		frame.setTitle("Not A Virus");
		frame.add(startButton);
		frame.add(timeLeft);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==startButton) {
			start();
		}
	}
	
	
	void start() {
		timer.start();
		frame.add(virusRansom);
		frame.getContentPane().setBackground(Color.red);
		frame.repaint();
	}
	
	
}
