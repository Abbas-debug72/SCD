import javax.swing.*;

public class StringManage {

    public static void main(String[] args) {
        JFrame frame = new JFrame("String Management");
        JTextField inputField = new JTextField(20);
        JLabel resultLabel = new JLabel("Result: ");
        
        // Create buttons
        JButton reverseButton = new JButton("Reverse");
        JButton lengthButton = new JButton("Length");
        JButton upperButton = new JButton("Uppercase");
        JButton lowerButton = new JButton("Lowercase");
        JButton countButton = new JButton("Count");
        JButton replaceButton = new JButton("Replace");
        JButton exitButton = new JButton("Exit");

        // Layout setup
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(inputField);
        frame.add(reverseButton);
        frame.add(lengthButton);
        frame.add(upperButton);
        frame.add(lowerButton);
        frame.add(countButton);
        frame.add(replaceButton);
        frame.add(resultLabel);
        frame.add(exitButton);

        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Button actions
        reverseButton.addActionListener(e -> showResult("Reversed: " + new StringBuilder(inputField.getText()).reverse().toString()));
        lengthButton.addActionListener(e -> showResult("Length: " + inputField.getText().length()));
        upperButton.addActionListener(e -> showResult("Uppercase: " + inputField.getText().toUpperCase()));
        lowerButton.addActionListener(e -> showResult("Lowercase: " + inputField.getText().toLowerCase()));
        
        // Count occurrences of a character within the string
        countButton.addActionListener(e -> {
            String input = inputField.getText();
            char charToCount = JOptionPane.showInputDialog("Enter character to count:").charAt(0);
            long count = input.chars().filter(c -> c == charToCount).count();
            showResult("Count of '" + charToCount + "': " + count);
        });

        // Replace characters in the string
        replaceButton.addActionListener(e -> {
            String input = inputField.getText();
            String oldChar = JOptionPane.showInputDialog("Character to replace:");
            String newChar = JOptionPane.showInputDialog("New character:");
            if (oldChar != null && newChar != null && oldChar.length() == 1 && newChar.length() == 1) {
                showResult("Replaced: " + input.replace(oldChar.charAt(0), newChar.charAt(0)));
            } else {
                showResult("Please enter valid characters.");
            }
        });

        exitButton.addActionListener(e -> System.exit(0));
    }

    // Helper method to display results
    private static void showResult(String result) {
        JOptionPane.showMessageDialog(null, result);
    }
}
