
# Word Parser

## Environment:

- Java version: 1.8
- Maven version: 3.*

## Description:

Write a program that parses a sentence and replaces each word with the following:

1) The first letter of the word.
2) The number of distinct characters between the first and last characters. If the word has only two letters, it 
   remains the same. 
4) The last letter of the word.

For Example: 
 
  * **Smooth** would become **S3h**
  * **is** would remain **is** (doesn't change)

Spaces or non-alphabetic characters separate words, and these separators should be maintained in their original form
and location in the answer. For example:

* **thinking-up** would become **t4g-up**
* **Hello world** would become **H2o w3d**

## Command

$ mvn compile exec:java

