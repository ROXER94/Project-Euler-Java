package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem096 {

	/**
	 * @param board
	 * @param candidateBoard
	 * @return the solution to a Sudoku board
	 */
	static int[][] getSudokuSolution(int[][] board, List<List<Integer>> candidateBoard) {
		if (isSudokuComplete(board))
			return board;
		List<Integer> firstAvailableCell = getSudokuFirstAvailableCell(board);
		int r = firstAvailableCell.get(0);
		int c = firstAvailableCell.get(1);
		for (int i : candidateBoard.get(9 * r + c)) {
			board[r][c] = i;
			if (isSudokuValid(board)) {
				int[][] currentBoard = getSudokuSolution(board, candidateBoard);
				if (isSudokuComplete(board))
					return currentBoard;
			}
			board[r][c] = 0;
		}
		return board;
	}

	/**
	 * @param board
	 * @return True if a Sudoku board is complete
	 */
	static boolean isSudokuComplete(int[][] board) {
		for (int r = 0; r < board.length; r++)
			for (int c = 0; c < board[0].length; c++)
				if (board[r][c] == 0)
					return false;
		return true;
	}

	/**
	 * @param board
	 * @return the first available cell in a Sudoku board
	 * @throws IllegalArgumentException
	 */
	static List<Integer> getSudokuFirstAvailableCell(int[][] board) throws IllegalArgumentException {
		for (int r = 0; r < board.length; r++)
			for (int c = 0; c < board[0].length; c++)
				if (board[r][c] == 0)
					return Functions.getTuple(r, c);
		throw new IllegalArgumentException("Sudoku board has no available cells");
	}

	/**
	 * @param board
	 * @return True if a Sudoku board is valid
	 */
	static boolean isSudokuValid(int[][] board) {
		return isSudokuRowsValid(board) && isSudokuColumnsValid(board) && isSudokuBlocksValid(board);
	}

	/**
	 * @param board
	 * @return True if a Sudoku board contains valid rows
	 */
	static boolean isSudokuRowsValid(int[][] board) {
		for (int r = 0; r < board.length; r++)
			if (Functions.hasDuplicates(Functions.getArrayRow(board, r), new int[] { 0 }))
				return false;
		return true;
	}

	/**
	 * @param board
	 * @return True if a Sudoku board contains valid columns
	 */
	static boolean isSudokuColumnsValid(int[][] board) {
		for (int c = 0; c < board[0].length; c++)
			if (Functions.hasDuplicates(Functions.getArrayColumn(board, c), new int[] { 0 }))
				return false;
		return true;
	}

	/**
	 * @param board
	 * @return True if a Sudoku board contains valid blocks
	 */
	static boolean isSudokuBlocksValid(int[][] board) {
		for (int r = 0; r < 9; r += 3)
			for (int c = 0; c < 9; c += 3) {
				List<Integer> block = new ArrayList<Integer>();
				for (int a = 0; a < 3; a++)
					for (int b = 0; b < 3; b++)
						block.add(board[r + a][c + b]);
				if (Functions.hasDuplicates(block.stream().mapToInt(i -> i).toArray(), new int[] { 0 }))
					return false;
			}
		return true;
	}

	/**
	 * @param board
	 * @param candidateBoard
	 */
	static void updateSudokuBoards(int[][] board, List<List<Integer>> candidateBoard) {
		for (int r = 0; r < board.length; r++)
			for (int c = 0; c < board[0].length; c++)
				if (board[r][c] != 0) {
					removeSudokuCandidateRow(board[r][c], r, candidateBoard);
					removeSudokuCandidateColumn(board[r][c], c, candidateBoard);
					removeSudokuCandidateBlock(board[r][c], r, c, candidateBoard);
					candidateBoard.set(9 * r + c, new ArrayList<Integer>());
				}
		for (int r = 0; r < 9; r++)
			for (int c = 0; c < 9; c++)
				if (candidateBoard.get(9 * r + c).size() == 1) {
					board[r][c] = candidateBoard.get(9 * r + c).get(0);
					candidateBoard.set(9 * r + c, new ArrayList<Integer>());
					updateSudokuBoards(board, candidateBoard);
				}
	}

	/**
	 * @param number
	 * @param rowIndex
	 * @param candidateBoard
	 */
	static void removeSudokuCandidateRow(int number, int rowIndex, List<List<Integer>> candidateBoard) {
		for (int i = 0; i < 9; i++)
			if (candidateBoard.get(9 * rowIndex + i).contains(number))
				candidateBoard.get(9 * rowIndex + i).remove(new Integer(number));
	}

	/**
	 * @param number
	 * @param columnIndex
	 * @param candidateBoard
	 */
	static void removeSudokuCandidateColumn(int number, int columnIndex, List<List<Integer>> candidateBoard) {
		for (int i = 0; i < 9; i++)
			if (candidateBoard.get(9 * i + columnIndex).contains(number))
				candidateBoard.get(9 * i + columnIndex).remove(new Integer(number));
	}

	/**
	 * @param number
	 * @param rowIndex
	 * @param columnIndex
	 * @param candidateBoard
	 */
	static void removeSudokuCandidateBlock(int number, int rowIndex, int columnIndex, List<List<Integer>> candidateBoard) {
		int r = 0;
		int c = 0;
		while (rowIndex - 3 >= 0) {
			r += 3;
			rowIndex -= 3;
		}
		while (columnIndex - 3 >= 0) {
			c += 3;
			columnIndex -= 3;
		}
		for (int a = 0; a < 3; a++)
			for (int b = 0; b < 3; b++)
				if (candidateBoard.get(9 * (r + a) + c + b).contains(number))
					candidateBoard.get(9 * (r + a) + c + b).remove(new Integer(number));
	}

	/**
	 * @param sudoku
	 * @param sudokuFile
	 * @param sudokus
	 * @throws IOException
	 */
	static void readSudokuBoard(int[][] sudoku, BufferedReader sudokuFile, List<int[][]> sudokus) throws IOException {
		String line;
		for (int i = 0; (line = sudokuFile.readLine()) != null; i++) {
			if (i % 10 == 0) {
				sudoku = new int[9][9];
				sudokus.add(sudoku);
				continue;
			}
			int x = i % 10 - 1;
			for (int y = 0; y < line.length(); y++)
				sudoku[x][y] = line.toCharArray()[y] - '0';
		}
	}

	/**
	 * @param sudoku
	 */
	static void printSudoku(int[][] sudoku) {
		for (int r = 0; r < sudoku.length; r++)
			System.out.println(Arrays.toString(Functions.getArrayRow(sudoku, r)));
		System.out.println();
	}

	/**
	 * Calculates the sum of the 3-digit numbers found in the top left corner of each sudoku solution grid
	 */
	static void solution() {
		int ans = 0;
		List<int[][]> sudokus = new ArrayList<int[][]>();
		try (BufferedReader br = new BufferedReader(new FileReader("src/projecteuler/resources/p096_sudoku.txt"))) {
			readSudokuBoard(new int[9][9], br, sudokus);
			for (int[][] sudokuBoard : sudokus) {
				List<List<Integer>> candidateBoard = new ArrayList<List<Integer>>();
				for (int i = 0; i < 81; i++)
					candidateBoard.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
				updateSudokuBoards(sudokuBoard, candidateBoard);
				int[][] solution = getSudokuSolution(sudokuBoard, candidateBoard);
				// printSudoku(solution);
				ans += solution[0][0] * 100 + solution[0][1] * 10 + solution[0][2];
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(ans);
	}
}