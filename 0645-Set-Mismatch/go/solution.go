package main

import "fmt"

func main() {
	arr := []int{1,2,2,4}
	fmt.Println(findErrorNums(arr))
}

func findErrorNums(nums []int) []int {
    n := len(nums)
    f := make([]int, n+1)
    for _, v := range(nums) {
        f[v]++
    }
    
    res := make([]int, 2)
    for k, v := range(f) {
        if v == 2 {
            res[0] = k
        } else if v == 0 {
            res[1] = k
        }
    }
    return res
}