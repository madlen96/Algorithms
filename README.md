# Algorithms
## Implementation of different algorithms

### 1. Levenshtein - implementation of Levenshtein algorithm 
  
  Command line arguments:
 
 >   1. path to txt file containing list of strings matching given regex pattern 
 >   2. compare test string which will be used to find minimum value of Levenshtein distance 
  
  Output: 
 >   Line number containing string that is the most similar to the test string - if there is more strings that have got the same value of levenshtein distance, the first one found is returned
  
  Usage:
  ```
    javac -Xlint Levenshtein.java Client.java
    java Client resources/example.txt "Kelly Folk"
 ```
