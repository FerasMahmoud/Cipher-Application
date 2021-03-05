# Cipher-Application
Implementing encryption and decryption techniques using own character substitutions.
I tested the program with multiple test cases in which my program was able to generate an acceptable output.
The program will read from a text file for example ‘message.txt’, inside the file a static text for example ‘abcdefghijklmnopqrstuvwxyz’.
The message is then read by the program and passed to the encryption method where the encryption process will procced the encryption for example ‘LM#Q&$+U^W%@BYZCD=FGH!?KN*’, and the program will save this text into file called for example ‘cipher.txt’.
Then, the program will read from a text file for example ‘cipher.txt’, inside the file an already encrypted text for example ‘LM#Q&$+U^W%@BYZCD=FGH!?KN*’ and applying the description to this text and generate for example’ abcdefghijklmnopqrstuvwxyz’ and save it to file ‘decrypt.txt’.

Expected Results
message.txt
content: abcdefghijklmnopqrstuvwxyz
cipher.txt
content: LM#Q&$+U^W%@BYZCD=FGH!?KN*
decrypt.txt
content: abcdefghijklmnopqrstuvwxyz

The flow of the program
• Message -> Encrypt
• Encrypt   -> Cipher
• Cipher     -> Decrypt
• Decrypt   -> Message


Screenshot of the output
![image](https://user-images.githubusercontent.com/50872362/110101597-d1a88680-7db4-11eb-9f11-6658bb78c78f.png)
