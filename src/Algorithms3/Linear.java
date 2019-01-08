package Algorithms3;

import java.util.Random;

public class Linear {

	public static void main(String[] args) {

System.out.println("Start of Question 2 - Linear Probing.");
		
		int p = 0, 										//variables for hash tables
			k = 0, 
			collisions = 0,
			index = 0;									 
		
		int prime[] = {7, 91, 17, 5, 73};				//prime array
		
		int key[] = new int[25];
		
		Random rand = new Random();
		
		for (int i = 0; i < 25; i++)					//fill key array
			key[i] = rand.nextInt((10000 - 1) + 1);
		
		System.out.println("Starting hash table with Linear probing.");
		
		for (int i = 0; i < 5; i++) {					//for each prime value
			p = prime[i];								//set p equal to prime #
			int hashTable[] = new int[p];				//create hash table of size p
			
			for (int j = 0; j < 25; j++) {				//for each value of key
				k = key[j];								//set k equal to key number
				index = k % p;
				
				if (hashTable[index] == 0)				//look for empty space by hash function
					hashTable[index] = k;				//if slot is empty = place k there
				else
					 for (int m = 0; m < p; m++) { 	//else increase h(k) by i to find empty space
						if (hashTable[index + i] == 0) {
							hashTable[index + i] = k;
							break;						//once found break loop
						} else if (hashTable[index + i] > p) {		//if index goes bigger then p size
							index = 0;								//reset index to 0
							if (hashTable[index] == 0) {			//continue checking
								hashTable[index] = k;
								break;				
							}
						}
							
					} 
				}
			
			System.out.println("LP: Hash function with p:" + p + " had " + collisions + " collisions.");
			collisions = 0;								//reset collision count for next hash table
		}
		
		System.out.println("End of Linear probing.");
		

	}

}
