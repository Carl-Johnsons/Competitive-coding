package main

import (
	"C"
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
	"strings"
)

func solve() {
	scanner := bufio.NewScanner(os.Stdin)
	caseCnt := 0

	for scanner.Scan() {
		line := scanner.Text()
		if line == "" {
			break
		}

		min := math.MaxInt32
		max := math.MinInt32
		numsString := strings.Fields(line)
		for i, numStr := range numsString {
			if i == 0 {
				continue
			}
			x, _ := strconv.Atoi(numStr)

			if min > x {
				min = x
			}
			if max < x {
				max = x
			}
		}

		fmt.Printf("Case %d: %d %d %d\n", caseCnt+1, min, max, max-min)
		caseCnt++
	}
}
