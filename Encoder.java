///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           M9.12 Zylabs Encoder Program
// Course:          CS 200, Spring, 2023
//
// Author:          Max Liss-'s-Gravemade
// Email:           lisssgravema@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// Source or Recipient; Description
// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html;
//
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Encodes and decodes messages.
 *
 * @author Ruby Wang
 * @author Max Liss-'s-Gravemade
 */
public class Encoder {

    /**
     * Encodes a given message by shifting each letter in the input string to the right in the ASCII
     * table by a fixed number of positions.
     *
     * @param encodedMessages The list of encoded messages
     * @param message         the input String waiting to be encoded
     */
    public static void encodeMessage(ArrayList<String> encodedMessages, String message) {
        final int ENCODE_SHIFTING = 5;
        final int CHAR_START_INDEX = 'a';
        final int CHARACTER_COUNT = 26;

        StringBuilder encodedMessage = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            int shiftedCharIndex =
                    ((int) currentChar - CHAR_START_INDEX + ENCODE_SHIFTING) % CHARACTER_COUNT + CHAR_START_INDEX;
            encodedMessage.append((char) shiftedCharIndex);
        }
        encodedMessages.add(encodedMessage.toString());
    }

    /**
     * Deletes a stored encoded message at the specified index in the ArrayList.
     *
     * @param encodedMessages The list of encoded messages
     * @param index           the index of where the message should be removed in encodedMessage
     *                        ArrayList
     * @return true if successfully deleted, otherwise return false
     */
    public static boolean deleteMessage(ArrayList<String> encodedMessages, int index) {
        if (index < 0 || index >= encodedMessages.size()) {
            return false;
        }
        encodedMessages.remove(index);
        return true;
    }

    /**
     * Aggregates all the encoded messages stored in the ArrayList into a single string, separating
     * different messages with newline characters.
     *
     * @param encodedMessages The list of encoded messages
     * @return the aggregated message
     */
    public static String getEncodedMessage(ArrayList<String> encodedMessages) {
        StringBuilder sb = new StringBuilder();

        for (String message : encodedMessages) {
            sb.append(message).append("\n");
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
    }

    /**
     * Takes in messages and indexes from users which includes a unit test for each method. You
     * don't need to edit anything here!
     *
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList<String> encodedMessages = new ArrayList<>();

        System.out.println("Please enter 3 words to encrypt followed by 2 integer delete " +
                "position" + " signals.");
        System.out.println("Example Input: word1 word2 word3 4 5");
        String firstMessage = scnr.next();
        String secondMessage = scnr.next();
        String thirdMessage = scnr.next();
        int firstIndex = scnr.nextInt();
        int secondIndex = scnr.nextInt();

        encodeMessage(encodedMessages, firstMessage);
        encodeMessage(encodedMessages, secondMessage);
        encodeMessage(encodedMessages, thirdMessage);
        System.out.println("current encoded message: " + getEncodedMessage(encodedMessages));

        System.out.println(deleteMessage(encodedMessages, firstIndex));
        System.out.println("current encoded message: " + getEncodedMessage(encodedMessages));

        System.out.println(deleteMessage(encodedMessages, secondIndex));
        System.out.println("current encoded message: " + getEncodedMessage(encodedMessages));
    }
}