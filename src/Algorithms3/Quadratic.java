package Algorithms3;

import java.util.Random;

public class Quadratic {

	public static void main(String[] args) {

System.out.println("Start of Question 2 - Quadratic Probing.");
		
		int p = 0, 										//variables for hash tables
			k = 0, 
			collisions = 0,
			index = 0,
			offset = 1;
		
		int prime[] = {7, 91, 17, 5, 73};				//prime array
		
		int key[] = new int[25];
		
		Random rand = new Random();
		
		for (int i = 0; i < 25; i++)					//fill key array
			key[i] = rand.nextInt((10000 - 1) + 1);
		
		System.out.println("Starting hash table with Quadratic probing.");
		
		for (int i = 0; i < 5; i++) {					//for each prime value
			p = prime[i];								//set p equal to prime #
			int hashTable[] = new int[p];				//create hash table of size p
			
			for (int j = 0; j < 25; j++) {				//for each value of key
				k = key[j];								//set k equal to key number
				index = k % p;
				
				if (hashTable[index] == 0)				//look for empty space by hash function
					hashTable[index] = k;				//if slot is empty = place k there
				else {
					do {								//if slot is occupied
					 index += offset;					//increment index by offset
					 offset += 2;						//increase offset 
					 if (hashTable[index] == 0)	{		//look for empty space by hash function
							hashTable[index] = k;
					 		break;}
				} while (hashTable[index] != 0);		//keep going until k is assigned
							
					offset = 1;							//reset offset 
				}
			}
			
			System.out.println("QP: Hash function with p:" + p + " had " + collisions + " collisions.");
			collisions = 0;								//reset collision count for next hash table
		}
		
		System.out.println("End of Quadratic probing.");
		

	}

}

