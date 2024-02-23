package main

import (
	"fmt"

	"rsc.io/quote"
) // 외부 모듈 호출추가

func main() {
	fmt.Println("Hello, World!")
	fmt.Println(quote.Go())
}
