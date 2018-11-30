/*
Assignment 6
Submitted By - Romi Padam (rkp170230)
Problem Statement -
Hash table implementation.
Hash function - Adding ASCII values for each character in a string.
Collision Resolution Strategy - Quadratic Probing.
*/

import java.math.BigInteger;

public class Hash {
    
    private static final double MAX_LOAD_FACTOR = 0.5;
    
    void addElements(String[] s, int hashTableSize) {
        
        String[] hashTable = new String[hashTableSize];
        
        int noOfElements = s.length;
        String word;
        int totalCollisions = 0;

        for (int i=0; i<noOfElements; i++) {
            word = s[i];
            totalCollisions += add(word, hashTableSize, hashTable);
                   
            //Keeping check on load factor - should not exceed 0.5
            if (i+1 > MAX_LOAD_FACTOR * hashTableSize) {
                System.out.println("Hash Table too full!");
                int newhashTableSize = getNextPrimeNumber(hashTableSize);
                
                System.out.println("Rehashing table values to new hash table with size "+ newhashTableSize + ".");
                System.out.println("-------------------------------------------------------");
                //Rehash all existing values in hashTable
                String[] temp = new String[newhashTableSize];
                totalCollisions += rehashHashTable(hashTable, temp);
                
                hashTableSize = newhashTableSize;
                hashTable = temp;
                System.out.println("-------------------------------------------------------");
                System.out.println("Rehashing completed.");
            }
        }
        
        //Printing Output
        System.out.println("Hash Table -" + "\nIndex\tValue");
        for (int i=0; i<hashTable.length; i++) {
            System.out.println(i+"\t"+hashTable[i]);
        }
        System.out.println("Total number of collisions - "+ totalCollisions);
    }
    
    int add (String word, int hashTableSize, String[] hashTable) {
        
        int collisions = 0;
                          
        //Hash function - Calculates index by adding ascii values of all characters in the string
        int key = getKey(word);
        int index = key % hashTableSize;
        System.out.println("\n"+ word + " will be placed at index "+ index + ".");
        
        //Collision Resolution using Quadratic Probing
        if (hashTable[index] != null){
            System.out.println("Collision Detected!");
            int[] results = quadraticProbing(index, hashTableSize, hashTable);
            index = results[0];
            collisions += results[1];   
            System.out.println(word + " will be placed at index "+ index + ".");
        }
            
        //Inserting element in Hash table
        hashTable[index] = word;
        return collisions;
    }
    
    
    int getKey(String word) {
        char c;
        int ascii;
        int key = 0;
        
        for (int i=0; i<word.length(); i++) {
            c = word.charAt(i);
            ascii = (int)c;
            key += ascii;
        }
        return key;
    }
    
    int[] quadraticProbing(int index, int hashTableSize, String[] hashTable) {
        int probeNumber = 0;
        int probe = index;
        while (hashTable[probe] != null) {
            probeNumber++;
            probe = (index + (probeNumber * probeNumber)) % hashTableSize;
        }
        int[] returnValues = new int[2];
        returnValues[0] = probe;
        returnValues[1] = probeNumber;
        return returnValues;
    }
    
    int getNextPrimeNumber(int hashTableSize) {
        BigInteger b = new BigInteger(String.valueOf(hashTableSize)); 
        return Integer.parseInt(b.nextProbablePrime().toString()); 
    }
    
    int rehashHashTable(String[] oldHashTable, String[] newHashTable){
        int collision = 0;
        for (String word : oldHashTable) {
            if (word != null) {
                collision += add(word, newHashTable.length, newHashTable);
            }
        }
        return collision;
    }
    
    public static void main(String[] args) {
        
        Hash hash = new Hash();
        
        int hashTableSize = 31;
        String[] s = {"Apple", "Peach", "93 45", "Orange", "878374", "1257", "Coconut", "Lemons", "Papayas1",
                      "Fig", "Plums ", "Mangoes", "99999999", "Avocado", "Cherries", "121212", "987", 
                      "Bananas", "Pears", "Apricots"};
        
        hash.addElements(s, hashTableSize);
    }   
}
