package main

import (
	"C"
	"fmt"
)

func solve() {
	var (
		n         int
		row       int
		col       int
		isCorrect bool = true
	)
	fmt.Scanf("%d\n", &n)
	rows := make([]bool, n)
	cols := make([]bool, n)
	diagonal := make([]bool, 2*n-1)
	reverseDiagonal := make([]bool, 2*n-1)
	for i := 0; i < n; i++ {
		fmt.Scanf("%d", &row)
		fmt.Scanf("%d\n", &col)
		if rows[row] || cols[col] || diagonal[col-row+(n-1)] || reverseDiagonal[row+col] {
			isCorrect = false
		}
		rows[row] = true
		cols[col] = true
		diagonal[col-row+(n-1)] = true
		reverseDiagonal[row+col] = true
	}
	if isCorrect {
		fmt.Println("CORRECT")
	} else {
		fmt.Println("INCORRECT")
	}
}

func main() {
	solve()
}
