package cipherapplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author feras
 *
 * FIRAS MAHMOUD 1845407
 */
public class Cipher {

    public static void main(String[] args) throws IOException {
        System.out.println("        Start of Cipher Application");
        System.out.println("Enter the file name to be read ex. 'message.txt'");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        System.out.println("Enter the Intermediate file name to be read ex. 'cipher.txt'");
        String IntermediateFileName = sc.nextLine();
        try {
            BufferedReader inStream1 = new BufferedReader(new FileReader(fileName));
            PrintWriter outStream1 = new PrintWriter(IntermediateFileName); // Create BufferedReader and PrintWriter
            encrypt(inStream1, outStream1); // call Encrypt method
            BufferedReader inStream2 = new BufferedReader(new FileReader(IntermediateFileName));
            PrintWriter outStream2 = new PrintWriter("decrypt.txt"); // Create BufferedReader and PrintWriter
            decrypt(inStream2, outStream2); // call Decrypt method
            System.out.println("        The program End Here");
        } catch (Exception e) {
            System.out.println("The File name is incorrect.");
            System.exit(0);
        }
    }

    //------------------------------------------------
    public static void encrypt(BufferedReader inStream, PrintWriter outStream) throws IOException {
        System.out.println("        The Encryption Will start now");
        String msg = "";
        while (inStream.ready()) {
            msg = msg + inStream.readLine();
        }
        if (msg.length() < 4) {
            System.out.println("\nThe text is less than 4 characters");
            System.exit(0);
        }
        //-----------------------------------------------------------

        // Step 1 and 2
        msg = msg.trim().toUpperCase(); // Remove spaces and upper case
        System.out.println("The Message after Step 1 and 2: " + msg);

        // Step 3
        msg = characterSubstitutions(msg); // Perform character substitutions
        System.out.println("The Message after Step 3: " + msg);

        // Step 4
        msg = halfStep(msg); // Move the first half of the string to be the last half 
        System.out.println("The Message after Step 4: " + msg);

        // Step 5
        msg = SwapFirst2Ch(msg); // Swap the first 2 characters
        System.out.println("The Message after Step 5: " + msg);

        // Step 6
        msg = Swap2Ch(msg); // Swap the two characters immediately to the left of the middle of the string with the two characters that immediately follow them
        System.out.println("The Message after Step 6: " + msg);

        System.out.println("The Final Message: " + msg + "\n");

        outStream.println(msg); // Write the Message tp the file named cipher.txt
        outStream.flush();
        outStream.close();
    }

    //------------------------------------------------
    public static void decrypt(BufferedReader inStream, PrintWriter outStream) throws IOException {
        System.out.println("        The Decryption Will start now");
        String msg = "";
        while (inStream.ready()) {
            msg = msg + inStream.readLine();
        }
        if (msg.length() < 4) {
            System.out.println("\nThe text is less than 4 characters");
            System.exit(0);
        }
        //-----------------------------------------------------------

        // Step 1
        msg = msg.trim().toUpperCase(); // Remove spaces and upper case
        System.out.println("The Message after Step 1 : " + msg);

        // Step 2
        msg = Swap2Ch(msg); // Swap the two characters immediately to the left of the middle of the string with the two characters that immediately follow them
        System.out.println("The Message after Step 2: " + msg);

        // Step 3
        msg = SwapFirst2Ch(msg); // Swap the first 2 characters
        System.out.println("The Message after Step 3: " + msg);

        // Step 4
        msg = halfStep(msg); // Move the first half of the string to be the last half 
        System.out.println("The Message after Step 4: " + msg);

        // Step 5
        msg = rverseCharacterSubstitutions(msg); // Perform character substitutions
        System.out.println("The Message after Step 5: " + msg);

        // Step 6
        msg = msg.toLowerCase(); // from upper to lower case
        System.out.println("The Message after Step 6: " + msg);

        System.out.println("The Final Message: " + msg + "\n");

        outStream.println(msg); // Write the Message tp the file named cipher.txt
        outStream.flush();
        outStream.close();
    }

    //------------------------------------------------
    public static String characterSubstitutions(String msg) {
        char[] msgArray = msg.toCharArray();
        char charCurrent;
        for (int i = 0; i < msgArray.length; i++) {
            charCurrent = msgArray[i];
            switch (charCurrent) {
                case 'A':
                    msgArray[i] = '@';
                    break;
                case 'E':
                    msgArray[i] = '=';
                    break;
                case 'I':
                    msgArray[i] = '!';
                    break;
                case 'J':
                    msgArray[i] = '?';
                    break;
                case 'O':
                    msgArray[i] = '*';
                    break;
                case 'P':
                    msgArray[i] = '#';
                    break;
                case 'R':
                    msgArray[i] = '&';
                    break;
                case 'S':
                    msgArray[i] = '$';
                    break;
                case 'T':
                    msgArray[i] = '+';
                    break;
                case 'V':
                    msgArray[i] = '^';
                    break;
                case 'X':
                    msgArray[i] = '%';
                    break;
                case ' ':
                    msgArray[i] = '_';
                    break;
                default:
                    break;
            }
        }
        return new String(msgArray);
    }

    //------------------------------------------------
    public static String rverseCharacterSubstitutions(String msg) {
        char[] msgArray = msg.toCharArray();
        char charCurrent;
        for (int i = 0; i < msgArray.length; i++) {
            charCurrent = msgArray[i];
            switch (charCurrent) {
                case '@':
                    msgArray[i] = 'A';
                    break;
                case '=':
                    msgArray[i] = 'E';
                    break;
                case '!':
                    msgArray[i] = 'I';
                    break;
                case '?':
                    msgArray[i] = 'J';
                    break;
                case '*':
                    msgArray[i] = 'O';
                    break;
                case '#':
                    msgArray[i] = 'P';
                    break;
                case '&':
                    msgArray[i] = 'R';
                    break;
                case '$':
                    msgArray[i] = 'S';
                    break;
                case '+':
                    msgArray[i] = 'T';
                    break;
                case '^':
                    msgArray[i] = 'V';
                    break;
                case '%':
                    msgArray[i] = 'X';
                    break;
                case '_':
                    msgArray[i] = ' ';
                    break;
                default:
                    break;
            }
        }
        return new String(msgArray);
    }

    //------------------------------------------------
    public static String halfStep(String msg) {
        char[] msgArray = msg.toCharArray();
        int halfLen, indexHalf = 0;

        if (msg.length() % 2 == 0) {
            halfLen = msg.length() / 2;
        } else {
            halfLen = (msg.length() / 2) + 1;
        }
        String fHalf = "", sHalf = "";

        for (int i = 0; i < halfLen; i++) {
            fHalf = fHalf + msgArray[i];
            indexHalf = i;
        }
        for (int i = indexHalf + 1; i < msg.length(); i++) {
            sHalf = sHalf + msgArray[i];
        }
        return sHalf + fHalf;
    }

    //------------------------------------------------
    public static String SwapFirst2Ch(String msg) {
        char[] msgArray = msg.toCharArray();
        char firstChar = msgArray[0], secondChar = msgArray[1];

        char beforeLastChar = msgArray[msgArray.length - 2];
        char lastChar = msgArray[msgArray.length - 1];

        msgArray[0] = beforeLastChar;
        msgArray[msgArray.length - 2] = firstChar;

        msgArray[1] = lastChar;
        msgArray[msgArray.length - 1] = secondChar;

        return new String(msgArray);
    }

    //------------------------------------------------
    public static String Swap2Ch(String msg) {
        char[] msgArray = msg.toCharArray();
        int halfLen;
        if (msg.length() % 2 == 0) {
            halfLen = msg.length() / 2;
        } else {
            halfLen = (msg.length() / 2) + 1;
        }

        char middleChar = msgArray[halfLen - 1], leftToMiddleChar = msgArray[halfLen - 2];

        char rightToMiddleChar = msgArray[halfLen], twoRightsFromMiddleChar = msgArray[halfLen + 1];

        msgArray[halfLen - 2] = rightToMiddleChar;
        msgArray[halfLen - 1] = twoRightsFromMiddleChar;

        msgArray[halfLen] = leftToMiddleChar;
        msgArray[halfLen + 1] = middleChar;

        return new String(msgArray);
    }

/**
 *
 * @author feras
 *
 * FIRAS MAHMOUD 1845407
 */
}
