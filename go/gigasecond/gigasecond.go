package gigasecond

import "time"

const GIGASECOND = 1e9 * time.Second

// Returns a moment when one lived for 1'000'000'000 seconds
func AddGigasecond(t time.Time) time.Time {
	return t.Add(time.Duration(GIGASECOND))
}
