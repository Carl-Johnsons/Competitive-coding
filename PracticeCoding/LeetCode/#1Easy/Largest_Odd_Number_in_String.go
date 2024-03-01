package main

import "C"

func largestOddNumber(num string) string {
	runeSlice := []rune(num)
	for i := len(runeSlice) - 1; i >= 0; i-- {
		if int(runeSlice[i])%2 == 1 {
			return num[0 : i+1]
		}
	}
	return ""
}
