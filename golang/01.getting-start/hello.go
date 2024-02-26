package main

// https://go.dev/doc/tutorial/getting-started

import (
	"fmt"

	"rsc.io/quote"
) // 외부 모듈 호출추가

func main() {
	fmt.Println("Hello, World!")
	fmt.Println(quote.Go())
}
