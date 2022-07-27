package model;

import utils.Constants;
import utils.customExceptions.InvalidInputException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static utils.ConversionUtils.*;
import static utils.ValidationUtils.*;

public class NumberConverter {

    private JFrame frame;
    private JComboBox from;
    private JComboBox to;
    private JTextField input;
    private JTextField output;
    private JLabel errorMessage;


    public NumberConverter() {
        initComponents();
    }

    private void initComponents(){
        JLabel labelFrom = new JLabel("From");
        labelFrom.setFont(new Font("Tahoma", 1, 18));
        labelFrom.setBounds(100,100, 100,50);
        JLabel labelTo = new JLabel("To");
        labelTo.setFont(new Font("Tahoma", 1, 18));
        labelTo.setBounds(300,100, 100,50);
        JLabel labelEnter = new JLabel("Enter a number");
        labelEnter.setFont(new Font("Tahoma", 1, 18));
        labelEnter.setBounds(100,220, 200,50);

        String[] numTypes = { "Binary", "Octal", "Decimal", "Hexadecimal" };
        from = new JComboBox(numTypes);
        from.setFont(new Font("Tahoma", 0, 18));
        from.setBounds(100, 150, 150, 40);
        to = new JComboBox(numTypes);
        to.setSelectedIndex(2);
        to.setFont(new Font("Tahoma", 0, 18));
        to.setBounds(300, 150, 150, 40);

        input = new JTextField();
        input.setBounds(100, 260, 200, 40);
        input.setFont(new Font("Serif", 1, 18));
        output = new JTextField();
        output.setBounds(100, 390, 200, 40);
        output.setFont(new Font("Serif", 1, 18));
        output.setEditable(false);

        JButton convertButton = new JButton();
        convertButton.setText("Convert");
        convertButton.setBounds(100, 330, 120, 40);
        convertButton.setFont(new Font("Tahoma", 1, 18));
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        JButton clearButton = new JButton();
        clearButton.setText("Clear");
        clearButton.setBounds(230, 330, 120, 40);
        clearButton.setFont(new Font("Tahoma", 1, 18));
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        errorMessage = new JLabel();
        errorMessage.setFont(new Font("Serif", 2, 18));
        errorMessage.setForeground(Color.RED);
        errorMessage.setBounds(100,430, 400,100);

        frame = new JFrame();
        frame.setTitle("Number Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.add(labelFrom);
        frame.add(labelTo);
        frame.add(labelEnter);
        frame.add(from);
        frame.add(to);
        frame.add(input);
        frame.add(output);
        frame.add(convertButton);
        frame.add(clearButton);
        frame.add(errorMessage);
    }

    private void button2ActionPerformed(ActionEvent evt) {
        input.setText("");
        output.setText("");
        errorMessage.setText("");
    }

    private void button1ActionPerformed(ActionEvent evt) {
        String fromString = (String) from.getSelectedItem();
        String toString = (String) to.getSelectedItem();
        String numString = input.getText();
        int num;
        String result = "";

        if(fromString.equals("Binary")){
            if(isValidBinaryNumber(numString)){
                num = Integer.parseInt(numString);
            }
            else{
                errorMessage.setText(Constants.INVALID_BINARY_NUMBER_MESSAGE);
                throw new InvalidInputException();
            }

            result = switch (toString) {
                case "Decimal" -> fromBinaryToDecimal(num);
                case "Octal" -> fromBinaryToOctal(num);
                case "Hexadecimal" -> fromBinaryToHexadecimal(num);
                default -> result;
            };
        }
        else if(fromString.equals("Decimal")){
            if(isValidDecimalNumber(numString)){
                num = Integer.parseInt(numString);
            }
            else{
                errorMessage.setText(Constants.INVALID_DECIMAL_NUMBER_MESSAGE);
                throw new InvalidInputException();
            }

            result = switch (toString) {
                case "Binary" -> fromDecimalToBinary(num);
                case "Octal" -> fromDecimalToOctal(num);
                case "Hexadecimal" -> fromDecimalToHexadecimal(num);
                default -> result;
            };
        }
        else if(fromString.equals("Octal")){
            if(isValidOctalNumber(numString)){
                num = Integer.parseInt(numString);
            }
            else{
                errorMessage.setText(Constants.INVALID_OCTAL_NUMBER_MESSAGE);
                throw new InvalidInputException();
            }

            result = switch (toString) {
                case "Binary" -> fromOctalToBinary(num);
                case "Decimal" -> fromOctalToDecimal(num);
                case "Hexadecimal" -> fromOctalToHexadecimal(num);
                default -> result;
            };
        }
        else if(fromString.equals("Hexadecimal")){
            if(!isValidHexadecimalNumber(numString)){
                errorMessage.setText(Constants.INVALID_HEXADECIMAL_NUMBER_MESSAGE);
                throw new InvalidInputException();
            }

            result = switch (toString) {
                case "Binary" -> fromHexadecimalToBinary(numString);
                case "Decimal" -> fromHexadecimalToDecimal(numString);
                case "Octal" -> fromHexadecimalToOctal(numString);
                default -> result;
            };
        }

        output.setText(result);
    }
}
