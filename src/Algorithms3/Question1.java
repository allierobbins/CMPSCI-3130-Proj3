package Algorithms3; 
import java.util.Random;
import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		//Question 1 for Programming Assignment 3
		
		System.out.println("Start of Question 1.");
		
		int p = 0, 
			k = 0, 
			collisions = 0,
			index = 0;									//variables for hash tables 
		
		int prime[] = {7, 91, 13, 5, 73};				//prime array
		
		int key[] = new int[25];
		
		Random rand = new Random();
		
		for (int i = 0; i < 25; i++)					//fill key array
			key[i] = rand.nextInt((10000 - 1) + 1);
		
		for (int i = 0; i < 5; i++) {					//for each prime value
			p = prime[i];								//set p equal to prime #
			int hashTable[] = new int[p];				//create hachtable of size p
			
			for (int j = 0; j < 25; j++) {				//for each value of key
				k = key[j];								//set k equal to key number
				index = k % p;
				
				if (hashTable[index] == 0)				//look for empty space by hash function
					hashTable[index] = k;				//if slot is empty = place k there
				else
					collisions++;						//else there is a collision and original k stays 
			}
			
			System.out.println("Hash function with p:" + p + " had " + collisions + " collisions.");
			collisions = 0;								//reset collision count for next hashtable
		}
		
		System.out.println("End of Question 1.");
}
}
