package hamming

import "fmt"

// Distance calculates the Hamming difference between two DNA strands.
func Distance(a, b string) (int, error) {
	if len(a) != len(b) {
		return 0, fmt.Errorf("DNA strands length differes: %d != %d", len(a), len(b))
	}

	counter := 0
	aRunes := []rune(a)
	for pos, char := range b {
		if aRunes[pos] != char {
			counter++
		}
	}

	return counter, nil
}
