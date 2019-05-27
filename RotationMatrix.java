package test;

public class RotationMatrix {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] arr1 = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		int[][] arr2 = new int[10][10];
		int count = 1;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				arr2[i][j] = count++;
			}
		}
		// rotateMatrix testCase
		printMatrix(arr);
		printMatrix(rotateMatrix(arr));
		printMatrix(arr1);
		printMatrix(rotateMatrix(arr1));
		printMatrix(arr2);
		printMatrix(rotateMatrix(arr2));

		// rotateMatrix1 testCase
		printMatrix(arr);
		printMatrix(rotateMatrix1(arr));
		printMatrix(arr1);
		printMatrix(rotateMatrix1(arr1));
		printMatrix(arr2);
		printMatrix(rotateMatrix1(arr2));
	}

	public static int[][] rotateMatrix(int[][] arr) {
		int[][] result = new int[arr.length][arr[0].length];
		int k = arr.length - 1;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (i + j <= k)
					result[i - 1][j] = arr[i][j];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j <= i; j++) {
				if (i + j > k)
					result[i][j - 1] = arr[i][j];
			}
		}
		for (int j = 0; j < arr.length; j++) {
			for (int i = 0; i < j; i++) {
				if (i + j >= k)
					result[i + 1][j] = arr[i][j];
			}
			for (int i = 0; i <= j; i++) {
				if (i + j < k)
					result[i][j + 1] = arr[i][j];
			}
		}
		int m = arr.length / 2;
		if (arr.length % 2 == 1)
			result[m][m] = arr[m][m];
		return result;
	}

	public static int[][] rotateMatrix1(int[][] arr) {
		int[][] result = new int[arr.length][arr[0].length];
		int k = arr.length - 1;
		if (arr.length % 2 == 0) {
			for (int i = 1; i < arr.length; i++) {
				for (int j = 0; j < i; j++) {
					if (i + j <= k && j % 2 == 0)
						result[i - 1][j] = arr[i][j];
					if (i + j >= k && i % 2 == 0)
						result[i][j + 1] = arr[i][j];
				}
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 1; j <= i; j++) {
					if (i + j > k && i % 2 == 1)
						result[i][j - 1] = arr[i][j];
					if (i + j < k && j % 2 == 1)
						result[i + 1][j] = arr[i][j];
				}
			}
			for (int j = 0; j < arr.length; j++) {
				for (int i = 0; i < j; i++) {
					if (i + j >= k && j % 2 == 1)
						result[i + 1][j] = arr[i][j];
					if (i + j <= k && i % 2 == 1)
						result[i][j - 1] = arr[i][j];
				}
				for (int i = 0; i <= j; i++) {
					if (i + j < k && i % 2 == 0)
						result[i][j + 1] = arr[i][j];
					if (i + j > k && j % 2 == 0)
						result[i - 1][j] = arr[i][j];
				}
			}
		} else {
			for (int i = 1; i < arr.length; i++) {
				for (int j = 0; j < i; j++) {
					if (i + j <= k && j % 2 == 0)
						result[i - 1][j] = arr[i][j];
					if (i + j >= k && i % 2 == 1)
						result[i][j + 1] = arr[i][j];
				}
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 1; j <= i; j++) {
					if (i + j > k && i % 2 == 0)
						result[i][j - 1] = arr[i][j];
					if (i + j < k && j % 2 == 1)
						result[i + 1][j] = arr[i][j];
				}
			}
			for (int j = 0; j < arr.length; j++) {
				for (int i = 0; i < j; i++) {
					if (i + j >= k && j % 2 == 0)
						result[i + 1][j] = arr[i][j];
					if (i + j <= k && i % 2 == 1)
						result[i][j - 1] = arr[i][j];
				}
				for (int i = 0; i <= j; i++) {
					if (i + j < k && i % 2 == 0)
						result[i][j + 1] = arr[i][j];
					if (i + j > k && j % 2 == 1)
						result[i - 1][j] = arr[i][j];
				}
			}
			int m = arr.length / 2;
			result[m][m] = arr[m][m];
		}
		return result;
	}

	public static void printMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (j > 0) {
					System.out.print(" ");
					if (arr[i][j] < 10)
						System.out.print(" ");
				} else if (j == 0 && arr[i][j] < 10)
					System.out.print(" ");
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
