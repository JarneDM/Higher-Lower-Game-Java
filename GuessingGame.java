import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GuessingGame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private static final int guess = 0;
	
	// variables
	private JLabel lblOutput;
	private int theNumber;
	static int numOfGuesses = 0;
	private JTextField txtGuess;
	private JButton playAgainBtn;
	
	
	
	public void checkGuess() {
		
		 
		 String guessText = txtGuess.getText();
		 String message = "";
		 
		try {
			int guess = Integer.parseInt(guessText);
			if(guess < theNumber) {
				message = guess + " is too low. Try again.";
				numOfGuesses++;
				txtGuess.setText(null);
			}
			else if(guess > theNumber) {
				message = guess + " is too high. Try again.";
				numOfGuesses++;
				txtGuess.setText(null);
			}
			else {
				message = guess + " is correct. You win after " + numOfGuesses + " tries!";
				numOfGuesses = 0;
				playAgainBtn.setVisible(true);
				txtGuess.setText(null);
			}
			} catch (Exception e) {
				message = "Enter a whole number between 1 and 100.";
				txtGuess.setText(null);
				numOfGuesses++;
			} finally {
				lblOutput.setText(message);
			}
		}
	
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
	}
	
	public GuessingGame() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Jarne's Guessing Game");
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel TitleLabel = new JLabel("Jarne's Guessing Game");
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		TitleLabel.setBounds(0, 32, 434, 35);
		getContentPane().add(TitleLabel);
		
		JLabel GuessLabel = new JLabel("Guess a number between 1 and 100:");
		GuessLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GuessLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GuessLabel.setBounds(53, 99, 225, 27);
		getContentPane().add(GuessLabel);
		
		// Text field
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGuess.setBounds(288, 103, 58, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		// Guess button
		JButton GuessBtn = new JButton("Guess!");
		GuessBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		GuessBtn.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 14));
		GuessBtn.setBounds(120, 158, 194, 23);
		getContentPane().add(GuessBtn);
		
		lblOutput = new JLabel("Enter a number and click \"Guess!\"");
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(0, 213, 434, 14);
		getContentPane().add(lblOutput);
		
		// play Again btn
		playAgainBtn = new JButton("Play again!");
		playAgainBtn.setVisible(false);
		playAgainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();
				playAgainBtn.setVisible(false);
			}
		});
		
		playAgainBtn.setFont(new Font("Monospaced", Font.BOLD, 14));
		playAgainBtn.setBounds(157, 179, 131, 23);
		getContentPane().add(playAgainBtn);
	}

	public static void main(String[] args) {
		
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450, 300));
		theGame.setVisible(true);
		
	}
}
