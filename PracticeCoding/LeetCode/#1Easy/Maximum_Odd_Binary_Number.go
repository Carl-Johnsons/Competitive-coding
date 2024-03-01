package main

import "C" // For telling this directory has the C file
import "strings"

func prependString(oldString string, addString string) string {
	var builder strings.Builder
	builder.WriteString(addString)
	builder.WriteString(oldString)
	return builder.String()
}
func maximumOddBinaryNumber(s string) string {
	var builder strings.Builder
	var hasOne = false
	for i := 0; i < len(s); i++ {
		if s[i:i+1] == "1" && !hasOne {
			hasOne = true
			continue
		}
		if s[i:i+1] == "1" {
			temp := builder.String()
			builder.Reset()
			builder.WriteString(prependString(temp, "1"))
		} else {
			builder.WriteString(s[i : i+1])
		}
	}
	if hasOne {
		builder.WriteString("1")
	}
	return builder.String()
}
