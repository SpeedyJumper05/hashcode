# hashcode
## Short explanation
A rather simple console application coded in Java 15. The program is able to take a message and hash it using the SHA-1 algorithm. The Program is also capable of brute forcing a generated hash in order to retrieve the original message. For the sake of speed, there are strong limitations, though.

## Guide
### Startup
On startup, hashcode will ask you if you want to encrypt or decrypt a message. To choose an option, type "encrypt" or "decrypt" into the console and press enter. Alternatively, you can type "en" or "e" to encrypt, and "de" or "d" to decrypt.
### Encrypting
After choosing *encrypt*, hashcode will ask you for a message. Type a message into the console and press enter. hashcode will then generate a SHA-1 hash of your input. Before this, however, your input will be converted to lowercase and scanned for illegal characters, which will then be removed. For more information on this, see [Limitations](https://github.com/SpeedyJumper05/hashcode/blob/main/README.md#limitations).

***<ins>DISCLAIMER:</ins> SHA-1 IS AN OUTDATED HASHING ALGORITHM AND NOT UP TO MODERN STANDARDS ANYMORE, DO NOT USE SHA-1 AND/OR THIS PROGRAM TO ENCRYPT CRITICAL INFORMATION!***
### Decrypting
After choosing *decrypt*, hashcode will ask you for a hash. Paste a hash into the console and press enter. hashcode will then start trying to brute force - that is, trying every possible combination - the original message behind the hash. Depending on the environment it is run in, your hardware, and the original message, this might take very long. For more information on this, see [Limitations](https://github.com/SpeedyJumper05/hashcode/blob/main/README.md#limitations).
## Limitations
### Characters
Because a high number of possible characters tried while brute forcing a hashed message would be unviable in terms of speed, hashcode works with **<ins>lowercase letters only</ins>**.

While encoding using hashcode, you will not have to particularly watch out for characters that are not allowed, because the program will convert all input to lowercase and filter out illegal characters. The cleansed String will be displayed together with the hashed output so that you can know if anything was cut from your original input.

When decoding, however, one will have to notice that hashcode will do fine reverting hashes to their respective original input if they were generated using hashcode, but not if they were generated with another program and from a message containing characters other than lowercase letters and spaces. In this case, the program would end up running indefinitely, because hashcode only checks messages it could itself generate.
### Speed
While hashing a single message does not take much time, hashing tens - if not hundreds of thousands of messages - will. As hashcode can take a hash as input and try to brute force the original message, this is exactly what's happening there. This means that, depending on your hardware and the length of the original input, decoding may take from just a few seconds for three-letter messages to hours, days, months, or more.

On newer hardware, I found messages of up to six characters to be viable through testing, however, on older hardware, original messages of five characters or more might already take too long for you.
On Windows, I found that the program runs significantly slower in the terminal/Powershell than when being executed in IntelliJ Idea Community Edition. Consider this when trying to maximize speed while decoding.
