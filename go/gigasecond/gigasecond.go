package gigasecond

import "time"

const GIGASECOND time.Duration = 1000000000 * time.Second

// Returns a moment whe one lived for 1'000'000'000 seconds
func AddGigasecond(t time.Time) time.Time {
	return t.Add(time.Duration(GIGASECOND))
}
