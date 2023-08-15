## Matrix

## WhiteBoard
![Matrix](./matrix.png)

## Approach & Efficiency

The apporach taken is to make a nested loop and iterate through the 2d array 
then assign the value of the row column to the sum array then return the sum array after finishing the loops

## Big o
the time complexity can be expressed as O(n * m), where n and m are the dimensions of the matrix.

## Solution
code 
```java
public static int[] sumOfMatrix(int[][] matrix) {
        int [] sum = new int[matrix.length];
        for(int i =0; i<matrix.length;i++) {
            for(int j = 0 ; j< matrix[i].length;j++){
                sum[i] += matrix[i][j];
            }
        }
        return sum;
    }
```
Link -> [Code](./app/src/main/java/matrix/App.java)

Test
```java
@Test
    public void matrixWithEmptyRows_ReturnZeros() {
        int[][] matrix = {
                {},
                {},
                {}
        };

        int[] expectedSum = {0, 0, 0};
        int[] actualSum = App.sumOfMatrix(matrix);

        assertArrayEquals(expectedSum, actualSum);
    }
    @Test
    public void matrixWithDifferentColumnCounts_Return_WithSummation() {
        int[][] matrix = {
                {1, 2},
                {3, 4, 5},
                {6, 7, 8, 9}
        };

        int[] expectedSum = {3, 12, 30};
        int[] actualSum = App.sumOfMatrix(matrix);

        assertArrayEquals(expectedSum, actualSum);
    }
```
Link -> [Test](./app/src/test/java/matrix/AppTest.java)
## How to run the code
- clone the repo and cd into the matrix directory.
- on the terminal type gradle run to run the main program.
- to run the tests type gradlew test.