package com.shaangroups.practice.codingtests;

public class Holidu {

	static boolean function2(int[] a) {
		// boolean flag = false;
		int[] b = a.clone();
		for (int t : b) {
			System.out.print(t + " ");
		}
		System.out.println();
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			temp = a[i];
			int j = temp + a[temp];
			System.out.println(j + ": j");
		}
		System.out.println();
		for (int t : b) {
			System.out.print(t + " ");
		}
		System.out.println();
		return false;
	}
	
	public static void main(String[] args) {
		int[] a = {2, 1, 1};
		
		System.out.println(function2(a));
	}
}

/*-

// write a function that returns the sum of the first n prime numbers



int function(int n) {
int sum = 0, counter = 0;
boolean flag = true;

for(int i = 1; i <= SOMELARGENUMBER; i++) {
	flag = true;
	for(int j=2; j<i; j++) {
		if (i%j ==0) {
			flag = false;
break;
		}
	}

	If (flag) {
		sum = sum + i;
counter++;
	}

If (counter == n)
	return sum;
}

}




A = [2, 3, -1, 1, 3]
A = [2, 1, -1, 1, 3]
B = [2, 1, -1, 1, 3]
B = [2, 1, -1, 1, 3]
Temp = -1;

B = [2, 0, 0, 1, 3]

A[0] -> a[2]
A[2] -> a[1]
A[1] -> a[4]

// write a function which takes an array of ints and calculates whether a pawn that starts at position a[0] will jump out (true) or will end in a loop (false)

function() {
   Int[] b = a.clone();
Temp = a[0];	
for(int i =0 ; i <a.length; i++) {
	Temp2 = B[a[i]];
	
}
   B[i] = b[i] + (b[i] + b[j]) 
}


*/